package com.jsh.erp.service.paymentRecords;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.*;
import com.jsh.erp.datasource.vo.PaymentRecordsExVo4List;
import com.jsh.erp.datasource.vo.PaymentRecordsVo;
import com.jsh.erp.exception.BusinessRunTimeException;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.balanceRecords.BalanceRecordsService;
import com.jsh.erp.service.log.LogService;
import com.jsh.erp.service.rechargeAmount.RechargeConfigurationService;
import com.jsh.erp.service.user.UserService;
import com.jsh.erp.utils.StringUtil;
import com.jsh.erp.utils.Tools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class PaymentRecordsService {
    private Logger logger = LoggerFactory.getLogger(PaymentRecordsService.class);

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserService userService;
    @Resource
    private PaymentRecordsMapper paymentRecordsMapper;
    @Resource
    private BalanceRecordsMapperEx balanceRecordsMapperEx;
    @Resource
    private PaymentRecordsMapperEx paymentRecordsMapperEx;
    @Resource
    private BalanceRecordsService balanceRecordsService;
    @Resource
    private LogService logService;
    @Resource
    private RechargeConfigurationService rechargeConfigurationService;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertPaymentRecord(JSONObject obj, HttpServletRequest request) throws Exception {
        Long userId = userService.getCurrentUser().getId();
        PaymentRecords paymentRecords = JSONObject.parseObject(obj.toJSONString(), PaymentRecords.class);
        int result;
        try {
            String insertType = obj.getString("insertType");
            if ("新增".equals(insertType)) {
                // 校验供应商是否重复
                if (checkIsSupplierExist(paymentRecords.getSupplierId(), paymentRecords.getSupplierId()) > 0) {
                    throw new BusinessRunTimeException(ExceptionConstants.PAYMENT_RECORDS_ADD_FAILED_CODE, ExceptionConstants.PAYMENT_RECORDS_ADD_FAILED_MSG);
                }
            }
            paymentRecords.setCreator(userId);
            //根据充值金额判断赠送金额
            BigDecimal gift = rechargeConfigurationService.getGiftAmountByRechargeAmount(paymentRecords.getPaymentAmount());
            BigDecimal amountOfGift = (gift != null) ? gift : BigDecimal.ZERO;
            paymentRecords.setAmountOfGift(amountOfGift);
            result = paymentRecordsMapper.insertSelective(paymentRecords);
            logService.insertLog("供应商费用管理", BusinessConstants.LOG_OPERATION_TYPE_ADD, request);
            if ("1".equals(paymentRecords.getApprovalStatus())) {
                // 更新供应商余额
                BigDecimal paymentAmount = paymentRecords.getPaymentAmount();//充值金额
                balanceRecordsService.addBalanceRecords(paymentRecords.getSupplierId(), paymentAmount, amountOfGift);
            }
        } catch (BusinessRunTimeException e) {
            throw e;
        } catch (Exception e) {
            JshException.writeFail(logger, e);
            throw new BusinessRunTimeException(ExceptionConstants.PAYMENT_RECORDS_ADD_FAILED_CODE, ExceptionConstants.PAYMENT_RECORDS_ADD_FAILED_MSG);
        }
        return result;
    }

    /**
     * 查询接口
     *
     * @param supplierId
     * @param beginTime
     * @param endTime
     * @param searchType
     * @param paymentStatus
     * @param offset
     * @param rows
     * @return
     * @throws ParseException
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public List<?> select(String supplierId, String beginTime, String endTime, String searchType, String status, String paymentStatus, int offset, int rows) throws Exception {
        beginTime = Tools.parseDayToTime(beginTime, BusinessConstants.DAY_FIRST_TIME);
        endTime = Tools.parseDayToTime(endTime, BusinessConstants.DAY_LAST_TIME);
        String[] statusArray = StringUtil.isNotEmpty(status) ? status.split(",") : null;
        List<PaymentRecords> paymentRecords = null;
        List<PaymentRecordsVo> paymentRecordsVos = new ArrayList<>();
        PaymentRecordsExVo4List paymentRecordsVo4List = new PaymentRecordsExVo4List();
        List<PaymentRecordsExVo4List> paymentRecordsVo4Lists = new ArrayList<>();
        BigDecimal subtotal = null;
        if (searchType == null || searchType.isEmpty()) {//条件查询
            paymentRecords = paymentRecordsMapperEx.selectByConditionPaymentRecords(supplierId, beginTime, endTime, statusArray, offset, rows);

            //1：列表（查询所有的供应商最新的缴费信息或根据时间段、供应商ID查询数据）
        } else if ("1".equals(searchType)) {
            Integer paymentStatusInt = null;
            if (paymentStatus != null) {
                paymentStatusInt = Integer.parseInt(paymentStatus);
            }
            paymentRecords = paymentRecordsMapperEx.getHistoricalRecordsList(supplierId, beginTime, endTime, statusArray, paymentStatusInt, offset, rows);

            //2：查看功能
        } else if ("2".equals(searchType)) {
            paymentRecords = paymentRecordsMapperEx.getHistoricalRecordsBySupplierId(supplierId, beginTime, endTime, statusArray, offset, rows);
            // 查询供应商的余额信息
            if (!paymentRecords.isEmpty()) {
                BalanceRecords balanceRecord = balanceRecordsMapperEx.selectBySupplierId(paymentRecords.get(0).getSupplierId());
                if (balanceRecord != null) {
                    subtotal = balanceRecord.getSubtotal();
                }
            }

            //3：查询历史单据（只查询已审核的单据）
        } else if ("3".equals(searchType)) {
            paymentRecords = paymentRecordsMapperEx.getHistoricalDocumentsBySupplierId(supplierId, beginTime, endTime, offset, rows);
            // 查询供应商的余额信息
            if (!paymentRecords.isEmpty()) {
                BalanceRecords balanceRecord = balanceRecordsMapperEx.selectBySupplierId(paymentRecords.get(0).getSupplierId());
                if (balanceRecord != null) {
                    subtotal = balanceRecord.getSubtotal();
                }
            }
        }

        // 时间格式转换和属性赋值
        for (int i = 0; i < paymentRecords.size(); i++) {
            PaymentRecords record = paymentRecords.get(i);
            String createTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(record.getCreateTime());
            String updateTime = null;
            if (record.getUpdateTime() != null) {
                updateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(record.getUpdateTime());
            }
            PaymentRecordsVo paymentRecordsVo = new PaymentRecordsVo();
            BeanUtils.copyProperties(record, paymentRecordsVo);
            User creator = userMapper.selectByPrimaryKey(record.getCreator());
            User updater = userMapper.selectByPrimaryKey(record.getUpdater());
            BalanceRecords balanceRecord = balanceRecordsMapperEx.selectBySupplierId(record.getSupplierId());
            if (balanceRecord != null) {//当有供应商还未通过审核时，则无法在余额表查询数据
                subtotal = balanceRecord.getSubtotal() != null ? balanceRecord.getSubtotal() : BigDecimal.ZERO;
            } else {
                subtotal = BigDecimal.ZERO;
            }

            paymentRecordsVo.setBalanceRecord(subtotal);//返回总余额
            paymentRecordsVo.setAmountOfGift(paymentRecordsVo.getAmountOfGift());
            paymentRecordsVo.setCreateTime(createTime);
            paymentRecordsVo.setUpdateTime(updateTime);

            paymentRecordsVo.setCreator(creator != null ? creator.getUsername() : "");
            paymentRecordsVo.setUpdater(updater != null ? updater.getUsername() : "");
            paymentRecordsVos.add(paymentRecordsVo);
        }
        // 返回当前查询的缴费时间段
        String earliestDate = null;
        String latestDate = null;
        if (!paymentRecords.isEmpty()) {
            earliestDate = Tools.getCenternTime(paymentRecords.get(paymentRecords.size() - 1).getCreateTime());
            latestDate = Tools.getCenternTime(paymentRecords.get(0).getCreateTime());
        }
        paymentRecordsVo4List.setPaymentRecords(paymentRecordsVos);
        paymentRecordsVo4List.setBalanceRecord(subtotal);
        paymentRecordsVo4List.setEarliestDate(earliestDate);
        paymentRecordsVo4List.setLatestDate(latestDate);
        paymentRecordsVo4Lists.add(paymentRecordsVo4List);
        return paymentRecordsVo4Lists;
    }

    /**
     * 查询数统计
     *
     * @param supplierId
     * @param beginTime
     * @param endTime
     * @param searchType
     * @param paymentStatus
     * @return
     */
    public Long counts(String supplierId, String beginTime, String endTime, String searchType, String status, String paymentStatus) {
        beginTime = Tools.parseDayToTime(beginTime, BusinessConstants.DAY_FIRST_TIME);
        endTime = Tools.parseDayToTime(endTime, BusinessConstants.DAY_LAST_TIME);
        Long result = 0L;
        // 查询所有的供应商最新的缴费信息或根据时间段、供应商ID查询数据
        String[] statusArray = StringUtil.isNotEmpty(status) ? status.split(",") : null;
        if ("1".equals(searchType)) {
            Integer paymentStatusInt = null;
            if (paymentStatus != null) {
                paymentStatusInt = Integer.parseInt(paymentStatus);
            }
            result = paymentRecordsMapperEx.countsHistoricalRecordsList(supplierId, beginTime, endTime, statusArray, paymentStatusInt);
            //查看功能
        } else if ("2".equals(searchType)) {
            result = paymentRecordsMapperEx.countsHistoricalRecordsBySupplierId(supplierId, beginTime, endTime, statusArray);
            //查询历史单据,只查询已审核的单据
        } else if ("3".equals(searchType)) {
            result = paymentRecordsMapperEx.countsHistoricalDocumentsBySupplierId(supplierId, beginTime, endTime, statusArray);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updatePaymentRecords(JSONObject obj, HttpServletRequest request) throws Exception {
        PaymentRecords paymentRecords = JSONObject.parseObject(obj.toJSONString(), PaymentRecords.class);
        User userInfo = userService.getCurrentUser();
        paymentRecords.setUpdater(userInfo == null ? null : userInfo.getId());
        paymentRecords.setUpdateTime(new Date());
        //根据充值金额判断赠送金额
        BigDecimal gift = rechargeConfigurationService.getGiftAmountByRechargeAmount(paymentRecords.getPaymentAmount());
        BigDecimal amountOfGift = (gift != null) ? gift : BigDecimal.ZERO;
        paymentRecords.setAmountOfGift(amountOfGift);
        int result = 0;
        try {
            result = paymentRecordsMapper.updateByPrimaryKeySelective(paymentRecords);
            // 更新供应商余额
            if ("1".equals(paymentRecords.getApprovalStatus())) {

                BigDecimal paymentAmount = paymentRecords.getPaymentAmount();//充值金额
                balanceRecordsService.addBalanceRecords(paymentRecords.getSupplierId(), paymentAmount, amountOfGift);
            }
            logService.insertLog("供应商费用管理", new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(paymentRecords.getId()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    /**
     * 批量设置状态
     *
     * @param status
     * @param paymentRecordsIds
     * @return
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchSetStatus(String status, String paymentRecordsIds, String comment, HttpServletRequest request) throws Exception {
        int result = 0;
        List<Long> prIds = new ArrayList<>();
        List<Long> ids = StringUtil.strToLongList(paymentRecordsIds);
        //检查修改的审核状态是否符合逻辑
        Map<String, List<String>> statusRules = new HashMap<>();
        statusRules.put("0", Arrays.asList("0", "1", "5", "6", "9"));
        statusRules.put("1", Arrays.asList("0", "9"));
        statusRules.put("5", Arrays.asList("0", "9"));
        statusRules.put("6", Arrays.asList("0", "6"));
        statusRules.put("9", Arrays.asList("0"));

        for (Long id : ids) {
            PaymentRecords paymentRecords = paymentRecordsMapper.selectByPrimaryKey(id);
            String paymentRecordsStatus = paymentRecords.getApprovalStatus();
            if (statusRules.containsKey(status) && statusRules.get(status).contains(paymentRecordsStatus) &&
                    paymentRecords.getDeleteFlag().equals(BusinessConstants.DELETE_FLAG_EXISTS)) {//被删除的不能进行审核
                prIds.add(id);
            } else {
                throw new BusinessRunTimeException(ExceptionConstants.UPDATE_STATUS_FAILED_CODE, ExceptionConstants.UPDATE_STATUS_FAILED_MSG);
            }
        }
        if (prIds.size() > 0) {
            for (Long prId : prIds) {
                PaymentRecords paymentRecords = paymentRecordsMapper.selectByPrimaryKey(prId);
                // 根据传入的状态执行相应的操作
                if ("0".equals(status) && "1".equals(paymentRecords.getApprovalStatus())) {//反审核且之前状态为已审核，回退金额
                    handleRollback(paymentRecords);
                } else if ("1".equals(status)) {//审核，扣除余额
                    handleApproval(paymentRecords);
                }
            }
            PaymentRecords paymentRecords = new PaymentRecords();
            paymentRecords.setComment(comment);
            paymentRecords.setApprovalStatus(status);
            paymentRecords.setVerifier(userService.getCurrentUser().getId());
            PaymentRecordsExample example = new PaymentRecordsExample();
            example.createCriteria().andIdIn(prIds);
            result = paymentRecordsMapper.updateByExampleSelective(paymentRecords, example);
        }
        return result;
    }

    // 反审核逻辑
    private void handleRollback(PaymentRecords paymentRecords) throws Exception {
        Long supplierId = paymentRecords.getSupplierId();
        BigDecimal paymentAmount = paymentRecords.getPaymentAmount();
        BigDecimal amountOfGift = (paymentRecords.getAmountOfGift() != null) ? paymentRecords.getAmountOfGift() : BigDecimal.ZERO;
        balanceRecordsService.subtractBalanceRecords(supplierId, paymentAmount, amountOfGift);
    }

    // 审核逻辑
    private void handleApproval(PaymentRecords paymentRecords) throws Exception {
        BigDecimal paymentAmount = paymentRecords.getPaymentAmount();
        BigDecimal amountOfGift = (paymentRecords.getAmountOfGift() != null) ? paymentRecords.getAmountOfGift() : BigDecimal.ZERO;
        balanceRecordsService.addBalanceRecords(paymentRecords.getSupplierId(), paymentAmount, amountOfGift);
    }

    /**
     * 批量删除接口（逻辑删除）
     *
     * @param ids
     * @param request
     * @return
     * @throws Exception
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeletePaymentRecords(String ids, HttpServletRequest request) throws Exception {
        StringBuffer sb = new StringBuffer();
        sb.append(BusinessConstants.LOG_OPERATION_TYPE_DELETE);
        List<PaymentRecords> prList = getPaymentRecordsListByIds(ids);

        List<Long> deletableIds = new ArrayList<>();
        for (PaymentRecords paymentRecords : prList) {
            //只有未审核、草稿、被驳回单据才能被删除
            String status = paymentRecords.getApprovalStatus();
            if ("0".equals(status) || "5".equals(status) || "6".equals(status)) {
                deletableIds.add(paymentRecords.getId());
            } else {
                throw new BusinessRunTimeException(ExceptionConstants.DEPOT_HEAD_UN_AUDIT_DELETE_FAILED_CODE, String.format(ExceptionConstants.DEPOT_HEAD_UN_AUDIT_DELETE_FAILED_MSG));
            }
        }
        int result = 0;
        if (!deletableIds.isEmpty()) {
            result = batchDeletePaymentRecordsByIds(deletableIds);
        }
        return result;
    }

    public List<PaymentRecords> getPaymentRecordsListByIds(String ids) throws Exception {
        List<Long> idList = StringUtil.strToLongList(ids);
        PaymentRecordsExample example = new PaymentRecordsExample();
        example.createCriteria().andIdIn(idList);
        List<PaymentRecords> list = paymentRecordsMapper.selectByExample(example);
        return list;
    }

    /**
     * 批量逻辑删除供应商充值信息
     *
     * @param ids
     * @return
     * @throws Exception
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeletePaymentRecordsByIds(List<Long> ids) throws Exception {
        User userInfo = userService.getCurrentUser();
        String[] idArray = ids.stream().map(String::valueOf).toArray(String[]::new);

        int result = 0;
        try {
            result = paymentRecordsMapperEx.batchDeletePaymentRecordsByIds(new Date(), userInfo == null ? null : userInfo.getId(), idArray);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    /**
     * 检验供应商是否存在
     *
     * @param id
     * @param supplierId
     * @return
     * @throws Exception
     */
    public int checkIsSupplierExist(Long id, Long supplierId) throws Exception {
        PaymentRecordsExample example = new PaymentRecordsExample();
        example.createCriteria().andIdNotEqualTo(id).andSupplierIdEqualTo(supplierId).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<PaymentRecords> list = null;
        try {
            list = paymentRecordsMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list == null ? 0 : list.size();
    }
}