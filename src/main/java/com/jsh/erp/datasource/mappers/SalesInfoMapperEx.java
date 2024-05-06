package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.vo.SalesInfoVoList;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SalesInfoMapperEx {
    List<Long> getExistingIds(@Param("materialId") Long materialId);

    int batchDeleteSalesInfoByIds(@Param("ids") List<Long> ids);

    int batchDeleteSalesInfoByMaterialIds(@Param("materialIds") List<Long> materialIds);

    List<SalesInfoVoList> findByAll(@Param("materialIds") List<Long> materialIds);
}
