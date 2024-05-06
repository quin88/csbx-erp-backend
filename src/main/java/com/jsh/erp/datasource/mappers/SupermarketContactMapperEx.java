package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.vo.SupermarketContactVoList;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SupermarketContactMapperEx {
    List<Long> getExistingIds(@Param("supplierId") Long supplierId);

    void batchDeleteSupermarketContactByIds(@Param("updateTime") Date updateTime, @Param("updater") Long updater, @Param("ids") List<Long> ids);

    int batchDeleteSupermarketContactBySupplierIds(@Param("updateTime") Date updateTime, @Param("updater") Long updater, @Param("supplierIds") String[] supplierIds);

    List<SupermarketContactVoList> findByAll(@Param("supplierIds")List<Long> supplierIds);
}
