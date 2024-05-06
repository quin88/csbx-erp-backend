package com.jsh.erp.datasource.dto;

import com.jsh.erp.datasource.entities.ValueAddedServeType;

import java.util.List;

public class ValueAddedServeDTO {

    private List<ValueAddedServeType> valueAddedServeTypes;

    private String deleteIds;

    public List<ValueAddedServeType> getValueAddedServeTypes() {
        return valueAddedServeTypes;
    }

    public void setValueAddedServeTypes(List<ValueAddedServeType> valueAddedServeTypes) {
        this.valueAddedServeTypes = valueAddedServeTypes;
    }

    public String getDeleteIds() {
        return deleteIds;
    }

    public void setDeleteIds(String deleteIds) {
        this.deleteIds = deleteIds;
    }
}