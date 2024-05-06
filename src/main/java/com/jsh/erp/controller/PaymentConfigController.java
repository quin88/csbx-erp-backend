package com.jsh.erp.controller;

import com.jsh.erp.datasource.dto.PaymentConfigDTO;
import com.jsh.erp.datasource.entities.PaymentConfig;
import com.jsh.erp.service.paymentConfig.PaymentConfigService;
import com.jsh.erp.utils.BaseResponseInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/paymentConfig")
@Api(tags = {"商超付款管理"})
public class PaymentConfigController {
    private Logger logger = LoggerFactory.getLogger(PaymentConfigController.class);

    @Resource
    private PaymentConfigService paymentConfigService;


    @PostMapping(value = "/addPaymentConfig")
    @ApiOperation(value = "保存商超付款配置")
    public Object addPaymentConfig(@RequestBody PaymentConfigDTO body, HttpServletRequest request) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        try {
            List<PaymentConfig> paymentConfigs = body.getPaymentConfigs();
            String deleteId = body.getDeleteId();
            paymentConfigService.addPaymentConfig(paymentConfigs, deleteId, request);
            res.code = 200;
            res.data = "保存成功！";
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = e.getMessage();
        }
        return res;
    }
}
