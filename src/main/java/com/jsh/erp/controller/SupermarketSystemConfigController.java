package com.jsh.erp.controller;

import com.jsh.erp.service.supermarketSystemConfig.SupermarketSystemConfigService;
import com.jsh.erp.utils.BaseResponseInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/supermarket")
@Api(tags = {"商超单据编号"})
public class SupermarketSystemConfigController {
    private Logger logger = LoggerFactory.getLogger(SupermarketSystemConfigController.class);

    @Resource
    private SupermarketSystemConfigService supermarketSystemConfigService;

    @GetMapping(value = "/buildNumber")
    @ApiOperation(value = "单据编号生成接口")
    public BaseResponseInfo buildNumber(@RequestParam(value = "numberName") String numberName,
                                        @RequestParam(value = "length") int length,
                                        HttpServletRequest request) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            String number = supermarketSystemConfigService.buildNumber(numberName, length, request);
            map.put("number", number);
            res.code = 200;
            res.data = map;
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = e.getMessage();
        }
        return res;
    }
}
