package com.jsh.erp.datasource.vo;

import com.jsh.erp.datasource.entities.OrderDetail;

import java.io.Serializable;

public class OrderDetailVo extends OrderDetail implements Serializable {

    private String number;

    private String supplier;

    private String material;

    private String accountNumber;

    private String supplyingZeroName;

    private String supplyingZeroNumber;

    private static final long serialVersionUID = 1L;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getSupplyingZeroName() {
        return supplyingZeroName;
    }

    public void setSupplyingZeroName(String supplyingZeroName) {
        this.supplyingZeroName = supplyingZeroName;
    }

    public String getSupplyingZeroNumber() {
        return supplyingZeroNumber;
    }

    public void setSupplyingZeroNumber(String supplyingZeroNumber) {
        this.supplyingZeroNumber = supplyingZeroNumber;
    }
}