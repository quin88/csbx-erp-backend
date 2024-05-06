package com.jsh.erp.datasource.entities;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderDetail implements Serializable {
    private Long id;

    private Long orderId;

    private Long supplierId;

    private Long materialId;

    private String aquaticType;

    private String originSource;

    private BigDecimal quantity;

    private String unit;

    private BigDecimal unitPrice;

    private BigDecimal nakedPrice;

    private BigDecimal taxNakedPrice;

    private BigDecimal taxUnitPrice;

    private Long accountId;

    private String bankName;

    private String accountName;

    private String deleteFlag;

    private Long tenantId;

    private BigDecimal difference;

    private BigDecimal supplementaryAmount;

    private String downloadStatus;

    private String paymentStatus;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }

    public String getAquaticType() {
        return aquaticType;
    }

    public void setAquaticType(String aquaticType) {
        this.aquaticType = aquaticType == null ? null : aquaticType.trim();
    }

    public String getOriginSource() {
        return originSource;
    }

    public void setOriginSource(String originSource) {
        this.originSource = originSource == null ? null : originSource.trim();
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getNakedPrice() {
        return nakedPrice;
    }

    public void setNakedPrice(BigDecimal nakedPrice) {
        this.nakedPrice = nakedPrice;
    }

    public BigDecimal getTaxNakedPrice() {
        return taxNakedPrice;
    }

    public void setTaxNakedPrice(BigDecimal taxNakedPrice) {
        this.taxNakedPrice = taxNakedPrice;
    }

    public BigDecimal getTaxUnitPrice() {
        return taxUnitPrice;
    }

    public void setTaxUnitPrice(BigDecimal taxUnitPrice) {
        this.taxUnitPrice = taxUnitPrice;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
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

    public BigDecimal getDifference() {
        return difference;
    }

    public void setDifference(BigDecimal difference) {
        this.difference = difference;
    }

    public BigDecimal getSupplementaryAmount() {
        return supplementaryAmount;
    }

    public void setSupplementaryAmount(BigDecimal supplementaryAmount) {
        this.supplementaryAmount = supplementaryAmount;
    }

    public String getDownloadStatus() {
        return downloadStatus;
    }

    public void setDownloadStatus(String downloadStatus) {
        this.downloadStatus = downloadStatus == null ? null : downloadStatus.trim();
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus == null ? null : paymentStatus.trim();
    }
}