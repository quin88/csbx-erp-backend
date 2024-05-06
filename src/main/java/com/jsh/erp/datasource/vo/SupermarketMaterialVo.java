package com.jsh.erp.datasource.vo;

import com.jsh.erp.datasource.entities.FileInfo;
import com.jsh.erp.datasource.entities.SupermarketMaterial;

import java.util.List;

public class SupermarketMaterialVo extends SupermarketMaterial {
    //供应商编码
    private String supplierNumber;

    //一级分类编码
    private String categoryNumber;

    //二级分类编码
    private String secondCategoryNumber;

    //三级分类编码
    private String thirdCategoryNumber;

    //省编码
    private String provinceNumber;

    //市编码
    private String cityNumber;

    //区/县/镇编码
    private String countyNumber;

    //省名称
    private String provinceName;

    //市名称
    private String cityName;

    //区/县/镇名称
    private String countyName;

    private List<FileInfo> fileInfos;
    public String getSupplierNumber() {
        return supplierNumber;
    }

    public void setSupplierNumber(String supplierNumber) {
        this.supplierNumber = supplierNumber;
    }

    public String getCategoryNumber() {
        return categoryNumber;
    }

    public void setCategoryNumber(String categoryNumber) {
        this.categoryNumber = categoryNumber;
    }

    public String getSecondCategoryNumber() {
        return secondCategoryNumber;
    }

    public void setSecondCategoryNumber(String secondCategoryNumber) {
        this.secondCategoryNumber = secondCategoryNumber;
    }

    public String getThirdCategoryNumber() {
        return thirdCategoryNumber;
    }

    public void setThirdCategoryNumber(String thirdCategoryNumber) {
        this.thirdCategoryNumber = thirdCategoryNumber;
    }

    public String getProvinceNumber() {
        return provinceNumber;
    }

    public void setProvinceNumber(String provinceNumber) {
        this.provinceNumber = provinceNumber;
    }

    public String getCityNumber() {
        return cityNumber;
    }

    public void setCityNumber(String cityNumber) {
        this.cityNumber = cityNumber;
    }

    public String getCountyNumber() {
        return countyNumber;
    }

    public void setCountyNumber(String countyNumber) {
        this.countyNumber = countyNumber;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public List<FileInfo> getFileInfos() {
        return fileInfos;
    }

    public void setFileInfos(List<FileInfo> fileInfos) {
        this.fileInfos = fileInfos;
    }
}
