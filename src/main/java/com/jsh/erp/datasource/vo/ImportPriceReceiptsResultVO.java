package com.jsh.erp.datasource.vo;

import java.math.BigDecimal;
import java.util.List;

public class ImportPriceReceiptsResultVO {

    private List<ImportPriceReceiptsVo4List> resultList;//费用流水

    private BigDecimal totalAmount;//余额总计

    private BigDecimal totalCost;//消费总计

    private List<ImportPriceReceiptsVo4List> coldStorageCosts;//冷库费用，供应商费用管理-副表数据

    private BigDecimal coldTotalAmount;//冷库费用，供应商费用管理-副表总计

    public ImportPriceReceiptsResultVO() {
    }

    public ImportPriceReceiptsResultVO(List<ImportPriceReceiptsVo4List> resultList, BigDecimal totalAmount) {
        this.resultList = resultList;
        this.totalAmount = totalAmount;
    }

    public List<ImportPriceReceiptsVo4List> getResultList() {
        return resultList;
    }

    public void setResultList(List<ImportPriceReceiptsVo4List> resultList) {
        this.resultList = resultList;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public List<ImportPriceReceiptsVo4List> getColdStorageCosts() {
        return coldStorageCosts;
    }

    public void setColdStorageCosts(List<ImportPriceReceiptsVo4List> coldStorageCosts) {
        this.coldStorageCosts = coldStorageCosts;
    }

    public BigDecimal getColdTotalAmount() {
        return coldTotalAmount;
    }

    public void setColdTotalAmount(BigDecimal coldTotalAmount) {
        this.coldTotalAmount = coldTotalAmount;
    }
}