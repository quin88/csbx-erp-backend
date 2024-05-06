package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.dto.InvoiceNumberDTO;
import com.jsh.erp.datasource.dto.SupermarketMaterialDetailsDTO;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.vo.SupermarketMaterialVoList;
import com.jsh.erp.service.supermarketMaterial.SupermarketMaterialService;
import com.jsh.erp.utils.BaseResponseInfo;
import com.jsh.erp.utils.ErpInfo;
import com.jsh.erp.utils.ExcelUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping(value = "supermarketMaterial")
@Api(tags = {"商超产品管理接口"})
public class SupermarketMaterialController {

    @Resource
    private SupermarketMaterialService supermarketMaterialService;

    @GetMapping(value = "/findMaterialDetails")
    @ApiOperation(value = "查找商超产品详细信息")
    public BaseResponseInfo findMaterialDetails(@RequestParam(value = "materialId", required = false) Long materialId,
                                                HttpServletRequest request) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        try {
            JSONObject data = supermarketMaterialService.findMaterialDetails(materialId);
            res.code = 200;
            res.data = data;
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = "数据查询异常";
        }
        return res;
    }

    @GetMapping(value = "/findBySelect")
    @ApiOperation(value = "查找商超产品信息")
    public BaseResponseInfo findBySelect(@RequestParam(value = "supplierId", required = false) Long supplierId,
                                         @RequestParam(value = "materialParam", required = false) String materialParam,
                                         @RequestParam(value = "temperatureCondition", required = false) String temperatureCondition,
                                         @RequestParam(value = "province", required = false) String province,
                                         @RequestParam(value = "city", required = false) String city,
                                         @RequestParam(value = "county", required = false) String county,
                                         @RequestParam(value = "aquaticType", required = false) String aquaticType,
                                         @RequestParam("currentPage") Integer currentPage,
                                         @RequestParam("pageSize") Integer pageSize,
                                         HttpServletRequest request) throws Exception {
        JSONObject object = new JSONObject();
        BaseResponseInfo baseResponseInfo = new BaseResponseInfo();
        try {
            List<SupermarketMaterialVoList> dataList = supermarketMaterialService.findBySelect(supplierId, materialParam, temperatureCondition, province, city, county, aquaticType, (currentPage - 1) * pageSize, pageSize);
            int total = supermarketMaterialService.findBySelectCount(supplierId, materialParam, temperatureCondition, province, city, county, aquaticType);

            object.put("rows", dataList);
            object.put("total", total);
            baseResponseInfo.code = 200;
            baseResponseInfo.data = object;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return baseResponseInfo;
    }

    /**
     * 保存商超产品的明细
     *
     * @param body
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/addSupermarketMaterialDetail")
    @ApiOperation(value = "保存商超产品的明细")
    public Object addSupermarketMaterialDetail(@RequestBody SupermarketMaterialDetailsDTO body, HttpServletRequest request) throws Exception {
        JSONObject result = ExceptionConstants.standardSuccess();
        Long materialId = body.getMaterialId();
        List<SalesMarket> salesMarketList = body.getSalesMarketList();
        List<SalesInfo> salesInfoList = body.getSalesInfoList();
        List<InvoiceNumber> invoiceList = body.getInvoiceList();
        List<InvoiceNumberDTO> invoiceLists = body.getInvoiceLists();
        List<Long> fileIds = body.getFileIds();
        List<ImageInfo> imageInfoList = body.getImageInfoList();
        List<FileInfo> fileInfoList = body.getFileInfoList();
        supermarketMaterialService.addSupermarketMaterialDetail(materialId, salesMarketList, salesInfoList, invoiceList, invoiceLists,
                fileIds, imageInfoList, fileInfoList, request);
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
        int res = supermarketMaterialService.batchSetEnabled(enabled, ids);
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
        int res = supermarketMaterialService.batchSetStatus(status, ids, comment, request);
        if (res > 0) {
            return returnJson(objectMap, ErpInfo.OK.name, ErpInfo.OK.code);
        } else {
            return returnJson(objectMap, ErpInfo.ERROR.name, ErpInfo.ERROR.code);
        }
    }

    /**
     * 导入商超产品
     *
     * @param file
     * @param request
     * @param response
     * @return
     */
    @PostMapping(value = "/importSupermarketMaterial")
    @ApiOperation(value = "导入商超产品")
    public BaseResponseInfo importSupermarketMaterial(MultipartFile file,
                                                      HttpServletRequest request, HttpServletResponse response) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        try {
            supermarketMaterialService.importSupermarketMaterial(file, request);
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
     * 导入商超产品详细信息
     *
     * @param file
     * @param request
     * @param response
     * @return
     */
    @PostMapping(value = "/importSupermarketMaterialDetails")
    @ApiOperation(value = "导入商超产品详细信息")
    public BaseResponseInfo importSupermarketMaterialDetails(MultipartFile file,
                                                             HttpServletRequest request, HttpServletResponse response) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        try {
            supermarketMaterialService.importSupermarketMaterialDetails(file, request);
            res.code = 200;
            res.data = "导入成功";
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = "导入失败";
        }
        return res;
    }


    @GetMapping(value = "/exportExcel")
    @ApiOperation(value = "导出excel表格")
    public void exportExcel(@RequestParam(value = "selections", required = false) List<Long> ids,
                            HttpServletRequest request, HttpServletResponse response) {
        try {
            File file = supermarketMaterialService.exportExcel(ids);
            ExcelUtils.downloadExcel(file, file.getName(), response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostMapping(value = "/saveInvoiceDetail")
    @ApiOperation(value = "保存发票单据信息")
    public BaseResponseInfo saveInvoiceDetail(@RequestParam List<Long> fileIds, @RequestParam List<String> filePaths,
                                              HttpServletRequest request) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        try {
            supermarketMaterialService.saveInvoiceDetail(fileIds, filePaths, request);
            res.code = 200;
            res.data = "保存成功";
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = "保存失败";
        }
        return res;
    }
}
