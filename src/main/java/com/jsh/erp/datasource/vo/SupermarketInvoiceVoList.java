package com.jsh.erp.datasource.vo;

import com.jsh.erp.datasource.entities.SupermarketInvoice;

public class SupermarketInvoiceVoList extends SupermarketInvoice {
    private String supplierName;

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
}
