package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.SupermarketTax;
import com.jsh.erp.datasource.entities.SupermarketTaxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupermarketTaxMapper {
    long countByExample(SupermarketTaxExample example);

    int deleteByExample(SupermarketTaxExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SupermarketTax record);

    int insertSelective(SupermarketTax record);

    List<SupermarketTax> selectByExample(SupermarketTaxExample example);

    SupermarketTax selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SupermarketTax record, @Param("example") SupermarketTaxExample example);

    int updateByExample(@Param("record") SupermarketTax record, @Param("example") SupermarketTaxExample example);

    int updateByPrimaryKeySelective(SupermarketTax record);

    int updateByPrimaryKey(SupermarketTax record);
}