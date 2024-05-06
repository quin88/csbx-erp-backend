package com.jsh.erp.datasource.vo;


import java.math.BigDecimal;
import java.util.Date;

public class PriceDetailsVoList  {
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

    private String createTime;

    private Long creator;

    private Date updateTime;

    private Long updater;

    private String deleteFlag;

    private Long tenantId;
    private String createTimeStr;


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
        this.number = number;
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
        this.supplier = supplier;
    }

    public String getReceiptsNumber() {
        return receiptsNumber;
    }

    public void setReceiptsNumber(String receiptsNumber) {
        this.receiptsNumber = receiptsNumber;
    }

    public String getBringIn() {
        return bringIn;
    }

    public void setBringIn(String bringIn) {
        this.bringIn = bringIn;
    }

    public String getOtherPriceType() {
        return otherPriceType;
    }

    public void setOtherPriceType(String otherPriceType) {
        this.otherPriceType = otherPriceType;
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
        this.timeMeasurement = timeMeasurement;
    }

    public String getWeightMeasurement() {
        return weightMeasurement;
    }

    public void setWeightMeasurement(String weightMeasurement) {
        this.weightMeasurement = weightMeasurement;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
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
        this.deleteFlag = deleteFlag;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }
}
