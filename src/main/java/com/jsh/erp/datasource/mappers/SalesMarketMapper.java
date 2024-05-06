package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.SalesMarket;
import com.jsh.erp.datasource.entities.SalesMarketExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalesMarketMapper {
    long countByExample(SalesMarketExample example);

    int deleteByExample(SalesMarketExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SalesMarket record);

    int insertSelective(SalesMarket record);

    List<SalesMarket> selectByExample(SalesMarketExample example);

    SalesMarket selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SalesMarket record, @Param("example") SalesMarketExample example);

    int updateByExample(@Param("record") SalesMarket record, @Param("example") SalesMarketExample example);

    int updateByPrimaryKeySelective(SalesMarket record);

    int updateByPrimaryKey(SalesMarket record);
}