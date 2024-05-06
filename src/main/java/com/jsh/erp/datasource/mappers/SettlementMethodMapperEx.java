package com.jsh.erp.datasource.mappers;

import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface SettlementMethodMapperEx {
    int batchDeleteSettlementMethodByIds(@Param("updateTime") Date updateTime, @Param("updater") Long updater, @Param("ids") String[] ids);
}
