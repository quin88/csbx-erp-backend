package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CityMapperEx {
    List<City> selectConditionByCity(@Param("name") String name,
                                     @Param("province") Long province,
                                     @Param("offset") Integer offset,
                                     @Param("rows") Integer rows);

    Long countByCity(@Param("name") String name,
                     @Param("province") Long province);
}
