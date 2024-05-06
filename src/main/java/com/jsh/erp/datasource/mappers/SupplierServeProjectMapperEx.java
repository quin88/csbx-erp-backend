package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.SupplierServeProject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SupplierServeProjectMapperEx {

    List<SupplierServeProject> searchSupplierServeProject(@Param("type") String type, @Param("supplierId") Long supplierId,
                                                          @Param("offset") Integer offset, @Param("rows") Integer rows);

    Long countSupplierServeProject(@Param("type") String type, @Param("supplierId") String supplierId);

    List<SupplierServeProject> selectSupplierServeProjectByNumber(@Param("number") String number);

    List<SupplierServeProject> getSupplierServeProjectListByServeProjectIds(@Param("serveProjectIds") String[] serveProjectIds);
}
