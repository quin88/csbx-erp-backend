package com.jsh.erp.datasource.dto;

import com.jsh.erp.datasource.entities.*;

import java.util.List;

public class SupermarketSupplierDetailsDTO {
    private Long supplierId;
    private List<SupermarketContact> supermarketContactList;

    private List<SupermarketAccount> supermarketAccountList;

    private List<SupermarketInvoice> supermarketInvoiceList;

    private List<SupermarketCooperation> supermarketCooperationList;

    private List<SupermarketAttachment> supermarketAttachmentList;

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public List<SupermarketContact> getSupermarketContactList() {
        return supermarketContactList;
    }

    public void setSupermarketContactList(List<SupermarketContact> supermarketContactList) {
        this.supermarketContactList = supermarketContactList;
    }

    public List<SupermarketAccount> getSupermarketAccountList() {
        return supermarketAccountList;
    }

    public void setSupermarketAccountList(List<SupermarketAccount> supermarketAccountList) {
        this.supermarketAccountList = supermarketAccountList;
    }

    public List<SupermarketInvoice> getSupermarketInvoiceList() {
        return supermarketInvoiceList;
    }

    public void setSupermarketInvoiceList(List<SupermarketInvoice> supermarketInvoiceList) {
        this.supermarketInvoiceList = supermarketInvoiceList;
    }

    public List<SupermarketCooperation> getSupermarketCooperationList() {
        return supermarketCooperationList;
    }

    public void setSupermarketCooperationList(List<SupermarketCooperation> supermarketCooperationList) {
        this.supermarketCooperationList = supermarketCooperationList;
    }

    public List<SupermarketAttachment> getSupermarketAttachmentList() {
        return supermarketAttachmentList;
    }

    public void setSupermarketAttachmentList(List<SupermarketAttachment> supermarketAttachmentList) {
        this.supermarketAttachmentList = supermarketAttachmentList;
    }
}
