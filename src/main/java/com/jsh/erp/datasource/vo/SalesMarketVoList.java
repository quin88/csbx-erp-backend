package com.jsh.erp.datasource.vo;

import com.jsh.erp.datasource.entities.SalesMarket;

public class SalesMarketVoList extends SalesMarket {
    private String materialName;

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }
}
