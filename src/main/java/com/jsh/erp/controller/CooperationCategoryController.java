package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.datasource.entities.CooperationCategory;
import com.jsh.erp.datasource.entities.Country;
import com.jsh.erp.datasource.mappers.CooperationCategoryMapper;
import com.jsh.erp.datasource.mappers.CooperationCategoryMapperEx;
import com.jsh.erp.datasource.mappers.CountryMapperEx;
import com.jsh.erp.utils.BaseResponseInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/cooperationCategory")
@Api(tags = {"合作品类管理"})
public class CooperationCategoryController {
    @Resource
    private CooperationCategoryMapperEx cooperationCategoryMapperEx;


    /**
     * 查询所有的合作品类-下拉框
     * @return
     */
    @GetMapping("/getCooperationCategoryList")
    @ApiOperation(value = "查询所有的合作品类")
    public BaseResponseInfo getCountryList() {

        BaseResponseInfo res = new BaseResponseInfo();
        try {
            List<CooperationCategory> cooperationCategoryList = cooperationCategoryMapperEx.getCooperationCategoryList();
            JSONArray cooperationCategoryArray = new JSONArray();
            for (CooperationCategory cooperationCategory : cooperationCategoryList) {
                JSONObject item = new JSONObject();
                item.put("id", cooperationCategory.getId());
                item.put("name", cooperationCategory.getName());

                cooperationCategoryArray.add(item);
            }
            res.code = 200;
            res.data = cooperationCategoryArray;
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = "获取数据失败";
        }
        return res;
    }
}

