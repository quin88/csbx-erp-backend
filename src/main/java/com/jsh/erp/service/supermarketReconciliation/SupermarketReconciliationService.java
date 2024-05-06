package com.jsh.erp.service.supermarketReconciliation;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.*;
import com.jsh.erp.datasource.vo.SupermarketReconciliationVo;
import com.jsh.erp.exception.BusinessRunTimeException;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.log.LogService;
import com.jsh.erp.service.supermarketReconciliationAquaticType.SupermarketReconciliationAquaticTypeService;
import com.jsh.erp.service.supermarketReconciliationExtend.SupermarketReconciliationExtendService;
import com.jsh.erp.service.supermarketReconciliationRelevancy.SupermarketReconciliationRelevancyService;
import com.jsh.erp.service.supermarketSystemConfig.SupermarketSystemConfigService;
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

@Service
public class SupermarketReconciliationService {
    private Logger logger = LoggerFactory.getLogger(SupermarketReconciliationService.class);
    @Resource
    private LogService logService;
    @Resource
    private SupermarketReconciliationMapper supermarketReconciliationMapper;
    @Resource
    private SupermarketReconciliationMapperEx supermarketReconciliationMapperEx;
    @Resource
    private UserService userService;
    @Resource
    private SupermarketReconciliationExtendService supermarketReconciliationExtendService;
    @Resource
    private SupermarketReconciliationRelevancyService srrService;
    @Resource
    private SupermarketReconciliationAquaticTypeService satService;
    @Resource
    private SupermarketReconciliationExtendMapper supermarketReconciliationExtendMapper;
    @Resource
    private SupermarketReconciliationRelevancyMapper srrMapper;
    @Resource
    private SupermarketReconciliationAquaticTypeMapper satMapper;
    @Resource
    private SupermarketSystemConfigService supermarketSystemConfigService;
    @Resource
    private SupermarketSystemConfigMapper supermarketSystemConfigMapper;

    public SupermarketReconciliation selectOne(Long id) {
        SupermarketReconciliation result = null;
        try {
            result = supermarketReconciliationMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    public List<?> search(Long id, String atId, String beginTime, String endTime, String number, String status, String reconciliationBeginTime, String reconciliationEndTime, int offset, int rows) {

        String[] statusArray = StringUtil.isNotEmpty(status) ? status.split(",") : null;
        String[] atIdArray = StringUtil.isNotEmpty(atId) ? atId.split(",") : null;
        beginTime = Tools.parseDayToTime(beginTime, BusinessConstants.DAY_FIRST_TIME);
        endTime = Tools.parseDayToTime(endTime, BusinessConstants.DAY_LAST_TIME);
        reconciliationBeginTime = Tools.parseDayToTime(reconciliationBeginTime, BusinessConstants.DAY_FIRST_TIME);
        reconciliationEndTime = Tools.parseDayToTime(reconciliationEndTime, BusinessConstants.DAY_LAST_TIME);
        List<SupermarketReconciliationVo> list = supermarketReconciliationMapperEx.selectSupermarketReconciliation(id, atIdArray, beginTime, endTime, number,
                statusArray, reconciliationBeginTime, reconciliationEndTime, offset, rows);

        JSONArray srList = new JSONArray();
        list.forEach(sr -> {
            JSONObject supermarketReconciliation = new JSONObject();

            supermarketReconciliation.put("id", sr.getId());
            supermarketReconciliation.put("number", sr.getNumber());
            supermarketReconciliation.put("status", sr.getStatus());
            supermarketReconciliation.put("remark", sr.getRemark());
            supermarketReconciliation.put("comment", sr.getComment());
            supermarketReconciliation.put("createTime", sr.getCreateTime());
            supermarketReconciliation.put("createdName", sr.getCreatedName());
            supermarketReconciliation.put("verifierTime", sr.getVerifierTime());
            supermarketReconciliation.put("verifierName", sr.getVerifierName());
            supermarketReconciliation.put("quantityTotal", sr.getQuantityTotal());
            supermarketReconciliation.put("billingPriceTotal", sr.getBillingPriceTotal());
            supermarketReconciliation.put("systemPriceTotal", sr.getSystemPriceTotal());
            supermarketReconciliation.put("priceTotal", sr.getPriceTotal());
            supermarketReconciliation.put("reconciliationBeginTime", sr.getReconciliationBeginTime());
            supermarketReconciliation.put("reconciliationEndTime", sr.getReconciliationEndTime());
            supermarketReconciliation.put("formula", sr.getFormula());

            //获取关联水产类型
            SupermarketReconciliationAquaticTypeExample satExample = new SupermarketReconciliationAquaticTypeExample();
            satExample.createCriteria().andSupermarketReconciliationIdEqualTo(sr.getId());
            List<SupermarketReconciliationAquaticType> sat = satMapper.selectByExample(satExample);

            supermarketReconciliation.put("sat", sat);

            srList.add(supermarketReconciliation);
        });
        return srList;
    }

    public Long counts(Long id, String atId, String beginTime, String endTime, String number, String status, String reconciliationBeginTime, String reconciliationEndTime) {
        Long result = null;
        String[] statusArray = StringUtil.isNotEmpty(status) ? status.split(",") : null;
        String[] atIdArray = StringUtil.isNotEmpty(atId) ? atId.split(",") : null;
        beginTime = Tools.parseDayToTime(beginTime, BusinessConstants.DAY_FIRST_TIME);
        endTime = Tools.parseDayToTime(endTime, BusinessConstants.DAY_LAST_TIME);
        reconciliationBeginTime = Tools.parseDayToTime(reconciliationBeginTime, BusinessConstants.DAY_FIRST_TIME);
        reconciliationEndTime = Tools.parseDayToTime(reconciliationEndTime, BusinessConstants.DAY_LAST_TIME);

        try {
            result = supermarketReconciliationMapperEx.countSupermarketReconciliation(id, atIdArray, beginTime, endTime, number, statusArray,
                    reconciliationBeginTime, reconciliationEndTime);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public Object addSupermarketReconciliationAndDetail(SupermarketReconciliationVo4Body body, HttpServletRequest request) throws Exception {
        SupermarketReconciliation supermarketReconciliation = JSONObject.parseObject(body.getInfo(), SupermarketReconciliation.class);
        String formula = supermarketReconciliation.getFormula();
        //校验单号是否重复
        if (checkIsNumberNoExist(0L, supermarketReconciliation.getNumber())) {
            throw new BusinessRunTimeException(ExceptionConstants.NUMBER_IS_EXIST_CODE,
                    String.format(ExceptionConstants.NUMBER_IS_EXIST_MSG));
        }
        User userInfo = userService.getCurrentUser();
        supermarketReconciliation.setCreator(userInfo == null ? null : userInfo.getId());
        supermarketReconciliation.setCreateTime(new Date());
        supermarketReconciliation.setUpdater(userInfo == null ? null : userInfo.getId());
        supermarketReconciliation.setUpdateTime(new Date());
        if (StringUtil.isEmpty(supermarketReconciliation.getStatus())) {
            supermarketReconciliation.setStatus(BusinessConstants.BILLS_STATUS_UN_AUDIT);
        }
        supermarketReconciliationMapper.insertSelective(supermarketReconciliation);
        //更新编号数值
        SupermarketSystemConfig config = supermarketSystemConfigService.getCurrentConfig(BusinessConstants.SUPERMARKET_RECONCILIATION_NUMBER_SEQ);
        Integer currentValue = config.getCurrentValue();
        config.setCurrentValue(currentValue + 1); //编号+1
        supermarketSystemConfigMapper.updateByPrimaryKeySelective(config);
        //根据编号查询id
        Long srId = supermarketReconciliationMapperEx.selectIdByNumber(supermarketReconciliation.getNumber());

        String rows = body.getRows();
        if (rows != null) {//处理子数据
            supermarketReconciliationExtendService.saveReconciliationExtend(rows, srId, formula, request);
        }
        List<SupermarketReconciliationRelevancy> srrList = body.getSrrList();
        if (srrList.size() > 0) {//处理关联编号
            srrService.saveReconciliationRelevancy(srrList, srId, body.getDeleteIds());
        }
        List<SupermarketReconciliationAquaticType> satList = body.getSatList();
        if (satList.size() > 0) {//处理水产类型
            satService.saveAquaticType(satList, srId, body.getSatDeleteIds());
        }
        logService.insertLog("商超财务",
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ADD).append(supermarketReconciliation.getId()).toString(), request);

        return ExceptionConstants.standardSuccess();
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public Object updateSupermarketReconciliationAndDetail(SupermarketReconciliationVo4Body body, HttpServletRequest request) throws Exception {
        SupermarketReconciliation supermarketReconciliation = JSONObject.parseObject(body.getInfo(), SupermarketReconciliation.class);
        String formula = supermarketReconciliation.getFormula();
        //校验单号是否重复
        if (checkIsNumberNoExist(supermarketReconciliation.getId(), supermarketReconciliation.getNumber())) {
            throw new BusinessRunTimeException(ExceptionConstants.NUMBER_IS_EXIST_CODE,
                    String.format(ExceptionConstants.NUMBER_IS_EXIST_MSG));
        }
        //校验审核状态，如何不是未审核或者驳回则提示
        String status = selectOne(supermarketReconciliation.getId()).getStatus();
        if (BusinessConstants.BILLS_STATUS_AUDIT.equals(status) || BusinessConstants.BILLS_STATUS_UNDER_REVIEW.equals(status)) {
            throw new BusinessRunTimeException(ExceptionConstants.SUPERMARKET_ORDER_CANNOT_EDIT_CODE,
                    String.format(ExceptionConstants.SUPERMARKET_ORDER_CANNOT_EDIT_MSG));
        }
        User userInfo = userService.getCurrentUser();
        supermarketReconciliation.setUpdater(userInfo == null ? null : userInfo.getId());
        supermarketReconciliation.setUpdateTime(new Date());
        if (StringUtil.isEmpty(supermarketReconciliation.getStatus())) {
            supermarketReconciliation.setStatus(BusinessConstants.BILLS_STATUS_UN_AUDIT);
        }
        supermarketReconciliationMapper.updateByPrimaryKeySelective(supermarketReconciliation);

        //根据编号查询id
        Long srId = supermarketReconciliationMapperEx.selectIdByNumber(supermarketReconciliation.getNumber());

        String rows = body.getRows();
        if (rows != null) {//处理子数据
            supermarketReconciliationExtendService.saveReconciliationExtend(rows, srId, formula, request);
        }
        List<SupermarketReconciliationRelevancy> srrList = body.getSrrList();
        if (srrList.size() > 0) {//处理关联编号
            srrService.saveReconciliationRelevancy(srrList, srId, body.getDeleteIds());
        }
        List<SupermarketReconciliationAquaticType> satList = body.getSatList();
        if (satList.size() > 0) {//处理水产类型
            satService.saveAquaticType(satList, srId, body.getSatDeleteIds());
        }
        logService.insertLog("商超订单",
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(supermarketReconciliation.getId()).toString(), request);

        return ExceptionConstants.standardSuccess();
    }

    private boolean checkIsNumberNoExist(Long id, String number) {
        SupermarketReconciliationExample example = new SupermarketReconciliationExample();
        example.createCriteria().andIdNotEqualTo(id).andNumberEqualTo(number).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<SupermarketReconciliation> list = null;
        try {
            list = supermarketReconciliationMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list != null && !list.isEmpty();
    }

    public JSONObject findByCondition(Long id) {
        JSONObject supermarketReconciliation = new JSONObject();
        SupermarketReconciliationVo sr = supermarketReconciliationMapperEx.selectSupermarketReconciliationById(id);
        supermarketReconciliation.put("id", sr.getId());
        supermarketReconciliation.put("number", sr.getNumber());
        supermarketReconciliation.put("status", sr.getStatus());
        supermarketReconciliation.put("remark", sr.getRemark());
        supermarketReconciliation.put("comment", sr.getComment());
        supermarketReconciliation.put("createTime", sr.getCreateTime());
        supermarketReconciliation.put("createdName", sr.getCreatedName());
        supermarketReconciliation.put("verifierTime", sr.getVerifierTime());
        supermarketReconciliation.put("verifierName", sr.getVerifierName());
        supermarketReconciliation.put("quantityTotal", sr.getQuantityTotal());
        supermarketReconciliation.put("billingPriceTotal", sr.getBillingPriceTotal());
        supermarketReconciliation.put("systemPriceTotal", sr.getSystemPriceTotal());
        supermarketReconciliation.put("reconciliationBeginTime", sr.getReconciliationBeginTime());
        supermarketReconciliation.put("reconciliationEndTime", sr.getReconciliationEndTime());
        supermarketReconciliation.put("formula", sr.getFormula());
        supermarketReconciliation.put("documentName", sr.getDocumentName());

        // 获取订单详情
        SupermarketReconciliationExtendExample sreExample = new SupermarketReconciliationExtendExample();
        sreExample.createCriteria().andSupermarketReconciliationIdEqualTo(sr.getId()).andDeleteFlagEqualTo(BusinessConstants.DELETE_FLAG_EXISTS);
        List<SupermarketReconciliationExtend> sre = supermarketReconciliationExtendMapper.selectByExample(sreExample);

        //获取关联订单
        SupermarketReconciliationRelevancyExample srrExample = new SupermarketReconciliationRelevancyExample();
        srrExample.createCriteria().andSupermarketReconciliationIdEqualTo(sr.getId());
        List<SupermarketReconciliationRelevancy> srr = srrMapper.selectByExample(srrExample);

        //获取关联水产类型
        SupermarketReconciliationAquaticTypeExample satExample = new SupermarketReconciliationAquaticTypeExample();
        satExample.createCriteria().andSupermarketReconciliationIdEqualTo(sr.getId());
        List<SupermarketReconciliationAquaticType> sat = satMapper.selectByExample(satExample);

        supermarketReconciliation.put("sre", sre);
        supermarketReconciliation.put("srr", srr);
        supermarketReconciliation.put("sat", sat);
        return supermarketReconciliation;
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

        List<SupermarketReconciliation> list = getSupermarketReconciliationByIds(ids);
        for (SupermarketReconciliation sr : list) {
            sb.append("[").append(sr.getId()).append("]");
            // 只有状态为未审核、驳回、草稿的单据才能被删除
            String orderStatus = sr.getStatus();
            if (!(BusinessConstants.BILLS_STATUS_UN_AUDIT.equals(orderStatus) ||
                    BusinessConstants.BILLS_STATUS_REJECT.equals(orderStatus) ||
                    BusinessConstants.BILLS_STATUS_DRAFT.equals(orderStatus))) {
                throw new BusinessRunTimeException(ExceptionConstants.DEPOT_HEAD_UN_AUDIT_DELETE_FAILED_CODE,
                        String.format(ExceptionConstants.DEPOT_HEAD_UN_AUDIT_DELETE_FAILED_MSG));
            }
        }
        int result = 0;
        try {
            result = supermarketReconciliationMapperEx.batchDeleteByIds(new Date(), userInfo == null ? null : userInfo.getId(), idArray);
            //删除商超对账关联表信息
            srrService.batchDeleteBySrIds(idArray);
            logService.insertLog("商超财务", sb.toString(),
                    ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    private List<SupermarketReconciliation> getSupermarketReconciliationByIds(String ids) {
        List<Long> idList = StringUtil.strToLongList(ids);
        List<SupermarketReconciliation> list = null;
        SupermarketReconciliationExample example = new SupermarketReconciliationExample();
        example.createCriteria().andIdIn(idList);
        try {
            list = supermarketReconciliationMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchSetStatus(String status, String ids, String comment, HttpServletRequest request) throws Exception {
        // 获取当前用户信息
        User userInfo = userService.getCurrentUser();
        int result = 0;
        // 解析订单ID列表
        List<Long> idList = StringUtil.strToLongList(ids);
        // 检查修改的审核状态是否符合逻辑的规则
        Map<String, List<String>> statusRules = new HashMap<>();
        statusRules.put("0", Arrays.asList("0", "1", "5", "6", "9"));
        statusRules.put("1", Arrays.asList("0", "9"));
        statusRules.put("5", Arrays.asList("0", "9"));
        statusRules.put("6", Arrays.asList("0", "6"));
        statusRules.put("9", Arrays.asList("0"));

        // 存储符合规则的订单ID列表
        List<Long> srIds = new ArrayList<>();
        for (Long id : idList) {
            SupermarketReconciliation SupermarketReconciliation = supermarketReconciliationMapper.selectByPrimaryKey(id);
            String srStatus = SupermarketReconciliation.getStatus();
            // 如果订单状态符合规则，则加入有效订单ID列表
            if (statusRules.containsKey(status) && statusRules.get(status).contains(srStatus)) {
                srIds.add(id);
            } else {
                // 如果订单状态不符合规则，则抛出异常
                throw new BusinessRunTimeException(ExceptionConstants.UPDATE_STATUS_FAILED_CODE, ExceptionConstants.UPDATE_STATUS_FAILED_MSG);
            }
        }
        // 如果有符合规则的订单，则更新状态
        if (srIds.size() > 0) {
            SupermarketReconciliation sr = new SupermarketReconciliation();
            sr.setStatus(status);
            sr.setComment(comment);
            sr.setVerifier(userService.getCurrentUser().getId());
            sr.setVerifierTime(new Date());
            SupermarketReconciliationExample example = new SupermarketReconciliationExample();
            example.createCriteria().andIdIn(srIds);
            result = supermarketReconciliationMapper.updateByExampleSelective(sr, example);
        }

        // 记录日志
        logService.insertLog("商超财务", new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ENABLED).toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        return result;
    }


}
