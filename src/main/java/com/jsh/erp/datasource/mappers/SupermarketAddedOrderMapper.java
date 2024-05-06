package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.SupermarketAddedOrder;
import com.jsh.erp.datasource.entities.SupermarketAddedOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupermarketAddedOrderMapper {
    long countByExample(SupermarketAddedOrderExample example);

    int deleteByExample(SupermarketAddedOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SupermarketAddedOrder record);

    int insertSelective(SupermarketAddedOrder record);

    List<SupermarketAddedOrder> selectByExample(SupermarketAddedOrderExample example);

    SupermarketAddedOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SupermarketAddedOrder record, @Param("example") SupermarketAddedOrderExample example);

    int updateByExample(@Param("record") SupermarketAddedOrder record, @Param("example") SupermarketAddedOrderExample example);

    int updateByPrimaryKeySelective(SupermarketAddedOrder record);

    int updateByPrimaryKey(SupermarketAddedOrder record);
}