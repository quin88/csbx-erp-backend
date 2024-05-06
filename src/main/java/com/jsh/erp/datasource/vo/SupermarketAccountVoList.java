package com.jsh.erp.datasource.vo;

import com.jsh.erp.datasource.entities.SupermarketAccount;

public class SupermarketAccountVoList extends SupermarketAccount {
    private String supplierName;

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
}
