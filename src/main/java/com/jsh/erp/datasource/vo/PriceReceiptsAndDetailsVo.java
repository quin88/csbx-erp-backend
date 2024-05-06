package com.jsh.erp.datasource.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class PriceReceiptsAndDetailsVo{
    private Long id;

    private String number;

    private Long supplierId;

    private String supplier;

    private String receiptsNumber;

    private String status;

    private BigDecimal totalPrice;

    private String createTime;

    private String createTimeStr;

    private Long creator;

    private Date updateTime;

    private Long updater;

    private String deleteFlag;

    private Long tenantId;

    private String priceType;

    private String comment;

    private Long verifier;

    private List<PriceDetailsVoList> priceDetails;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
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

    public String getPriceType() {
        return priceType;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getVerifier() {
        return verifier;
    }

    public void setVerifier(Long verifier) {
        this.verifier = verifier;
    }

    public List<PriceDetailsVoList> getPriceDetails() {
        return priceDetails;
    }

    public void setPriceDetails(List<PriceDetailsVoList> priceDetails) {
        this.priceDetails = priceDetails;
    }
}
