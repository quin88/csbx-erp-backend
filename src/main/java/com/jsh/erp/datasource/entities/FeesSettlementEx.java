package com.jsh.erp.datasource.entities;

public class FeesSettlementEx extends FeesSettlement {
    private String settlementMethod;

    private String secondSettlementMethod;

    public String getSettlementMethod() {
        return this.settlementMethod;
    }

    public void setSettlementMethod(String settlementMethod) {
        this.settlementMethod = settlementMethod;
    }

    public String getSecondSettlementMethod() {
        return this.secondSettlementMethod;
    }

    public void setSecondSettlementMethod(String secondSettlementMethod) {
        this.secondSettlementMethod = secondSettlementMethod;
    }
}
