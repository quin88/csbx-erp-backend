package com.jsh.erp.controller;

import com.jsh.erp.datasource.dto.OrderDocumentDTO;
import com.jsh.erp.service.orderDocument.OrderDocumentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping(value = "/orderDocument")
@Api(tags = {"商超订单单据管理"})
public class OrderDocumentController {

    @Resource
    private OrderDocumentService orderDocumentService;

    /**
     * 保存订单单据
     *
     * @param request
     * @return
     */
    @PostMapping(value = "/saveOrderDocument")
    @ApiOperation(value = "保存订单单据")
    public Object saveOrderDocument(@RequestBody OrderDocumentDTO documentDTO, HttpServletRequest request) throws Exception {
        return orderDocumentService.saveOrderDocument(documentDTO, request);
    }

    @GetMapping(value = "/getOrderDocument")
    @ApiOperation(value = "获取订单单据")
    public Map<String, Object> getOrderDocument(@RequestParam(value = "orderId") Long orderId, HttpServletRequest request) throws Exception {
        return orderDocumentService.getOrderDocument(orderId, request);
    }
}
