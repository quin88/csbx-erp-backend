package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.BusinessType;
import com.jsh.erp.datasource.entities.BusinessTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BusinessTypeMapper {
    long countByExample(BusinessTypeExample example);

    int deleteByExample(BusinessTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BusinessType record);

    int insertSelective(BusinessType record);

    List<BusinessType> selectByExample(BusinessTypeExample example);

    BusinessType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BusinessType record, @Param("example") BusinessTypeExample example);

    int updateByExample(@Param("record") BusinessType record, @Param("example") BusinessTypeExample example);

    int updateByPrimaryKeySelective(BusinessType record);

    int updateByPrimaryKey(BusinessType record);
}