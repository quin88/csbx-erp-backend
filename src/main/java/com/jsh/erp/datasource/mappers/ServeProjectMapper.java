package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.ServeProject;
import com.jsh.erp.datasource.entities.ServeProjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServeProjectMapper {
    long countByExample(ServeProjectExample example);

    int deleteByExample(ServeProjectExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ServeProject record);

    int insertSelective(ServeProject record);

    List<ServeProject> selectByExample(ServeProjectExample example);

    ServeProject selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ServeProject record, @Param("example") ServeProjectExample example);

    int updateByExample(@Param("record") ServeProject record, @Param("example") ServeProjectExample example);

    int updateByPrimaryKeySelective(ServeProject record);

    int updateByPrimaryKey(ServeProject record);
}