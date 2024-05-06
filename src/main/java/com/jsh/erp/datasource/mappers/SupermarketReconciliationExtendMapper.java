package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.SupermarketReconciliationExtend;
import com.jsh.erp.datasource.entities.SupermarketReconciliationExtendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupermarketReconciliationExtendMapper {
    long countByExample(SupermarketReconciliationExtendExample example);

    int deleteByExample(SupermarketReconciliationExtendExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SupermarketReconciliationExtend record);

    int insertSelective(SupermarketReconciliationExtend record);

    List<SupermarketReconciliationExtend> selectByExample(SupermarketReconciliationExtendExample example);

    SupermarketReconciliationExtend selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SupermarketReconciliationExtend record, @Param("example") SupermarketReconciliationExtendExample example);

    int updateByExample(@Param("record") SupermarketReconciliationExtend record, @Param("example") SupermarketReconciliationExtendExample example);

    int updateByPrimaryKeySelective(SupermarketReconciliationExtend record);

    int updateByPrimaryKey(SupermarketReconciliationExtend record);
}