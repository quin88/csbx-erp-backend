package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.entities.SupermarketReconciliationVo4Body;
import com.jsh.erp.service.supermarketReconciliation.SupermarketReconciliationService;
import com.jsh.erp.utils.BaseResponseInfo;
import com.jsh.erp.utils.ErpInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import static com.jsh.erp.utils.ResponseJsonUtil.returnJson;

@RestController
@RequestMapping(value = "/supermarketReconciliation")
@Api(tags = {"商超对账管理"})
public class SupermarketReconciliationController {

    @Resource
    private SupermarketReconciliationService supermarketReconciliationService;

    @PostMapping(value = "/addSupermarketReconciliationAndDetail")
    @ApiOperation(value = "新增商超对账和详情")
    public Object addSupermarketReconciliationAndDetail(@RequestBody SupermarketReconciliationVo4Body body, HttpServletRequest request) throws Exception {
        JSONObject result = ExceptionConstants.standardSuccess();
        supermarketReconciliationService.addSupermarketReconciliationAndDetail(body, request);
        return result;
    }

    @PutMapping(value = "/updateSupermarketReconciliationAndDetail")
    @ApiOperation(value = "编辑商超对账和详情")
    public Object updateSupermarketFinanceAndDetail(@RequestBody SupermarketReconciliationVo4Body body, HttpServletRequest request) throws Exception {
        JSONObject result = ExceptionConstants.standardSuccess();
        supermarketReconciliationService.updateSupermarketReconciliationAndDetail(body, request);
        return result;
    }
    
    @GetMapping(value = "/findBySelect")
    @ApiOperation(value = "根据id查询商超对账数据")
    public Object findBySelect(@RequestParam(value = "id") Long id, HttpServletRequest request) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        try {
            JSONObject list = supermarketReconciliationService.findByCondition(id);
            res.code = 200;
            res.data = list;
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = "获取数据失败";
        }
        return res;
    }

    @PostMapping(value = "/batchSetStatus")
    @ApiOperation(value = "审核接口")
    public String batchSetStatus(@RequestBody JSONObject jsonObject,
                                 HttpServletRequest request) throws Exception {
        String status = jsonObject.getString("status");
        String ids = jsonObject.getString("ids");
        String comment = jsonObject.getString("comment");
        Map<String, Object> objectMap = new HashMap<>();
        int res = supermarketReconciliationService.batchSetStatus(status, ids, comment, request);
        if (res > 0) {
            return returnJson(objectMap, ErpInfo.OK.name, ErpInfo.OK.code);
        } else {
            return returnJson(objectMap, ErpInfo.ERROR.name, ErpInfo.ERROR.code);
        }
    }
}
