package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.vo.SupermarketFinanceVo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SupermarketFinanceMapperEx {
    List<SupermarketFinanceVo> selectSupermarketFinance(@Param("id") Long id,
                                                        @Param("aquaticTypeId") Long aquaticTypeId,
                                                        @Param("marketId") Long marketId,
                                                        @Param("beginTime") String beginTime,
                                                        @Param("endTime") String endTime,
                                                        @Param("number") String number,
                                                        @Param("statusArray") String[] statusArray,
                                                        @Param("linkNumber") String linkNumber,
                                                        @Param("offset") Integer offset,
                                                        @Param("rows") Integer rows);

    Long countSupermarketFinance(@Param("id") Long id,
                                 @Param("aquaticTypeId") Long aquaticTypeId,
                                 @Param("marketId") Long marketId,
                                 @Param("beginTime") String beginTime,
                                 @Param("endTime") String endTime,
                                 @Param("number") String number,
                                 @Param("statusArray") String[] statusArray,
                                 @Param("linkNumber") String linkNumber);

    int batchDeleteByIds(@Param("updateTime") Date updateTime,
                         @Param("updater") Long updater,
                         @Param("ids") String[] ids);

    SupermarketFinanceVo selectSupermarketFinanceById(@Param("id") Long id);

    Long selectIdByNumber(@Param("number") String number);

    List<SupermarketFinanceVo> selectSupermarketFinanceByPayDate(@Param("startDate") Date startDate,
                                                                 @Param("endDate") Date endDate);

    SupermarketFinanceVo selectSupermarketFinanceByOrderId(@Param("orderId") Long orderId,
                                                           @Param("sfId") Long sfId);
}
