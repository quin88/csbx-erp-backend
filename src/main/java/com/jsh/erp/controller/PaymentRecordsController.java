package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.service.paymentRecords.PaymentRecordsService;
import com.jsh.erp.utils.ErpInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import static com.jsh.erp.utils.ResponseJsonUtil.returnJson;

@RestController
@RequestMapping(value = "/paymentRecords")
@Api(tags = {"供应商费用管理"})
public class PaymentRecordsController {
    private Logger logger = LoggerFactory.getLogger(PaymentRecordsController.class);

    @Resource
    private PaymentRecordsService paymentRecordsService;

    /**
     * 批量设置状态-审核或者反审核
     *
     * @param jsonObject
     * @param request
     * @return
     */
    @PostMapping(value = "/batchSetStatus")
    @ApiOperation(value = "批量设置状态-审核或者反审核")
    public String batchSetStatus(@RequestBody JSONObject jsonObject,
                                 HttpServletRequest request) throws Exception {
        Map<String, Object> objectMap = new HashMap<>();
        String status = jsonObject.getString("status");
        String ids = jsonObject.getString("ids");
        String comment = jsonObject.getString("comment");
        int res = paymentRecordsService.batchSetStatus(status, ids, comment, request);

        if (res > 0) {
            return returnJson(objectMap, ErpInfo.OK.name, ErpInfo.OK.code);
        } else {
            return returnJson(objectMap, ErpInfo.ERROR.name, ErpInfo.ERROR.code);
        }
    }

    /**
     * 根据月份查询充值记录
     *
     * @param request
     * @return
     */
   /* @GetMapping(value = "/getPaymentRecordsToMonth")
    @ApiOperation(value = "根据月份查询充值记录")
    public BaseResponseInfo getPaymentRecordsToMonth(@RequestParam("supplierId") Long supplierId,
                                                 @RequestParam(value = "month", required = false) String month,
                                                 HttpServletRequest request) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        JSONObject json = new JSONObject();
        try {
            //月的出入库次数
            DepotHeadVoInOutSCount inOutSCount = paymentRecordsService.findInOutSupplierCountTotal(supplierId, month);
            //月的每日消费合计
            List<PriceReceiptsVoSExpense> dayTotalExpense = priceReceiptsService.findDayTotalExpense(supplierId, month);
            json.put("inCount", inOutSCount.getInCount());
            json.put("outCount", inOutSCount.getOutCount());
            json.put("dayTotalExpense", dayTotalExpense);
            res.code = 200;
            res.data = json;
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = "获取数据失败";
        }
        return res;
    }*/
}
