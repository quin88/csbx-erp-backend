package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.vo.SupermarketInvoiceVoList;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SupermarketInvoiceMapperEx {
    List<Long> getExistingIds(@Param("supplierId") Long supplierId);

    void batchDeleteSupermarketInvoiceByIds(@Param("updateTime") Date updateTime, @Param("updater") Long updater, @Param("ids") List<Long> ids);

    int batchDeleteSupermarketInvoiceBySupplierIds(@Param("updateTime") Date updateTime, @Param("updater") Long updater, @Param("supplierIds") String[] supplierIds);

    List<SupermarketInvoiceVoList> findByAll(@Param("supplierIds")List<Long> supplierIds);
}
