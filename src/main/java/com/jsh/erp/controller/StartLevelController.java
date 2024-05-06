package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.datasource.entities.SourceType;
import com.jsh.erp.datasource.entities.StarLevel;
import com.jsh.erp.service.startLevel.StartLevelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "startLevel")
@Api(tags = {"供应商星级管理"})
public class StartLevelController {
    @Resource
    private StartLevelService startLevelService;

    /**
     * 查找所有星级信息-下拉框
     *
     * @param request
     * @return
     */
    @PostMapping(value = "/findByStartLevel")
    @ApiOperation(value = "查找所有星级信息")
    public JSONArray findByStartLevel(HttpServletRequest request) throws Exception {
        JSONArray arr = new JSONArray();
        try {
            List<StarLevel> starLevelList = startLevelService.findByStartLevel();
            JSONArray dataArray = new JSONArray();
            if (null != starLevelList) {
                for (StarLevel starLevel : starLevelList) {
                    JSONObject item = new JSONObject();
                    item.put("id", starLevel.getId());
                    item.put("name", starLevel.getName());
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
