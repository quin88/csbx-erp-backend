package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.SupermarketReconciliation;
import com.jsh.erp.datasource.entities.SupermarketReconciliationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupermarketReconciliationMapper {
    long countByExample(SupermarketReconciliationExample example);

    int deleteByExample(SupermarketReconciliationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SupermarketReconciliation record);

    int insertSelective(SupermarketReconciliation record);

    List<SupermarketReconciliation> selectByExample(SupermarketReconciliationExample example);

    SupermarketReconciliation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SupermarketReconciliation record, @Param("example") SupermarketReconciliationExample example);

    int updateByExample(@Param("record") SupermarketReconciliation record, @Param("example") SupermarketReconciliationExample example);

    int updateByPrimaryKeySelective(SupermarketReconciliation record);

    int updateByPrimaryKey(SupermarketReconciliation record);
}