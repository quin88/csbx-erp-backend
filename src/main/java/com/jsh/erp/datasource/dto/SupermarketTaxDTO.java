package com.jsh.erp.datasource.dto;

import com.jsh.erp.datasource.entities.SupermarketTax;

import java.util.List;

public class SupermarketTaxDTO {

    private List<SupermarketTax> supermarketTax;

    private String deleteId;

    public List<SupermarketTax> getSupermarketTax() {
        return supermarketTax;
    }

    public void setSupermarketTax(List<SupermarketTax> supermarketTax) {
        this.supermarketTax = supermarketTax;
    }

    public String getDeleteId() {
        return deleteId;
    }

    public void setDeleteId(String deleteId) {
        this.deleteId = deleteId;
    }
}