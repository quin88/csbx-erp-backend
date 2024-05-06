package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.FeesSettlement;
import com.jsh.erp.datasource.entities.FeesSettlementExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface FeesSettlementMapper {
    long countByExample(FeesSettlementExample example);

    int deleteByExample(FeesSettlementExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FeesSettlement record);

    int insertSelective(FeesSettlement record);

    List<FeesSettlement> selectByExample(FeesSettlementExample example);

    FeesSettlement selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FeesSettlement record, @Param("example") FeesSettlementExample example);

    int updateByExample(@Param("record") FeesSettlement record, @Param("example") FeesSettlementExample example);

    int updateByPrimaryKeySelective(FeesSettlement record);

    int updateByPrimaryKey(FeesSettlement record);

}