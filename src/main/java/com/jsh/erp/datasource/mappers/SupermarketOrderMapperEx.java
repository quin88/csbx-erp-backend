package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.vo.SupermarketOrderDifferenceDetailVo;
import com.jsh.erp.datasource.vo.SupermarketOrderVo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SupermarketOrderMapperEx {

    Long selectIdByNumber(@Param("number") String number);

    List<SupermarketOrderVo> selectSupermarketOrder(
            @Param("id") Long id,
            @Param("categoryArray") String[] categoryArray,
            @Param("beginTime") String beginTime,
            @Param("endTime") String endTime,
            @Param("number") String number,
            @Param("statusArray") String[] statusArray,
            @Param("uploadStatusArray") String[] uploadStatusArray,
            @Param("serveClientId") Long serveClientId,
            @Param("tradeBeginTime") String tradeBeginTime,
            @Param("tradeEndTime") String tradeEndTime,
            @Param("marketAddressId") Long marketAddressId,
            @Param("linkFlag") String linkFlag,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countSupermarketOrder(
            @Param("id") Long id,
            @Param("categoryArray") String[] categoryArray,
            @Param("beginTime") String beginTime,
            @Param("endTime") String endTime,
            @Param("number") String number,
            @Param("statusArray") String[] statusArray,
            @Param("uploadStatusArray") String[] uploadStatusArray,
            @Param("serveClientId") Long serveClientId,
            @Param("tradeBeginTime") String tradeBeginTime,
            @Param("tradeEndTime") String tradeEndTime,
            @Param("marketAddressId") Long marketAddressId,
            @Param("linkFlag") String linkFlag);

    int batchDeleteSupermarketOrderByIds(@Param("updateTime") Date updateTime,
                                         @Param("updater") Long updater,
                                         @Param("ids") String[] ids);

    SupermarketOrderVo selectSupermarketOrderById(@Param("id") Long id);

    List<SupermarketOrderDifferenceDetailVo> getDifferenceDetail(@Param("linkId") Long linkId);
}
