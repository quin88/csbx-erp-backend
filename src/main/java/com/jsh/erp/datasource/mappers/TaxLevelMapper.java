package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.TaxLevel;
import com.jsh.erp.datasource.entities.TaxLevelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaxLevelMapper {
    long countByExample(TaxLevelExample example);

    int deleteByExample(TaxLevelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TaxLevel record);

    int insertSelective(TaxLevel record);

    List<TaxLevel> selectByExample(TaxLevelExample example);

    TaxLevel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TaxLevel record, @Param("example") TaxLevelExample example);

    int updateByExample(@Param("record") TaxLevel record, @Param("example") TaxLevelExample example);

    int updateByPrimaryKeySelective(TaxLevel record);

    int updateByPrimaryKey(TaxLevel record);
}