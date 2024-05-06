package com.jsh.erp.datasource.dto;

import java.util.List;

public class CityDTO {

    private Long cityId;

    private String cityName;

    private String cityNumber;

    private List<CountyDTO> counties;

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityNumber() {
        return cityNumber;
    }

    public void setCityNumber(String cityNumber) {
        this.cityNumber = cityNumber;
    }

    public List<CountyDTO> getCounties() {
        return counties;
    }

    public void setCounties(List<CountyDTO> counties) {
        this.counties = counties;
    }
}