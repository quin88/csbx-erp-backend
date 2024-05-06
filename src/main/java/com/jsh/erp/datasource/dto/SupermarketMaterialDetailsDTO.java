package com.jsh.erp.datasource.dto;

import com.jsh.erp.datasource.entities.*;

import java.util.List;

public class SupermarketMaterialDetailsDTO {
    private Long materialId;

    private List<SalesMarket> salesMarketList;

    private List<SalesInfo> salesInfoList;

    private List<InvoiceNumber> invoiceList;

    private List<InvoiceNumberDTO> invoiceLists;

    private List<Long> fileIds;

    private List<ImageInfo> imageInfoList;

    private List<FileInfo> fileInfoList;

    public Long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }

    public List<SalesMarket> getSalesMarketList() {
        return salesMarketList;
    }

    public void setSalesMarketList(List<SalesMarket> salesMarketList) {
        this.salesMarketList = salesMarketList;
    }

    public List<SalesInfo> getSalesInfoList() {
        return salesInfoList;
    }

    public void setSalesInfoList(List<SalesInfo> salesInfoList) {
        this.salesInfoList = salesInfoList;
    }

    public List<InvoiceNumber> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<InvoiceNumber> invoiceList) {
        this.invoiceList = invoiceList;
    }

    public List<InvoiceNumberDTO> getInvoiceLists() {
        return invoiceLists;
    }

    public void setInvoiceLists(List<InvoiceNumberDTO> invoiceLists) {
        this.invoiceLists = invoiceLists;
    }

    public List<Long> getFileIds() {
        return fileIds;
    }

    public void setFileIds(List<Long> fileIds) {
        this.fileIds = fileIds;
    }

    public List<ImageInfo> getImageInfoList() {
        return imageInfoList;
    }

    public void setImageInfoList(List<ImageInfo> imageInfoList) {
        this.imageInfoList = imageInfoList;
    }

    public List<FileInfo> getFileInfoList() {
        return fileInfoList;
    }

    public void setFileInfoList(List<FileInfo> fileInfoList) {
        this.fileInfoList = fileInfoList;
    }
}
