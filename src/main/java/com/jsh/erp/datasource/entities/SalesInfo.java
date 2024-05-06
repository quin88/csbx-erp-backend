package com.jsh.erp.datasource.entities;

import java.io.Serializable;
import java.math.BigDecimal;

public class SalesInfo implements Serializable {
    private Long id;

    private Long materialId;

    private String storeNumber;

    private BigDecimal taxPurchasePrice;

    private BigDecimal taxSellingPrice;

    private String standard;

    private Boolean shippingCost;

    private String sourceType;

    private String salesChannel;

    private String shippingMethod;

    private String boxSpec;

    private BigDecimal smallQuantity;

    private BigDecimal largeQuantity;

    private BigDecimal weight;

    private String boxBarcode;

    private String launchDate;

    private String remark;

    private Long province;

    private Long city;

    private Long county;

    private String deleteFlag;

    private Long tenantId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }

    public String getStoreNumber() {
        return storeNumber;
    }

    public void setStoreNumber(String storeNumber) {
        this.storeNumber = storeNumber == null ? null : storeNumber.trim();
    }

    public BigDecimal getTaxPurchasePrice() {
        return taxPurchasePrice;
    }

    public void setTaxPurchasePrice(BigDecimal taxPurchasePrice) {
        this.taxPurchasePrice = taxPurchasePrice;
    }

    public BigDecimal getTaxSellingPrice() {
        return taxSellingPrice;
    }

    public void setTaxSellingPrice(BigDecimal taxSellingPrice) {
        this.taxSellingPrice = taxSellingPrice;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard == null ? null : standard.trim();
    }

    public Boolean getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(Boolean shippingCost) {
        this.shippingCost = shippingCost;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType == null ? null : sourceType.trim();
    }

    public String getSalesChannel() {
        return salesChannel;
    }

    public void setSalesChannel(String salesChannel) {
        this.salesChannel = salesChannel == null ? null : salesChannel.trim();
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod == null ? null : shippingMethod.trim();
    }

    public String getBoxSpec() {
        return boxSpec;
    }

    public void setBoxSpec(String boxSpec) {
        this.boxSpec = boxSpec == null ? null : boxSpec.trim();
    }

    public BigDecimal getSmallQuantity() {
        return smallQuantity;
    }

    public void setSmallQuantity(BigDecimal smallQuantity) {
        this.smallQuantity = smallQuantity;
    }

    public BigDecimal getLargeQuantity() {
        return largeQuantity;
    }

    public void setLargeQuantity(BigDecimal largeQuantity) {
        this.largeQuantity = largeQuantity;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getBoxBarcode() {
        return boxBarcode;
    }

    public void setBoxBarcode(String boxBarcode) {
        this.boxBarcode = boxBarcode == null ? null : boxBarcode.trim();
    }

    public String getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate == null ? null : launchDate.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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