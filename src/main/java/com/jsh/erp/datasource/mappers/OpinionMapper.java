package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.Opinion;
import com.jsh.erp.datasource.entities.OpinionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OpinionMapper {
    long countByExample(OpinionExample example);

    int deleteByExample(OpinionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Opinion record);

    int insertSelective(Opinion record);

    List<Opinion> selectByExample(OpinionExample example);

    Opinion selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Opinion record, @Param("example") OpinionExample example);

    int updateByExample(@Param("record") Opinion record, @Param("example") OpinionExample example);

    int updateByPrimaryKeySelective(Opinion record);

    int updateByPrimaryKey(Opinion record);
}