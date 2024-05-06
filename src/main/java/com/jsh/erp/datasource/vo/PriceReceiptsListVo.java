package com.jsh.erp.datasource.vo;

import com.jsh.erp.datasource.entities.DepotItemVo4WithInfoEx;
import com.jsh.erp.datasource.entities.PaymentRecords;
import com.jsh.erp.datasource.entities.PriceDetails;
import com.jsh.erp.datasource.entities.PriceReceipts;

import java.util.List;

public class PriceReceiptsListVo {

   private List<PaymentRecords> paymentRecords;

   private List<PriceDetails>  priceDetails;

   private List<PriceReceipts> priceReceipts;

   private List<DepotItemVo4WithInfoEx> depotItemVo4WithInfoExes;

   public List<PaymentRecords> getPaymentRecords() {
      return paymentRecords;
   }

   public void setPaymentRecords(List<PaymentRecords> paymentRecords) {
      this.paymentRecords = paymentRecords;
   }

   public List<PriceDetails> getPriceDetails() {
      return priceDetails;
   }

   public void setPriceDetails(List<PriceDetails> priceDetails) {
      this.priceDetails = priceDetails;
   }

   public List<PriceReceipts> getPriceReceipts() {
      return priceReceipts;
   }

   public void setPriceReceipts(List<PriceReceipts> priceReceipts) {
      this.priceReceipts = priceReceipts;
   }

   public List<DepotItemVo4WithInfoEx> getDepotItemVo4WithInfoExes() {
      return depotItemVo4WithInfoExes;
   }

   public void setDepotItemVo4WithInfoExes(List<DepotItemVo4WithInfoEx> depotItemVo4WithInfoExes) {
      this.depotItemVo4WithInfoExes = depotItemVo4WithInfoExes;
   }
}
