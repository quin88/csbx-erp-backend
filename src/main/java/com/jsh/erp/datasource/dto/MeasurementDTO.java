package com.jsh.erp.datasource.dto;

import com.jsh.erp.datasource.entities.Measurement;

import java.util.List;

public class MeasurementDTO {
    private List<Measurement> measurements;

    private String deleteId;

    public List<Measurement> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<Measurement> measurements) {
        this.measurements = measurements;
    }

    public String getDeleteId() {
        return deleteId;
    }

    public void setDeleteId(String deleteId) {
        this.deleteId = deleteId;
    }
}
