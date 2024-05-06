package com.jsh.erp.datasource.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PriceDetailsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PriceDetailsExample() {
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

        public Criteria andSupplierIdIsNull() {
            addCriterion("supplier_id is null");
            return (Criteria) this;
        }

        public Criteria andSupplierIdIsNotNull() {
            addCriterion("supplier_id is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierIdEqualTo(Long value) {
            addCriterion("supplier_id =", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotEqualTo(Long value) {
            addCriterion("supplier_id <>", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdGreaterThan(Long value) {
            addCriterion("supplier_id >", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdGreaterThanOrEqualTo(Long value) {
            addCriterion("supplier_id >=", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdLessThan(Long value) {
            addCriterion("supplier_id <", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdLessThanOrEqualTo(Long value) {
            addCriterion("supplier_id <=", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdIn(List<Long> values) {
            addCriterion("supplier_id in", values, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotIn(List<Long> values) {
            addCriterion("supplier_id not in", values, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdBetween(Long value1, Long value2) {
            addCriterion("supplier_id between", value1, value2, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotBetween(Long value1, Long value2) {
            addCriterion("supplier_id not between", value1, value2, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIsNull() {
            addCriterion("supplier is null");
            return (Criteria) this;
        }

        public Criteria andSupplierIsNotNull() {
            addCriterion("supplier is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierEqualTo(String value) {
            addCriterion("supplier =", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotEqualTo(String value) {
            addCriterion("supplier <>", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierGreaterThan(String value) {
            addCriterion("supplier >", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierGreaterThanOrEqualTo(String value) {
            addCriterion("supplier >=", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLessThan(String value) {
            addCriterion("supplier <", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLessThanOrEqualTo(String value) {
            addCriterion("supplier <=", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLike(String value) {
            addCriterion("supplier like", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotLike(String value) {
            addCriterion("supplier not like", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierIn(List<String> values) {
            addCriterion("supplier in", values, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotIn(List<String> values) {
            addCriterion("supplier not in", values, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierBetween(String value1, String value2) {
            addCriterion("supplier between", value1, value2, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotBetween(String value1, String value2) {
            addCriterion("supplier not between", value1, value2, "supplier");
            return (Criteria) this;
        }

        public Criteria andReceiptsNumberIsNull() {
            addCriterion("receipts_number is null");
            return (Criteria) this;
        }

        public Criteria andReceiptsNumberIsNotNull() {
            addCriterion("receipts_number is not null");
            return (Criteria) this;
        }

        public Criteria andReceiptsNumberEqualTo(String value) {
            addCriterion("receipts_number =", value, "receiptsNumber");
            return (Criteria) this;
        }

        public Criteria andReceiptsNumberNotEqualTo(String value) {
            addCriterion("receipts_number <>", value, "receiptsNumber");
            return (Criteria) this;
        }

        public Criteria andReceiptsNumberGreaterThan(String value) {
            addCriterion("receipts_number >", value, "receiptsNumber");
            return (Criteria) this;
        }

        public Criteria andReceiptsNumberGreaterThanOrEqualTo(String value) {
            addCriterion("receipts_number >=", value, "receiptsNumber");
            return (Criteria) this;
        }

        public Criteria andReceiptsNumberLessThan(String value) {
            addCriterion("receipts_number <", value, "receiptsNumber");
            return (Criteria) this;
        }

        public Criteria andReceiptsNumberLessThanOrEqualTo(String value) {
            addCriterion("receipts_number <=", value, "receiptsNumber");
            return (Criteria) this;
        }

        public Criteria andReceiptsNumberLike(String value) {
            addCriterion("receipts_number like", value, "receiptsNumber");
            return (Criteria) this;
        }

        public Criteria andReceiptsNumberNotLike(String value) {
            addCriterion("receipts_number not like", value, "receiptsNumber");
            return (Criteria) this;
        }

        public Criteria andReceiptsNumberIn(List<String> values) {
            addCriterion("receipts_number in", values, "receiptsNumber");
            return (Criteria) this;
        }

        public Criteria andReceiptsNumberNotIn(List<String> values) {
            addCriterion("receipts_number not in", values, "receiptsNumber");
            return (Criteria) this;
        }

        public Criteria andReceiptsNumberBetween(String value1, String value2) {
            addCriterion("receipts_number between", value1, value2, "receiptsNumber");
            return (Criteria) this;
        }

        public Criteria andReceiptsNumberNotBetween(String value1, String value2) {
            addCriterion("receipts_number not between", value1, value2, "receiptsNumber");
            return (Criteria) this;
        }

        public Criteria andBringInIsNull() {
            addCriterion("bring_in is null");
            return (Criteria) this;
        }

        public Criteria andBringInIsNotNull() {
            addCriterion("bring_in is not null");
            return (Criteria) this;
        }

        public Criteria andBringInEqualTo(String value) {
            addCriterion("bring_in =", value, "bringIn");
            return (Criteria) this;
        }

        public Criteria andBringInNotEqualTo(String value) {
            addCriterion("bring_in <>", value, "bringIn");
            return (Criteria) this;
        }

        public Criteria andBringInGreaterThan(String value) {
            addCriterion("bring_in >", value, "bringIn");
            return (Criteria) this;
        }

        public Criteria andBringInGreaterThanOrEqualTo(String value) {
            addCriterion("bring_in >=", value, "bringIn");
            return (Criteria) this;
        }

        public Criteria andBringInLessThan(String value) {
            addCriterion("bring_in <", value, "bringIn");
            return (Criteria) this;
        }

        public Criteria andBringInLessThanOrEqualTo(String value) {
            addCriterion("bring_in <=", value, "bringIn");
            return (Criteria) this;
        }

        public Criteria andBringInLike(String value) {
            addCriterion("bring_in like", value, "bringIn");
            return (Criteria) this;
        }

        public Criteria andBringInNotLike(String value) {
            addCriterion("bring_in not like", value, "bringIn");
            return (Criteria) this;
        }

        public Criteria andBringInIn(List<String> values) {
            addCriterion("bring_in in", values, "bringIn");
            return (Criteria) this;
        }

        public Criteria andBringInNotIn(List<String> values) {
            addCriterion("bring_in not in", values, "bringIn");
            return (Criteria) this;
        }

        public Criteria andBringInBetween(String value1, String value2) {
            addCriterion("bring_in between", value1, value2, "bringIn");
            return (Criteria) this;
        }

        public Criteria andBringInNotBetween(String value1, String value2) {
            addCriterion("bring_in not between", value1, value2, "bringIn");
            return (Criteria) this;
        }

        public Criteria andOtherPriceTypeIsNull() {
            addCriterion("other_price_type is null");
            return (Criteria) this;
        }

        public Criteria andOtherPriceTypeIsNotNull() {
            addCriterion("other_price_type is not null");
            return (Criteria) this;
        }

        public Criteria andOtherPriceTypeEqualTo(String value) {
            addCriterion("other_price_type =", value, "otherPriceType");
            return (Criteria) this;
        }

        public Criteria andOtherPriceTypeNotEqualTo(String value) {
            addCriterion("other_price_type <>", value, "otherPriceType");
            return (Criteria) this;
        }

        public Criteria andOtherPriceTypeGreaterThan(String value) {
            addCriterion("other_price_type >", value, "otherPriceType");
            return (Criteria) this;
        }

        public Criteria andOtherPriceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("other_price_type >=", value, "otherPriceType");
            return (Criteria) this;
        }

        public Criteria andOtherPriceTypeLessThan(String value) {
            addCriterion("other_price_type <", value, "otherPriceType");
            return (Criteria) this;
        }

        public Criteria andOtherPriceTypeLessThanOrEqualTo(String value) {
            addCriterion("other_price_type <=", value, "otherPriceType");
            return (Criteria) this;
        }

        public Criteria andOtherPriceTypeLike(String value) {
            addCriterion("other_price_type like", value, "otherPriceType");
            return (Criteria) this;
        }

        public Criteria andOtherPriceTypeNotLike(String value) {
            addCriterion("other_price_type not like", value, "otherPriceType");
            return (Criteria) this;
        }

        public Criteria andOtherPriceTypeIn(List<String> values) {
            addCriterion("other_price_type in", values, "otherPriceType");
            return (Criteria) this;
        }

        public Criteria andOtherPriceTypeNotIn(List<String> values) {
            addCriterion("other_price_type not in", values, "otherPriceType");
            return (Criteria) this;
        }

        public Criteria andOtherPriceTypeBetween(String value1, String value2) {
            addCriterion("other_price_type between", value1, value2, "otherPriceType");
            return (Criteria) this;
        }

        public Criteria andOtherPriceTypeNotBetween(String value1, String value2) {
            addCriterion("other_price_type not between", value1, value2, "otherPriceType");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andSubtotalIsNull() {
            addCriterion("subtotal is null");
            return (Criteria) this;
        }

        public Criteria andSubtotalIsNotNull() {
            addCriterion("subtotal is not null");
            return (Criteria) this;
        }

        public Criteria andSubtotalEqualTo(BigDecimal value) {
            addCriterion("subtotal =", value, "subtotal");
            return (Criteria) this;
        }

        public Criteria andSubtotalNotEqualTo(BigDecimal value) {
            addCriterion("subtotal <>", value, "subtotal");
            return (Criteria) this;
        }

        public Criteria andSubtotalGreaterThan(BigDecimal value) {
            addCriterion("subtotal >", value, "subtotal");
            return (Criteria) this;
        }

        public Criteria andSubtotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("subtotal >=", value, "subtotal");
            return (Criteria) this;
        }

        public Criteria andSubtotalLessThan(BigDecimal value) {
            addCriterion("subtotal <", value, "subtotal");
            return (Criteria) this;
        }

        public Criteria andSubtotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("subtotal <=", value, "subtotal");
            return (Criteria) this;
        }

        public Criteria andSubtotalIn(List<BigDecimal> values) {
            addCriterion("subtotal in", values, "subtotal");
            return (Criteria) this;
        }

        public Criteria andSubtotalNotIn(List<BigDecimal> values) {
            addCriterion("subtotal not in", values, "subtotal");
            return (Criteria) this;
        }

        public Criteria andSubtotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("subtotal between", value1, value2, "subtotal");
            return (Criteria) this;
        }

        public Criteria andSubtotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("subtotal not between", value1, value2, "subtotal");
            return (Criteria) this;
        }

        public Criteria andPriceNumberIsNull() {
            addCriterion("price_number is null");
            return (Criteria) this;
        }

        public Criteria andPriceNumberIsNotNull() {
            addCriterion("price_number is not null");
            return (Criteria) this;
        }

        public Criteria andPriceNumberEqualTo(BigDecimal value) {
            addCriterion("price_number =", value, "priceNumber");
            return (Criteria) this;
        }

        public Criteria andPriceNumberNotEqualTo(BigDecimal value) {
            addCriterion("price_number <>", value, "priceNumber");
            return (Criteria) this;
        }

        public Criteria andPriceNumberGreaterThan(BigDecimal value) {
            addCriterion("price_number >", value, "priceNumber");
            return (Criteria) this;
        }

        public Criteria andPriceNumberGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price_number >=", value, "priceNumber");
            return (Criteria) this;
        }

        public Criteria andPriceNumberLessThan(BigDecimal value) {
            addCriterion("price_number <", value, "priceNumber");
            return (Criteria) this;
        }

        public Criteria andPriceNumberLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price_number <=", value, "priceNumber");
            return (Criteria) this;
        }

        public Criteria andPriceNumberIn(List<BigDecimal> values) {
            addCriterion("price_number in", values, "priceNumber");
            return (Criteria) this;
        }

        public Criteria andPriceNumberNotIn(List<BigDecimal> values) {
            addCriterion("price_number not in", values, "priceNumber");
            return (Criteria) this;
        }

        public Criteria andPriceNumberBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_number between", value1, value2, "priceNumber");
            return (Criteria) this;
        }

        public Criteria andPriceNumberNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_number not between", value1, value2, "priceNumber");
            return (Criteria) this;
        }

        public Criteria andTimeMeasurementIsNull() {
            addCriterion("time_measurement is null");
            return (Criteria) this;
        }

        public Criteria andTimeMeasurementIsNotNull() {
            addCriterion("time_measurement is not null");
            return (Criteria) this;
        }

        public Criteria andTimeMeasurementEqualTo(String value) {
            addCriterion("time_measurement =", value, "timeMeasurement");
            return (Criteria) this;
        }

        public Criteria andTimeMeasurementNotEqualTo(String value) {
            addCriterion("time_measurement <>", value, "timeMeasurement");
            return (Criteria) this;
        }

        public Criteria andTimeMeasurementGreaterThan(String value) {
            addCriterion("time_measurement >", value, "timeMeasurement");
            return (Criteria) this;
        }

        public Criteria andTimeMeasurementGreaterThanOrEqualTo(String value) {
            addCriterion("time_measurement >=", value, "timeMeasurement");
            return (Criteria) this;
        }

        public Criteria andTimeMeasurementLessThan(String value) {
            addCriterion("time_measurement <", value, "timeMeasurement");
            return (Criteria) this;
        }

        public Criteria andTimeMeasurementLessThanOrEqualTo(String value) {
            addCriterion("time_measurement <=", value, "timeMeasurement");
            return (Criteria) this;
        }

        public Criteria andTimeMeasurementLike(String value) {
            addCriterion("time_measurement like", value, "timeMeasurement");
            return (Criteria) this;
        }

        public Criteria andTimeMeasurementNotLike(String value) {
            addCriterion("time_measurement not like", value, "timeMeasurement");
            return (Criteria) this;
        }

        public Criteria andTimeMeasurementIn(List<String> values) {
            addCriterion("time_measurement in", values, "timeMeasurement");
            return (Criteria) this;
        }

        public Criteria andTimeMeasurementNotIn(List<String> values) {
            addCriterion("time_measurement not in", values, "timeMeasurement");
            return (Criteria) this;
        }

        public Criteria andTimeMeasurementBetween(String value1, String value2) {
            addCriterion("time_measurement between", value1, value2, "timeMeasurement");
            return (Criteria) this;
        }

        public Criteria andTimeMeasurementNotBetween(String value1, String value2) {
            addCriterion("time_measurement not between", value1, value2, "timeMeasurement");
            return (Criteria) this;
        }

        public Criteria andWeightMeasurementIsNull() {
            addCriterion("weight_measurement is null");
            return (Criteria) this;
        }

        public Criteria andWeightMeasurementIsNotNull() {
            addCriterion("weight_measurement is not null");
            return (Criteria) this;
        }

        public Criteria andWeightMeasurementEqualTo(String value) {
            addCriterion("weight_measurement =", value, "weightMeasurement");
            return (Criteria) this;
        }

        public Criteria andWeightMeasurementNotEqualTo(String value) {
            addCriterion("weight_measurement <>", value, "weightMeasurement");
            return (Criteria) this;
        }

        public Criteria andWeightMeasurementGreaterThan(String value) {
            addCriterion("weight_measurement >", value, "weightMeasurement");
            return (Criteria) this;
        }

        public Criteria andWeightMeasurementGreaterThanOrEqualTo(String value) {
            addCriterion("weight_measurement >=", value, "weightMeasurement");
            return (Criteria) this;
        }

        public Criteria andWeightMeasurementLessThan(String value) {
            addCriterion("weight_measurement <", value, "weightMeasurement");
            return (Criteria) this;
        }

        public Criteria andWeightMeasurementLessThanOrEqualTo(String value) {
            addCriterion("weight_measurement <=", value, "weightMeasurement");
            return (Criteria) this;
        }

        public Criteria andWeightMeasurementLike(String value) {
            addCriterion("weight_measurement like", value, "weightMeasurement");
            return (Criteria) this;
        }

        public Criteria andWeightMeasurementNotLike(String value) {
            addCriterion("weight_measurement not like", value, "weightMeasurement");
            return (Criteria) this;
        }

        public Criteria andWeightMeasurementIn(List<String> values) {
            addCriterion("weight_measurement in", values, "weightMeasurement");
            return (Criteria) this;
        }

        public Criteria andWeightMeasurementNotIn(List<String> values) {
            addCriterion("weight_measurement not in", values, "weightMeasurement");
            return (Criteria) this;
        }

        public Criteria andWeightMeasurementBetween(String value1, String value2) {
            addCriterion("weight_measurement between", value1, value2, "weightMeasurement");
            return (Criteria) this;
        }

        public Criteria andWeightMeasurementNotBetween(String value1, String value2) {
            addCriterion("weight_measurement not between", value1, value2, "weightMeasurement");
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