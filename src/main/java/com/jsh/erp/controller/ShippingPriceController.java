package com.jsh.erp.controller;

import com.jsh.erp.datasource.vo.ShippingPriceVo;
import com.jsh.erp.service.shippingPrice.ShippingPriceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author CSBX 75271*8920
 */
@RestController
@RequestMapping(value = "/shippingPrice")
@Api(tags = {"物流费用"})
public class ShippingPriceController {
    private Logger logger = LoggerFactory.getLogger(ShippingPriceController.class);

    @Resource
    private ShippingPriceService shippingPriceService;


    @PostMapping(value = "/addShippingPrice")
    @ApiOperation(value = "新增物流费用")
    public Object addShippingPrice(@RequestBody ShippingPriceVo shippingPriceVo,
                                   HttpServletRequest request) throws Exception {
        return shippingPriceService.addShippingPrice(shippingPriceVo, request);
    }

    @PutMapping(value = "/updateShippingPrice")
    @ApiOperation(value = "编辑物流费用")
    public Object updatePriceDetails(@RequestBody ShippingPriceVo shippingPriceVo, HttpServletRequest request) throws Exception {
        return shippingPriceService.updatePriceDetails(shippingPriceVo, request);
    }

    @GetMapping(value = "/selectShippingPrice")
    @ApiOperation(value = "查看物流费用")
    public Object selectPriceDetails(@RequestParam String receiptsNumber, HttpServletRequest request) throws Exception {
        return shippingPriceService.selectPriceDetails(receiptsNumber, request);
    }

    /**
     * 批量设置状态-审核或者反审核
     * @param jsonObject
     * @param request
     * @return
     */
   /* @PostMapping(value = "/batchSetStatus")
    @ApiOperation(value = "批量设置状态-审核或者反审核")
    public String batchSetStatus(@RequestBody JSONObject jsonObject,
                                 HttpServletRequest request) throws Exception{
        Map<String, Object> objectMap = new HashMap<>();
        String status = jsonObject.getString("status");
        String receiptsNumbers = jsonObject.getString("receiptsNumber");
        int res = shippingPriceService.batchSetStatus(status, receiptsNumbers);

        if(res > 0) {
            return returnJson(objectMap, ErpInfo.OK.name, ErpInfo.OK.code);
        } else {
            return returnJson(objectMap, ErpInfo.ERROR.name, ErpInfo.ERROR.code);
        }
    }*/
}