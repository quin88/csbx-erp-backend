package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.SupermarketCooperation;
import com.jsh.erp.datasource.entities.SupermarketCooperationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupermarketCooperationMapper {
    long countByExample(SupermarketCooperationExample example);

    int deleteByExample(SupermarketCooperationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SupermarketCooperation record);

    int insertSelective(SupermarketCooperation record);

    List<SupermarketCooperation> selectByExample(SupermarketCooperationExample example);

    SupermarketCooperation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SupermarketCooperation record, @Param("example") SupermarketCooperationExample example);

    int updateByExample(@Param("record") SupermarketCooperation record, @Param("example") SupermarketCooperationExample example);

    int updateByPrimaryKeySelective(SupermarketCooperation record);

    int updateByPrimaryKey(SupermarketCooperation record);
}