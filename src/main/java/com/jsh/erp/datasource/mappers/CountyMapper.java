package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.County;
import com.jsh.erp.datasource.entities.CountyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CountyMapper {
    long countByExample(CountyExample example);

    int deleteByExample(CountyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(County record);

    int insertSelective(County record);

    List<County> selectByExample(CountyExample example);

    County selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") County record, @Param("example") CountyExample example);

    int updateByExample(@Param("record") County record, @Param("example") CountyExample example);

    int updateByPrimaryKeySelective(County record);

    int updateByPrimaryKey(County record);
}