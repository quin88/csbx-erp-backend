package com.jsh.erp.datasource.vo;

import java.math.BigDecimal;
import java.util.Date;

public class ImportPriceReceiptsVo4List {

    private Date createdTime;

    private String barCode;

    private String name;

    private String materialUnit;

    private String depotName;

    private String anotherDepotName;

    private String goodsAllocationName;

    private String anotherGoodsAllocationName;

    private BigDecimal totalWeight;

    private BigDecimal weight;

    private Date productionDate;

    private String producingArea;

    private String batchNumber;

    private Integer expiryNum;//有效期

    private BigDecimal paymentAmount;//充值金额

    private BigDecimal amountOfGift;//赠送金额

    private BigDecimal numberOfPanels;

    private BigDecimal numberOfPallets;

    private BigDecimal unitPrice;

    private BigDecimal allPrice;//总金额

    private String remark;

    private BigDecimal operNumber;

    private String type;

    private String number;

    private String supplier;

    private String timeMeasurement;//时间单位

    private String weightMeasurement;//重量单位

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterialUnit() {
        return materialUnit;
    }

    public void setMaterialUnit(String materialUnit) {
        this.materialUnit = materialUnit;
    }

    public String getDepotName() {
        return depotName;
    }

    public void setDepotName(String depotName) {
        this.depotName = depotName;
    }

    public String getAnotherDepotName() {
        return anotherDepotName;
    }

    public void setAnotherDepotName(String anotherDepotName) {
        this.anotherDepotName = anotherDepotName;
    }

    public String getGoodsAllocationName() {
        return goodsAllocationName;
    }

    public void setGoodsAllocationName(String goodsAllocationName) {
        this.goodsAllocationName = goodsAllocationName;
    }

    public String getAnotherGoodsAllocationName() {
        return anotherGoodsAllocationName;
    }

    public void setAnotherGoodsAllocationName(String anotherGoodsAllocationName) {
        this.anotherGoodsAllocationName = anotherGoodsAllocationName;
    }

    public BigDecimal getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(BigDecimal totalWeight) {
        this.totalWeight = totalWeight;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public String getProducingArea() {
        return producingArea;
    }

    public void setProducingArea(String producingArea) {
        this.producingArea = producingArea;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public Integer getExpiryNum() {
        return expiryNum;
    }

    public void setExpiryNum(Integer expiryNum) {
        this.expiryNum = expiryNum;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public BigDecimal getAmountOfGift() {
        return amountOfGift;
    }

    public void setAmountOfGift(BigDecimal amountOfGift) {
        this.amountOfGift = amountOfGift;
    }

    public BigDecimal getNumberOfPanels() {
        return numberOfPanels;
    }

    public void setNumberOfPanels(BigDecimal numberOfPanels) {
        this.numberOfPanels = numberOfPanels;
    }

    public BigDecimal getNumberOfPallets() {
        return numberOfPallets;
    }

    public void setNumberOfPallets(BigDecimal numberOfPallets) {
        this.numberOfPallets = numberOfPallets;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getAllPrice() {
        return allPrice;
    }

    public void setAllPrice(BigDecimal allPrice) {
        this.allPrice = allPrice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getOperNumber() {
        return operNumber;
    }

    public void setOperNumber(BigDecimal operNumber) {
        this.operNumber = operNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
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
}
