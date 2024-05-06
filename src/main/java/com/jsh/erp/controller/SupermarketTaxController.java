package com.jsh.erp.controller;

import com.jsh.erp.datasource.dto.SupermarketTaxDTO;
import com.jsh.erp.datasource.entities.SupermarketServeClient;
import com.jsh.erp.datasource.entities.SupermarketTax;
import com.jsh.erp.service.supermarketTax.SupermarketTaxService;
import com.jsh.erp.utils.BaseResponseInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/supermarketTax")
@Api(tags = {"商超税率接口管理"})
public class SupermarketTaxController {
    private Logger logger = LoggerFactory.getLogger(SupermarketTaxController.class);

    @Resource
    private SupermarketTaxService supermarketTaxService;


    @PostMapping(value = "/addSupermarketTax")
    @ApiOperation(value = "保存商超税率")
    public Object addSupermarketTax(@RequestBody SupermarketTaxDTO body, HttpServletRequest request) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        try {
            List<SupermarketTax> supermarketTax = body.getSupermarketTax();
            String deleteId = body.getDeleteId();
            supermarketTaxService.addSupermarketTax(supermarketTax, deleteId, request);
            res.code = 200;
            res.data = "新增成功！";
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = e.getMessage();
        }
        return res;
    }
}
