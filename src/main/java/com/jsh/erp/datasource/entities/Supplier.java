package com.jsh.erp.datasource.entities;

import java.io.Serializable;
import java.math.BigDecimal;

public class Supplier implements Serializable {
    private Long id;

    private String supplier;

    private String contacts;

    private String phoneNum;

    private String email;

    private String description;

    private Byte isystem;

    private String type;

    private Boolean enabled;

    private BigDecimal advanceIn;

    private BigDecimal beginNeedGet;

    private BigDecimal beginNeedPay;

    private BigDecimal allNeedGet;

    private BigDecimal allNeedPay;

    private String fax;

    private String telephone;

    private String address;

    private String taxNum;

    private String bankName;

    private String accountNumber;

    private BigDecimal taxRate;

    private String sort;

    private Long tenantId;

    private String deleteFlag;

    private String companyType;

    private String companySize;

    private String partnershipDetail;

    private String mainProduct;

    private String estimateIncome;

    private Double deposit;

    private String checkStatus;

    private String companyCert;

    private String ownerId;

    private String comment;

    private Long verifier;

    private String originType;

    private String imagePath;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier == null ? null : supplier.trim();
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum == null ? null : phoneNum.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Byte getIsystem() {
        return isystem;
    }

    public void setIsystem(Byte isystem) {
        this.isystem = isystem;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public BigDecimal getAdvanceIn() {
        return advanceIn;
    }

    public void setAdvanceIn(BigDecimal advanceIn) {
        this.advanceIn = advanceIn;
    }

    public BigDecimal getBeginNeedGet() {
        return beginNeedGet;
    }

    public void setBeginNeedGet(BigDecimal beginNeedGet) {
        this.beginNeedGet = beginNeedGet;
    }

    public BigDecimal getBeginNeedPay() {
        return beginNeedPay;
    }

    public void setBeginNeedPay(BigDecimal beginNeedPay) {
        this.beginNeedPay = beginNeedPay;
    }

    public BigDecimal getAllNeedGet() {
        return allNeedGet;
    }

    public void setAllNeedGet(BigDecimal allNeedGet) {
        this.allNeedGet = allNeedGet;
    }

    public BigDecimal getAllNeedPay() {
        return allNeedPay;
    }

    public void setAllNeedPay(BigDecimal allNeedPay) {
        this.allNeedPay = allNeedPay;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getTaxNum() {
        return taxNum;
    }

    public void setTaxNum(String taxNum) {
        this.taxNum = taxNum == null ? null : taxNum.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber == null ? null : accountNumber.trim();
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
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

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType == null ? null : companyType.trim();
    }

    public String getCompanySize() {
        return companySize;
    }

    public void setCompanySize(String companySize) {
        this.companySize = companySize == null ? null : companySize.trim();
    }

    public String getPartnershipDetail() {
        return partnershipDetail;
    }

    public void setPartnershipDetail(String partnershipDetail) {
        this.partnershipDetail = partnershipDetail == null ? null : partnershipDetail.trim();
    }

    public String getMainProduct() {
        return mainProduct;
    }

    public void setMainProduct(String mainProduct) {
        this.mainProduct = mainProduct == null ? null : mainProduct.trim();
    }

    public String getEstimateIncome() {
        return estimateIncome;
    }

    public void setEstimateIncome(String estimateIncome) {
        this.estimateIncome = estimateIncome == null ? null : estimateIncome.trim();
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus == null ? null : checkStatus.trim();
    }

    public String getCompanyCert() {
        return companyCert;
    }

    public void setCompanyCert(String companyCert) {
        this.companyCert = companyCert == null ? null : companyCert.trim();
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId == null ? null : ownerId.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath == null ? null : imagePath.trim();
    }
}