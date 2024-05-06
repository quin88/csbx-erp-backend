package com.jsh.erp.datasource.vo;

import com.jsh.erp.datasource.entities.SupermarketAddedOrder;

import java.io.Serializable;
import java.math.BigDecimal;

public class SupermarketAddedOrderVo extends SupermarketAddedOrder implements Serializable {

    private String createdName;

    private String verifierName;

    private BigDecimal linkedDifferenceTotal;//关联订单差额

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

    public BigDecimal getLinkedDifferenceTotal() {
        return linkedDifferenceTotal;
    }

    public void setLinkedDifferenceTotal(BigDecimal linkedDifferenceTotal) {
        this.linkedDifferenceTotal = linkedDifferenceTotal;
    }
}