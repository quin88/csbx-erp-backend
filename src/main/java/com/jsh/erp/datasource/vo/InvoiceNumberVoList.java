package com.jsh.erp.datasource.vo;

import com.jsh.erp.datasource.entities.InvoiceNumber;

public class InvoiceNumberVoList extends InvoiceNumber {
    private String materialName;

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }
}
