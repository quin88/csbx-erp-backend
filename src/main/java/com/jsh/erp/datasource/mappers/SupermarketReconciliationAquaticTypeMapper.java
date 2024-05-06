package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.SupermarketReconciliationAquaticType;
import com.jsh.erp.datasource.entities.SupermarketReconciliationAquaticTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupermarketReconciliationAquaticTypeMapper {
    long countByExample(SupermarketReconciliationAquaticTypeExample example);

    int deleteByExample(SupermarketReconciliationAquaticTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SupermarketReconciliationAquaticType record);

    int insertSelective(SupermarketReconciliationAquaticType record);

    List<SupermarketReconciliationAquaticType> selectByExample(SupermarketReconciliationAquaticTypeExample example);

    SupermarketReconciliationAquaticType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SupermarketReconciliationAquaticType record, @Param("example") SupermarketReconciliationAquaticTypeExample example);

    int updateByExample(@Param("record") SupermarketReconciliationAquaticType record, @Param("example") SupermarketReconciliationAquaticTypeExample example);

    int updateByPrimaryKeySelective(SupermarketReconciliationAquaticType record);

    int updateByPrimaryKey(SupermarketReconciliationAquaticType record);
}