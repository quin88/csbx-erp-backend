package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.CooperationCategory;
import com.jsh.erp.datasource.entities.CooperationCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CooperationCategoryMapper {
    long countByExample(CooperationCategoryExample example);

    int deleteByExample(CooperationCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CooperationCategory record);

    int insertSelective(CooperationCategory record);

    List<CooperationCategory> selectByExample(CooperationCategoryExample example);

    CooperationCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CooperationCategory record, @Param("example") CooperationCategoryExample example);

    int updateByExample(@Param("record") CooperationCategory record, @Param("example") CooperationCategoryExample example);

    int updateByPrimaryKeySelective(CooperationCategory record);

    int updateByPrimaryKey(CooperationCategory record);
}