package com.jsh.erp.datasource.mappers;

import org.apache.ibatis.annotations.Param;

public interface MarketAreaMapperEx {

    int batchDeleteMarketAreaByIds(@Param("idArray") String[] idArray);

    int batchDeleteByMarketIds(@Param("idArray") String[] idArray);
}
