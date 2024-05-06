package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.SmallDepot;
import com.jsh.erp.datasource.entities.SmallDepotExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmallDepotMapper {
    long countByExample(SmallDepotExample example);

    int deleteByExample(SmallDepotExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmallDepot record);

    int insertSelective(SmallDepot record);

    List<SmallDepot> selectByExample(SmallDepotExample example);

    SmallDepot selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmallDepot record, @Param("example") SmallDepotExample example);

    int updateByExample(@Param("record") SmallDepot record, @Param("example") SmallDepotExample example);

    int updateByPrimaryKeySelective(SmallDepot record);

    int updateByPrimaryKey(SmallDepot record);
}