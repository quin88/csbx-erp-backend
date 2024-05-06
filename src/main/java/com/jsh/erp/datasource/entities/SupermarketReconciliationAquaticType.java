package com.jsh.erp.datasource.entities;

import java.io.Serializable;

public class SupermarketReconciliationAquaticType implements Serializable {
    private Long id;

    private Long supermarketReconciliationId;

    private Long aquaticTypeId;

    private String aquaticType;

    private Long tenantId;

    private String deleteFlag;

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

    public Long getAquaticTypeId() {
        return aquaticTypeId;
    }

    public void setAquaticTypeId(Long aquaticTypeId) {
        this.aquaticTypeId = aquaticTypeId;
    }

    public String getAquaticType() {
        return aquaticType;
    }

    public void setAquaticType(String aquaticType) {
        this.aquaticType = aquaticType == null ? null : aquaticType.trim();
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