package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.SupermarketFinance;
import com.jsh.erp.datasource.entities.SupermarketFinanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupermarketFinanceMapper {
    long countByExample(SupermarketFinanceExample example);

    int deleteByExample(SupermarketFinanceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SupermarketFinance record);

    int insertSelective(SupermarketFinance record);

    List<SupermarketFinance> selectByExample(SupermarketFinanceExample example);

    SupermarketFinance selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SupermarketFinance record, @Param("example") SupermarketFinanceExample example);

    int updateByExample(@Param("record") SupermarketFinance record, @Param("example") SupermarketFinanceExample example);

    int updateByPrimaryKeySelective(SupermarketFinance record);

    int updateByPrimaryKey(SupermarketFinance record);
}