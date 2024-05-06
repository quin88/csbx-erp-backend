package com.jsh.erp.datasource.vo;

import com.jsh.erp.datasource.entities.SupermarketOrder;

import java.io.Serializable;
import java.math.BigDecimal;

public class SupermarketOrderVo extends SupermarketOrder implements Serializable {

    private String createdName;

    private String verifierName;

    private String serveClientName;

    private BigDecimal tax;

    private String marketAddress;

    private BigDecimal linkedDifferenceTotal;//关联订单差额

    private static final long serialVersionUID = 1L;

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

    public String getServeClientName() {
        return serveClientName;
    }

    public void setServeClientName(String serveClientName) {
        this.serveClientName = serveClientName;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public String getMarketAddress() {
        return marketAddress;
    }

    public void setMarketAddress(String marketAddress) {
        this.marketAddress = marketAddress;
    }

    public BigDecimal getLinkedDifferenceTotal() {
        return linkedDifferenceTotal;
    }

    public void setLinkedDifferenceTotal(BigDecimal linkedDifferenceTotal) {
        this.linkedDifferenceTotal = linkedDifferenceTotal;
    }
}