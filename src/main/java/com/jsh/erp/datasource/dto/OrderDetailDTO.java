package com.jsh.erp.datasource.dto;

import java.math.BigDecimal;

public class OrderDetailDTO {

    private Long id;

    private BigDecimal difference;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getDifference() {
        return difference;
    }

    public void setDifference(BigDecimal difference) {
        this.difference = difference;
    }
}