package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.SupermarketOrder;
import com.jsh.erp.datasource.entities.SupermarketOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupermarketOrderMapper {
    long countByExample(SupermarketOrderExample example);

    int deleteByExample(SupermarketOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SupermarketOrder record);

    int insertSelective(SupermarketOrder record);

    List<SupermarketOrder> selectByExample(SupermarketOrderExample example);

    SupermarketOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SupermarketOrder record, @Param("example") SupermarketOrderExample example);

    int updateByExample(@Param("record") SupermarketOrder record, @Param("example") SupermarketOrderExample example);

    int updateByPrimaryKeySelective(SupermarketOrder record);

    int updateByPrimaryKey(SupermarketOrder record);
}