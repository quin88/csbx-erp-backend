package com.jsh.erp.datasource.entities;

import java.io.Serializable;

public class Province implements Serializable {
    private Long id;

    private Long countryId;

    private String provinceName;

    private String provinceNumber;

    private String deleteFlag;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName == null ? null : provinceName.trim();
    }

    public String getProvinceNumber() {
        return provinceNumber;
    }

    public void setProvinceNumber(String provinceNumber) {
        this.provinceNumber = provinceNumber == null ? null : provinceNumber.trim();
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }
}