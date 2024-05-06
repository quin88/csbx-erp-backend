package com.jsh.erp.service.supermarketOrder;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.dto.OrderDetailDTO;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.*;
import com.jsh.erp.datasource.vo.*;
import com.jsh.erp.exception.BusinessRunTimeException;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.log.LogService;
import com.jsh.erp.service.material.MaterialService;
import com.jsh.erp.service.orderDeatil.OrderDetailService;
import com.jsh.erp.service.supermarketSystemConfig.SupermarketSystemConfigService;
import com.jsh.erp.service.supermarketVerificationLogs.SupermarketVerificationLogsService;
import com.jsh.erp.service.user.UserService;
import com.jsh.erp.utils.BaseResponseInfo;
import com.jsh.erp.utils.ExcelUtils;
import com.jsh.erp.utils.StringUtil;
import com.jsh.erp.utils.Tools;
import jxl.Sheet;
import jxl.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

import static com.jsh.erp.utils.ExcelUtils.getContent;

@Service
public class SupermarketOrderService {
    private Logger logger = LoggerFactory.getLogger(SupermarketOrderService.class);
    @Resource
    private LogService logService;
    @Resource
    private SupermarketOrderMapper supermarketOrderMapper;
    @Resource
    private UserService userService;
    @Resource
    private SequenceMapperEx sequenceMapperEx;
    @Resource
    private SupermarketOrderMapperEx supermarketOrderMapperEx;
    @Resource
    private OrderDetailService orderDetailService;
    @Resource
    private OrderDetailMapper orderDetailMapper;
    @Resource
    private MaterialService materialService;
    @Resource
    private OrderDetailMapperEx orderDetailMapperEx;
    @Resource
    private SupermarketSystemConfigService supermarketSystemConfigService;
    @Resource
    private SupermarketSystemConfigMapper supermarketSystemConfigMapper;
    @Resource
    private SupermarketFinanceMapperEx supermarketFinanceMapperEx;
    @Resource
    private SupermarketAddedOrderMapperEx supermarketAddedOrderMapperEx;
    @Resource
    private SupermarketVerificationLogsService supermarketVerificationLogsService;
    @Resource
    private SupermarketVerificationLogsMapperEx supermarketVerificationLogsMapperEx;

    public SupermarketOrder selectOne(Long id) {
        SupermarketOrder result = null;
        try {
            result = supermarketOrderMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public Object addSupermarketOrderAndDetail(String beanJson, String rows, HttpServletRequest request) throws Exception {
        SupermarketOrder supermarketOrder = JSONObject.parseObject(beanJson, SupermarketOrder.class);

        //校验单号是否重复
        if (checkIsNumberNoExist(0L, supermarketOrder.getNumber())) {
            throw new BusinessRunTimeException(ExceptionConstants.NUMBER_IS_EXIST_CODE,
                    String.format(ExceptionConstants.NUMBER_IS_EXIST_MSG));
        }
        Date date = new Date();
        Long userId = userService.getCurrentUser().getId();
        supermarketOrder.setCreator(userId);
        supermarketOrder.setCreateTime(date);
        supermarketOrder.setUpdater(userId);
        supermarketOrder.setUpdateTime(date);
        supermarketOrder.setUploadStatus(BusinessConstants.UPLOAD_STATUS_NO);//默认未上传
        if (StringUtil.isEmpty(supermarketOrder.getStatus())) {
            supermarketOrder.setStatus(BusinessConstants.BILLS_STATUS_UN_AUDIT);
        }
        supermarketOrderMapper.insertSelective(supermarketOrder);

        //根据编号查询id
        Long soIds = supermarketOrderMapperEx.selectIdByNumber(supermarketOrder.getNumber());

        //如果状态为提交审核，记录流程
        if (BusinessConstants.BILLS_STATUS_UN_AUDIT.equals(supermarketOrder.getStatus())) {
            SupermarketVerificationLogs sfl = new SupermarketVerificationLogs();
            sfl.setTitle("订单申请");
            sfl.setNumber(supermarketOrder.getNumber());
            sfl.setStatus(supermarketOrder.getStatus());
            sfl.setTime(date);
            sfl.setUserId(userId);
            sfl.setOrderId(soIds);
            supermarketVerificationLogsService.saveVerificationLogs(sfl, request);
        }
        //更新编号数值
        SupermarketSystemConfig config = supermarketSystemConfigService.getCurrentConfig(BusinessConstants.SUPERMARKET_ORDER_NUMBER_SEQ);
        Integer currentValue = config.getCurrentValue();
        config.setCurrentValue(currentValue + 1); //编号+1
        supermarketSystemConfigMapper.updateByPrimaryKeySelective(config);
        //保存订单详情
        if (rows != null) {
            orderDetailService.saveOrderDetails(rows, soIds, request);
        }
        logService.insertLog("商超订单",
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ADD).append(supermarketOrder.getId()).toString(), request);

        return ExceptionConstants.standardSuccess();
    }

    private boolean checkIsNumberNoExist(Long id, String number) {
        SupermarketOrderExample example = new SupermarketOrderExample();
        example.createCriteria().andIdNotEqualTo(id).andNumberEqualTo(number).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<SupermarketOrder> list = null;
        try {
            list = supermarketOrderMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list != null && !list.isEmpty();
    }

    public List<?> search(Long id, String category, String beginTime, String endTime, String number, String status,
                          String uploadStatus, Long serveClientId, String tradeBeginTime, String tradeEndTime, Long marketAddressId, String linkFlag, int offset, int rows) {

        String[] statusArray = StringUtil.isNotEmpty(status) ? status.split(",") : null;
        String[] uploadStatusArray = StringUtil.isNotEmpty(uploadStatus) ? uploadStatus.split(",") : null;
        String[] categoryArray = StringUtil.isNotEmpty(category) ? category.split(",") : null;
        beginTime = Tools.parseDayToTime(beginTime, BusinessConstants.DAY_FIRST_TIME);
        endTime = Tools.parseDayToTime(endTime, BusinessConstants.DAY_LAST_TIME);
        tradeBeginTime = Tools.parseDayToTime(tradeBeginTime, BusinessConstants.DAY_FIRST_TIME);
        tradeEndTime = Tools.parseDayToTime(tradeEndTime, BusinessConstants.DAY_LAST_TIME);
        List<SupermarketOrderVo> supermarketOrders = supermarketOrderMapperEx.selectSupermarketOrder(id, categoryArray, beginTime, endTime, number,
                statusArray, uploadStatusArray, serveClientId, tradeBeginTime, tradeEndTime, marketAddressId, linkFlag, offset, rows);
        JSONArray soList = new JSONArray();
        supermarketOrders.forEach(order -> {
            JSONObject supermarketOrder = new JSONObject();
            supermarketOrder.put("id", order.getId());
            supermarketOrder.put("openTime", order.getOpenTime());
            supermarketOrder.put("number", order.getNumber());
            supermarketOrder.put("category", order.getCategory());
            supermarketOrder.put("nakedPriceTotal", getFormattedBigDecimal(order.getNakedPriceTotal()));
            supermarketOrder.put("taxInclusiveTotal", getFormattedBigDecimal(order.getTaxInclusiveTotal()));
            supermarketOrder.put("status", order.getStatus());
            supermarketOrder.put("uploadStatus", order.getUploadStatus());
            supermarketOrder.put("remark", order.getRemark());
            supermarketOrder.put("comment", order.getComment());
            supermarketOrder.put("createTime", order.getCreateTime());
            supermarketOrder.put("createdName", order.getCreatedName());
            supermarketOrder.put("verifierTime", order.getVerifierTime());
            supermarketOrder.put("verifierName", order.getVerifierName());
            supermarketOrder.put("tradeTime", order.getTradeTime());
            supermarketOrder.put("linkId", order.getLinkId());
            supermarketOrder.put("linkNumber", order.getLinkNumber());
            supermarketOrder.put("marketAddress", order.getMarketAddress());
            supermarketOrder.put("differenceTotal", order.getDifferenceTotal());
            supermarketOrder.put("linkedDifferenceTotal", order.getLinkedDifferenceTotal());

            // 获取订单详情
            Long orderId = order.getId();
            List<OrderDetailVo> orderDetails = findBySelect(orderId.toString());
            supermarketOrder.put("orderDetails", orderDetails);

            soList.add(supermarketOrder);
        });
        return soList;
    }

    private BigDecimal getFormattedBigDecimal(BigDecimal value) {
        return value != null ? value.setScale(2, RoundingMode.HALF_UP) : BigDecimal.ZERO;
    }

    public Long counts(Long id, String category, String beginTime, String endTime, String number, String status, String uploadStatus,
                       Long serveClientId, String tradeBeginTime, String tradeEndTime, Long marketAddressId, String linkFlag) {
        Long result = null;
        String[] statusArray = StringUtil.isNotEmpty(status) ? status.split(",") : null;
        String[] uploadStatusArray = StringUtil.isNotEmpty(uploadStatus) ? uploadStatus.split(",") : null;
        String[] categoryArray = StringUtil.isNotEmpty(category) ? category.split(",") : null;
        beginTime = Tools.parseDayToTime(beginTime, BusinessConstants.DAY_FIRST_TIME);
        endTime = Tools.parseDayToTime(endTime, BusinessConstants.DAY_LAST_TIME);
        try {
            result = supermarketOrderMapperEx.countSupermarketOrder(id, categoryArray, beginTime, endTime, number, statusArray, uploadStatusArray,
                    serveClientId, tradeBeginTime, tradeEndTime, marketAddressId, linkFlag);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public Object updateSupermarketOrderAndDetail(String beanJson, String rows, HttpServletRequest request) throws Exception {
        SupermarketOrder supermarketOrder = JSONObject.parseObject(beanJson, SupermarketOrder.class);

        //校验单号是否重复
        if (checkIsNumberNoExist(supermarketOrder.getId(), supermarketOrder.getNumber())) {
            throw new BusinessRunTimeException(ExceptionConstants.NUMBER_IS_EXIST_CODE,
                    String.format(ExceptionConstants.NUMBER_IS_EXIST_MSG));
        }
        //校验审核状态，如何不是未审核或者驳回则提示
        String status = selectOne(supermarketOrder.getId()).getStatus();
        if (BusinessConstants.BILLS_STATUS_AUDIT.equals(status) || BusinessConstants.BILLS_STATUS_UNDER_REVIEW.equals(status)) {
            throw new BusinessRunTimeException(ExceptionConstants.SUPERMARKET_ORDER_CANNOT_EDIT_CODE,
                    String.format(ExceptionConstants.SUPERMARKET_ORDER_CANNOT_EDIT_MSG));
        }
        Date date = new Date();
        User userInfo = userService.getCurrentUser();
        Long userId = userInfo.getId();
        supermarketOrder.setUpdater(userId);
        supermarketOrder.setUpdateTime(date);
        if (StringUtil.isEmpty(supermarketOrder.getStatus())) {
            supermarketOrder.setStatus(BusinessConstants.BILLS_STATUS_UN_AUDIT);
        }
        supermarketOrderMapper.updateByPrimaryKeySelective(supermarketOrder);
        //如果状态为保存并审核，记录流程
        if (BusinessConstants.BILLS_STATUS_UN_AUDIT.equals(supermarketOrder.getStatus())) {
            SupermarketVerificationLogs sfl = new SupermarketVerificationLogs();
            sfl.setTitle("订单申请");
            sfl.setOrderId(supermarketOrder.getId());
            sfl.setNumber(supermarketOrder.getNumber());
            sfl.setStatus(supermarketOrder.getStatus());
            sfl.setTime(date);
            sfl.setUserId(userId);
            supermarketVerificationLogsService.saveVerificationLogs(sfl, request);
        }
        //根据编号查询id
        Long soIds = supermarketOrderMapperEx.selectIdByNumber(supermarketOrder.getNumber());
        //保存订单详情
        if (rows != null) {
            orderDetailService.saveOrderDetails(rows, soIds, request);
        }
        logService.insertLog("商超订单",
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(supermarketOrder.getId()).toString(), request);

        return ExceptionConstants.standardSuccess();
    }

    public JSONObject findByCondition(Long id, Long supplierId, Long accountId) {

        JSONObject supermarketOrder = new JSONObject();
        SupermarketOrderVo order = supermarketOrderMapperEx.selectSupermarketOrderById(id);
        supermarketOrder.put("id", order.getId());
        supermarketOrder.put("openTime", order.getOpenTime());
        supermarketOrder.put("number", order.getNumber());
        supermarketOrder.put("category", order.getCategory());
        supermarketOrder.put("status", order.getStatus());
        supermarketOrder.put("uploadStatus", order.getUploadStatus());
        supermarketOrder.put("remark", order.getRemark());
        supermarketOrder.put("comment", order.getComment());
        supermarketOrder.put("createTime", order.getCreateTime());
        supermarketOrder.put("createdName", order.getCreatedName());
        supermarketOrder.put("verifierTime", order.getVerifierTime());
        supermarketOrder.put("verifierName", order.getVerifierName());
        supermarketOrder.put("tradeTime", order.getTradeTime());
        supermarketOrder.put("serveClientId", order.getServeClientId());
        supermarketOrder.put("serveClientName", order.getServeClientName());
        supermarketOrder.put("tax", order.getTax());
        supermarketOrder.put("marketAddressId", order.getMarketAddressId());
        supermarketOrder.put("marketAddress", order.getMarketAddress());
        supermarketOrder.put("linkId", order.getLinkId());
        supermarketOrder.put("linkNumber", order.getLinkNumber());
        supermarketOrder.put("differenceTotal", order.getDifferenceTotal());
        supermarketOrder.put("linkedDifferenceTotal", order.getLinkedDifferenceTotal());
        // 获取订单详情
        List<OrderDetailVo> orderDetails = orderDetailMapperEx.findByCondition(id, supplierId, accountId);
        //处理小计金额
        BigDecimal nakedPriceTotal = BigDecimal.ZERO; // 裸价总计
        BigDecimal taxInclusiveTotal = BigDecimal.ZERO; // 税后总计

        JSONArray dataArray = new JSONArray();
        for (OrderDetailVo orderDetail : orderDetails) {
            nakedPriceTotal = nakedPriceTotal.add(orderDetail.getNakedPrice());
            taxInclusiveTotal = taxInclusiveTotal.add(orderDetail.getTaxNakedPrice());
            JSONObject supplierList = new JSONObject();
            supplierList.put("accountId", orderDetail.getAccountId());
            supplierList.put("account", orderDetail.getAccountName());
            if (!dataArray.contains(supplierList)) {
                dataArray.add(supplierList);
            }
        }

        supermarketOrder.put("nakedPriceTotal", getFormattedBigDecimal(nakedPriceTotal));
        supermarketOrder.put("taxInclusiveTotal", getFormattedBigDecimal(taxInclusiveTotal));
        supermarketOrder.put("orderDetails", orderDetails);
        supermarketOrder.put("accountList", dataArray);
        return supermarketOrder;
    }

    public int deleteSupermarketOrder(Long id, HttpServletRequest request) throws Exception {
        return batchDeleteSupermarketOrderByIds(id.toString());
    }

    public int batchDeleteSupermarketOrder(String ids, HttpServletRequest request) throws Exception {
        return batchDeleteSupermarketOrderByIds(ids);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteSupermarketOrderByIds(String ids) throws Exception {
        int result = 0;
        String[] idArray = ids.split(",");
        //记录日志
        StringBuffer sb = new StringBuffer();
        sb.append(BusinessConstants.LOG_OPERATION_TYPE_DELETE);
        List<SupermarketOrder> list = getSupermarketOrdersByIds(ids);
        for (SupermarketOrder order : list) {
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
        User userInfo = userService.getCurrentUser();
        //执行删除操作
        try {
            result = supermarketOrderMapperEx.batchDeleteSupermarketOrderByIds(new Date(), userInfo == null ? null : userInfo.getId(), idArray);
            logService.insertLog("商超订单", ids,
                    ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
            //删除订单详情信息
            orderDetailService.batchDeleteOrderDetails(idArray);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    private List<SupermarketOrder> getSupermarketOrdersByIds(String ids) {
        List<Long> idList = StringUtil.strToLongList(ids);
        List<SupermarketOrder> list = null;
        SupermarketOrderExample example = new SupermarketOrderExample();
        example.createCriteria().andIdIn(idList);
        try {
            list = supermarketOrderMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Transactional(value = "transactionManager", rollbackFor = {Exception.class, BusinessRunTimeException.class})
    public int batchSetStatus(String status, Long id, String comment, List<OrderDetailDTO> orderDetailDTOS,
                              HttpServletRequest request) throws Exception {
        // 检查修改的审核状态是否符合逻辑
        Map<String, List<String>> statusRules = getStatusRules();
        SupermarketOrder supermarketOrder = supermarketOrderMapper.selectByPrimaryKey(id);
        String soStatus = supermarketOrder.getStatus();
        if (!(statusRules.containsKey(status) && statusRules.get(status).contains(soStatus))) {
            // 如果状态不符合规则，抛出异常
            throw new BusinessRunTimeException(ExceptionConstants.UPDATE_STATUS_FAILED_CODE,
                    ExceptionConstants.UPDATE_STATUS_FAILED_MSG);
        }
        // 设置订单的审核状态、审核人、审核时间、备注
        Long userId = userService.getCurrentUser().getId();
        Date date = new Date();
        supermarketOrder.setStatus(status);
        supermarketOrder.setVerifier(userId);
        supermarketOrder.setVerifierTime(date);
        supermarketOrder.setComment(comment);

        // 如果状态为部分审核，更新差额和订单详情
        BigDecimal differenceTotal = BigDecimal.ZERO;
        if (BusinessConstants.SUPERMARKET_ORDER_STATUS_PORTION.equals(status)) {
            for (OrderDetailDTO orderDetailDTO : orderDetailDTOS) {
                orderDetailService.updateOrderDetailDifference(orderDetailDTO);
                differenceTotal = differenceTotal.add(orderDetailDTO.getDifference());
            }
            supermarketOrder.setInitialDifference(differenceTotal);
            supermarketOrder.setDifferenceTotal(differenceTotal);
        }

        // 如果为部分审核，更新关联订单
        if ((BusinessConstants.SUPERMARKET_ORDER_STATUS_PORTION.equals(status) ||
                BusinessConstants.BILLS_STATUS_AUDIT.equals(status))
                && supermarketOrder.getLinkId() != null) {
            BigDecimal relatedDifferenceTotal = supermarketOrderMapper.selectByPrimaryKey(supermarketOrder.getLinkId()).getDifferenceTotal();
            //获取当前订单补额
            BigDecimal saTotal = orderDetailMapperEx.getSupplementaryAmountTotalById(supermarketOrder.getId());
            relatedDifferenceTotal = relatedDifferenceTotal.subtract(saTotal);

            SupermarketOrder relatedOrder = new SupermarketOrder();
            relatedOrder.setId(supermarketOrder.getLinkId());
            relatedOrder.setDifferenceTotal(relatedDifferenceTotal);
            if (relatedDifferenceTotal.compareTo(BigDecimal.ZERO) <= 0) {
                relatedOrder.setStatus(BusinessConstants.BILLS_STATUS_AUDIT);
            }
            supermarketOrderMapper.updateByPrimaryKeySelective(relatedOrder);
        }
        // 更新当前商超订单
        int result = supermarketOrderMapper.updateByPrimaryKeySelective(supermarketOrder);
        //如果状态为部分审核、审核或驳回，记录流程
        if (BusinessConstants.BILLS_STATUS_AUDIT.equals(status) ||
                BusinessConstants.SUPERMARKET_ORDER_STATUS_PORTION.equals(status) ||
                BusinessConstants.BILLS_STATUS_REJECT.equals(status)) {
            SupermarketVerificationLogs sfl = new SupermarketVerificationLogs();
            sfl.setTitle("订单审核");
            sfl.setNumber(supermarketOrder.getNumber());
            sfl.setStatus(supermarketOrder.getStatus());
            sfl.setTime(date);
            sfl.setOrderId(id);
            sfl.setUserId(userId);
            sfl.setComment(comment);
            supermarketVerificationLogsService.saveVerificationLogs(sfl, request);
        }
        // 记录日志
        logService.insertLog("商超订单", BusinessConstants.LOG_OPERATION_TYPE_ENABLED,
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

    @Transactional(value = "transactionManager", rollbackFor = {Exception.class, BusinessRunTimeException.class})
    public BaseResponseInfo importExcel(MultipartFile file, HttpServletRequest request) {

        BaseResponseInfo info = new BaseResponseInfo();
        try {
            Workbook workbook = Workbook.getWorkbook(file.getInputStream());
            Sheet src = workbook.getSheet(0);
            int rightRows = ExcelUtils.getRightRows(src);

            //创建一个商超订单
            SupermarketOrder supermarketOrder = new SupermarketOrder();
            String number = supermarketSystemConfigService.buildNumber(BusinessConstants.DEPOT_NUMBER_SEQ, 6, request);
            User userInfo = userService.getCurrentUser();
            String firstAquaticType = getContent(src, 2, 4);// 获取第一个水产类型

            supermarketOrder.setCategory(firstAquaticType);
            supermarketOrder.setCreator(userInfo == null ? null : userInfo.getId());
            supermarketOrder.setCreateTime(new Date());
            supermarketOrder.setUpdater(userInfo == null ? null : userInfo.getId());
            supermarketOrder.setUpdateTime(new Date());
            String longNumber = "CYSCGL-AAA" + number;//拼接前缀
            supermarketOrder.setNumber(longNumber);
            supermarketOrder.setOpenTime(new Date());
            supermarketOrder.setStatus(BusinessConstants.BILLS_STATUS_DRAFT);//默认草稿状态
            supermarketOrder.setUploadStatus(BusinessConstants.UPLOAD_STATUS_NO);//默认未上传
            if (StringUtil.isEmpty(supermarketOrder.getStatus())) {
                supermarketOrder.setStatus(BusinessConstants.BILLS_STATUS_UN_AUDIT);
            }
            supermarketOrderMapper.insertSelective(supermarketOrder);
            //更新编号表数值
            sequenceMapperEx.updateBuildOnlyNumber(BusinessConstants.SUPERMARKET_ORDER_NUMBER_SEQ); //编号+1
            //根据编号查询id
            Long soIds = supermarketOrderMapperEx.selectIdByNumber(longNumber);

            //文件扩展名只能为xls
            String fileName = file.getOriginalFilename();
            if (StringUtil.isNotEmpty(fileName)) {
                String fileExt = fileName.substring(fileName.indexOf(".") + 1);
                if (!("xls".equals(fileExt) || "xlsx".equals(fileExt))) {
                    throw new BusinessRunTimeException(ExceptionConstants.MATERIAL_EXTENSION_ERROR_CODE,
                            ExceptionConstants.MATERIAL_EXTENSION_ERROR_MSG);
                }
            }
            List<OrderDetail> orderDetails = new ArrayList<>();
            BigDecimal nakedPriceTotal = BigDecimal.ZERO; // 裸价总计
            BigDecimal taxInclusiveTotal = BigDecimal.ZERO; // 税后总计
            for (int i = 2; i < rightRows; i++) {
                OrderDetail order = new OrderDetail();

                String quantityStr = getContent(src, i, 6);//供货数量
                BigDecimal quantity = materialService.parseBigDecimalEx(quantityStr);
                String unitPriceStr = getContent(src, i, 8);//商品裸价
                BigDecimal unitPrice = materialService.parseBigDecimalEx(unitPriceStr);
                String nakedPriceStr = getContent(src, i, 9);//裸价小计
                BigDecimal nakedPrice = materialService.parseBigDecimalEx(nakedPriceStr);
                String taxUnitPriceStr = getContent(src, i, 10);//税后单价
                BigDecimal taxUnitPrice = materialService.parseBigDecimalEx(taxUnitPriceStr);
                String taxNakedPriceStr = getContent(src, i, 11);//税后小计
                BigDecimal taxNakedPrice = materialService.parseBigDecimalEx(taxNakedPriceStr);

                order.setOrderId(soIds);
                order.setSupplierId(StringUtil.parseStrLong(getContent(src, i, 0))); //供应商id
                order.setMaterialId(StringUtil.parseStrLong(getContent(src, i, 2)));//商品id
                order.setAquaticType(getContent(src, i, 4));//水产类型
                order.setOriginSource(getContent(src, i, 5));//货品源头
                order.setQuantity(quantity);
                order.setUnit(getContent(src, i, 7));//单位
                order.setUnitPrice(unitPrice);
                order.setNakedPrice(nakedPrice);
                order.setTaxUnitPrice(taxUnitPrice);
                order.setTaxNakedPrice(taxNakedPrice);
                order.setAccountId(StringUtil.parseStrLong(getContent(src, i, 12)));//供应商收款账户id
                order.setBankName(getContent(src, i, 14)); //开户银行名称
                order.setAccountName(getContent(src, i, 15));//账户名称

                nakedPriceTotal = nakedPriceTotal.add(nakedPrice);
                taxInclusiveTotal = taxInclusiveTotal.add(taxNakedPrice);

                orderDetails.add(order);
            }
            for (OrderDetail orderDetail : orderDetails) {
                orderDetailMapper.insertSelective(orderDetail);
            }
            //修改裸价合计，含税合计
            supermarketOrder.setId(soIds);
            supermarketOrder.setNakedPriceTotal(nakedPriceTotal);
            supermarketOrder.setTaxInclusiveTotal(taxInclusiveTotal);
            supermarketOrderMapper.updateByPrimaryKeySelective(supermarketOrder);

            logService.insertLog("商超订单",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_IMPORT).append(orderDetails.size()).append(BusinessConstants.LOG_DATA_UNIT).toString(),
                    ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
            info.code = 200;
            info.data = "导入成功";
        } catch (BusinessRunTimeException e) {
            info.code = e.getCode();
            info.data = e.getData().get("message");
        } catch (Exception e) {
            e.printStackTrace();
            info.code = 500;
            info.data = "导入失败";
        }
        return info;
    }

    public List<OrderDetailVo> findBySelect(String ids) {
        String[] idArray = (ids != null) ? ids.split(",") : null;
        return orderDetailMapperEx.findBySelect(idArray);
    }

    public File exportExcel(List<OrderDetailVo> dataList) throws Exception {
        String[] names = {"*单据编号", "*供应商名称", "商品名称", "水产类型", "货品源头", "供货数量", "单位", "商品裸价",
                "裸价小计金额", "税后单价", "税后小计金额", "供应商收款账户", "开户行", "户名"};
        String title = "商超订单";
        List<String[]> objects = new ArrayList<String[]>();
        if (null != dataList) {
            for (OrderDetailVo o : dataList) {
                String[] objs = new String[20];
                objs[0] = o.getNumber();
                objs[1] = o.getSupplier();
                objs[2] = o.getMaterial();
                objs[3] = o.getAquaticType();
                objs[4] = o.getOriginSource();
                objs[5] = o.getQuantity() == null ? "" : o.getQuantity().setScale(2, RoundingMode.HALF_UP).toString();
                objs[6] = o.getUnit();
                objs[7] = o.getUnitPrice() == null ? "" : o.getUnitPrice().setScale(2, RoundingMode.HALF_UP).toString();
                objs[8] = o.getNakedPrice() == null ? "" : o.getNakedPrice().setScale(2, RoundingMode.HALF_UP).toString();
                objs[9] = o.getTaxUnitPrice() == null ? "" : o.getTaxUnitPrice().setScale(2, RoundingMode.HALF_UP).toString();
                objs[10] = o.getTaxNakedPrice() == null ? "" : o.getTaxNakedPrice().setScale(2, RoundingMode.HALF_UP).toString();
                objs[11] = o.getAccountNumber();
                objs[12] = o.getBankName();
                objs[13] = o.getAccountName();
                objs[14] = o.getSupplyingZeroName();
                objs[15] = o.getSupplyingZeroNumber();
                objects.add(objs);
            }
        }
        return ExcelUtils.exportObjectsWithoutTitle(title, "*导入时本行内容请勿删除，切记！", names, title, objects);
    }

    public JSONArray getProcess(Long orderId, Long sfId, String type, HttpServletRequest request) {
        JSONArray array = new JSONArray();

        List<SupermarketVerificationLogsVo> svls = supermarketVerificationLogsMapperEx.selectVerificationLogsById(orderId, sfId);
        if (svls.size() > 0) {
            for (SupermarketVerificationLogsVo svl : svls) {
                JSONObject ob = new JSONObject();
                ob.put("title", svl.getTitle());
                ob.put("status", svl.getStatus());
                ob.put("time", svl.getTime());
                ob.put("number", svl.getNumber());
                ob.put("name", svl.getName());
                ob.put("comment", svl.getComment());
                array.add(ob);
            }
        }

        if (type.equals("order")) {
            // 获取财务信息
            SupermarketFinanceVo sfVo = supermarketFinanceMapperEx.selectSupermarketFinanceByOrderId(orderId, sfId);
            if (sfVo != null) {
                //付款凭证
                String payStatus = sfVo.getPayStatus();
                if (!BusinessConstants.SUPERMARKET_FINANCE_PAY_STATUS_UN_AUDIT.equals(payStatus)) {//部分付款或已付款
                    JSONObject ob = new JSONObject();
                    ob.put("title", "付款凭证");
                    ob.put("status", payStatus);
                    ob.put("time", sfVo.getUploadTime());
                    ob.put("number", sfVo.getNumber());
                    ob.put("name", sfVo.getUploaderName());
                    ob.put("linkId", sfVo.getId());
                    array.add(ob);
                }

                //结款
                if (!BusinessConstants.SUPERMARKET_FINANCE_PAYMENT_STATUS_UN_AUDIT.equals(sfVo.getPaymentStatus())) {
                    JSONObject ob = new JSONObject();
                    ob.put("title", "结款");
                    ob.put("status", sfVo.getPaymentStatus());
                    ob.put("time", sfVo.getPaymentDate());
                    ob.put("number", sfVo.getNumber());
                    ob.put("name", sfVo.getPaymenterName());
                    array.add(ob);
                }
            }
        }
        return array;
    }

    public JSONObject getDifferenceDetail(Long linkId, HttpServletRequest request) {

        SupermarketOrder supermarketOrder = supermarketOrderMapper.selectByPrimaryKey(linkId);

        //初始差额
        BigDecimal initialDifference = supermarketOrder.getInitialDifference();
        //当前差额
        BigDecimal differenceTotal = supermarketOrder.getDifferenceTotal();
        //订单补额
        List<SupermarketOrderDifferenceDetailVo> order = supermarketOrderMapperEx.getDifferenceDetail(linkId);
        //个人补单
        List<SupermarketOrderDifferenceDetailVo> addOrder = supermarketAddedOrderMapperEx.getDifferenceDetail(linkId);
        // 合并两个列表
        List<SupermarketOrderDifferenceDetailVo> combinedList = new ArrayList<>(order);
        combinedList.addAll(addOrder);

        // 根据 updateTime 进行升序排序
        combinedList.sort(Comparator.comparing(SupermarketOrderDifferenceDetailVo::getUpdateTime));

        // 创建 JSONObject 对象存储结果
        JSONObject resultObject = new JSONObject();
        resultObject.put("initialDifference", initialDifference);
        resultObject.put("differenceTotal", differenceTotal);
        resultObject.put("differenceDetail", combinedList);

        return resultObject;
    }
}
