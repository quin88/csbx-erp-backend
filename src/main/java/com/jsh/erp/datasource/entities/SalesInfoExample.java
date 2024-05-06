package com.jsh.erp.datasource.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SalesInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SalesInfoExample() {
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

        public Criteria andMaterialIdIsNull() {
            addCriterion("material_id is null");
            return (Criteria) this;
        }

        public Criteria andMaterialIdIsNotNull() {
            addCriterion("material_id is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialIdEqualTo(Long value) {
            addCriterion("material_id =", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotEqualTo(Long value) {
            addCriterion("material_id <>", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdGreaterThan(Long value) {
            addCriterion("material_id >", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdGreaterThanOrEqualTo(Long value) {
            addCriterion("material_id >=", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdLessThan(Long value) {
            addCriterion("material_id <", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdLessThanOrEqualTo(Long value) {
            addCriterion("material_id <=", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdIn(List<Long> values) {
            addCriterion("material_id in", values, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotIn(List<Long> values) {
            addCriterion("material_id not in", values, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdBetween(Long value1, Long value2) {
            addCriterion("material_id between", value1, value2, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotBetween(Long value1, Long value2) {
            addCriterion("material_id not between", value1, value2, "materialId");
            return (Criteria) this;
        }

        public Criteria andStoreNumberIsNull() {
            addCriterion("store_number is null");
            return (Criteria) this;
        }

        public Criteria andStoreNumberIsNotNull() {
            addCriterion("store_number is not null");
            return (Criteria) this;
        }

        public Criteria andStoreNumberEqualTo(String value) {
            addCriterion("store_number =", value, "storeNumber");
            return (Criteria) this;
        }

        public Criteria andStoreNumberNotEqualTo(String value) {
            addCriterion("store_number <>", value, "storeNumber");
            return (Criteria) this;
        }

        public Criteria andStoreNumberGreaterThan(String value) {
            addCriterion("store_number >", value, "storeNumber");
            return (Criteria) this;
        }

        public Criteria andStoreNumberGreaterThanOrEqualTo(String value) {
            addCriterion("store_number >=", value, "storeNumber");
            return (Criteria) this;
        }

        public Criteria andStoreNumberLessThan(String value) {
            addCriterion("store_number <", value, "storeNumber");
            return (Criteria) this;
        }

        public Criteria andStoreNumberLessThanOrEqualTo(String value) {
            addCriterion("store_number <=", value, "storeNumber");
            return (Criteria) this;
        }

        public Criteria andStoreNumberLike(String value) {
            addCriterion("store_number like", value, "storeNumber");
            return (Criteria) this;
        }

        public Criteria andStoreNumberNotLike(String value) {
            addCriterion("store_number not like", value, "storeNumber");
            return (Criteria) this;
        }

        public Criteria andStoreNumberIn(List<String> values) {
            addCriterion("store_number in", values, "storeNumber");
            return (Criteria) this;
        }

        public Criteria andStoreNumberNotIn(List<String> values) {
            addCriterion("store_number not in", values, "storeNumber");
            return (Criteria) this;
        }

        public Criteria andStoreNumberBetween(String value1, String value2) {
            addCriterion("store_number between", value1, value2, "storeNumber");
            return (Criteria) this;
        }

        public Criteria andStoreNumberNotBetween(String value1, String value2) {
            addCriterion("store_number not between", value1, value2, "storeNumber");
            return (Criteria) this;
        }

        public Criteria andTaxPurchasePriceIsNull() {
            addCriterion("tax_purchase_price is null");
            return (Criteria) this;
        }

        public Criteria andTaxPurchasePriceIsNotNull() {
            addCriterion("tax_purchase_price is not null");
            return (Criteria) this;
        }

        public Criteria andTaxPurchasePriceEqualTo(BigDecimal value) {
            addCriterion("tax_purchase_price =", value, "taxPurchasePrice");
            return (Criteria) this;
        }

        public Criteria andTaxPurchasePriceNotEqualTo(BigDecimal value) {
            addCriterion("tax_purchase_price <>", value, "taxPurchasePrice");
            return (Criteria) this;
        }

        public Criteria andTaxPurchasePriceGreaterThan(BigDecimal value) {
            addCriterion("tax_purchase_price >", value, "taxPurchasePrice");
            return (Criteria) this;
        }

        public Criteria andTaxPurchasePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_purchase_price >=", value, "taxPurchasePrice");
            return (Criteria) this;
        }

        public Criteria andTaxPurchasePriceLessThan(BigDecimal value) {
            addCriterion("tax_purchase_price <", value, "taxPurchasePrice");
            return (Criteria) this;
        }

        public Criteria andTaxPurchasePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_purchase_price <=", value, "taxPurchasePrice");
            return (Criteria) this;
        }

        public Criteria andTaxPurchasePriceIn(List<BigDecimal> values) {
            addCriterion("tax_purchase_price in", values, "taxPurchasePrice");
            return (Criteria) this;
        }

        public Criteria andTaxPurchasePriceNotIn(List<BigDecimal> values) {
            addCriterion("tax_purchase_price not in", values, "taxPurchasePrice");
            return (Criteria) this;
        }

        public Criteria andTaxPurchasePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_purchase_price between", value1, value2, "taxPurchasePrice");
            return (Criteria) this;
        }

        public Criteria andTaxPurchasePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_purchase_price not between", value1, value2, "taxPurchasePrice");
            return (Criteria) this;
        }

        public Criteria andTaxSellingPriceIsNull() {
            addCriterion("tax_selling_price is null");
            return (Criteria) this;
        }

        public Criteria andTaxSellingPriceIsNotNull() {
            addCriterion("tax_selling_price is not null");
            return (Criteria) this;
        }

        public Criteria andTaxSellingPriceEqualTo(BigDecimal value) {
            addCriterion("tax_selling_price =", value, "taxSellingPrice");
            return (Criteria) this;
        }

        public Criteria andTaxSellingPriceNotEqualTo(BigDecimal value) {
            addCriterion("tax_selling_price <>", value, "taxSellingPrice");
            return (Criteria) this;
        }

        public Criteria andTaxSellingPriceGreaterThan(BigDecimal value) {
            addCriterion("tax_selling_price >", value, "taxSellingPrice");
            return (Criteria) this;
        }

        public Criteria andTaxSellingPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_selling_price >=", value, "taxSellingPrice");
            return (Criteria) this;
        }

        public Criteria andTaxSellingPriceLessThan(BigDecimal value) {
            addCriterion("tax_selling_price <", value, "taxSellingPrice");
            return (Criteria) this;
        }

        public Criteria andTaxSellingPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_selling_price <=", value, "taxSellingPrice");
            return (Criteria) this;
        }

        public Criteria andTaxSellingPriceIn(List<BigDecimal> values) {
            addCriterion("tax_selling_price in", values, "taxSellingPrice");
            return (Criteria) this;
        }

        public Criteria andTaxSellingPriceNotIn(List<BigDecimal> values) {
            addCriterion("tax_selling_price not in", values, "taxSellingPrice");
            return (Criteria) this;
        }

        public Criteria andTaxSellingPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_selling_price between", value1, value2, "taxSellingPrice");
            return (Criteria) this;
        }

        public Criteria andTaxSellingPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_selling_price not between", value1, value2, "taxSellingPrice");
            return (Criteria) this;
        }

        public Criteria andStandardIsNull() {
            addCriterion("standard is null");
            return (Criteria) this;
        }

        public Criteria andStandardIsNotNull() {
            addCriterion("standard is not null");
            return (Criteria) this;
        }

        public Criteria andStandardEqualTo(String value) {
            addCriterion("standard =", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardNotEqualTo(String value) {
            addCriterion("standard <>", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardGreaterThan(String value) {
            addCriterion("standard >", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardGreaterThanOrEqualTo(String value) {
            addCriterion("standard >=", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardLessThan(String value) {
            addCriterion("standard <", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardLessThanOrEqualTo(String value) {
            addCriterion("standard <=", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardLike(String value) {
            addCriterion("standard like", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardNotLike(String value) {
            addCriterion("standard not like", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardIn(List<String> values) {
            addCriterion("standard in", values, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardNotIn(List<String> values) {
            addCriterion("standard not in", values, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardBetween(String value1, String value2) {
            addCriterion("standard between", value1, value2, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardNotBetween(String value1, String value2) {
            addCriterion("standard not between", value1, value2, "standard");
            return (Criteria) this;
        }

        public Criteria andShippingCostIsNull() {
            addCriterion("shipping_cost is null");
            return (Criteria) this;
        }

        public Criteria andShippingCostIsNotNull() {
            addCriterion("shipping_cost is not null");
            return (Criteria) this;
        }

        public Criteria andShippingCostEqualTo(Boolean value) {
            addCriterion("shipping_cost =", value, "shippingCost");
            return (Criteria) this;
        }

        public Criteria andShippingCostNotEqualTo(Boolean value) {
            addCriterion("shipping_cost <>", value, "shippingCost");
            return (Criteria) this;
        }

        public Criteria andShippingCostGreaterThan(Boolean value) {
            addCriterion("shipping_cost >", value, "shippingCost");
            return (Criteria) this;
        }

        public Criteria andShippingCostGreaterThanOrEqualTo(Boolean value) {
            addCriterion("shipping_cost >=", value, "shippingCost");
            return (Criteria) this;
        }

        public Criteria andShippingCostLessThan(Boolean value) {
            addCriterion("shipping_cost <", value, "shippingCost");
            return (Criteria) this;
        }

        public Criteria andShippingCostLessThanOrEqualTo(Boolean value) {
            addCriterion("shipping_cost <=", value, "shippingCost");
            return (Criteria) this;
        }

        public Criteria andShippingCostIn(List<Boolean> values) {
            addCriterion("shipping_cost in", values, "shippingCost");
            return (Criteria) this;
        }

        public Criteria andShippingCostNotIn(List<Boolean> values) {
            addCriterion("shipping_cost not in", values, "shippingCost");
            return (Criteria) this;
        }

        public Criteria andShippingCostBetween(Boolean value1, Boolean value2) {
            addCriterion("shipping_cost between", value1, value2, "shippingCost");
            return (Criteria) this;
        }

        public Criteria andShippingCostNotBetween(Boolean value1, Boolean value2) {
            addCriterion("shipping_cost not between", value1, value2, "shippingCost");
            return (Criteria) this;
        }

        public Criteria andSourceTypeIsNull() {
            addCriterion("source_type is null");
            return (Criteria) this;
        }

        public Criteria andSourceTypeIsNotNull() {
            addCriterion("source_type is not null");
            return (Criteria) this;
        }

        public Criteria andSourceTypeEqualTo(String value) {
            addCriterion("source_type =", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNotEqualTo(String value) {
            addCriterion("source_type <>", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeGreaterThan(String value) {
            addCriterion("source_type >", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("source_type >=", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeLessThan(String value) {
            addCriterion("source_type <", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeLessThanOrEqualTo(String value) {
            addCriterion("source_type <=", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeLike(String value) {
            addCriterion("source_type like", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNotLike(String value) {
            addCriterion("source_type not like", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeIn(List<String> values) {
            addCriterion("source_type in", values, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNotIn(List<String> values) {
            addCriterion("source_type not in", values, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeBetween(String value1, String value2) {
            addCriterion("source_type between", value1, value2, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNotBetween(String value1, String value2) {
            addCriterion("source_type not between", value1, value2, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSalesChannelIsNull() {
            addCriterion("sales_channel is null");
            return (Criteria) this;
        }

        public Criteria andSalesChannelIsNotNull() {
            addCriterion("sales_channel is not null");
            return (Criteria) this;
        }

        public Criteria andSalesChannelEqualTo(String value) {
            addCriterion("sales_channel =", value, "salesChannel");
            return (Criteria) this;
        }

        public Criteria andSalesChannelNotEqualTo(String value) {
            addCriterion("sales_channel <>", value, "salesChannel");
            return (Criteria) this;
        }

        public Criteria andSalesChannelGreaterThan(String value) {
            addCriterion("sales_channel >", value, "salesChannel");
            return (Criteria) this;
        }

        public Criteria andSalesChannelGreaterThanOrEqualTo(String value) {
            addCriterion("sales_channel >=", value, "salesChannel");
            return (Criteria) this;
        }

        public Criteria andSalesChannelLessThan(String value) {
            addCriterion("sales_channel <", value, "salesChannel");
            return (Criteria) this;
        }

        public Criteria andSalesChannelLessThanOrEqualTo(String value) {
            addCriterion("sales_channel <=", value, "salesChannel");
            return (Criteria) this;
        }

        public Criteria andSalesChannelLike(String value) {
            addCriterion("sales_channel like", value, "salesChannel");
            return (Criteria) this;
        }

        public Criteria andSalesChannelNotLike(String value) {
            addCriterion("sales_channel not like", value, "salesChannel");
            return (Criteria) this;
        }

        public Criteria andSalesChannelIn(List<String> values) {
            addCriterion("sales_channel in", values, "salesChannel");
            return (Criteria) this;
        }

        public Criteria andSalesChannelNotIn(List<String> values) {
            addCriterion("sales_channel not in", values, "salesChannel");
            return (Criteria) this;
        }

        public Criteria andSalesChannelBetween(String value1, String value2) {
            addCriterion("sales_channel between", value1, value2, "salesChannel");
            return (Criteria) this;
        }

        public Criteria andSalesChannelNotBetween(String value1, String value2) {
            addCriterion("sales_channel not between", value1, value2, "salesChannel");
            return (Criteria) this;
        }

        public Criteria andShippingMethodIsNull() {
            addCriterion("shipping_method is null");
            return (Criteria) this;
        }

        public Criteria andShippingMethodIsNotNull() {
            addCriterion("shipping_method is not null");
            return (Criteria) this;
        }

        public Criteria andShippingMethodEqualTo(String value) {
            addCriterion("shipping_method =", value, "shippingMethod");
            return (Criteria) this;
        }

        public Criteria andShippingMethodNotEqualTo(String value) {
            addCriterion("shipping_method <>", value, "shippingMethod");
            return (Criteria) this;
        }

        public Criteria andShippingMethodGreaterThan(String value) {
            addCriterion("shipping_method >", value, "shippingMethod");
            return (Criteria) this;
        }

        public Criteria andShippingMethodGreaterThanOrEqualTo(String value) {
            addCriterion("shipping_method >=", value, "shippingMethod");
            return (Criteria) this;
        }

        public Criteria andShippingMethodLessThan(String value) {
            addCriterion("shipping_method <", value, "shippingMethod");
            return (Criteria) this;
        }

        public Criteria andShippingMethodLessThanOrEqualTo(String value) {
            addCriterion("shipping_method <=", value, "shippingMethod");
            return (Criteria) this;
        }

        public Criteria andShippingMethodLike(String value) {
            addCriterion("shipping_method like", value, "shippingMethod");
            return (Criteria) this;
        }

        public Criteria andShippingMethodNotLike(String value) {
            addCriterion("shipping_method not like", value, "shippingMethod");
            return (Criteria) this;
        }

        public Criteria andShippingMethodIn(List<String> values) {
            addCriterion("shipping_method in", values, "shippingMethod");
            return (Criteria) this;
        }

        public Criteria andShippingMethodNotIn(List<String> values) {
            addCriterion("shipping_method not in", values, "shippingMethod");
            return (Criteria) this;
        }

        public Criteria andShippingMethodBetween(String value1, String value2) {
            addCriterion("shipping_method between", value1, value2, "shippingMethod");
            return (Criteria) this;
        }

        public Criteria andShippingMethodNotBetween(String value1, String value2) {
            addCriterion("shipping_method not between", value1, value2, "shippingMethod");
            return (Criteria) this;
        }

        public Criteria andBoxSpecIsNull() {
            addCriterion("box_spec is null");
            return (Criteria) this;
        }

        public Criteria andBoxSpecIsNotNull() {
            addCriterion("box_spec is not null");
            return (Criteria) this;
        }

        public Criteria andBoxSpecEqualTo(String value) {
            addCriterion("box_spec =", value, "boxSpec");
            return (Criteria) this;
        }

        public Criteria andBoxSpecNotEqualTo(String value) {
            addCriterion("box_spec <>", value, "boxSpec");
            return (Criteria) this;
        }

        public Criteria andBoxSpecGreaterThan(String value) {
            addCriterion("box_spec >", value, "boxSpec");
            return (Criteria) this;
        }

        public Criteria andBoxSpecGreaterThanOrEqualTo(String value) {
            addCriterion("box_spec >=", value, "boxSpec");
            return (Criteria) this;
        }

        public Criteria andBoxSpecLessThan(String value) {
            addCriterion("box_spec <", value, "boxSpec");
            return (Criteria) this;
        }

        public Criteria andBoxSpecLessThanOrEqualTo(String value) {
            addCriterion("box_spec <=", value, "boxSpec");
            return (Criteria) this;
        }

        public Criteria andBoxSpecLike(String value) {
            addCriterion("box_spec like", value, "boxSpec");
            return (Criteria) this;
        }

        public Criteria andBoxSpecNotLike(String value) {
            addCriterion("box_spec not like", value, "boxSpec");
            return (Criteria) this;
        }

        public Criteria andBoxSpecIn(List<String> values) {
            addCriterion("box_spec in", values, "boxSpec");
            return (Criteria) this;
        }

        public Criteria andBoxSpecNotIn(List<String> values) {
            addCriterion("box_spec not in", values, "boxSpec");
            return (Criteria) this;
        }

        public Criteria andBoxSpecBetween(String value1, String value2) {
            addCriterion("box_spec between", value1, value2, "boxSpec");
            return (Criteria) this;
        }

        public Criteria andBoxSpecNotBetween(String value1, String value2) {
            addCriterion("box_spec not between", value1, value2, "boxSpec");
            return (Criteria) this;
        }

        public Criteria andSmallQuantityIsNull() {
            addCriterion("small_quantity is null");
            return (Criteria) this;
        }

        public Criteria andSmallQuantityIsNotNull() {
            addCriterion("small_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andSmallQuantityEqualTo(BigDecimal value) {
            addCriterion("small_quantity =", value, "smallQuantity");
            return (Criteria) this;
        }

        public Criteria andSmallQuantityNotEqualTo(BigDecimal value) {
            addCriterion("small_quantity <>", value, "smallQuantity");
            return (Criteria) this;
        }

        public Criteria andSmallQuantityGreaterThan(BigDecimal value) {
            addCriterion("small_quantity >", value, "smallQuantity");
            return (Criteria) this;
        }

        public Criteria andSmallQuantityGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("small_quantity >=", value, "smallQuantity");
            return (Criteria) this;
        }

        public Criteria andSmallQuantityLessThan(BigDecimal value) {
            addCriterion("small_quantity <", value, "smallQuantity");
            return (Criteria) this;
        }

        public Criteria andSmallQuantityLessThanOrEqualTo(BigDecimal value) {
            addCriterion("small_quantity <=", value, "smallQuantity");
            return (Criteria) this;
        }

        public Criteria andSmallQuantityIn(List<BigDecimal> values) {
            addCriterion("small_quantity in", values, "smallQuantity");
            return (Criteria) this;
        }

        public Criteria andSmallQuantityNotIn(List<BigDecimal> values) {
            addCriterion("small_quantity not in", values, "smallQuantity");
            return (Criteria) this;
        }

        public Criteria andSmallQuantityBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("small_quantity between", value1, value2, "smallQuantity");
            return (Criteria) this;
        }

        public Criteria andSmallQuantityNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("small_quantity not between", value1, value2, "smallQuantity");
            return (Criteria) this;
        }

        public Criteria andLargeQuantityIsNull() {
            addCriterion("large_quantity is null");
            return (Criteria) this;
        }

        public Criteria andLargeQuantityIsNotNull() {
            addCriterion("large_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andLargeQuantityEqualTo(BigDecimal value) {
            addCriterion("large_quantity =", value, "largeQuantity");
            return (Criteria) this;
        }

        public Criteria andLargeQuantityNotEqualTo(BigDecimal value) {
            addCriterion("large_quantity <>", value, "largeQuantity");
            return (Criteria) this;
        }

        public Criteria andLargeQuantityGreaterThan(BigDecimal value) {
            addCriterion("large_quantity >", value, "largeQuantity");
            return (Criteria) this;
        }

        public Criteria andLargeQuantityGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("large_quantity >=", value, "largeQuantity");
            return (Criteria) this;
        }

        public Criteria andLargeQuantityLessThan(BigDecimal value) {
            addCriterion("large_quantity <", value, "largeQuantity");
            return (Criteria) this;
        }

        public Criteria andLargeQuantityLessThanOrEqualTo(BigDecimal value) {
            addCriterion("large_quantity <=", value, "largeQuantity");
            return (Criteria) this;
        }

        public Criteria andLargeQuantityIn(List<BigDecimal> values) {
            addCriterion("large_quantity in", values, "largeQuantity");
            return (Criteria) this;
        }

        public Criteria andLargeQuantityNotIn(List<BigDecimal> values) {
            addCriterion("large_quantity not in", values, "largeQuantity");
            return (Criteria) this;
        }

        public Criteria andLargeQuantityBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("large_quantity between", value1, value2, "largeQuantity");
            return (Criteria) this;
        }

        public Criteria andLargeQuantityNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("large_quantity not between", value1, value2, "largeQuantity");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(BigDecimal value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(BigDecimal value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(BigDecimal value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(BigDecimal value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<BigDecimal> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<BigDecimal> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andBoxBarcodeIsNull() {
            addCriterion("box_barcode is null");
            return (Criteria) this;
        }

        public Criteria andBoxBarcodeIsNotNull() {
            addCriterion("box_barcode is not null");
            return (Criteria) this;
        }

        public Criteria andBoxBarcodeEqualTo(String value) {
            addCriterion("box_barcode =", value, "boxBarcode");
            return (Criteria) this;
        }

        public Criteria andBoxBarcodeNotEqualTo(String value) {
            addCriterion("box_barcode <>", value, "boxBarcode");
            return (Criteria) this;
        }

        public Criteria andBoxBarcodeGreaterThan(String value) {
            addCriterion("box_barcode >", value, "boxBarcode");
            return (Criteria) this;
        }

        public Criteria andBoxBarcodeGreaterThanOrEqualTo(String value) {
            addCriterion("box_barcode >=", value, "boxBarcode");
            return (Criteria) this;
        }

        public Criteria andBoxBarcodeLessThan(String value) {
            addCriterion("box_barcode <", value, "boxBarcode");
            return (Criteria) this;
        }

        public Criteria andBoxBarcodeLessThanOrEqualTo(String value) {
            addCriterion("box_barcode <=", value, "boxBarcode");
            return (Criteria) this;
        }

        public Criteria andBoxBarcodeLike(String value) {
            addCriterion("box_barcode like", value, "boxBarcode");
            return (Criteria) this;
        }

        public Criteria andBoxBarcodeNotLike(String value) {
            addCriterion("box_barcode not like", value, "boxBarcode");
            return (Criteria) this;
        }

        public Criteria andBoxBarcodeIn(List<String> values) {
            addCriterion("box_barcode in", values, "boxBarcode");
            return (Criteria) this;
        }

        public Criteria andBoxBarcodeNotIn(List<String> values) {
            addCriterion("box_barcode not in", values, "boxBarcode");
            return (Criteria) this;
        }

        public Criteria andBoxBarcodeBetween(String value1, String value2) {
            addCriterion("box_barcode between", value1, value2, "boxBarcode");
            return (Criteria) this;
        }

        public Criteria andBoxBarcodeNotBetween(String value1, String value2) {
            addCriterion("box_barcode not between", value1, value2, "boxBarcode");
            return (Criteria) this;
        }

        public Criteria andLaunchDateIsNull() {
            addCriterion("launch_date is null");
            return (Criteria) this;
        }

        public Criteria andLaunchDateIsNotNull() {
            addCriterion("launch_date is not null");
            return (Criteria) this;
        }

        public Criteria andLaunchDateEqualTo(String value) {
            addCriterion("launch_date =", value, "launchDate");
            return (Criteria) this;
        }

        public Criteria andLaunchDateNotEqualTo(String value) {
            addCriterion("launch_date <>", value, "launchDate");
            return (Criteria) this;
        }

        public Criteria andLaunchDateGreaterThan(String value) {
            addCriterion("launch_date >", value, "launchDate");
            return (Criteria) this;
        }

        public Criteria andLaunchDateGreaterThanOrEqualTo(String value) {
            addCriterion("launch_date >=", value, "launchDate");
            return (Criteria) this;
        }

        public Criteria andLaunchDateLessThan(String value) {
            addCriterion("launch_date <", value, "launchDate");
            return (Criteria) this;
        }

        public Criteria andLaunchDateLessThanOrEqualTo(String value) {
            addCriterion("launch_date <=", value, "launchDate");
            return (Criteria) this;
        }

        public Criteria andLaunchDateLike(String value) {
            addCriterion("launch_date like", value, "launchDate");
            return (Criteria) this;
        }

        public Criteria andLaunchDateNotLike(String value) {
            addCriterion("launch_date not like", value, "launchDate");
            return (Criteria) this;
        }

        public Criteria andLaunchDateIn(List<String> values) {
            addCriterion("launch_date in", values, "launchDate");
            return (Criteria) this;
        }

        public Criteria andLaunchDateNotIn(List<String> values) {
            addCriterion("launch_date not in", values, "launchDate");
            return (Criteria) this;
        }

        public Criteria andLaunchDateBetween(String value1, String value2) {
            addCriterion("launch_date between", value1, value2, "launchDate");
            return (Criteria) this;
        }

        public Criteria andLaunchDateNotBetween(String value1, String value2) {
            addCriterion("launch_date not between", value1, value2, "launchDate");
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

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(Long value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(Long value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(Long value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(Long value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(Long value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(Long value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<Long> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<Long> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(Long value1, Long value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(Long value1, Long value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(Long value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(Long value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(Long value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(Long value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(Long value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(Long value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<Long> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<Long> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(Long value1, Long value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(Long value1, Long value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCountyIsNull() {
            addCriterion("county is null");
            return (Criteria) this;
        }

        public Criteria andCountyIsNotNull() {
            addCriterion("county is not null");
            return (Criteria) this;
        }

        public Criteria andCountyEqualTo(Long value) {
            addCriterion("county =", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotEqualTo(Long value) {
            addCriterion("county <>", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyGreaterThan(Long value) {
            addCriterion("county >", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyGreaterThanOrEqualTo(Long value) {
            addCriterion("county >=", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyLessThan(Long value) {
            addCriterion("county <", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyLessThanOrEqualTo(Long value) {
            addCriterion("county <=", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyIn(List<Long> values) {
            addCriterion("county in", values, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotIn(List<Long> values) {
            addCriterion("county not in", values, "county");
            return (Criteria) this;
        }

        public Criteria andCountyBetween(Long value1, Long value2) {
            addCriterion("county between", value1, value2, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotBetween(Long value1, Long value2) {
            addCriterion("county not between", value1, value2, "county");
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