package com.jsh.erp.datasource.dto;

import com.jsh.erp.datasource.entities.SecondMeasurement;

import java.util.List;

public class SecondMeasurementDTO {
    private List<SecondMeasurement> secondMeasurementList;

    private String deleteId;

    public List<SecondMeasurement> getSecondMeasurementList() {
        return secondMeasurementList;
    }

    public void setSecondMeasurementList(List<SecondMeasurement> secondMeasurementList) {
        this.secondMeasurementList = secondMeasurementList;
    }

    public String getDeleteId() {
        return deleteId;
    }

    public void setDeleteId(String deleteId) {
        this.deleteId = deleteId;
    }
}
