package com.jsh.erp.datasource.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DepotItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DepotItemExample() {
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

        public Criteria andHeaderIdIsNull() {
            addCriterion("header_id is null");
            return (Criteria) this;
        }

        public Criteria andHeaderIdIsNotNull() {
            addCriterion("header_id is not null");
            return (Criteria) this;
        }

        public Criteria andHeaderIdEqualTo(Long value) {
            addCriterion("header_id =", value, "headerId");
            return (Criteria) this;
        }

        public Criteria andHeaderIdNotEqualTo(Long value) {
            addCriterion("header_id <>", value, "headerId");
            return (Criteria) this;
        }

        public Criteria andHeaderIdGreaterThan(Long value) {
            addCriterion("header_id >", value, "headerId");
            return (Criteria) this;
        }

        public Criteria andHeaderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("header_id >=", value, "headerId");
            return (Criteria) this;
        }

        public Criteria andHeaderIdLessThan(Long value) {
            addCriterion("header_id <", value, "headerId");
            return (Criteria) this;
        }

        public Criteria andHeaderIdLessThanOrEqualTo(Long value) {
            addCriterion("header_id <=", value, "headerId");
            return (Criteria) this;
        }

        public Criteria andHeaderIdIn(List<Long> values) {
            addCriterion("header_id in", values, "headerId");
            return (Criteria) this;
        }

        public Criteria andHeaderIdNotIn(List<Long> values) {
            addCriterion("header_id not in", values, "headerId");
            return (Criteria) this;
        }

        public Criteria andHeaderIdBetween(Long value1, Long value2) {
            addCriterion("header_id between", value1, value2, "headerId");
            return (Criteria) this;
        }

        public Criteria andHeaderIdNotBetween(Long value1, Long value2) {
            addCriterion("header_id not between", value1, value2, "headerId");
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

        public Criteria andMaterialExtendIdIsNull() {
            addCriterion("material_extend_id is null");
            return (Criteria) this;
        }

        public Criteria andMaterialExtendIdIsNotNull() {
            addCriterion("material_extend_id is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialExtendIdEqualTo(Long value) {
            addCriterion("material_extend_id =", value, "materialExtendId");
            return (Criteria) this;
        }

        public Criteria andMaterialExtendIdNotEqualTo(Long value) {
            addCriterion("material_extend_id <>", value, "materialExtendId");
            return (Criteria) this;
        }

        public Criteria andMaterialExtendIdGreaterThan(Long value) {
            addCriterion("material_extend_id >", value, "materialExtendId");
            return (Criteria) this;
        }

        public Criteria andMaterialExtendIdGreaterThanOrEqualTo(Long value) {
            addCriterion("material_extend_id >=", value, "materialExtendId");
            return (Criteria) this;
        }

        public Criteria andMaterialExtendIdLessThan(Long value) {
            addCriterion("material_extend_id <", value, "materialExtendId");
            return (Criteria) this;
        }

        public Criteria andMaterialExtendIdLessThanOrEqualTo(Long value) {
            addCriterion("material_extend_id <=", value, "materialExtendId");
            return (Criteria) this;
        }

        public Criteria andMaterialExtendIdIn(List<Long> values) {
            addCriterion("material_extend_id in", values, "materialExtendId");
            return (Criteria) this;
        }

        public Criteria andMaterialExtendIdNotIn(List<Long> values) {
            addCriterion("material_extend_id not in", values, "materialExtendId");
            return (Criteria) this;
        }

        public Criteria andMaterialExtendIdBetween(Long value1, Long value2) {
            addCriterion("material_extend_id between", value1, value2, "materialExtendId");
            return (Criteria) this;
        }

        public Criteria andMaterialExtendIdNotBetween(Long value1, Long value2) {
            addCriterion("material_extend_id not between", value1, value2, "materialExtendId");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitIsNull() {
            addCriterion("material_unit is null");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitIsNotNull() {
            addCriterion("material_unit is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitEqualTo(String value) {
            addCriterion("material_unit =", value, "materialUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitNotEqualTo(String value) {
            addCriterion("material_unit <>", value, "materialUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitGreaterThan(String value) {
            addCriterion("material_unit >", value, "materialUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitGreaterThanOrEqualTo(String value) {
            addCriterion("material_unit >=", value, "materialUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitLessThan(String value) {
            addCriterion("material_unit <", value, "materialUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitLessThanOrEqualTo(String value) {
            addCriterion("material_unit <=", value, "materialUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitLike(String value) {
            addCriterion("material_unit like", value, "materialUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitNotLike(String value) {
            addCriterion("material_unit not like", value, "materialUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitIn(List<String> values) {
            addCriterion("material_unit in", values, "materialUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitNotIn(List<String> values) {
            addCriterion("material_unit not in", values, "materialUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitBetween(String value1, String value2) {
            addCriterion("material_unit between", value1, value2, "materialUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitNotBetween(String value1, String value2) {
            addCriterion("material_unit not between", value1, value2, "materialUnit");
            return (Criteria) this;
        }

        public Criteria andSkuIsNull() {
            addCriterion("sku is null");
            return (Criteria) this;
        }

        public Criteria andSkuIsNotNull() {
            addCriterion("sku is not null");
            return (Criteria) this;
        }

        public Criteria andSkuEqualTo(String value) {
            addCriterion("sku =", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuNotEqualTo(String value) {
            addCriterion("sku <>", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuGreaterThan(String value) {
            addCriterion("sku >", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuGreaterThanOrEqualTo(String value) {
            addCriterion("sku >=", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuLessThan(String value) {
            addCriterion("sku <", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuLessThanOrEqualTo(String value) {
            addCriterion("sku <=", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuLike(String value) {
            addCriterion("sku like", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuNotLike(String value) {
            addCriterion("sku not like", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuIn(List<String> values) {
            addCriterion("sku in", values, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuNotIn(List<String> values) {
            addCriterion("sku not in", values, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuBetween(String value1, String value2) {
            addCriterion("sku between", value1, value2, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuNotBetween(String value1, String value2) {
            addCriterion("sku not between", value1, value2, "sku");
            return (Criteria) this;
        }

        public Criteria andOperNumberIsNull() {
            addCriterion("oper_number is null");
            return (Criteria) this;
        }

        public Criteria andOperNumberIsNotNull() {
            addCriterion("oper_number is not null");
            return (Criteria) this;
        }

        public Criteria andOperNumberEqualTo(BigDecimal value) {
            addCriterion("oper_number =", value, "operNumber");
            return (Criteria) this;
        }

        public Criteria andOperNumberNotEqualTo(BigDecimal value) {
            addCriterion("oper_number <>", value, "operNumber");
            return (Criteria) this;
        }

        public Criteria andOperNumberGreaterThan(BigDecimal value) {
            addCriterion("oper_number >", value, "operNumber");
            return (Criteria) this;
        }

        public Criteria andOperNumberGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("oper_number >=", value, "operNumber");
            return (Criteria) this;
        }

        public Criteria andOperNumberLessThan(BigDecimal value) {
            addCriterion("oper_number <", value, "operNumber");
            return (Criteria) this;
        }

        public Criteria andOperNumberLessThanOrEqualTo(BigDecimal value) {
            addCriterion("oper_number <=", value, "operNumber");
            return (Criteria) this;
        }

        public Criteria andOperNumberIn(List<BigDecimal> values) {
            addCriterion("oper_number in", values, "operNumber");
            return (Criteria) this;
        }

        public Criteria andOperNumberNotIn(List<BigDecimal> values) {
            addCriterion("oper_number not in", values, "operNumber");
            return (Criteria) this;
        }

        public Criteria andOperNumberBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("oper_number between", value1, value2, "operNumber");
            return (Criteria) this;
        }

        public Criteria andOperNumberNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("oper_number not between", value1, value2, "operNumber");
            return (Criteria) this;
        }

        public Criteria andBasicNumberIsNull() {
            addCriterion("basic_number is null");
            return (Criteria) this;
        }

        public Criteria andBasicNumberIsNotNull() {
            addCriterion("basic_number is not null");
            return (Criteria) this;
        }

        public Criteria andBasicNumberEqualTo(BigDecimal value) {
            addCriterion("basic_number =", value, "basicNumber");
            return (Criteria) this;
        }

        public Criteria andBasicNumberNotEqualTo(BigDecimal value) {
            addCriterion("basic_number <>", value, "basicNumber");
            return (Criteria) this;
        }

        public Criteria andBasicNumberGreaterThan(BigDecimal value) {
            addCriterion("basic_number >", value, "basicNumber");
            return (Criteria) this;
        }

        public Criteria andBasicNumberGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("basic_number >=", value, "basicNumber");
            return (Criteria) this;
        }

        public Criteria andBasicNumberLessThan(BigDecimal value) {
            addCriterion("basic_number <", value, "basicNumber");
            return (Criteria) this;
        }

        public Criteria andBasicNumberLessThanOrEqualTo(BigDecimal value) {
            addCriterion("basic_number <=", value, "basicNumber");
            return (Criteria) this;
        }

        public Criteria andBasicNumberIn(List<BigDecimal> values) {
            addCriterion("basic_number in", values, "basicNumber");
            return (Criteria) this;
        }

        public Criteria andBasicNumberNotIn(List<BigDecimal> values) {
            addCriterion("basic_number not in", values, "basicNumber");
            return (Criteria) this;
        }

        public Criteria andBasicNumberBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("basic_number between", value1, value2, "basicNumber");
            return (Criteria) this;
        }

        public Criteria andBasicNumberNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("basic_number not between", value1, value2, "basicNumber");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIsNull() {
            addCriterion("unit_price is null");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIsNotNull() {
            addCriterion("unit_price is not null");
            return (Criteria) this;
        }

        public Criteria andUnitPriceEqualTo(BigDecimal value) {
            addCriterion("unit_price =", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotEqualTo(BigDecimal value) {
            addCriterion("unit_price <>", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceGreaterThan(BigDecimal value) {
            addCriterion("unit_price >", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("unit_price >=", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceLessThan(BigDecimal value) {
            addCriterion("unit_price <", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("unit_price <=", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIn(List<BigDecimal> values) {
            addCriterion("unit_price in", values, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotIn(List<BigDecimal> values) {
            addCriterion("unit_price not in", values, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unit_price between", value1, value2, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unit_price not between", value1, value2, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitPriceIsNull() {
            addCriterion("purchase_unit_price is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitPriceIsNotNull() {
            addCriterion("purchase_unit_price is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitPriceEqualTo(BigDecimal value) {
            addCriterion("purchase_unit_price =", value, "purchaseUnitPrice");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitPriceNotEqualTo(BigDecimal value) {
            addCriterion("purchase_unit_price <>", value, "purchaseUnitPrice");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitPriceGreaterThan(BigDecimal value) {
            addCriterion("purchase_unit_price >", value, "purchaseUnitPrice");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("purchase_unit_price >=", value, "purchaseUnitPrice");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitPriceLessThan(BigDecimal value) {
            addCriterion("purchase_unit_price <", value, "purchaseUnitPrice");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("purchase_unit_price <=", value, "purchaseUnitPrice");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitPriceIn(List<BigDecimal> values) {
            addCriterion("purchase_unit_price in", values, "purchaseUnitPrice");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitPriceNotIn(List<BigDecimal> values) {
            addCriterion("purchase_unit_price not in", values, "purchaseUnitPrice");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("purchase_unit_price between", value1, value2, "purchaseUnitPrice");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("purchase_unit_price not between", value1, value2, "purchaseUnitPrice");
            return (Criteria) this;
        }

        public Criteria andTaxUnitPriceIsNull() {
            addCriterion("tax_unit_price is null");
            return (Criteria) this;
        }

        public Criteria andTaxUnitPriceIsNotNull() {
            addCriterion("tax_unit_price is not null");
            return (Criteria) this;
        }

        public Criteria andTaxUnitPriceEqualTo(BigDecimal value) {
            addCriterion("tax_unit_price =", value, "taxUnitPrice");
            return (Criteria) this;
        }

        public Criteria andTaxUnitPriceNotEqualTo(BigDecimal value) {
            addCriterion("tax_unit_price <>", value, "taxUnitPrice");
            return (Criteria) this;
        }

        public Criteria andTaxUnitPriceGreaterThan(BigDecimal value) {
            addCriterion("tax_unit_price >", value, "taxUnitPrice");
            return (Criteria) this;
        }

        public Criteria andTaxUnitPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_unit_price >=", value, "taxUnitPrice");
            return (Criteria) this;
        }

        public Criteria andTaxUnitPriceLessThan(BigDecimal value) {
            addCriterion("tax_unit_price <", value, "taxUnitPrice");
            return (Criteria) this;
        }

        public Criteria andTaxUnitPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_unit_price <=", value, "taxUnitPrice");
            return (Criteria) this;
        }

        public Criteria andTaxUnitPriceIn(List<BigDecimal> values) {
            addCriterion("tax_unit_price in", values, "taxUnitPrice");
            return (Criteria) this;
        }

        public Criteria andTaxUnitPriceNotIn(List<BigDecimal> values) {
            addCriterion("tax_unit_price not in", values, "taxUnitPrice");
            return (Criteria) this;
        }

        public Criteria andTaxUnitPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_unit_price between", value1, value2, "taxUnitPrice");
            return (Criteria) this;
        }

        public Criteria andTaxUnitPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_unit_price not between", value1, value2, "taxUnitPrice");
            return (Criteria) this;
        }

        public Criteria andAllPriceIsNull() {
            addCriterion("all_price is null");
            return (Criteria) this;
        }

        public Criteria andAllPriceIsNotNull() {
            addCriterion("all_price is not null");
            return (Criteria) this;
        }

        public Criteria andAllPriceEqualTo(BigDecimal value) {
            addCriterion("all_price =", value, "allPrice");
            return (Criteria) this;
        }

        public Criteria andAllPriceNotEqualTo(BigDecimal value) {
            addCriterion("all_price <>", value, "allPrice");
            return (Criteria) this;
        }

        public Criteria andAllPriceGreaterThan(BigDecimal value) {
            addCriterion("all_price >", value, "allPrice");
            return (Criteria) this;
        }

        public Criteria andAllPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("all_price >=", value, "allPrice");
            return (Criteria) this;
        }

        public Criteria andAllPriceLessThan(BigDecimal value) {
            addCriterion("all_price <", value, "allPrice");
            return (Criteria) this;
        }

        public Criteria andAllPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("all_price <=", value, "allPrice");
            return (Criteria) this;
        }

        public Criteria andAllPriceIn(List<BigDecimal> values) {
            addCriterion("all_price in", values, "allPrice");
            return (Criteria) this;
        }

        public Criteria andAllPriceNotIn(List<BigDecimal> values) {
            addCriterion("all_price not in", values, "allPrice");
            return (Criteria) this;
        }

        public Criteria andAllPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("all_price between", value1, value2, "allPrice");
            return (Criteria) this;
        }

        public Criteria andAllPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("all_price not between", value1, value2, "allPrice");
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

        public Criteria andDepotIdIsNull() {
            addCriterion("depot_id is null");
            return (Criteria) this;
        }

        public Criteria andDepotIdIsNotNull() {
            addCriterion("depot_id is not null");
            return (Criteria) this;
        }

        public Criteria andDepotIdEqualTo(Long value) {
            addCriterion("depot_id =", value, "depotId");
            return (Criteria) this;
        }

        public Criteria andDepotIdNotEqualTo(Long value) {
            addCriterion("depot_id <>", value, "depotId");
            return (Criteria) this;
        }

        public Criteria andDepotIdGreaterThan(Long value) {
            addCriterion("depot_id >", value, "depotId");
            return (Criteria) this;
        }

        public Criteria andDepotIdGreaterThanOrEqualTo(Long value) {
            addCriterion("depot_id >=", value, "depotId");
            return (Criteria) this;
        }

        public Criteria andDepotIdLessThan(Long value) {
            addCriterion("depot_id <", value, "depotId");
            return (Criteria) this;
        }

        public Criteria andDepotIdLessThanOrEqualTo(Long value) {
            addCriterion("depot_id <=", value, "depotId");
            return (Criteria) this;
        }

        public Criteria andDepotIdIn(List<Long> values) {
            addCriterion("depot_id in", values, "depotId");
            return (Criteria) this;
        }

        public Criteria andDepotIdNotIn(List<Long> values) {
            addCriterion("depot_id not in", values, "depotId");
            return (Criteria) this;
        }

        public Criteria andDepotIdBetween(Long value1, Long value2) {
            addCriterion("depot_id between", value1, value2, "depotId");
            return (Criteria) this;
        }

        public Criteria andDepotIdNotBetween(Long value1, Long value2) {
            addCriterion("depot_id not between", value1, value2, "depotId");
            return (Criteria) this;
        }

        public Criteria andAnotherDepotIdIsNull() {
            addCriterion("another_depot_id is null");
            return (Criteria) this;
        }

        public Criteria andAnotherDepotIdIsNotNull() {
            addCriterion("another_depot_id is not null");
            return (Criteria) this;
        }

        public Criteria andAnotherDepotIdEqualTo(Long value) {
            addCriterion("another_depot_id =", value, "anotherDepotId");
            return (Criteria) this;
        }

        public Criteria andAnotherDepotIdNotEqualTo(Long value) {
            addCriterion("another_depot_id <>", value, "anotherDepotId");
            return (Criteria) this;
        }

        public Criteria andAnotherDepotIdGreaterThan(Long value) {
            addCriterion("another_depot_id >", value, "anotherDepotId");
            return (Criteria) this;
        }

        public Criteria andAnotherDepotIdGreaterThanOrEqualTo(Long value) {
            addCriterion("another_depot_id >=", value, "anotherDepotId");
            return (Criteria) this;
        }

        public Criteria andAnotherDepotIdLessThan(Long value) {
            addCriterion("another_depot_id <", value, "anotherDepotId");
            return (Criteria) this;
        }

        public Criteria andAnotherDepotIdLessThanOrEqualTo(Long value) {
            addCriterion("another_depot_id <=", value, "anotherDepotId");
            return (Criteria) this;
        }

        public Criteria andAnotherDepotIdIn(List<Long> values) {
            addCriterion("another_depot_id in", values, "anotherDepotId");
            return (Criteria) this;
        }

        public Criteria andAnotherDepotIdNotIn(List<Long> values) {
            addCriterion("another_depot_id not in", values, "anotherDepotId");
            return (Criteria) this;
        }

        public Criteria andAnotherDepotIdBetween(Long value1, Long value2) {
            addCriterion("another_depot_id between", value1, value2, "anotherDepotId");
            return (Criteria) this;
        }

        public Criteria andAnotherDepotIdNotBetween(Long value1, Long value2) {
            addCriterion("another_depot_id not between", value1, value2, "anotherDepotId");
            return (Criteria) this;
        }

        public Criteria andTaxRateIsNull() {
            addCriterion("tax_rate is null");
            return (Criteria) this;
        }

        public Criteria andTaxRateIsNotNull() {
            addCriterion("tax_rate is not null");
            return (Criteria) this;
        }

        public Criteria andTaxRateEqualTo(BigDecimal value) {
            addCriterion("tax_rate =", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateNotEqualTo(BigDecimal value) {
            addCriterion("tax_rate <>", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateGreaterThan(BigDecimal value) {
            addCriterion("tax_rate >", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_rate >=", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateLessThan(BigDecimal value) {
            addCriterion("tax_rate <", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_rate <=", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateIn(List<BigDecimal> values) {
            addCriterion("tax_rate in", values, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateNotIn(List<BigDecimal> values) {
            addCriterion("tax_rate not in", values, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_rate between", value1, value2, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_rate not between", value1, value2, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxMoneyIsNull() {
            addCriterion("tax_money is null");
            return (Criteria) this;
        }

        public Criteria andTaxMoneyIsNotNull() {
            addCriterion("tax_money is not null");
            return (Criteria) this;
        }

        public Criteria andTaxMoneyEqualTo(BigDecimal value) {
            addCriterion("tax_money =", value, "taxMoney");
            return (Criteria) this;
        }

        public Criteria andTaxMoneyNotEqualTo(BigDecimal value) {
            addCriterion("tax_money <>", value, "taxMoney");
            return (Criteria) this;
        }

        public Criteria andTaxMoneyGreaterThan(BigDecimal value) {
            addCriterion("tax_money >", value, "taxMoney");
            return (Criteria) this;
        }

        public Criteria andTaxMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_money >=", value, "taxMoney");
            return (Criteria) this;
        }

        public Criteria andTaxMoneyLessThan(BigDecimal value) {
            addCriterion("tax_money <", value, "taxMoney");
            return (Criteria) this;
        }

        public Criteria andTaxMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_money <=", value, "taxMoney");
            return (Criteria) this;
        }

        public Criteria andTaxMoneyIn(List<BigDecimal> values) {
            addCriterion("tax_money in", values, "taxMoney");
            return (Criteria) this;
        }

        public Criteria andTaxMoneyNotIn(List<BigDecimal> values) {
            addCriterion("tax_money not in", values, "taxMoney");
            return (Criteria) this;
        }

        public Criteria andTaxMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_money between", value1, value2, "taxMoney");
            return (Criteria) this;
        }

        public Criteria andTaxMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_money not between", value1, value2, "taxMoney");
            return (Criteria) this;
        }

        public Criteria andTaxLastMoneyIsNull() {
            addCriterion("tax_last_money is null");
            return (Criteria) this;
        }

        public Criteria andTaxLastMoneyIsNotNull() {
            addCriterion("tax_last_money is not null");
            return (Criteria) this;
        }

        public Criteria andTaxLastMoneyEqualTo(BigDecimal value) {
            addCriterion("tax_last_money =", value, "taxLastMoney");
            return (Criteria) this;
        }

        public Criteria andTaxLastMoneyNotEqualTo(BigDecimal value) {
            addCriterion("tax_last_money <>", value, "taxLastMoney");
            return (Criteria) this;
        }

        public Criteria andTaxLastMoneyGreaterThan(BigDecimal value) {
            addCriterion("tax_last_money >", value, "taxLastMoney");
            return (Criteria) this;
        }

        public Criteria andTaxLastMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_last_money >=", value, "taxLastMoney");
            return (Criteria) this;
        }

        public Criteria andTaxLastMoneyLessThan(BigDecimal value) {
            addCriterion("tax_last_money <", value, "taxLastMoney");
            return (Criteria) this;
        }

        public Criteria andTaxLastMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_last_money <=", value, "taxLastMoney");
            return (Criteria) this;
        }

        public Criteria andTaxLastMoneyIn(List<BigDecimal> values) {
            addCriterion("tax_last_money in", values, "taxLastMoney");
            return (Criteria) this;
        }

        public Criteria andTaxLastMoneyNotIn(List<BigDecimal> values) {
            addCriterion("tax_last_money not in", values, "taxLastMoney");
            return (Criteria) this;
        }

        public Criteria andTaxLastMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_last_money between", value1, value2, "taxLastMoney");
            return (Criteria) this;
        }

        public Criteria andTaxLastMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_last_money not between", value1, value2, "taxLastMoney");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeIsNull() {
            addCriterion("material_type is null");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeIsNotNull() {
            addCriterion("material_type is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeEqualTo(String value) {
            addCriterion("material_type =", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeNotEqualTo(String value) {
            addCriterion("material_type <>", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeGreaterThan(String value) {
            addCriterion("material_type >", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeGreaterThanOrEqualTo(String value) {
            addCriterion("material_type >=", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeLessThan(String value) {
            addCriterion("material_type <", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeLessThanOrEqualTo(String value) {
            addCriterion("material_type <=", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeLike(String value) {
            addCriterion("material_type like", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeNotLike(String value) {
            addCriterion("material_type not like", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeIn(List<String> values) {
            addCriterion("material_type in", values, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeNotIn(List<String> values) {
            addCriterion("material_type not in", values, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeBetween(String value1, String value2) {
            addCriterion("material_type between", value1, value2, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeNotBetween(String value1, String value2) {
            addCriterion("material_type not between", value1, value2, "materialType");
            return (Criteria) this;
        }

        public Criteria andSnListIsNull() {
            addCriterion("sn_list is null");
            return (Criteria) this;
        }

        public Criteria andSnListIsNotNull() {
            addCriterion("sn_list is not null");
            return (Criteria) this;
        }

        public Criteria andSnListEqualTo(String value) {
            addCriterion("sn_list =", value, "snList");
            return (Criteria) this;
        }

        public Criteria andSnListNotEqualTo(String value) {
            addCriterion("sn_list <>", value, "snList");
            return (Criteria) this;
        }

        public Criteria andSnListGreaterThan(String value) {
            addCriterion("sn_list >", value, "snList");
            return (Criteria) this;
        }

        public Criteria andSnListGreaterThanOrEqualTo(String value) {
            addCriterion("sn_list >=", value, "snList");
            return (Criteria) this;
        }

        public Criteria andSnListLessThan(String value) {
            addCriterion("sn_list <", value, "snList");
            return (Criteria) this;
        }

        public Criteria andSnListLessThanOrEqualTo(String value) {
            addCriterion("sn_list <=", value, "snList");
            return (Criteria) this;
        }

        public Criteria andSnListLike(String value) {
            addCriterion("sn_list like", value, "snList");
            return (Criteria) this;
        }

        public Criteria andSnListNotLike(String value) {
            addCriterion("sn_list not like", value, "snList");
            return (Criteria) this;
        }

        public Criteria andSnListIn(List<String> values) {
            addCriterion("sn_list in", values, "snList");
            return (Criteria) this;
        }

        public Criteria andSnListNotIn(List<String> values) {
            addCriterion("sn_list not in", values, "snList");
            return (Criteria) this;
        }

        public Criteria andSnListBetween(String value1, String value2) {
            addCriterion("sn_list between", value1, value2, "snList");
            return (Criteria) this;
        }

        public Criteria andSnListNotBetween(String value1, String value2) {
            addCriterion("sn_list not between", value1, value2, "snList");
            return (Criteria) this;
        }

        public Criteria andBatchNumberIsNull() {
            addCriterion("batch_number is null");
            return (Criteria) this;
        }

        public Criteria andBatchNumberIsNotNull() {
            addCriterion("batch_number is not null");
            return (Criteria) this;
        }

        public Criteria andBatchNumberEqualTo(String value) {
            addCriterion("batch_number =", value, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberNotEqualTo(String value) {
            addCriterion("batch_number <>", value, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberGreaterThan(String value) {
            addCriterion("batch_number >", value, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberGreaterThanOrEqualTo(String value) {
            addCriterion("batch_number >=", value, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberLessThan(String value) {
            addCriterion("batch_number <", value, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberLessThanOrEqualTo(String value) {
            addCriterion("batch_number <=", value, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberLike(String value) {
            addCriterion("batch_number like", value, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberNotLike(String value) {
            addCriterion("batch_number not like", value, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberIn(List<String> values) {
            addCriterion("batch_number in", values, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberNotIn(List<String> values) {
            addCriterion("batch_number not in", values, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberBetween(String value1, String value2) {
            addCriterion("batch_number between", value1, value2, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberNotBetween(String value1, String value2) {
            addCriterion("batch_number not between", value1, value2, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andExpirationDateIsNull() {
            addCriterion("expiration_date is null");
            return (Criteria) this;
        }

        public Criteria andExpirationDateIsNotNull() {
            addCriterion("expiration_date is not null");
            return (Criteria) this;
        }

        public Criteria andExpirationDateEqualTo(Date value) {
            addCriterion("expiration_date =", value, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateNotEqualTo(Date value) {
            addCriterion("expiration_date <>", value, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateGreaterThan(Date value) {
            addCriterion("expiration_date >", value, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateGreaterThanOrEqualTo(Date value) {
            addCriterion("expiration_date >=", value, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateLessThan(Date value) {
            addCriterion("expiration_date <", value, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateLessThanOrEqualTo(Date value) {
            addCriterion("expiration_date <=", value, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateIn(List<Date> values) {
            addCriterion("expiration_date in", values, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateNotIn(List<Date> values) {
            addCriterion("expiration_date not in", values, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateBetween(Date value1, Date value2) {
            addCriterion("expiration_date between", value1, value2, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateNotBetween(Date value1, Date value2) {
            addCriterion("expiration_date not between", value1, value2, "expirationDate");
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

        public Criteria andNumberOfPanelsIsNull() {
            addCriterion("number_of_panels is null");
            return (Criteria) this;
        }

        public Criteria andNumberOfPanelsIsNotNull() {
            addCriterion("number_of_panels is not null");
            return (Criteria) this;
        }

        public Criteria andNumberOfPanelsEqualTo(BigDecimal value) {
            addCriterion("number_of_panels =", value, "numberOfPanels");
            return (Criteria) this;
        }

        public Criteria andNumberOfPanelsNotEqualTo(BigDecimal value) {
            addCriterion("number_of_panels <>", value, "numberOfPanels");
            return (Criteria) this;
        }

        public Criteria andNumberOfPanelsGreaterThan(BigDecimal value) {
            addCriterion("number_of_panels >", value, "numberOfPanels");
            return (Criteria) this;
        }

        public Criteria andNumberOfPanelsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("number_of_panels >=", value, "numberOfPanels");
            return (Criteria) this;
        }

        public Criteria andNumberOfPanelsLessThan(BigDecimal value) {
            addCriterion("number_of_panels <", value, "numberOfPanels");
            return (Criteria) this;
        }

        public Criteria andNumberOfPanelsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("number_of_panels <=", value, "numberOfPanels");
            return (Criteria) this;
        }

        public Criteria andNumberOfPanelsIn(List<BigDecimal> values) {
            addCriterion("number_of_panels in", values, "numberOfPanels");
            return (Criteria) this;
        }

        public Criteria andNumberOfPanelsNotIn(List<BigDecimal> values) {
            addCriterion("number_of_panels not in", values, "numberOfPanels");
            return (Criteria) this;
        }

        public Criteria andNumberOfPanelsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("number_of_panels between", value1, value2, "numberOfPanels");
            return (Criteria) this;
        }

        public Criteria andNumberOfPanelsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("number_of_panels not between", value1, value2, "numberOfPanels");
            return (Criteria) this;
        }

        public Criteria andNumberOfPalletsIsNull() {
            addCriterion("number_of_pallets is null");
            return (Criteria) this;
        }

        public Criteria andNumberOfPalletsIsNotNull() {
            addCriterion("number_of_pallets is not null");
            return (Criteria) this;
        }

        public Criteria andNumberOfPalletsEqualTo(BigDecimal value) {
            addCriterion("number_of_pallets =", value, "numberOfPallets");
            return (Criteria) this;
        }

        public Criteria andNumberOfPalletsNotEqualTo(BigDecimal value) {
            addCriterion("number_of_pallets <>", value, "numberOfPallets");
            return (Criteria) this;
        }

        public Criteria andNumberOfPalletsGreaterThan(BigDecimal value) {
            addCriterion("number_of_pallets >", value, "numberOfPallets");
            return (Criteria) this;
        }

        public Criteria andNumberOfPalletsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("number_of_pallets >=", value, "numberOfPallets");
            return (Criteria) this;
        }

        public Criteria andNumberOfPalletsLessThan(BigDecimal value) {
            addCriterion("number_of_pallets <", value, "numberOfPallets");
            return (Criteria) this;
        }

        public Criteria andNumberOfPalletsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("number_of_pallets <=", value, "numberOfPallets");
            return (Criteria) this;
        }

        public Criteria andNumberOfPalletsIn(List<BigDecimal> values) {
            addCriterion("number_of_pallets in", values, "numberOfPallets");
            return (Criteria) this;
        }

        public Criteria andNumberOfPalletsNotIn(List<BigDecimal> values) {
            addCriterion("number_of_pallets not in", values, "numberOfPallets");
            return (Criteria) this;
        }

        public Criteria andNumberOfPalletsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("number_of_pallets between", value1, value2, "numberOfPallets");
            return (Criteria) this;
        }

        public Criteria andNumberOfPalletsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("number_of_pallets not between", value1, value2, "numberOfPallets");
            return (Criteria) this;
        }

        public Criteria andProductionDateIsNull() {
            addCriterion("production_date is null");
            return (Criteria) this;
        }

        public Criteria andProductionDateIsNotNull() {
            addCriterion("production_date is not null");
            return (Criteria) this;
        }

        public Criteria andProductionDateEqualTo(Date value) {
            addCriterion("production_date =", value, "productionDate");
            return (Criteria) this;
        }

        public Criteria andProductionDateNotEqualTo(Date value) {
            addCriterion("production_date <>", value, "productionDate");
            return (Criteria) this;
        }

        public Criteria andProductionDateGreaterThan(Date value) {
            addCriterion("production_date >", value, "productionDate");
            return (Criteria) this;
        }

        public Criteria andProductionDateGreaterThanOrEqualTo(Date value) {
            addCriterion("production_date >=", value, "productionDate");
            return (Criteria) this;
        }

        public Criteria andProductionDateLessThan(Date value) {
            addCriterion("production_date <", value, "productionDate");
            return (Criteria) this;
        }

        public Criteria andProductionDateLessThanOrEqualTo(Date value) {
            addCriterion("production_date <=", value, "productionDate");
            return (Criteria) this;
        }

        public Criteria andProductionDateIn(List<Date> values) {
            addCriterion("production_date in", values, "productionDate");
            return (Criteria) this;
        }

        public Criteria andProductionDateNotIn(List<Date> values) {
            addCriterion("production_date not in", values, "productionDate");
            return (Criteria) this;
        }

        public Criteria andProductionDateBetween(Date value1, Date value2) {
            addCriterion("production_date between", value1, value2, "productionDate");
            return (Criteria) this;
        }

        public Criteria andProductionDateNotBetween(Date value1, Date value2) {
            addCriterion("production_date not between", value1, value2, "productionDate");
            return (Criteria) this;
        }

        public Criteria andProducingAreaIsNull() {
            addCriterion("producing_area is null");
            return (Criteria) this;
        }

        public Criteria andProducingAreaIsNotNull() {
            addCriterion("producing_area is not null");
            return (Criteria) this;
        }

        public Criteria andProducingAreaEqualTo(String value) {
            addCriterion("producing_area =", value, "producingArea");
            return (Criteria) this;
        }

        public Criteria andProducingAreaNotEqualTo(String value) {
            addCriterion("producing_area <>", value, "producingArea");
            return (Criteria) this;
        }

        public Criteria andProducingAreaGreaterThan(String value) {
            addCriterion("producing_area >", value, "producingArea");
            return (Criteria) this;
        }

        public Criteria andProducingAreaGreaterThanOrEqualTo(String value) {
            addCriterion("producing_area >=", value, "producingArea");
            return (Criteria) this;
        }

        public Criteria andProducingAreaLessThan(String value) {
            addCriterion("producing_area <", value, "producingArea");
            return (Criteria) this;
        }

        public Criteria andProducingAreaLessThanOrEqualTo(String value) {
            addCriterion("producing_area <=", value, "producingArea");
            return (Criteria) this;
        }

        public Criteria andProducingAreaLike(String value) {
            addCriterion("producing_area like", value, "producingArea");
            return (Criteria) this;
        }

        public Criteria andProducingAreaNotLike(String value) {
            addCriterion("producing_area not like", value, "producingArea");
            return (Criteria) this;
        }

        public Criteria andProducingAreaIn(List<String> values) {
            addCriterion("producing_area in", values, "producingArea");
            return (Criteria) this;
        }

        public Criteria andProducingAreaNotIn(List<String> values) {
            addCriterion("producing_area not in", values, "producingArea");
            return (Criteria) this;
        }

        public Criteria andProducingAreaBetween(String value1, String value2) {
            addCriterion("producing_area between", value1, value2, "producingArea");
            return (Criteria) this;
        }

        public Criteria andProducingAreaNotBetween(String value1, String value2) {
            addCriterion("producing_area not between", value1, value2, "producingArea");
            return (Criteria) this;
        }

        public Criteria andTotalWeightIsNull() {
            addCriterion("total_weight is null");
            return (Criteria) this;
        }

        public Criteria andTotalWeightIsNotNull() {
            addCriterion("total_weight is not null");
            return (Criteria) this;
        }

        public Criteria andTotalWeightEqualTo(BigDecimal value) {
            addCriterion("total_weight =", value, "totalWeight");
            return (Criteria) this;
        }

        public Criteria andTotalWeightNotEqualTo(BigDecimal value) {
            addCriterion("total_weight <>", value, "totalWeight");
            return (Criteria) this;
        }

        public Criteria andTotalWeightGreaterThan(BigDecimal value) {
            addCriterion("total_weight >", value, "totalWeight");
            return (Criteria) this;
        }

        public Criteria andTotalWeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_weight >=", value, "totalWeight");
            return (Criteria) this;
        }

        public Criteria andTotalWeightLessThan(BigDecimal value) {
            addCriterion("total_weight <", value, "totalWeight");
            return (Criteria) this;
        }

        public Criteria andTotalWeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_weight <=", value, "totalWeight");
            return (Criteria) this;
        }

        public Criteria andTotalWeightIn(List<BigDecimal> values) {
            addCriterion("total_weight in", values, "totalWeight");
            return (Criteria) this;
        }

        public Criteria andTotalWeightNotIn(List<BigDecimal> values) {
            addCriterion("total_weight not in", values, "totalWeight");
            return (Criteria) this;
        }

        public Criteria andTotalWeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_weight between", value1, value2, "totalWeight");
            return (Criteria) this;
        }

        public Criteria andTotalWeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_weight not between", value1, value2, "totalWeight");
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

        public Criteria andGoodsAllocationIdIsNull() {
            addCriterion("goods_allocation_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsAllocationIdIsNotNull() {
            addCriterion("goods_allocation_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsAllocationIdEqualTo(Long value) {
            addCriterion("goods_allocation_id =", value, "goodsAllocationId");
            return (Criteria) this;
        }

        public Criteria andGoodsAllocationIdNotEqualTo(Long value) {
            addCriterion("goods_allocation_id <>", value, "goodsAllocationId");
            return (Criteria) this;
        }

        public Criteria andGoodsAllocationIdGreaterThan(Long value) {
            addCriterion("goods_allocation_id >", value, "goodsAllocationId");
            return (Criteria) this;
        }

        public Criteria andGoodsAllocationIdGreaterThanOrEqualTo(Long value) {
            addCriterion("goods_allocation_id >=", value, "goodsAllocationId");
            return (Criteria) this;
        }

        public Criteria andGoodsAllocationIdLessThan(Long value) {
            addCriterion("goods_allocation_id <", value, "goodsAllocationId");
            return (Criteria) this;
        }

        public Criteria andGoodsAllocationIdLessThanOrEqualTo(Long value) {
            addCriterion("goods_allocation_id <=", value, "goodsAllocationId");
            return (Criteria) this;
        }

        public Criteria andGoodsAllocationIdIn(List<Long> values) {
            addCriterion("goods_allocation_id in", values, "goodsAllocationId");
            return (Criteria) this;
        }

        public Criteria andGoodsAllocationIdNotIn(List<Long> values) {
            addCriterion("goods_allocation_id not in", values, "goodsAllocationId");
            return (Criteria) this;
        }

        public Criteria andGoodsAllocationIdBetween(Long value1, Long value2) {
            addCriterion("goods_allocation_id between", value1, value2, "goodsAllocationId");
            return (Criteria) this;
        }

        public Criteria andGoodsAllocationIdNotBetween(Long value1, Long value2) {
            addCriterion("goods_allocation_id not between", value1, value2, "goodsAllocationId");
            return (Criteria) this;
        }

        public Criteria andAnotherGoodsAllocationIdIsNull() {
            addCriterion("another_goods_allocation_id is null");
            return (Criteria) this;
        }

        public Criteria andAnotherGoodsAllocationIdIsNotNull() {
            addCriterion("another_goods_allocation_id is not null");
            return (Criteria) this;
        }

        public Criteria andAnotherGoodsAllocationIdEqualTo(Long value) {
            addCriterion("another_goods_allocation_id =", value, "anotherGoodsAllocationId");
            return (Criteria) this;
        }

        public Criteria andAnotherGoodsAllocationIdNotEqualTo(Long value) {
            addCriterion("another_goods_allocation_id <>", value, "anotherGoodsAllocationId");
            return (Criteria) this;
        }

        public Criteria andAnotherGoodsAllocationIdGreaterThan(Long value) {
            addCriterion("another_goods_allocation_id >", value, "anotherGoodsAllocationId");
            return (Criteria) this;
        }

        public Criteria andAnotherGoodsAllocationIdGreaterThanOrEqualTo(Long value) {
            addCriterion("another_goods_allocation_id >=", value, "anotherGoodsAllocationId");
            return (Criteria) this;
        }

        public Criteria andAnotherGoodsAllocationIdLessThan(Long value) {
            addCriterion("another_goods_allocation_id <", value, "anotherGoodsAllocationId");
            return (Criteria) this;
        }

        public Criteria andAnotherGoodsAllocationIdLessThanOrEqualTo(Long value) {
            addCriterion("another_goods_allocation_id <=", value, "anotherGoodsAllocationId");
            return (Criteria) this;
        }

        public Criteria andAnotherGoodsAllocationIdIn(List<Long> values) {
            addCriterion("another_goods_allocation_id in", values, "anotherGoodsAllocationId");
            return (Criteria) this;
        }

        public Criteria andAnotherGoodsAllocationIdNotIn(List<Long> values) {
            addCriterion("another_goods_allocation_id not in", values, "anotherGoodsAllocationId");
            return (Criteria) this;
        }

        public Criteria andAnotherGoodsAllocationIdBetween(Long value1, Long value2) {
            addCriterion("another_goods_allocation_id between", value1, value2, "anotherGoodsAllocationId");
            return (Criteria) this;
        }

        public Criteria andAnotherGoodsAllocationIdNotBetween(Long value1, Long value2) {
            addCriterion("another_goods_allocation_id not between", value1, value2, "anotherGoodsAllocationId");
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