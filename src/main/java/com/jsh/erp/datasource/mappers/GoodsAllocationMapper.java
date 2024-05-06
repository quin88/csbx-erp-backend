package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.GoodsAllocation;
import com.jsh.erp.datasource.entities.GoodsAllocationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsAllocationMapper {
    long countByExample(GoodsAllocationExample example);

    int deleteByExample(GoodsAllocationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsAllocation record);

    int insertSelective(GoodsAllocation record);

    List<GoodsAllocation> selectByExample(GoodsAllocationExample example);

    GoodsAllocation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsAllocation record, @Param("example") GoodsAllocationExample example);

    int updateByExample(@Param("record") GoodsAllocation record, @Param("example") GoodsAllocationExample example);

    int updateByPrimaryKeySelective(GoodsAllocation record);

    int updateByPrimaryKey(GoodsAllocation record);
}