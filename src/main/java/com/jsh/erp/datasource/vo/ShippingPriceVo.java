package com.jsh.erp.datasource.vo;

import com.jsh.erp.datasource.entities.PriceReceipts;
import com.jsh.erp.datasource.entities.ShippingPrice;

import java.util.List;

public class ShippingPriceVo {

    private List<ShippingPrice> shippingPrices;

    private PriceReceipts priceReceipts;

    public List<ShippingPrice> getShippingPrices() {
        return shippingPrices;
    }

    public void setShippingPrices(List<ShippingPrice> shippingPrices) {
        this.shippingPrices = shippingPrices;
    }

    public PriceReceipts getPriceReceipts() {
        return priceReceipts;
    }

    public void setPriceReceipts(PriceReceipts priceReceipts) {
        this.priceReceipts = priceReceipts;
    }
}
