package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.ValueAddedServe;
import com.jsh.erp.datasource.entities.ValueAddedServeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ValueAddedServeMapper {
    long countByExample(ValueAddedServeExample example);

    int deleteByExample(ValueAddedServeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ValueAddedServe record);

    int insertSelective(ValueAddedServe record);

    List<ValueAddedServe> selectByExample(ValueAddedServeExample example);

    ValueAddedServe selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ValueAddedServe record, @Param("example") ValueAddedServeExample example);

    int updateByExample(@Param("record") ValueAddedServe record, @Param("example") ValueAddedServeExample example);

    int updateByPrimaryKeySelective(ValueAddedServe record);

    int updateByPrimaryKey(ValueAddedServe record);
}