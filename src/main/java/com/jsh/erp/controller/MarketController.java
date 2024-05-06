package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.datasource.entities.MarketVo4Body;
import com.jsh.erp.service.market.MarketService;
import com.jsh.erp.utils.ErpInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import static com.jsh.erp.utils.ResponseJsonUtil.returnJson;

@RestController
@RequestMapping(value = "/market")
@Api(tags = {"市场管理"})
public class MarketController {
    private Logger logger = LoggerFactory.getLogger(MarketController.class);
    @Resource
    private MarketService marketService;

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
        int res = marketService.batchSetActive(enabled, ids);
        if (res > 0) {
            return returnJson(objectMap, ErpInfo.OK.name, ErpInfo.OK.code);
        } else {
            return returnJson(objectMap, ErpInfo.ERROR.name, ErpInfo.ERROR.code);
        }
    }

    @PostMapping(value = "/addMarketAndArea")
    @ApiOperation(value = "新增市场信息")
    public Object addMarketAndArea(@RequestBody MarketVo4Body body,
                                   HttpServletRequest request) throws Exception {
        return marketService.addMarketAndArea(body, request);
    }

    @PutMapping(value = "/updateMarketAndArea")
    @ApiOperation(value = "编辑市场信息")
    public Object updateMarketAndArea(@RequestBody MarketVo4Body body,
                                      HttpServletRequest request) throws Exception {
        return marketService.updateMarketAndArea(body, request);
    }

    @GetMapping(value = "/findById")
    @ApiOperation(value = "编辑市场信息")
    public Object findById(@RequestParam(value = "id", required = false) Long id,
                               HttpServletRequest request) throws Exception {

        return marketService.findById(id, request);
    }

}
