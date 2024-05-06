package com.jsh.erp.datasource.vo;

import com.jsh.erp.datasource.entities.PriceDetails;
import com.jsh.erp.datasource.entities.PriceReceipts;

import java.util.List;

public class PriceDetailsVo {

    private List<PriceDetails> priceDetails;

    private PriceReceipts priceReceipts;

    public List<PriceDetails> getPriceDetails() {
        return priceDetails;
    }

    public void setPriceDetails(List<PriceDetails> priceDetails) {
        this.priceDetails = priceDetails;
    }

    public PriceReceipts getPriceReceipts() {
        return priceReceipts;
    }

    public void setPriceReceipts(PriceReceipts priceReceipts) {
        this.priceReceipts = priceReceipts;
    }
}
