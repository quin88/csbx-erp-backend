package com.jsh.erp.datasource.mappers;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FileInfoMapperEx {
    List<Long> getExistingIds(@Param("materialId") Long materialId, @Param("baseInfoId") Long baseInfoId);

    int batchDeleteFile(@Param("ids") List<Long> fileIds);
}
