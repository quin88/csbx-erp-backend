package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.SupermarketAccount;
import com.jsh.erp.datasource.entities.SupermarketAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupermarketAccountMapper {
    long countByExample(SupermarketAccountExample example);

    int deleteByExample(SupermarketAccountExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SupermarketAccount record);

    int insertSelective(SupermarketAccount record);

    List<SupermarketAccount> selectByExample(SupermarketAccountExample example);

    SupermarketAccount selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SupermarketAccount record, @Param("example") SupermarketAccountExample example);

    int updateByExample(@Param("record") SupermarketAccount record, @Param("example") SupermarketAccountExample example);

    int updateByPrimaryKeySelective(SupermarketAccount record);

    int updateByPrimaryKey(SupermarketAccount record);
}