package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.Supplier;
import com.jsh.erp.datasource.vo.SupplierVoList;
import com.jsh.erp.datasource.vo.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SupplierMapperEx {

    List<SupplierVoList> selectByConditionSupplier(
            @Param("supplier") String supplier,
            @Param("type") String type,
            @Param("phonenum") String phonenum,
            @Param("telephone") String telephone,
            @Param("statusArray") String[] statusArray,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countsBySupplier(
            @Param("supplier") String supplier,
            @Param("type") String type,
            @Param("phonenum") String phonenum,
            @Param("telephone") String telephone,
            @Param("statusArray") String[] statusArray);

    List<Supplier> findByAll(
            @Param("supplier") String supplier,
            @Param("type") String type,
            @Param("phonenum") String phonenum,
            @Param("telephone") String telephone);

    int batchDeleteSupplierByIds(@Param("updateTime") Date updateTime, @Param("updater") Long updater, @Param("ids") String ids[]);

    Supplier getSupplierByNameAndType(
            @Param("supplier") String supplier,
            @Param("type") String type);

    List<UserVo> getSupplierByPhone(@Param("telephone") String phone);

    Long selectSupplierIdBySupplier(@Param("supplier") String supplier);

    int getSupplierNumberByPhone(@Param("telephone")String telephone,@Param("id") Long id);
}