package com.jsh.erp.datasource.entities;

import java.io.Serializable;

public class PaymentConfig implements Serializable {
    private Long id;

    private Long marketAddressId;

    private Long aquaticTypeId;

    private Integer deadline;

    private String deleteFlag;

    private Long tenantId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMarketAddressId() {
        return marketAddressId;
    }

    public void setMarketAddressId(Long marketAddressId) {
        this.marketAddressId = marketAddressId;
    }

    public Long getAquaticTypeId() {
        return aquaticTypeId;
    }

    public void setAquaticTypeId(Long aquaticTypeId) {
        this.aquaticTypeId = aquaticTypeId;
    }

    public Integer getDeadline() {
        return deadline;
    }

    public void setDeadline(Integer deadline) {
        this.deadline = deadline;
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
}