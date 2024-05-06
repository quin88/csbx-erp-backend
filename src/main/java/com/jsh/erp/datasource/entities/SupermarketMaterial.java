package com.jsh.erp.datasource.entities;

import java.io.Serializable;
import java.util.Date;

public class SupermarketMaterial implements Serializable {
    private Long id;

    private Long supplierId;

    private Long categoryId;

    private Long secondCategoryId;

    private Long thirdCategoryId;

    private String number;

    private String name;

    private String unit;

    private String temperatureCondition;

    private String aquaticType;

    private Long province;

    private Long city;

    private Long county;

    private String remark;

    private String status;

    private Boolean enabled;

    private Date createTime;

    private Long creator;

    private Date updateTime;

    private Long updater;

    private Long verifier;

    private Date verifierTime;

    private String comment;

    private String deleteFlag;

    private Long tenantId;

    private String supplyingZeroName;

    private String supplyingZeroNumber;

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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getSecondCategoryId() {
        return secondCategoryId;
    }

    public void setSecondCategoryId(Long secondCategoryId) {
        this.secondCategoryId = secondCategoryId;
    }

    public Long getThirdCategoryId() {
        return thirdCategoryId;
    }

    public void setThirdCategoryId(Long thirdCategoryId) {
        this.thirdCategoryId = thirdCategoryId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getTemperatureCondition() {
        return temperatureCondition;
    }

    public void setTemperatureCondition(String temperatureCondition) {
        this.temperatureCondition = temperatureCondition == null ? null : temperatureCondition.trim();
    }

    public String getAquaticType() {
        return aquaticType;
    }

    public void setAquaticType(String aquaticType) {
        this.aquaticType = aquaticType == null ? null : aquaticType.trim();
    }

    public Long getProvince() {
        return province;
    }

    public void setProvince(Long province) {
        this.province = province;
    }

    public Long getCity() {
        return city;
    }

    public void setCity(Long city) {
        this.city = city;
    }

    public Long getCounty() {
        return county;
    }

    public void setCounty(Long county) {
        this.county = county;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
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

    public String getSupplyingZeroName() {
        return supplyingZeroName;
    }

    public void setSupplyingZeroName(String supplyingZeroName) {
        this.supplyingZeroName = supplyingZeroName == null ? null : supplyingZeroName.trim();
    }

    public String getSupplyingZeroNumber() {
        return supplyingZeroNumber;
    }

    public void setSupplyingZeroNumber(String supplyingZeroNumber) {
        this.supplyingZeroNumber = supplyingZeroNumber == null ? null : supplyingZeroNumber.trim();
    }
}