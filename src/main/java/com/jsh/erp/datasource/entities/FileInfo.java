package com.jsh.erp.datasource.entities;

import java.io.Serializable;

public class FileInfo implements Serializable {
    private Long id;

    private Long materialId;

    private Long baseInfoId;

    private Long invoiceNumberId;

    private String filePath;

    private Long tenantId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }

    public Long getBaseInfoId() {
        return baseInfoId;
    }

    public void setBaseInfoId(Long baseInfoId) {
        this.baseInfoId = baseInfoId;
    }

    public Long getInvoiceNumberId() {
        return invoiceNumberId;
    }

    public void setInvoiceNumberId(Long invoiceNumberId) {
        this.invoiceNumberId = invoiceNumberId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }
}