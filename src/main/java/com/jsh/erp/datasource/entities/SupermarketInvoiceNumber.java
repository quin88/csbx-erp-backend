package com.jsh.erp.datasource.entities;

import java.io.Serializable;

public class SupermarketInvoiceNumber implements Serializable {
    private Long id;

    private Long supermarketDocumentId;

    private String invoiceNumber;

    private Long tenantId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSupermarketDocumentId() {
        return supermarketDocumentId;
    }

    public void setSupermarketDocumentId(Long supermarketDocumentId) {
        this.supermarketDocumentId = supermarketDocumentId;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber == null ? null : invoiceNumber.trim();
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }
}