package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.Measurement;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MeasurementMapperEx {
    int batchDeleteMeasurementByIds(@Param("ids") String[] ids);

    List<Measurement> selectByConditionMeasurement(@Param("offset") int offset,
                                                   @Param("rows") int rows);

    Long countMeasurement();

}
