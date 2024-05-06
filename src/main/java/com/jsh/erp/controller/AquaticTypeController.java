package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.datasource.entities.AquaticType;
import com.jsh.erp.service.aquaticType.AquaticTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/aquaticType")
@Api(tags = {"水产类型管理"})
public class AquaticTypeController {
    @Resource
    private AquaticTypeService aquaticTypeService;

    /**
     * 查找所有水产类型-下拉框
     *
     * @param request
     * @return
     */
    @PostMapping(value = "/findByAquaticType")
    @ApiOperation(value = "查找所有水产类型")
    public JSONArray findByAquaticType(HttpServletRequest request) throws Exception {
        JSONArray arr = new JSONArray();
        try {
            List<AquaticType> aquaticTypeList = aquaticTypeService.findByAquaticType();
            JSONArray dataArray = new JSONArray();
            if (null != aquaticTypeList) {
                for (AquaticType aquaticType : aquaticTypeList) {
                    JSONObject item = new JSONObject();
                    item.put("id", aquaticType.getId());
                    item.put("name", aquaticType.getName());
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
