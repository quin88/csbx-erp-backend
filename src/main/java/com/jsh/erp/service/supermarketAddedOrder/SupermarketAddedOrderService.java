package com.jsh.erp.service.supermarketAddedOrder;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.*;
import com.jsh.erp.datasource.vo.SupermarketAddedOrderVo;
import com.jsh.erp.exception.BusinessRunTimeException;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.log.LogService;
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
import java.math.BigDecimal;
import java.util.*;

@Service
public class SupermarketAddedOrderService {
    private Logger logger = LoggerFactory.getLogger(SupermarketAddedOrderService.class);
    @Resource
    private LogService logService;
    @Resource
    private SupermarketAddedOrderMapper supermarketAddedOrderMapper;
    @Resource
    private UserService userService;
    @Resource
    private SupermarketAddedOrderMapperEx supermarketAddedOrderMapperEx;
    @Resource
    private SupermarketOrderMapper supermarketOrderMapper;
    @Resource
    private SupermarketSystemConfigService supermarketSystemConfigService;
    @Resource
    private SupermarketSystemConfigMapper supermarketSystemConfigMapper;

    public Object selectOne(Long id) {
        SupermarketAddedOrderVo result = null;
        try {
            result = supermarketAddedOrderMapperEx.selectSupermarketAddedOrderById(id);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    public List<?> search(Long id, String beginTime, String endTime, String number, String status, String linkNumber, int offset, int rows) {
        String[] statusArray = StringUtil.isNotEmpty(status) ? status.split(",") : null;
        beginTime = Tools.parseDayToTime(beginTime, BusinessConstants.DAY_FIRST_TIME);
        endTime = Tools.parseDayToTime(endTime, BusinessConstants.DAY_LAST_TIME);

        return supermarketAddedOrderMapperEx.selectSupermarketAddedOrder(id, beginTime, endTime, number,
                statusArray, linkNumber, offset, rows);
    }

    public Long counts(Long id, String beginTime, String endTime, String number, String status, String linkNumber) {
        String[] statusArray = StringUtil.isNotEmpty(status) ? status.split(",") : null;
        beginTime = Tools.parseDayToTime(beginTime, BusinessConstants.DAY_FIRST_TIME);
        endTime = Tools.parseDayToTime(endTime, BusinessConstants.DAY_LAST_TIME);

        return supermarketAddedOrderMapperEx.countSupermarketAddedOrder(id, beginTime, endTime, number,
                statusArray, linkNumber);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception {
        SupermarketAddedOrder supermarketAddedOrder = JSONObject.parseObject(obj.toJSONString(), SupermarketAddedOrder.class);
        //检测图片长度是否超出
        checkImageLength(supermarketAddedOrder.getImage());
        //校验单号是否重复
        if (checkIsNumberNoExist(0L, supermarketAddedOrder.getNumber())) {
            throw new BusinessRunTimeException(ExceptionConstants.NUMBER_IS_EXIST_CODE,
                    String.format(ExceptionConstants.NUMBER_IS_EXIST_MSG));
        }
        int result = 0;
        User userInfo = userService.getCurrentUser();
        try {
            supermarketAddedOrder.setCreator(userInfo.getId());
            supermarketAddedOrder.setCreateTime(new Date());
            supermarketAddedOrder.setUpdater(userInfo.getId());
            supermarketAddedOrder.setUpdateTime(new Date());
            result = supermarketAddedOrderMapper.insertSelective(supermarketAddedOrder);
            //更新编号数值
            SupermarketSystemConfig config = supermarketSystemConfigService.getCurrentConfig(BusinessConstants.SUPERMARKET_ADDED_ORDER_NUMBER_SEQ);
            Integer currentValue = config.getCurrentValue();
            config.setCurrentValue(currentValue + 1); //编号+1
            supermarketSystemConfigMapper.updateByPrimaryKeySelective(config);
            logService.insertLog("个人补单",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ADD).append(supermarketAddedOrder.getNumber()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    private void checkImageLength(String image) {
        if (image.length() >= 500) {
            throw new BusinessRunTimeException(ExceptionConstants.SUPPLIER_ADDED_ORDER_SAVE_IMAGE_FAILED_CODE,
                    String.format(ExceptionConstants.SUPPLIER_ADDED_ORDER_SAVE_IMAGE_FAILED_MSG));
        }
    }

    private boolean checkIsNumberNoExist(Long id, String number) {
        SupermarketAddedOrderExample example = new SupermarketAddedOrderExample();
        example.createCriteria().andIdNotEqualTo(id).andNumberEqualTo(number).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<SupermarketAddedOrder> list = null;
        try {
            list = supermarketAddedOrderMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list != null && !list.isEmpty();
    }


    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int update(JSONObject obj, HttpServletRequest request) throws Exception {
        SupermarketAddedOrder supermarketAddedOrder = JSONObject.parseObject(obj.toJSONString(), SupermarketAddedOrder.class);
        //检测图片长度是否超出
        checkImageLength(supermarketAddedOrder.getImage());
        //校验单号是否重复
        if (checkIsNumberNoExist(supermarketAddedOrder.getId(), supermarketAddedOrder.getNumber())) {
            throw new BusinessRunTimeException(ExceptionConstants.NUMBER_IS_EXIST_CODE,
                    String.format(ExceptionConstants.NUMBER_IS_EXIST_MSG));
        }
        int result = 0;
        User userInfo = userService.getCurrentUser();
        try {
            supermarketAddedOrder.setUpdater(userInfo.getId());
            supermarketAddedOrder.setUpdateTime(new Date());
            result = supermarketAddedOrderMapper.updateByPrimaryKeySelective(supermarketAddedOrder);

            logService.insertLog("个人补单",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(supermarketAddedOrder.getNumber()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
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

        List<SupermarketAddedOrder> list = getSupermarketAddedOrdersByIds(ids);
        for (SupermarketAddedOrder order : list) {
            sb.append("[").append(order.getId()).append("]");
            // 只有状态为未审核、驳回、草稿的单据才能被删除
            String orderStatus = order.getStatus();
            if (!(BusinessConstants.BILLS_STATUS_UN_AUDIT.equals(orderStatus) ||
                    BusinessConstants.BILLS_STATUS_REJECT.equals(orderStatus) ||
                    BusinessConstants.BILLS_STATUS_DRAFT.equals(orderStatus))) {
                throw new BusinessRunTimeException(ExceptionConstants.DEPOT_HEAD_UN_AUDIT_DELETE_FAILED_CODE,
                        String.format(ExceptionConstants.DEPOT_HEAD_UN_AUDIT_DELETE_FAILED_MSG));
            }
        }
        int result = 0;
        try {
            result = supermarketAddedOrderMapperEx.batchDeleteByIds(new Date(), userInfo == null ? null : userInfo.getId(), idArray);
            logService.insertLog("个人补单", sb.toString(),
                    ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    private List<SupermarketAddedOrder> getSupermarketAddedOrdersByIds(String ids) {
        List<Long> idList = StringUtil.strToLongList(ids);
        List<SupermarketAddedOrder> list = null;
        SupermarketAddedOrderExample example = new SupermarketAddedOrderExample();
        example.createCriteria().andIdIn(idList);
        try {
            list = supermarketAddedOrderMapper.selectByExample(example);
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
        List<Long> addedOrderIds = StringUtil.strToLongList(ids);
        // 检查修改的审核状态是否符合逻辑的规则
        Map<String, List<String>> statusRules = new HashMap<>();
        statusRules.put("0", Arrays.asList("0", "1", "5", "6", "9"));
        statusRules.put("1", Arrays.asList("0", "9"));
        statusRules.put("5", Arrays.asList("0", "9"));
        statusRules.put("6", Arrays.asList("0", "6"));
        statusRules.put("9", Arrays.asList("0"));

        // 存储符合规则的订单ID列表
        List<Long> validOrderIds = new ArrayList<>();
        for (Long id : addedOrderIds) {
            SupermarketAddedOrder supermarketAddedOrder = supermarketAddedOrderMapper.selectByPrimaryKey(id);
            String orderStatus = supermarketAddedOrder.getStatus();
            // 如果订单状态符合规则，则加入有效订单ID列表
            if (statusRules.containsKey(status) && statusRules.get(status).contains(orderStatus)) {
                validOrderIds.add(id);
            } else {
                // 如果订单状态不符合规则，则抛出异常
                throw new BusinessRunTimeException(ExceptionConstants.UPDATE_STATUS_FAILED_CODE, ExceptionConstants.UPDATE_STATUS_FAILED_MSG);
            }
        }
        // 如果有符合规则的订单，则更新状态
        if (!validOrderIds.isEmpty()) {
            for (Long saoId : validOrderIds) {
                SupermarketAddedOrder sao = supermarketAddedOrderMapper.selectByPrimaryKey(saoId);
                sao.setStatus(status);
                sao.setComment(comment);
                sao.setVerifier(userService.getCurrentUser().getId());
                sao.setVerifierTime(new Date());
                // 根据订单ID更新订单状态
                SupermarketAddedOrderExample example = new SupermarketAddedOrderExample();
                example.createCriteria().andIdEqualTo(saoId);
                // 如果状态为审核通过，则更新关联订单的差额
                if (BusinessConstants.BILLS_STATUS_AUDIT.equals(status)) {
                    BigDecimal relatedDifferenceTotal = supermarketOrderMapper.selectByPrimaryKey(sao.getLinkId()).getDifferenceTotal();
                    sao.setInitialDifference(relatedDifferenceTotal);//记录当前差额
                    BigDecimal transferAmount = supermarketAddedOrderMapper.selectByPrimaryKey(saoId).getTransferAmount();
                    relatedDifferenceTotal = relatedDifferenceTotal.subtract(transferAmount);
                    SupermarketOrder relatedOrder = new SupermarketOrder();
                    relatedOrder.setId(sao.getLinkId());
                    relatedOrder.setDifferenceTotal(relatedDifferenceTotal);
                    // 如果差额为0或者负数，则更新关联订单的状态为审核通过
                    if (relatedDifferenceTotal.compareTo(BigDecimal.ZERO) <= 0) {
                        relatedOrder.setStatus(BusinessConstants.BILLS_STATUS_AUDIT);
                    }
                    // 更新关联订单
                    supermarketOrderMapper.updateByPrimaryKeySelective(relatedOrder);
                }
                // 更新当前订单
                result = supermarketAddedOrderMapper.updateByExampleSelective(sao, example);
            }
        }
        // 记录日志
        logService.insertLog("个人补单", new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ENABLED).toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        return result;
    }
}
