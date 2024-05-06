package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.FeesSettlementEx;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface FeesSettlementMapperEx {
    List<FeesSettlementEx> selectBySupplierId(@Param("supplierId")Long supplierId);

    int batchDeleteBySupplierIds(@Param("updateTime") Date updateTime, @Param("updater") Long updater, @Param("ids") String ids[]);

    int deleteByPrimaryKey(@Param("updateTime") Date updateTime, @Param("updater") Long updater,@Param("id") Long id);
}