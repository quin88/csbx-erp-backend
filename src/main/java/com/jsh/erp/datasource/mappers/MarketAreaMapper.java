package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.MarketArea;
import com.jsh.erp.datasource.entities.MarketAreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MarketAreaMapper {
    long countByExample(MarketAreaExample example);

    int deleteByExample(MarketAreaExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MarketArea record);

    int insertSelective(MarketArea record);

    List<MarketArea> selectByExample(MarketAreaExample example);

    MarketArea selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MarketArea record, @Param("example") MarketAreaExample example);

    int updateByExample(@Param("record") MarketArea record, @Param("example") MarketAreaExample example);

    int updateByPrimaryKeySelective(MarketArea record);

    int updateByPrimaryKey(MarketArea record);
}