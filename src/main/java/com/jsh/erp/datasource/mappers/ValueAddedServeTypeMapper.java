package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.ValueAddedServeType;
import com.jsh.erp.datasource.entities.ValueAddedServeTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ValueAddedServeTypeMapper {
    long countByExample(ValueAddedServeTypeExample example);

    int deleteByExample(ValueAddedServeTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ValueAddedServeType record);

    int insertSelective(ValueAddedServeType record);

    List<ValueAddedServeType> selectByExample(ValueAddedServeTypeExample example);

    ValueAddedServeType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ValueAddedServeType record, @Param("example") ValueAddedServeTypeExample example);

    int updateByExample(@Param("record") ValueAddedServeType record, @Param("example") ValueAddedServeTypeExample example);

    int updateByPrimaryKeySelective(ValueAddedServeType record);

    int updateByPrimaryKey(ValueAddedServeType record);
}