package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.datasource.vo.DepotHeadVoInOutSCount;
import com.jsh.erp.datasource.vo.PriceReceiptsVoSExpense;
import com.jsh.erp.datasource.vo.PriceReceiptsVoSMonthExpense;
import com.jsh.erp.service.depotHead.DepotHeadService;
import com.jsh.erp.service.priceReceipts.PriceReceiptsService;
import com.jsh.erp.utils.BaseResponseInfo;
import com.jsh.erp.utils.ErpInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;

import static com.jsh.erp.utils.ResponseJsonUtil.returnJson;

/**
 * 费用单据
 */
@RestController
@RequestMapping(value = "/priceReceipts")
@Api(tags = {"费用单据"})
public class PriceReceiptsController {

    private Logger logger = LoggerFactory.getLogger(PriceReceiptsController.class);

    @Resource
    private PriceReceiptsService priceReceiptsService;
    @Resource
    private DepotHeadService depotHeadService;

    @GetMapping(value = "/importPriceReceipts")
    @ApiOperation(value = "导出流水")
    public Object importPriceReceipts(@RequestParam Long supplierId, @RequestParam String searchType,
                                      @RequestParam(required = false) String beginTime, @RequestParam(required = false) String endTime,
                                      HttpServletRequest request) throws Exception {

        return priceReceiptsService.importPriceReceipts(supplierId, searchType, beginTime, endTime, request);
    }

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
        int res = priceReceiptsService.batchSetStatus(status, ids, comment, request);

        if (res > 0) {
            return returnJson(objectMap, ErpInfo.OK.name, ErpInfo.OK.code);
        } else {
            return returnJson(objectMap, ErpInfo.ERROR.name, ErpInfo.ERROR.code);
        }
    }


    @GetMapping(value = "/getPaymentRecordsToDay")
    @ApiOperation(value = "查询当日消费详情")
    public BaseResponseInfo getPaymentRecordsToDay(@RequestParam(value = "supplierId") Long supplierId,
                                                   @RequestParam(value = "dayDate") String dayDate,
                                                   HttpServletRequest request) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();

        try {
            Object o = priceReceiptsService.getPriceReceiptsToDay(supplierId, dayDate, request);
            res.code = 200;
            res.data = o;
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = "获取数据失败";
        }
        return res;
    }

    /**
     * 根据供应商统计每日存储费用
     *
     * @param request
     * @return
     */
    @GetMapping(value = "/getStatisticsBySupplier")
    @ApiOperation(value = "统计每日结算费用")
    public BaseResponseInfo getStatisticsBySupplier(
            @RequestParam(value = "priceType") String priceType,
            @RequestParam(value = "supplierId") Long supplierId,
            @RequestParam(value = "beginTime", required = false) String beginTime,
            @RequestParam(value = "endTime", required = false) String endTime,
            HttpServletRequest request) {
        BaseResponseInfo res = new BaseResponseInfo();
        HashMap<String, Object> map = new HashMap<>();
        try {
            BigDecimal totalAmount = priceReceiptsService.getStatisticsBySupplier(priceType, supplierId, beginTime, endTime);
            res.code = 200;
            map.put("totalAmount", totalAmount);
            res.data = map;
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = "获取数据失败";
        }
        return res;
    }

    @GetMapping(value = "/getPaymentRecordsDetails")
    @ApiOperation(value = "查询账户余额详情")
    public BaseResponseInfo getPaymentRecordsDetails(@RequestParam("supplierId") Long supplierId,
                                                     @RequestParam(value = "beginDate", required = false) String beginDate,
                                                     @RequestParam(value = "endDate", required = false) String endDate,
                                                     HttpServletRequest request) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        JSONArray dataList = new JSONArray();
        JSONObject resultMap = new JSONObject();
        try {
            //获取所有数据
            List<PriceReceiptsVoSMonthExpense> list = priceReceiptsService.getPaymentRecordsList(supplierId, beginDate, endDate);
            //当前月的消费总金额
            BigDecimal currentMonthStatistics = priceReceiptsService.getCurrentMonthStatistics(supplierId);
            //当前月的出入库次数
            DepotHeadVoInOutSCount inOutSCount = depotHeadService.findCurrentInOutSupplierCountTotal(supplierId);
            //当前月的每日消费合计
            List<PriceReceiptsVoSExpense> dayTotalExpense = priceReceiptsService.findDayTotalExpenseByCurrentMonth(supplierId);

            JSONObject currentMonth = new JSONObject();
            if (inOutSCount != null) {
                currentMonth.put("inCount", inOutSCount.getInCount());
                currentMonth.put("outCount", inOutSCount.getOutCount());
                currentMonth.put("currentMonthStatistics", currentMonthStatistics);
                currentMonth.put("dayTotalExpense", dayTotalExpense);
            }
            dataList = addDataList(list);
            resultMap.put("currentMonth", currentMonth);
            resultMap.put("dataList", dataList);
            res.code = 200;
            res.data = resultMap;
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = "获取数据失败";
        }
        return res;
    }

    /**
     * 添加每月的消费合计
     *
     * @param list
     */
    private JSONArray addDataList(List<PriceReceiptsVoSMonthExpense> list) {
        JSONArray dataArray = new JSONArray();
        if (list != null && !list.isEmpty()) {
            JSONArray timeList = new JSONArray();
            for (PriceReceiptsVoSMonthExpense monthExpense : list) {

                JSONObject object = new JSONObject();
                object.put("month", monthExpense.getMonth());
                object.put("expense", monthExpense.getMonthlyTotalExpense());

                if (dataArray.isEmpty()) {
                    JSONObject monthItem = new JSONObject();
                    monthItem.put("time", monthExpense.getYear());

                    timeList.add(object);
                    monthItem.put("timeList", timeList);
                    dataArray.add(monthItem);
                } else {
                    boolean year = false;
                    ListIterator<Object> iterator = dataArray.listIterator();
                    while (iterator.hasNext()) {
                        JSONObject next = (JSONObject) iterator.next();
                        if (next.get("time").equals(monthExpense.getYear())) {
                            JSONArray array = next.getJSONArray("timeList");
                            array.add(object);
                            year = true;
                            break;
                        }
                    }
                    if (!year) {
                        JSONObject monthItem = new JSONObject();
                        monthItem.put("time", monthExpense.getYear());
                        JSONArray otherList = new JSONArray();
                        otherList.add(object);
                        monthItem.put("timeList", otherList);
                        dataArray.add(monthItem);
                    }
                }
            }
        }
        return dataArray;
    }


    /**
     * 根据月份查询数据
     *
     * @param request
     * @return
     */
    @GetMapping(value = "/getPriceDetailsToMonth")
    @ApiOperation(value = "根据月份查询数据")
    public BaseResponseInfo findByShippingMethod(@RequestParam("supplierId") Long supplierId,
                                                 @RequestParam(value = "month", required = false) String month,
                                                 HttpServletRequest request) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        JSONObject json = new JSONObject();
        try {
            //月的出入库次数
            DepotHeadVoInOutSCount inOutSCount = depotHeadService.findInOutSupplierCountTotal(supplierId, month);
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
    }
}


