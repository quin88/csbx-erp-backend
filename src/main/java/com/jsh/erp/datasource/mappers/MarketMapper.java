package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.Market;
import com.jsh.erp.datasource.entities.MarketExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MarketMapper {
    long countByExample(MarketExample example);

    int deleteByExample(MarketExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Market record);

    int insertSelective(Market record);

    List<Market> selectByExample(MarketExample example);

    Market selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Market record, @Param("example") MarketExample example);

    int updateByExample(@Param("record") Market record, @Param("example") MarketExample example);

    int updateByPrimaryKeySelective(Market record);

    int updateByPrimaryKey(Market record);
}