package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.SupplierExtend;
import com.jsh.erp.datasource.entities.SupplierExtendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupplierExtendMapper {
    long countByExample(SupplierExtendExample example);

    int deleteByExample(SupplierExtendExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SupplierExtend record);

    int insertSelective(SupplierExtend record);

    List<SupplierExtend> selectByExample(SupplierExtendExample example);

    SupplierExtend selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SupplierExtend record, @Param("example") SupplierExtendExample example);

    int updateByExample(@Param("record") SupplierExtend record, @Param("example") SupplierExtendExample example);

    int updateByPrimaryKeySelective(SupplierExtend record);

    int updateByPrimaryKey(SupplierExtend record);
}