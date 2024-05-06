package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.ShippingPrice;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ShippingPriceMapperEx {

    void batchDelete(@Param("ids") List<Long> ids);

    int batchDeleteShippingPriceByReceiptsNumbers(@Param("updateTime") Date updateTime, @Param("updater") Long updater, @Param("receiptsNumberArray") String[] receiptsNumberArray);

    List<ShippingPrice> selectShippingPriceByReceiptsNumber(@Param("receiptsNumber") String number);
}