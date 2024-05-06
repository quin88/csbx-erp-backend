package com.jsh.erp.datasource.dto;

import com.jsh.erp.datasource.entities.OrderDocument;

import java.util.List;

public class OrderDocumentDTO {
    private List<OrderDocument> orderDocuments;
    private Long orderId;

    public List<OrderDocument> getOrderDocuments() {
        return orderDocuments;
    }

    public void setOrderDocuments(List<OrderDocument> orderDocuments) {
        this.orderDocuments = orderDocuments;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
