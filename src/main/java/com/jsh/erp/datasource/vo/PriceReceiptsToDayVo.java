package com.jsh.erp.datasource.vo;

import com.jsh.erp.datasource.entities.DepotItemVo4WithInfoEx;
import com.jsh.erp.datasource.entities.PriceDetails;
import com.jsh.erp.datasource.entities.ShippingPrice;

import java.math.BigDecimal;
import java.util.List;

public class PriceReceiptsToDayVo {

    private BigDecimal totalPrice;

    private List<PriceDetails> priceDetails;

    private List<DepotItemVo4WithInfoEx> depotItemVo4WithInfoExes;

    private List<ShippingPrice> shippingPrices;

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<PriceDetails> getPriceDetails() {
        return priceDetails;
    }

    public void setPriceDetails(List<PriceDetails> priceDetails) {
        this.priceDetails = priceDetails;
    }

    public List<DepotItemVo4WithInfoEx> getDepotItemVo4WithInfoExes() {
        return depotItemVo4WithInfoExes;
    }

    public void setDepotItemVo4WithInfoExes(List<DepotItemVo4WithInfoEx> depotItemVo4WithInfoExes) {
        this.depotItemVo4WithInfoExes = depotItemVo4WithInfoExes;
    }

    public List<ShippingPrice> getShippingPrices() {
        return shippingPrices;
    }

    public void setShippingPrices(List<ShippingPrice> shippingPrices) {
        this.shippingPrices = shippingPrices;
    }
}
