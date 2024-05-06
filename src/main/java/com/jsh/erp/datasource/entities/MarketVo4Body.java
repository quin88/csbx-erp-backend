package com.jsh.erp.datasource.entities;

import java.util.List;

public class MarketVo4Body extends Market{

    private List<MarketArea> marketAreaList;

    public List<MarketArea> getMarketAreaList() {
        return marketAreaList;
    }

    public void setMarketAreaList(List<MarketArea> marketAreaList) {
        this.marketAreaList = marketAreaList;
    }
}