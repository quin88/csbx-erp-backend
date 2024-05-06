package com.jsh.erp.datasource.entities;

import java.io.Serializable;
import java.util.Date;

public class SupermarketReconciliation implements Serializable {
    private Long id;

    private String number;

    private Long aquaticTypeId;

    private String remark;

    private Date reconciliationBeginTime;

    private Date reconciliationEndTime;

    private String status;

    private Date createTime;

    private Long creator;

    private Date updateTime;

    private Long updater;

    private Long verifier;

    private Date verifierTime;

    private String deleteFlag;

    private Long tenantId;

    private String comment;

    private String formula;

    private String documentName;

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

    public Long getAquaticTypeId() {
        return aquaticTypeId;
    }

    public void setAquaticTypeId(Long aquaticTypeId) {
        this.aquaticTypeId = aquaticTypeId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getReconciliationBeginTime() {
        return reconciliationBeginTime;
    }

    public void setReconciliationBeginTime(Date reconciliationBeginTime) {
        this.reconciliationBeginTime = reconciliationBeginTime;
    }

    public Date getReconciliationEndTime() {
        return reconciliationEndTime;
    }

    public void setReconciliationEndTime(Date reconciliationEndTime) {
        this.reconciliationEndTime = reconciliationEndTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula == null ? null : formula.trim();
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName == null ? null : documentName.trim();
    }
}