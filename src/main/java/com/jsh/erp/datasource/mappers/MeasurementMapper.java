package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.Measurement;
import com.jsh.erp.datasource.entities.MeasurementExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MeasurementMapper {
    long countByExample(MeasurementExample example);

    int deleteByExample(MeasurementExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Measurement record);

    int insertSelective(Measurement record);

    List<Measurement> selectByExample(MeasurementExample example);

    Measurement selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Measurement record, @Param("example") MeasurementExample example);

    int updateByExample(@Param("record") Measurement record, @Param("example") MeasurementExample example);

    int updateByPrimaryKeySelective(Measurement record);

    int updateByPrimaryKey(Measurement record);
}