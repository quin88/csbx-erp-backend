package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.Market;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MarketMapperEx {

    List<Market> selectByConditionMarket(@Param("number") String number, @Param("name") String name, @Param("enabled") String enabled, int offset, int rows);

    Long countByConditionMarket(@Param("number") String number, @Param("name") String name, @Param("enabled") String enabled);

    Long selectMarketByNumber(@Param("number") String number);
}
