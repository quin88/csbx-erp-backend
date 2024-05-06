package com.jsh.erp.datasource.entities;

import java.util.List;

public class SupermarketReconciliationVo4Body {

    private Long id;

    private String info;

    private String rows;

    private String deleteIds;
    private List<SupermarketReconciliationRelevancy> srrList;

    private String satDeleteIds;

    private List<SupermarketReconciliationAquaticType> satList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getRows() {
        return rows;
    }

    public void setRows(String rows) {
        this.rows = rows;
    }

    public List<SupermarketReconciliationRelevancy> getSrrList() {
        return srrList;
    }

    public void setSrrList(List<SupermarketReconciliationRelevancy> srrList) {
        this.srrList = srrList;
    }

    public String getDeleteIds() {
        return deleteIds;
    }

    public void setDeleteIds(String deleteIds) {
        this.deleteIds = deleteIds;
    }

    public String getSatDeleteIds() {
        return satDeleteIds;
    }

    public void setSatDeleteIds(String satDeleteIds) {
        this.satDeleteIds = satDeleteIds;
    }

    public List<SupermarketReconciliationAquaticType> getSatList() {
        return satList;
    }

    public void setSatList(List<SupermarketReconciliationAquaticType> satList) {
        this.satList = satList;
    }
}