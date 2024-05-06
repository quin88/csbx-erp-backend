package com.jsh.erp.datasource.vo;

import java.util.List;

public class PriceReceiptsToDayVoList {

    private String type;

    private List<PriceReceiptsToDayVo> priceDetails;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<PriceReceiptsToDayVo> getPriceDetails() {
        return priceDetails;
    }

    public void setPriceDetails(List<PriceReceiptsToDayVo> priceDetails) {
        this.priceDetails = priceDetails;
    }
}
