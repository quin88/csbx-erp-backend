package com.jsh.erp.datasource.vo;

import com.jsh.erp.datasource.entities.SupermarketReconciliation;

import java.io.Serializable;
import java.math.BigDecimal;

public class SupermarketReconciliationVo extends SupermarketReconciliation implements Serializable {

    private String createdName;

    private String verifierName;

    private BigDecimal quantityTotal;

    private BigDecimal billingPriceTotal;

    private BigDecimal systemPriceTotal;

    private String aquaticType;

    private BigDecimal priceTotal;
    public String getCreatedName() {
        return createdName;
    }

    public void setCreatedName(String createdName) {
        this.createdName = createdName;
    }

    public String getVerifierName() {
        return verifierName;
    }

    public void setVerifierName(String verifierName) {
        this.verifierName = verifierName;
    }

    public BigDecimal getQuantityTotal() {
        return quantityTotal;
    }

    public void setQuantityTotal(BigDecimal quantityTotal) {
        this.quantityTotal = quantityTotal;
    }

    public BigDecimal getBillingPriceTotal() {
        return billingPriceTotal;
    }

    public void setBillingPriceTotal(BigDecimal billingPriceTotal) {
        this.billingPriceTotal = billingPriceTotal;
    }

    public BigDecimal getSystemPriceTotal() {
        return systemPriceTotal;
    }

    public void setSystemPriceTotal(BigDecimal systemPriceTotal) {
        this.systemPriceTotal = systemPriceTotal;
    }

    public String getAquaticType() {
        return aquaticType;
    }

    public void setAquaticType(String aquaticType) {
        this.aquaticType = aquaticType;
    }

    public BigDecimal getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(BigDecimal priceTotal) {
        this.priceTotal = priceTotal;
    }
}