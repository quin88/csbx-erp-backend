package com.jsh.erp.datasource.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SupermarketOrder implements Serializable {
    private Long id;

    private Date openTime;

    private String number;

    private String category;

    private BigDecimal nakedPriceTotal;

    private BigDecimal taxInclusiveTotal;

    private String status;

    private String uploadStatus;

    private String remark;

    private Date createTime;

    private Long creator;

    private Date updateTime;

    private Long updater;

    private Long verifier;

    private Date verifierTime;

    private String comment;

    private String deleteFlag;

    private Long tenantId;

    private Date tradeTime;

    private Long serveClientId;

    private Long marketAddressId;

    private BigDecimal differenceTotal;

    private Long linkId;

    private String linkNumber;

    private BigDecimal initialDifference;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public BigDecimal getNakedPriceTotal() {
        return nakedPriceTotal;
    }

    public void setNakedPriceTotal(BigDecimal nakedPriceTotal) {
        this.nakedPriceTotal = nakedPriceTotal;
    }

    public BigDecimal getTaxInclusiveTotal() {
        return taxInclusiveTotal;
    }

    public void setTaxInclusiveTotal(BigDecimal taxInclusiveTotal) {
        this.taxInclusiveTotal = taxInclusiveTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getUploadStatus() {
        return uploadStatus;
    }

    public void setUploadStatus(String uploadStatus) {
        this.uploadStatus = uploadStatus == null ? null : uploadStatus.trim();
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

    public Long getVerifier() {
        return verifier;
    }

    public void setVerifier(Long verifier) {
        this.verifier = verifier;
    }

    public Date getVerifierTime() {
        return verifierTime;
    }

    public void setVerifierTime(Date verifierTime) {
        this.verifierTime = verifierTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
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

    public Date getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(Date tradeTime) {
        this.tradeTime = tradeTime;
    }

    public Long getServeClientId() {
        return serveClientId;
    }

    public void setServeClientId(Long serveClientId) {
        this.serveClientId = serveClientId;
    }

    public Long getMarketAddressId() {
        return marketAddressId;
    }

    public void setMarketAddressId(Long marketAddressId) {
        this.marketAddressId = marketAddressId;
    }

    public BigDecimal getDifferenceTotal() {
        return differenceTotal;
    }

    public void setDifferenceTotal(BigDecimal differenceTotal) {
        this.differenceTotal = differenceTotal;
    }

    public Long getLinkId() {
        return linkId;
    }

    public void setLinkId(Long linkId) {
        this.linkId = linkId;
    }

    public String getLinkNumber() {
        return linkNumber;
    }

    public void setLinkNumber(String linkNumber) {
        this.linkNumber = linkNumber == null ? null : linkNumber.trim();
    }

    public BigDecimal getInitialDifference() {
        return initialDifference;
    }

    public void setInitialDifference(BigDecimal initialDifference) {
        this.initialDifference = initialDifference;
    }
}