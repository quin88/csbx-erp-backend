package com.jsh.erp.service.supermarketMaterial;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.dto.InvoiceNumberDTO;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.*;
import com.jsh.erp.datasource.vo.*;
import com.jsh.erp.exception.BusinessRunTimeException;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.fileInfo.FileInfoService;
import com.jsh.erp.service.imageInfo.ImageInfoService;
import com.jsh.erp.service.invoice.InvoiceService;
import com.jsh.erp.service.log.LogService;
import com.jsh.erp.service.salesInfo.SalesInfoService;
import com.jsh.erp.service.salesMarket.SalesMarketService;
import com.jsh.erp.service.sequence.SequenceService;
import com.jsh.erp.service.user.UserService;
import com.jsh.erp.utils.BaseResponseInfo;
import com.jsh.erp.utils.ExcelUtils;
import com.jsh.erp.utils.StringUtil;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
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
import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class SupermarketMaterialService {

    private Logger logger = LoggerFactory.getLogger(SupermarketMaterialService.class);
    @Resource
    private SupermarketMaterialMapper supermarketMaterialMapper;
    @Resource
    private SupermarketMaterialMapperEx supermarketMaterialMapperEx;
    @Resource
    private LogService logService;
    @Resource
    private UserService userService;
    @Resource
    private SalesMarketService salesMarketService;
    @Resource
    private SalesInfoService salesInfoService;
    @Resource
    private InvoiceService invoiceService;
    @Resource
    private ImageInfoService imageInfoService;
    @Resource
    private OrderDetailMapperEx orderDetailMapperEx;
    @Resource
    private FileInfoService fileInfoService;
    @Resource
    private FileInfoMapperEx fileInfoMapperEx;
    @Resource
    private FileInfoMapper fileInfoMapper;
    @Value(value = "${file.path}")
    private String filePath;

    @Resource
    private SequenceMapperEx sequenceMapperEx;

    @Resource
    private SequenceService sequenceService;

    public SupermarketMaterialVo getSupermarketMaterial(Long id) {
        SupermarketMaterialVo result = null;
        try {
            result = supermarketMaterialMapperEx.selectByPrimaryKey(id);
            FileInfoExample example = new FileInfoExample();
            example.createCriteria().andBaseInfoIdEqualTo(id);
            List<FileInfo> fileInfos = fileInfoMapper.selectByExample(example);
            result.setFileInfos(fileInfos);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    public List<SupermarketMaterial> getSupermarketMaterialListByIds(String ids) {
        List<Long> idList = StringUtil.strToLongList(ids);
        List<SupermarketMaterial> list = null;
        SupermarketMaterialExample example = new SupermarketMaterialExample();
        example.createCriteria().andIdIn(idList);
        try {
            list = supermarketMaterialMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<SupermarketMaterialVoList> select(Long supplierId, Long categoryId, Long secondCategoryId, Long thirdCategoryId, String materialParam,
                                                  String temperatureCondition, String aquaticType, String status, int offset, int rows) {
        List<SupermarketMaterialVoList> list = null;
        String[] statusArray = StringUtil.isNotEmpty(status) ? status.split(",") : null;
        try {
            list = supermarketMaterialMapperEx.selectByConditionSupermarketMaterial(supplierId, categoryId, secondCategoryId, thirdCategoryId,
                    materialParam, temperatureCondition, aquaticType, statusArray, offset, rows);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public Long countSupermarketMaterial(Long supplierId, Long categoryId, Long secondCategoryId, Long thirdCategoryId, String materialParam,
                                         String temperatureCondition, String aquaticType, String status) {
        Long result = null;
        String[] statusArray = StringUtil.isNotEmpty(status) ? status.split(",") : null;
        try {
            result = supermarketMaterialMapperEx.countBySupermarketMaterial(supplierId, categoryId, secondCategoryId, thirdCategoryId,
                    materialParam, temperatureCondition, aquaticType, statusArray);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertSupermarketMaterial(JSONObject obj, HttpServletRequest request) throws Exception {
        SupermarketMaterial supermarketMaterial = JSONObject.parseObject(obj.toJSONString(), SupermarketMaterial.class);
        JSONArray fileInfos = obj.getJSONArray("fileInfos");

        //校验商品编码
        SupermarketMaterialExample example = new SupermarketMaterialExample();
        example.createCriteria().andNumberEqualTo(supermarketMaterial.getNumber()).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<SupermarketMaterial> list = supermarketMaterialMapper.selectByExample(example);
        if (!list.isEmpty()) {
            throw new BusinessRunTimeException(ExceptionConstants.NUMBER_IS_EXIST_CODE, ExceptionConstants.NUMBER_IS_EXIST_MSG);
        }

        Timestamp currentTime = new Timestamp(System.currentTimeMillis());

        int result = 0;
        User userInfo = userService.getCurrentUser();
        supermarketMaterial.setEnabled(false);
        supermarketMaterial.setCreateTime(currentTime);
        supermarketMaterial.setCreator(userInfo == null ? null : userInfo.getId());
        supermarketMaterial.setUpdateTime(currentTime);
        supermarketMaterial.setUpdater(userInfo == null ? null : userInfo.getId());
        try {
            result = supermarketMaterialMapper.insertSelective(supermarketMaterial);
            list = supermarketMaterialMapper.selectByExample(example);
            Long id = list.stream().findFirst().get().getId();
            if (fileInfos != null) {
                for (int i = 0; i < fileInfos.size(); i++) {
                    JSONObject fileInfoObj = fileInfos.getJSONObject(i);
                    FileInfo fileInfo = new FileInfo();
                    fileInfo.setBaseInfoId(id);
                    fileInfo.setFilePath(fileInfoObj.getString("filePath"));
                    fileInfoMapper.insertSelective(fileInfo);
                }
            }
            //商品编码加一
            sequenceMapperEx.updateBuildOnlyNumber(BusinessConstants.SUPERMARKET_MATERIAL_NUMBER_SEQ); //编号+1
            logService.insertLog("商超商品",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ADD).append(supermarketMaterial.getName()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateSupermarketMaterial(JSONObject obj, HttpServletRequest request) throws Exception {
        SupermarketMaterial supermarketMaterial = JSONObject.parseObject(obj.toJSONString(), SupermarketMaterial.class);
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());

        JSONArray fileInfos = obj.getJSONArray("fileInfos");
        int result = 0;
        User userInfo = userService.getCurrentUser();
        supermarketMaterial.setUpdateTime(currentTime);
        supermarketMaterial.setUpdater(userInfo == null ? null : userInfo.getId());
        try {
            result = supermarketMaterialMapper.updateByPrimaryKey(supermarketMaterial);
            Long id = supermarketMaterial.getId();
            List<FileInfo> fileInfoList = new ArrayList<>();
            if (fileInfos != null) {
                for (int i = 0; i < fileInfos.size(); i++) {
                    JSONObject fileInfoObj = fileInfos.getJSONObject(i);
                    FileInfo fileInfo = new FileInfo();
                    fileInfo.setBaseInfoId(id);
                    fileInfo.setFilePath(fileInfoObj.getString("filePath"));
                    fileInfoList.add(fileInfo);
                }
                fileInfoService.saveFileInfoList(null, id, fileInfoList);
            }
            logService.insertLog("商超商品",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(supermarketMaterial.getName()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void addSupermarketMaterialDetail(Long materialId, List<SalesMarket> salesMarketList, List<SalesInfo> salesInfoList,
                                             List<InvoiceNumber> invoiceList, List<InvoiceNumberDTO> invoiceLists, List<Long> fileIds,
                                             List<ImageInfo> imageInfoList, List<FileInfo> fileInfoList, HttpServletRequest request) throws Exception {
        //1.保存销售市场信息
        salesMarketService.savesSalesMarketList(materialId, salesMarketList);
        //2.保存销售信息
        salesInfoService.saveSalesInfoList(materialId, salesInfoList);
        //3.保存发票单据信息
        invoiceService.saveInvoiceList(materialId, invoiceList);
        //处理发票中的附件数据
        invoiceService.saveFileInfoDetails(fileIds, invoiceLists);
        //4.保存图片信息
        imageInfoService.saveImageInfoList(materialId, imageInfoList);
        //5.保存附件信息
        fileInfoService.saveFileInfoList(materialId, null, fileInfoList);
    }

    /**
     * 批量启用-禁用
     *
     * @param enabled
     * @param ids
     * @return
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchSetEnabled(Boolean enabled, String ids) throws Exception {
        List<Long> idList = StringUtil.strToLongList(ids);
        User userInfo = userService.getCurrentUser();

        if (enabled) {
            for (Long id : idList) {
                SupermarketMaterial material = supermarketMaterialMapper.selectByPrimaryKey(id);
                if (!Objects.equals(material.getStatus(), "1")) {
                    throw new BusinessRunTimeException(ExceptionConstants.SUPERMARKET_SUPPLIER_UPDATE_ENABLE_TRUE_FAILED_CODE, String.format(ExceptionConstants.SUPERMARKET_SUPPLIER_UPDATE_ENABLE_TRUE_FAILED_CODE_MSG, material.getName()));
                }
            }
        }
        int result = 0;
        SupermarketMaterial supplier = new SupermarketMaterial();
        supplier.setEnabled(enabled);
        supplier.setUpdater(userInfo == null ? null : userInfo.getId());
        supplier.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        SupermarketMaterialExample example = new SupermarketMaterialExample();
        example.createCriteria().andIdIn(idList);

        try {
            result = supermarketMaterialMapper.updateByExampleSelective(supplier, example);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteSupermarketMaterial(Long id, HttpServletRequest request) throws Exception {
        return batchDeleteSupermarketMaterialByIds(id.toString());
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteSupermarketMaterial(String ids, HttpServletRequest request) throws Exception {
        return batchDeleteSupermarketMaterialByIds(ids);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteSupermarketMaterialByIds(String ids) throws Exception {
        int result = 0;
        List<Long> idList = StringUtil.strToLongList(ids);
        //校验订单明细表
        List<OrderDetail> orderDetailList = null;
        try {
            orderDetailList = orderDetailMapperEx.getOrderDetailListByMaterialIds(idList);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        if (orderDetailList != null && orderDetailList.size() > 0) {
            logger.error("异常码[{}],异常提示[{}],参数,MaterialIds[{}]",
                    ExceptionConstants.DELETE_FORCE_CONFIRM_CODE, ExceptionConstants.DELETE_FORCE_CONFIRM_MSG, ids);
            throw new BusinessRunTimeException(ExceptionConstants.DELETE_FORCE_CONFIRM_CODE,
                    ExceptionConstants.DELETE_FORCE_CONFIRM_MSG);
        }

        //校验商品状态
        List<SupermarketMaterial> list = getSupermarketMaterialListByIds(ids);
        for (SupermarketMaterial material : list) {
            String status = material.getStatus();
            if (status.equals("1") || status.equals("9")) {
                throw new BusinessRunTimeException(ExceptionConstants.SUPERMARKET_MATERIAL_UN_AUDIT_DELETE_FAILED_CODE, ExceptionConstants.SUPERMARKET_MATERIAL_UN_AUDIT_DELETE_FAILED_MSG);
            }
        }

        //记录日志
        StringBuffer sb = new StringBuffer();
        sb.append(BusinessConstants.LOG_OPERATION_TYPE_DELETE);
        for (SupermarketMaterial material : list) {
            sb.append("[").append(material.getName()).append("]");
        }
        User userInfo = userService.getCurrentUser();
        try {
            result = supermarketMaterialMapperEx.batchDeleteSupermarketMaterialByIds(new Date(), userInfo == null ? null : userInfo.getId(), idList);
            logService.insertLog("商超产品", sb.toString(),
                    ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
            //删除商品基础资料
            batchDeleteSupermarketMaterialDetails(idList);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void batchDeleteSupermarketMaterialDetails(List<Long> idList) throws Exception {
        //删除销售市场信息
        salesMarketService.batchDeleteSalesMarketByMaterialIds(idList);
        //删除销售信息
        salesInfoService.batchDeleteSalesInfoByMaterialIds(idList);
        //删除发票单据
        invoiceService.batchDeleteInvoiceByMaterialIds(idList);
        //删除图片
        imageInfoService.batchDeleteImageInfoByMaterialIds(idList);
        //删除附件
        fileInfoService.batchDeleteFileInfoByMaterialIds(idList);
    }


    public List<SupermarketMaterialVoList> findBySelect(Long supplierId, String materialParam, String temperatureCondition, String province, String city, String county, String aquaticType, Integer offset, Integer rows) {
        List<SupermarketMaterialVoList> list = null;
        try {
            list = supermarketMaterialMapperEx.findBySelect(supplierId, materialParam, temperatureCondition, province, city, county, aquaticType, offset, rows);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }


    public int findBySelectCount(Long supplierId, String materialParam, String temperatureCondition, String province, String city, String county, String aquaticType) {
        int result = 0;
        try {
            result = supermarketMaterialMapperEx.findBySelectCount(supplierId, materialParam, temperatureCondition, province, city, county, aquaticType);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    public JSONObject findMaterialDetails(Long materialId) {
        JSONObject data = new JSONObject();

        List<SalesMarket> salesMarketList = salesMarketService.findSalesMarketListByMaterialId(materialId);
        List<SalesInfo> salesInfoList = salesInfoService.findSalesInfoListByMaterialId(materialId);
        List<InvoiceNumber> invoiceList = invoiceService.findInvoiceListByMaterialId(materialId);
        List<ImageInfo> imageInfoList = imageInfoService.findImageInfoListByMaterialId(materialId);
        List<FileInfo> fileInfoList = fileInfoService.findFileInfoListByMaterialId(materialId);
        //获取所有的批次号id
        JSONArray dataArray = new JSONArray();
        if (invoiceList != null && invoiceList.size() > 0) {
            for (InvoiceNumber invoiceNumber : invoiceList) {
                List<FileInfo> list = fileInfoService.findFileInfoListByInvoiceNumberId(invoiceNumber.getId());
                JSONObject item = new JSONObject();
                item.put("id", invoiceNumber.getId());
                item.put("materialId", invoiceNumber.getMaterialId());
                item.put("batchNumber", invoiceNumber.getBatchNumber());
                item.put("remark", invoiceNumber.getRemark());
                item.put("fileInfoList", list);
                dataArray.add(item);
            }
        }
        data.put("salesMarketList", salesMarketList);
        data.put("salesInfoList", salesInfoList);
        data.put("invoiceList", dataArray);
        data.put("imageInfoList", imageInfoList);
        data.put("fileInfoList", fileInfoList);
//        data.put("inFileInfoList", invoiceNumberMap);
        return data;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchSetStatus(String status, String smIds, String comment, HttpServletRequest request) throws Exception {
        User userInfo = userService.getCurrentUser();
        List<Long> idList = new ArrayList<>();
        List<Long> ids = StringUtil.strToLongList(smIds);
        //检查修改的审核状态是否符合逻辑
        Map<String, List<String>> statusRules = new HashMap<>();
        statusRules.put("0", Arrays.asList("0", "1", "5", "6", "9"));
        statusRules.put("1", Arrays.asList("0", "9"));
        statusRules.put("5", Arrays.asList("0", "9"));
        statusRules.put("6", Arrays.asList("0", "6"));
        statusRules.put("9", Arrays.asList("0"));
        for (Long id : ids) {
            SupermarketMaterial material = getSupermarketMaterial(id);
            String smStatus = material.getStatus();
            if (statusRules.containsKey(status) && statusRules.get(status).contains(smStatus)) {
                idList.add(id);
            } else {
                throw new BusinessRunTimeException(ExceptionConstants.UPDATE_STATUS_FAILED_CODE, ExceptionConstants.UPDATE_STATUS_FAILED_MSG);
            }
        }
        SupermarketMaterial material = new SupermarketMaterial();
        material.setStatus(status);
        material.setVerifierTime(new Timestamp(System.currentTimeMillis()));
        material.setVerifier(userInfo == null ? null : userInfo.getId());
        material.setComment(comment);
        SupermarketMaterialExample example = new SupermarketMaterialExample();
        example.createCriteria().andIdIn(idList);
        return supermarketMaterialMapper.updateByExampleSelective(material, example);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void importSupermarketMaterial(MultipartFile file, HttpServletRequest request) throws Exception {
        String type = "商超产品";
        Workbook workbook = Workbook.getWorkbook(file.getInputStream());
        Sheet src = workbook.getSheet(0);

        User userInfo = userService.getCurrentUser();
        //'供应商id*', 供应商名称*, '商品编号*', '商品名称*', '单位*', '温度条件*', '水产类型*', '一级分类id*', '一级分类*', '二级分类id*', '二级分类*', '三级分类id*', '三级分类*', '省id*', '省', '市id', '市', '区/县/镇id*', '区/县/镇*', '备注', '状态*'
        List<SupermarketMaterial> smList = new ArrayList<>();
        for (int i = 2; i < src.getRows(); i++) {
            String supplierId = ExcelUtils.getContent(src, i, 0);
            String enabled = ExcelUtils.getContent(src, i, 20);
            if (StringUtil.isNotEmpty(supplierId) && StringUtil.isNotEmpty(enabled)) {
                SupermarketMaterial s = new SupermarketMaterial();
                s.setSupplierId(Long.parseLong(supplierId));
                String content = ExcelUtils.getContent(src, i, 2);
                // 商品编码拼接(2024/1/2 替换为大写字母和数字混合编码)
                String onlyNumber = sequenceService.buildMaterialNumber();
                s.setNumber(String.valueOf(new StringBuffer(content).append(onlyNumber)));
                s.setName(ExcelUtils.getContent(src, i, 3));
                s.setUnit(ExcelUtils.getContent(src, i, 4));
                s.setTemperatureCondition(ExcelUtils.getContent(src, i, 5));
                s.setAquaticType(ExcelUtils.getContent(src, i, 6));
                s.setCategoryId(StringUtil.parseStrLong(ExcelUtils.getContent(src, i, 7)));
                s.setSecondCategoryId(StringUtil.parseStrLong(ExcelUtils.getContent(src, i, 9)));
                s.setThirdCategoryId(StringUtil.parseStrLong(ExcelUtils.getContent(src, i, 11)));
                s.setProvince(StringUtil.parseStrLong(ExcelUtils.getContent(src, i, 13)));
                s.setCity(StringUtil.parseStrLong(ExcelUtils.getContent(src, i, 15)));
                s.setCounty(StringUtil.parseStrLong(ExcelUtils.getContent(src, i, 17)));
                s.setRemark(ExcelUtils.getContent(src, i, 19));
                s.setEnabled("1".equals(enabled));

                //导入状态默认为草稿
                s.setStatus("6");
                Timestamp currentTime = new Timestamp(System.currentTimeMillis());
                s.setCreator(userInfo == null ? null : userInfo.getId());
                s.setCreateTime(currentTime);
                s.setUpdater(userInfo == null ? null : userInfo.getId());
                s.setUpdateTime(currentTime);
                smList.add(s);
            }
        }
        importExcel(smList, type);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public BaseResponseInfo importExcel(List<SupermarketMaterial> smList, String type) throws Exception {
        logService.insertLog(type,
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_IMPORT).append(smList.size()).append(BusinessConstants.LOG_DATA_UNIT).toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        BaseResponseInfo info = new BaseResponseInfo();
        Map<String, Object> data = new HashMap<>();
        try {
            for (SupermarketMaterial s : smList) {
                SupermarketMaterialExample example = new SupermarketMaterialExample();
                example.createCriteria().andNumberEqualTo(s.getNumber()).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
                List<SupermarketMaterial> list = supermarketMaterialMapper.selectByExample(example);
                if (list.size() <= 0) {
                    supermarketMaterialMapper.insertSelective(s);
                } else {
                    Long id = list.get(0).getId();
                    s.setId(id);
                    supermarketMaterialMapper.updateByPrimaryKeySelective(s);
                }
            }
            info.code = 200;
            data.put("message", "成功");
        } catch (Exception e) {
            e.printStackTrace();
            info.code = 500;
            data.put("message", e.getMessage());
        }
        info.data = data;
        return info;
    }

    public void importSupermarketMaterialDetails(MultipartFile file, HttpServletRequest request) {
        try {
            Workbook workbook = Workbook.getWorkbook(file.getInputStream());
            //遍历每个工作表
            for (Sheet sheet : workbook.getSheets()) {
                String sheetName = sheet.getName();
                switch (sheetName) {
                    case "销售市场":
                        importSalesMarketExcel(sheet);
                        break;
                    case "销售消息":
                        importSalesInfoExcel(sheet);
                        break;
                    case "发票单据":
                        importInvoiceExcel(sheet);
                        break;
                    default:
                        System.out.println("Unknown sheet: " + sheetName);
                }
            }
            workbook.close();
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void importSalesInfoExcel(Sheet sheet) throws Exception {
        // '商品id', '门店号/档口号', '含税进价', '含税售价', '规格', '是否包括运费', '来源状态', '市场销售渠道', '运输方式', '箱规长宽高(CM)', '小包件装数', '大包件装数', '毛重(kg)', '箱规条码', '省id', '省', '市id', '市', '区/县/镇id', '区/县/镇', '上市日期','备注'
        List<SalesInfo> list = new ArrayList<>();
        String materialId = null;
        for (int i = 2; i < sheet.getRows(); i++) {
            materialId = ExcelUtils.getContent(sheet, i, 0);
            if (StringUtil.isNotEmpty(materialId)) {
                SalesInfo s = new SalesInfo();
                s.setMaterialId(Long.parseLong(materialId));
                s.setStoreNumber(ExcelUtils.getContent(sheet, i, 1));
                s.setTaxPurchasePrice(parseBigDecimalEx(ExcelUtils.getContent(sheet, i, 2)));
                s.setTaxSellingPrice(parseBigDecimalEx(ExcelUtils.getContent(sheet, i, 3)));
                s.setStandard(ExcelUtils.getContent(sheet, i, 4));
                s.setShippingCost(StringUtil.isEmpty(ExcelUtils.getContent(sheet, i, 5)) ? null : "1".equals(ExcelUtils.getContent(sheet, i, 5)));
                s.setSourceType(ExcelUtils.getContent(sheet, i, 6));
                s.setSalesChannel(ExcelUtils.getContent(sheet, i, 7));
                s.setShippingMethod(ExcelUtils.getContent(sheet, i, 8));
                s.setBoxSpec(ExcelUtils.getContent(sheet, i, 9));
                s.setSmallQuantity(parseBigDecimalEx(ExcelUtils.getContent(sheet, i, 10)));
                s.setLargeQuantity(parseBigDecimalEx(ExcelUtils.getContent(sheet, i, 11)));
                s.setWeight(parseBigDecimalEx(ExcelUtils.getContent(sheet, i, 12)));
                s.setBoxBarcode(ExcelUtils.getContent(sheet, i, 13));
                s.setProvince(StringUtil.parseStrLong(ExcelUtils.getContent(sheet, i, 14)));
                s.setCity(StringUtil.parseStrLong(ExcelUtils.getContent(sheet, i, 16)));
                s.setCounty(StringUtil.parseStrLong(ExcelUtils.getContent(sheet, i, 18)));
                s.setLaunchDate(ExcelUtils.getContent(sheet, i, 20));
                s.setRemark(ExcelUtils.getContent(sheet, i, 21));
                list.add(s);
            }
        }
        salesInfoService.saveSalesInfoList(StringUtil.parseStrLong(materialId), list);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void importSalesMarketExcel(Sheet sheet) throws Exception {
        //'商品id', '销售市场', '备注'
        List<SalesMarket> list = new ArrayList<>();
        Long materialId = null;
        for (int i = 2; i < sheet.getRows(); i++) {
            materialId = StringUtil.parseStrLong(ExcelUtils.getContent(sheet, i, 0));
            if (materialId != null) {
                SalesMarket s = new SalesMarket();
                s.setMaterialId(materialId);
                s.setMarketName(ExcelUtils.getContent(sheet, i, 1));
                s.setRemark(ExcelUtils.getContent(sheet, i, 2));
                list.add(s);
            }
        }
        salesMarketService.savesSalesMarketList(materialId, list);
    }

    public BigDecimal parseBigDecimalEx(String str) throws Exception {
        if (!StringUtil.isEmpty(str)) {
            return new BigDecimal(str);
        } else {
            return null;
        }
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void importInvoiceExcel(Sheet sheet) {
        //'商品id','批次号', '备注'
        List<InvoiceNumber> list = new ArrayList<>();
        Long materialId = null;
        for (int i = 2; i < sheet.getRows(); i++) {
            materialId = StringUtil.parseStrLong(ExcelUtils.getContent(sheet, i, 0));
            if (materialId != null) {
                InvoiceNumber invoice = new InvoiceNumber();
                invoice.setMaterialId(materialId);
                invoice.setBatchNumber(ExcelUtils.getContent(sheet, i, 1));
                invoice.setRemark(ExcelUtils.getContent(sheet, i, 2));
                list.add(invoice);
            }
        }
        invoiceService.saveInvoiceList(materialId, list);
    }

    public File exportExcel(List<Long> ids) throws Exception {
        //基本信息
        List<SupermarketMaterialVo4> materialVo4 = supermarketMaterialMapperEx.findByIds(ids);
        String[] materialNames = {"商品id*", "供应商名称*", "商品编码*", "商品名称*", "单位*", "温度条件*", "水产类型*", "一级分类*", "二级分类*", "三级分类*", "省*", "市*", "区/县/镇*", "备注", "状态"};
        String materialTitle = "SKU信息-基本信息";
        List<String[]> materialObjects = new ArrayList<String[]>();
        if (null != materialVo4) {
            for (SupermarketMaterialVo4 sm : materialVo4) {
                String[] objs = new String[20];
                objs[0] = sm.getId().toString();
                objs[1] = sm.getSupplier();
                objs[2] = sm.getNumber();
                objs[3] = sm.getName();
                objs[4] = sm.getUnit();
                objs[5] = sm.getTemperatureCondition();
                objs[6] = sm.getAquaticType();
                objs[7] = sm.getCategory();
                objs[8] = sm.getSecondCategory();
                objs[9] = sm.getThirdCategory();
                objs[10] = sm.getProvinceName();
                objs[11] = sm.getCityName();
                objs[12] = sm.getCountyName();
                objs[13] = sm.getRemark();
                objs[14] = sm.getEnabled() ? "1" : "0";
                objs[15] = sm.getSupplyingZeroName();
                objs[16] = sm.getSupplyingZeroNumber();
                materialObjects.add(objs);
            }
        }
        //销售市场
        List<SalesMarketVoList> salesMarketVoList = salesMarketService.findByAll(ids);
        String[] salesMarketNames = {"商品id*", "商品名称", "销售市场", "备注"};
        String salesMarketTitle = "SKU信息-销售市场";
        List<String[]> salesMarketObjects = new ArrayList<String[]>();
        if (null != salesMarketVoList) {
            for (SalesMarketVoList salesMarket : salesMarketVoList) {
                String[] objs = new String[4];
                objs[0] = salesMarket.getMaterialId().toString();
                objs[1] = salesMarket.getMaterialName();
                objs[2] = salesMarket.getMarketName();
                objs[3] = salesMarket.getRemark();
                salesMarketObjects.add(objs);
            }
        }
        //销售消息
        List<SalesInfoVoList> salesInfoVoList = salesInfoService.findByAll(ids);
        String[] salesInfoNames = {"商品id*", "商品名称", "门店号/档口号", "货品源头", "含税进价", "含税售价", "规格", "是否包运费", "来源状态", "市场销售渠道", "运输方式", "箱规长宽高(cm)", "小包件装数", "大包件装数", "毛重(kg)", "箱规条码", "上市日期", "备注"};
        String salesInfoTitle = "SKU信息-销售消息";
        List<String[]> salesInfoObjects = new ArrayList<String[]>();
        if (null != salesInfoVoList) {
            for (SalesInfoVoList si : salesInfoVoList) {
                String[] objs = new String[19];
                objs[0] = si.getMaterialId().toString();
                objs[1] = si.getMaterialName();
                objs[2] = si.getStoreNumber();
                objs[3] = appendToString(si.getProvinceName(), si.getCityName(), si.getCountyName());
                objs[4] = si.getTaxPurchasePrice() == null ? null : si.getTaxPurchasePrice().setScale(2, RoundingMode.HALF_UP).toString();
                objs[5] = si.getTaxSellingPrice() == null ? null : si.getTaxSellingPrice().setScale(2, RoundingMode.HALF_UP).toString();
                objs[6] = si.getStandard();
                objs[7] = si.getShippingCost() == null ? null : (si.getShippingCost() ? "是" : "否");
                objs[8] = si.getSourceType();
                objs[9] = si.getSalesChannel();
                objs[10] = si.getShippingMethod();
                objs[11] = si.getBoxSpec();
                objs[12] = si.getSmallQuantity() == null ? null : si.getSmallQuantity().toBigInteger().toString();
                objs[13] = si.getLargeQuantity() == null ? null : si.getLargeQuantity().toBigInteger().toString();
                objs[14] = si.getWeight() == null ? null : si.getWeight().setScale(2, RoundingMode.HALF_UP).toString();
                objs[15] = si.getBoxBarcode();
                objs[16] = si.getLaunchDate();
                objs[17] = si.getRemark();
                salesInfoObjects.add(objs);
            }
        }
        //发票单据
        List<InvoiceNumberVoList> invoiceVoList = invoiceService.findByAll(ids);
        String[] invoiceNames = {"商品id*", "商品名称", "批次号", "备注"};
        String invoiceTitle = "SKU信息-发票单据";
        List<String[]> invoiceObjects = new ArrayList<String[]>();
        if (null != salesMarketVoList) {
            for (InvoiceNumberVoList invoice : invoiceVoList) {
                String[] objs = new String[5];
                objs[0] = invoice.getMaterialId().toString();
                objs[1] = invoice.getMaterialName();
                objs[2] = invoice.getBatchNumber();
                objs[3] = invoice.getRemark();
                invoiceObjects.add(objs);
            }
        }
        //导出
        File excelFile = new File(materialTitle);
        WritableWorkbook wtwb = Workbook.createWorkbook(excelFile);
        String tip = "*导入时本行内容请勿删除，切记！";

        WritableSheet materialSheet = wtwb.createSheet(materialTitle, 0);
        ExcelUtils.exportSheet(tip, materialNames, materialObjects, materialSheet);

        WritableSheet saleMarketSheet = wtwb.createSheet(salesMarketTitle, 1);
        ExcelUtils.exportSheet(tip, salesMarketNames, salesMarketObjects, saleMarketSheet);

        WritableSheet saleInfoSheet = wtwb.createSheet(salesInfoTitle, 2);
        ExcelUtils.exportSheet(tip, salesInfoNames, salesInfoObjects, saleInfoSheet);

        WritableSheet invoiceSheet = wtwb.createSheet(invoiceTitle, 3);
        ExcelUtils.exportSheet(tip, invoiceNames, invoiceObjects, invoiceSheet);
        wtwb.write();
        wtwb.close();
        return excelFile;
    }

    private static String appendToString(String provinceName, String cityName, String countyName) {
        StringBuilder sb = new StringBuilder();
        if (StringUtil.isNotEmpty(provinceName)) {
            sb.append(provinceName);
            if (StringUtil.isNotEmpty(cityName)) {
                sb.append("/").append(cityName);
                if (StringUtil.isNotEmpty(countyName)) {
                    sb.append("/").append(countyName);
                }
            }
        }
        return sb.toString();
    }

    public void saveInvoiceDetail(List<Long> fileIds, List<String> filePaths, HttpServletRequest request) throws Exception {
        User currentUser = userService.getCurrentUser();
        try {
            if (CollectionUtils.isNotEmpty(fileIds)) {
                fileInfoMapperEx.batchDeleteFile(fileIds);
            }
            if (CollectionUtils.isNotEmpty(filePaths)) {
                for (String path : filePaths) {
                    deleteFile(path);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteFile(String fileName) {
        String fileUrl = filePath + File.separator + fileName;
        File file = new File(fileUrl);
        if (file.exists() && file.isFile()) {
            file.delete();
        }
    }

}
