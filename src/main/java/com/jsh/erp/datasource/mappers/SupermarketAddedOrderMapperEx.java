package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.vo.SupermarketAddedOrderVo;
import com.jsh.erp.datasource.vo.SupermarketOrderDifferenceDetailVo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SupermarketAddedOrderMapperEx {
    List<SupermarketAddedOrderVo> selectSupermarketAddedOrder(@Param("id") Long id,
                                                              @Param("beginTime") String beginTime,
                                                              @Param("endTime") String endTime,
                                                              @Param("number") String number,
                                                              @Param("statusArray") String[] statusArray,
                                                              @Param("linkNumber") String linkNumber,
                                                              @Param("offset") Integer offset,
                                                              @Param("rows") Integer rows);

    Long countSupermarketAddedOrder(@Param("id") Long id,
                                    @Param("beginTime") String beginTime,
                                    @Param("endTime") String endTime,
                                    @Param("number") String number,
                                    @Param("statusArray") String[] statusArray,
                                    @Param("linkNumber") String linkNumber);

    int batchDeleteByIds(@Param("updateTime") Date updateTime,
                         @Param("updater") Long updater,
                         @Param("ids") String[] ids);

    List<SupermarketOrderDifferenceDetailVo> getDifferenceDetail(@Param("linkId") Long linkId);

    SupermarketAddedOrderVo selectSupermarketAddedOrderById(@Param("id") Long id);
}
