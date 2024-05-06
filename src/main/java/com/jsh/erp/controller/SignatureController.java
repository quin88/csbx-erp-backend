package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.datasource.entities.Signature;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.goodsAllocation.GoodsAllocationService;
import com.jsh.erp.service.signature.SignatureService;
import com.jsh.erp.utils.ErpInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.jsh.erp.utils.ResponseJsonUtil.returnJson;

@RestController
@RequestMapping(value = "signature")
@Api(tags = {"签名管理"})
public class SignatureController {

    private Logger logger = LoggerFactory.getLogger(GoodsAllocationService.class);

    @Resource
    private SignatureService signatureService;

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
        int res = signatureService.batchSetActive(enabled, ids);
        if (res > 0) {
            return returnJson(objectMap, ErpInfo.OK.name, ErpInfo.OK.code);
        } else {
            return returnJson(objectMap, ErpInfo.ERROR.name, ErpInfo.ERROR.code);
        }
    }

    @GetMapping(value = "/findBySelect")
    @ApiOperation(value = "查询收货人、发货人-下拉框")
    public JSONArray findBySelect(@RequestParam String role, @RequestParam boolean enable) throws Exception {
        JSONArray array = new JSONArray();
        try {
            List<Signature> list = signatureService.findBySelect(role, enable);
            if (!list.isEmpty()) {
                for (Signature signature : list) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("id", signature.getId());
                    jsonObject.put("name", signature.getName());
                    array.add(jsonObject);
                }
            }
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return array;
    }
}
