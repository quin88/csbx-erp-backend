package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.vo.SupermarketCooperationVoList;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SupermarketCooperationMapperEx {

    List<Long> getExistingIds(@Param(("supplierId")) Long supplierId);

    void batchDeleteSupermarketCooperationByIds(@Param("updateTime") Date updateTime, @Param("updater") Long updater, @Param("ids") List<Long> ids);

    int batchDeleteSupermarketCooperationBySupplierIds(@Param("updateTime") Date updateTime, @Param("updater") Long updater, @Param("supplierIds") String[] supplierIds);

    List<SupermarketCooperationVoList> findByAll(@Param("supplierIds")List<Long> supplierIds);
}
