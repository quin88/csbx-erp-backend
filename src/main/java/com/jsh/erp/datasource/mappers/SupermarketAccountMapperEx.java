package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.SupermarketAccount;
import com.jsh.erp.datasource.entities.SupermarketSupplier;
import com.jsh.erp.datasource.vo.SupermarketAccountVoList;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SupermarketAccountMapperEx {
    List<Long> getExistingIds(@Param("supplierId") Long supplierId);

    void batchDeleteSupermarketAccountByIds(@Param("updateTime") Date updateTime, @Param("updater") Long updater, @Param("ids") List<Long> ids);

    int batchDeleteSupermarketAccountBySupplierIds(@Param("updateTime") Date updateTime, @Param("updater") Long updater, @Param("supplierIds") String[] supplierIds);

    List<SupermarketAccountVoList> findByAll(@Param("supplierIds") List<Long> supplierIds);

    List<SupermarketAccountVoList> getSupermarketAccountList();
}
