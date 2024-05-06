package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.entities.SupermarketFinanceExtend;
import com.jsh.erp.service.supermarketFinanceExtend.SupermarketFinanceExtendService;
import com.jsh.erp.utils.BaseResponseInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/supermarketFinanceExtend")
@Api(tags = {"商超财务子数据管理"})
public class SupermarketFinanceExtendController {

    @Resource
    private SupermarketFinanceExtendService supermarketFinanceExtendService;

    @PostMapping(value = "/uploadProofOfPayment")
    @ApiOperation(value = "上传付款凭证")
    public Object uploadProofOfPayment(@RequestBody SupermarketFinanceExtend sfe, HttpServletRequest request) throws Exception {
        JSONObject result = ExceptionConstants.standardSuccess();
        supermarketFinanceExtendService.uploadProofOfPayment(sfe, request);
        return result;
    }

    @PostMapping(value = "/updateStatus")
    @ApiOperation(value = "修改下载或结款状态")
    public Object updateStatus(@RequestBody JSONObject requestBody, HttpServletRequest request) throws Exception {
        JSONObject result = ExceptionConstants.standardSuccess();
        String ids = requestBody.getString("ids");
        String downloadStatus = requestBody.getString("downloadStatus");
        String paymentStatus = requestBody.getString("paymentStatus");
        Long financeId = requestBody.getLong("financeId");
        supermarketFinanceExtendService.updateStatus(ids, downloadStatus, paymentStatus, financeId, request);
        return result;
    }

    @GetMapping(value = "/getProofOfPaymentByFinanceId")
    @ApiOperation(value = "根据财务id查询付款凭证")
    public Object getProofOfPaymentByFinanceId(@RequestParam(value = "linkId") Long linkId, HttpServletRequest request) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        try {
            List<SupermarketFinanceExtend> list = supermarketFinanceExtendService.getProofOfPaymentByFinanceId(linkId, request);
            res.code = 200;
            res.data = list;
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = "获取数据失败";
        }
        return res;
    }
}
