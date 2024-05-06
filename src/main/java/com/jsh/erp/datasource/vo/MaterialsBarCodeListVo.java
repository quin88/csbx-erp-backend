package com.jsh.erp.datasource.vo;

public class MaterialsBarCodeListVo {

    private Long headerId;

    private String MaterialsBarCodeList;

    public Long getHeaderId() {
        return headerId;
    }

    public void setHeaderId(Long headerId) {
        this.headerId = headerId;
    }

    public String getIsMaterialsBarCodeList() {
        return this.MaterialsBarCodeList;
    }

    public void setIsMaterialsBarCodeList(String materialsBarCodeList) {
        this.MaterialsBarCodeList = materialsBarCodeList;
    }
}
