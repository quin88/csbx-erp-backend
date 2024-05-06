package com.jsh.erp.datasource.dto;

import java.util.List;

public class ProvinceDTO {

    private Long provinceId;

    private String provinceName;

    private String provinceNumber;

    private List<CityDTO> cities;

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceNumber() {
        return provinceNumber;
    }

    public void setProvinceNumber(String provinceNumber) {
        this.provinceNumber = provinceNumber;
    }

    public List<CityDTO> getCities() {
        return cities;
    }

    public void setCities(List<CityDTO> cities) {
        this.cities = cities;
    }
}