package com.jsh.erp.datasource.mappers;

import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SupermarketDocumentItemMapperEx {

    Long selectIdByNumber(@Param("number") String number);


    int batchDeleteSupermarketOrderByIds(@Param("updateTime") Date updateTime, @Param("updater") Long updater, @Param("ids") String[] ids);

    List<Long> getExistingIds(@Param("documentId") Long documentId);

    void batchDeleteDocumentItemByIds(@Param("ids") List<Long> ids);
}
