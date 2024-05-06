package com.jsh.erp.datasource.entities;

import java.io.Serializable;

public class MarketAddress implements Serializable {
    private Long id;

    private String marketAddress;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarketAddress() {
        return marketAddress;
    }

    public void setMarketAddress(String marketAddress) {
        this.marketAddress = marketAddress == null ? null : marketAddress.trim();
    }
}