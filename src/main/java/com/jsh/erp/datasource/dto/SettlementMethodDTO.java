package com.jsh.erp.datasource.dto;

import com.jsh.erp.datasource.entities.SettlementMethod;

import java.util.List;

public class SettlementMethodDTO {
    private List<SettlementMethod> settlementMethod;

    private String deleteId;

    public List<SettlementMethod> getSettlementMethod() {
        return settlementMethod;
    }

    public void setSettlementMethod(List<SettlementMethod> settlementMethod) {
        this.settlementMethod = settlementMethod;
    }

    public String getDeleteId() {
        return deleteId;
    }

    public void setDeleteId(String deleteId) {
        this.deleteId = deleteId;
    }
}
