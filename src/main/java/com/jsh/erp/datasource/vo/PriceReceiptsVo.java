package com.jsh.erp.datasource.vo;

import com.jsh.erp.datasource.entities.PriceReceipts;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class PriceReceiptsVo extends PriceReceipts implements Serializable {

    private String userName;

    private List<String> priceTypes;

    private String organName;

    private BigDecimal priceNumber;

    private static final long serialVersionUID = 1L;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getPriceTypes() {
        return priceTypes;
    }

    public void setPriceTypes(List<String> priceTypes) {
        this.priceTypes = priceTypes;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public BigDecimal getPriceNumber() {
        return priceNumber;
    }

    public void setPriceNumber(BigDecimal priceNumber) {
        this.priceNumber = priceNumber;
    }
}