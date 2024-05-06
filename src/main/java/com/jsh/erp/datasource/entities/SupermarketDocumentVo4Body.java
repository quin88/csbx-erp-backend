package com.jsh.erp.datasource.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class SupermarketDocumentVo4Body extends SupermarketDocument implements Serializable {

    private String itemName;

    private String shipper;

    private String receiver;

    private BigDecimal quantity;

    private String aquaticType;

    private String unit;

    private List<SupermarketDocumentItem> supermarketDocumentItem;

    private List<SupermarketInvoiceNumber> supermarketInvoiceNumbers;

    private String deleteIds;//发票删除id

    private static final long serialVersionUID = 1L;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getShipper() {
        return shipper;
    }

    public void setShipper(String shipper) {
        this.shipper = shipper;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getAquaticType() {
        return aquaticType;
    }

    public void setAquaticType(String aquaticType) {
        this.aquaticType = aquaticType;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public List<SupermarketDocumentItem> getSupermarketDocumentItem() {
        return supermarketDocumentItem;
    }

    public void setSupermarketDocumentItem(List<SupermarketDocumentItem> supermarketDocumentItem) {
        this.supermarketDocumentItem = supermarketDocumentItem;
    }

    public List<SupermarketInvoiceNumber> getSupermarketInvoiceNumbers() {
        return supermarketInvoiceNumbers;
    }

    public void setSupermarketInvoiceNumbers(List<SupermarketInvoiceNumber> supermarketInvoiceNumbers) {
        this.supermarketInvoiceNumbers = supermarketInvoiceNumbers;
    }

    public String getDeleteIds() {
        return deleteIds;
    }

    public void setDeleteIds(String deleteIds) {
        this.deleteIds = deleteIds;
    }
}