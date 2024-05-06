package com.jsh.erp.datasource.entities;

import com.jsh.erp.datasource.vo.PriceDetailsVo;

import java.util.List;

public class DepotHeadAndPriceDetailsBody extends DepotHeadVo4Body {

    private PriceDetailsVo priceDetailsVo;

    private List<SupplierServeProject> supplierServeProjects;

    private String originType;

    public PriceDetailsVo getPriceDetailsVo() {
        return priceDetailsVo;
    }

    public void setPriceDetailsVo(PriceDetailsVo priceDetailsVo) {
        this.priceDetailsVo = priceDetailsVo;
    }

    public List<SupplierServeProject> getSupplierServeProjects() {
        return supplierServeProjects;
    }

    public void setSupplierServeProjects(List<SupplierServeProject> supplierServeProjects) {
        this.supplierServeProjects = supplierServeProjects;
    }

    public String getOriginType() {
        return originType;
    }

    public void setOriginType(String originType) {
        this.originType = originType;
    }

}