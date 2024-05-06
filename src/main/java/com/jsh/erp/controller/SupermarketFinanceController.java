package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.entities.SupermarketFinanceVo4Body;
import com.jsh.erp.service.supermarketFinance.SupermarketFinanceService;
import com.jsh.erp.utils.BaseResponseInfo;
import com.jsh.erp.utils.ErpInfo;
import com.jsh.erp.utils.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import static com.jsh.erp.utils.ResponseJsonUtil.returnJson;

@RestController
@RequestMapping(value = "/supermarketFinance")
@Api(tags = {"商超财务管理"})
public class SupermarketFinanceController {

    @Resource
    private SupermarketFinanceService supermarketFinanceService;

    @PostMapping(value = "/addSupermarketFinanceAndDetail")
    @ApiOperation(value = "新增商超财务和详情")
    public Object addSupermarketFinanceAndDetail(@RequestBody SupermarketFinanceVo4Body body, HttpServletRequest request) throws Exception {
        JSONObject result = ExceptionConstants.standardSuccess();
        supermarketFinanceService.addSupermarketFinanceAndDetail(body, request);
        return result;
    }

    @PutMapping(value = "/updateSupermarketFinanceAndDetail")
    @ApiOperation(value = "编辑商超财务和详情")
    public Object updateSupermarketFinanceAndDetail(@RequestBody SupermarketFinanceVo4Body body, HttpServletRequest request) throws Exception {
        JSONObject result = ExceptionConstants.standardSuccess();
        supermarketFinanceService.updateSupermarketFinanceAndDetail(body, request);
        return result;
    }
    
    @GetMapping(value = "/findBySelect")
    @ApiOperation(value = "根据id查询商超财务数据")
    public Object findBySelect(@RequestParam(value = "id") Long id, HttpServletRequest request) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        try {
            JSONObject list = supermarketFinanceService.findByCondition(id);
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
        Long id = jsonObject.getLong("id");
        String comment = jsonObject.getString("comment");
        Map<String, Object> objectMap = new HashMap<>();
        int res = supermarketFinanceService.batchSetStatus(status, id, comment, request);
        if (res > 0) {
            return returnJson(objectMap, ErpInfo.OK.name, ErpInfo.OK.code);
        } else {
            return returnJson(objectMap, ErpInfo.ERROR.name, ErpInfo.ERROR.code);
        }
    }
}
