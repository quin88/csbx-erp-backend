package com.jsh.erp.datasource.vo;


import com.jsh.erp.datasource.entities.SupermarketSystemConfig;

public class SupermarketSystemConfigVo extends SupermarketSystemConfig {

    private String tenantName;

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }
}
