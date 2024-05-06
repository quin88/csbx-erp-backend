package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.SupermarketSupplier;
import com.jsh.erp.datasource.vo.SupermarketSupplierVoList;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SupermarketSupplierMapperEx {
    int batchDeleteSuperMarketSupplierByIds(@Param("updateTime") Date updateTime, @Param("updater") Long updater, @Param("ids") String[] ids);

    List<SupermarketSupplierVoList> selectByConditionSupermarketSupplier(@Param("number") String number,
                                                                         @Param("name") String name,
                                                                         @Param("supplierLevel") String supplierLevel,
                                                                         @Param("statusArray") String[] statusArray,
                                                                         @Param("offset") Integer offset,
                                                                         @Param("rows") Integer rows);

    Long countSupermarketSupplier(@Param("number") String number,
                                  @Param("name") String name,
                                  @Param("supplierLevel") String supplierLevel,
                                  @Param("statusArray") String[] statusArray);

    SupermarketSupplierVoList selectByPrimaryKey(@Param("id") Long id);

    Long countHasSupplier(@Param("marketIds") List<Long> marketIds);

    List<SupermarketSupplierVoList> findByAll(@Param("ids")List<Long> ids);

}
