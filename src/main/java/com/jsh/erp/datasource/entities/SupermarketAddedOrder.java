package com.jsh.erp.datasource.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SupermarketAddedOrder implements Serializable {
    private Long id;

    private Long linkId;

    private String linkNumber;

    private BigDecimal transferAmount;

    private Date paymentDate;

    private String paymentAccountNumber;

    private String collectionAccountNumber;

    private String number;

    private String remark;

    private String image;

    private Date createTime;

    private Long creator;

    private Date updateTime;

    private Long updater;

    private String status;

    private Long verifier;

    private Date verifierTime;

    private String deleteFlag;

    private Long tenantId;

    private String comment;

    private BigDecimal initialDifference;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public BigDecimal getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(BigDecimal transferAmount) {
        this.transferAmount = transferAmount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentAccountNumber() {
        return paymentAccountNumber;
    }

    public void setPaymentAccountNumber(String paymentAccountNumber) {
        this.paymentAccountNumber = paymentAccountNumber == null ? null : paymentAccountNumber.trim();
    }

    public String getCollectionAccountNumber() {
        return collectionAccountNumber;
    }

    public void setCollectionAccountNumber(String collectionAccountNumber) {
        this.collectionAccountNumber = collectionAccountNumber == null ? null : collectionAccountNumber.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public BigDecimal getInitialDifference() {
        return initialDifference;
    }

    public void setInitialDifference(BigDecimal initialDifference) {
        this.initialDifference = initialDifference;
    }
}