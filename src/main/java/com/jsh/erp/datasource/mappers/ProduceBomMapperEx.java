package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.ProduceBom;
import com.jsh.erp.datasource.entities.ProduceBomExample;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ProduceBomMapperEx {

    int batchDeleteProduceBomByIds(@Param("updateTime") Date updateTime, @Param("updater") Long updater, @Param("idArray") String[] idArray);

    List<ProduceBom> getProduceBomList(@Param("produceBomParam") String produceBomParam,
                                       @Param("offset") Integer offset,
                                       @Param("rows") Integer rows);

    Long countProduceBomList(@Param("produceBomParam") String produceBomParam);
}