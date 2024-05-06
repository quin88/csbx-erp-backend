package com.jsh.erp.datasource.entities;

import java.io.Serializable;

public class DepotLinkNumber implements Serializable {
    private Long id;

    private String linkNumber;

    private Long depotHeadId;

    private String deleteFlag;

    private Long tenantId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLinkNumber() {
        return linkNumber;
    }

    public void setLinkNumber(String linkNumber) {
        this.linkNumber = linkNumber == null ? null : linkNumber.trim();
    }

    public Long getDepotHeadId() {
        return depotHeadId;
    }

    public void setDepotHeadId(Long depotHeadId) {
        this.depotHeadId = depotHeadId;
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