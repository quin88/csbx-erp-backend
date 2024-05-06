package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.dto.OrderDetailDTO;
import com.jsh.erp.datasource.dto.SupermarketOrderStatusDTO;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.vo.OrderDetailVo;
import com.jsh.erp.service.supermarketOrder.SupermarketOrderService;
import com.jsh.erp.utils.BaseResponseInfo;
import com.jsh.erp.utils.ErpInfo;
import com.jsh.erp.utils.ExcelUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.jsh.erp.utils.ResponseJsonUtil.returnJson;

@RestController
@RequestMapping(value = "/supermarketOrder")
@Api(tags = {"商超订单管理"})
public class SupermarketOrderController {

    @Resource
    private SupermarketOrderService supermarketOrderService;

    /**
     * 新增商超订单和详情
     *
     * @param request
     * @return
     */
    @PostMapping(value = "/addSupermarketOrderAndDetail")
    @ApiOperation(value = "新增商超订单和详情")
    public Object addSupermarketOrderAndDetail(@RequestBody SupermarketOrderVo4Body body, HttpServletRequest request) throws Exception {
        JSONObject result = ExceptionConstants.standardSuccess();
        String beanJson = body.getInfo();
        String rows = body.getRows();
        supermarketOrderService.addSupermarketOrderAndDetail(beanJson, rows, request);
        return result;
    }

    @PutMapping(value = "/updateSupermarketOrderAndDetail")
    @ApiOperation(value = "编辑商超订单和详情")
    public Object updateSupermarketOrderAndDetail(@RequestBody SupermarketOrderVo4Body body, HttpServletRequest request) throws Exception {
        JSONObject result = ExceptionConstants.standardSuccess();
        String beanJson = body.getInfo();
        String rows = body.getRows();
        supermarketOrderService.updateSupermarketOrderAndDetail(beanJson, rows, request);
        return result;
    }

    @GetMapping(value = "/findBySelect")
    @ApiOperation(value = "根据id查询商超订单数据")
    public Object findBySelect(@RequestParam(value = "id") Long id, @RequestParam(value = "supplierId", required = false) Long supplierId,
                               @RequestParam(value = "accountId", required = false) Long accountId, HttpServletRequest request) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        try {
            JSONObject list = supermarketOrderService.findByCondition(id, supplierId, accountId);
            res.code = 200;
            res.data = list;
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = "获取数据失败";
        }
        return res;
    }

    @PostMapping(value = "/batchSetStatus")
    @ApiOperation(value = "审核接口")
    public String batchSetStatus(@RequestBody SupermarketOrderStatusDTO supermarketOrderStatusDTO,
                                 HttpServletRequest request) throws Exception {
        Long id = supermarketOrderStatusDTO.getId();
        String status = supermarketOrderStatusDTO.getStatus();
        String comment = supermarketOrderStatusDTO.getComment();
        List<OrderDetailDTO> orderDetailDTOS = supermarketOrderStatusDTO.getOrderDetailDTOS();
        Map<String, Object> objectMap = new HashMap<>();
        int res = supermarketOrderService.batchSetStatus(status, id, comment, orderDetailDTOS, request);
        if (res > 0) {
            return returnJson(objectMap, ErpInfo.OK.name, ErpInfo.OK.code);
        } else {
            return returnJson(objectMap, ErpInfo.ERROR.name, ErpInfo.ERROR.code);
        }
    }

    @PostMapping(value = "/importExcel")
    @ApiOperation(value = "excel表格导入商超订单")
    public BaseResponseInfo importExcel(MultipartFile file,
                                        HttpServletRequest request, HttpServletResponse response) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        try {
            res = supermarketOrderService.importExcel(file, request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @GetMapping(value = "/exportExcel")
    @ApiOperation(value = "导出excel表格")
    public void exportExcel(@RequestParam(value = "selections", required = false) String ids,
                            HttpServletRequest request, HttpServletResponse response) {
        try {
            List<OrderDetailVo> dataList = supermarketOrderService.findBySelect(ids);
            File file = supermarketOrderService.exportExcel(dataList);
            ExcelUtils.downloadExcel(file, file.getName(), response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping(value = "/getProcess")
    @ApiOperation(value = "查看流程")
    public Object getProcess(@RequestParam(value = "orderId", required = false) Long orderId,
                             @RequestParam(value = "sfId", required = false) Long sfId,
                             @RequestParam(value = "type") String type,
                             HttpServletRequest request) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        try {
            JSONArray list = supermarketOrderService.getProcess(orderId, sfId, type, request);
            res.code = 200;
            res.data = list;
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = "获取数据失败";
        }
        return res;
    }

    @GetMapping(value = "/getDifferenceDetail")
    @ApiOperation(value = "查看差额明细")
    public Object getDifferenceDetail(@RequestParam(value = "linkId") Long linkId, HttpServletRequest request) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        try {
            JSONObject list = supermarketOrderService.getDifferenceDetail(linkId, request);
            res.code = 200;
            res.data = list;
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = "获取数据失败";
        }
        return res;
    }
}
