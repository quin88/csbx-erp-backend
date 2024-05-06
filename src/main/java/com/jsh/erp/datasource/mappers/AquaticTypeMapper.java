package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.AquaticType;
import com.jsh.erp.datasource.entities.AquaticTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AquaticTypeMapper {
    long countByExample(AquaticTypeExample example);

    int deleteByExample(AquaticTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AquaticType record);

    int insertSelective(AquaticType record);

    List<AquaticType> selectByExample(AquaticTypeExample example);

    AquaticType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AquaticType record, @Param("example") AquaticTypeExample example);

    int updateByExample(@Param("record") AquaticType record, @Param("example") AquaticTypeExample example);

    int updateByPrimaryKeySelective(AquaticType record);

    int updateByPrimaryKey(AquaticType record);
}