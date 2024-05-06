package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.TemperatureCondition;
import com.jsh.erp.datasource.entities.TemperatureConditionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TemperatureConditionMapper {
    long countByExample(TemperatureConditionExample example);

    int deleteByExample(TemperatureConditionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TemperatureCondition record);

    int insertSelective(TemperatureCondition record);

    List<TemperatureCondition> selectByExample(TemperatureConditionExample example);

    TemperatureCondition selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TemperatureCondition record, @Param("example") TemperatureConditionExample example);

    int updateByExample(@Param("record") TemperatureCondition record, @Param("example") TemperatureConditionExample example);

    int updateByPrimaryKeySelective(TemperatureCondition record);

    int updateByPrimaryKey(TemperatureCondition record);
}