package com.jsh.erp.datasource.mappers;

import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SupermarketAttachmentMapperEx {
    List<Long> getExistingIds(@Param("supplierId") Long supplierId);

    void batchDeleteSupermarketAttachmentByIds(@Param("updateTime") Date updateTime, @Param("updater") Long updater, @Param("ids") List<Long> ids);

    int batchDeleteSupermarketAttachmentBySupplierIds(@Param("updateTime") Date updateTime, @Param("updater") Long updater, @Param("supplierIds") String[] supplierIds);
}
