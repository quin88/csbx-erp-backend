package com.jsh.erp.datasource.mappers;

import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface ProcessMapperEx {
    int batchDeleteProcessByIds(@Param("updateTime") Date updateTime, @Param("updater") Long updater, @Param("idArray") String[] idArray);
}
