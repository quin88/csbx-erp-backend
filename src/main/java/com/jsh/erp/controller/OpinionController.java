package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.dto.OpinionDTO;
import com.jsh.erp.service.opinion.OpinionService;
import com.jsh.erp.utils.BaseResponseInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/opinion")
@Api(tags = {"小程序-意见反馈管理"})
public class OpinionController {

    @Resource
    private OpinionService opinionService;

    /**
     * 保存订单单据
     *
     * @param request
     * @return
     */
    @PostMapping(value = "/saveOpinionDetail")
    @ApiOperation(value = "保存意见反馈")
    public JSONObject saveOpinionDetail(@RequestBody OpinionDTO opinionDTO, HttpServletRequest request) throws Exception {
        JSONObject result = ExceptionConstants.standardSuccess();
        opinionService.saveOpinionDetail(opinionDTO, request);
        return result;
    }
}
