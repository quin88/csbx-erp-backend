package com.jsh.erp.datasource.vo;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 供应商费用模块--查询历史单据接口返回对象
 */
public class PaymentRecordsExVo4List implements Serializable {
    private List<PaymentRecordsVo> paymentRecords;

    private BigDecimal balanceRecord;

    private String earliestDate;

    private String latestDate;

    public List<PaymentRecordsVo> getPaymentRecords() {
        return paymentRecords;
    }

    public void setPaymentRecords(List<PaymentRecordsVo> paymentRecords) {
        this.paymentRecords = paymentRecords;
    }

    public BigDecimal getBalanceRecord() {
        return balanceRecord;
    }

    public void setBalanceRecord(BigDecimal balanceRecord) {
        this.balanceRecord = balanceRecord;
    }

    public String getEarliestDate() {
        return earliestDate;
    }

    public void setEarliestDate(String earliestDate) {
        this.earliestDate = earliestDate;
    }

    public String getLatestDate() {
        return latestDate;
    }

    public void setLatestDate(String latestDate) {
        this.latestDate = latestDate;
    }
}