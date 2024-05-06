package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.GoodsAllocation;
import com.jsh.erp.datasource.vo.GoodsAllocationVo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface GoodsAllocationMapperEx {
    int batchDeleteGoodsAllocationByIds(@Param("updateTime") Date updateTime,
                                        @Param("updater") Long updater,
                                        @Param("idArray") String[] idArray);

    List<GoodsAllocationVo> selectByConditionGoodsAllocation(@Param("depotId") Long depotId,
                                                             @Param("smallDepotId") Long smallDepotId,
                                                             @Param("number") String number,
                                                             @Param("capacityStatus") String capacityStatus,
                                                             @Param("enabled") String enabled,
                                                             @Param("offset") Integer offset,
                                                             @Param("rows") Integer rows);

    Long countsByGoodsAllocation(@Param("depotId") Long depotId,
                                 @Param("smallDepotId") Long smallDepotId,
                                 @Param("number") String number,
                                 @Param("capacityStatus") String capacityStatus,
                                 @Param("enabled") String enabled);

    GoodsAllocation selectRepetitionGoods(@Param("depotId") Long depotId,
                                          @Param("goodsAllocation") String goodsAllocation);

    Long countIsActive(@Param("idArray") String[] idArray);

    int batchDeleteSupplierExtendByIds(Date date, Long aLong, String[] idArray);
}
