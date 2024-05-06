package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.SupermarketUnit;
import com.jsh.erp.datasource.entities.SupermarketUnitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupermarketUnitMapper {
    long countByExample(SupermarketUnitExample example);

    int deleteByExample(SupermarketUnitExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SupermarketUnit record);

    int insertSelective(SupermarketUnit record);

    List<SupermarketUnit> selectByExample(SupermarketUnitExample example);

    SupermarketUnit selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SupermarketUnit record, @Param("example") SupermarketUnitExample example);

    int updateByExample(@Param("record") SupermarketUnit record, @Param("example") SupermarketUnitExample example);

    int updateByPrimaryKeySelective(SupermarketUnit record);

    int updateByPrimaryKey(SupermarketUnit record);
}