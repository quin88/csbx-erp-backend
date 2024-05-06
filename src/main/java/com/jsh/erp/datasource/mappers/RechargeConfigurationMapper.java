package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.RechargeConfiguration;
import com.jsh.erp.datasource.entities.RechargeConfigurationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RechargeConfigurationMapper {
    long countByExample(RechargeConfigurationExample example);

    int deleteByExample(RechargeConfigurationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RechargeConfiguration record);

    int insertSelective(RechargeConfiguration record);

    List<RechargeConfiguration> selectByExample(RechargeConfigurationExample example);

    RechargeConfiguration selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RechargeConfiguration record, @Param("example") RechargeConfigurationExample example);

    int updateByExample(@Param("record") RechargeConfiguration record, @Param("example") RechargeConfigurationExample example);

    int updateByPrimaryKeySelective(RechargeConfiguration record);

    int updateByPrimaryKey(RechargeConfiguration record);
}