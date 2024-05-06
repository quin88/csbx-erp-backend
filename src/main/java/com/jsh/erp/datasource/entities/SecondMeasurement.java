package com.jsh.erp.datasource.entities;

import java.io.Serializable;

public class SecondMeasurement implements Serializable {
    private Long id;

    private Long measurementId;

    private String secondMeasurementUnit;

    private Long tenantId;

    private String deleteFlag;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMeasurementId() {
        return measurementId;
    }

    public void setMeasurementId(Long measurementId) {
        this.measurementId = measurementId;
    }

    public String getSecondMeasurementUnit() {
        return secondMeasurementUnit;
    }

    public void setSecondMeasurementUnit(String secondMeasurementUnit) {
        this.secondMeasurementUnit = secondMeasurementUnit == null ? null : secondMeasurementUnit.trim();
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }
}