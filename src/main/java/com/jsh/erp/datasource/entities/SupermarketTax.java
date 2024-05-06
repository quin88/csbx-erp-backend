package com.jsh.erp.datasource.entities;

import java.io.Serializable;
import java.math.BigDecimal;

public class SupermarketTax implements Serializable {
    private Long id;

    private Long serveClientId;

    private BigDecimal tax;

    private String deleteFlag;

    private Long tenantId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getServeClientId() {
        return serveClientId;
    }

    public void setServeClientId(Long serveClientId) {
        this.serveClientId = serveClientId;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }
}