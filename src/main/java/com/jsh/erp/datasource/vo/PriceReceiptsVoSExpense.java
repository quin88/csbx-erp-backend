package com.jsh.erp.datasource.vo;

import java.math.BigDecimal;

public class PriceReceiptsVoSExpense {
    private String day;

    private BigDecimal dayTotalExpense;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public BigDecimal getDayTotalExpense() {
        return dayTotalExpense;
    }

    public void setDayTotalExpense(BigDecimal dayTotalExpense) {
        this.dayTotalExpense = dayTotalExpense;
    }
}
