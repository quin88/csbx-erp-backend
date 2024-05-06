package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.SupermarketSupplier;
import com.jsh.erp.datasource.entities.SupermarketSupplierExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupermarketSupplierMapper {
    long countByExample(SupermarketSupplierExample example);

    int deleteByExample(SupermarketSupplierExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SupermarketSupplier record);

    int insertSelective(SupermarketSupplier record);

    List<SupermarketSupplier> selectByExample(SupermarketSupplierExample example);

    SupermarketSupplier selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SupermarketSupplier record, @Param("example") SupermarketSupplierExample example);

    int updateByExample(@Param("record") SupermarketSupplier record, @Param("example") SupermarketSupplierExample example);

    int updateByPrimaryKeySelective(SupermarketSupplier record);

    int updateByPrimaryKey(SupermarketSupplier record);
}