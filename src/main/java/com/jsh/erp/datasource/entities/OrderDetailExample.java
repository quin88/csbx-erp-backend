package com.jsh.erp.datasource.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderDetailExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Long> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Long> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
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

        public Criteria andAquaticTypeIsNull() {
            addCriterion("aquatic_type is null");
            return (Criteria) this;
        }

        public Criteria andAquaticTypeIsNotNull() {
            addCriterion("aquatic_type is not null");
            return (Criteria) this;
        }

        public Criteria andAquaticTypeEqualTo(String value) {
            addCriterion("aquatic_type =", value, "aquaticType");
            return (Criteria) this;
        }

        public Criteria andAquaticTypeNotEqualTo(String value) {
            addCriterion("aquatic_type <>", value, "aquaticType");
            return (Criteria) this;
        }

        public Criteria andAquaticTypeGreaterThan(String value) {
            addCriterion("aquatic_type >", value, "aquaticType");
            return (Criteria) this;
        }

        public Criteria andAquaticTypeGreaterThanOrEqualTo(String value) {
            addCriterion("aquatic_type >=", value, "aquaticType");
            return (Criteria) this;
        }

        public Criteria andAquaticTypeLessThan(String value) {
            addCriterion("aquatic_type <", value, "aquaticType");
            return (Criteria) this;
        }

        public Criteria andAquaticTypeLessThanOrEqualTo(String value) {
            addCriterion("aquatic_type <=", value, "aquaticType");
            return (Criteria) this;
        }

        public Criteria andAquaticTypeLike(String value) {
            addCriterion("aquatic_type like", value, "aquaticType");
            return (Criteria) this;
        }

        public Criteria andAquaticTypeNotLike(String value) {
            addCriterion("aquatic_type not like", value, "aquaticType");
            return (Criteria) this;
        }

        public Criteria andAquaticTypeIn(List<String> values) {
            addCriterion("aquatic_type in", values, "aquaticType");
            return (Criteria) this;
        }

        public Criteria andAquaticTypeNotIn(List<String> values) {
            addCriterion("aquatic_type not in", values, "aquaticType");
            return (Criteria) this;
        }

        public Criteria andAquaticTypeBetween(String value1, String value2) {
            addCriterion("aquatic_type between", value1, value2, "aquaticType");
            return (Criteria) this;
        }

        public Criteria andAquaticTypeNotBetween(String value1, String value2) {
            addCriterion("aquatic_type not between", value1, value2, "aquaticType");
            return (Criteria) this;
        }

        public Criteria andOriginSourceIsNull() {
            addCriterion("origin_source is null");
            return (Criteria) this;
        }

        public Criteria andOriginSourceIsNotNull() {
            addCriterion("origin_source is not null");
            return (Criteria) this;
        }

        public Criteria andOriginSourceEqualTo(String value) {
            addCriterion("origin_source =", value, "originSource");
            return (Criteria) this;
        }

        public Criteria andOriginSourceNotEqualTo(String value) {
            addCriterion("origin_source <>", value, "originSource");
            return (Criteria) this;
        }

        public Criteria andOriginSourceGreaterThan(String value) {
            addCriterion("origin_source >", value, "originSource");
            return (Criteria) this;
        }

        public Criteria andOriginSourceGreaterThanOrEqualTo(String value) {
            addCriterion("origin_source >=", value, "originSource");
            return (Criteria) this;
        }

        public Criteria andOriginSourceLessThan(String value) {
            addCriterion("origin_source <", value, "originSource");
            return (Criteria) this;
        }

        public Criteria andOriginSourceLessThanOrEqualTo(String value) {
            addCriterion("origin_source <=", value, "originSource");
            return (Criteria) this;
        }

        public Criteria andOriginSourceLike(String value) {
            addCriterion("origin_source like", value, "originSource");
            return (Criteria) this;
        }

        public Criteria andOriginSourceNotLike(String value) {
            addCriterion("origin_source not like", value, "originSource");
            return (Criteria) this;
        }

        public Criteria andOriginSourceIn(List<String> values) {
            addCriterion("origin_source in", values, "originSource");
            return (Criteria) this;
        }

        public Criteria andOriginSourceNotIn(List<String> values) {
            addCriterion("origin_source not in", values, "originSource");
            return (Criteria) this;
        }

        public Criteria andOriginSourceBetween(String value1, String value2) {
            addCriterion("origin_source between", value1, value2, "originSource");
            return (Criteria) this;
        }

        public Criteria andOriginSourceNotBetween(String value1, String value2) {
            addCriterion("origin_source not between", value1, value2, "originSource");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNull() {
            addCriterion("quantity is null");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNotNull() {
            addCriterion("quantity is not null");
            return (Criteria) this;
        }

        public Criteria andQuantityEqualTo(BigDecimal value) {
            addCriterion("quantity =", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotEqualTo(BigDecimal value) {
            addCriterion("quantity <>", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThan(BigDecimal value) {
            addCriterion("quantity >", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("quantity >=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThan(BigDecimal value) {
            addCriterion("quantity <", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThanOrEqualTo(BigDecimal value) {
            addCriterion("quantity <=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityIn(List<BigDecimal> values) {
            addCriterion("quantity in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotIn(List<BigDecimal> values) {
            addCriterion("quantity not in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("quantity between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("quantity not between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("unit like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("unit not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("unit not between", value1, value2, "unit");
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

        public Criteria andNakedPriceIsNull() {
            addCriterion("naked_price is null");
            return (Criteria) this;
        }

        public Criteria andNakedPriceIsNotNull() {
            addCriterion("naked_price is not null");
            return (Criteria) this;
        }

        public Criteria andNakedPriceEqualTo(BigDecimal value) {
            addCriterion("naked_price =", value, "nakedPrice");
            return (Criteria) this;
        }

        public Criteria andNakedPriceNotEqualTo(BigDecimal value) {
            addCriterion("naked_price <>", value, "nakedPrice");
            return (Criteria) this;
        }

        public Criteria andNakedPriceGreaterThan(BigDecimal value) {
            addCriterion("naked_price >", value, "nakedPrice");
            return (Criteria) this;
        }

        public Criteria andNakedPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("naked_price >=", value, "nakedPrice");
            return (Criteria) this;
        }

        public Criteria andNakedPriceLessThan(BigDecimal value) {
            addCriterion("naked_price <", value, "nakedPrice");
            return (Criteria) this;
        }

        public Criteria andNakedPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("naked_price <=", value, "nakedPrice");
            return (Criteria) this;
        }

        public Criteria andNakedPriceIn(List<BigDecimal> values) {
            addCriterion("naked_price in", values, "nakedPrice");
            return (Criteria) this;
        }

        public Criteria andNakedPriceNotIn(List<BigDecimal> values) {
            addCriterion("naked_price not in", values, "nakedPrice");
            return (Criteria) this;
        }

        public Criteria andNakedPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("naked_price between", value1, value2, "nakedPrice");
            return (Criteria) this;
        }

        public Criteria andNakedPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("naked_price not between", value1, value2, "nakedPrice");
            return (Criteria) this;
        }

        public Criteria andTaxNakedPriceIsNull() {
            addCriterion("tax_naked_price is null");
            return (Criteria) this;
        }

        public Criteria andTaxNakedPriceIsNotNull() {
            addCriterion("tax_naked_price is not null");
            return (Criteria) this;
        }

        public Criteria andTaxNakedPriceEqualTo(BigDecimal value) {
            addCriterion("tax_naked_price =", value, "taxNakedPrice");
            return (Criteria) this;
        }

        public Criteria andTaxNakedPriceNotEqualTo(BigDecimal value) {
            addCriterion("tax_naked_price <>", value, "taxNakedPrice");
            return (Criteria) this;
        }

        public Criteria andTaxNakedPriceGreaterThan(BigDecimal value) {
            addCriterion("tax_naked_price >", value, "taxNakedPrice");
            return (Criteria) this;
        }

        public Criteria andTaxNakedPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_naked_price >=", value, "taxNakedPrice");
            return (Criteria) this;
        }

        public Criteria andTaxNakedPriceLessThan(BigDecimal value) {
            addCriterion("tax_naked_price <", value, "taxNakedPrice");
            return (Criteria) this;
        }

        public Criteria andTaxNakedPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_naked_price <=", value, "taxNakedPrice");
            return (Criteria) this;
        }

        public Criteria andTaxNakedPriceIn(List<BigDecimal> values) {
            addCriterion("tax_naked_price in", values, "taxNakedPrice");
            return (Criteria) this;
        }

        public Criteria andTaxNakedPriceNotIn(List<BigDecimal> values) {
            addCriterion("tax_naked_price not in", values, "taxNakedPrice");
            return (Criteria) this;
        }

        public Criteria andTaxNakedPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_naked_price between", value1, value2, "taxNakedPrice");
            return (Criteria) this;
        }

        public Criteria andTaxNakedPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_naked_price not between", value1, value2, "taxNakedPrice");
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

        public Criteria andAccountIdIsNull() {
            addCriterion("account_id is null");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNotNull() {
            addCriterion("account_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccountIdEqualTo(Long value) {
            addCriterion("account_id =", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotEqualTo(Long value) {
            addCriterion("account_id <>", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThan(Long value) {
            addCriterion("account_id >", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThanOrEqualTo(Long value) {
            addCriterion("account_id >=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThan(Long value) {
            addCriterion("account_id <", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThanOrEqualTo(Long value) {
            addCriterion("account_id <=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIn(List<Long> values) {
            addCriterion("account_id in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotIn(List<Long> values) {
            addCriterion("account_id not in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdBetween(Long value1, Long value2) {
            addCriterion("account_id between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotBetween(Long value1, Long value2) {
            addCriterion("account_id not between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNull() {
            addCriterion("bank_name is null");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNotNull() {
            addCriterion("bank_name is not null");
            return (Criteria) this;
        }

        public Criteria andBankNameEqualTo(String value) {
            addCriterion("bank_name =", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotEqualTo(String value) {
            addCriterion("bank_name <>", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThan(String value) {
            addCriterion("bank_name >", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("bank_name >=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThan(String value) {
            addCriterion("bank_name <", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThanOrEqualTo(String value) {
            addCriterion("bank_name <=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLike(String value) {
            addCriterion("bank_name like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotLike(String value) {
            addCriterion("bank_name not like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameIn(List<String> values) {
            addCriterion("bank_name in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotIn(List<String> values) {
            addCriterion("bank_name not in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameBetween(String value1, String value2) {
            addCriterion("bank_name between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotBetween(String value1, String value2) {
            addCriterion("bank_name not between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andAccountNameIsNull() {
            addCriterion("account_name is null");
            return (Criteria) this;
        }

        public Criteria andAccountNameIsNotNull() {
            addCriterion("account_name is not null");
            return (Criteria) this;
        }

        public Criteria andAccountNameEqualTo(String value) {
            addCriterion("account_name =", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotEqualTo(String value) {
            addCriterion("account_name <>", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameGreaterThan(String value) {
            addCriterion("account_name >", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameGreaterThanOrEqualTo(String value) {
            addCriterion("account_name >=", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameLessThan(String value) {
            addCriterion("account_name <", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameLessThanOrEqualTo(String value) {
            addCriterion("account_name <=", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameLike(String value) {
            addCriterion("account_name like", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotLike(String value) {
            addCriterion("account_name not like", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameIn(List<String> values) {
            addCriterion("account_name in", values, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotIn(List<String> values) {
            addCriterion("account_name not in", values, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameBetween(String value1, String value2) {
            addCriterion("account_name between", value1, value2, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotBetween(String value1, String value2) {
            addCriterion("account_name not between", value1, value2, "accountName");
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

        public Criteria andDifferenceIsNull() {
            addCriterion("difference is null");
            return (Criteria) this;
        }

        public Criteria andDifferenceIsNotNull() {
            addCriterion("difference is not null");
            return (Criteria) this;
        }

        public Criteria andDifferenceEqualTo(BigDecimal value) {
            addCriterion("difference =", value, "difference");
            return (Criteria) this;
        }

        public Criteria andDifferenceNotEqualTo(BigDecimal value) {
            addCriterion("difference <>", value, "difference");
            return (Criteria) this;
        }

        public Criteria andDifferenceGreaterThan(BigDecimal value) {
            addCriterion("difference >", value, "difference");
            return (Criteria) this;
        }

        public Criteria andDifferenceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("difference >=", value, "difference");
            return (Criteria) this;
        }

        public Criteria andDifferenceLessThan(BigDecimal value) {
            addCriterion("difference <", value, "difference");
            return (Criteria) this;
        }

        public Criteria andDifferenceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("difference <=", value, "difference");
            return (Criteria) this;
        }

        public Criteria andDifferenceIn(List<BigDecimal> values) {
            addCriterion("difference in", values, "difference");
            return (Criteria) this;
        }

        public Criteria andDifferenceNotIn(List<BigDecimal> values) {
            addCriterion("difference not in", values, "difference");
            return (Criteria) this;
        }

        public Criteria andDifferenceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("difference between", value1, value2, "difference");
            return (Criteria) this;
        }

        public Criteria andDifferenceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("difference not between", value1, value2, "difference");
            return (Criteria) this;
        }

        public Criteria andSupplementaryAmountIsNull() {
            addCriterion("supplementary_amount is null");
            return (Criteria) this;
        }

        public Criteria andSupplementaryAmountIsNotNull() {
            addCriterion("supplementary_amount is not null");
            return (Criteria) this;
        }

        public Criteria andSupplementaryAmountEqualTo(BigDecimal value) {
            addCriterion("supplementary_amount =", value, "supplementaryAmount");
            return (Criteria) this;
        }

        public Criteria andSupplementaryAmountNotEqualTo(BigDecimal value) {
            addCriterion("supplementary_amount <>", value, "supplementaryAmount");
            return (Criteria) this;
        }

        public Criteria andSupplementaryAmountGreaterThan(BigDecimal value) {
            addCriterion("supplementary_amount >", value, "supplementaryAmount");
            return (Criteria) this;
        }

        public Criteria andSupplementaryAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("supplementary_amount >=", value, "supplementaryAmount");
            return (Criteria) this;
        }

        public Criteria andSupplementaryAmountLessThan(BigDecimal value) {
            addCriterion("supplementary_amount <", value, "supplementaryAmount");
            return (Criteria) this;
        }

        public Criteria andSupplementaryAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("supplementary_amount <=", value, "supplementaryAmount");
            return (Criteria) this;
        }

        public Criteria andSupplementaryAmountIn(List<BigDecimal> values) {
            addCriterion("supplementary_amount in", values, "supplementaryAmount");
            return (Criteria) this;
        }

        public Criteria andSupplementaryAmountNotIn(List<BigDecimal> values) {
            addCriterion("supplementary_amount not in", values, "supplementaryAmount");
            return (Criteria) this;
        }

        public Criteria andSupplementaryAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("supplementary_amount between", value1, value2, "supplementaryAmount");
            return (Criteria) this;
        }

        public Criteria andSupplementaryAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("supplementary_amount not between", value1, value2, "supplementaryAmount");
            return (Criteria) this;
        }

        public Criteria andDownloadStatusIsNull() {
            addCriterion("download_status is null");
            return (Criteria) this;
        }

        public Criteria andDownloadStatusIsNotNull() {
            addCriterion("download_status is not null");
            return (Criteria) this;
        }

        public Criteria andDownloadStatusEqualTo(String value) {
            addCriterion("download_status =", value, "downloadStatus");
            return (Criteria) this;
        }

        public Criteria andDownloadStatusNotEqualTo(String value) {
            addCriterion("download_status <>", value, "downloadStatus");
            return (Criteria) this;
        }

        public Criteria andDownloadStatusGreaterThan(String value) {
            addCriterion("download_status >", value, "downloadStatus");
            return (Criteria) this;
        }

        public Criteria andDownloadStatusGreaterThanOrEqualTo(String value) {
            addCriterion("download_status >=", value, "downloadStatus");
            return (Criteria) this;
        }

        public Criteria andDownloadStatusLessThan(String value) {
            addCriterion("download_status <", value, "downloadStatus");
            return (Criteria) this;
        }

        public Criteria andDownloadStatusLessThanOrEqualTo(String value) {
            addCriterion("download_status <=", value, "downloadStatus");
            return (Criteria) this;
        }

        public Criteria andDownloadStatusLike(String value) {
            addCriterion("download_status like", value, "downloadStatus");
            return (Criteria) this;
        }

        public Criteria andDownloadStatusNotLike(String value) {
            addCriterion("download_status not like", value, "downloadStatus");
            return (Criteria) this;
        }

        public Criteria andDownloadStatusIn(List<String> values) {
            addCriterion("download_status in", values, "downloadStatus");
            return (Criteria) this;
        }

        public Criteria andDownloadStatusNotIn(List<String> values) {
            addCriterion("download_status not in", values, "downloadStatus");
            return (Criteria) this;
        }

        public Criteria andDownloadStatusBetween(String value1, String value2) {
            addCriterion("download_status between", value1, value2, "downloadStatus");
            return (Criteria) this;
        }

        public Criteria andDownloadStatusNotBetween(String value1, String value2) {
            addCriterion("download_status not between", value1, value2, "downloadStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusIsNull() {
            addCriterion("payment_status is null");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusIsNotNull() {
            addCriterion("payment_status is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusEqualTo(String value) {
            addCriterion("payment_status =", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusNotEqualTo(String value) {
            addCriterion("payment_status <>", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusGreaterThan(String value) {
            addCriterion("payment_status >", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusGreaterThanOrEqualTo(String value) {
            addCriterion("payment_status >=", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusLessThan(String value) {
            addCriterion("payment_status <", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusLessThanOrEqualTo(String value) {
            addCriterion("payment_status <=", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusLike(String value) {
            addCriterion("payment_status like", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusNotLike(String value) {
            addCriterion("payment_status not like", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusIn(List<String> values) {
            addCriterion("payment_status in", values, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusNotIn(List<String> values) {
            addCriterion("payment_status not in", values, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusBetween(String value1, String value2) {
            addCriterion("payment_status between", value1, value2, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusNotBetween(String value1, String value2) {
            addCriterion("payment_status not between", value1, value2, "paymentStatus");
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