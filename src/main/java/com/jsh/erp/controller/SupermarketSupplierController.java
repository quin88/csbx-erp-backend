package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.dto.SupermarketSupplierDetailsDTO;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.vo.SupermarketAccountVoList;
import com.jsh.erp.exception.BusinessRunTimeException;
import com.jsh.erp.service.supermarketAccount.SupermarketAccountService;
import com.jsh.erp.service.supermarketAttachment.SupermarketAttachmentService;
import com.jsh.erp.service.supermarketContact.SupermarketContactService;
import com.jsh.erp.service.supermarketCooperation.SupermarketCooperationService;
import com.jsh.erp.service.supermarketInvoice.SupermarketInvoiceService;
import com.jsh.erp.service.supermarketSupplier.SupermarketSupplierService;
import com.jsh.erp.utils.BaseResponseInfo;
import com.jsh.erp.utils.ErpInfo;
import com.jsh.erp.utils.ExcelUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.jsh.erp.utils.ResponseJsonUtil.returnJson;

@RestController
@RequestMapping(value = "/supermarketSupplier")
@Api(tags = {"商超供应商接口管理"})
public class SupermarketSupplierController {
    private Logger logger = LoggerFactory.getLogger(SupermarketSupplierController.class);

    @Resource
    private SupermarketSupplierService supermarketSupplierService;

    @Resource
    private SupermarketAccountService supermarketAccountService;

    @Resource
    private SupermarketAttachmentService supermarketAttachmentService;

    @Resource
    private SupermarketContactService supermarketContactService;

    @Resource
    private SupermarketCooperationService supermarketCooperationService;

    @Resource
    private SupermarketInvoiceService supermarketInvoiceService;

    /**
     * 查询供应商基础资料
     *
     * @param supplierId
     * @param request
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/selectById")
    @ApiOperation(value = "查询商超供应商明细")
    public BaseResponseInfo selectById(@RequestParam("supplierId") Long supplierId, HttpServletRequest request) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        Map<String, Object> map = new HashMap<>();

        List<SupermarketAccount> accountList = null;
        List<SupermarketAttachment> attachmentList = null;
        List<SupermarketContact> contactList = null;
        List<SupermarketCooperation> cooperationList = null;
        List<SupermarketInvoice> invoiceList = null;
        try {
            accountList = supermarketAccountService.getAccountListBySupplierId(supplierId);
            attachmentList = supermarketAttachmentService.getSupermarketAttachmentList(supplierId);
            contactList = supermarketContactService.getSupermarketContactList(supplierId);
            cooperationList = supermarketCooperationService.getSupermarketCooperationList(supplierId);
            invoiceList = supermarketInvoiceService.getSupermarketInvoiceList(supplierId);
            map.put("accountList", accountList);
            map.put("attachmentList", attachmentList);
            map.put("contactList", contactList);
            map.put("cooperationList", cooperationList);
            map.put("invoiceList", invoiceList);
            res.code = 200;
            res.data = map;
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = "获取数据失败";

        }
        return res;
    }

    /**
     * 查找供应商信息-下拉框
     *
     * @param request
     * @return
     */
    @PostMapping(value = "/findBySelect")
    @ApiOperation(value = "查找供应商信息")
    public JSONArray findBySelectSup(HttpServletRequest request) throws Exception {
        JSONArray arr = new JSONArray();
        try {
            List<SupermarketSupplier> supplierList = supermarketSupplierService.findBySelectSup();
            JSONArray dataArray = new JSONArray();
            if (null != supplierList) {
                for (SupermarketSupplier supplier : supplierList) {
                    JSONObject item = new JSONObject();
                    item.put("id", supplier.getId());
                    item.put("name", supplier.getName());
                    item.put("number", supplier.getNumber());
                    dataArray.add(item);
                }
            }
            arr = dataArray;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }

    /**
     * 保存商超供应商明细
     *
     * @param body
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/addSupermarketSupplierDetail")
    @ApiOperation(value = "保存商超供应商明细")
    public Object addSupermarketSupplierDetail(@RequestBody SupermarketSupplierDetailsDTO body, HttpServletRequest request) throws Exception {
        JSONObject result = ExceptionConstants.standardSuccess();
        Long supplierId = body.getSupplierId();
        List<SupermarketAccount> accountList = body.getSupermarketAccountList();
        List<SupermarketAttachment> attachmentList = body.getSupermarketAttachmentList();
        List<SupermarketContact> contactList = body.getSupermarketContactList();
        List<SupermarketCooperation> cooperationList = body.getSupermarketCooperationList();
        List<SupermarketInvoice> invoiceList = body.getSupermarketInvoiceList();
        supermarketSupplierService.addSupermarketSupplierDetail(supplierId, accountList, attachmentList, contactList, cooperationList, invoiceList, request);
        return result;
    }

    /**
     * 批量设置状态-启用和禁用
     *
     * @param jsonObject
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/batchSetActive")
    @ApiOperation(value = "批量设置启用状态")
    public String batchSetActive(@RequestBody JSONObject jsonObject,
                                 HttpServletRequest request) throws Exception {
        Boolean enabled = jsonObject.getBoolean("enabled");
        String ids = jsonObject.getString("ids");
        Map<String, Object> objectMap = new HashMap<>();
        int res = supermarketSupplierService.batchSetEnabled(enabled, ids);
        if (res > 0) {
            return returnJson(objectMap, ErpInfo.OK.name, ErpInfo.OK.code);
        } else {
            return returnJson(objectMap, ErpInfo.ERROR.name, ErpInfo.ERROR.code);
        }
    }

    /**
     * 批量设置审核状态
     *
     * @param jsonObject
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/batchSetStatus")
    @ApiOperation(value = "批量设置审核状态")
    public String batchSetStatus(@RequestBody JSONObject jsonObject,
                                 HttpServletRequest request) throws Exception {
        String status = jsonObject.getString("status");
        String ids = jsonObject.getString("ids");
        String comment = jsonObject.getString("comment");
        Map<String, Object> objectMap = new HashMap<>();
        int res = supermarketSupplierService.batchSetStatus(status, ids, comment, request);
        if (res > 0) {
            return returnJson(objectMap, ErpInfo.OK.name, ErpInfo.OK.code);
        } else {
            return returnJson(objectMap, ErpInfo.ERROR.name, ErpInfo.ERROR.code);
        }
    }

    /**
     * 导入商超供应商
     *
     * @param file
     * @param request
     * @param response
     * @return
     */
    @PostMapping(value = "/importSupermarketSupplier")
    @ApiOperation(value = "导入商超供应商")
    public BaseResponseInfo importSupermarketSupplier(MultipartFile file,
                                                      HttpServletRequest request, HttpServletResponse response) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        try {
            supermarketSupplierService.importSupermarketSupplier(file, request);
            res.code = 200;
            res.data = "导入成功";
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = "导入失败";
        }
        return res;
    }

    /**
     * 导入商超供应商详情
     *
     * @param file
     * @param request
     * @param response
     * @return
     */
    @PostMapping(value = "/importSupermarketSupplierDetails")
    @ApiOperation(value = "导入商超供应商详情")
    public BaseResponseInfo importSupermarketSupplierDetails(MultipartFile file,
                                                             HttpServletRequest request, HttpServletResponse response) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        try {
            supermarketSupplierService.importSupermarketSupplierDetails(file, request);
            res.code = 200;
            res.data = "导入成功";
        } catch (BusinessRunTimeException e) {
            res.code = e.getCode();
            res.data = e.getData().get("message");
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = "导入失败";
        }
        return res;
    }

    /**
     * 生成excel表格
     *
     * @param request
     * @param response
     */
    @GetMapping(value = "/exportExcel")
    public void exportExcel(@RequestParam(value = "selections", required = false) List<Long> ids,
                            HttpServletRequest request, HttpServletResponse response) {
        try {
            File file = supermarketSupplierService.exportExcel(ids);
            ExcelUtils.downloadExcel(file, file.getName(), response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询所有账户信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/getSupermarketAccountList")
    @ApiOperation(value = "查询所有账户信息")
    public BaseResponseInfo getSupermarketAccountList(HttpServletRequest request) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        JSONArray array = new JSONArray();

        List<SupermarketAccountVoList> accountList;
        try {
            accountList = supermarketAccountService.getSupermarketAccountList();
            for (SupermarketAccountVoList supermarketAccount : accountList) {
                JSONObject object = new JSONObject();
                object.put("id", supermarketAccount.getId());
                object.put("name", supermarketAccount.getAccountName());
                object.put("bankName", supermarketAccount.getBankName());
                object.put("accountNumber", supermarketAccount.getAccountNumber());
                object.put("supplierId",supermarketAccount.getSupplierId());
                object.put("supplierName",supermarketAccount.getSupplierName());
                array.add(object);
            }
            res.code = 200;
            res.data = array;
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = "获取数据失败";
        }
        return res;
    }

}
