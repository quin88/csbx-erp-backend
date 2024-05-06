package com.jsh.erp.datasource.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DepotHeadExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DepotHeadExample() {
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

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andSubTypeIsNull() {
            addCriterion("sub_type is null");
            return (Criteria) this;
        }

        public Criteria andSubTypeIsNotNull() {
            addCriterion("sub_type is not null");
            return (Criteria) this;
        }

        public Criteria andSubTypeEqualTo(String value) {
            addCriterion("sub_type =", value, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeNotEqualTo(String value) {
            addCriterion("sub_type <>", value, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeGreaterThan(String value) {
            addCriterion("sub_type >", value, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeGreaterThanOrEqualTo(String value) {
            addCriterion("sub_type >=", value, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeLessThan(String value) {
            addCriterion("sub_type <", value, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeLessThanOrEqualTo(String value) {
            addCriterion("sub_type <=", value, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeLike(String value) {
            addCriterion("sub_type like", value, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeNotLike(String value) {
            addCriterion("sub_type not like", value, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeIn(List<String> values) {
            addCriterion("sub_type in", values, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeNotIn(List<String> values) {
            addCriterion("sub_type not in", values, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeBetween(String value1, String value2) {
            addCriterion("sub_type between", value1, value2, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeNotBetween(String value1, String value2) {
            addCriterion("sub_type not between", value1, value2, "subType");
            return (Criteria) this;
        }

        public Criteria andDefaultNumberIsNull() {
            addCriterion("default_number is null");
            return (Criteria) this;
        }

        public Criteria andDefaultNumberIsNotNull() {
            addCriterion("default_number is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultNumberEqualTo(String value) {
            addCriterion("default_number =", value, "defaultNumber");
            return (Criteria) this;
        }

        public Criteria andDefaultNumberNotEqualTo(String value) {
            addCriterion("default_number <>", value, "defaultNumber");
            return (Criteria) this;
        }

        public Criteria andDefaultNumberGreaterThan(String value) {
            addCriterion("default_number >", value, "defaultNumber");
            return (Criteria) this;
        }

        public Criteria andDefaultNumberGreaterThanOrEqualTo(String value) {
            addCriterion("default_number >=", value, "defaultNumber");
            return (Criteria) this;
        }

        public Criteria andDefaultNumberLessThan(String value) {
            addCriterion("default_number <", value, "defaultNumber");
            return (Criteria) this;
        }

        public Criteria andDefaultNumberLessThanOrEqualTo(String value) {
            addCriterion("default_number <=", value, "defaultNumber");
            return (Criteria) this;
        }

        public Criteria andDefaultNumberLike(String value) {
            addCriterion("default_number like", value, "defaultNumber");
            return (Criteria) this;
        }

        public Criteria andDefaultNumberNotLike(String value) {
            addCriterion("default_number not like", value, "defaultNumber");
            return (Criteria) this;
        }

        public Criteria andDefaultNumberIn(List<String> values) {
            addCriterion("default_number in", values, "defaultNumber");
            return (Criteria) this;
        }

        public Criteria andDefaultNumberNotIn(List<String> values) {
            addCriterion("default_number not in", values, "defaultNumber");
            return (Criteria) this;
        }

        public Criteria andDefaultNumberBetween(String value1, String value2) {
            addCriterion("default_number between", value1, value2, "defaultNumber");
            return (Criteria) this;
        }

        public Criteria andDefaultNumberNotBetween(String value1, String value2) {
            addCriterion("default_number not between", value1, value2, "defaultNumber");
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

        public Criteria andOperTimeIsNull() {
            addCriterion("oper_time is null");
            return (Criteria) this;
        }

        public Criteria andOperTimeIsNotNull() {
            addCriterion("oper_time is not null");
            return (Criteria) this;
        }

        public Criteria andOperTimeEqualTo(Date value) {
            addCriterion("oper_time =", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeNotEqualTo(Date value) {
            addCriterion("oper_time <>", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeGreaterThan(Date value) {
            addCriterion("oper_time >", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("oper_time >=", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeLessThan(Date value) {
            addCriterion("oper_time <", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeLessThanOrEqualTo(Date value) {
            addCriterion("oper_time <=", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeIn(List<Date> values) {
            addCriterion("oper_time in", values, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeNotIn(List<Date> values) {
            addCriterion("oper_time not in", values, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeBetween(Date value1, Date value2) {
            addCriterion("oper_time between", value1, value2, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeNotBetween(Date value1, Date value2) {
            addCriterion("oper_time not between", value1, value2, "operTime");
            return (Criteria) this;
        }

        public Criteria andOrganIdIsNull() {
            addCriterion("organ_id is null");
            return (Criteria) this;
        }

        public Criteria andOrganIdIsNotNull() {
            addCriterion("organ_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrganIdEqualTo(Long value) {
            addCriterion("organ_id =", value, "organId");
            return (Criteria) this;
        }

        public Criteria andOrganIdNotEqualTo(Long value) {
            addCriterion("organ_id <>", value, "organId");
            return (Criteria) this;
        }

        public Criteria andOrganIdGreaterThan(Long value) {
            addCriterion("organ_id >", value, "organId");
            return (Criteria) this;
        }

        public Criteria andOrganIdGreaterThanOrEqualTo(Long value) {
            addCriterion("organ_id >=", value, "organId");
            return (Criteria) this;
        }

        public Criteria andOrganIdLessThan(Long value) {
            addCriterion("organ_id <", value, "organId");
            return (Criteria) this;
        }

        public Criteria andOrganIdLessThanOrEqualTo(Long value) {
            addCriterion("organ_id <=", value, "organId");
            return (Criteria) this;
        }

        public Criteria andOrganIdIn(List<Long> values) {
            addCriterion("organ_id in", values, "organId");
            return (Criteria) this;
        }

        public Criteria andOrganIdNotIn(List<Long> values) {
            addCriterion("organ_id not in", values, "organId");
            return (Criteria) this;
        }

        public Criteria andOrganIdBetween(Long value1, Long value2) {
            addCriterion("organ_id between", value1, value2, "organId");
            return (Criteria) this;
        }

        public Criteria andOrganIdNotBetween(Long value1, Long value2) {
            addCriterion("organ_id not between", value1, value2, "organId");
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

        public Criteria andChangeAmountIsNull() {
            addCriterion("change_amount is null");
            return (Criteria) this;
        }

        public Criteria andChangeAmountIsNotNull() {
            addCriterion("change_amount is not null");
            return (Criteria) this;
        }

        public Criteria andChangeAmountEqualTo(BigDecimal value) {
            addCriterion("change_amount =", value, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andChangeAmountNotEqualTo(BigDecimal value) {
            addCriterion("change_amount <>", value, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andChangeAmountGreaterThan(BigDecimal value) {
            addCriterion("change_amount >", value, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andChangeAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("change_amount >=", value, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andChangeAmountLessThan(BigDecimal value) {
            addCriterion("change_amount <", value, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andChangeAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("change_amount <=", value, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andChangeAmountIn(List<BigDecimal> values) {
            addCriterion("change_amount in", values, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andChangeAmountNotIn(List<BigDecimal> values) {
            addCriterion("change_amount not in", values, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andChangeAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("change_amount between", value1, value2, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andChangeAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("change_amount not between", value1, value2, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andBackAmountIsNull() {
            addCriterion("back_amount is null");
            return (Criteria) this;
        }

        public Criteria andBackAmountIsNotNull() {
            addCriterion("back_amount is not null");
            return (Criteria) this;
        }

        public Criteria andBackAmountEqualTo(BigDecimal value) {
            addCriterion("back_amount =", value, "backAmount");
            return (Criteria) this;
        }

        public Criteria andBackAmountNotEqualTo(BigDecimal value) {
            addCriterion("back_amount <>", value, "backAmount");
            return (Criteria) this;
        }

        public Criteria andBackAmountGreaterThan(BigDecimal value) {
            addCriterion("back_amount >", value, "backAmount");
            return (Criteria) this;
        }

        public Criteria andBackAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("back_amount >=", value, "backAmount");
            return (Criteria) this;
        }

        public Criteria andBackAmountLessThan(BigDecimal value) {
            addCriterion("back_amount <", value, "backAmount");
            return (Criteria) this;
        }

        public Criteria andBackAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("back_amount <=", value, "backAmount");
            return (Criteria) this;
        }

        public Criteria andBackAmountIn(List<BigDecimal> values) {
            addCriterion("back_amount in", values, "backAmount");
            return (Criteria) this;
        }

        public Criteria andBackAmountNotIn(List<BigDecimal> values) {
            addCriterion("back_amount not in", values, "backAmount");
            return (Criteria) this;
        }

        public Criteria andBackAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("back_amount between", value1, value2, "backAmount");
            return (Criteria) this;
        }

        public Criteria andBackAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("back_amount not between", value1, value2, "backAmount");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNull() {
            addCriterion("total_price is null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNotNull() {
            addCriterion("total_price is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceEqualTo(BigDecimal value) {
            addCriterion("total_price =", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotEqualTo(BigDecimal value) {
            addCriterion("total_price <>", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThan(BigDecimal value) {
            addCriterion("total_price >", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_price >=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThan(BigDecimal value) {
            addCriterion("total_price <", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_price <=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIn(List<BigDecimal> values) {
            addCriterion("total_price in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotIn(List<BigDecimal> values) {
            addCriterion("total_price not in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_price between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_price not between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNull() {
            addCriterion("pay_type is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("pay_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(String value) {
            addCriterion("pay_type =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(String value) {
            addCriterion("pay_type <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(String value) {
            addCriterion("pay_type >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pay_type >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(String value) {
            addCriterion("pay_type <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(String value) {
            addCriterion("pay_type <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLike(String value) {
            addCriterion("pay_type like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotLike(String value) {
            addCriterion("pay_type not like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<String> values) {
            addCriterion("pay_type in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<String> values) {
            addCriterion("pay_type not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(String value1, String value2) {
            addCriterion("pay_type between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(String value1, String value2) {
            addCriterion("pay_type not between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andBillTypeIsNull() {
            addCriterion("bill_type is null");
            return (Criteria) this;
        }

        public Criteria andBillTypeIsNotNull() {
            addCriterion("bill_type is not null");
            return (Criteria) this;
        }

        public Criteria andBillTypeEqualTo(String value) {
            addCriterion("bill_type =", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeNotEqualTo(String value) {
            addCriterion("bill_type <>", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeGreaterThan(String value) {
            addCriterion("bill_type >", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeGreaterThanOrEqualTo(String value) {
            addCriterion("bill_type >=", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeLessThan(String value) {
            addCriterion("bill_type <", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeLessThanOrEqualTo(String value) {
            addCriterion("bill_type <=", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeLike(String value) {
            addCriterion("bill_type like", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeNotLike(String value) {
            addCriterion("bill_type not like", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeIn(List<String> values) {
            addCriterion("bill_type in", values, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeNotIn(List<String> values) {
            addCriterion("bill_type not in", values, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeBetween(String value1, String value2) {
            addCriterion("bill_type between", value1, value2, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeNotBetween(String value1, String value2) {
            addCriterion("bill_type not between", value1, value2, "billType");
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

        public Criteria andFileNameIsNull() {
            addCriterion("file_name is null");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNotNull() {
            addCriterion("file_name is not null");
            return (Criteria) this;
        }

        public Criteria andFileNameEqualTo(String value) {
            addCriterion("file_name =", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotEqualTo(String value) {
            addCriterion("file_name <>", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThan(String value) {
            addCriterion("file_name >", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("file_name >=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThan(String value) {
            addCriterion("file_name <", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThanOrEqualTo(String value) {
            addCriterion("file_name <=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLike(String value) {
            addCriterion("file_name like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotLike(String value) {
            addCriterion("file_name not like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameIn(List<String> values) {
            addCriterion("file_name in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotIn(List<String> values) {
            addCriterion("file_name not in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameBetween(String value1, String value2) {
            addCriterion("file_name between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotBetween(String value1, String value2) {
            addCriterion("file_name not between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andSalesManIsNull() {
            addCriterion("sales_man is null");
            return (Criteria) this;
        }

        public Criteria andSalesManIsNotNull() {
            addCriterion("sales_man is not null");
            return (Criteria) this;
        }

        public Criteria andSalesManEqualTo(String value) {
            addCriterion("sales_man =", value, "salesMan");
            return (Criteria) this;
        }

        public Criteria andSalesManNotEqualTo(String value) {
            addCriterion("sales_man <>", value, "salesMan");
            return (Criteria) this;
        }

        public Criteria andSalesManGreaterThan(String value) {
            addCriterion("sales_man >", value, "salesMan");
            return (Criteria) this;
        }

        public Criteria andSalesManGreaterThanOrEqualTo(String value) {
            addCriterion("sales_man >=", value, "salesMan");
            return (Criteria) this;
        }

        public Criteria andSalesManLessThan(String value) {
            addCriterion("sales_man <", value, "salesMan");
            return (Criteria) this;
        }

        public Criteria andSalesManLessThanOrEqualTo(String value) {
            addCriterion("sales_man <=", value, "salesMan");
            return (Criteria) this;
        }

        public Criteria andSalesManLike(String value) {
            addCriterion("sales_man like", value, "salesMan");
            return (Criteria) this;
        }

        public Criteria andSalesManNotLike(String value) {
            addCriterion("sales_man not like", value, "salesMan");
            return (Criteria) this;
        }

        public Criteria andSalesManIn(List<String> values) {
            addCriterion("sales_man in", values, "salesMan");
            return (Criteria) this;
        }

        public Criteria andSalesManNotIn(List<String> values) {
            addCriterion("sales_man not in", values, "salesMan");
            return (Criteria) this;
        }

        public Criteria andSalesManBetween(String value1, String value2) {
            addCriterion("sales_man between", value1, value2, "salesMan");
            return (Criteria) this;
        }

        public Criteria andSalesManNotBetween(String value1, String value2) {
            addCriterion("sales_man not between", value1, value2, "salesMan");
            return (Criteria) this;
        }

        public Criteria andAccountIdListIsNull() {
            addCriterion("account_id_list is null");
            return (Criteria) this;
        }

        public Criteria andAccountIdListIsNotNull() {
            addCriterion("account_id_list is not null");
            return (Criteria) this;
        }

        public Criteria andAccountIdListEqualTo(String value) {
            addCriterion("account_id_list =", value, "accountIdList");
            return (Criteria) this;
        }

        public Criteria andAccountIdListNotEqualTo(String value) {
            addCriterion("account_id_list <>", value, "accountIdList");
            return (Criteria) this;
        }

        public Criteria andAccountIdListGreaterThan(String value) {
            addCriterion("account_id_list >", value, "accountIdList");
            return (Criteria) this;
        }

        public Criteria andAccountIdListGreaterThanOrEqualTo(String value) {
            addCriterion("account_id_list >=", value, "accountIdList");
            return (Criteria) this;
        }

        public Criteria andAccountIdListLessThan(String value) {
            addCriterion("account_id_list <", value, "accountIdList");
            return (Criteria) this;
        }

        public Criteria andAccountIdListLessThanOrEqualTo(String value) {
            addCriterion("account_id_list <=", value, "accountIdList");
            return (Criteria) this;
        }

        public Criteria andAccountIdListLike(String value) {
            addCriterion("account_id_list like", value, "accountIdList");
            return (Criteria) this;
        }

        public Criteria andAccountIdListNotLike(String value) {
            addCriterion("account_id_list not like", value, "accountIdList");
            return (Criteria) this;
        }

        public Criteria andAccountIdListIn(List<String> values) {
            addCriterion("account_id_list in", values, "accountIdList");
            return (Criteria) this;
        }

        public Criteria andAccountIdListNotIn(List<String> values) {
            addCriterion("account_id_list not in", values, "accountIdList");
            return (Criteria) this;
        }

        public Criteria andAccountIdListBetween(String value1, String value2) {
            addCriterion("account_id_list between", value1, value2, "accountIdList");
            return (Criteria) this;
        }

        public Criteria andAccountIdListNotBetween(String value1, String value2) {
            addCriterion("account_id_list not between", value1, value2, "accountIdList");
            return (Criteria) this;
        }

        public Criteria andAccountMoneyListIsNull() {
            addCriterion("account_money_list is null");
            return (Criteria) this;
        }

        public Criteria andAccountMoneyListIsNotNull() {
            addCriterion("account_money_list is not null");
            return (Criteria) this;
        }

        public Criteria andAccountMoneyListEqualTo(String value) {
            addCriterion("account_money_list =", value, "accountMoneyList");
            return (Criteria) this;
        }

        public Criteria andAccountMoneyListNotEqualTo(String value) {
            addCriterion("account_money_list <>", value, "accountMoneyList");
            return (Criteria) this;
        }

        public Criteria andAccountMoneyListGreaterThan(String value) {
            addCriterion("account_money_list >", value, "accountMoneyList");
            return (Criteria) this;
        }

        public Criteria andAccountMoneyListGreaterThanOrEqualTo(String value) {
            addCriterion("account_money_list >=", value, "accountMoneyList");
            return (Criteria) this;
        }

        public Criteria andAccountMoneyListLessThan(String value) {
            addCriterion("account_money_list <", value, "accountMoneyList");
            return (Criteria) this;
        }

        public Criteria andAccountMoneyListLessThanOrEqualTo(String value) {
            addCriterion("account_money_list <=", value, "accountMoneyList");
            return (Criteria) this;
        }

        public Criteria andAccountMoneyListLike(String value) {
            addCriterion("account_money_list like", value, "accountMoneyList");
            return (Criteria) this;
        }

        public Criteria andAccountMoneyListNotLike(String value) {
            addCriterion("account_money_list not like", value, "accountMoneyList");
            return (Criteria) this;
        }

        public Criteria andAccountMoneyListIn(List<String> values) {
            addCriterion("account_money_list in", values, "accountMoneyList");
            return (Criteria) this;
        }

        public Criteria andAccountMoneyListNotIn(List<String> values) {
            addCriterion("account_money_list not in", values, "accountMoneyList");
            return (Criteria) this;
        }

        public Criteria andAccountMoneyListBetween(String value1, String value2) {
            addCriterion("account_money_list between", value1, value2, "accountMoneyList");
            return (Criteria) this;
        }

        public Criteria andAccountMoneyListNotBetween(String value1, String value2) {
            addCriterion("account_money_list not between", value1, value2, "accountMoneyList");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNull() {
            addCriterion("discount is null");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNotNull() {
            addCriterion("discount is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountEqualTo(BigDecimal value) {
            addCriterion("discount =", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotEqualTo(BigDecimal value) {
            addCriterion("discount <>", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThan(BigDecimal value) {
            addCriterion("discount >", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("discount >=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThan(BigDecimal value) {
            addCriterion("discount <", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("discount <=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountIn(List<BigDecimal> values) {
            addCriterion("discount in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotIn(List<BigDecimal> values) {
            addCriterion("discount not in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount not between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyIsNull() {
            addCriterion("discount_money is null");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyIsNotNull() {
            addCriterion("discount_money is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyEqualTo(BigDecimal value) {
            addCriterion("discount_money =", value, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyNotEqualTo(BigDecimal value) {
            addCriterion("discount_money <>", value, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyGreaterThan(BigDecimal value) {
            addCriterion("discount_money >", value, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("discount_money >=", value, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyLessThan(BigDecimal value) {
            addCriterion("discount_money <", value, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("discount_money <=", value, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyIn(List<BigDecimal> values) {
            addCriterion("discount_money in", values, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyNotIn(List<BigDecimal> values) {
            addCriterion("discount_money not in", values, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount_money between", value1, value2, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount_money not between", value1, value2, "discountMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountLastMoneyIsNull() {
            addCriterion("discount_last_money is null");
            return (Criteria) this;
        }

        public Criteria andDiscountLastMoneyIsNotNull() {
            addCriterion("discount_last_money is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountLastMoneyEqualTo(BigDecimal value) {
            addCriterion("discount_last_money =", value, "discountLastMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountLastMoneyNotEqualTo(BigDecimal value) {
            addCriterion("discount_last_money <>", value, "discountLastMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountLastMoneyGreaterThan(BigDecimal value) {
            addCriterion("discount_last_money >", value, "discountLastMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountLastMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("discount_last_money >=", value, "discountLastMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountLastMoneyLessThan(BigDecimal value) {
            addCriterion("discount_last_money <", value, "discountLastMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountLastMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("discount_last_money <=", value, "discountLastMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountLastMoneyIn(List<BigDecimal> values) {
            addCriterion("discount_last_money in", values, "discountLastMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountLastMoneyNotIn(List<BigDecimal> values) {
            addCriterion("discount_last_money not in", values, "discountLastMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountLastMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount_last_money between", value1, value2, "discountLastMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountLastMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount_last_money not between", value1, value2, "discountLastMoney");
            return (Criteria) this;
        }

        public Criteria andOtherMoneyIsNull() {
            addCriterion("other_money is null");
            return (Criteria) this;
        }

        public Criteria andOtherMoneyIsNotNull() {
            addCriterion("other_money is not null");
            return (Criteria) this;
        }

        public Criteria andOtherMoneyEqualTo(BigDecimal value) {
            addCriterion("other_money =", value, "otherMoney");
            return (Criteria) this;
        }

        public Criteria andOtherMoneyNotEqualTo(BigDecimal value) {
            addCriterion("other_money <>", value, "otherMoney");
            return (Criteria) this;
        }

        public Criteria andOtherMoneyGreaterThan(BigDecimal value) {
            addCriterion("other_money >", value, "otherMoney");
            return (Criteria) this;
        }

        public Criteria andOtherMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("other_money >=", value, "otherMoney");
            return (Criteria) this;
        }

        public Criteria andOtherMoneyLessThan(BigDecimal value) {
            addCriterion("other_money <", value, "otherMoney");
            return (Criteria) this;
        }

        public Criteria andOtherMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("other_money <=", value, "otherMoney");
            return (Criteria) this;
        }

        public Criteria andOtherMoneyIn(List<BigDecimal> values) {
            addCriterion("other_money in", values, "otherMoney");
            return (Criteria) this;
        }

        public Criteria andOtherMoneyNotIn(List<BigDecimal> values) {
            addCriterion("other_money not in", values, "otherMoney");
            return (Criteria) this;
        }

        public Criteria andOtherMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("other_money between", value1, value2, "otherMoney");
            return (Criteria) this;
        }

        public Criteria andOtherMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("other_money not between", value1, value2, "otherMoney");
            return (Criteria) this;
        }

        public Criteria andDepositIsNull() {
            addCriterion("deposit is null");
            return (Criteria) this;
        }

        public Criteria andDepositIsNotNull() {
            addCriterion("deposit is not null");
            return (Criteria) this;
        }

        public Criteria andDepositEqualTo(BigDecimal value) {
            addCriterion("deposit =", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotEqualTo(BigDecimal value) {
            addCriterion("deposit <>", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositGreaterThan(BigDecimal value) {
            addCriterion("deposit >", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("deposit >=", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositLessThan(BigDecimal value) {
            addCriterion("deposit <", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositLessThanOrEqualTo(BigDecimal value) {
            addCriterion("deposit <=", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositIn(List<BigDecimal> values) {
            addCriterion("deposit in", values, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotIn(List<BigDecimal> values) {
            addCriterion("deposit not in", values, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deposit between", value1, value2, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deposit not between", value1, value2, "deposit");
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

        public Criteria andPurchaseStatusIsNull() {
            addCriterion("purchase_status is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseStatusIsNotNull() {
            addCriterion("purchase_status is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseStatusEqualTo(String value) {
            addCriterion("purchase_status =", value, "purchaseStatus");
            return (Criteria) this;
        }

        public Criteria andPurchaseStatusNotEqualTo(String value) {
            addCriterion("purchase_status <>", value, "purchaseStatus");
            return (Criteria) this;
        }

        public Criteria andPurchaseStatusGreaterThan(String value) {
            addCriterion("purchase_status >", value, "purchaseStatus");
            return (Criteria) this;
        }

        public Criteria andPurchaseStatusGreaterThanOrEqualTo(String value) {
            addCriterion("purchase_status >=", value, "purchaseStatus");
            return (Criteria) this;
        }

        public Criteria andPurchaseStatusLessThan(String value) {
            addCriterion("purchase_status <", value, "purchaseStatus");
            return (Criteria) this;
        }

        public Criteria andPurchaseStatusLessThanOrEqualTo(String value) {
            addCriterion("purchase_status <=", value, "purchaseStatus");
            return (Criteria) this;
        }

        public Criteria andPurchaseStatusLike(String value) {
            addCriterion("purchase_status like", value, "purchaseStatus");
            return (Criteria) this;
        }

        public Criteria andPurchaseStatusNotLike(String value) {
            addCriterion("purchase_status not like", value, "purchaseStatus");
            return (Criteria) this;
        }

        public Criteria andPurchaseStatusIn(List<String> values) {
            addCriterion("purchase_status in", values, "purchaseStatus");
            return (Criteria) this;
        }

        public Criteria andPurchaseStatusNotIn(List<String> values) {
            addCriterion("purchase_status not in", values, "purchaseStatus");
            return (Criteria) this;
        }

        public Criteria andPurchaseStatusBetween(String value1, String value2) {
            addCriterion("purchase_status between", value1, value2, "purchaseStatus");
            return (Criteria) this;
        }

        public Criteria andPurchaseStatusNotBetween(String value1, String value2) {
            addCriterion("purchase_status not between", value1, value2, "purchaseStatus");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(String value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(String value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(String value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(String value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(String value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(String value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLike(String value) {
            addCriterion("source like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotLike(String value) {
            addCriterion("source not like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<String> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<String> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(String value1, String value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(String value1, String value2) {
            addCriterion("source not between", value1, value2, "source");
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

        public Criteria andSimulatedAnnealingIsNull() {
            addCriterion("simulated_annealing is null");
            return (Criteria) this;
        }

        public Criteria andSimulatedAnnealingIsNotNull() {
            addCriterion("simulated_annealing is not null");
            return (Criteria) this;
        }

        public Criteria andSimulatedAnnealingEqualTo(String value) {
            addCriterion("simulated_annealing =", value, "simulatedAnnealing");
            return (Criteria) this;
        }

        public Criteria andSimulatedAnnealingNotEqualTo(String value) {
            addCriterion("simulated_annealing <>", value, "simulatedAnnealing");
            return (Criteria) this;
        }

        public Criteria andSimulatedAnnealingGreaterThan(String value) {
            addCriterion("simulated_annealing >", value, "simulatedAnnealing");
            return (Criteria) this;
        }

        public Criteria andSimulatedAnnealingGreaterThanOrEqualTo(String value) {
            addCriterion("simulated_annealing >=", value, "simulatedAnnealing");
            return (Criteria) this;
        }

        public Criteria andSimulatedAnnealingLessThan(String value) {
            addCriterion("simulated_annealing <", value, "simulatedAnnealing");
            return (Criteria) this;
        }

        public Criteria andSimulatedAnnealingLessThanOrEqualTo(String value) {
            addCriterion("simulated_annealing <=", value, "simulatedAnnealing");
            return (Criteria) this;
        }

        public Criteria andSimulatedAnnealingLike(String value) {
            addCriterion("simulated_annealing like", value, "simulatedAnnealing");
            return (Criteria) this;
        }

        public Criteria andSimulatedAnnealingNotLike(String value) {
            addCriterion("simulated_annealing not like", value, "simulatedAnnealing");
            return (Criteria) this;
        }

        public Criteria andSimulatedAnnealingIn(List<String> values) {
            addCriterion("simulated_annealing in", values, "simulatedAnnealing");
            return (Criteria) this;
        }

        public Criteria andSimulatedAnnealingNotIn(List<String> values) {
            addCriterion("simulated_annealing not in", values, "simulatedAnnealing");
            return (Criteria) this;
        }

        public Criteria andSimulatedAnnealingBetween(String value1, String value2) {
            addCriterion("simulated_annealing between", value1, value2, "simulatedAnnealing");
            return (Criteria) this;
        }

        public Criteria andSimulatedAnnealingNotBetween(String value1, String value2) {
            addCriterion("simulated_annealing not between", value1, value2, "simulatedAnnealing");
            return (Criteria) this;
        }

        public Criteria andPeriodIsNull() {
            addCriterion("period is null");
            return (Criteria) this;
        }

        public Criteria andPeriodIsNotNull() {
            addCriterion("period is not null");
            return (Criteria) this;
        }

        public Criteria andPeriodEqualTo(String value) {
            addCriterion("period =", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotEqualTo(String value) {
            addCriterion("period <>", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodGreaterThan(String value) {
            addCriterion("period >", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodGreaterThanOrEqualTo(String value) {
            addCriterion("period >=", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodLessThan(String value) {
            addCriterion("period <", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodLessThanOrEqualTo(String value) {
            addCriterion("period <=", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodLike(String value) {
            addCriterion("period like", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotLike(String value) {
            addCriterion("period not like", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodIn(List<String> values) {
            addCriterion("period in", values, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotIn(List<String> values) {
            addCriterion("period not in", values, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodBetween(String value1, String value2) {
            addCriterion("period between", value1, value2, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotBetween(String value1, String value2) {
            addCriterion("period not between", value1, value2, "period");
            return (Criteria) this;
        }

        public Criteria andOtherCostTotalIsNull() {
            addCriterion("other_cost_total is null");
            return (Criteria) this;
        }

        public Criteria andOtherCostTotalIsNotNull() {
            addCriterion("other_cost_total is not null");
            return (Criteria) this;
        }

        public Criteria andOtherCostTotalEqualTo(BigDecimal value) {
            addCriterion("other_cost_total =", value, "otherCostTotal");
            return (Criteria) this;
        }

        public Criteria andOtherCostTotalNotEqualTo(BigDecimal value) {
            addCriterion("other_cost_total <>", value, "otherCostTotal");
            return (Criteria) this;
        }

        public Criteria andOtherCostTotalGreaterThan(BigDecimal value) {
            addCriterion("other_cost_total >", value, "otherCostTotal");
            return (Criteria) this;
        }

        public Criteria andOtherCostTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("other_cost_total >=", value, "otherCostTotal");
            return (Criteria) this;
        }

        public Criteria andOtherCostTotalLessThan(BigDecimal value) {
            addCriterion("other_cost_total <", value, "otherCostTotal");
            return (Criteria) this;
        }

        public Criteria andOtherCostTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("other_cost_total <=", value, "otherCostTotal");
            return (Criteria) this;
        }

        public Criteria andOtherCostTotalIn(List<BigDecimal> values) {
            addCriterion("other_cost_total in", values, "otherCostTotal");
            return (Criteria) this;
        }

        public Criteria andOtherCostTotalNotIn(List<BigDecimal> values) {
            addCriterion("other_cost_total not in", values, "otherCostTotal");
            return (Criteria) this;
        }

        public Criteria andOtherCostTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("other_cost_total between", value1, value2, "otherCostTotal");
            return (Criteria) this;
        }

        public Criteria andOtherCostTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("other_cost_total not between", value1, value2, "otherCostTotal");
            return (Criteria) this;
        }

        public Criteria andProductQualityIsNull() {
            addCriterion("product_quality is null");
            return (Criteria) this;
        }

        public Criteria andProductQualityIsNotNull() {
            addCriterion("product_quality is not null");
            return (Criteria) this;
        }

        public Criteria andProductQualityEqualTo(String value) {
            addCriterion("product_quality =", value, "productQuality");
            return (Criteria) this;
        }

        public Criteria andProductQualityNotEqualTo(String value) {
            addCriterion("product_quality <>", value, "productQuality");
            return (Criteria) this;
        }

        public Criteria andProductQualityGreaterThan(String value) {
            addCriterion("product_quality >", value, "productQuality");
            return (Criteria) this;
        }

        public Criteria andProductQualityGreaterThanOrEqualTo(String value) {
            addCriterion("product_quality >=", value, "productQuality");
            return (Criteria) this;
        }

        public Criteria andProductQualityLessThan(String value) {
            addCriterion("product_quality <", value, "productQuality");
            return (Criteria) this;
        }

        public Criteria andProductQualityLessThanOrEqualTo(String value) {
            addCriterion("product_quality <=", value, "productQuality");
            return (Criteria) this;
        }

        public Criteria andProductQualityLike(String value) {
            addCriterion("product_quality like", value, "productQuality");
            return (Criteria) this;
        }

        public Criteria andProductQualityNotLike(String value) {
            addCriterion("product_quality not like", value, "productQuality");
            return (Criteria) this;
        }

        public Criteria andProductQualityIn(List<String> values) {
            addCriterion("product_quality in", values, "productQuality");
            return (Criteria) this;
        }

        public Criteria andProductQualityNotIn(List<String> values) {
            addCriterion("product_quality not in", values, "productQuality");
            return (Criteria) this;
        }

        public Criteria andProductQualityBetween(String value1, String value2) {
            addCriterion("product_quality between", value1, value2, "productQuality");
            return (Criteria) this;
        }

        public Criteria andProductQualityNotBetween(String value1, String value2) {
            addCriterion("product_quality not between", value1, value2, "productQuality");
            return (Criteria) this;
        }

        public Criteria andCustomsDeclarationDocumentIsNull() {
            addCriterion("customs_declaration_document is null");
            return (Criteria) this;
        }

        public Criteria andCustomsDeclarationDocumentIsNotNull() {
            addCriterion("customs_declaration_document is not null");
            return (Criteria) this;
        }

        public Criteria andCustomsDeclarationDocumentEqualTo(String value) {
            addCriterion("customs_declaration_document =", value, "customsDeclarationDocument");
            return (Criteria) this;
        }

        public Criteria andCustomsDeclarationDocumentNotEqualTo(String value) {
            addCriterion("customs_declaration_document <>", value, "customsDeclarationDocument");
            return (Criteria) this;
        }

        public Criteria andCustomsDeclarationDocumentGreaterThan(String value) {
            addCriterion("customs_declaration_document >", value, "customsDeclarationDocument");
            return (Criteria) this;
        }

        public Criteria andCustomsDeclarationDocumentGreaterThanOrEqualTo(String value) {
            addCriterion("customs_declaration_document >=", value, "customsDeclarationDocument");
            return (Criteria) this;
        }

        public Criteria andCustomsDeclarationDocumentLessThan(String value) {
            addCriterion("customs_declaration_document <", value, "customsDeclarationDocument");
            return (Criteria) this;
        }

        public Criteria andCustomsDeclarationDocumentLessThanOrEqualTo(String value) {
            addCriterion("customs_declaration_document <=", value, "customsDeclarationDocument");
            return (Criteria) this;
        }

        public Criteria andCustomsDeclarationDocumentLike(String value) {
            addCriterion("customs_declaration_document like", value, "customsDeclarationDocument");
            return (Criteria) this;
        }

        public Criteria andCustomsDeclarationDocumentNotLike(String value) {
            addCriterion("customs_declaration_document not like", value, "customsDeclarationDocument");
            return (Criteria) this;
        }

        public Criteria andCustomsDeclarationDocumentIn(List<String> values) {
            addCriterion("customs_declaration_document in", values, "customsDeclarationDocument");
            return (Criteria) this;
        }

        public Criteria andCustomsDeclarationDocumentNotIn(List<String> values) {
            addCriterion("customs_declaration_document not in", values, "customsDeclarationDocument");
            return (Criteria) this;
        }

        public Criteria andCustomsDeclarationDocumentBetween(String value1, String value2) {
            addCriterion("customs_declaration_document between", value1, value2, "customsDeclarationDocument");
            return (Criteria) this;
        }

        public Criteria andCustomsDeclarationDocumentNotBetween(String value1, String value2) {
            addCriterion("customs_declaration_document not between", value1, value2, "customsDeclarationDocument");
            return (Criteria) this;
        }

        public Criteria andQuarantineCertificateIsNull() {
            addCriterion("quarantine_certificate is null");
            return (Criteria) this;
        }

        public Criteria andQuarantineCertificateIsNotNull() {
            addCriterion("quarantine_certificate is not null");
            return (Criteria) this;
        }

        public Criteria andQuarantineCertificateEqualTo(String value) {
            addCriterion("quarantine_certificate =", value, "quarantineCertificate");
            return (Criteria) this;
        }

        public Criteria andQuarantineCertificateNotEqualTo(String value) {
            addCriterion("quarantine_certificate <>", value, "quarantineCertificate");
            return (Criteria) this;
        }

        public Criteria andQuarantineCertificateGreaterThan(String value) {
            addCriterion("quarantine_certificate >", value, "quarantineCertificate");
            return (Criteria) this;
        }

        public Criteria andQuarantineCertificateGreaterThanOrEqualTo(String value) {
            addCriterion("quarantine_certificate >=", value, "quarantineCertificate");
            return (Criteria) this;
        }

        public Criteria andQuarantineCertificateLessThan(String value) {
            addCriterion("quarantine_certificate <", value, "quarantineCertificate");
            return (Criteria) this;
        }

        public Criteria andQuarantineCertificateLessThanOrEqualTo(String value) {
            addCriterion("quarantine_certificate <=", value, "quarantineCertificate");
            return (Criteria) this;
        }

        public Criteria andQuarantineCertificateLike(String value) {
            addCriterion("quarantine_certificate like", value, "quarantineCertificate");
            return (Criteria) this;
        }

        public Criteria andQuarantineCertificateNotLike(String value) {
            addCriterion("quarantine_certificate not like", value, "quarantineCertificate");
            return (Criteria) this;
        }

        public Criteria andQuarantineCertificateIn(List<String> values) {
            addCriterion("quarantine_certificate in", values, "quarantineCertificate");
            return (Criteria) this;
        }

        public Criteria andQuarantineCertificateNotIn(List<String> values) {
            addCriterion("quarantine_certificate not in", values, "quarantineCertificate");
            return (Criteria) this;
        }

        public Criteria andQuarantineCertificateBetween(String value1, String value2) {
            addCriterion("quarantine_certificate between", value1, value2, "quarantineCertificate");
            return (Criteria) this;
        }

        public Criteria andQuarantineCertificateNotBetween(String value1, String value2) {
            addCriterion("quarantine_certificate not between", value1, value2, "quarantineCertificate");
            return (Criteria) this;
        }

        public Criteria andLicenseIsNull() {
            addCriterion("license is null");
            return (Criteria) this;
        }

        public Criteria andLicenseIsNotNull() {
            addCriterion("license is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseEqualTo(String value) {
            addCriterion("license =", value, "license");
            return (Criteria) this;
        }

        public Criteria andLicenseNotEqualTo(String value) {
            addCriterion("license <>", value, "license");
            return (Criteria) this;
        }

        public Criteria andLicenseGreaterThan(String value) {
            addCriterion("license >", value, "license");
            return (Criteria) this;
        }

        public Criteria andLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("license >=", value, "license");
            return (Criteria) this;
        }

        public Criteria andLicenseLessThan(String value) {
            addCriterion("license <", value, "license");
            return (Criteria) this;
        }

        public Criteria andLicenseLessThanOrEqualTo(String value) {
            addCriterion("license <=", value, "license");
            return (Criteria) this;
        }

        public Criteria andLicenseLike(String value) {
            addCriterion("license like", value, "license");
            return (Criteria) this;
        }

        public Criteria andLicenseNotLike(String value) {
            addCriterion("license not like", value, "license");
            return (Criteria) this;
        }

        public Criteria andLicenseIn(List<String> values) {
            addCriterion("license in", values, "license");
            return (Criteria) this;
        }

        public Criteria andLicenseNotIn(List<String> values) {
            addCriterion("license not in", values, "license");
            return (Criteria) this;
        }

        public Criteria andLicenseBetween(String value1, String value2) {
            addCriterion("license between", value1, value2, "license");
            return (Criteria) this;
        }

        public Criteria andLicenseNotBetween(String value1, String value2) {
            addCriterion("license not between", value1, value2, "license");
            return (Criteria) this;
        }

        public Criteria andDetailedGoodsListIsNull() {
            addCriterion("detailed_goods_list is null");
            return (Criteria) this;
        }

        public Criteria andDetailedGoodsListIsNotNull() {
            addCriterion("detailed_goods_list is not null");
            return (Criteria) this;
        }

        public Criteria andDetailedGoodsListEqualTo(String value) {
            addCriterion("detailed_goods_list =", value, "detailedGoodsList");
            return (Criteria) this;
        }

        public Criteria andDetailedGoodsListNotEqualTo(String value) {
            addCriterion("detailed_goods_list <>", value, "detailedGoodsList");
            return (Criteria) this;
        }

        public Criteria andDetailedGoodsListGreaterThan(String value) {
            addCriterion("detailed_goods_list >", value, "detailedGoodsList");
            return (Criteria) this;
        }

        public Criteria andDetailedGoodsListGreaterThanOrEqualTo(String value) {
            addCriterion("detailed_goods_list >=", value, "detailedGoodsList");
            return (Criteria) this;
        }

        public Criteria andDetailedGoodsListLessThan(String value) {
            addCriterion("detailed_goods_list <", value, "detailedGoodsList");
            return (Criteria) this;
        }

        public Criteria andDetailedGoodsListLessThanOrEqualTo(String value) {
            addCriterion("detailed_goods_list <=", value, "detailedGoodsList");
            return (Criteria) this;
        }

        public Criteria andDetailedGoodsListLike(String value) {
            addCriterion("detailed_goods_list like", value, "detailedGoodsList");
            return (Criteria) this;
        }

        public Criteria andDetailedGoodsListNotLike(String value) {
            addCriterion("detailed_goods_list not like", value, "detailedGoodsList");
            return (Criteria) this;
        }

        public Criteria andDetailedGoodsListIn(List<String> values) {
            addCriterion("detailed_goods_list in", values, "detailedGoodsList");
            return (Criteria) this;
        }

        public Criteria andDetailedGoodsListNotIn(List<String> values) {
            addCriterion("detailed_goods_list not in", values, "detailedGoodsList");
            return (Criteria) this;
        }

        public Criteria andDetailedGoodsListBetween(String value1, String value2) {
            addCriterion("detailed_goods_list between", value1, value2, "detailedGoodsList");
            return (Criteria) this;
        }

        public Criteria andDetailedGoodsListNotBetween(String value1, String value2) {
            addCriterion("detailed_goods_list not between", value1, value2, "detailedGoodsList");
            return (Criteria) this;
        }

        public Criteria andDeliveryOrderIsNull() {
            addCriterion("delivery_order is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryOrderIsNotNull() {
            addCriterion("delivery_order is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryOrderEqualTo(String value) {
            addCriterion("delivery_order =", value, "deliveryOrder");
            return (Criteria) this;
        }

        public Criteria andDeliveryOrderNotEqualTo(String value) {
            addCriterion("delivery_order <>", value, "deliveryOrder");
            return (Criteria) this;
        }

        public Criteria andDeliveryOrderGreaterThan(String value) {
            addCriterion("delivery_order >", value, "deliveryOrder");
            return (Criteria) this;
        }

        public Criteria andDeliveryOrderGreaterThanOrEqualTo(String value) {
            addCriterion("delivery_order >=", value, "deliveryOrder");
            return (Criteria) this;
        }

        public Criteria andDeliveryOrderLessThan(String value) {
            addCriterion("delivery_order <", value, "deliveryOrder");
            return (Criteria) this;
        }

        public Criteria andDeliveryOrderLessThanOrEqualTo(String value) {
            addCriterion("delivery_order <=", value, "deliveryOrder");
            return (Criteria) this;
        }

        public Criteria andDeliveryOrderLike(String value) {
            addCriterion("delivery_order like", value, "deliveryOrder");
            return (Criteria) this;
        }

        public Criteria andDeliveryOrderNotLike(String value) {
            addCriterion("delivery_order not like", value, "deliveryOrder");
            return (Criteria) this;
        }

        public Criteria andDeliveryOrderIn(List<String> values) {
            addCriterion("delivery_order in", values, "deliveryOrder");
            return (Criteria) this;
        }

        public Criteria andDeliveryOrderNotIn(List<String> values) {
            addCriterion("delivery_order not in", values, "deliveryOrder");
            return (Criteria) this;
        }

        public Criteria andDeliveryOrderBetween(String value1, String value2) {
            addCriterion("delivery_order between", value1, value2, "deliveryOrder");
            return (Criteria) this;
        }

        public Criteria andDeliveryOrderNotBetween(String value1, String value2) {
            addCriterion("delivery_order not between", value1, value2, "deliveryOrder");
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

        public Criteria andExpirationOperationTimeIsNull() {
            addCriterion("expiration_operation_time is null");
            return (Criteria) this;
        }

        public Criteria andExpirationOperationTimeIsNotNull() {
            addCriterion("expiration_operation_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpirationOperationTimeEqualTo(Date value) {
            addCriterion("expiration_operation_time =", value, "expirationOperationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationOperationTimeNotEqualTo(Date value) {
            addCriterion("expiration_operation_time <>", value, "expirationOperationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationOperationTimeGreaterThan(Date value) {
            addCriterion("expiration_operation_time >", value, "expirationOperationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationOperationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("expiration_operation_time >=", value, "expirationOperationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationOperationTimeLessThan(Date value) {
            addCriterion("expiration_operation_time <", value, "expirationOperationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationOperationTimeLessThanOrEqualTo(Date value) {
            addCriterion("expiration_operation_time <=", value, "expirationOperationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationOperationTimeIn(List<Date> values) {
            addCriterion("expiration_operation_time in", values, "expirationOperationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationOperationTimeNotIn(List<Date> values) {
            addCriterion("expiration_operation_time not in", values, "expirationOperationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationOperationTimeBetween(Date value1, Date value2) {
            addCriterion("expiration_operation_time between", value1, value2, "expirationOperationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationOperationTimeNotBetween(Date value1, Date value2) {
            addCriterion("expiration_operation_time not between", value1, value2, "expirationOperationTime");
            return (Criteria) this;
        }

        public Criteria andClientIsNull() {
            addCriterion("client is null");
            return (Criteria) this;
        }

        public Criteria andClientIsNotNull() {
            addCriterion("client is not null");
            return (Criteria) this;
        }

        public Criteria andClientEqualTo(String value) {
            addCriterion("client =", value, "client");
            return (Criteria) this;
        }

        public Criteria andClientNotEqualTo(String value) {
            addCriterion("client <>", value, "client");
            return (Criteria) this;
        }

        public Criteria andClientGreaterThan(String value) {
            addCriterion("client >", value, "client");
            return (Criteria) this;
        }

        public Criteria andClientGreaterThanOrEqualTo(String value) {
            addCriterion("client >=", value, "client");
            return (Criteria) this;
        }

        public Criteria andClientLessThan(String value) {
            addCriterion("client <", value, "client");
            return (Criteria) this;
        }

        public Criteria andClientLessThanOrEqualTo(String value) {
            addCriterion("client <=", value, "client");
            return (Criteria) this;
        }

        public Criteria andClientLike(String value) {
            addCriterion("client like", value, "client");
            return (Criteria) this;
        }

        public Criteria andClientNotLike(String value) {
            addCriterion("client not like", value, "client");
            return (Criteria) this;
        }

        public Criteria andClientIn(List<String> values) {
            addCriterion("client in", values, "client");
            return (Criteria) this;
        }

        public Criteria andClientNotIn(List<String> values) {
            addCriterion("client not in", values, "client");
            return (Criteria) this;
        }

        public Criteria andClientBetween(String value1, String value2) {
            addCriterion("client between", value1, value2, "client");
            return (Criteria) this;
        }

        public Criteria andClientNotBetween(String value1, String value2) {
            addCriterion("client not between", value1, value2, "client");
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

        public Criteria andOriginTypeIsNull() {
            addCriterion("origin_type is null");
            return (Criteria) this;
        }

        public Criteria andOriginTypeIsNotNull() {
            addCriterion("origin_type is not null");
            return (Criteria) this;
        }

        public Criteria andOriginTypeEqualTo(String value) {
            addCriterion("origin_type =", value, "originType");
            return (Criteria) this;
        }

        public Criteria andOriginTypeNotEqualTo(String value) {
            addCriterion("origin_type <>", value, "originType");
            return (Criteria) this;
        }

        public Criteria andOriginTypeGreaterThan(String value) {
            addCriterion("origin_type >", value, "originType");
            return (Criteria) this;
        }

        public Criteria andOriginTypeGreaterThanOrEqualTo(String value) {
            addCriterion("origin_type >=", value, "originType");
            return (Criteria) this;
        }

        public Criteria andOriginTypeLessThan(String value) {
            addCriterion("origin_type <", value, "originType");
            return (Criteria) this;
        }

        public Criteria andOriginTypeLessThanOrEqualTo(String value) {
            addCriterion("origin_type <=", value, "originType");
            return (Criteria) this;
        }

        public Criteria andOriginTypeLike(String value) {
            addCriterion("origin_type like", value, "originType");
            return (Criteria) this;
        }

        public Criteria andOriginTypeNotLike(String value) {
            addCriterion("origin_type not like", value, "originType");
            return (Criteria) this;
        }

        public Criteria andOriginTypeIn(List<String> values) {
            addCriterion("origin_type in", values, "originType");
            return (Criteria) this;
        }

        public Criteria andOriginTypeNotIn(List<String> values) {
            addCriterion("origin_type not in", values, "originType");
            return (Criteria) this;
        }

        public Criteria andOriginTypeBetween(String value1, String value2) {
            addCriterion("origin_type between", value1, value2, "originType");
            return (Criteria) this;
        }

        public Criteria andOriginTypeNotBetween(String value1, String value2) {
            addCriterion("origin_type not between", value1, value2, "originType");
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