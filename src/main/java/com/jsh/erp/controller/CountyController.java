package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.datasource.entities.County;
import com.jsh.erp.service.county.CountyService;
import com.jsh.erp.utils.ErpInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.jsh.erp.utils.ResponseJsonUtil.returnJson;

@RestController
@RequestMapping(value = "/county")
@Api(tags = {"产地管理"})
public class CountyController {

    @Resource
    private CountyService countyService;

    /**
     * 查找区/县信息-下拉框
     *
     * @param request
     * @return
     */
    @PostMapping(value = "/getCountyById")
    @ApiOperation(value = "查找区/县信息")
    public JSONArray getCountyById(@RequestParam(value = "provinceId", required = false) Long provinceId,
                                       @RequestParam(value = "cityId", required = false) Long cityId,
                                       HttpServletRequest request) throws Exception {
        JSONArray arr = new JSONArray();
        try {
            List<County> countyList = countyService.getCountyById(provinceId, cityId);
            JSONArray dataArray = new JSONArray();
            if (null != countyList) {
                for (County county : countyList) {
                    JSONObject item = new JSONObject();
                    item.put("id", county.getId());
                    item.put("county", county.getCountyName());
                    item.put("number", county.getCountyNumber());
                    dataArray.add(item);
                }
            }
            arr = dataArray;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }

    /**
     * 批量设置状态-启用和禁用
     *
     * @param jsonObject
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/batchSetActive")
    @ApiOperation(value = "批量设置启用状态")
    public String batchSetActive(@RequestBody JSONObject jsonObject,
                                 HttpServletRequest request) throws Exception {
        Boolean enabled = jsonObject.getBoolean("enabled");
        String ids = jsonObject.getString("ids");
        Map<String, Object> objectMap = new HashMap<>();
        int res = countyService.batchSetActive(enabled, ids);
        if (res > 0) {
            return returnJson(objectMap, ErpInfo.OK.name, ErpInfo.OK.code);
        } else {
            return returnJson(objectMap, ErpInfo.ERROR.name, ErpInfo.ERROR.code);
        }
    }
}
