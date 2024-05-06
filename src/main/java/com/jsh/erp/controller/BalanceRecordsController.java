package com.jsh.erp.controller;

import com.jsh.erp.datasource.entities.BalanceRecords;
import com.jsh.erp.datasource.mappers.BalanceRecordsMapperEx;
import com.jsh.erp.service.priceReceipts.PriceReceiptsService;
import com.jsh.erp.utils.BaseResponseInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/balanceRecords")
@Api(tags = {"余额管理"})
public class BalanceRecordsController {

    @Resource
    private BalanceRecordsMapperEx balanceRecordsMapperEx;

    @Resource
    private PriceReceiptsService priceReceiptsService;

    /**
     * 查询供应商账户余额
     *
     * @param request
     * @return
     */
    @GetMapping(value = "/getBalanceRecordsBySupplierId")
    @ApiOperation(value = "查询供应商账户余额")
    public BaseResponseInfo getBalanceRecordsBySupplierId(@RequestParam("supplierId") Long supplierId, HttpServletRequest request) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        Map<String, Object> map = new HashMap<>();
        try {
            BalanceRecords balanceRecords = balanceRecordsMapperEx.selectBySupplierId(supplierId);
            BigDecimal currentMonthStatistics = priceReceiptsService.getCurrentMonthStatistics(supplierId);
            if (balanceRecords != null) {
                BigDecimal balance = balanceRecords.getBalance();
                BigDecimal amountOfGift = balanceRecords.getAmountOfGift();
                BigDecimal subtotal = balanceRecords.getSubtotal();
                map.put("currentMonthStatistics", currentMonthStatistics.setScale(2, RoundingMode.HALF_UP));
                map.put("balance", balance == null ? BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP) : balance.setScale(2, RoundingMode.HALF_UP));
                map.put("amountOfGift", amountOfGift == null ? BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP) : amountOfGift.setScale(2, RoundingMode.HALF_UP));
                map.put("subtotal", subtotal == null ? BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP) : subtotal.setScale(2, RoundingMode.HALF_UP));
            }
            res.code = 200;
            res.data = map;
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = "获取数据失败";
        }
        return res;
    }
}
