package com.jsh.erp.datasource.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SupplierExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SupplierExample() {
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

        public Criteria andContactsIsNull() {
            addCriterion("contacts is null");
            return (Criteria) this;
        }

        public Criteria andContactsIsNotNull() {
            addCriterion("contacts is not null");
            return (Criteria) this;
        }

        public Criteria andContactsEqualTo(String value) {
            addCriterion("contacts =", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotEqualTo(String value) {
            addCriterion("contacts <>", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsGreaterThan(String value) {
            addCriterion("contacts >", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsGreaterThanOrEqualTo(String value) {
            addCriterion("contacts >=", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsLessThan(String value) {
            addCriterion("contacts <", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsLessThanOrEqualTo(String value) {
            addCriterion("contacts <=", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsLike(String value) {
            addCriterion("contacts like", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotLike(String value) {
            addCriterion("contacts not like", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsIn(List<String> values) {
            addCriterion("contacts in", values, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotIn(List<String> values) {
            addCriterion("contacts not in", values, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsBetween(String value1, String value2) {
            addCriterion("contacts between", value1, value2, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotBetween(String value1, String value2) {
            addCriterion("contacts not between", value1, value2, "contacts");
            return (Criteria) this;
        }

        public Criteria andPhoneNumIsNull() {
            addCriterion("phone_num is null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumIsNotNull() {
            addCriterion("phone_num is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumEqualTo(String value) {
            addCriterion("phone_num =", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotEqualTo(String value) {
            addCriterion("phone_num <>", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumGreaterThan(String value) {
            addCriterion("phone_num >", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumGreaterThanOrEqualTo(String value) {
            addCriterion("phone_num >=", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumLessThan(String value) {
            addCriterion("phone_num <", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumLessThanOrEqualTo(String value) {
            addCriterion("phone_num <=", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumLike(String value) {
            addCriterion("phone_num like", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotLike(String value) {
            addCriterion("phone_num not like", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumIn(List<String> values) {
            addCriterion("phone_num in", values, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotIn(List<String> values) {
            addCriterion("phone_num not in", values, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumBetween(String value1, String value2) {
            addCriterion("phone_num between", value1, value2, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotBetween(String value1, String value2) {
            addCriterion("phone_num not between", value1, value2, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andIsystemIsNull() {
            addCriterion("isystem is null");
            return (Criteria) this;
        }

        public Criteria andIsystemIsNotNull() {
            addCriterion("isystem is not null");
            return (Criteria) this;
        }

        public Criteria andIsystemEqualTo(Byte value) {
            addCriterion("isystem =", value, "isystem");
            return (Criteria) this;
        }

        public Criteria andIsystemNotEqualTo(Byte value) {
            addCriterion("isystem <>", value, "isystem");
            return (Criteria) this;
        }

        public Criteria andIsystemGreaterThan(Byte value) {
            addCriterion("isystem >", value, "isystem");
            return (Criteria) this;
        }

        public Criteria andIsystemGreaterThanOrEqualTo(Byte value) {
            addCriterion("isystem >=", value, "isystem");
            return (Criteria) this;
        }

        public Criteria andIsystemLessThan(Byte value) {
            addCriterion("isystem <", value, "isystem");
            return (Criteria) this;
        }

        public Criteria andIsystemLessThanOrEqualTo(Byte value) {
            addCriterion("isystem <=", value, "isystem");
            return (Criteria) this;
        }

        public Criteria andIsystemIn(List<Byte> values) {
            addCriterion("isystem in", values, "isystem");
            return (Criteria) this;
        }

        public Criteria andIsystemNotIn(List<Byte> values) {
            addCriterion("isystem not in", values, "isystem");
            return (Criteria) this;
        }

        public Criteria andIsystemBetween(Byte value1, Byte value2) {
            addCriterion("isystem between", value1, value2, "isystem");
            return (Criteria) this;
        }

        public Criteria andIsystemNotBetween(Byte value1, Byte value2) {
            addCriterion("isystem not between", value1, value2, "isystem");
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

        public Criteria andEnabledIsNull() {
            addCriterion("enabled is null");
            return (Criteria) this;
        }

        public Criteria andEnabledIsNotNull() {
            addCriterion("enabled is not null");
            return (Criteria) this;
        }

        public Criteria andEnabledEqualTo(Boolean value) {
            addCriterion("enabled =", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotEqualTo(Boolean value) {
            addCriterion("enabled <>", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThan(Boolean value) {
            addCriterion("enabled >", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThanOrEqualTo(Boolean value) {
            addCriterion("enabled >=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThan(Boolean value) {
            addCriterion("enabled <", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThanOrEqualTo(Boolean value) {
            addCriterion("enabled <=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledIn(List<Boolean> values) {
            addCriterion("enabled in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotIn(List<Boolean> values) {
            addCriterion("enabled not in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledBetween(Boolean value1, Boolean value2) {
            addCriterion("enabled between", value1, value2, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotBetween(Boolean value1, Boolean value2) {
            addCriterion("enabled not between", value1, value2, "enabled");
            return (Criteria) this;
        }

        public Criteria andAdvanceInIsNull() {
            addCriterion("advance_in is null");
            return (Criteria) this;
        }

        public Criteria andAdvanceInIsNotNull() {
            addCriterion("advance_in is not null");
            return (Criteria) this;
        }

        public Criteria andAdvanceInEqualTo(BigDecimal value) {
            addCriterion("advance_in =", value, "advanceIn");
            return (Criteria) this;
        }

        public Criteria andAdvanceInNotEqualTo(BigDecimal value) {
            addCriterion("advance_in <>", value, "advanceIn");
            return (Criteria) this;
        }

        public Criteria andAdvanceInGreaterThan(BigDecimal value) {
            addCriterion("advance_in >", value, "advanceIn");
            return (Criteria) this;
        }

        public Criteria andAdvanceInGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("advance_in >=", value, "advanceIn");
            return (Criteria) this;
        }

        public Criteria andAdvanceInLessThan(BigDecimal value) {
            addCriterion("advance_in <", value, "advanceIn");
            return (Criteria) this;
        }

        public Criteria andAdvanceInLessThanOrEqualTo(BigDecimal value) {
            addCriterion("advance_in <=", value, "advanceIn");
            return (Criteria) this;
        }

        public Criteria andAdvanceInIn(List<BigDecimal> values) {
            addCriterion("advance_in in", values, "advanceIn");
            return (Criteria) this;
        }

        public Criteria andAdvanceInNotIn(List<BigDecimal> values) {
            addCriterion("advance_in not in", values, "advanceIn");
            return (Criteria) this;
        }

        public Criteria andAdvanceInBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("advance_in between", value1, value2, "advanceIn");
            return (Criteria) this;
        }

        public Criteria andAdvanceInNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("advance_in not between", value1, value2, "advanceIn");
            return (Criteria) this;
        }

        public Criteria andBeginNeedGetIsNull() {
            addCriterion("begin_need_get is null");
            return (Criteria) this;
        }

        public Criteria andBeginNeedGetIsNotNull() {
            addCriterion("begin_need_get is not null");
            return (Criteria) this;
        }

        public Criteria andBeginNeedGetEqualTo(BigDecimal value) {
            addCriterion("begin_need_get =", value, "beginNeedGet");
            return (Criteria) this;
        }

        public Criteria andBeginNeedGetNotEqualTo(BigDecimal value) {
            addCriterion("begin_need_get <>", value, "beginNeedGet");
            return (Criteria) this;
        }

        public Criteria andBeginNeedGetGreaterThan(BigDecimal value) {
            addCriterion("begin_need_get >", value, "beginNeedGet");
            return (Criteria) this;
        }

        public Criteria andBeginNeedGetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("begin_need_get >=", value, "beginNeedGet");
            return (Criteria) this;
        }

        public Criteria andBeginNeedGetLessThan(BigDecimal value) {
            addCriterion("begin_need_get <", value, "beginNeedGet");
            return (Criteria) this;
        }

        public Criteria andBeginNeedGetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("begin_need_get <=", value, "beginNeedGet");
            return (Criteria) this;
        }

        public Criteria andBeginNeedGetIn(List<BigDecimal> values) {
            addCriterion("begin_need_get in", values, "beginNeedGet");
            return (Criteria) this;
        }

        public Criteria andBeginNeedGetNotIn(List<BigDecimal> values) {
            addCriterion("begin_need_get not in", values, "beginNeedGet");
            return (Criteria) this;
        }

        public Criteria andBeginNeedGetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("begin_need_get between", value1, value2, "beginNeedGet");
            return (Criteria) this;
        }

        public Criteria andBeginNeedGetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("begin_need_get not between", value1, value2, "beginNeedGet");
            return (Criteria) this;
        }

        public Criteria andBeginNeedPayIsNull() {
            addCriterion("begin_need_pay is null");
            return (Criteria) this;
        }

        public Criteria andBeginNeedPayIsNotNull() {
            addCriterion("begin_need_pay is not null");
            return (Criteria) this;
        }

        public Criteria andBeginNeedPayEqualTo(BigDecimal value) {
            addCriterion("begin_need_pay =", value, "beginNeedPay");
            return (Criteria) this;
        }

        public Criteria andBeginNeedPayNotEqualTo(BigDecimal value) {
            addCriterion("begin_need_pay <>", value, "beginNeedPay");
            return (Criteria) this;
        }

        public Criteria andBeginNeedPayGreaterThan(BigDecimal value) {
            addCriterion("begin_need_pay >", value, "beginNeedPay");
            return (Criteria) this;
        }

        public Criteria andBeginNeedPayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("begin_need_pay >=", value, "beginNeedPay");
            return (Criteria) this;
        }

        public Criteria andBeginNeedPayLessThan(BigDecimal value) {
            addCriterion("begin_need_pay <", value, "beginNeedPay");
            return (Criteria) this;
        }

        public Criteria andBeginNeedPayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("begin_need_pay <=", value, "beginNeedPay");
            return (Criteria) this;
        }

        public Criteria andBeginNeedPayIn(List<BigDecimal> values) {
            addCriterion("begin_need_pay in", values, "beginNeedPay");
            return (Criteria) this;
        }

        public Criteria andBeginNeedPayNotIn(List<BigDecimal> values) {
            addCriterion("begin_need_pay not in", values, "beginNeedPay");
            return (Criteria) this;
        }

        public Criteria andBeginNeedPayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("begin_need_pay between", value1, value2, "beginNeedPay");
            return (Criteria) this;
        }

        public Criteria andBeginNeedPayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("begin_need_pay not between", value1, value2, "beginNeedPay");
            return (Criteria) this;
        }

        public Criteria andAllNeedGetIsNull() {
            addCriterion("all_need_get is null");
            return (Criteria) this;
        }

        public Criteria andAllNeedGetIsNotNull() {
            addCriterion("all_need_get is not null");
            return (Criteria) this;
        }

        public Criteria andAllNeedGetEqualTo(BigDecimal value) {
            addCriterion("all_need_get =", value, "allNeedGet");
            return (Criteria) this;
        }

        public Criteria andAllNeedGetNotEqualTo(BigDecimal value) {
            addCriterion("all_need_get <>", value, "allNeedGet");
            return (Criteria) this;
        }

        public Criteria andAllNeedGetGreaterThan(BigDecimal value) {
            addCriterion("all_need_get >", value, "allNeedGet");
            return (Criteria) this;
        }

        public Criteria andAllNeedGetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("all_need_get >=", value, "allNeedGet");
            return (Criteria) this;
        }

        public Criteria andAllNeedGetLessThan(BigDecimal value) {
            addCriterion("all_need_get <", value, "allNeedGet");
            return (Criteria) this;
        }

        public Criteria andAllNeedGetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("all_need_get <=", value, "allNeedGet");
            return (Criteria) this;
        }

        public Criteria andAllNeedGetIn(List<BigDecimal> values) {
            addCriterion("all_need_get in", values, "allNeedGet");
            return (Criteria) this;
        }

        public Criteria andAllNeedGetNotIn(List<BigDecimal> values) {
            addCriterion("all_need_get not in", values, "allNeedGet");
            return (Criteria) this;
        }

        public Criteria andAllNeedGetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("all_need_get between", value1, value2, "allNeedGet");
            return (Criteria) this;
        }

        public Criteria andAllNeedGetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("all_need_get not between", value1, value2, "allNeedGet");
            return (Criteria) this;
        }

        public Criteria andAllNeedPayIsNull() {
            addCriterion("all_need_pay is null");
            return (Criteria) this;
        }

        public Criteria andAllNeedPayIsNotNull() {
            addCriterion("all_need_pay is not null");
            return (Criteria) this;
        }

        public Criteria andAllNeedPayEqualTo(BigDecimal value) {
            addCriterion("all_need_pay =", value, "allNeedPay");
            return (Criteria) this;
        }

        public Criteria andAllNeedPayNotEqualTo(BigDecimal value) {
            addCriterion("all_need_pay <>", value, "allNeedPay");
            return (Criteria) this;
        }

        public Criteria andAllNeedPayGreaterThan(BigDecimal value) {
            addCriterion("all_need_pay >", value, "allNeedPay");
            return (Criteria) this;
        }

        public Criteria andAllNeedPayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("all_need_pay >=", value, "allNeedPay");
            return (Criteria) this;
        }

        public Criteria andAllNeedPayLessThan(BigDecimal value) {
            addCriterion("all_need_pay <", value, "allNeedPay");
            return (Criteria) this;
        }

        public Criteria andAllNeedPayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("all_need_pay <=", value, "allNeedPay");
            return (Criteria) this;
        }

        public Criteria andAllNeedPayIn(List<BigDecimal> values) {
            addCriterion("all_need_pay in", values, "allNeedPay");
            return (Criteria) this;
        }

        public Criteria andAllNeedPayNotIn(List<BigDecimal> values) {
            addCriterion("all_need_pay not in", values, "allNeedPay");
            return (Criteria) this;
        }

        public Criteria andAllNeedPayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("all_need_pay between", value1, value2, "allNeedPay");
            return (Criteria) this;
        }

        public Criteria andAllNeedPayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("all_need_pay not between", value1, value2, "allNeedPay");
            return (Criteria) this;
        }

        public Criteria andFaxIsNull() {
            addCriterion("fax is null");
            return (Criteria) this;
        }

        public Criteria andFaxIsNotNull() {
            addCriterion("fax is not null");
            return (Criteria) this;
        }

        public Criteria andFaxEqualTo(String value) {
            addCriterion("fax =", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotEqualTo(String value) {
            addCriterion("fax <>", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThan(String value) {
            addCriterion("fax >", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThanOrEqualTo(String value) {
            addCriterion("fax >=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThan(String value) {
            addCriterion("fax <", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThanOrEqualTo(String value) {
            addCriterion("fax <=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLike(String value) {
            addCriterion("fax like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotLike(String value) {
            addCriterion("fax not like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxIn(List<String> values) {
            addCriterion("fax in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotIn(List<String> values) {
            addCriterion("fax not in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxBetween(String value1, String value2) {
            addCriterion("fax between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotBetween(String value1, String value2) {
            addCriterion("fax not between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNull() {
            addCriterion("telephone is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("telephone is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("telephone =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("telephone <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("telephone >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("telephone >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("telephone <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("telephone <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("telephone like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("telephone not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("telephone in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("telephone not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("telephone between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("telephone not between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andTaxNumIsNull() {
            addCriterion("tax_num is null");
            return (Criteria) this;
        }

        public Criteria andTaxNumIsNotNull() {
            addCriterion("tax_num is not null");
            return (Criteria) this;
        }

        public Criteria andTaxNumEqualTo(String value) {
            addCriterion("tax_num =", value, "taxNum");
            return (Criteria) this;
        }

        public Criteria andTaxNumNotEqualTo(String value) {
            addCriterion("tax_num <>", value, "taxNum");
            return (Criteria) this;
        }

        public Criteria andTaxNumGreaterThan(String value) {
            addCriterion("tax_num >", value, "taxNum");
            return (Criteria) this;
        }

        public Criteria andTaxNumGreaterThanOrEqualTo(String value) {
            addCriterion("tax_num >=", value, "taxNum");
            return (Criteria) this;
        }

        public Criteria andTaxNumLessThan(String value) {
            addCriterion("tax_num <", value, "taxNum");
            return (Criteria) this;
        }

        public Criteria andTaxNumLessThanOrEqualTo(String value) {
            addCriterion("tax_num <=", value, "taxNum");
            return (Criteria) this;
        }

        public Criteria andTaxNumLike(String value) {
            addCriterion("tax_num like", value, "taxNum");
            return (Criteria) this;
        }

        public Criteria andTaxNumNotLike(String value) {
            addCriterion("tax_num not like", value, "taxNum");
            return (Criteria) this;
        }

        public Criteria andTaxNumIn(List<String> values) {
            addCriterion("tax_num in", values, "taxNum");
            return (Criteria) this;
        }

        public Criteria andTaxNumNotIn(List<String> values) {
            addCriterion("tax_num not in", values, "taxNum");
            return (Criteria) this;
        }

        public Criteria andTaxNumBetween(String value1, String value2) {
            addCriterion("tax_num between", value1, value2, "taxNum");
            return (Criteria) this;
        }

        public Criteria andTaxNumNotBetween(String value1, String value2) {
            addCriterion("tax_num not between", value1, value2, "taxNum");
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

        public Criteria andAccountNumberIsNull() {
            addCriterion("account_number is null");
            return (Criteria) this;
        }

        public Criteria andAccountNumberIsNotNull() {
            addCriterion("account_number is not null");
            return (Criteria) this;
        }

        public Criteria andAccountNumberEqualTo(String value) {
            addCriterion("account_number =", value, "accountNumber");
            return (Criteria) this;
        }

        public Criteria andAccountNumberNotEqualTo(String value) {
            addCriterion("account_number <>", value, "accountNumber");
            return (Criteria) this;
        }

        public Criteria andAccountNumberGreaterThan(String value) {
            addCriterion("account_number >", value, "accountNumber");
            return (Criteria) this;
        }

        public Criteria andAccountNumberGreaterThanOrEqualTo(String value) {
            addCriterion("account_number >=", value, "accountNumber");
            return (Criteria) this;
        }

        public Criteria andAccountNumberLessThan(String value) {
            addCriterion("account_number <", value, "accountNumber");
            return (Criteria) this;
        }

        public Criteria andAccountNumberLessThanOrEqualTo(String value) {
            addCriterion("account_number <=", value, "accountNumber");
            return (Criteria) this;
        }

        public Criteria andAccountNumberLike(String value) {
            addCriterion("account_number like", value, "accountNumber");
            return (Criteria) this;
        }

        public Criteria andAccountNumberNotLike(String value) {
            addCriterion("account_number not like", value, "accountNumber");
            return (Criteria) this;
        }

        public Criteria andAccountNumberIn(List<String> values) {
            addCriterion("account_number in", values, "accountNumber");
            return (Criteria) this;
        }

        public Criteria andAccountNumberNotIn(List<String> values) {
            addCriterion("account_number not in", values, "accountNumber");
            return (Criteria) this;
        }

        public Criteria andAccountNumberBetween(String value1, String value2) {
            addCriterion("account_number between", value1, value2, "accountNumber");
            return (Criteria) this;
        }

        public Criteria andAccountNumberNotBetween(String value1, String value2) {
            addCriterion("account_number not between", value1, value2, "accountNumber");
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

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(String value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(String value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(String value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(String value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(String value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(String value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLike(String value) {
            addCriterion("sort like", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotLike(String value) {
            addCriterion("sort not like", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<String> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<String> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(String value1, String value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(String value1, String value2) {
            addCriterion("sort not between", value1, value2, "sort");
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

        public Criteria andCompanyTypeIsNull() {
            addCriterion("company_type is null");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeIsNotNull() {
            addCriterion("company_type is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeEqualTo(String value) {
            addCriterion("company_type =", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeNotEqualTo(String value) {
            addCriterion("company_type <>", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeGreaterThan(String value) {
            addCriterion("company_type >", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("company_type >=", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeLessThan(String value) {
            addCriterion("company_type <", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeLessThanOrEqualTo(String value) {
            addCriterion("company_type <=", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeLike(String value) {
            addCriterion("company_type like", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeNotLike(String value) {
            addCriterion("company_type not like", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeIn(List<String> values) {
            addCriterion("company_type in", values, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeNotIn(List<String> values) {
            addCriterion("company_type not in", values, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeBetween(String value1, String value2) {
            addCriterion("company_type between", value1, value2, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeNotBetween(String value1, String value2) {
            addCriterion("company_type not between", value1, value2, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanySizeIsNull() {
            addCriterion("company_size is null");
            return (Criteria) this;
        }

        public Criteria andCompanySizeIsNotNull() {
            addCriterion("company_size is not null");
            return (Criteria) this;
        }

        public Criteria andCompanySizeEqualTo(String value) {
            addCriterion("company_size =", value, "companySize");
            return (Criteria) this;
        }

        public Criteria andCompanySizeNotEqualTo(String value) {
            addCriterion("company_size <>", value, "companySize");
            return (Criteria) this;
        }

        public Criteria andCompanySizeGreaterThan(String value) {
            addCriterion("company_size >", value, "companySize");
            return (Criteria) this;
        }

        public Criteria andCompanySizeGreaterThanOrEqualTo(String value) {
            addCriterion("company_size >=", value, "companySize");
            return (Criteria) this;
        }

        public Criteria andCompanySizeLessThan(String value) {
            addCriterion("company_size <", value, "companySize");
            return (Criteria) this;
        }

        public Criteria andCompanySizeLessThanOrEqualTo(String value) {
            addCriterion("company_size <=", value, "companySize");
            return (Criteria) this;
        }

        public Criteria andCompanySizeLike(String value) {
            addCriterion("company_size like", value, "companySize");
            return (Criteria) this;
        }

        public Criteria andCompanySizeNotLike(String value) {
            addCriterion("company_size not like", value, "companySize");
            return (Criteria) this;
        }

        public Criteria andCompanySizeIn(List<String> values) {
            addCriterion("company_size in", values, "companySize");
            return (Criteria) this;
        }

        public Criteria andCompanySizeNotIn(List<String> values) {
            addCriterion("company_size not in", values, "companySize");
            return (Criteria) this;
        }

        public Criteria andCompanySizeBetween(String value1, String value2) {
            addCriterion("company_size between", value1, value2, "companySize");
            return (Criteria) this;
        }

        public Criteria andCompanySizeNotBetween(String value1, String value2) {
            addCriterion("company_size not between", value1, value2, "companySize");
            return (Criteria) this;
        }

        public Criteria andPartnershipDetailIsNull() {
            addCriterion("partnership_detail is null");
            return (Criteria) this;
        }

        public Criteria andPartnershipDetailIsNotNull() {
            addCriterion("partnership_detail is not null");
            return (Criteria) this;
        }

        public Criteria andPartnershipDetailEqualTo(String value) {
            addCriterion("partnership_detail =", value, "partnershipDetail");
            return (Criteria) this;
        }

        public Criteria andPartnershipDetailNotEqualTo(String value) {
            addCriterion("partnership_detail <>", value, "partnershipDetail");
            return (Criteria) this;
        }

        public Criteria andPartnershipDetailGreaterThan(String value) {
            addCriterion("partnership_detail >", value, "partnershipDetail");
            return (Criteria) this;
        }

        public Criteria andPartnershipDetailGreaterThanOrEqualTo(String value) {
            addCriterion("partnership_detail >=", value, "partnershipDetail");
            return (Criteria) this;
        }

        public Criteria andPartnershipDetailLessThan(String value) {
            addCriterion("partnership_detail <", value, "partnershipDetail");
            return (Criteria) this;
        }

        public Criteria andPartnershipDetailLessThanOrEqualTo(String value) {
            addCriterion("partnership_detail <=", value, "partnershipDetail");
            return (Criteria) this;
        }

        public Criteria andPartnershipDetailLike(String value) {
            addCriterion("partnership_detail like", value, "partnershipDetail");
            return (Criteria) this;
        }

        public Criteria andPartnershipDetailNotLike(String value) {
            addCriterion("partnership_detail not like", value, "partnershipDetail");
            return (Criteria) this;
        }

        public Criteria andPartnershipDetailIn(List<String> values) {
            addCriterion("partnership_detail in", values, "partnershipDetail");
            return (Criteria) this;
        }

        public Criteria andPartnershipDetailNotIn(List<String> values) {
            addCriterion("partnership_detail not in", values, "partnershipDetail");
            return (Criteria) this;
        }

        public Criteria andPartnershipDetailBetween(String value1, String value2) {
            addCriterion("partnership_detail between", value1, value2, "partnershipDetail");
            return (Criteria) this;
        }

        public Criteria andPartnershipDetailNotBetween(String value1, String value2) {
            addCriterion("partnership_detail not between", value1, value2, "partnershipDetail");
            return (Criteria) this;
        }

        public Criteria andMainProductIsNull() {
            addCriterion("main_product is null");
            return (Criteria) this;
        }

        public Criteria andMainProductIsNotNull() {
            addCriterion("main_product is not null");
            return (Criteria) this;
        }

        public Criteria andMainProductEqualTo(String value) {
            addCriterion("main_product =", value, "mainProduct");
            return (Criteria) this;
        }

        public Criteria andMainProductNotEqualTo(String value) {
            addCriterion("main_product <>", value, "mainProduct");
            return (Criteria) this;
        }

        public Criteria andMainProductGreaterThan(String value) {
            addCriterion("main_product >", value, "mainProduct");
            return (Criteria) this;
        }

        public Criteria andMainProductGreaterThanOrEqualTo(String value) {
            addCriterion("main_product >=", value, "mainProduct");
            return (Criteria) this;
        }

        public Criteria andMainProductLessThan(String value) {
            addCriterion("main_product <", value, "mainProduct");
            return (Criteria) this;
        }

        public Criteria andMainProductLessThanOrEqualTo(String value) {
            addCriterion("main_product <=", value, "mainProduct");
            return (Criteria) this;
        }

        public Criteria andMainProductLike(String value) {
            addCriterion("main_product like", value, "mainProduct");
            return (Criteria) this;
        }

        public Criteria andMainProductNotLike(String value) {
            addCriterion("main_product not like", value, "mainProduct");
            return (Criteria) this;
        }

        public Criteria andMainProductIn(List<String> values) {
            addCriterion("main_product in", values, "mainProduct");
            return (Criteria) this;
        }

        public Criteria andMainProductNotIn(List<String> values) {
            addCriterion("main_product not in", values, "mainProduct");
            return (Criteria) this;
        }

        public Criteria andMainProductBetween(String value1, String value2) {
            addCriterion("main_product between", value1, value2, "mainProduct");
            return (Criteria) this;
        }

        public Criteria andMainProductNotBetween(String value1, String value2) {
            addCriterion("main_product not between", value1, value2, "mainProduct");
            return (Criteria) this;
        }

        public Criteria andEstimateIncomeIsNull() {
            addCriterion("estimate_income is null");
            return (Criteria) this;
        }

        public Criteria andEstimateIncomeIsNotNull() {
            addCriterion("estimate_income is not null");
            return (Criteria) this;
        }

        public Criteria andEstimateIncomeEqualTo(String value) {
            addCriterion("estimate_income =", value, "estimateIncome");
            return (Criteria) this;
        }

        public Criteria andEstimateIncomeNotEqualTo(String value) {
            addCriterion("estimate_income <>", value, "estimateIncome");
            return (Criteria) this;
        }

        public Criteria andEstimateIncomeGreaterThan(String value) {
            addCriterion("estimate_income >", value, "estimateIncome");
            return (Criteria) this;
        }

        public Criteria andEstimateIncomeGreaterThanOrEqualTo(String value) {
            addCriterion("estimate_income >=", value, "estimateIncome");
            return (Criteria) this;
        }

        public Criteria andEstimateIncomeLessThan(String value) {
            addCriterion("estimate_income <", value, "estimateIncome");
            return (Criteria) this;
        }

        public Criteria andEstimateIncomeLessThanOrEqualTo(String value) {
            addCriterion("estimate_income <=", value, "estimateIncome");
            return (Criteria) this;
        }

        public Criteria andEstimateIncomeLike(String value) {
            addCriterion("estimate_income like", value, "estimateIncome");
            return (Criteria) this;
        }

        public Criteria andEstimateIncomeNotLike(String value) {
            addCriterion("estimate_income not like", value, "estimateIncome");
            return (Criteria) this;
        }

        public Criteria andEstimateIncomeIn(List<String> values) {
            addCriterion("estimate_income in", values, "estimateIncome");
            return (Criteria) this;
        }

        public Criteria andEstimateIncomeNotIn(List<String> values) {
            addCriterion("estimate_income not in", values, "estimateIncome");
            return (Criteria) this;
        }

        public Criteria andEstimateIncomeBetween(String value1, String value2) {
            addCriterion("estimate_income between", value1, value2, "estimateIncome");
            return (Criteria) this;
        }

        public Criteria andEstimateIncomeNotBetween(String value1, String value2) {
            addCriterion("estimate_income not between", value1, value2, "estimateIncome");
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

        public Criteria andDepositEqualTo(Double value) {
            addCriterion("deposit =", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotEqualTo(Double value) {
            addCriterion("deposit <>", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositGreaterThan(Double value) {
            addCriterion("deposit >", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositGreaterThanOrEqualTo(Double value) {
            addCriterion("deposit >=", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositLessThan(Double value) {
            addCriterion("deposit <", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositLessThanOrEqualTo(Double value) {
            addCriterion("deposit <=", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositIn(List<Double> values) {
            addCriterion("deposit in", values, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotIn(List<Double> values) {
            addCriterion("deposit not in", values, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositBetween(Double value1, Double value2) {
            addCriterion("deposit between", value1, value2, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotBetween(Double value1, Double value2) {
            addCriterion("deposit not between", value1, value2, "deposit");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIsNull() {
            addCriterion("check_status is null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIsNotNull() {
            addCriterion("check_status is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusEqualTo(String value) {
            addCriterion("check_status =", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotEqualTo(String value) {
            addCriterion("check_status <>", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThan(String value) {
            addCriterion("check_status >", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThanOrEqualTo(String value) {
            addCriterion("check_status >=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThan(String value) {
            addCriterion("check_status <", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThanOrEqualTo(String value) {
            addCriterion("check_status <=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLike(String value) {
            addCriterion("check_status like", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotLike(String value) {
            addCriterion("check_status not like", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIn(List<String> values) {
            addCriterion("check_status in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotIn(List<String> values) {
            addCriterion("check_status not in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusBetween(String value1, String value2) {
            addCriterion("check_status between", value1, value2, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotBetween(String value1, String value2) {
            addCriterion("check_status not between", value1, value2, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCompanyCertIsNull() {
            addCriterion("company_cert is null");
            return (Criteria) this;
        }

        public Criteria andCompanyCertIsNotNull() {
            addCriterion("company_cert is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyCertEqualTo(String value) {
            addCriterion("company_cert =", value, "companyCert");
            return (Criteria) this;
        }

        public Criteria andCompanyCertNotEqualTo(String value) {
            addCriterion("company_cert <>", value, "companyCert");
            return (Criteria) this;
        }

        public Criteria andCompanyCertGreaterThan(String value) {
            addCriterion("company_cert >", value, "companyCert");
            return (Criteria) this;
        }

        public Criteria andCompanyCertGreaterThanOrEqualTo(String value) {
            addCriterion("company_cert >=", value, "companyCert");
            return (Criteria) this;
        }

        public Criteria andCompanyCertLessThan(String value) {
            addCriterion("company_cert <", value, "companyCert");
            return (Criteria) this;
        }

        public Criteria andCompanyCertLessThanOrEqualTo(String value) {
            addCriterion("company_cert <=", value, "companyCert");
            return (Criteria) this;
        }

        public Criteria andCompanyCertLike(String value) {
            addCriterion("company_cert like", value, "companyCert");
            return (Criteria) this;
        }

        public Criteria andCompanyCertNotLike(String value) {
            addCriterion("company_cert not like", value, "companyCert");
            return (Criteria) this;
        }

        public Criteria andCompanyCertIn(List<String> values) {
            addCriterion("company_cert in", values, "companyCert");
            return (Criteria) this;
        }

        public Criteria andCompanyCertNotIn(List<String> values) {
            addCriterion("company_cert not in", values, "companyCert");
            return (Criteria) this;
        }

        public Criteria andCompanyCertBetween(String value1, String value2) {
            addCriterion("company_cert between", value1, value2, "companyCert");
            return (Criteria) this;
        }

        public Criteria andCompanyCertNotBetween(String value1, String value2) {
            addCriterion("company_cert not between", value1, value2, "companyCert");
            return (Criteria) this;
        }

        public Criteria andOwnerIdIsNull() {
            addCriterion("owner_id is null");
            return (Criteria) this;
        }

        public Criteria andOwnerIdIsNotNull() {
            addCriterion("owner_id is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerIdEqualTo(String value) {
            addCriterion("owner_id =", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotEqualTo(String value) {
            addCriterion("owner_id <>", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdGreaterThan(String value) {
            addCriterion("owner_id >", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdGreaterThanOrEqualTo(String value) {
            addCriterion("owner_id >=", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdLessThan(String value) {
            addCriterion("owner_id <", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdLessThanOrEqualTo(String value) {
            addCriterion("owner_id <=", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdLike(String value) {
            addCriterion("owner_id like", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotLike(String value) {
            addCriterion("owner_id not like", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdIn(List<String> values) {
            addCriterion("owner_id in", values, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotIn(List<String> values) {
            addCriterion("owner_id not in", values, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdBetween(String value1, String value2) {
            addCriterion("owner_id between", value1, value2, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotBetween(String value1, String value2) {
            addCriterion("owner_id not between", value1, value2, "ownerId");
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

        public Criteria andImagePathIsNull() {
            addCriterion("image_path is null");
            return (Criteria) this;
        }

        public Criteria andImagePathIsNotNull() {
            addCriterion("image_path is not null");
            return (Criteria) this;
        }

        public Criteria andImagePathEqualTo(String value) {
            addCriterion("image_path =", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathNotEqualTo(String value) {
            addCriterion("image_path <>", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathGreaterThan(String value) {
            addCriterion("image_path >", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathGreaterThanOrEqualTo(String value) {
            addCriterion("image_path >=", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathLessThan(String value) {
            addCriterion("image_path <", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathLessThanOrEqualTo(String value) {
            addCriterion("image_path <=", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathLike(String value) {
            addCriterion("image_path like", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathNotLike(String value) {
            addCriterion("image_path not like", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathIn(List<String> values) {
            addCriterion("image_path in", values, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathNotIn(List<String> values) {
            addCriterion("image_path not in", values, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathBetween(String value1, String value2) {
            addCriterion("image_path between", value1, value2, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathNotBetween(String value1, String value2) {
            addCriterion("image_path not between", value1, value2, "imagePath");
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