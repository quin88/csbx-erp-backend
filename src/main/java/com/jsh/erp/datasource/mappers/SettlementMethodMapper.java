package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.SettlementMethod;
import com.jsh.erp.datasource.entities.SettlementMethodExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SettlementMethodMapper {
    long countByExample(SettlementMethodExample example);

    int deleteByExample(SettlementMethodExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SettlementMethod record);

    int insertSelective(SettlementMethod record);

    List<SettlementMethod> selectByExample(SettlementMethodExample example);

    SettlementMethod selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SettlementMethod record, @Param("example") SettlementMethodExample example);

    int updateByExample(@Param("record") SettlementMethod record, @Param("example") SettlementMethodExample example);

    int updateByPrimaryKeySelective(SettlementMethod record);

    int updateByPrimaryKey(SettlementMethod record);
}