package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.SupplierExtend;
import com.jsh.erp.datasource.vo.SupplierExtendVoList;
import com.jsh.erp.datasource.vo.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SupplierExtendMapperEx {
    List<SupplierExtendVoList> selectByConditionSupplierExtend(
            @Param("supplierId") String supplierId,
            @Param("active") String active,
            @Param("name") String name,
            @Param("phone") String phone,
            @Param("role") String role,
            @Param("statusArray") String[] statusArray,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countByConditionSupplierExtend(@Param("supplierId") String supplierId,
                                        @Param("active") String active,
                                        @Param("name") String name,
                                        @Param("phone") String phone,
                                        @Param("role") String role,
                                        @Param("statusArray") String[] statusArray);

    Long countIsActive(@Param("idArray") String[] idArray);

    int batchDeleteSupplierExtendByIds(@Param("updateTime") Date updateTime, @Param("updater") Long updater, @Param("ids") String[] ids);

    SupplierExtend selectBySupplierIdAndRole(@Param("supplierId") Long supplierId);

    List<UserVo> getSupplierExtendByPhone(@Param("phone") String phone);

    int countIsActiveSupplierExtend(@Param("supplierId") Long supplierId,@Param("activeFlag") int activeFlag);
}
