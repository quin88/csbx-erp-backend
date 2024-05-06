package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.datasource.entities.Supplier;
import com.jsh.erp.datasource.entities.SupplierLevel;
import com.jsh.erp.service.supplierLevel.SupplierLevelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/supplierLevel")
@Api(tags = {"供应商级别管理"})
public class SupplierLevelController {
    @Resource
    private SupplierLevelService supplierLevelService;

    /**
     * 查找所有供应商级别-下拉框
     *
     * @param request
     * @return
     */
    @PostMapping(value = "/findBySupplierLevel")
    @ApiOperation(value = "查找所有供应商级别")
    public JSONArray findBySupplierLevel(HttpServletRequest request) throws Exception {
        JSONArray arr = new JSONArray();
        try {
            List<SupplierLevel> supplierLevelList = supplierLevelService.findBySupplierLevel();
            JSONArray dataArray = new JSONArray();
            if (null != supplierLevelList) {
                for (SupplierLevel supplierLevel : supplierLevelList) {
                    JSONObject item = new JSONObject();
                    item.put("id", supplierLevel.getId());
                    item.put("level", supplierLevel.getLevel());
                    item.put("name", supplierLevel.getName());
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
