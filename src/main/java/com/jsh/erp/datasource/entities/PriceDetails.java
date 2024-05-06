package com.jsh.erp.datasource.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PriceDetails implements Serializable {
    private Long id;

    private String number;

    private Long supplierId;

    private String supplier;

    private String receiptsNumber;

    private String bringIn;

    private String otherPriceType;

    private BigDecimal price;

    private BigDecimal subtotal;

    private BigDecimal priceNumber;

    private String timeMeasurement;

    private String weightMeasurement;

    private String status;

    private String remark;

    private Date createTime;

    private Long creator;

    private Date updateTime;

    private Long updater;

    private String deleteFlag;

    private Long tenantId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier == null ? null : supplier.trim();
    }

    public String getReceiptsNumber() {
        return receiptsNumber;
    }

    public void setReceiptsNumber(String receiptsNumber) {
        this.receiptsNumber = receiptsNumber == null ? null : receiptsNumber.trim();
    }

    public String getBringIn() {
        return bringIn;
    }

    public void setBringIn(String bringIn) {
        this.bringIn = bringIn == null ? null : bringIn.trim();
    }

    public String getOtherPriceType() {
        return otherPriceType;
    }

    public void setOtherPriceType(String otherPriceType) {
        this.otherPriceType = otherPriceType == null ? null : otherPriceType.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getPriceNumber() {
        return priceNumber;
    }

    public void setPriceNumber(BigDecimal priceNumber) {
        this.priceNumber = priceNumber;
    }

    public String getTimeMeasurement() {
        return timeMeasurement;
    }

    public void setTimeMeasurement(String timeMeasurement) {
        this.timeMeasurement = timeMeasurement == null ? null : timeMeasurement.trim();
    }

    public String getWeightMeasurement() {
        return weightMeasurement;
    }

    public void setWeightMeasurement(String weightMeasurement) {
        this.weightMeasurement = weightMeasurement == null ? null : weightMeasurement.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdater() {
        return updater;
    }

    public void setUpdater(Long updater) {
        this.updater = updater;
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