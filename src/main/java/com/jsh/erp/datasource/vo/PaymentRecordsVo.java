package com.jsh.erp.datasource.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 这个VO没有继承对象，要求将创建人，创建时间等字段使用字符串形式返回
 */
public class PaymentRecordsVo implements Serializable {

    private Long id;

    private Long supplierId;

    private String supplier;

    private String paymentNumber;

    private BigDecimal paymentAmount;

    private String fileName;

    private String remark;

    private String approvalStatus;

    private String createTime;

    private String creator;

    private String updateTime;

    private String updater;

    private String deleteFlag;

    private Long tenantId;

    private BigDecimal balanceRecord;//余额

    private String comment;

    private BigDecimal amountOfGift;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPaymentNumber() {
        return paymentNumber;
    }

    public void setPaymentNumber(String paymentNumber) {
        this.paymentNumber = paymentNumber;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
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

    public BigDecimal getBalanceRecord() {
        return balanceRecord;
    }

    public void setBalanceRecord(BigDecimal balanceRecord) {
        this.balanceRecord = balanceRecord;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public BigDecimal getAmountOfGift() {
        return amountOfGift;
    }

    public void setAmountOfGift(BigDecimal amountOfGift) {
        this.amountOfGift = amountOfGift;
    }
}