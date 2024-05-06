package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.datasource.entities.TaxLevel;
import com.jsh.erp.service.taxLevel.TaxLevelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "taxLevel")
@Api(tags = {"供应商纳税级别管理"})
public class TaxLevelController {

    @Resource
    private TaxLevelService taxLevelService;

    /**
     * 查找所有纳税级别-下拉框
     *
     * @param request
     * @return
     */
    @PostMapping(value = "/findByTaxLevel")
    @ApiOperation(value = "查找所有纳税级别")
    public JSONArray findBySelectSup(HttpServletRequest request) throws Exception {
        JSONArray arr = new JSONArray();
        try {
            List<TaxLevel> taxLevelList = taxLevelService.findByTaxLevel();
            JSONArray dataArray = new JSONArray();
            if (null != taxLevelList) {
                for (TaxLevel taxLevel : taxLevelList) {
                    JSONObject item = new JSONObject();
                    item.put("id", taxLevel.getId());
                    item.put("name", taxLevel.getName());
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
