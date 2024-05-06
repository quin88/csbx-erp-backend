package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.datasource.entities.GoodsAllocation;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.goodsAllocation.GoodsAllocationService;
import com.jsh.erp.utils.BaseResponseInfo;
import com.jsh.erp.utils.ErpInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.jsh.erp.utils.ResponseJsonUtil.returnJson;

/**
 * @author ji sheng hua jshERP
 */
@RestController
@RequestMapping(value = "/goodsAllocation")
@Api(tags = {"货位管理"})
public class GoodsAllocationController {
    private Logger logger = LoggerFactory.getLogger(GoodsAllocationController.class);

    @Resource
    private GoodsAllocationService goodsAllocationService;


    /**
     * 批量设置状态--启用禁用
     *
     * @param jsonObject
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/batchSetActive")
    @ApiOperation(value = "批量设置状态")
    public String batchSetActive(@RequestBody JSONObject jsonObject,
                                 HttpServletRequest request) throws Exception {
        Boolean enabled = jsonObject.getBoolean("enabled");
        String ids = jsonObject.getString("ids");
        Map<String, Object> objectMap = new HashMap<>();
        int res = goodsAllocationService.batchSetActive(enabled, ids);
        if (res > 0) {
            return returnJson(objectMap, ErpInfo.OK.name, ErpInfo.OK.code);
        } else {
            return returnJson(objectMap, ErpInfo.ERROR.name, ErpInfo.ERROR.code);
        }
    }

    /**
     * excel表格导入货位
     *
     * @param file
     * @param request
     * @param response
     * @return
     */
    @PostMapping(value = "/importExcel")
    @ApiOperation(value = "excel表格导入货位")
    public BaseResponseInfo importExcel(MultipartFile file,
                                        HttpServletRequest request, HttpServletResponse response) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        try {
            res = goodsAllocationService.importExcel(file, request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    /* 查询货位-下拉框
     *
     * @param depotId
     * @param active
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/findBySelect")
    @ApiOperation(value = "查询货位-下拉框")
    public JSONArray findBySelect(@RequestParam Long depotId, @RequestParam boolean active) throws Exception {
        JSONArray array = new JSONArray();
        try {
            List<GoodsAllocation> list = goodsAllocationService.findBySelect(depotId, active);
            if (!list.isEmpty()) {
                for (GoodsAllocation goodsAllocation : list) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("id", goodsAllocation.getId());
                    jsonObject.put("goodsAllocation", goodsAllocation.getGoodsAllocation());
                    array.add(jsonObject);
                }
            }
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return array;
    }
}
