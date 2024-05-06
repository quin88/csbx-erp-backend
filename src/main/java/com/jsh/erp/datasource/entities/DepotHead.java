package com.jsh.erp.datasource.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DepotHead implements Serializable {
    private Long id;

    private String type;

    private String subType;

    private String defaultNumber;

    private String number;

    private Date createTime;

    private Date operTime;

    private Long organId;

    private Long creator;

    private Long accountId;

    private BigDecimal changeAmount;

    private BigDecimal backAmount;

    private BigDecimal totalPrice;

    private String payType;

    private String billType;

    private String remark;

    private String fileName;

    private String salesMan;

    private String accountIdList;

    private String accountMoneyList;

    private BigDecimal discount;

    private BigDecimal discountMoney;

    private BigDecimal discountLastMoney;

    private BigDecimal otherMoney;

    private BigDecimal deposit;

    private String status;

    private String purchaseStatus;

    private String source;

    private String linkNumber;

    private Long tenantId;

    private String deleteFlag;

    private Long supplierId;

    private String simulatedAnnealing;

    private String period;

    private BigDecimal otherCostTotal;

    private String productQuality;

    private String customsDeclarationDocument;

    private String quarantineCertificate;

    private String license;

    private String detailedGoodsList;

    private String deliveryOrder;

    private String receiptsNumber;

    private String comment;

    private Date expirationOperationTime;

    private String client;

    private Long verifier;

    private String originType;

    private Date verifierTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType == null ? null : subType.trim();
    }

    public String getDefaultNumber() {
        return defaultNumber;
    }

    public void setDefaultNumber(String defaultNumber) {
        this.defaultNumber = defaultNumber == null ? null : defaultNumber.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getOperTime() {
        return operTime;
    }

    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }

    public Long getOrganId() {
        return organId;
    }

    public void setOrganId(Long organId) {
        this.organId = organId;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getChangeAmount() {
        return changeAmount;
    }

    public void setChangeAmount(BigDecimal changeAmount) {
        this.changeAmount = changeAmount;
    }

    public BigDecimal getBackAmount() {
        return backAmount;
    }

    public void setBackAmount(BigDecimal backAmount) {
        this.backAmount = backAmount;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType == null ? null : billType.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getSalesMan() {
        return salesMan;
    }

    public void setSalesMan(String salesMan) {
        this.salesMan = salesMan == null ? null : salesMan.trim();
    }

    public String getAccountIdList() {
        return accountIdList;
    }

    public void setAccountIdList(String accountIdList) {
        this.accountIdList = accountIdList == null ? null : accountIdList.trim();
    }

    public String getAccountMoneyList() {
        return accountMoneyList;
    }

    public void setAccountMoneyList(String accountMoneyList) {
        this.accountMoneyList = accountMoneyList == null ? null : accountMoneyList.trim();
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getDiscountMoney() {
        return discountMoney;
    }

    public void setDiscountMoney(BigDecimal discountMoney) {
        this.discountMoney = discountMoney;
    }

    public BigDecimal getDiscountLastMoney() {
        return discountLastMoney;
    }

    public void setDiscountLastMoney(BigDecimal discountLastMoney) {
        this.discountLastMoney = discountLastMoney;
    }

    public BigDecimal getOtherMoney() {
        return otherMoney;
    }

    public void setOtherMoney(BigDecimal otherMoney) {
        this.otherMoney = otherMoney;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getPurchaseStatus() {
        return purchaseStatus;
    }

    public void setPurchaseStatus(String purchaseStatus) {
        this.purchaseStatus = purchaseStatus == null ? null : purchaseStatus.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getLinkNumber() {
        return linkNumber;
    }

    public void setLinkNumber(String linkNumber) {
        this.linkNumber = linkNumber == null ? null : linkNumber.trim();
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getSimulatedAnnealing() {
        return simulatedAnnealing;
    }

    public void setSimulatedAnnealing(String simulatedAnnealing) {
        this.simulatedAnnealing = simulatedAnnealing == null ? null : simulatedAnnealing.trim();
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period == null ? null : period.trim();
    }

    public BigDecimal getOtherCostTotal() {
        return otherCostTotal;
    }

    public void setOtherCostTotal(BigDecimal otherCostTotal) {
        this.otherCostTotal = otherCostTotal;
    }

    public String getProductQuality() {
        return productQuality;
    }

    public void setProductQuality(String productQuality) {
        this.productQuality = productQuality == null ? null : productQuality.trim();
    }

    public String getCustomsDeclarationDocument() {
        return customsDeclarationDocument;
    }

    public void setCustomsDeclarationDocument(String customsDeclarationDocument) {
        this.customsDeclarationDocument = customsDeclarationDocument == null ? null : customsDeclarationDocument.trim();
    }

    public String getQuarantineCertificate() {
        return quarantineCertificate;
    }

    public void setQuarantineCertificate(String quarantineCertificate) {
        this.quarantineCertificate = quarantineCertificate == null ? null : quarantineCertificate.trim();
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license == null ? null : license.trim();
    }

    public String getDetailedGoodsList() {
        return detailedGoodsList;
    }

    public void setDetailedGoodsList(String detailedGoodsList) {
        this.detailedGoodsList = detailedGoodsList == null ? null : detailedGoodsList.trim();
    }

    public String getDeliveryOrder() {
        return deliveryOrder;
    }

    public void setDeliveryOrder(String deliveryOrder) {
        this.deliveryOrder = deliveryOrder == null ? null : deliveryOrder.trim();
    }

    public String getReceiptsNumber() {
        return receiptsNumber;
    }

    public void setReceiptsNumber(String receiptsNumber) {
        this.receiptsNumber = receiptsNumber == null ? null : receiptsNumber.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Date getExpirationOperationTime() {
        return expirationOperationTime;
    }

    public void setExpirationOperationTime(Date expirationOperationTime) {
        this.expirationOperationTime = expirationOperationTime;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client == null ? null : client.trim();
    }

    public Long getVerifier() {
        return verifier;
    }

    public void setVerifier(Long verifier) {
        this.verifier = verifier;
    }

    public String getOriginType() {
        return originType;
    }

    public void setOriginType(String originType) {
        this.originType = originType == null ? null : originType.trim();
    }

    public Date getVerifierTime() {
        return verifierTime;
    }

    public void setVerifierTime(Date verifierTime) {
        this.verifierTime = verifierTime;
    }
}