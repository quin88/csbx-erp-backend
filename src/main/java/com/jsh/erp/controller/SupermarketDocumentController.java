package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.entities.SupermarketDocumentVo4Body;
import com.jsh.erp.service.supermarketDocument.SupermarketDocumentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/supermarketDocument")
@Api(tags = {"商超出入库管理"})
public class SupermarketDocumentController {

    @Resource
    private SupermarketDocumentService supermarketDocumentService;

    /**
     * 新增商超出入库信息
     *
     * @param request
     * @return
     */
    @PostMapping(value = "/addSupermarketDocumentAndItem")
    @ApiOperation(value = "新增商超出入库信息")
    public Object addSupermarketDocumentAndItem(@RequestBody SupermarketDocumentVo4Body body, HttpServletRequest request) throws Exception {
        JSONObject result = ExceptionConstants.standardSuccess();
        supermarketDocumentService.addSupermarketDocumentAndItem(body, request);
        return result;
    }

    /**
     * 编辑商超出入库信息
     *
     * @param request
     * @return
     */
    @PutMapping(value = "/updateSupermarketDocumentAndItem")
    @ApiOperation(value = "编辑商超出入库信息")
    public Object updateSupermarketDocumentAndItem(@RequestBody SupermarketDocumentVo4Body body,
                                                   @RequestParam(value = "itemIds",required = false) List<Long> itemIds,
                                                   HttpServletRequest request) throws Exception {
        JSONObject result = ExceptionConstants.standardSuccess();
        supermarketDocumentService.updateSupermarketDocumentAndItem(body, itemIds, request);
        return result;
    }
}
