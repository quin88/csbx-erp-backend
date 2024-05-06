package com.jsh.erp.datasource.entities;

import java.io.Serializable;
import java.util.Date;

public class GoodsAllocation implements Serializable {
    private Long id;

    private String goodsAllocation;

    private Long depotId;

    private String depot;

    private String remark;

    private Date createTime;

    private Long creator;

    private Date updateTime;

    private Long updater;

    private Long tenantId;

    private String deleteFlag;

    private Long smallDepotId;

    private Long locationId;

    private Integer row;

    private String goodsType;

    private String spaceType;

    private Integer lattice;

    private Integer capacity;

    private String capacityStatus;

    private Integer length;

    private Integer width;

    private Integer height;

    private Integer weight;

    private String weightUnit;

    private String number;

    private Boolean enabled;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoodsAllocation() {
        return goodsAllocation;
    }

    public void setGoodsAllocation(String goodsAllocation) {
        this.goodsAllocation = goodsAllocation == null ? null : goodsAllocation.trim();
    }

    public Long getDepotId() {
        return depotId;
    }

    public void setDepotId(Long depotId) {
        this.depotId = depotId;
    }

    public String getDepot() {
        return depot;
    }

    public void setDepot(String depot) {
        this.depot = depot == null ? null : depot.trim();
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

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }

    public Long getSmallDepotId() {
        return smallDepotId;
    }

    public void setSmallDepotId(Long smallDepotId) {
        this.smallDepotId = smallDepotId;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType == null ? null : goodsType.trim();
    }

    public String getSpaceType() {
        return spaceType;
    }

    public void setSpaceType(String spaceType) {
        this.spaceType = spaceType == null ? null : spaceType.trim();
    }

    public Integer getLattice() {
        return lattice;
    }

    public void setLattice(Integer lattice) {
        this.lattice = lattice;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getCapacityStatus() {
        return capacityStatus;
    }

    public void setCapacityStatus(String capacityStatus) {
        this.capacityStatus = capacityStatus == null ? null : capacityStatus.trim();
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit == null ? null : weightUnit.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}