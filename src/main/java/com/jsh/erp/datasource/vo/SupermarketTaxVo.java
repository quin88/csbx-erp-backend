package com.jsh.erp.datasource.vo;

import com.jsh.erp.datasource.entities.SupermarketTax;

public class SupermarketTaxVo extends SupermarketTax {

    private String serveClientName;

    private String tenantName;

    public String getServeClientName() {
        return serveClientName;
    }

    public void setServeClientName(String serveClientName) {
        this.serveClientName = serveClientName;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }
}
