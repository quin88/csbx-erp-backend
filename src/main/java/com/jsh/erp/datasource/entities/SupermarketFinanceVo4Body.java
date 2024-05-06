package com.jsh.erp.datasource.entities;

import java.util.List;

public class SupermarketFinanceVo4Body {

    private Long id;

    private String info;

    private String rows;

    private String deleteIds;//被删除的关联单号表的id

    private String deleteOrderIds;//被删除的关联订单号的id

    private List<SupermarketFinanceRelevancy> srrList;

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

    public List<SupermarketFinanceRelevancy> getSrrList() {
        return srrList;
    }

    public void setSrrList(List<SupermarketFinanceRelevancy> srrList) {
        this.srrList = srrList;
    }

    public String getDeleteIds() {
        return deleteIds;
    }

    public void setDeleteIds(String deleteIds) {
        this.deleteIds = deleteIds;
    }

    public String getDeleteOrderIds() {
        return deleteOrderIds;
    }

    public void setDeleteOrderIds(String deleteOrderIds) {
        this.deleteOrderIds = deleteOrderIds;
    }
}