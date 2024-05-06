package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.datasource.entities.TemperatureCondition;
import com.jsh.erp.service.temperatureCondition.TemperatureConditionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/temperatureCondition")
@Api(tags = {"温度条件管理"})
public class TemperatureConditionController {

    @Resource
    private TemperatureConditionService temperatureConditionService;

    /**
     * 查找所有温度条件-下拉框
     *
     * @param request
     * @return
     */
    @PostMapping(value = "/findByTemperatureCondition")
    @ApiOperation(value = "查找所有温度条件")
    public JSONArray findByTemperatureCondition(HttpServletRequest request) throws Exception {
        JSONArray arr = new JSONArray();
        try {
            List<TemperatureCondition> temperatureConditionList = temperatureConditionService.findByTemperatureCondition();
            JSONArray dataArray = new JSONArray();
            if (null != temperatureConditionList) {
                for (TemperatureCondition temperatureCondition : temperatureConditionList) {
                    JSONObject item = new JSONObject();
                    item.put("id", temperatureCondition.getId());
                    item.put("name", temperatureCondition.getName());
                    dataArray.add(item);
                }
            }
            arr = dataArray;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }
}
