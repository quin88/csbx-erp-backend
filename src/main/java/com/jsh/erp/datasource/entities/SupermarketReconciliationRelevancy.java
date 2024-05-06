package com.jsh.erp.datasource.entities;

import java.io.Serializable;

public class SupermarketReconciliationRelevancy implements Serializable {
    private Long id;

    private Long supermarketReconciliationId;

    private Long supermarketOrderId;

    private String supermarketOrderNumber;

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

    public Long getSupermarketOrderId() {
        return supermarketOrderId;
    }

    public void setSupermarketOrderId(Long supermarketOrderId) {
        this.supermarketOrderId = supermarketOrderId;
    }

    public String getSupermarketOrderNumber() {
        return supermarketOrderNumber;
    }

    public void setSupermarketOrderNumber(String supermarketOrderNumber) {
        this.supermarketOrderNumber = supermarketOrderNumber == null ? null : supermarketOrderNumber.trim();
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