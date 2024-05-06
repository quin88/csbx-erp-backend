package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.datasource.entities.SourceType;
import com.jsh.erp.service.sourceType.SourceTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/sourceType")
@Api(tags = {"商品来源类型管理"})
public class SourceTypeController {

    @Resource
    private SourceTypeService sourceTypeService;

    /**
     * 查找所有的来源信息-下拉框
     *
     * @param request
     * @return
     */
    @PostMapping(value = "/findBySourceType")
    @ApiOperation(value = "查找所有的来源信息")
    public JSONArray findBySelectSup(HttpServletRequest request) throws Exception {
        JSONArray arr = new JSONArray();
        try {
            List<SourceType> sourceTypeList = sourceTypeService.findBySourceType();
            JSONArray dataArray = new JSONArray();
            if (null != sourceTypeList) {
                for (SourceType sourceType : sourceTypeList) {
                    JSONObject item = new JSONObject();
                    item.put("id", sourceType.getId());
                    item.put("name", sourceType.getName());
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
