package com.jsh.erp.datasource.vo;

import com.jsh.erp.datasource.entities.SupermarketFinance;

import java.io.Serializable;
import java.math.BigDecimal;

public class SupermarketFinanceVo extends SupermarketFinance implements Serializable {

    private String createdName;

    private String verifierName;

    private String uploaderName;

    private String paymenterName;

    private String aquaticType;

    private String market;

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

    public String getUploaderName() {
        return uploaderName;
    }

    public void setUploaderName(String uploaderName) {
        this.uploaderName = uploaderName;
    }

    public String getPaymenterName() {
        return paymenterName;
    }

    public void setPaymenterName(String paymenterName) {
        this.paymenterName = paymenterName;
    }

    public String getAquaticType() {
        return aquaticType;
    }

    public void setAquaticType(String aquaticType) {
        this.aquaticType = aquaticType;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public BigDecimal getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(BigDecimal priceTotal) {
        this.priceTotal = priceTotal;
    }
}