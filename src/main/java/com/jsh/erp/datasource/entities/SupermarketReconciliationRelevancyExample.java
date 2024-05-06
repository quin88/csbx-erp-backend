package com.jsh.erp.datasource.entities;

import java.util.ArrayList;
import java.util.List;

public class SupermarketReconciliationRelevancyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SupermarketReconciliationRelevancyExample() {
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

        public Criteria andSupermarketReconciliationIdIsNull() {
            addCriterion("supermarket_reconciliation_id is null");
            return (Criteria) this;
        }

        public Criteria andSupermarketReconciliationIdIsNotNull() {
            addCriterion("supermarket_reconciliation_id is not null");
            return (Criteria) this;
        }

        public Criteria andSupermarketReconciliationIdEqualTo(Long value) {
            addCriterion("supermarket_reconciliation_id =", value, "supermarketReconciliationId");
            return (Criteria) this;
        }

        public Criteria andSupermarketReconciliationIdNotEqualTo(Long value) {
            addCriterion("supermarket_reconciliation_id <>", value, "supermarketReconciliationId");
            return (Criteria) this;
        }

        public Criteria andSupermarketReconciliationIdGreaterThan(Long value) {
            addCriterion("supermarket_reconciliation_id >", value, "supermarketReconciliationId");
            return (Criteria) this;
        }

        public Criteria andSupermarketReconciliationIdGreaterThanOrEqualTo(Long value) {
            addCriterion("supermarket_reconciliation_id >=", value, "supermarketReconciliationId");
            return (Criteria) this;
        }

        public Criteria andSupermarketReconciliationIdLessThan(Long value) {
            addCriterion("supermarket_reconciliation_id <", value, "supermarketReconciliationId");
            return (Criteria) this;
        }

        public Criteria andSupermarketReconciliationIdLessThanOrEqualTo(Long value) {
            addCriterion("supermarket_reconciliation_id <=", value, "supermarketReconciliationId");
            return (Criteria) this;
        }

        public Criteria andSupermarketReconciliationIdIn(List<Long> values) {
            addCriterion("supermarket_reconciliation_id in", values, "supermarketReconciliationId");
            return (Criteria) this;
        }

        public Criteria andSupermarketReconciliationIdNotIn(List<Long> values) {
            addCriterion("supermarket_reconciliation_id not in", values, "supermarketReconciliationId");
            return (Criteria) this;
        }

        public Criteria andSupermarketReconciliationIdBetween(Long value1, Long value2) {
            addCriterion("supermarket_reconciliation_id between", value1, value2, "supermarketReconciliationId");
            return (Criteria) this;
        }

        public Criteria andSupermarketReconciliationIdNotBetween(Long value1, Long value2) {
            addCriterion("supermarket_reconciliation_id not between", value1, value2, "supermarketReconciliationId");
            return (Criteria) this;
        }

        public Criteria andSupermarketOrderIdIsNull() {
            addCriterion("supermarket_order_id is null");
            return (Criteria) this;
        }

        public Criteria andSupermarketOrderIdIsNotNull() {
            addCriterion("supermarket_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andSupermarketOrderIdEqualTo(Long value) {
            addCriterion("supermarket_order_id =", value, "supermarketOrderId");
            return (Criteria) this;
        }

        public Criteria andSupermarketOrderIdNotEqualTo(Long value) {
            addCriterion("supermarket_order_id <>", value, "supermarketOrderId");
            return (Criteria) this;
        }

        public Criteria andSupermarketOrderIdGreaterThan(Long value) {
            addCriterion("supermarket_order_id >", value, "supermarketOrderId");
            return (Criteria) this;
        }

        public Criteria andSupermarketOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("supermarket_order_id >=", value, "supermarketOrderId");
            return (Criteria) this;
        }

        public Criteria andSupermarketOrderIdLessThan(Long value) {
            addCriterion("supermarket_order_id <", value, "supermarketOrderId");
            return (Criteria) this;
        }

        public Criteria andSupermarketOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("supermarket_order_id <=", value, "supermarketOrderId");
            return (Criteria) this;
        }

        public Criteria andSupermarketOrderIdIn(List<Long> values) {
            addCriterion("supermarket_order_id in", values, "supermarketOrderId");
            return (Criteria) this;
        }

        public Criteria andSupermarketOrderIdNotIn(List<Long> values) {
            addCriterion("supermarket_order_id not in", values, "supermarketOrderId");
            return (Criteria) this;
        }

        public Criteria andSupermarketOrderIdBetween(Long value1, Long value2) {
            addCriterion("supermarket_order_id between", value1, value2, "supermarketOrderId");
            return (Criteria) this;
        }

        public Criteria andSupermarketOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("supermarket_order_id not between", value1, value2, "supermarketOrderId");
            return (Criteria) this;
        }

        public Criteria andSupermarketOrderNumberIsNull() {
            addCriterion("supermarket_order_number is null");
            return (Criteria) this;
        }

        public Criteria andSupermarketOrderNumberIsNotNull() {
            addCriterion("supermarket_order_number is not null");
            return (Criteria) this;
        }

        public Criteria andSupermarketOrderNumberEqualTo(String value) {
            addCriterion("supermarket_order_number =", value, "supermarketOrderNumber");
            return (Criteria) this;
        }

        public Criteria andSupermarketOrderNumberNotEqualTo(String value) {
            addCriterion("supermarket_order_number <>", value, "supermarketOrderNumber");
            return (Criteria) this;
        }

        public Criteria andSupermarketOrderNumberGreaterThan(String value) {
            addCriterion("supermarket_order_number >", value, "supermarketOrderNumber");
            return (Criteria) this;
        }

        public Criteria andSupermarketOrderNumberGreaterThanOrEqualTo(String value) {
            addCriterion("supermarket_order_number >=", value, "supermarketOrderNumber");
            return (Criteria) this;
        }

        public Criteria andSupermarketOrderNumberLessThan(String value) {
            addCriterion("supermarket_order_number <", value, "supermarketOrderNumber");
            return (Criteria) this;
        }

        public Criteria andSupermarketOrderNumberLessThanOrEqualTo(String value) {
            addCriterion("supermarket_order_number <=", value, "supermarketOrderNumber");
            return (Criteria) this;
        }

        public Criteria andSupermarketOrderNumberLike(String value) {
            addCriterion("supermarket_order_number like", value, "supermarketOrderNumber");
            return (Criteria) this;
        }

        public Criteria andSupermarketOrderNumberNotLike(String value) {
            addCriterion("supermarket_order_number not like", value, "supermarketOrderNumber");
            return (Criteria) this;
        }

        public Criteria andSupermarketOrderNumberIn(List<String> values) {
            addCriterion("supermarket_order_number in", values, "supermarketOrderNumber");
            return (Criteria) this;
        }

        public Criteria andSupermarketOrderNumberNotIn(List<String> values) {
            addCriterion("supermarket_order_number not in", values, "supermarketOrderNumber");
            return (Criteria) this;
        }

        public Criteria andSupermarketOrderNumberBetween(String value1, String value2) {
            addCriterion("supermarket_order_number between", value1, value2, "supermarketOrderNumber");
            return (Criteria) this;
        }

        public Criteria andSupermarketOrderNumberNotBetween(String value1, String value2) {
            addCriterion("supermarket_order_number not between", value1, value2, "supermarketOrderNumber");
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