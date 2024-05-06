package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.vo.SalesMarketVoList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SalesMarketMapperEx {
    List<Long> getExistingIds(@Param("materialId") Long materialId);

    int batchDeleteSalesMarketByIds(@Param("ids") List<Long> ids);

    int batchDeleteSalesMarketByMaterialIds(@Param("materialIds") List<Long> materialIds);

    List<SalesMarketVoList> findByAll(@Param("materialIds") List<Long> materialIds);
}
