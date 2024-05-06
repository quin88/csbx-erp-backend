package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.datasource.entities.SupermarketUnit;
import com.jsh.erp.service.supermarketUnit.SupermarketUnitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/supermarketUnit")
@Api(tags = {"商超单位管理"})
public class SupermarketUnitController {

    @Resource
    private SupermarketUnitService supermarketUnitService;

    /**
     * 查询所有单位-下拉框
     * @param request
     * @return
     */
    @PostMapping(value = "/findBySupermarketUnit")
    @ApiOperation(value = "查询所有单位")
    public JSONArray findBySupermarketUnit(HttpServletRequest request) {
        JSONArray array = new JSONArray();
        try {
            List<SupermarketUnit> unitList = supermarketUnitService.findBySupermarketUnit();
            if (unitList != null) {
                JSONArray dateArray = new JSONArray();
                for (SupermarketUnit unit : unitList) {
                    JSONObject item = new com.alibaba.fastjson.JSONObject();
                    item.put("id", unit.getId());
                    item.put("name", unit.getName());
                    dateArray.add(item);
                }
                array = dateArray;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return array;
    }
}
