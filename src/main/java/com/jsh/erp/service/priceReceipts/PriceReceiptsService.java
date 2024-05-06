package com.jsh.erp.service.priceReceipts;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.*;
import com.jsh.erp.datasource.vo.*;
import com.jsh.erp.exception.BusinessRunTimeException;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.balanceRecords.BalanceRecordsService;
import com.jsh.erp.service.depotItem.DepotItemService;
import com.jsh.erp.service.priceDetails.PriceDetailsService;
import com.jsh.erp.service.shippingPrice.ShippingPriceService;
import com.jsh.erp.service.user.UserService;
import com.jsh.erp.utils.StringUtil;
import com.jsh.erp.utils.Tools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

import static com.jsh.erp.utils.Tools.getNow3;


@Service
public class PriceReceiptsService {

    private Logger logger = LoggerFactory.getLogger(PriceReceiptsService.class);

    public static final String PRICE_TYPE = "每月物流费用";
    @Resource
    private PriceReceiptsMapper priceReceiptsMapper;
    @Resource
    private BalanceRecordsService balanceRecordsService;
    @Resource
    private PriceReceiptsMapperEx priceReceiptsMapperEx;
    @Resource
    private UserService userService;
    @Resource
    private PriceDetailsMapperEx priceDetailsMapperEx;
    @Resource
    private PriceDetailsService priceDetailsService;
    @Resource
    private PaymentRecordsMapperEx paymentRecordsMapperEx;
    @Resource
    private DepotItemMapperEx depotItemMapperEx;
    @Resource
    private ShippingPriceService shippingPriceService;
    @Resource
    private DepotHeadMapper depotHeadMapper;
    @Resource
    private DepotItemService depotItemService;
    @Resource
    private ShippingPriceMapperEx shippingPriceMapperEx;

    public PriceReceipts getPriceReceipts(Long id) {
        PriceReceipts result = null;
        try {
            result = priceReceiptsMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    public List<?> select(String supplierId, String priceType, String beginTime, String endTime, String status, int offset, int rows) {
        beginTime = Tools.parseDayToTime(beginTime, BusinessConstants.DAY_FIRST_TIME);
        endTime = Tools.parseDayToTime(endTime, BusinessConstants.DAY_LAST_TIME);
        String[] statusArray = StringUtil.isNotEmpty(status) ? status.split(",") : null;
        List<PriceReceiptsVo> priceReceiptsVoList = priceReceiptsMapperEx.selectPriceReceiptsList(supplierId, priceType, beginTime, endTime, statusArray, offset, rows);
        List<PriceReceiptsVo> priceReceiptsVos = new ArrayList<>();
        for (PriceReceiptsVo priceReceiptsVo : priceReceiptsVoList) {
            //此步操作，用于前端无法渲染supplier字段，所以新增一个organName字段，赋值到这个字段返回给前端
            priceReceiptsVo.setOrganName(priceReceiptsVo.getSupplier());
            List<String> list = priceDetailsMapperEx.selectDetailsByReceiptsNumber(priceReceiptsVo.getReceiptsNumber());
            if (list != null) {
                priceReceiptsVo.setPriceTypes(list);
                priceReceiptsVo.setPriceNumber(null);
            }
            priceReceiptsVos.add(priceReceiptsVo);
        }
        return priceReceiptsVos;
    }

    public Long counts(String supplier, String priceType, String beginTime, String endTime, String status) {
        beginTime = Tools.parseDayToTime(beginTime, BusinessConstants.DAY_FIRST_TIME);
        endTime = Tools.parseDayToTime(endTime, BusinessConstants.DAY_LAST_TIME);
        String[] statusArray = StringUtil.isNotEmpty(status) ? status.split(",") : null;
        return priceReceiptsMapperEx.countsPriceReceipts(supplier, priceType, beginTime, endTime, statusArray);
    }

    public int deleteBatchByIds(String ids, HttpServletRequest request) throws Exception {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(BusinessConstants.LOG_OPERATION_TYPE_DELETE);
        //根据id查询已有数据的审核状态
        List<PriceReceipts> prList = getPriceReceiptsListByIds(ids);

        for (PriceReceipts priceReceipts : prList) {
            //已审核和审核中的单据不能被删除
            if (BusinessConstants.BILLS_STATUS_AUDIT.equals(priceReceipts.getStatus()) || BusinessConstants.BILLS_STATUS_UNDER_REVIEW.equals(priceReceipts.getStatus())) {
                throw new BusinessRunTimeException(ExceptionConstants.DEPOT_HEAD_UN_AUDIT_DELETE_FAILED_CODE, String.format(ExceptionConstants.DEPOT_HEAD_UN_AUDIT_DELETE_FAILED_MSG));
            }
        }
        return batchDeletePriceReceiptsByIds(ids);
    }

    public List<PriceReceipts> getPriceReceiptsListByIds(String ids) throws Exception {
        List<Long> idList = StringUtil.strToLongList(ids);
        PriceReceiptsExample example = new PriceReceiptsExample();
        example.createCriteria().andIdIn(idList);
        return priceReceiptsMapper.selectByExample(example);
    }

    /**
     * 批量逻辑删除单据主表信息
     *
     * @param ids
     * @return
     * @throws Exception
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeletePriceReceiptsByIds(String ids) throws Exception {
        User userInfo = userService.getCurrentUser();
        String[] idArray = ids.split(",");
        int result = 0;
        List<String> numbers = priceReceiptsMapperEx.findPriceDetailReceiptsNumberByIdArray(idArray);
        for (String number : numbers) {
            // 查询费用单据
            PriceReceipts priceReceipts = priceReceiptsMapperEx.selectPriceReceiptsByReceiptsNumber(number);
            // 如果费用单据为已审核状态，抛出异常
            if (BusinessConstants.BILLS_STATUS_AUDIT.equals(priceReceipts.getStatus()) ||
                    BusinessConstants.BILLS_STATUS_UNDER_REVIEW.equals(priceReceipts.getStatus())) {
                throw new BusinessRunTimeException(ExceptionConstants.DEPOT_HEAD_UN_AUDIT_DELETE_FAILED_CODE,
                        String.format(ExceptionConstants.DEPOT_HEAD_UN_AUDIT_DELETE_FAILED_MSG));
            }
            // 如果是物流费用类型，批量删除相关物流费用记录
            if (PRICE_TYPE.equals(priceReceipts.getPriceType())) {
                shippingPriceService.batchDeletePriceDetailByReceiptsNumber(numbers);
            }
        }
        // 批量逻辑删除费用单据
        result = priceReceiptsMapperEx.batchDeletePriceReceiptsByIds(new Date(), userInfo == null ? null : userInfo.getId(), idArray);
        // 批量逻辑删除费用明细
        priceDetailsService.batchDeletePriceDetailByReceiptsNumber(numbers);
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchSetStatus(String status, String ids, String comment, HttpServletRequest request) throws Exception {
        User userInfo = userService.getCurrentUser();

        int result = 0;
        List<Long> prIds = new ArrayList<>();
        List<Long> priceReceiptsIds = StringUtil.strToLongList(ids);
        //检查修改的审核状态是否符合逻辑
        Map<String, List<String>> statusRules = new HashMap<>();
        statusRules.put("0", Arrays.asList("0", "1", "5", "6", "9"));
        statusRules.put("1", Arrays.asList("0", "9"));
        statusRules.put("5", Arrays.asList("0", "9"));
        statusRules.put("6", Arrays.asList("0", "6"));
        statusRules.put("9", Arrays.asList("0"));

        for (Long id : priceReceiptsIds) {
            PriceReceipts priceReceipts = getPriceReceipts(id);
            String priceReceiptsStatus = priceReceipts.getStatus();
            if (statusRules.containsKey(status) && statusRules.get(status).contains(priceReceiptsStatus) &&
                    priceReceipts.getDeleteFlag().equals(BusinessConstants.DELETE_FLAG_EXISTS)) {//被删除的不能进行审核
                prIds.add(id);
            } else {
                throw new BusinessRunTimeException(ExceptionConstants.UPDATE_STATUS_FAILED_CODE, ExceptionConstants.UPDATE_STATUS_FAILED_MSG);
            }
        }
        if (prIds.size() > 0) {
            for (Long prId : prIds) {
                PriceReceipts priceReceipts = priceReceiptsMapper.selectByPrimaryKey(prId);
                // 根据传入的状态执行相应的操作
                if ("0".equals(status) && "1".equals(priceReceipts.getStatus())) {//反审核且之前状态为已审核，回退金额
                    BigDecimal paymentAmount = priceReceipts.getTotalPrice();
                    BigDecimal amountOfGift = BigDecimal.ZERO;
                    balanceRecordsService.rollbackBalanceRecords(priceReceipts.getSupplierId(), paymentAmount, amountOfGift);
                } else if ("1".equals(status)) {//审核，扣除余额
                    balanceRecordsService.subtractBalance(priceReceipts.getSupplierId(), priceReceipts.getTotalPrice(), priceReceipts.getPriceType());
                }
            }
            PriceReceipts priceReceipts = new PriceReceipts();
            priceReceipts.setStatus(status);
            priceReceipts.setComment(comment);
            priceReceipts.setVerifier(userService.getCurrentUser().getId());
            PriceReceiptsExample example = new PriceReceiptsExample();

            example.createCriteria().andIdIn(prIds);
            result = priceReceiptsMapper.updateByExampleSelective(priceReceipts, example);
            //修改费用明细状态
            String[] idArray = ids.split(",");
            List<String> receiptsNumberList = priceReceiptsMapperEx.findPriceDetailReceiptsNumberByIdArray(idArray);
            priceDetailsService.batchSetStatus(status, receiptsNumberList);
        }
        return result;
    }

    public int deleteByIds(Long id, HttpServletRequest request) throws Exception {
        return batchDeletePriceReceiptsByIds(id.toString());
    }

    public BigDecimal getStatisticsBySupplier(String priceType, Long supplierId, String beginTime, String endTime) {
        BigDecimal totalAmount = BigDecimal.ZERO;
        beginTime = Tools.parseDayToTime(beginTime, BusinessConstants.DAY_FIRST_TIME);
        endTime = Tools.parseDayToTime(endTime, BusinessConstants.DAY_LAST_TIME);
        try {
            totalAmount = priceReceiptsMapperEx.getStatisticsBySupplier(priceType, supplierId, beginTime, endTime);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return totalAmount;
    }

    /**
     * 导出流水接口
     *
     * @param supplierId
     * @param request
     * @return
     */
    public Object importPriceReceipts(Long supplierId, String searchType, String beginTime, String endTime, HttpServletRequest request) {
        beginTime = Tools.parseDayToTime(beginTime, BusinessConstants.DAY_FIRST_TIME);
        endTime = Tools.parseDayToTime(endTime, BusinessConstants.DAY_LAST_TIME);

        List<List<ImportPriceReceiptsVo4List>> queryList;
        BigDecimal totalAmount;
        ImportPriceReceiptsResultVO importPriceReceiptsResultVO = new ImportPriceReceiptsResultVO();

        if ("费用结算".equals(searchType)) {
            queryList = getPriceSettlementQueryList(supplierId, beginTime, endTime);
            totalAmount = calculateAndSetResultList(queryList, importPriceReceiptsResultVO);
            totalAmount = totalAmount.negate();//转为负数
        } else if ("供应商费用管理".equals(searchType)) {
            queryList = getSupplierCostManagementQueryList(supplierId, beginTime, endTime);
            calculateAndSetResultList(queryList, importPriceReceiptsResultVO);
            //查询当前账户余额
            totalAmount = paymentRecordsMapperEx.getRemainingSumStatistics(supplierId, endTime);

            BigDecimal totalCost = calculateTotalCost(importPriceReceiptsResultVO.getResultList());
            List<ImportPriceReceiptsVo4List> costsList = getColdStorageCostsList(supplierId, beginTime, endTime);

            importPriceReceiptsResultVO.setColdStorageCosts(costsList);
            importPriceReceiptsResultVO.setTotalCost(totalCost);
            BigDecimal coldTotalAmount = calculateTotalPrice(costsList);
            importPriceReceiptsResultVO.setColdTotalAmount(coldTotalAmount);
        } else {
            return null;
        }
        importPriceReceiptsResultVO.setTotalAmount(totalAmount);
        return importPriceReceiptsResultVO;
    }

    /**
     * 计算并设置结果列表和总金额
     *
     * @param queryList
     * @param importPriceReceiptsResultVO
     * @return
     */
    private BigDecimal calculateAndSetResultList(List<List<ImportPriceReceiptsVo4List>> queryList, ImportPriceReceiptsResultVO importPriceReceiptsResultVO) {
        List<ImportPriceReceiptsVo4List> resultList = queryList.stream()
                .flatMap(Collection::stream)
                .sorted(Comparator.comparing(ImportPriceReceiptsVo4List::getCreatedTime))
                .collect(Collectors.toList());
        BigDecimal totalAmount = calculateTotalPrice(resultList);
        importPriceReceiptsResultVO.setResultList(resultList);
        return totalAmount;
    }

    /**
     * 计算非充值的总费用,统计消费总计
     *
     * @param resultList
     * @return
     */
    private BigDecimal calculateTotalCost(List<ImportPriceReceiptsVo4List> resultList) {
        List<ImportPriceReceiptsVo4List> nonRechargeList = resultList.stream()
                .filter(entry -> !"缴费".equals(entry.getName()))
                .collect(Collectors.toList());
        return calculateTotalPrice(nonRechargeList);
    }

    private List<ImportPriceReceiptsVo4List> getColdStorageCostsList(Long supplierId, String beginTime, String endTime) {
        List<ImportPriceReceiptsVo4List> priceDetails = priceDetailsMapperEx.selectPriceDetailBySupplierIdAndTime(supplierId, beginTime, endTime);
        List<ImportPriceReceiptsVo4List> shippingPrices = new ArrayList<>(priceReceiptsMapperEx.selectShippingPriceBySupplierIdAndTime(supplierId, beginTime, endTime));

        // 合并相同属性的费用
        Map<String, ImportPriceReceiptsVo4List> mergedCosts = new HashMap<>();

        // 处理 priceDetails 中的费用
        if (priceDetails.size() > 0) {
            for (ImportPriceReceiptsVo4List detail : priceDetails) {
                String key = generateKey(detail); // 生成唯一键
                if (!mergedCosts.containsKey(key)) {
                    // 如果 mergedCosts 中没有当前费用的键，直接添加
                    mergedCosts.put(key, detail);
                } else {
                    // 如果 mergedCosts 中已经存在当前费用的键，则合并费用并计算总价
                    ImportPriceReceiptsVo4List existingDetail = mergedCosts.get(key);
                    BigDecimal totalPrice = existingDetail.getAllPrice().add(detail.getAllPrice());
                    BigDecimal operNumber = existingDetail.getOperNumber().add(detail.getOperNumber());//数量
                    existingDetail.setAllPrice(totalPrice);
                    existingDetail.setOperNumber(operNumber);
                }
            }
        }
        // 处理 shippingPrices 中的费用
        BigDecimal totalShippingPrice = BigDecimal.ZERO;
        if (shippingPrices.size() > 0) {
            for (ImportPriceReceiptsVo4List shipping : shippingPrices) {
                totalShippingPrice = totalShippingPrice.add(shipping.getAllPrice());
            }
            ImportPriceReceiptsVo4List shipping = new ImportPriceReceiptsVo4List();
            shipping.setSupplier(shippingPrices.get(0).getSupplier());
            shipping.setName(shippingPrices.get(0).getName());
            shipping.setAllPrice(totalShippingPrice);
            mergedCosts.put("每月物流费用", shipping);
        }
        // 将合并后的费用放入结果列表并按创建时间排序
        List<ImportPriceReceiptsVo4List> resultList = new ArrayList<>(mergedCosts.values());
        return resultList;
    }

    // 生成合并费用的唯一键
    private String generateKey(ImportPriceReceiptsVo4List cost) {
        // 使用所有需要比较的属性作为键
        return cost.getName() + "_" + cost.getUnitPrice() + "_" + cost.getTimeMeasurement() + "_" + cost.getWeightMeasurement();
    }

    private List<List<ImportPriceReceiptsVo4List>> getPriceSettlementQueryList(Long supplierId, String beginTime, String endTime) {
        return Arrays.asList(
                //费用明细
                priceDetailsMapperEx.selectPriceDetailBySupplierIdAndTime(supplierId, beginTime, endTime),
                //物流费用
                priceReceiptsMapperEx.selectShippingPriceBySupplierIdAndTime(supplierId, beginTime, endTime),
                //商品信息
                depotItemMapperEx.selectDepotItemInfoBySupplierIdAndTime(supplierId, beginTime, endTime)
        );
    }

    private List<List<ImportPriceReceiptsVo4List>> getSupplierCostManagementQueryList(Long supplierId, String beginTime, String endTime) {
        return Arrays.asList(
                //充值缴费表
                paymentRecordsMapperEx.selectPaymentRecordsBySupplierIdAndTime(supplierId, beginTime, endTime),
                //费用明细
                priceDetailsMapperEx.selectPriceDetailBySupplierIdAndTime(supplierId, beginTime, endTime),
                //物流费用
                priceReceiptsMapperEx.selectShippingPriceBySupplierIdAndTime(supplierId, beginTime, endTime),
                //商品信息
                depotItemMapperEx.selectDepotItemInfoBySupplierIdAndTime(supplierId, beginTime, endTime)
        );
    }

    //计算集合中的总金额
    public BigDecimal calculateTotalPrice(List<ImportPriceReceiptsVo4List> priceReceiptsList) {
        return priceReceiptsList.stream()
                .map(ImportPriceReceiptsVo4List::getAllPrice)
                .filter(Objects::nonNull) // 过滤掉为null的价格
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /**
     * 统计供应商的消费金额-统计当前月份
     */
    public BigDecimal getCurrentMonthStatistics(Long supplierId) throws Exception {
        String monthFirstDay = Tools.firstDayOfMonth(Tools.getCurrentMonth()) + BusinessConstants.DAY_FIRST_TIME;
        return priceReceiptsMapperEx.getCurrentMonthStatistics(supplierId, monthFirstDay, getNow3());
    }

    /**
     * 查询当前每日的消费总计
     */
    public List<PriceReceiptsVoSExpense> findDayTotalExpenseByCurrentMonth(Long supplierId) throws ParseException {
        String beginTime = Tools.firstDayOfMonth(Tools.getCurrentMonth()) + BusinessConstants.DAY_FIRST_TIME;
        List<PriceReceiptsVoSExpense> dayTotalExpense = null;
        try {
            dayTotalExpense = priceReceiptsMapperEx.findDayTotalExpense(supplierId, beginTime, getNow3());
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return dayTotalExpense;
    }

    /**
     * 查询供应商每月的消费总计
     */
    public List<PriceReceiptsVoSMonthExpense> getPaymentRecordsList(Long supplierId, String beginDate, String endDate) {
        List<PriceReceiptsVoSMonthExpense> monthlyTotalExpense = null;
        try {
            String beginTime = beginDate == null ? null : Tools.firstDayOfMonth(beginDate) + BusinessConstants.DAY_FIRST_TIME;
            String endTime = endDate == null ? null : Tools.lastDayOfMonth(endDate) + BusinessConstants.DAY_LAST_TIME;
            monthlyTotalExpense = priceReceiptsMapperEx.findMonthTotalExpense(supplierId, beginTime, endTime);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return monthlyTotalExpense;
    }

    /**
     * 根据时间查询供应商每天的消费总计
     */
    public List<PriceReceiptsVoSExpense> findDayTotalExpense(Long supplierId, String monthTime) throws ParseException {
        String beginTime = Tools.firstDayOfMonth(monthTime) + BusinessConstants.DAY_FIRST_TIME;
        String endTime = Tools.lastDayOfMonth(monthTime) + BusinessConstants.DAY_LAST_TIME;
        List<PriceReceiptsVoSExpense> dayTotalExpense = null;
        try {
            dayTotalExpense = priceReceiptsMapperEx.findDayTotalExpense(supplierId, beginTime, endTime);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return dayTotalExpense;
    }

    public Object getPriceReceiptsToDay(Long supplierId, String dayDate, HttpServletRequest request) throws Exception {
        String beginTime = Tools.parseDayToTime(dayDate, BusinessConstants.DAY_FIRST_TIME);
        String endTime = Tools.parseDayToTime(dayDate, BusinessConstants.DAY_LAST_TIME);
        Date beginDate = Tools.parse(beginTime, "yyyy-MM-dd HH:mm:ss");
        Date endDate = Tools.parse(endTime, "yyyy-MM-dd HH:mm:ss");

        PriceReceiptsExample example = new PriceReceiptsExample();
        example.createCriteria()
                .andSupplierIdEqualTo(supplierId)
                .andCreateTimeBetween(beginDate, endDate)
                .andStatusEqualTo(BusinessConstants.BILLS_STATUS_AUDIT)
                .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        //查询当日所有费用
        List<PriceReceipts> priceReceipts = priceReceiptsMapper.selectByExample(example);

        JSONObject jsonObject = new JSONObject();

        //查询入库费用
        addPriceReceiptsToDayVo(jsonObject, "inbound", "寄存入库", priceReceipts);
        //查询出库费用
        addPriceReceiptsToDayVo(jsonObject, "outbound", "销售寄存出库", priceReceipts);
        //查询每日存储费用
        addPriceReceiptsToDayVo(jsonObject, "dailyStorageFees", "每日存储费用", priceReceipts);
        //每月物流费用
        addPriceReceiptsToDayVo(jsonObject, "monthlyLogisticsFees", "每月物流费用", priceReceipts);
        //其他费用
        addPriceReceiptsToDayVo(jsonObject, "otherFees", "其它费用", priceReceipts);

        return jsonObject;
    }

    private void addPriceReceiptsToDayVo(JSONObject jsonObject, String key, String priceType, List<PriceReceipts> priceReceipts) throws Exception {
        List<PriceReceiptsToDayVo> list = new ArrayList<>();
        List<PriceReceipts> filteredList = priceReceipts.stream()
                .filter(item -> priceType.equals(item.getPriceType()))
                .collect(Collectors.toList());

        for (PriceReceipts receipts : filteredList) {
            PriceReceiptsToDayVo priceReceiptsToDayVo = new PriceReceiptsToDayVo();
            priceReceiptsToDayVo.setTotalPrice(receipts.getTotalPrice());//合计

            if (!"每月物流费用".equals(priceType)) {
                List<PriceDetails> priceDetails = priceDetailsMapperEx.selectListByReceiptsNumber(receipts.getReceiptsNumber());
                priceReceiptsToDayVo.setPriceDetails(priceDetails);//费用详情
            }
            if ("寄存入库".equals(priceType) || "销售寄存出库".equals(priceType)) {
                DepotHeadExample headExample = new DepotHeadExample();
                headExample.createCriteria().andNumberEqualTo(receipts.getNumber()).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
                List<DepotHead> depotHeads = depotHeadMapper.selectByExample(headExample);
                DepotHead depotHead = depotHeads.get(0);
                List<DepotItemVo4WithInfoEx> dataList = depotItemService.getDetailList(depotHead.getId().toString());
                priceReceiptsToDayVo.setDepotItemVo4WithInfoExes(dataList);//商品信息
            }
            if ("每月物流费用".equals(priceType)) {
                List<ShippingPrice> shippingPrices = shippingPriceMapperEx.selectShippingPriceByReceiptsNumber(receipts.getReceiptsNumber());
                priceReceiptsToDayVo.setShippingPrices(shippingPrices);//物流费用详情
            }
            list.add(priceReceiptsToDayVo);
        }
        jsonObject.put(key, list);
    }
}


