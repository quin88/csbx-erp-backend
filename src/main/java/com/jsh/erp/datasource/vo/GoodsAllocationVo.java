package com.jsh.erp.datasource.vo;

import com.jsh.erp.datasource.entities.GoodsAllocation;

public class GoodsAllocationVo extends GoodsAllocation {

    private String smallDepotName;//小仓库名称

    private String locationName;//区位名称

    private String createdName;

    public String getCreatedName() {
        return createdName;
    }

    public void setCreatedName(String createdName) {
        this.createdName = createdName;
    }

    public String getSmallDepotName() {
        return smallDepotName;
    }

    public void setSmallDepotName(String smallDepotName) {
        this.smallDepotName = smallDepotName;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}