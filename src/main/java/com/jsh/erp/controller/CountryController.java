package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.datasource.entities.Country;
import com.jsh.erp.datasource.mappers.CountryMapperEx;
import com.jsh.erp.utils.BaseResponseInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/country")
@Api(tags = {"国家管理"})
public class CountryController {
    private Logger logger = LoggerFactory.getLogger(CountryController.class);

    @Resource
    private CountryMapperEx countryMapperEx;


    @GetMapping("/getCountryList")
    @ApiOperation(value = "获取国家列表")
    public BaseResponseInfo getCountryList() {

        BaseResponseInfo res = new BaseResponseInfo();
        try {
            List<Country> countryList = countryMapperEx.getCountryList();
            JSONArray countryArray = new JSONArray();
            for (Country country : countryList) {
                JSONObject countryObj = new JSONObject();
                countryObj.put("id", country.getId());
                countryObj.put("country_name", country.getCountryName());
                countryObj.put("country_number", country.getCountryNumber());

                countryArray.add(countryObj);
            }
            res.code = 200;
            res.data = countryArray;
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = "获取数据失败";
        }
        return res;
    }
}

