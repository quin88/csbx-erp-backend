package com.jsh.erp.datasource.entities;

import java.io.Serializable;
import java.math.BigDecimal;

public class RechargeConfiguration implements Serializable {
    private Long id;

    private BigDecimal rechargeAmount;

    private BigDecimal amountOfGift;

    private Long tenantId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getRechargeAmount() {
        return rechargeAmount;
    }

    public void setRechargeAmount(BigDecimal rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }

    public BigDecimal getAmountOfGift() {
        return amountOfGift;
    }

    public void setAmountOfGift(BigDecimal amountOfGift) {
        this.amountOfGift = amountOfGift;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }
}