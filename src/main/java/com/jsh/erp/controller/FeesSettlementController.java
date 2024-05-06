package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.entities.FeesSettlement;
import com.jsh.erp.datasource.entities.FeesSettlementEx;
import com.jsh.erp.datasource.entities.Supplier;
import com.jsh.erp.datasource.vo.SupplierVoBody;
import com.jsh.erp.service.feesSettlement.FeesSettlementService;
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
@RequestMapping(value = "/feesSettlement")
@Api(tags = {"供应商费用结算管理"})
public class FeesSettlementController {
    private Logger logger= LoggerFactory.getLogger(FeesSettlementController.class);

    @Resource
    private FeesSettlementService feesSettlementService;

    /**
     * 新增供应商及供应商费用结算信息
     * @param body
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/addSupplierAndFeesSettlement")
    @ApiOperation(value = "新增供应商及供应商费用结算信息")
    public Object addSupplierAndFeesSettlement(@RequestBody SupplierVoBody body, HttpServletRequest request) throws  Exception{
        JSONObject result = ExceptionConstants.standardSuccess();

        Supplier supplierInfo = body.getSupplier();
        List<FeesSettlement> feesSettlementList = body.getFeesSettlementList();
        feesSettlementService.addSupplierAndFeesSettlement(supplierInfo, feesSettlementList, request);
        return result;
    }

    /**
     * 更新供应商及供应商费用结算信息
     * @param body
     * @param request
     * @return
     * @throws Exception
     */
    @PutMapping(value = "/updateSupplierAndFeesSettlement")
    @ApiOperation(value = "更新供应商及供应商费用结算信息")
    public Object updateSupplierAndFeesSettlement(@RequestBody SupplierVoBody body, HttpServletRequest request) throws Exception{
        JSONObject result = ExceptionConstants.standardSuccess();
        Supplier supplierInfo = body.getSupplier();
        List<FeesSettlement> feesSettlements = body.getFeesSettlementList();
        feesSettlementService.updateSupplierAndFeesSettlement(supplierInfo,feesSettlements,request);
        return result;
    }

    @DeleteMapping(value = "/deleteSupplierAndFeesSettlement")
    @ApiOperation(value = "删除供应商及供应商费用结算信息")
    public Object deleteDepotHeadAndDetail(@RequestParam String ids, HttpServletRequest request) throws Exception{
        JSONObject result = ExceptionConstants.standardSuccess();
        feesSettlementService.batchDeleteSupplierByIds(ids,request);
        return result;
    }

    /**
     * 根据供应商id获取所属结算方式
     * @param request
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/findBySupplierId")
    @ApiOperation(value = "根据供应商id获取所属结算方式")
    public BaseResponseInfo findBySupplierId(@RequestParam("supplierId")Long supplierId, HttpServletRequest request) throws Exception{
        BaseResponseInfo res = new BaseResponseInfo();
        try {
            List<FeesSettlementEx> arr = feesSettlementService.findBySupplierId(supplierId);
            res.code = 200;
            res.data = arr;
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = "获取数据失败";
        }
        return res;
    }
}
