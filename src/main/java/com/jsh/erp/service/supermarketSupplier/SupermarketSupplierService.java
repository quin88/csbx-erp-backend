package com.jsh.erp.service.supermarketSupplier;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.*;
import com.jsh.erp.datasource.vo.*;
import com.jsh.erp.exception.BusinessRunTimeException;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.log.LogService;
import com.jsh.erp.service.supermarketAccount.SupermarketAccountService;
import com.jsh.erp.service.supermarketAttachment.SupermarketAttachmentService;
import com.jsh.erp.service.supermarketContact.SupermarketContactService;
import com.jsh.erp.service.supermarketCooperation.SupermarketCooperationService;
import com.jsh.erp.service.supermarketInvoice.SupermarketInvoiceService;
import com.jsh.erp.service.user.UserService;
import com.jsh.erp.utils.BaseResponseInfo;
import com.jsh.erp.utils.ExcelUtils;
import com.jsh.erp.utils.StringUtil;
import com.jsh.erp.utils.Tools;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.*;
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
import java.io.IOException;
import java.lang.Boolean;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.util.*;

@Service
public class SupermarketSupplierService {
    private Logger logger = LoggerFactory.getLogger(SupermarketSupplierService.class);

    @Resource
    private SupermarketSupplierMapper supermarketSupplierMapper;

    @Resource
    private SupermarketSupplierMapperEx supermarketSupplierMapperEx;

    @Resource
    private UserService userService;

    @Resource
    private LogService logService;

    @Resource
    private SupermarketContactService supermarketContactService;

    @Resource
    private SupermarketAccountService supermarketAccountService;

    @Resource
    private SupermarketInvoiceService supermarketInvoiceService;

    @Resource
    private SupermarketCooperationService supermarketCooperationService;

    @Resource
    private SupermarketAttachmentService supermarketAttachmentService;

    @Resource
    private SequenceMapperEx sequenceMapperEx;

    @Resource
    private SupermarketMaterialMapper supermarketMaterialMapper;

    public SupermarketSupplierVoList getSupermarketSupplier(Long id) {
        SupermarketSupplierVoList result = null;
        try {
            result = supermarketSupplierMapperEx.selectByPrimaryKey(id);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    public List<SupermarketSupplier> findBySelectSup() {
        SupermarketSupplierExample example = new SupermarketSupplierExample();
        example.createCriteria().andEnabledEqualTo(true).andStatusEqualTo(BusinessConstants.BILLS_STATUS_AUDIT)
                .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<SupermarketSupplier> list = null;
        try {
            list = supermarketSupplierMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    private List<SupermarketSupplier> getSuperMarketSupplierListByIds(String ids) {
        List<Long> idList = StringUtil.strToLongList(ids);
        List<SupermarketSupplier> list = null;
        SupermarketSupplierExample example = new SupermarketSupplierExample();
        example.createCriteria().andIdIn(idList);
        try {
            list = supermarketSupplierMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<SupermarketSupplierVoList> select(String number, String name, String supplierLevel, String status, int offset, int rows) {
        List<SupermarketSupplierVoList> list = null;
        String[] statusArray = StringUtil.isNotEmpty(status) ? status.split(",") : null;
        try {
            list = supermarketSupplierMapperEx.selectByConditionSupermarketSupplier(number, name, supplierLevel, statusArray, offset, rows);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public Long countSupermarketSupplier(String number, String name, String supplierLevel, String status) {
        Long result = null;
        String[] statusArray = StringUtil.isNotEmpty(status) ? status.split(",") : null;
        try {
            result = supermarketSupplierMapperEx.countSupermarketSupplier(number, name, supplierLevel, statusArray);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertSuperMarketSupplierService(JSONObject obj, HttpServletRequest request) throws Exception {
        SupermarketSupplier supermarketSupplier = JSONObject.parseObject(obj.toJSONString(), SupermarketSupplier.class);

        //校验供应商编码
        if (checkIsNumberExist(supermarketSupplier.getNumber()) > 0) {
            throw new BusinessRunTimeException(ExceptionConstants.NUMBER_IS_EXIST_CODE, ExceptionConstants.NUMBER_IS_EXIST_MSG);
        }
        int result = 0;
        Long userId = userService.getUserId(request);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        try {
            supermarketSupplier.setCreateTime(timestamp);
            supermarketSupplier.setCreator(userId);
            supermarketSupplier.setUpdateTime(timestamp);
            supermarketSupplier.setUpdater(userId);
            supermarketSupplier.setEnabled(false);
            result = supermarketSupplierMapper.insertSelective(supermarketSupplier);
            sequenceMapperEx.updateBuildOnlyNumber(BusinessConstants.SUPPLIER_NUMBER_SEQ); //编号+1
            logService.insertLog("商超供应商", BusinessConstants.LOG_OPERATION_TYPE_ADD, request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    private int checkIsNumberExist(String number) {
        SupermarketSupplierExample example = new SupermarketSupplierExample();
        example.createCriteria().andNumberEqualTo(number).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<SupermarketSupplier> list = null;
        try {
            list = supermarketSupplierMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list == null ? 0 : list.size();
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateSuperMarketSupplierService(JSONObject obj, HttpServletRequest request) throws Exception {
        SupermarketSupplier supermarketSupplier = JSONObject.parseObject(obj.toJSONString(), SupermarketSupplier.class);
        Long userId = userService.getUserId(request);
        supermarketSupplier.setUpdater(userId);
        supermarketSupplier.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        int result = 0;
        try {
            result = supermarketSupplierMapper.updateByPrimaryKey(supermarketSupplier);
            logService.insertLog("商超供应商",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(supermarketSupplier.getId()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void addSupermarketSupplierDetail(Long supplierId, List<SupermarketAccount> accountList, List<SupermarketAttachment> attachmentList, List<SupermarketContact> contactList, List<SupermarketCooperation> cooperationList, List<SupermarketInvoice> invoiceList, HttpServletRequest request) throws Exception {
        //1.供应商联系人信息
        supermarketContactService.saveContactList(supplierId, contactList);
        //2.供应商账户信息
        supermarketAccountService.saveAccountList(supplierId, accountList);
        //3.供应商发票信息
        supermarketInvoiceService.saveInvoiceList(supplierId, invoiceList);
        //4.供应商合作信息
        supermarketCooperationService.saveCooperationList(supplierId, cooperationList);
        //5.供应商附件
        supermarketAttachmentService.saveAttachmentList(supplierId, attachmentList);
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
                SupermarketSupplier supplier = supermarketSupplierMapper.selectByPrimaryKey(id);
                if (!Objects.equals(supplier.getStatus(), "1")) {
                    throw new BusinessRunTimeException(ExceptionConstants.SUPERMARKET_SUPPLIER_UPDATE_ENABLE_TRUE_FAILED_CODE, String.format(ExceptionConstants.SUPERMARKET_SUPPLIER_UPDATE_ENABLE_TRUE_FAILED_CODE_MSG, supplier.getName()));
                }
            }
        }
        int result = 0;
        SupermarketSupplier supplier = new SupermarketSupplier();
        supplier.setEnabled(enabled);
        supplier.setUpdater(userInfo == null ? null : userInfo.getId());
        supplier.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        SupermarketSupplierExample example = new SupermarketSupplierExample();
        example.createCriteria().andIdIn(idList);

        try {
            result = supermarketSupplierMapper.updateByExampleSelective(supplier, example);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteSuperMarketSupplier(Long id, HttpServletRequest request) throws Exception {
        return batchDeleteSuperMarketSupplierByIds(id.toString());
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteSuperMarketSupplier(String ids, HttpServletRequest request) throws Exception {
        return batchDeleteSuperMarketSupplierByIds(ids);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteSuperMarketSupplierByIds(String ids) throws Exception {
        int result = 0;
        String[] idArray = ids.split(",");
        List<SupermarketSupplier> list = getSuperMarketSupplierListByIds(ids);
        //校验商品
        List<SupermarketMaterial> materials = null;
        try {
            SupermarketMaterialExample example = new SupermarketMaterialExample();
            example.createCriteria().andSupplierIdIn(StringUtil.strToLongList(ids)).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
            materials = supermarketMaterialMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        if (materials != null && materials.size() > 0) {
            logger.error("异常码[{}],异常提示[{}],参数,MaterialIds[{}]",
                    ExceptionConstants.DELETE_FORCE_CONFIRM_CODE, ExceptionConstants.DELETE_FORCE_CONFIRM_MSG, ids);
            throw new BusinessRunTimeException(ExceptionConstants.DELETE_FORCE_CONFIRM_CODE,
                    ExceptionConstants.DELETE_FORCE_CONFIRM_MSG);
        }
        //校验供应商状态
        for (SupermarketSupplier supplier : list) {
            String status = supplier.getStatus();
            if (status.equals("1") || status.equals("9")) {
                throw new BusinessRunTimeException(ExceptionConstants.SUPERMARKET_MATERIAL_UN_AUDIT_DELETE_FAILED_CODE, ExceptionConstants.SUPERMARKET_MATERIAL_UN_AUDIT_DELETE_FAILED_MSG);
            }
        }
        //记录日志
        StringBuffer sb = new StringBuffer();
        sb.append(BusinessConstants.LOG_OPERATION_TYPE_DELETE);
        for (SupermarketSupplier supplier : list) {
            sb.append("[").append(supplier.getName()).append("]");
        }
        User userInfo = userService.getCurrentUser();
        //执行删除操作
        try {
            result = supermarketSupplierMapperEx.batchDeleteSuperMarketSupplierByIds(new Date(), userInfo == null ? null : userInfo.getId(), idArray);
            logService.insertLog("商超供应商", sb.toString(),
                    ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
            //删除供应商的基础资料
            batchDeleteSuperMarketSupplierDetails(idArray);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    /**
     * 删除供应商的基础资料
     *
     * @param idArray
     * @return
     */
    private void batchDeleteSuperMarketSupplierDetails(String[] idArray) throws Exception {
        try {
            //1.删除对应的联系人信息
            supermarketContactService.batchDeleteSupermarketContactBySupplierIds(idArray);
            //2.删除对应的账户信息
            supermarketAccountService.batchDeleteSupermarketAccountBySupplierIds(idArray);
            //3.删除对应的发票信息
            supermarketInvoiceService.batchDeleteSupermarketInvoiceBySupplierIds(idArray);
            //4.删除对应的合作信息
            supermarketCooperationService.batchDeleteSupermarketCooperationBySupplierIds(idArray);
            //5.删除对应的附件信息
            supermarketAttachmentService.batchDeleteSupermarketAttachmentBySupplierIds(idArray);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchSetStatus(String status, String ssIds, String comment, HttpServletRequest request) throws Exception {
        User userInfo = userService.getCurrentUser();

        //检查修改的审核状态是否符合逻辑
        Map<String, List<String>> statusRules = new HashMap<>();
        statusRules.put("0", Arrays.asList("0", "1", "5", "6", "9"));
        statusRules.put("1", Arrays.asList("0", "9"));
        statusRules.put("5", Arrays.asList("0", "9"));
        statusRules.put("6", Arrays.asList("0", "6"));
        statusRules.put("9", Arrays.asList("0"));
        List<Long> idList = new ArrayList<>();
        List<Long> ids = StringUtil.strToLongList(ssIds);
        for (Long id : ids) {
            SupermarketSupplier supplier = getSupermarketSupplier(id);
            String ssStatus = supplier.getStatus();
            if (statusRules.containsKey(status) && statusRules.get(status).contains(ssStatus)) {
                idList.add(id);
            } else {
                throw new BusinessRunTimeException(ExceptionConstants.UPDATE_STATUS_FAILED_CODE, ExceptionConstants.UPDATE_STATUS_FAILED_MSG);
            }
        }
        SupermarketSupplier supplier = new SupermarketSupplier();
        supplier.setStatus(status);
        supplier.setVerifierTime(new Timestamp(System.currentTimeMillis()));
        supplier.setVerifier(userInfo == null ? null : userInfo.getId());
        supplier.setComment(comment);
        SupermarketSupplierExample example = new SupermarketSupplierExample();
        example.createCriteria().andIdIn(idList);
        return supermarketSupplierMapper.updateByExampleSelective(supplier, example);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void importSupermarketSupplier(MultipartFile file, HttpServletRequest request) throws Exception {
        String type = "商超供应商";
        Workbook workbook = Workbook.getWorkbook(file.getInputStream());
        Sheet src = workbook.getSheet(0);

        //'市场id', '市场名称', '供应商级别', '纳税级别', '企业类型', '星级', '供应商编码', '供应商名称', '省id', '省', 市id', '市', '统一社会信用代码', '是否供应商自产自销免税备案', '注册资本（万元）','公司地址', '公司简介', '经营范围', '公司电话', '主营品牌', '公司成立时间', '邮编', '传真', '合作开始时间', '合作结束时间', '启用状态'
        List<SupermarketSupplier> sslist = new ArrayList<>();
        for (int i = 2; i < src.getRows(); i++) {
            String marketId = ExcelUtils.getContent(src, i, 0);
            String enabled = ExcelUtils.getContent(src, i, 25);
            if (StringUtil.isNotEmpty(marketId) && StringUtil.isNotEmpty(enabled)) {
                SupermarketSupplier s = new SupermarketSupplier();
                s.setMarketId(StringUtil.parseStrLong(marketId));
                s.setSupplierLevel(ExcelUtils.getContent(src, i, 2));
                s.setTaxLevel(ExcelUtils.getContent(src, i, 3));
                s.setBusinessType(ExcelUtils.getContent(src, i, 4));
                s.setStarLevel(ExcelUtils.getContent(src, i, 5));
                s.setNumber(ExcelUtils.getContent(src, i, 6));
                s.setName(ExcelUtils.getContent(src, i, 7));
                s.setProvince(StringUtil.parseStrLong(ExcelUtils.getContent(src, i, 8)));
                s.setCity(StringUtil.parseStrLong(ExcelUtils.getContent(src, i, 10)));
                s.setCreditCode(ExcelUtils.getContent(src, i, 12));
                s.setIsExempt(StringUtil.isEmpty(ExcelUtils.getContent(src, i, 13)) ? null : ("1".equals(ExcelUtils.getContent(src, i, 10))));
                s.setAmount(StringUtil.parseBigDecimalEx(ExcelUtils.getContent(src, i, 14)));
                s.setCompanyAddress(ExcelUtils.getContent(src, i, 15));
                s.setCompanyProfile(ExcelUtils.getContent(src, i, 16));
                s.setBusinessScope(ExcelUtils.getContent(src, i, 17));
                s.setCompanyTel(ExcelUtils.getContent(src, i, 18));
                s.setMainBrand(ExcelUtils.getContent(src, i, 19));
                s.setEstablishmentDate(ExcelUtils.getContent(src, i, 20));
                s.setPostcode(ExcelUtils.getContent(src, i, 21));
                s.setFax(ExcelUtils.getContent(src, i, 22));
                s.setStartDate(ExcelUtils.getDate(src, i, 23));
                s.setEndDate(ExcelUtils.getDate(src, i, 24));
                s.setEnabled("1".equals(enabled));

                User userInfo = userService.getCurrentUser();
                Timestamp currentTime = new Timestamp(System.currentTimeMillis());
                s.setCreator(userInfo == null ? null : userInfo.getId());
                s.setCreateTime(currentTime);
                s.setUpdater(userInfo == null ? null : userInfo.getId());
                s.setUpdateTime(currentTime);
                s.setStatus("6");
                sslist.add(s);
            }
        }
        importExcel(sslist, type);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public BaseResponseInfo importExcel(List<SupermarketSupplier> sslist, String type) throws Exception {
        logService.insertLog(type,
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_IMPORT).append(sslist.size()).append(BusinessConstants.LOG_DATA_UNIT).toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        BaseResponseInfo info = new BaseResponseInfo();
        Map<String, Object> data = new HashMap<>();
        try {
            for (SupermarketSupplier s : sslist) {
                SupermarketSupplierExample example = new SupermarketSupplierExample();
                example.createCriteria().andNumberEqualTo(s.getNumber()).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
                List<SupermarketSupplier> list = supermarketSupplierMapper.selectByExample(example);
                if (list.size() <= 0) {
                    supermarketSupplierMapper.insertSelective(s);
                } else {
                    Long id = list.get(0).getId();
                    s.setId(id);
                    supermarketSupplierMapper.updateByPrimaryKeySelective(s);
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

    public void importSupermarketSupplierDetails(MultipartFile file, HttpServletRequest request) throws Exception {
        Workbook workbook = Workbook.getWorkbook(file.getInputStream());
        //遍历每个工作表
        for (Sheet sheet : workbook.getSheets()) {
            String sheetName = sheet.getName();
            switch (sheetName) {
                case "联系人信息":
                    importSupermarketContactExcel(sheet);
                    break;
                case "银行账户":
                    importSupermarketAccountExcel(sheet);
                    break;
                case "发票信息":
                    importSupermarketInvoiceExcel(sheet);
                    break;
                case "合作信息":
                    importSupermarketCooperationExcel(sheet);
                    break;
                default:
                    System.out.println("Unknown sheet: " + sheetName);
            }
        }
        workbook.close();
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void importSupermarketContactExcel(Sheet sheet) throws Exception {
        //'供应商id', '联系人', '职位', '联系人电话', '邮箱', '微信', 'QQ', '是否在职', '备注'
        List<SupermarketContact> list = new ArrayList<>();
        Long supplierId = null;
        for (int i = 2; i < sheet.getRows(); i++) {
            supplierId = StringUtil.parseStrLong(ExcelUtils.getContent(sheet, i, 0));
            if (supplierId != null) {
                SupermarketContact s = new SupermarketContact();
                s.setSupplierId(supplierId);
                s.setName(ExcelUtils.getContent(sheet, i, 1));
                s.setPosition(ExcelUtils.getContent(sheet, i, 2));
                s.setPhoneNumber(ExcelUtils.getContent(sheet, i, 3));
                s.setEmail(ExcelUtils.getContent(sheet, i, 4));
                s.setWechat(ExcelUtils.getContent(sheet, i, 5));
                s.setQq(ExcelUtils.getContent(sheet, i, 6));
                s.setEnabled(StringUtil.isEmpty(ExcelUtils.getContent(sheet, i, 7)) ? null : ("1".equals(ExcelUtils.getContent(sheet, i, 7))));
                s.setRemark(ExcelUtils.getContent(sheet, i, 8));
                list.add(s);
            }
        }
        supermarketContactService.saveContactList(supplierId, list);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void importSupermarketAccountExcel(Sheet sheet) throws Exception {
        //'供应商id', '开户银行', '开户行行号', '银行账号', '户名', '备注'
        List<SupermarketAccount> list = new ArrayList<>();
        Long supplierId = null;
        for (int i = 2; i < sheet.getRows(); i++) {
            supplierId = StringUtil.parseStrLong(ExcelUtils.getContent(sheet, i, 0));
            if (supplierId != null) {
                SupermarketAccount s = new SupermarketAccount();
                s.setSupplierId(supplierId);
                s.setBankName(ExcelUtils.getContent(sheet, i, 1));
                s.setBranchCode(ExcelUtils.getContent(sheet, i, 2));
                s.setAccountNumber(ExcelUtils.getContent(sheet, i, 3));
                s.setAccountName(ExcelUtils.getContent(sheet, i, 4));
                s.setRemark(ExcelUtils.getContent(sheet, i, 5));
                list.add(s);
            }
        }
        supermarketAccountService.saveAccountList(supplierId, list);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void importSupermarketInvoiceExcel(Sheet sheet) throws Exception {
        //'供应商id', '发票地址', '发票抬头', '备注'
        List<SupermarketInvoice> list = new ArrayList<>();
        Long supplierId = null;
        for (int i = 2; i < sheet.getRows(); i++) {
            supplierId = StringUtil.parseStrLong(ExcelUtils.getContent(sheet, i, 0));
            if (supplierId != null) {
                SupermarketInvoice s = new SupermarketInvoice();
                s.setSupplierId(supplierId);
                s.setInvoiceAddress(ExcelUtils.getContent(sheet, i, 1));
                s.setInvoiceTitle(ExcelUtils.getContent(sheet, i, 2));
                s.setRemark(ExcelUtils.getContent(sheet, i, 3));
                list.add(s);
            }
        }
        supermarketInvoiceService.saveInvoiceList(supplierId, list);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void importSupermarketCooperationExcel(Sheet sheet) throws Exception {
        //'供应商id', '联系人', '职位', '联系人电话', '微信', 'QQ', '是否在职', '备注'
        List<SupermarketCooperation> list = new ArrayList<>();
        Long supplierId = null;
        for (int i = 2; i < sheet.getRows(); i++) {
            supplierId = StringUtil.parseStrLong(ExcelUtils.getContent(sheet, i, 0));
            if (supplierId != null) {
                SupermarketCooperation s = new SupermarketCooperation();
                s.setSupplierId(supplierId);
                s.setCooperationName(ExcelUtils.getContent(sheet, i, 1));
                s.setRemark(ExcelUtils.getContent(sheet, i, 2));
                list.add(s);
            }
        }
        supermarketCooperationService.saveCooperationList(supplierId, list);
    }

    public List<SupermarketSupplierVoList> findByAll(List<Long> ids) {
        List<SupermarketSupplierVoList> list = null;
        try {
            list = supermarketSupplierMapperEx.findByAll(ids);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public File exportExcel(List<Long> ids) throws Exception {
        //供应商-基础信息
        List<SupermarketSupplierVoList> supplierDataList = findByAll(ids);
        String[] supplierNames = {"供应商id*", "市场名称*", "供应商编号*", "供应商名称*", "地区（省）*", "地区（市）*", "统一社会信用代码*", "类型*", "企业类型", "纳税级别", "是否供应商自产自销免税备案", "注册资本（万元）",
                "公司地址", "公司简介", "经营范围", "公司电话", "主营品牌", "公司成立时间", "邮编", "传真", "星级", "合作开始时间", "合作结束时间", "状态*"};
        String supplierTitle = "供应商-基础信息";
        List<String[]> supplierObjects = new ArrayList<String[]>();
        if (null != supplierDataList) {
            for (SupermarketSupplierVoList s : supplierDataList) {
                String[] objs = new String[24];
                objs[0] = s.getId().toString();
                objs[1] = s.getMarketName();
                objs[2] = s.getNumber();
                objs[3] = s.getName();
                objs[4] = s.getProvinceName();
                objs[5] = s.getCityName();
                objs[6] = s.getCreditCode();
                objs[7] = s.getSupplierLevel();
                objs[8] = s.getBusinessType();
                objs[9] = s.getTaxLevel();
                objs[10] = s.getIsExempt() == null ? null : (s.getIsExempt() ? "是" : "否");
                objs[11] = s.getAmount() == null ? null : s.getAmount().setScale(2, RoundingMode.HALF_UP).toString();
                objs[12] = s.getCompanyAddress();
                objs[13] = s.getCompanyProfile();
                objs[14] = s.getBusinessScope();
                objs[15] = s.getCompanyTel();
                objs[16] = s.getMainBrand();
                objs[17] = s.getEstablishmentDate();
                objs[18] = s.getPostcode();
                objs[19] = s.getFax();
                objs[20] = s.getStarLevel();
                objs[21] = Tools.parseDateToStr(s.getStartDate());
                objs[22] = Tools.parseDateToStr(s.getEndDate());
                objs[23] = s.getEnabled() ? "1" : "0";
                supplierObjects.add(objs);
            }
        }

        //供应商-联系人信息
        List<SupermarketContactVoList> contactVoList = supermarketContactService.findByAll(ids);
        String[] contactNames = {"供应商id*", "供应商名称*", "人员", "职位", "联系电话", "邮箱", "微信", "QQ ", "是否在职", "备注"};
        String contactTitle = "供应商-联系人信息";
        List<String[]> contactObjects = new ArrayList<String[]>();
        if (null != contactVoList) {
            for (SupermarketContactVoList s : contactVoList) {
                String[] objs = new String[10];
                objs[0] = s.getSupplierId().toString();
                objs[1] = s.getSupplierName();
                objs[2] = s.getName();
                objs[3] = s.getPosition();
                objs[4] = s.getPhoneNumber();
                objs[5] = s.getEmail();
                objs[6] = s.getWechat();
                objs[7] = s.getQq();
                objs[8] = s.getEnabled() == null ? null : (s.getEnabled() ? "是" : "否");
                objs[9] = s.getRemark();
                contactObjects.add(objs);
            }
        }

        //供应商-银行账户
        List<SupermarketAccountVoList> accountVoList = supermarketAccountService.findByAll(ids);
        String[] accountNames = {"供应商id*", "供应商名称*", "开户银行(银行名称)", "开户行行号", "银行账号id", "银行账号(银行账户号码)", "户名", "备注"};
        String accountTitle = "供应商-银行账户";
        List<String[]> accountObjects = new ArrayList<String[]>();
        if (null != accountVoList) {
            for (SupermarketAccountVoList s : accountVoList) {
                String[] objs = new String[8];
                objs[0] = s.getSupplierId().toString();
                objs[1] = s.getSupplierName();
                objs[2] = s.getBankName();
                objs[3] = s.getBranchCode();
                objs[4] = s.getId().toString();
                objs[5] = s.getAccountNumber();
                objs[6] = s.getAccountName();
                objs[7] = s.getRemark();
                accountObjects.add(objs);
            }
        }
        //供应商-发票
        List<SupermarketInvoiceVoList> invoiceVoList = supermarketInvoiceService.findByAll(ids);
        String[] invoiceNames = {"供应商id*", "供应商名称*", "发票地址(开票地址)", "发票抬头(开票名称)", "备注"};
        String invoiceTitle = "供应商-发票";
        List<String[]> invoiceObjects = new ArrayList<String[]>();
        if (null != invoiceVoList) {
            for (SupermarketInvoiceVoList s : invoiceVoList) {
                String[] objs = new String[5];
                objs[0] = s.getSupplierId().toString();
                objs[1] = s.getSupplierName();
                objs[2] = s.getInvoiceAddress();
                objs[3] = s.getInvoiceTitle();
                objs[4] = s.getRemark();
                invoiceObjects.add(objs);
            }
        }
        //供应商-合作信息
        List<SupermarketCooperationVoList> cooperationVoList = supermarketCooperationService.findByAll(ids);
        String[] cooperationNames = {"供应商id*", "供应商名称*", "意向合作品类", "备注"};
        String cooperationTitle = "供应商-合作信息";
        List<String[]> cooperationObjects = new ArrayList<String[]>();
        if (null != cooperationVoList) {
            for (SupermarketCooperationVoList s : cooperationVoList) {
                String[] objs = new String[5];
                objs[0] = s.getSupplierId().toString();
                objs[1] = s.getSupplierName();
                objs[2] = s.getCooperationName();
                objs[3] = s.getRemark();
                cooperationObjects.add(objs);
            }
        }
        //导出
        File excelFile = new File(supplierTitle);
        WritableWorkbook wtwb = Workbook.createWorkbook(excelFile);
        String tip = "*导入时本行内容请勿删除，切记！";

        WritableSheet supplierSheet = wtwb.createSheet(supplierTitle, 0);
        ExcelUtils.exportSheet(tip, supplierNames, supplierObjects, supplierSheet);

        WritableSheet contactSheet = wtwb.createSheet(contactTitle, 1);
        ExcelUtils.exportSheet(tip, contactNames, contactObjects, contactSheet);

        WritableSheet accountSheet = wtwb.createSheet(accountTitle, 2);
        ExcelUtils.exportSheet(tip, accountNames, accountObjects, accountSheet);

        WritableSheet invoiceSheet = wtwb.createSheet(invoiceTitle, 3);
        ExcelUtils.exportSheet(tip, invoiceNames, invoiceObjects, invoiceSheet);

        WritableSheet cooperationSheet = wtwb.createSheet(cooperationTitle, 4);
        ExcelUtils.exportSheet(tip, cooperationNames, cooperationObjects, cooperationSheet);
        wtwb.write();
        wtwb.close();
        return excelFile;
    }
}
