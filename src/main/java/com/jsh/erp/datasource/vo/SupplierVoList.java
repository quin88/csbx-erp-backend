package com.jsh.erp.datasource.vo;

import com.jsh.erp.datasource.entities.Supplier;

public class SupplierVoList extends Supplier {
    /**
     * 审核人名称
     */
    private String verifierName;

    public String getVerifierName() {
        return verifierName;
    }

    public void setVerifierName(String verifierName) {
        this.verifierName = verifierName;
    }
}
