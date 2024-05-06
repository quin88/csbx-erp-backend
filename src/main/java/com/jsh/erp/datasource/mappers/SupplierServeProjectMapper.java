package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.SupplierServeProject;
import com.jsh.erp.datasource.entities.SupplierServeProjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupplierServeProjectMapper {
    long countByExample(SupplierServeProjectExample example);

    int deleteByExample(SupplierServeProjectExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SupplierServeProject record);

    int insertSelective(SupplierServeProject record);

    List<SupplierServeProject> selectByExample(SupplierServeProjectExample example);

    SupplierServeProject selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SupplierServeProject record, @Param("example") SupplierServeProjectExample example);

    int updateByExample(@Param("record") SupplierServeProject record, @Param("example") SupplierServeProjectExample example);

    int updateByPrimaryKeySelective(SupplierServeProject record);

    int updateByPrimaryKey(SupplierServeProject record);
}