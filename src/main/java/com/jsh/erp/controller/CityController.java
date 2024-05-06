package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.datasource.entities.City;
import com.jsh.erp.datasource.entities.Province;
import com.jsh.erp.service.city.CityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/city")
@Api(tags = {"市管理"})
public class CityController {
    @Resource
    private CityService cityService;

    /**
     * 查找市信息-下拉框
     *
     * @param request
     * @return
     */
    @PostMapping(value = "/getCityByProvinceId")
    @ApiOperation(value = "查找市信息")
    public JSONArray getCityByProvinceId(@RequestParam("provinceId") Long provinceId, HttpServletRequest request) throws Exception {
        JSONArray arr = new JSONArray();
        try {
            List<City> cityList = cityService.getCityByProvinceId(provinceId);
            JSONArray dataArray = new JSONArray();
            if (null != cityList) {
                for (City city : cityList) {
                    JSONObject item = new JSONObject();
                    item.put("id", city.getId());
                    item.put("city", city.getCityName());
                    item.put("number", city.getCityNumber());
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
