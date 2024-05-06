package com.jsh.erp.datasource.mappers;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ImageInfoMapperEx {
    List<Long> getExistingIds(@Param("materialId") Long materialId);
}
