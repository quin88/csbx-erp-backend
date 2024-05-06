package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.SupermarketFinanceRelevancy;
import com.jsh.erp.datasource.entities.SupermarketFinanceRelevancyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupermarketFinanceRelevancyMapper {
    long countByExample(SupermarketFinanceRelevancyExample example);

    int deleteByExample(SupermarketFinanceRelevancyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SupermarketFinanceRelevancy record);

    int insertSelective(SupermarketFinanceRelevancy record);

    List<SupermarketFinanceRelevancy> selectByExample(SupermarketFinanceRelevancyExample example);

    SupermarketFinanceRelevancy selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SupermarketFinanceRelevancy record, @Param("example") SupermarketFinanceRelevancyExample example);

    int updateByExample(@Param("record") SupermarketFinanceRelevancy record, @Param("example") SupermarketFinanceRelevancyExample example);

    int updateByPrimaryKeySelective(SupermarketFinanceRelevancy record);

    int updateByPrimaryKey(SupermarketFinanceRelevancy record);
}