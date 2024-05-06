package com.jsh.erp.datasource.dto;

import com.jsh.erp.datasource.entities.BusinessHours;
import com.jsh.erp.datasource.entities.Depot;

import java.util.List;

public class DepotDTO extends Depot {

    private List<BusinessHours> businessHours;

    private String deleteIds;

    public List<BusinessHours> getBusinessHours() {
        return businessHours;
    }

    public void setBusinessHours(List<BusinessHours> businessHours) {
        this.businessHours = businessHours;
    }

    public String getDeleteIds() {
        return deleteIds;
    }

    public void setDeleteIds(String deleteIds) {
        this.deleteIds = deleteIds;
    }
}