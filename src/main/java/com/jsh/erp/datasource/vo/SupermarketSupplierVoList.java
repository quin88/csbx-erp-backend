package com.jsh.erp.datasource.vo;

import com.jsh.erp.datasource.entities.SupermarketSupplier;

public class SupermarketSupplierVoList extends SupermarketSupplier {
    private String marketName;

    private String provinceName;

    private String cityName;

    private String createdName;

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCreatedName() {
        return createdName;
    }

    public void setCreatedName(String createdName) {
        this.createdName = createdName;
    }
}
