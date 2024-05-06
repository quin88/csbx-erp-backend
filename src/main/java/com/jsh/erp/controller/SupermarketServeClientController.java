package com.jsh.erp.controller;

import com.jsh.erp.datasource.dto.SupermarketServeClientDTO;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.service.supermarketServeClient.SupermarketServeClientService;
import com.jsh.erp.utils.BaseResponseInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/supermarketServeClient")
@Api(tags = {"商超服务商接口管理"})
public class SupermarketServeClientController {
    private Logger logger = LoggerFactory.getLogger(SupermarketServeClientController.class);

    @Resource
    private SupermarketServeClientService supermarketServeClientService;


    @PostMapping(value = "/addSupermarketServeClient")
    @ApiOperation(value = "保存商超服务商")
    public Object addSupermarketServeClient(@RequestBody SupermarketServeClientDTO body, HttpServletRequest request) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        try {
            List<SupermarketServeClient> serveClients = body.getServeClients();
            String deleteId = body.getDeleteId();
            supermarketServeClientService.addSupermarketServeClient(serveClients, deleteId, request);
            res.code = 200;
            res.data = "新增成功！";
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = "新增失败！";
        }
        return res;
    }
}
