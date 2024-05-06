package com.jsh.erp.datasource.vo;

import com.jsh.erp.datasource.entities.Location;

public class LocationVo extends Location {

    private String depotName;

    private String smallDepotName;

    public String getDepotName() {
        return depotName;
    }

    public void setDepotName(String depotName) {
        this.depotName = depotName;
    }

    public String getSmallDepotName() {
        return smallDepotName;
    }

    public void setSmallDepotName(String smallDepotName) {
        this.smallDepotName = smallDepotName;
    }
}