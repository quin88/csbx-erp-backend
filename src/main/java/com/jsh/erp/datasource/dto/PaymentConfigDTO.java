package com.jsh.erp.datasource.dto;

import com.jsh.erp.datasource.entities.PaymentConfig;

import java.util.List;

public class PaymentConfigDTO {

    private List<PaymentConfig> paymentConfigs;

    private String deleteId;

    public List<PaymentConfig> getPaymentConfigs() {
        return paymentConfigs;
    }

    public void setPaymentConfigs(List<PaymentConfig> paymentConfigs) {
        this.paymentConfigs = paymentConfigs;
    }

    public String getDeleteId() {
        return deleteId;
    }

    public void setDeleteId(String deleteId) {
        this.deleteId = deleteId;
    }
}