package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.SupplierLevel;
import com.jsh.erp.datasource.entities.SupplierLevelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupplierLevelMapper {
    long countByExample(SupplierLevelExample example);

    int deleteByExample(SupplierLevelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SupplierLevel record);

    int insertSelective(SupplierLevel record);

    List<SupplierLevel> selectByExample(SupplierLevelExample example);

    SupplierLevel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SupplierLevel record, @Param("example") SupplierLevelExample example);

    int updateByExample(@Param("record") SupplierLevel record, @Param("example") SupplierLevelExample example);

    int updateByPrimaryKeySelective(SupplierLevel record);

    int updateByPrimaryKey(SupplierLevel record);
}