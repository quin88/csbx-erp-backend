package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.vo.LocationVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LocationMapperEx {

    List<LocationVo> selectLocation(@Param("depotId") Long depotId,
                                    @Param("smallDepotId") Long smallDepotId,
                                    @Param("enabledFlag") String enabledFlag,
                                    @Param("offset") Integer offset,
                                    @Param("rows") Integer rows);

    Long countLocation(@Param("depotId") Long depotId,
                       @Param("smallDepotId") Long smallDepotId,
                       @Param("enabledFlag") String enabledFlag);
}
