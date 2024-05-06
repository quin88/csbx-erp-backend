package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.SmallDepot;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SmallDepotMapperEx {

    List<SmallDepot> selectSmallDepot(@Param("depotId") Long depotId,
                                      @Param("enabledFlag") String enabledFlag,
                                      @Param("offset") Integer offset,
                                      @Param("rows") Integer rows);

    Long countSmallDepot(@Param("depotId") Long depotId,
                         @Param("enabledFlag") String enabledFlag);
}
