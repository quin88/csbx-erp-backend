package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.StarLevel;
import com.jsh.erp.datasource.entities.StarLevelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StarLevelMapper {
    long countByExample(StarLevelExample example);

    int deleteByExample(StarLevelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StarLevel record);

    int insertSelective(StarLevel record);

    List<StarLevel> selectByExample(StarLevelExample example);

    StarLevel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StarLevel record, @Param("example") StarLevelExample example);

    int updateByExample(@Param("record") StarLevel record, @Param("example") StarLevelExample example);

    int updateByPrimaryKeySelective(StarLevel record);

    int updateByPrimaryKey(StarLevel record);
}