package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.ShippingPrice;
import com.jsh.erp.datasource.entities.ShippingPriceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShippingPriceMapper {
    long countByExample(ShippingPriceExample example);

    int deleteByExample(ShippingPriceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShippingPrice record);

    int insertSelective(ShippingPrice record);

    List<ShippingPrice> selectByExample(ShippingPriceExample example);

    ShippingPrice selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShippingPrice record, @Param("example") ShippingPriceExample example);

    int updateByExample(@Param("record") ShippingPrice record, @Param("example") ShippingPriceExample example);

    int updateByPrimaryKeySelective(ShippingPrice record);

    int updateByPrimaryKey(ShippingPrice record);
}