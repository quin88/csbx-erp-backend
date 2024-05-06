package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.SourceType;
import com.jsh.erp.datasource.entities.SourceTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SourceTypeMapper {
    long countByExample(SourceTypeExample example);

    int deleteByExample(SourceTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SourceType record);

    int insertSelective(SourceType record);

    List<SourceType> selectByExample(SourceTypeExample example);

    SourceType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SourceType record, @Param("example") SourceTypeExample example);

    int updateByExample(@Param("record") SourceType record, @Param("example") SourceTypeExample example);

    int updateByPrimaryKeySelective(SourceType record);

    int updateByPrimaryKey(SourceType record);
}