package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.datasource.entities.ShippingMethod;
import com.jsh.erp.service.shippingMethod.ShippingMethodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "shippingMethod")
@Api(tags = {"运输方式管理"})
public class ShippingMethodController {
    @Resource
    private ShippingMethodService shippingMethodService;

    /**
     * 查询物流方式-下拉框
     * @param request
     * @return
     */
    @PostMapping(value = "/findByShippingMethod")
    @ApiOperation(value = "查询所有物流方式")
    public JSONArray findByShippingMethod(HttpServletRequest request) {
        JSONArray array = new JSONArray();
        try {
            List<ShippingMethod> shippingMethods = shippingMethodService.findByShippingMethod();
            if (shippingMethods != null) {
                JSONArray dateArray = new JSONArray();
                for (ShippingMethod method : shippingMethods) {
                    JSONObject item = new JSONObject();
                    item.put("id", method.getId());
                    item.put("name", method.getName());
                    dateArray.add(item);
                }
                array = dateArray;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }
}
