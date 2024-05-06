package com.jsh.erp.datasource.vo;

import com.jsh.erp.datasource.entities.County;

public class CountyVo4List extends County {

    private String city;

    private String cityNumber;

    private Long provinceId;

    private String province;

    private String provinceNumber;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityNumber() {
        return cityNumber;
    }

    public void setCityNumber(String cityNumber) {
        this.cityNumber = cityNumber;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProvinceNumber() {
        return provinceNumber;
    }

    public void setProvinceNumber(String provinceNumber) {
        this.provinceNumber = provinceNumber;
    }
}
