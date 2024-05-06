package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.SupermarketFinanceExtend;
import com.jsh.erp.datasource.entities.SupermarketFinanceExtendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupermarketFinanceExtendMapper {
    long countByExample(SupermarketFinanceExtendExample example);

    int deleteByExample(SupermarketFinanceExtendExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SupermarketFinanceExtend record);

    int insertSelective(SupermarketFinanceExtend record);

    List<SupermarketFinanceExtend> selectByExample(SupermarketFinanceExtendExample example);

    SupermarketFinanceExtend selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SupermarketFinanceExtend record, @Param("example") SupermarketFinanceExtendExample example);

    int updateByExample(@Param("record") SupermarketFinanceExtend record, @Param("example") SupermarketFinanceExtendExample example);

    int updateByPrimaryKeySelective(SupermarketFinanceExtend record);

    int updateByPrimaryKey(SupermarketFinanceExtend record);
}