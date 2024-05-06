package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.SecondMeasurement;
import com.jsh.erp.datasource.entities.SecondMeasurementExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondMeasurementMapper {
    long countByExample(SecondMeasurementExample example);

    int deleteByExample(SecondMeasurementExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SecondMeasurement record);

    int insertSelective(SecondMeasurement record);

    List<SecondMeasurement> selectByExample(SecondMeasurementExample example);

    SecondMeasurement selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SecondMeasurement record, @Param("example") SecondMeasurementExample example);

    int updateByExample(@Param("record") SecondMeasurement record, @Param("example") SecondMeasurementExample example);

    int updateByPrimaryKeySelective(SecondMeasurement record);

    int updateByPrimaryKey(SecondMeasurement record);
}