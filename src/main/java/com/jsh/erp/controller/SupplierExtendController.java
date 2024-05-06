package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.service.supplierExtend.SupplierExtendService;
import com.jsh.erp.utils.ErpInfo;
import com.jsh.erp.utils.QRCodeGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import static com.jsh.erp.utils.ResponseJsonUtil.returnJson;

@RestController
@RequestMapping(value = "/supplierExtend")
@Api(tags = {"供应商子账户明细"})
public class SupplierExtendController {
    private Logger logger = LoggerFactory.getLogger(SupplierExtendController.class);

    @Resource
    private SupplierExtendService supplierExtendService;

    /**
     * 批量设置状态-审核和反审核
     *
     * @param jsonObject
     * @param request
     * @return
     */
    @PostMapping(value = "/batchSetStatus")
    @ApiOperation(value = "批量设置状态")
    public String batchSetStatus(@RequestBody JSONObject jsonObject,
                                 HttpServletRequest request) throws Exception {
        String status = jsonObject.getString("status");
        String ids = jsonObject.getString("ids");
        String comment = jsonObject.getString("comment");
        Map<String, Object> objectMap = new HashMap<>();
        int res = supplierExtendService.batchSetStatus(status, ids, comment, request);
        if (res > 0) {
            return returnJson(objectMap, ErpInfo.OK.name, ErpInfo.OK.code);
        } else {
            return returnJson(objectMap, ErpInfo.ERROR.name, ErpInfo.ERROR.code);
        }
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
        Boolean active = jsonObject.getBoolean("active");
        String ids = jsonObject.getString("ids");
        Map<String, Object> objectMap = new HashMap<>();
        int res = supplierExtendService.batchSetActive(active, ids);
        if (res > 0) {
            return returnJson(objectMap, ErpInfo.OK.name, ErpInfo.OK.code);
        } else {
            return returnJson(objectMap, ErpInfo.ERROR.name, ErpInfo.ERROR.code);
        }
    }

   /* @GetMapping("/generateQRCode")
    @ApiOperation(value = "生成子账户注册二维码")
    public ResponseEntity<byte[]> generateQRCode(@RequestParam String url, @RequestParam String supplier, @RequestParam String supplierId) {

        String content = "URL: " + url + ", Supplier: " + supplier + ", SupplierId: " + supplierId;
        byte[] qrCodeImage = QRCodeGenerator.generateQRCode(content, 200, 200);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);

        return new ResponseEntity<>(qrCodeImage, headers, HttpStatus.OK);
    }*/
}
