package com.jsh.erp.datasource.vo;


import com.jsh.erp.datasource.entities.SupermarketServeClient;

public class SupermarketServeClientVo extends SupermarketServeClient {

    private String tenantName;

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }
}
