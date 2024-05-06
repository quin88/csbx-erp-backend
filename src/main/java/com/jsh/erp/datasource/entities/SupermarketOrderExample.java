package com.jsh.erp.datasource.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SupermarketOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SupermarketOrderExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOpenTimeIsNull() {
            addCriterion("open_time is null");
            return (Criteria) this;
        }

        public Criteria andOpenTimeIsNotNull() {
            addCriterion("open_time is not null");
            return (Criteria) this;
        }

        public Criteria andOpenTimeEqualTo(Date value) {
            addCriterion("open_time =", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotEqualTo(Date value) {
            addCriterion("open_time <>", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeGreaterThan(Date value) {
            addCriterion("open_time >", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("open_time >=", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeLessThan(Date value) {
            addCriterion("open_time <", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeLessThanOrEqualTo(Date value) {
            addCriterion("open_time <=", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeIn(List<Date> values) {
            addCriterion("open_time in", values, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotIn(List<Date> values) {
            addCriterion("open_time not in", values, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeBetween(Date value1, Date value2) {
            addCriterion("open_time between", value1, value2, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotBetween(Date value1, Date value2) {
            addCriterion("open_time not between", value1, value2, "openTime");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(String value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(String value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(String value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(String value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(String value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(String value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLike(String value) {
            addCriterion("number like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotLike(String value) {
            addCriterion("number not like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<String> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<String> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(String value1, String value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(String value1, String value2) {
            addCriterion("number not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNull() {
            addCriterion("category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("category like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("category not like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("category not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andNakedPriceTotalIsNull() {
            addCriterion("naked_price_total is null");
            return (Criteria) this;
        }

        public Criteria andNakedPriceTotalIsNotNull() {
            addCriterion("naked_price_total is not null");
            return (Criteria) this;
        }

        public Criteria andNakedPriceTotalEqualTo(BigDecimal value) {
            addCriterion("naked_price_total =", value, "nakedPriceTotal");
            return (Criteria) this;
        }

        public Criteria andNakedPriceTotalNotEqualTo(BigDecimal value) {
            addCriterion("naked_price_total <>", value, "nakedPriceTotal");
            return (Criteria) this;
        }

        public Criteria andNakedPriceTotalGreaterThan(BigDecimal value) {
            addCriterion("naked_price_total >", value, "nakedPriceTotal");
            return (Criteria) this;
        }

        public Criteria andNakedPriceTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("naked_price_total >=", value, "nakedPriceTotal");
            return (Criteria) this;
        }

        public Criteria andNakedPriceTotalLessThan(BigDecimal value) {
            addCriterion("naked_price_total <", value, "nakedPriceTotal");
            return (Criteria) this;
        }

        public Criteria andNakedPriceTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("naked_price_total <=", value, "nakedPriceTotal");
            return (Criteria) this;
        }

        public Criteria andNakedPriceTotalIn(List<BigDecimal> values) {
            addCriterion("naked_price_total in", values, "nakedPriceTotal");
            return (Criteria) this;
        }

        public Criteria andNakedPriceTotalNotIn(List<BigDecimal> values) {
            addCriterion("naked_price_total not in", values, "nakedPriceTotal");
            return (Criteria) this;
        }

        public Criteria andNakedPriceTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("naked_price_total between", value1, value2, "nakedPriceTotal");
            return (Criteria) this;
        }

        public Criteria andNakedPriceTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("naked_price_total not between", value1, value2, "nakedPriceTotal");
            return (Criteria) this;
        }

        public Criteria andTaxInclusiveTotalIsNull() {
            addCriterion("tax_inclusive_total is null");
            return (Criteria) this;
        }

        public Criteria andTaxInclusiveTotalIsNotNull() {
            addCriterion("tax_inclusive_total is not null");
            return (Criteria) this;
        }

        public Criteria andTaxInclusiveTotalEqualTo(BigDecimal value) {
            addCriterion("tax_inclusive_total =", value, "taxInclusiveTotal");
            return (Criteria) this;
        }

        public Criteria andTaxInclusiveTotalNotEqualTo(BigDecimal value) {
            addCriterion("tax_inclusive_total <>", value, "taxInclusiveTotal");
            return (Criteria) this;
        }

        public Criteria andTaxInclusiveTotalGreaterThan(BigDecimal value) {
            addCriterion("tax_inclusive_total >", value, "taxInclusiveTotal");
            return (Criteria) this;
        }

        public Criteria andTaxInclusiveTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_inclusive_total >=", value, "taxInclusiveTotal");
            return (Criteria) this;
        }

        public Criteria andTaxInclusiveTotalLessThan(BigDecimal value) {
            addCriterion("tax_inclusive_total <", value, "taxInclusiveTotal");
            return (Criteria) this;
        }

        public Criteria andTaxInclusiveTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_inclusive_total <=", value, "taxInclusiveTotal");
            return (Criteria) this;
        }

        public Criteria andTaxInclusiveTotalIn(List<BigDecimal> values) {
            addCriterion("tax_inclusive_total in", values, "taxInclusiveTotal");
            return (Criteria) this;
        }

        public Criteria andTaxInclusiveTotalNotIn(List<BigDecimal> values) {
            addCriterion("tax_inclusive_total not in", values, "taxInclusiveTotal");
            return (Criteria) this;
        }

        public Criteria andTaxInclusiveTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_inclusive_total between", value1, value2, "taxInclusiveTotal");
            return (Criteria) this;
        }

        public Criteria andTaxInclusiveTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_inclusive_total not between", value1, value2, "taxInclusiveTotal");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andUploadStatusIsNull() {
            addCriterion("upload_status is null");
            return (Criteria) this;
        }

        public Criteria andUploadStatusIsNotNull() {
            addCriterion("upload_status is not null");
            return (Criteria) this;
        }

        public Criteria andUploadStatusEqualTo(String value) {
            addCriterion("upload_status =", value, "uploadStatus");
            return (Criteria) this;
        }

        public Criteria andUploadStatusNotEqualTo(String value) {
            addCriterion("upload_status <>", value, "uploadStatus");
            return (Criteria) this;
        }

        public Criteria andUploadStatusGreaterThan(String value) {
            addCriterion("upload_status >", value, "uploadStatus");
            return (Criteria) this;
        }

        public Criteria andUploadStatusGreaterThanOrEqualTo(String value) {
            addCriterion("upload_status >=", value, "uploadStatus");
            return (Criteria) this;
        }

        public Criteria andUploadStatusLessThan(String value) {
            addCriterion("upload_status <", value, "uploadStatus");
            return (Criteria) this;
        }

        public Criteria andUploadStatusLessThanOrEqualTo(String value) {
            addCriterion("upload_status <=", value, "uploadStatus");
            return (Criteria) this;
        }

        public Criteria andUploadStatusLike(String value) {
            addCriterion("upload_status like", value, "uploadStatus");
            return (Criteria) this;
        }

        public Criteria andUploadStatusNotLike(String value) {
            addCriterion("upload_status not like", value, "uploadStatus");
            return (Criteria) this;
        }

        public Criteria andUploadStatusIn(List<String> values) {
            addCriterion("upload_status in", values, "uploadStatus");
            return (Criteria) this;
        }

        public Criteria andUploadStatusNotIn(List<String> values) {
            addCriterion("upload_status not in", values, "uploadStatus");
            return (Criteria) this;
        }

        public Criteria andUploadStatusBetween(String value1, String value2) {
            addCriterion("upload_status between", value1, value2, "uploadStatus");
            return (Criteria) this;
        }

        public Criteria andUploadStatusNotBetween(String value1, String value2) {
            addCriterion("upload_status not between", value1, value2, "uploadStatus");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(Long value) {
            addCriterion("creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(Long value) {
            addCriterion("creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(Long value) {
            addCriterion("creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(Long value) {
            addCriterion("creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(Long value) {
            addCriterion("creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(Long value) {
            addCriterion("creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<Long> values) {
            addCriterion("creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<Long> values) {
            addCriterion("creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(Long value1, Long value2) {
            addCriterion("creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(Long value1, Long value2) {
            addCriterion("creator not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdaterIsNull() {
            addCriterion("updater is null");
            return (Criteria) this;
        }

        public Criteria andUpdaterIsNotNull() {
            addCriterion("updater is not null");
            return (Criteria) this;
        }

        public Criteria andUpdaterEqualTo(Long value) {
            addCriterion("updater =", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterNotEqualTo(Long value) {
            addCriterion("updater <>", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterGreaterThan(Long value) {
            addCriterion("updater >", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterGreaterThanOrEqualTo(Long value) {
            addCriterion("updater >=", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterLessThan(Long value) {
            addCriterion("updater <", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterLessThanOrEqualTo(Long value) {
            addCriterion("updater <=", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterIn(List<Long> values) {
            addCriterion("updater in", values, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterNotIn(List<Long> values) {
            addCriterion("updater not in", values, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterBetween(Long value1, Long value2) {
            addCriterion("updater between", value1, value2, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterNotBetween(Long value1, Long value2) {
            addCriterion("updater not between", value1, value2, "updater");
            return (Criteria) this;
        }

        public Criteria andVerifierIsNull() {
            addCriterion("verifier is null");
            return (Criteria) this;
        }

        public Criteria andVerifierIsNotNull() {
            addCriterion("verifier is not null");
            return (Criteria) this;
        }

        public Criteria andVerifierEqualTo(Long value) {
            addCriterion("verifier =", value, "verifier");
            return (Criteria) this;
        }

        public Criteria andVerifierNotEqualTo(Long value) {
            addCriterion("verifier <>", value, "verifier");
            return (Criteria) this;
        }

        public Criteria andVerifierGreaterThan(Long value) {
            addCriterion("verifier >", value, "verifier");
            return (Criteria) this;
        }

        public Criteria andVerifierGreaterThanOrEqualTo(Long value) {
            addCriterion("verifier >=", value, "verifier");
            return (Criteria) this;
        }

        public Criteria andVerifierLessThan(Long value) {
            addCriterion("verifier <", value, "verifier");
            return (Criteria) this;
        }

        public Criteria andVerifierLessThanOrEqualTo(Long value) {
            addCriterion("verifier <=", value, "verifier");
            return (Criteria) this;
        }

        public Criteria andVerifierIn(List<Long> values) {
            addCriterion("verifier in", values, "verifier");
            return (Criteria) this;
        }

        public Criteria andVerifierNotIn(List<Long> values) {
            addCriterion("verifier not in", values, "verifier");
            return (Criteria) this;
        }

        public Criteria andVerifierBetween(Long value1, Long value2) {
            addCriterion("verifier between", value1, value2, "verifier");
            return (Criteria) this;
        }

        public Criteria andVerifierNotBetween(Long value1, Long value2) {
            addCriterion("verifier not between", value1, value2, "verifier");
            return (Criteria) this;
        }

        public Criteria andVerifierTimeIsNull() {
            addCriterion("verifier_time is null");
            return (Criteria) this;
        }

        public Criteria andVerifierTimeIsNotNull() {
            addCriterion("verifier_time is not null");
            return (Criteria) this;
        }

        public Criteria andVerifierTimeEqualTo(Date value) {
            addCriterion("verifier_time =", value, "verifierTime");
            return (Criteria) this;
        }

        public Criteria andVerifierTimeNotEqualTo(Date value) {
            addCriterion("verifier_time <>", value, "verifierTime");
            return (Criteria) this;
        }

        public Criteria andVerifierTimeGreaterThan(Date value) {
            addCriterion("verifier_time >", value, "verifierTime");
            return (Criteria) this;
        }

        public Criteria andVerifierTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("verifier_time >=", value, "verifierTime");
            return (Criteria) this;
        }

        public Criteria andVerifierTimeLessThan(Date value) {
            addCriterion("verifier_time <", value, "verifierTime");
            return (Criteria) this;
        }

        public Criteria andVerifierTimeLessThanOrEqualTo(Date value) {
            addCriterion("verifier_time <=", value, "verifierTime");
            return (Criteria) this;
        }

        public Criteria andVerifierTimeIn(List<Date> values) {
            addCriterion("verifier_time in", values, "verifierTime");
            return (Criteria) this;
        }

        public Criteria andVerifierTimeNotIn(List<Date> values) {
            addCriterion("verifier_time not in", values, "verifierTime");
            return (Criteria) this;
        }

        public Criteria andVerifierTimeBetween(Date value1, Date value2) {
            addCriterion("verifier_time between", value1, value2, "verifierTime");
            return (Criteria) this;
        }

        public Criteria andVerifierTimeNotBetween(Date value1, Date value2) {
            addCriterion("verifier_time not between", value1, value2, "verifierTime");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("comment =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("comment <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("comment >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("comment >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("comment <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("comment <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("comment like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("comment not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("comment in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("comment not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("comment between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("comment not between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNull() {
            addCriterion("delete_flag is null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNotNull() {
            addCriterion("delete_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagEqualTo(String value) {
            addCriterion("delete_flag =", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotEqualTo(String value) {
            addCriterion("delete_flag <>", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThan(String value) {
            addCriterion("delete_flag >", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThanOrEqualTo(String value) {
            addCriterion("delete_flag >=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThan(String value) {
            addCriterion("delete_flag <", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThanOrEqualTo(String value) {
            addCriterion("delete_flag <=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLike(String value) {
            addCriterion("delete_flag like", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotLike(String value) {
            addCriterion("delete_flag not like", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIn(List<String> values) {
            addCriterion("delete_flag in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotIn(List<String> values) {
            addCriterion("delete_flag not in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagBetween(String value1, String value2) {
            addCriterion("delete_flag between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotBetween(String value1, String value2) {
            addCriterion("delete_flag not between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNull() {
            addCriterion("tenant_id is null");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNotNull() {
            addCriterion("tenant_id is not null");
            return (Criteria) this;
        }

        public Criteria andTenantIdEqualTo(Long value) {
            addCriterion("tenant_id =", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotEqualTo(Long value) {
            addCriterion("tenant_id <>", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThan(Long value) {
            addCriterion("tenant_id >", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThanOrEqualTo(Long value) {
            addCriterion("tenant_id >=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThan(Long value) {
            addCriterion("tenant_id <", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThanOrEqualTo(Long value) {
            addCriterion("tenant_id <=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdIn(List<Long> values) {
            addCriterion("tenant_id in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotIn(List<Long> values) {
            addCriterion("tenant_id not in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdBetween(Long value1, Long value2) {
            addCriterion("tenant_id between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotBetween(Long value1, Long value2) {
            addCriterion("tenant_id not between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTradeTimeIsNull() {
            addCriterion("trade_time is null");
            return (Criteria) this;
        }

        public Criteria andTradeTimeIsNotNull() {
            addCriterion("trade_time is not null");
            return (Criteria) this;
        }

        public Criteria andTradeTimeEqualTo(Date value) {
            addCriterion("trade_time =", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeNotEqualTo(Date value) {
            addCriterion("trade_time <>", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeGreaterThan(Date value) {
            addCriterion("trade_time >", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("trade_time >=", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeLessThan(Date value) {
            addCriterion("trade_time <", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeLessThanOrEqualTo(Date value) {
            addCriterion("trade_time <=", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeIn(List<Date> values) {
            addCriterion("trade_time in", values, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeNotIn(List<Date> values) {
            addCriterion("trade_time not in", values, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeBetween(Date value1, Date value2) {
            addCriterion("trade_time between", value1, value2, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeNotBetween(Date value1, Date value2) {
            addCriterion("trade_time not between", value1, value2, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andServeClientIdIsNull() {
            addCriterion("serve_client_id is null");
            return (Criteria) this;
        }

        public Criteria andServeClientIdIsNotNull() {
            addCriterion("serve_client_id is not null");
            return (Criteria) this;
        }

        public Criteria andServeClientIdEqualTo(Long value) {
            addCriterion("serve_client_id =", value, "serveClientId");
            return (Criteria) this;
        }

        public Criteria andServeClientIdNotEqualTo(Long value) {
            addCriterion("serve_client_id <>", value, "serveClientId");
            return (Criteria) this;
        }

        public Criteria andServeClientIdGreaterThan(Long value) {
            addCriterion("serve_client_id >", value, "serveClientId");
            return (Criteria) this;
        }

        public Criteria andServeClientIdGreaterThanOrEqualTo(Long value) {
            addCriterion("serve_client_id >=", value, "serveClientId");
            return (Criteria) this;
        }

        public Criteria andServeClientIdLessThan(Long value) {
            addCriterion("serve_client_id <", value, "serveClientId");
            return (Criteria) this;
        }

        public Criteria andServeClientIdLessThanOrEqualTo(Long value) {
            addCriterion("serve_client_id <=", value, "serveClientId");
            return (Criteria) this;
        }

        public Criteria andServeClientIdIn(List<Long> values) {
            addCriterion("serve_client_id in", values, "serveClientId");
            return (Criteria) this;
        }

        public Criteria andServeClientIdNotIn(List<Long> values) {
            addCriterion("serve_client_id not in", values, "serveClientId");
            return (Criteria) this;
        }

        public Criteria andServeClientIdBetween(Long value1, Long value2) {
            addCriterion("serve_client_id between", value1, value2, "serveClientId");
            return (Criteria) this;
        }

        public Criteria andServeClientIdNotBetween(Long value1, Long value2) {
            addCriterion("serve_client_id not between", value1, value2, "serveClientId");
            return (Criteria) this;
        }

        public Criteria andMarketAddressIdIsNull() {
            addCriterion("market_address_id is null");
            return (Criteria) this;
        }

        public Criteria andMarketAddressIdIsNotNull() {
            addCriterion("market_address_id is not null");
            return (Criteria) this;
        }

        public Criteria andMarketAddressIdEqualTo(Long value) {
            addCriterion("market_address_id =", value, "marketAddressId");
            return (Criteria) this;
        }

        public Criteria andMarketAddressIdNotEqualTo(Long value) {
            addCriterion("market_address_id <>", value, "marketAddressId");
            return (Criteria) this;
        }

        public Criteria andMarketAddressIdGreaterThan(Long value) {
            addCriterion("market_address_id >", value, "marketAddressId");
            return (Criteria) this;
        }

        public Criteria andMarketAddressIdGreaterThanOrEqualTo(Long value) {
            addCriterion("market_address_id >=", value, "marketAddressId");
            return (Criteria) this;
        }

        public Criteria andMarketAddressIdLessThan(Long value) {
            addCriterion("market_address_id <", value, "marketAddressId");
            return (Criteria) this;
        }

        public Criteria andMarketAddressIdLessThanOrEqualTo(Long value) {
            addCriterion("market_address_id <=", value, "marketAddressId");
            return (Criteria) this;
        }

        public Criteria andMarketAddressIdIn(List<Long> values) {
            addCriterion("market_address_id in", values, "marketAddressId");
            return (Criteria) this;
        }

        public Criteria andMarketAddressIdNotIn(List<Long> values) {
            addCriterion("market_address_id not in", values, "marketAddressId");
            return (Criteria) this;
        }

        public Criteria andMarketAddressIdBetween(Long value1, Long value2) {
            addCriterion("market_address_id between", value1, value2, "marketAddressId");
            return (Criteria) this;
        }

        public Criteria andMarketAddressIdNotBetween(Long value1, Long value2) {
            addCriterion("market_address_id not between", value1, value2, "marketAddressId");
            return (Criteria) this;
        }

        public Criteria andDifferenceTotalIsNull() {
            addCriterion("difference_total is null");
            return (Criteria) this;
        }

        public Criteria andDifferenceTotalIsNotNull() {
            addCriterion("difference_total is not null");
            return (Criteria) this;
        }

        public Criteria andDifferenceTotalEqualTo(BigDecimal value) {
            addCriterion("difference_total =", value, "differenceTotal");
            return (Criteria) this;
        }

        public Criteria andDifferenceTotalNotEqualTo(BigDecimal value) {
            addCriterion("difference_total <>", value, "differenceTotal");
            return (Criteria) this;
        }

        public Criteria andDifferenceTotalGreaterThan(BigDecimal value) {
            addCriterion("difference_total >", value, "differenceTotal");
            return (Criteria) this;
        }

        public Criteria andDifferenceTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("difference_total >=", value, "differenceTotal");
            return (Criteria) this;
        }

        public Criteria andDifferenceTotalLessThan(BigDecimal value) {
            addCriterion("difference_total <", value, "differenceTotal");
            return (Criteria) this;
        }

        public Criteria andDifferenceTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("difference_total <=", value, "differenceTotal");
            return (Criteria) this;
        }

        public Criteria andDifferenceTotalIn(List<BigDecimal> values) {
            addCriterion("difference_total in", values, "differenceTotal");
            return (Criteria) this;
        }

        public Criteria andDifferenceTotalNotIn(List<BigDecimal> values) {
            addCriterion("difference_total not in", values, "differenceTotal");
            return (Criteria) this;
        }

        public Criteria andDifferenceTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("difference_total between", value1, value2, "differenceTotal");
            return (Criteria) this;
        }

        public Criteria andDifferenceTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("difference_total not between", value1, value2, "differenceTotal");
            return (Criteria) this;
        }

        public Criteria andLinkIdIsNull() {
            addCriterion("link_id is null");
            return (Criteria) this;
        }

        public Criteria andLinkIdIsNotNull() {
            addCriterion("link_id is not null");
            return (Criteria) this;
        }

        public Criteria andLinkIdEqualTo(Long value) {
            addCriterion("link_id =", value, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdNotEqualTo(Long value) {
            addCriterion("link_id <>", value, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdGreaterThan(Long value) {
            addCriterion("link_id >", value, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdGreaterThanOrEqualTo(Long value) {
            addCriterion("link_id >=", value, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdLessThan(Long value) {
            addCriterion("link_id <", value, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdLessThanOrEqualTo(Long value) {
            addCriterion("link_id <=", value, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdIn(List<Long> values) {
            addCriterion("link_id in", values, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdNotIn(List<Long> values) {
            addCriterion("link_id not in", values, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdBetween(Long value1, Long value2) {
            addCriterion("link_id between", value1, value2, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdNotBetween(Long value1, Long value2) {
            addCriterion("link_id not between", value1, value2, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkNumberIsNull() {
            addCriterion("link_number is null");
            return (Criteria) this;
        }

        public Criteria andLinkNumberIsNotNull() {
            addCriterion("link_number is not null");
            return (Criteria) this;
        }

        public Criteria andLinkNumberEqualTo(String value) {
            addCriterion("link_number =", value, "linkNumber");
            return (Criteria) this;
        }

        public Criteria andLinkNumberNotEqualTo(String value) {
            addCriterion("link_number <>", value, "linkNumber");
            return (Criteria) this;
        }

        public Criteria andLinkNumberGreaterThan(String value) {
            addCriterion("link_number >", value, "linkNumber");
            return (Criteria) this;
        }

        public Criteria andLinkNumberGreaterThanOrEqualTo(String value) {
            addCriterion("link_number >=", value, "linkNumber");
            return (Criteria) this;
        }

        public Criteria andLinkNumberLessThan(String value) {
            addCriterion("link_number <", value, "linkNumber");
            return (Criteria) this;
        }

        public Criteria andLinkNumberLessThanOrEqualTo(String value) {
            addCriterion("link_number <=", value, "linkNumber");
            return (Criteria) this;
        }

        public Criteria andLinkNumberLike(String value) {
            addCriterion("link_number like", value, "linkNumber");
            return (Criteria) this;
        }

        public Criteria andLinkNumberNotLike(String value) {
            addCriterion("link_number not like", value, "linkNumber");
            return (Criteria) this;
        }

        public Criteria andLinkNumberIn(List<String> values) {
            addCriterion("link_number in", values, "linkNumber");
            return (Criteria) this;
        }

        public Criteria andLinkNumberNotIn(List<String> values) {
            addCriterion("link_number not in", values, "linkNumber");
            return (Criteria) this;
        }

        public Criteria andLinkNumberBetween(String value1, String value2) {
            addCriterion("link_number between", value1, value2, "linkNumber");
            return (Criteria) this;
        }

        public Criteria andLinkNumberNotBetween(String value1, String value2) {
            addCriterion("link_number not between", value1, value2, "linkNumber");
            return (Criteria) this;
        }

        public Criteria andInitialDifferenceIsNull() {
            addCriterion("initial_difference is null");
            return (Criteria) this;
        }

        public Criteria andInitialDifferenceIsNotNull() {
            addCriterion("initial_difference is not null");
            return (Criteria) this;
        }

        public Criteria andInitialDifferenceEqualTo(BigDecimal value) {
            addCriterion("initial_difference =", value, "initialDifference");
            return (Criteria) this;
        }

        public Criteria andInitialDifferenceNotEqualTo(BigDecimal value) {
            addCriterion("initial_difference <>", value, "initialDifference");
            return (Criteria) this;
        }

        public Criteria andInitialDifferenceGreaterThan(BigDecimal value) {
            addCriterion("initial_difference >", value, "initialDifference");
            return (Criteria) this;
        }

        public Criteria andInitialDifferenceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("initial_difference >=", value, "initialDifference");
            return (Criteria) this;
        }

        public Criteria andInitialDifferenceLessThan(BigDecimal value) {
            addCriterion("initial_difference <", value, "initialDifference");
            return (Criteria) this;
        }

        public Criteria andInitialDifferenceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("initial_difference <=", value, "initialDifference");
            return (Criteria) this;
        }

        public Criteria andInitialDifferenceIn(List<BigDecimal> values) {
            addCriterion("initial_difference in", values, "initialDifference");
            return (Criteria) this;
        }

        public Criteria andInitialDifferenceNotIn(List<BigDecimal> values) {
            addCriterion("initial_difference not in", values, "initialDifference");
            return (Criteria) this;
        }

        public Criteria andInitialDifferenceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("initial_difference between", value1, value2, "initialDifference");
            return (Criteria) this;
        }

        public Criteria andInitialDifferenceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("initial_difference not between", value1, value2, "initialDifference");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}