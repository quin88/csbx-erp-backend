package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.SupermarketReconciliationRelevancy;
import com.jsh.erp.datasource.entities.SupermarketReconciliationRelevancyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupermarketReconciliationRelevancyMapper {
    long countByExample(SupermarketReconciliationRelevancyExample example);

    int deleteByExample(SupermarketReconciliationRelevancyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SupermarketReconciliationRelevancy record);

    int insertSelective(SupermarketReconciliationRelevancy record);

    List<SupermarketReconciliationRelevancy> selectByExample(SupermarketReconciliationRelevancyExample example);

    SupermarketReconciliationRelevancy selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SupermarketReconciliationRelevancy record, @Param("example") SupermarketReconciliationRelevancyExample example);

    int updateByExample(@Param("record") SupermarketReconciliationRelevancy record, @Param("example") SupermarketReconciliationRelevancyExample example);

    int updateByPrimaryKeySelective(SupermarketReconciliationRelevancy record);

    int updateByPrimaryKey(SupermarketReconciliationRelevancy record);
}