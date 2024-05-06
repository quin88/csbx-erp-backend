package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.SecondSettlementMethod;
import com.jsh.erp.datasource.entities.SecondSettlementMethodExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondSettlementMethodMapper {
    long countByExample(SecondSettlementMethodExample example);

    int deleteByExample(SecondSettlementMethodExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SecondSettlementMethod record);

    int insertSelective(SecondSettlementMethod record);

    List<SecondSettlementMethod> selectByExample(SecondSettlementMethodExample example);

    SecondSettlementMethod selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SecondSettlementMethod record, @Param("example") SecondSettlementMethodExample example);

    int updateByExample(@Param("record") SecondSettlementMethod record, @Param("example") SecondSettlementMethodExample example);

    int updateByPrimaryKeySelective(SecondSettlementMethod record);

    int updateByPrimaryKey(SecondSettlementMethod record);
}