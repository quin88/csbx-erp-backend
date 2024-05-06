package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.SalesInfo;
import com.jsh.erp.datasource.entities.SalesInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalesInfoMapper {
    long countByExample(SalesInfoExample example);

    int deleteByExample(SalesInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SalesInfo record);

    int insertSelective(SalesInfo record);

    List<SalesInfo> selectByExample(SalesInfoExample example);

    SalesInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SalesInfo record, @Param("example") SalesInfoExample example);

    int updateByExample(@Param("record") SalesInfo record, @Param("example") SalesInfoExample example);

    int updateByPrimaryKeySelective(SalesInfo record);

    int updateByPrimaryKey(SalesInfo record);
}