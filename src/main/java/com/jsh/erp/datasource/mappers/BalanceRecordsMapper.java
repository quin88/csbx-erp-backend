package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.BalanceRecords;
import com.jsh.erp.datasource.entities.BalanceRecordsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BalanceRecordsMapper {
    long countByExample(BalanceRecordsExample example);

    int deleteByExample(BalanceRecordsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BalanceRecords record);

    int insertSelective(BalanceRecords record);

    List<BalanceRecords> selectByExample(BalanceRecordsExample example);

    BalanceRecords selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BalanceRecords record, @Param("example") BalanceRecordsExample example);

    int updateByExample(@Param("record") BalanceRecords record, @Param("example") BalanceRecordsExample example);

    int updateByPrimaryKeySelective(BalanceRecords record);

    int updateByPrimaryKey(BalanceRecords record);
}