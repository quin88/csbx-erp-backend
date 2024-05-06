package com.jsh.erp.datasource.vo;

import com.jsh.erp.datasource.entities.FeesSettlement;
import com.jsh.erp.datasource.entities.Supplier;

import java.util.List;

public class SupplierVoBody {
    private Supplier supplier;

    private List<FeesSettlement> feesSettlementList;

    public SupplierVoBody() {
    }

    public SupplierVoBody(Supplier supplier, List<FeesSettlement> feesSettlementList) {
        this.supplier = supplier;
        this.feesSettlementList = feesSettlementList;
    }

    public Supplier getSupplier() {
        return this.supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public List<FeesSettlement> getFeesSettlementList() {
        return this.feesSettlementList;
    }

    public void setFeesSettlementList(List<FeesSettlement> feesSettlementList) {
        this.feesSettlementList = feesSettlementList;
    }
}
