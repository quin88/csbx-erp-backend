package com.jsh.erp.datasource.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SmallDepotExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SmallDepotExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
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

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(Integer value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(Integer value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(Integer value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(Integer value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(Integer value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(Integer value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<Integer> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<Integer> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(Integer value1, Integer value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(Integer value1, Integer value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaUnitIsNull() {
            addCriterion("area_unit is null");
            return (Criteria) this;
        }

        public Criteria andAreaUnitIsNotNull() {
            addCriterion("area_unit is not null");
            return (Criteria) this;
        }

        public Criteria andAreaUnitEqualTo(String value) {
            addCriterion("area_unit =", value, "areaUnit");
            return (Criteria) this;
        }

        public Criteria andAreaUnitNotEqualTo(String value) {
            addCriterion("area_unit <>", value, "areaUnit");
            return (Criteria) this;
        }

        public Criteria andAreaUnitGreaterThan(String value) {
            addCriterion("area_unit >", value, "areaUnit");
            return (Criteria) this;
        }

        public Criteria andAreaUnitGreaterThanOrEqualTo(String value) {
            addCriterion("area_unit >=", value, "areaUnit");
            return (Criteria) this;
        }

        public Criteria andAreaUnitLessThan(String value) {
            addCriterion("area_unit <", value, "areaUnit");
            return (Criteria) this;
        }

        public Criteria andAreaUnitLessThanOrEqualTo(String value) {
            addCriterion("area_unit <=", value, "areaUnit");
            return (Criteria) this;
        }

        public Criteria andAreaUnitLike(String value) {
            addCriterion("area_unit like", value, "areaUnit");
            return (Criteria) this;
        }

        public Criteria andAreaUnitNotLike(String value) {
            addCriterion("area_unit not like", value, "areaUnit");
            return (Criteria) this;
        }

        public Criteria andAreaUnitIn(List<String> values) {
            addCriterion("area_unit in", values, "areaUnit");
            return (Criteria) this;
        }

        public Criteria andAreaUnitNotIn(List<String> values) {
            addCriterion("area_unit not in", values, "areaUnit");
            return (Criteria) this;
        }

        public Criteria andAreaUnitBetween(String value1, String value2) {
            addCriterion("area_unit between", value1, value2, "areaUnit");
            return (Criteria) this;
        }

        public Criteria andAreaUnitNotBetween(String value1, String value2) {
            addCriterion("area_unit not between", value1, value2, "areaUnit");
            return (Criteria) this;
        }

        public Criteria andVolumeIsNull() {
            addCriterion("volume is null");
            return (Criteria) this;
        }

        public Criteria andVolumeIsNotNull() {
            addCriterion("volume is not null");
            return (Criteria) this;
        }

        public Criteria andVolumeEqualTo(Integer value) {
            addCriterion("volume =", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeNotEqualTo(Integer value) {
            addCriterion("volume <>", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeGreaterThan(Integer value) {
            addCriterion("volume >", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeGreaterThanOrEqualTo(Integer value) {
            addCriterion("volume >=", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeLessThan(Integer value) {
            addCriterion("volume <", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeLessThanOrEqualTo(Integer value) {
            addCriterion("volume <=", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeIn(List<Integer> values) {
            addCriterion("volume in", values, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeNotIn(List<Integer> values) {
            addCriterion("volume not in", values, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeBetween(Integer value1, Integer value2) {
            addCriterion("volume between", value1, value2, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeNotBetween(Integer value1, Integer value2) {
            addCriterion("volume not between", value1, value2, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeUnitIsNull() {
            addCriterion("volume_unit is null");
            return (Criteria) this;
        }

        public Criteria andVolumeUnitIsNotNull() {
            addCriterion("volume_unit is not null");
            return (Criteria) this;
        }

        public Criteria andVolumeUnitEqualTo(String value) {
            addCriterion("volume_unit =", value, "volumeUnit");
            return (Criteria) this;
        }

        public Criteria andVolumeUnitNotEqualTo(String value) {
            addCriterion("volume_unit <>", value, "volumeUnit");
            return (Criteria) this;
        }

        public Criteria andVolumeUnitGreaterThan(String value) {
            addCriterion("volume_unit >", value, "volumeUnit");
            return (Criteria) this;
        }

        public Criteria andVolumeUnitGreaterThanOrEqualTo(String value) {
            addCriterion("volume_unit >=", value, "volumeUnit");
            return (Criteria) this;
        }

        public Criteria andVolumeUnitLessThan(String value) {
            addCriterion("volume_unit <", value, "volumeUnit");
            return (Criteria) this;
        }

        public Criteria andVolumeUnitLessThanOrEqualTo(String value) {
            addCriterion("volume_unit <=", value, "volumeUnit");
            return (Criteria) this;
        }

        public Criteria andVolumeUnitLike(String value) {
            addCriterion("volume_unit like", value, "volumeUnit");
            return (Criteria) this;
        }

        public Criteria andVolumeUnitNotLike(String value) {
            addCriterion("volume_unit not like", value, "volumeUnit");
            return (Criteria) this;
        }

        public Criteria andVolumeUnitIn(List<String> values) {
            addCriterion("volume_unit in", values, "volumeUnit");
            return (Criteria) this;
        }

        public Criteria andVolumeUnitNotIn(List<String> values) {
            addCriterion("volume_unit not in", values, "volumeUnit");
            return (Criteria) this;
        }

        public Criteria andVolumeUnitBetween(String value1, String value2) {
            addCriterion("volume_unit between", value1, value2, "volumeUnit");
            return (Criteria) this;
        }

        public Criteria andVolumeUnitNotBetween(String value1, String value2) {
            addCriterion("volume_unit not between", value1, value2, "volumeUnit");
            return (Criteria) this;
        }

        public Criteria andMaxGoodsQuantityIsNull() {
            addCriterion("max_goods_quantity is null");
            return (Criteria) this;
        }

        public Criteria andMaxGoodsQuantityIsNotNull() {
            addCriterion("max_goods_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andMaxGoodsQuantityEqualTo(Integer value) {
            addCriterion("max_goods_quantity =", value, "maxGoodsQuantity");
            return (Criteria) this;
        }

        public Criteria andMaxGoodsQuantityNotEqualTo(Integer value) {
            addCriterion("max_goods_quantity <>", value, "maxGoodsQuantity");
            return (Criteria) this;
        }

        public Criteria andMaxGoodsQuantityGreaterThan(Integer value) {
            addCriterion("max_goods_quantity >", value, "maxGoodsQuantity");
            return (Criteria) this;
        }

        public Criteria andMaxGoodsQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_goods_quantity >=", value, "maxGoodsQuantity");
            return (Criteria) this;
        }

        public Criteria andMaxGoodsQuantityLessThan(Integer value) {
            addCriterion("max_goods_quantity <", value, "maxGoodsQuantity");
            return (Criteria) this;
        }

        public Criteria andMaxGoodsQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("max_goods_quantity <=", value, "maxGoodsQuantity");
            return (Criteria) this;
        }

        public Criteria andMaxGoodsQuantityIn(List<Integer> values) {
            addCriterion("max_goods_quantity in", values, "maxGoodsQuantity");
            return (Criteria) this;
        }

        public Criteria andMaxGoodsQuantityNotIn(List<Integer> values) {
            addCriterion("max_goods_quantity not in", values, "maxGoodsQuantity");
            return (Criteria) this;
        }

        public Criteria andMaxGoodsQuantityBetween(Integer value1, Integer value2) {
            addCriterion("max_goods_quantity between", value1, value2, "maxGoodsQuantity");
            return (Criteria) this;
        }

        public Criteria andMaxGoodsQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("max_goods_quantity not between", value1, value2, "maxGoodsQuantity");
            return (Criteria) this;
        }

        public Criteria andMaxTemperatureIsNull() {
            addCriterion("max_temperature is null");
            return (Criteria) this;
        }

        public Criteria andMaxTemperatureIsNotNull() {
            addCriterion("max_temperature is not null");
            return (Criteria) this;
        }

        public Criteria andMaxTemperatureEqualTo(String value) {
            addCriterion("max_temperature =", value, "maxTemperature");
            return (Criteria) this;
        }

        public Criteria andMaxTemperatureNotEqualTo(String value) {
            addCriterion("max_temperature <>", value, "maxTemperature");
            return (Criteria) this;
        }

        public Criteria andMaxTemperatureGreaterThan(String value) {
            addCriterion("max_temperature >", value, "maxTemperature");
            return (Criteria) this;
        }

        public Criteria andMaxTemperatureGreaterThanOrEqualTo(String value) {
            addCriterion("max_temperature >=", value, "maxTemperature");
            return (Criteria) this;
        }

        public Criteria andMaxTemperatureLessThan(String value) {
            addCriterion("max_temperature <", value, "maxTemperature");
            return (Criteria) this;
        }

        public Criteria andMaxTemperatureLessThanOrEqualTo(String value) {
            addCriterion("max_temperature <=", value, "maxTemperature");
            return (Criteria) this;
        }

        public Criteria andMaxTemperatureLike(String value) {
            addCriterion("max_temperature like", value, "maxTemperature");
            return (Criteria) this;
        }

        public Criteria andMaxTemperatureNotLike(String value) {
            addCriterion("max_temperature not like", value, "maxTemperature");
            return (Criteria) this;
        }

        public Criteria andMaxTemperatureIn(List<String> values) {
            addCriterion("max_temperature in", values, "maxTemperature");
            return (Criteria) this;
        }

        public Criteria andMaxTemperatureNotIn(List<String> values) {
            addCriterion("max_temperature not in", values, "maxTemperature");
            return (Criteria) this;
        }

        public Criteria andMaxTemperatureBetween(String value1, String value2) {
            addCriterion("max_temperature between", value1, value2, "maxTemperature");
            return (Criteria) this;
        }

        public Criteria andMaxTemperatureNotBetween(String value1, String value2) {
            addCriterion("max_temperature not between", value1, value2, "maxTemperature");
            return (Criteria) this;
        }

        public Criteria andMinTemperatureIsNull() {
            addCriterion("min_temperature is null");
            return (Criteria) this;
        }

        public Criteria andMinTemperatureIsNotNull() {
            addCriterion("min_temperature is not null");
            return (Criteria) this;
        }

        public Criteria andMinTemperatureEqualTo(String value) {
            addCriterion("min_temperature =", value, "minTemperature");
            return (Criteria) this;
        }

        public Criteria andMinTemperatureNotEqualTo(String value) {
            addCriterion("min_temperature <>", value, "minTemperature");
            return (Criteria) this;
        }

        public Criteria andMinTemperatureGreaterThan(String value) {
            addCriterion("min_temperature >", value, "minTemperature");
            return (Criteria) this;
        }

        public Criteria andMinTemperatureGreaterThanOrEqualTo(String value) {
            addCriterion("min_temperature >=", value, "minTemperature");
            return (Criteria) this;
        }

        public Criteria andMinTemperatureLessThan(String value) {
            addCriterion("min_temperature <", value, "minTemperature");
            return (Criteria) this;
        }

        public Criteria andMinTemperatureLessThanOrEqualTo(String value) {
            addCriterion("min_temperature <=", value, "minTemperature");
            return (Criteria) this;
        }

        public Criteria andMinTemperatureLike(String value) {
            addCriterion("min_temperature like", value, "minTemperature");
            return (Criteria) this;
        }

        public Criteria andMinTemperatureNotLike(String value) {
            addCriterion("min_temperature not like", value, "minTemperature");
            return (Criteria) this;
        }

        public Criteria andMinTemperatureIn(List<String> values) {
            addCriterion("min_temperature in", values, "minTemperature");
            return (Criteria) this;
        }

        public Criteria andMinTemperatureNotIn(List<String> values) {
            addCriterion("min_temperature not in", values, "minTemperature");
            return (Criteria) this;
        }

        public Criteria andMinTemperatureBetween(String value1, String value2) {
            addCriterion("min_temperature between", value1, value2, "minTemperature");
            return (Criteria) this;
        }

        public Criteria andMinTemperatureNotBetween(String value1, String value2) {
            addCriterion("min_temperature not between", value1, value2, "minTemperature");
            return (Criteria) this;
        }

        public Criteria andRefrigerationMethodIsNull() {
            addCriterion("refrigeration_method is null");
            return (Criteria) this;
        }

        public Criteria andRefrigerationMethodIsNotNull() {
            addCriterion("refrigeration_method is not null");
            return (Criteria) this;
        }

        public Criteria andRefrigerationMethodEqualTo(String value) {
            addCriterion("refrigeration_method =", value, "refrigerationMethod");
            return (Criteria) this;
        }

        public Criteria andRefrigerationMethodNotEqualTo(String value) {
            addCriterion("refrigeration_method <>", value, "refrigerationMethod");
            return (Criteria) this;
        }

        public Criteria andRefrigerationMethodGreaterThan(String value) {
            addCriterion("refrigeration_method >", value, "refrigerationMethod");
            return (Criteria) this;
        }

        public Criteria andRefrigerationMethodGreaterThanOrEqualTo(String value) {
            addCriterion("refrigeration_method >=", value, "refrigerationMethod");
            return (Criteria) this;
        }

        public Criteria andRefrigerationMethodLessThan(String value) {
            addCriterion("refrigeration_method <", value, "refrigerationMethod");
            return (Criteria) this;
        }

        public Criteria andRefrigerationMethodLessThanOrEqualTo(String value) {
            addCriterion("refrigeration_method <=", value, "refrigerationMethod");
            return (Criteria) this;
        }

        public Criteria andRefrigerationMethodLike(String value) {
            addCriterion("refrigeration_method like", value, "refrigerationMethod");
            return (Criteria) this;
        }

        public Criteria andRefrigerationMethodNotLike(String value) {
            addCriterion("refrigeration_method not like", value, "refrigerationMethod");
            return (Criteria) this;
        }

        public Criteria andRefrigerationMethodIn(List<String> values) {
            addCriterion("refrigeration_method in", values, "refrigerationMethod");
            return (Criteria) this;
        }

        public Criteria andRefrigerationMethodNotIn(List<String> values) {
            addCriterion("refrigeration_method not in", values, "refrigerationMethod");
            return (Criteria) this;
        }

        public Criteria andRefrigerationMethodBetween(String value1, String value2) {
            addCriterion("refrigeration_method between", value1, value2, "refrigerationMethod");
            return (Criteria) this;
        }

        public Criteria andRefrigerationMethodNotBetween(String value1, String value2) {
            addCriterion("refrigeration_method not between", value1, value2, "refrigerationMethod");
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