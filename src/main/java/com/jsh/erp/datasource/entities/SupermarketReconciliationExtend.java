package com.jsh.erp.datasource.entities;

import java.io.Serializable;
import java.math.BigDecimal;

public class SupermarketReconciliationExtend implements Serializable {
    private Long id;

    private Long supermarketReconciliationId;

    private String name;

    private String aquaticType;

    private String unit;

    private BigDecimal quantity;

    private BigDecimal price;

    private BigDecimal billingPrice;

    private BigDecimal systemPrice;

    private String deleteFlag;

    private Long tenantId;

    private String supplyingZeroNumber;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSupermarketReconciliationId() {
        return supermarketReconciliationId;
    }

    public void setSupermarketReconciliationId(Long supermarketReconciliationId) {
        this.supermarketReconciliationId = supermarketReconciliationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAquaticType() {
        return aquaticType;
    }

    public void setAquaticType(String aquaticType) {
        this.aquaticType = aquaticType == null ? null : aquaticType.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getBillingPrice() {
        return billingPrice;
    }

    public void setBillingPrice(BigDecimal billingPrice) {
        this.billingPrice = billingPrice;
    }

    public BigDecimal getSystemPrice() {
        return systemPrice;
    }

    public void setSystemPrice(BigDecimal systemPrice) {
        this.systemPrice = systemPrice;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getSupplyingZeroNumber() {
        return supplyingZeroNumber;
    }

    public void setSupplyingZeroNumber(String supplyingZeroNumber) {
        this.supplyingZeroNumber = supplyingZeroNumber == null ? null : supplyingZeroNumber.trim();
    }
}