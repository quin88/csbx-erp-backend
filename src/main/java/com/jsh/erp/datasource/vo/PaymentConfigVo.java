package com.jsh.erp.datasource.vo;

import com.jsh.erp.datasource.entities.PaymentConfig;

public class PaymentConfigVo extends PaymentConfig {

    private String market;

    private String cooperationCategory;

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getCooperationCategory() {
        return cooperationCategory;
    }

    public void setCooperationCategory(String cooperationCategory) {
        this.cooperationCategory = cooperationCategory;
    }
}
