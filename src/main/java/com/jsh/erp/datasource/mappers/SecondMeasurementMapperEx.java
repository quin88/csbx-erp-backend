package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.vo.SecondMeasurementVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SecondMeasurementMapperEx {
    int batchDeleteSecondMeasurementByIds(@Param("ids") String[] ids);

    List<SecondMeasurementVo> selectByConditionSecondMeasurement(@Param("measurementId") Long measurementId,
                                                                 @Param("offset") int offset,
                                                                 @Param("rows") int rows);

    Long countSecondMeasurement(@Param("measurementId") Long measurementId);
}
