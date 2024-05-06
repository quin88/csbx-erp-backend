package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.DepotEx;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface DepotMapperEx {

    List<DepotEx> selectByConditionDepot(
            @Param("name") String name,
            @Param("type") Integer type,
            @Param("remark") String remark,
            @Param("enabledFlag") String enabledFlag,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countsByDepot(
            @Param("name") String name,
            @Param("type") Integer type,
            @Param("remark") String remark,
            @Param("enabledFlag") String enabledFlag);

    int batchDeleteDepotByIds(@Param("updateTime") Date updateTime,
                              @Param("updater") Long updater,
                              @Param("ids") String ids[]);

    Long selectDepotIdByDepot(@Param("name") String name);
}