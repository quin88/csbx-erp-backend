package com.jsh.erp.controller;

import com.jsh.erp.datasource.dto.RechargeConfigurationDTO;
import com.jsh.erp.datasource.entities.RechargeConfiguration;
import com.jsh.erp.service.rechargeAmount.RechargeConfigurationService;
import com.jsh.erp.service.user.UserService;
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
@RequestMapping(value = "/rechargeConfiguration")
@Api(tags = {"充值配置接口管理"})
public class RechargeConfigurationController {
    private Logger logger = LoggerFactory.getLogger(RechargeConfigurationController.class);

    @Resource
    private RechargeConfigurationService rechargeConfigurationService;

    @Resource
    private UserService userService;

    /**
     * 充值配置保存接口
     *
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/saveRechargeConfiguration")
    @ApiOperation(value = "保存充值配置")
    public BaseResponseInfo saveRechargeConfiguration(@RequestBody RechargeConfigurationDTO dto, HttpServletRequest request) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();

        try {
            userService.getCurrentUser();
            rechargeConfigurationService.saveRechargeConfiguration(dto, request);
            res.code = 200;
            res.data = "保存成功";
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = "保存失败";

        }
        return res;
    }

    @GetMapping(value = "/getRechargeConfigurationList")
    @ApiOperation(value = "获取充值配置列表")
    public BaseResponseInfo getRechargeConfigurationList(HttpServletRequest request) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        try {
            userService.getCurrentUser();
            List<RechargeConfiguration> rcs = rechargeConfigurationService.getRechargeConfigurationList(request);
            res.code = 200;
            res.data = rcs;
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = "保存失败";

        }
        return res;
    }

}
