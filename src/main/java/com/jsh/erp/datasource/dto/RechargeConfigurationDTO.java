package com.jsh.erp.datasource.dto;

import com.jsh.erp.datasource.entities.RechargeConfiguration;

import java.util.List;

public class RechargeConfigurationDTO {

    private List<RechargeConfiguration> rechargeConfigurations;

    private String deleteIds;

    public List<RechargeConfiguration> getRechargeConfigurations() {
        return rechargeConfigurations;
    }

    public void setRechargeConfigurations(List<RechargeConfiguration> rechargeConfigurations) {
        this.rechargeConfigurations = rechargeConfigurations;
    }

    public String getDeleteIds() {
        return deleteIds;
    }

    public void setDeleteIds(String deleteIds) {
        this.deleteIds = deleteIds;
    }
}