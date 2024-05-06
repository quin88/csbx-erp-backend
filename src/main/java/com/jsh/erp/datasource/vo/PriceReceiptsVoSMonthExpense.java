package com.jsh.erp.datasource.vo;

import java.math.BigDecimal;

public class PriceReceiptsVoSMonthExpense {
    private String month;

    private String year;

    private BigDecimal monthlyTotalExpense;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public BigDecimal getMonthlyTotalExpense() {
        return monthlyTotalExpense;
    }

    public void setMonthlyTotalExpense(BigDecimal monthlyTotalExpense) {
        this.monthlyTotalExpense = monthlyTotalExpense;
    }
}
