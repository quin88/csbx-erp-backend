package com.jsh.erp.controller;

import com.jsh.erp.datasource.vo.PriceDetailsVo;
import com.jsh.erp.service.priceDetails.PriceDetailsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 费用明细
 */
@RestController
@RequestMapping(value = "/priceDetails")
@Api(tags = {"费用明细"})
public class PriceDetailsController {

    private Logger logger = LoggerFactory.getLogger(PriceDetailsController.class);

    @Resource
    private PriceDetailsService priceDetailsService;

    @PostMapping(value = "/addPriceDetails")
    @ApiOperation(value = "新增费用明细")
    public Object addPriceDetails(@RequestBody PriceDetailsVo priceDetailsVo, HttpServletRequest request) throws Exception {

        return priceDetailsService.addPriceDetails(priceDetailsVo,null, request);//subType设置为空，此方法被共用，DepotHeadService调用需要传值
    }

    @PutMapping(value = "/updatePriceDetails")
    @ApiOperation(value = "编辑费用明细")
    public Object updatePriceDetails(@RequestBody PriceDetailsVo priceDetailsVo, HttpServletRequest request) throws Exception {
        return priceDetailsService.updatePriceDetails(priceDetailsVo, request);
    }

    @GetMapping(value = "/selectPriceDetails")
    @ApiOperation(value = "查看费用明细")
    public PriceDetailsVo selectPriceDetails(@RequestParam String receiptsNumbers, HttpServletRequest request) throws Exception {

        return priceDetailsService.selectPriceDetails(receiptsNumbers, request);
    }

}
