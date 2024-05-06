package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.datasource.entities.SalesChannel;
import com.jsh.erp.datasource.entities.ShippingMethod;
import com.jsh.erp.service.salesChannel.SalesChannelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "salesChannel")
@Api(tags = {"销售渠道管理"})
public class SalesChannelController {

    @Resource
    private SalesChannelService salesChannelService;

    /**
     * 查询所有销售渠道-下拉框
     * @param request
     * @return
     */
    @PostMapping(value = "/findBySalesChannel")
    @ApiOperation(value = "查询所有销售渠道")
    public JSONArray findByShippingMethod(HttpServletRequest request) {
        JSONArray array = new JSONArray();
        try {
            List<SalesChannel> salesChannelList = salesChannelService.findBySalesChannel();
            if (salesChannelList != null) {
                JSONArray dateArray = new JSONArray();
                for (SalesChannel salesChannel : salesChannelList) {
                    JSONObject item = new JSONObject();
                    item.put("id", salesChannel.getId());
                    item.put("name", salesChannel.getName());
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
