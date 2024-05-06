package com.jsh.erp.datasource.vo;

import com.jsh.erp.datasource.entities.SupplierExtend;

public class SupplierExtendVoList extends SupplierExtend {
    /**
     * 审核人名称
     */
    private String verifierName;

    /**
     * 审核时间
     */
    private String verifierTimeStr;

    public String getVerifierName() {
        return verifierName;
    }

    public void setVerifierName(String verifierName) {
        this.verifierName = verifierName;
    }

    public String getVerifierTimeStr() {
        return verifierTimeStr;
    }

    public void setVerifierTimeStr(String verifierTimeStr) {
        this.verifierTimeStr = verifierTimeStr;
    }
}
