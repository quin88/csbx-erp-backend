package com.jsh.erp.datasource.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DailyPriceLogs implements Serializable {
    private Long id;

    private Long priceDetailsId;

    private BigDecimal otherCostPrice;

    private Date createTime;

    private Long creator;

    private Date updateTime;

    private Long updater;

    private Integer quantity;

    private String deleteFlag;

    private Long tenantId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPriceDetailsId() {
        return priceDetailsId;
    }

    public void setPriceDetailsId(Long priceDetailsId) {
        this.priceDetailsId = priceDetailsId;
    }

    public BigDecimal getOtherCostPrice() {
        return otherCostPrice;
    }

    public void setOtherCostPrice(BigDecimal otherCostPrice) {
        this.otherCostPrice = otherCostPrice;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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