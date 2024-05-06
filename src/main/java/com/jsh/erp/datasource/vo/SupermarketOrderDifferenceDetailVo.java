package com.jsh.erp.datasource.vo;

import java.math.BigDecimal;
import java.util.Date;

public class SupermarketOrderDifferenceDetailVo {

    private BigDecimal supplementaryAmount;

    private Date updateTime;

    private String type;

    private String number;

    public BigDecimal getSupplementaryAmount() {
        return supplementaryAmount;
    }

    public void setSupplementaryAmount(BigDecimal supplementaryAmount) {
        this.supplementaryAmount = supplementaryAmount;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
