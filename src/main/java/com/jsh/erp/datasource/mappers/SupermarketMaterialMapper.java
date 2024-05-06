package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.SupermarketMaterial;
import com.jsh.erp.datasource.entities.SupermarketMaterialExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupermarketMaterialMapper {
    long countByExample(SupermarketMaterialExample example);

    int deleteByExample(SupermarketMaterialExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SupermarketMaterial record);

    int insertSelective(SupermarketMaterial record);

    List<SupermarketMaterial> selectByExample(SupermarketMaterialExample example);

    SupermarketMaterial selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SupermarketMaterial record, @Param("example") SupermarketMaterialExample example);

    int updateByExample(@Param("record") SupermarketMaterial record, @Param("example") SupermarketMaterialExample example);

    int updateByPrimaryKeySelective(SupermarketMaterial record);

    int updateByPrimaryKey(SupermarketMaterial record);
}