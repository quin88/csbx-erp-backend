package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.dto.ValueAddedServeDTO;
import com.jsh.erp.service.valueAddedServeType.ValueAddedServeTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/valueAddedServeType")
@Api(tags = {"增值服务类型"})
public class ValueAddedServeTypeController {
    private Logger logger = LoggerFactory.getLogger(ValueAddedServeTypeController.class);

    @Resource
    private ValueAddedServeTypeService valueAddedServeTypeService;

    @PostMapping(value = "/addValueAddedServe")
    @ApiOperation(value = "新增或编辑增值服务类型")
    public Object addValueAddedServe(@RequestBody ValueAddedServeDTO valueAddedServeDTO, HttpServletRequest request) throws Exception {
        JSONObject result = ExceptionConstants.standardSuccess();

        valueAddedServeTypeService.addValueAddedServe(valueAddedServeDTO, request);
        return result;
    }
}
