package com.jsh.erp.datasource.vo;

import com.jsh.erp.datasource.entities.BusinessHours;

public class BusinessHoursVo extends BusinessHours {

    private String beginTimeStr;

    private String endTimeStr;

    public String getBeginTimeStr() {
        return beginTimeStr;
    }

    public void setBeginTimeStr(String beginTimeStr) {
        this.beginTimeStr = beginTimeStr;
    }

    public String getEndTimeStr() {
        return endTimeStr;
    }

    public void setEndTimeStr(String endTimeStr) {
        this.endTimeStr = endTimeStr;
    }
}
