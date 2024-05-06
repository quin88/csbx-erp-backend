package com.jsh.erp.datasource.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class FeesSettlement implements Serializable {
    private Long id;

    private Long supplierId;

    private Long settlementId;

    private Long secondSettlementId;

    private String measurementUnit;

    private String secondMeasurementUnit;

    private BigDecimal price;

    private Date createTime;

    private Long creator;

    private Date updateTime;

    private Long updater;

    private Long tenantId;

    private String deleteFlag;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Long getSettlementId() {
        return settlementId;
    }

    public void setSettlementId(Long settlementId) {
        this.settlementId = settlementId;
    }

    public Long getSecondSettlementId() {
        return secondSettlementId;
    }

    public void setSecondSettlementId(Long secondSettlementId) {
        this.secondSettlementId = secondSettlementId;
    }

    public String getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(String measurementUnit) {
        this.measurementUnit = measurementUnit == null ? null : measurementUnit.trim();
    }

    public String getSecondMeasurementUnit() {
        return secondMeasurementUnit;
    }

    public void setSecondMeasurementUnit(String secondMeasurementUnit) {
        this.secondMeasurementUnit = secondMeasurementUnit == null ? null : secondMeasurementUnit.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdater() {
        return updater;
    }

    public void setUpdater(Long updater) {
        this.updater = updater;
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