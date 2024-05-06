package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.SupermarketSystemConfig;
import com.jsh.erp.datasource.entities.SupermarketSystemConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupermarketSystemConfigMapper {
    long countByExample(SupermarketSystemConfigExample example);

    int deleteByExample(SupermarketSystemConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SupermarketSystemConfig record);

    int insertSelective(SupermarketSystemConfig record);

    List<SupermarketSystemConfig> selectByExample(SupermarketSystemConfigExample example);

    SupermarketSystemConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SupermarketSystemConfig record, @Param("example") SupermarketSystemConfigExample example);

    int updateByExample(@Param("record") SupermarketSystemConfig record, @Param("example") SupermarketSystemConfigExample example);

    int updateByPrimaryKeySelective(SupermarketSystemConfig record);

    int updateByPrimaryKey(SupermarketSystemConfig record);
}