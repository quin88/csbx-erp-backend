package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.datasource.entities.BusinessType;
import com.jsh.erp.service.businessType.BusinessTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/businessType")
@Api(tags = {"企业类型管理"})
public class BusinessTypeController {

    @Resource
    private BusinessTypeService businessTypeService;

    /**
     * 查找所有企业类型-下拉框
     *
     * @param request
     * @return
     */
    @PostMapping(value = "/findByBusinessType")
    @ApiOperation(value = "查找所有企业类型")
    public JSONArray findByBusinessType(HttpServletRequest request) throws Exception {
        JSONArray arr = new JSONArray();
        try {
            List<BusinessType> businessTypeList = businessTypeService.findByBusinessType();
            JSONArray dataArray = new JSONArray();
            if (null != businessTypeList) {
                for (BusinessType businessType : businessTypeList) {
                    JSONObject item = new JSONObject();
                    item.put("id", businessType.getId());
                    item.put("name", businessType.getName());
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

