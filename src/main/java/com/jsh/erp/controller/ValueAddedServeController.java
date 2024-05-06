package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.service.valueAddedServe.ValueAddedServeService;
import com.jsh.erp.utils.ErpInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import static com.jsh.erp.utils.ResponseJsonUtil.returnJson;

@RestController
@RequestMapping(value = "/valueAddedServe")
@Api(tags = {"增值服务"})
public class ValueAddedServeController {
    private Logger logger = LoggerFactory.getLogger(ValueAddedServeController.class);

    @Resource
    private ValueAddedServeService valueAddedServeService;


    @PostMapping(value = "/batchSetActive")
    @ApiOperation(value = "批量设置启用状态")
    public String batchSetActive(@RequestBody JSONObject jsonObject,
                                 HttpServletRequest request) throws Exception {
        Boolean enabled = jsonObject.getBoolean("enabled");
        String ids = jsonObject.getString("ids");
        Map<String, Object> objectMap = new HashMap<>();
        int res = valueAddedServeService.batchSetActive(enabled, ids);
        if (res > 0) {
            return returnJson(objectMap, ErpInfo.OK.name, ErpInfo.OK.code);
        } else {
            return returnJson(objectMap, ErpInfo.ERROR.name, ErpInfo.ERROR.code);
        }
    }
}
