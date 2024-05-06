package com.jsh.erp.service.supermarketFinance;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.*;
import com.jsh.erp.datasource.vo.SupermarketFinanceVo;
import com.jsh.erp.exception.BusinessRunTimeException;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.log.LogService;
import com.jsh.erp.service.supermarketFinanceExtend.SupermarketFinanceExtendService;
import com.jsh.erp.service.supermarketFinanceRelevancy.SupermarketFinanceRelevancyService;
import com.jsh.erp.service.supermarketSystemConfig.SupermarketSystemConfigService;
import com.jsh.erp.service.supermarketVerificationLogs.SupermarketVerificationLogsService;
import com.jsh.erp.service.user.UserService;
import com.jsh.erp.utils.StringUtil;
import com.jsh.erp.utils.Tools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SupermarketFinanceService {
    private Logger logger = LoggerFactory.getLogger(SupermarketFinanceService.class);
    @Resource
    private LogService logService;
    @Resource
    private SupermarketFinanceMapper supermarketFinanceMapper;
    @Resource
    private SupermarketFinanceMapperEx supermarketFinanceMapperEx;
    @Resource
    private UserService userService;
    @Resource
    private SupermarketFinanceExtendService supermarketFinanceExtendService;
    @Resource
    private SupermarketFinanceExtendMapper supermarketFinanceExtendMapper;
    @Resource
    private SupermarketFinanceRelevancyService supermarketFinanceRelevancyService;
    @Resource
    private SupermarketFinanceRelevancyMapper supermarketFinanceRelevancyMapper;
    @Resource
    private SupermarketSystemConfigService supermarketSystemConfigService;
    @Resource
    private SupermarketSystemConfigMapper supermarketSystemConfigMapper;
    @Resource
    private SupermarketVerificationLogsService supermarketVerificationLogsService;

    public SupermarketFinance selectOne(Long id) {
        SupermarketFinance result = null;
        try {
            result = supermarketFinanceMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    public List<?> search(Long id, Long aquaticTypeId, Long marketId, String beginTime, String endTime, String number, String status, String linkNumber, int offset, int rows) {

        String[] statusArray = StringUtil.isNotEmpty(status) ? status.split(",") : null;
        beginTime = Tools.parseDayToTime(beginTime, BusinessConstants.DAY_FIRST_TIME);
        endTime = Tools.parseDayToTime(endTime, BusinessConstants.DAY_LAST_TIME);
        List<SupermarketFinanceVo> list = supermarketFinanceMapperEx.selectSupermarketFinance(id, aquaticTypeId, marketId, beginTime, endTime, number, statusArray,
                linkNumber, offset, rows);

        JSONArray sfList = new JSONArray();
        list.forEach(sf -> {
            JSONObject supermarketFinance = new JSONObject();

            supermarketFinance.put("id", sf.getId());
            supermarketFinance.put("number", sf.getNumber());
            supermarketFinance.put("status", sf.getStatus());
            supermarketFinance.put("remark", sf.getRemark());
            supermarketFinance.put("comment", sf.getComment());
            supermarketFinance.put("createTime", sf.getCreateTime());
            supermarketFinance.put("createdName", sf.getCreatedName());
            supermarketFinance.put("verifierTime", sf.getVerifierTime());
            supermarketFinance.put("verifierName", sf.getVerifierName());
            supermarketFinance.put("market", sf.getMarket());
            supermarketFinance.put("aquaticType", sf.getAquaticType());
            supermarketFinance.put("priceTotal", sf.getPriceTotal());
            supermarketFinance.put("payDate", sf.getPayDate());
            supermarketFinance.put("payStatus", sf.getPayStatus());

            //获取关联订单
            SupermarketFinanceRelevancyExample sfrExample = new SupermarketFinanceRelevancyExample();
            sfrExample.createCriteria().andSupermarketFinanceIdEqualTo(sf.getId()).
                    andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
            List<SupermarketFinanceRelevancy> sfr = supermarketFinanceRelevancyMapper.selectByExample(sfrExample);
            supermarketFinance.put("sfr", sfr);
            sfList.add(supermarketFinance);
        });
        return sfList;
    }

    public Long counts(Long id, Long aquaticTypeId, Long marketId, String beginTime, String endTime, String number, String status, String linkNumber) {
        Long list = null;
        String[] statusArray = StringUtil.isNotEmpty(status) ? status.split(",") : null;
        beginTime = Tools.parseDayToTime(beginTime, BusinessConstants.DAY_FIRST_TIME);
        endTime = Tools.parseDayToTime(endTime, BusinessConstants.DAY_LAST_TIME);

        try {
            list = supermarketFinanceMapperEx.countSupermarketFinance(id, aquaticTypeId, marketId, beginTime, endTime, number, statusArray, linkNumber);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public Object addSupermarketFinanceAndDetail(SupermarketFinanceVo4Body body, HttpServletRequest request) throws Exception {
        SupermarketFinance supermarketFinance = JSONObject.parseObject(body.getInfo(), SupermarketFinance.class);
        Long userId = userService.getCurrentUser().getId();

        //校验单号是否重复
        if (checkIsNumberNoExist(0L, supermarketFinance.getNumber())) {
            throw new BusinessRunTimeException(ExceptionConstants.NUMBER_IS_EXIST_CODE,
                    String.format(ExceptionConstants.NUMBER_IS_EXIST_MSG));
        }

        //检验关联订单是否被关联
        List<SupermarketFinanceRelevancy> sfrList = body.getSrrList();
        List<Long> soIds = sfrList.stream().map(SupermarketFinanceRelevancy::getSupermarketOrderId).
                collect(Collectors.toList());
        SupermarketFinanceRelevancyExample example = new SupermarketFinanceRelevancyExample();
        example.createCriteria().andSupermarketOrderIdIn(soIds).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<SupermarketFinanceRelevancy> sfr = supermarketFinanceRelevancyMapper.selectByExample(example);
        if (sfr.size() > 0) {
            throw new BusinessRunTimeException(ExceptionConstants.SUPERMARKET_FINANCE_HAS_ORDER_CODE,
                    String.format(ExceptionConstants.SUPERMARKET_FINANCE_HAS_ORDER_MSG));
        }

        Date date = new Date();

        supermarketFinance.setCreator(userId);
        supermarketFinance.setCreateTime(date);
        supermarketFinance.setUpdater(userId);
        supermarketFinance.setUpdateTime(date);
        if (StringUtil.isEmpty(supermarketFinance.getStatus())) {
            supermarketFinance.setStatus(BusinessConstants.BILLS_STATUS_UN_AUDIT);
        }
        supermarketFinanceMapper.insertSelective(supermarketFinance);

        //根据编号查询id
        Long sfIds = supermarketFinanceMapperEx.selectIdByNumber(supermarketFinance.getNumber());

        //如果状态为提交审核，记录流程
        if (BusinessConstants.BILLS_STATUS_UN_AUDIT.equals(supermarketFinance.getStatus())) {
            for (SupermarketFinanceRelevancy supermarketFinanceRelevancy : sfrList) {
                SupermarketVerificationLogs sfl = new SupermarketVerificationLogs();
                sfl.setTitle("付款申请");
                sfl.setOrderId(supermarketFinanceRelevancy.getSupermarketOrderId());
                sfl.setSupermarketFinanceId(sfIds);
                sfl.setNumber(supermarketFinance.getNumber());
                sfl.setStatus(supermarketFinance.getStatus());
                sfl.setTime(date);
                sfl.setUserId(userId);
                supermarketVerificationLogsService.saveVerificationLogs(sfl, request);
            }
        }
        //更新编号数值
        SupermarketSystemConfig config = supermarketSystemConfigService.getCurrentConfig(BusinessConstants.SUPERMARKET_FINANCE_NUMBER_SEQ);
        Integer currentValue = config.getCurrentValue();
        config.setCurrentValue(currentValue + 1); //编号+1
        supermarketSystemConfigMapper.updateByPrimaryKeySelective(config);
        //根据编号查询id
        Long sfId = supermarketFinanceMapperEx.selectIdByNumber(supermarketFinance.getNumber());

        String rows = body.getRows();
        if (rows != null) {//处理子数据
            supermarketFinanceExtendService.saveFinanceExtend(rows, sfId, request);
        }
        if (sfrList.size() > 0) {//处理关联编号
            supermarketFinanceRelevancyService.saveFinanceRelevancy(sfId, sfrList, body.getDeleteIds());
        }
        logService.insertLog("商超财务",
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ADD).append(supermarketFinance.getId()).toString(), request);

        return ExceptionConstants.standardSuccess();
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public Object updateSupermarketFinanceAndDetail(SupermarketFinanceVo4Body body, HttpServletRequest request) throws Exception {
        SupermarketFinance supermarketFinance = JSONObject.parseObject(body.getInfo(), SupermarketFinance.class);
        Long sfId = supermarketFinance.getId();
        //校验单号是否重复
        if (checkIsNumberNoExist(supermarketFinance.getId(), supermarketFinance.getNumber())) {
            throw new BusinessRunTimeException(ExceptionConstants.NUMBER_IS_EXIST_CODE,
                    String.format(ExceptionConstants.NUMBER_IS_EXIST_MSG));
        }

        //检验关联订单是否被关联
        List<SupermarketFinanceRelevancy> sfrList = body.getSrrList();
        List<Long> soIds = sfrList.stream().map(SupermarketFinanceRelevancy::getSupermarketOrderId).
                collect(Collectors.toList());
        SupermarketFinanceRelevancyExample example = new SupermarketFinanceRelevancyExample();
        example.createCriteria().andSupermarketOrderIdIn(soIds).andSupermarketFinanceIdNotEqualTo(sfId)
                .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<SupermarketFinanceRelevancy> sfr = supermarketFinanceRelevancyMapper.selectByExample(example);
        if (sfr.size() > 0) {
            throw new BusinessRunTimeException(ExceptionConstants.SUPERMARKET_FINANCE_HAS_ORDER_CODE,
                    String.format(ExceptionConstants.SUPERMARKET_FINANCE_HAS_ORDER_MSG));
        }

        //校验审核状态，如何不是未审核或者驳回则提示
        String status = selectOne(supermarketFinance.getId()).getStatus();
        if (BusinessConstants.BILLS_STATUS_AUDIT.equals(status) || BusinessConstants.BILLS_STATUS_UNDER_REVIEW.equals(status)) {
            throw new BusinessRunTimeException(ExceptionConstants.SUPERMARKET_ORDER_CANNOT_EDIT_CODE,
                    String.format(ExceptionConstants.SUPERMARKET_ORDER_CANNOT_EDIT_MSG));
        }
        Date date = new Date();
        Long userId = userService.getCurrentUser().getId();

        supermarketFinance.setUpdater(userId);
        supermarketFinance.setUpdateTime(date);
        if (StringUtil.isEmpty(supermarketFinance.getStatus())) {
            supermarketFinance.setStatus(BusinessConstants.BILLS_STATUS_UN_AUDIT);
        }
        supermarketFinanceMapper.updateByPrimaryKey(supermarketFinance);

        //如果状态为提交审核，记录流程
        if (BusinessConstants.BILLS_STATUS_UN_AUDIT.equals(supermarketFinance.getStatus())) {
            //如果有更换的关联订单，则需要删除流程记录
            supermarketVerificationLogsService.batchDeleteBySfIds(sfId.toString());
            for (SupermarketFinanceRelevancy supermarketFinanceRelevancy : sfrList) {
                SupermarketVerificationLogs sfl = new SupermarketVerificationLogs();
                sfl.setTitle("付款申请");
                sfl.setOrderId(supermarketFinanceRelevancy.getSupermarketOrderId());
                sfl.setSupermarketFinanceId(sfId);
                sfl.setNumber(supermarketFinance.getNumber());
                sfl.setStatus(supermarketFinance.getStatus());
                sfl.setTime(date);
                sfl.setUserId(userId);
                supermarketVerificationLogsService.saveVerificationLogs(sfl, request);
            }
        }

        String rows = body.getRows();
        if (rows != null) {//处理子数据
            supermarketFinanceExtendService.saveFinanceExtend(rows, sfId, request);
        }
        if (sfrList.size() > 0) {//处理关联编号
            supermarketFinanceRelevancyService.saveFinanceRelevancy(sfId, sfrList, body.getDeleteIds());
        }
        logService.insertLog("商超订单",
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(supermarketFinance.getId()).toString(), request);

        return ExceptionConstants.standardSuccess();
    }

    private boolean checkIsNumberNoExist(Long id, String number) {
        SupermarketFinanceExample example = new SupermarketFinanceExample();
        example.createCriteria().andIdNotEqualTo(id).andNumberEqualTo(number).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<SupermarketFinance> list = null;
        try {
            list = supermarketFinanceMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list != null && !list.isEmpty();
    }

    public int delete(Long id, HttpServletRequest request) throws Exception {
        return batchDeleteByIds(id.toString());
    }

    public int batchDelete(String ids, HttpServletRequest request) throws Exception {
        return batchDeleteByIds(ids);
    }

    /**
     * 批量删除接口
     *
     * @param ids
     * @return
     * @throws Exception
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteByIds(String ids) throws Exception {
        String[] idArray = ids.split(",");
        User userInfo = userService.getCurrentUser();
        //记录日志
        StringBuffer sb = new StringBuffer();
        sb.append(BusinessConstants.LOG_OPERATION_TYPE_DELETE);

        List<SupermarketFinance> list = getSupermarketFinanceByIds(ids);
        for (SupermarketFinance sf : list) {
            sb.append("[").append(sf.getId()).append("]");
            // 只有状态为未审核、驳回、草稿的单据才能被删除
            String sfStatus = sf.getStatus();
            if (!(BusinessConstants.BILLS_STATUS_UN_AUDIT.equals(sfStatus) ||
                    BusinessConstants.BILLS_STATUS_REJECT.equals(sfStatus) ||
                    BusinessConstants.BILLS_STATUS_DRAFT.equals(sfStatus))) {
                throw new BusinessRunTimeException(ExceptionConstants.DEPOT_HEAD_UN_AUDIT_DELETE_FAILED_CODE,
                        String.format(ExceptionConstants.DEPOT_HEAD_UN_AUDIT_DELETE_FAILED_MSG));
            }
        }
        int result = 0;
        try {
            result = supermarketFinanceMapperEx.batchDeleteByIds(new Date(), userInfo == null ? null : userInfo.getId(), idArray);
            //删除商超财务关联表信息
            supermarketFinanceRelevancyService.batchDeleteBySfIds(idArray);
            //商超审核纪录表信息
            supermarketVerificationLogsService.batchDeleteBySfIds(ids);
            logService.insertLog("商超财务", sb.toString(),
                    ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    private List<SupermarketFinance> getSupermarketFinanceByIds(String ids) {
        List<Long> idList = StringUtil.strToLongList(ids);
        List<SupermarketFinance> list = null;
        SupermarketFinanceExample example = new SupermarketFinanceExample();
        example.createCriteria().andIdIn(idList);
        try {
            list = supermarketFinanceMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchSetStatus(String status, Long id, String comment, HttpServletRequest request) throws Exception {
        // 获取当前用户信息
        Long userId = userService.getCurrentUser().getId();
        // 检查修改的审核状态是否符合逻辑
        Map<String, List<String>> statusRules = getStatusRules();
        SupermarketFinance supermarketFinance = supermarketFinanceMapper.selectByPrimaryKey(id);
        String sfStatus = supermarketFinance.getStatus();
        if (!(statusRules.containsKey(status) && statusRules.get(status).contains(sfStatus))) {
            // 如果状态不符合规则，抛出异常
            throw new BusinessRunTimeException(ExceptionConstants.UPDATE_STATUS_FAILED_CODE,
                    ExceptionConstants.UPDATE_STATUS_FAILED_MSG);
        }
        SupermarketFinance sf = new SupermarketFinance();
        Date date = new Date();
        sf.setId(id);
        sf.setStatus(status);
        sf.setComment(comment);
        sf.setVerifier(userId);
        sf.setVerifierTime(date);

        int result = supermarketFinanceMapper.updateByPrimaryKeySelective(sf);

        //如果状态为审核或者驳回，记录流程
        SupermarketFinanceRelevancyExample example = new SupermarketFinanceRelevancyExample();
        example.createCriteria().andSupermarketFinanceIdEqualTo(id).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<SupermarketFinanceRelevancy> sfrList = supermarketFinanceRelevancyMapper.selectByExample(example);
        if (BusinessConstants.BILLS_STATUS_AUDIT.equals(status) ||
                BusinessConstants.BILLS_STATUS_REJECT.equals(status)) {
            for (SupermarketFinanceRelevancy supermarketFinanceRelevancy : sfrList) {
                SupermarketVerificationLogs sfl = new SupermarketVerificationLogs();
                sfl.setTitle("付款审核");
                sfl.setOrderId(supermarketFinanceRelevancy.getSupermarketOrderId());
                sfl.setSupermarketFinanceId(supermarketFinance.getId());
                sfl.setNumber(supermarketFinance.getNumber());
                sfl.setStatus(status);
                sfl.setComment(comment);
                sfl.setTime(date);
                sfl.setUserId(userId);
                supermarketVerificationLogsService.saveVerificationLogs(sfl, request);
            }
        }

        // 记录日志
        logService.insertLog("商超财务", new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ENABLED).toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        return result;
    }

    // 获取状态规则
    private Map<String, List<String>> getStatusRules() {
        Map<String, List<String>> statusRules = new HashMap<>();
        statusRules.put("0", Arrays.asList("0", "1", "5", "6", "9"));
        statusRules.put("2", Arrays.asList("0", "9"));
        statusRules.put("1", Arrays.asList("0", "2", "9"));
        statusRules.put("5", Arrays.asList("0", "9"));
        statusRules.put("6", Arrays.asList("0", "6"));
        statusRules.put("9", Arrays.asList("0"));
        return statusRules;
    }

    public JSONObject findByCondition(Long id) {
        JSONObject supermarketFinance = new JSONObject();
        SupermarketFinanceVo sf = supermarketFinanceMapperEx.selectSupermarketFinanceById(id);
        supermarketFinance.put("id", sf.getId());
        supermarketFinance.put("number", sf.getNumber());
        supermarketFinance.put("status", sf.getStatus());
        supermarketFinance.put("remark", sf.getRemark());
        supermarketFinance.put("comment", sf.getComment());
        supermarketFinance.put("marketId", sf.getMarketId());
        supermarketFinance.put("aquaticTypeId", sf.getAquaticTypeId());
        supermarketFinance.put("createTime", sf.getCreateTime());
        supermarketFinance.put("createdName", sf.getCreatedName());
        supermarketFinance.put("verifierTime", sf.getVerifierTime());
        supermarketFinance.put("verifierName", sf.getVerifierName());
        supermarketFinance.put("market", sf.getMarket());
        supermarketFinance.put("aquaticType", sf.getAquaticType());
        supermarketFinance.put("priceTotal", sf.getPriceTotal());
        supermarketFinance.put("payDate", sf.getPayDate());
        supermarketFinance.put("payStatus", sf.getPayStatus());
        supermarketFinance.put("creator", sf.getCreator());
        supermarketFinance.put("verifier", sf.getVerifier());
        supermarketFinance.put("deleteFlag", sf.getDeleteFlag());
        supermarketFinance.put("tenantId", sf.getTenantId());
        supermarketFinance.put("uploader", sf.getUploader());
        supermarketFinance.put("uploadTime", sf.getUploadTime());
        supermarketFinance.put("paymentStatus", sf.getPaymentStatus());
        supermarketFinance.put("paymentDate", sf.getPaymentDate());
        supermarketFinance.put("paymenter", sf.getPaymenter());

        // 获取订单详情
        SupermarketFinanceExtendExample sfeExample = new SupermarketFinanceExtendExample();
        sfeExample.createCriteria().andSupermarketFinanceIdEqualTo(sf.getId()).andDeleteFlagEqualTo(BusinessConstants.DELETE_FLAG_EXISTS);
        List<SupermarketFinanceExtend> sfe = supermarketFinanceExtendMapper.selectByExample(sfeExample);

        //获取关联订单
        SupermarketFinanceRelevancyExample sfrExample = new SupermarketFinanceRelevancyExample();
        sfrExample.createCriteria().andSupermarketFinanceIdEqualTo(sf.getId()).
                andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<SupermarketFinanceRelevancy> sfr = supermarketFinanceRelevancyMapper.selectByExample(sfrExample);

        supermarketFinance.put("sfe", sfe);
        supermarketFinance.put("sfr", sfr);
        return supermarketFinance;
    }
}