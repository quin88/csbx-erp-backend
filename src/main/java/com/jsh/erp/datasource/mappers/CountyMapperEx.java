package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.County;
import com.jsh.erp.datasource.vo.CountyVo4List;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CountyMapperEx {

    List<CountyVo4List> selectByConditionCounty(@Param("id") Long id, @Param("provinceId") Long provinceId, @Param("cityId") Long cityId,
                                                @Param("countyName") String countyName, @Param("enabled") String enabled, int offset, int rows);

    Long countByConditionCounty(@Param("id") Long id, @Param("provinceId") Long provinceId, @Param("cityId") Long cityId,
                                @Param("countyName") String countyName, @Param("enabled") String enabled);

    List<County> getCountyById(@Param("provinceId") Long provinceId,
                               @Param("cityId") Long cityId);
}
