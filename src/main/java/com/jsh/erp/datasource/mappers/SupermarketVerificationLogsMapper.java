package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.SupermarketVerificationLogs;
import com.jsh.erp.datasource.entities.SupermarketVerificationLogsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupermarketVerificationLogsMapper {
    long countByExample(SupermarketVerificationLogsExample example);

    int deleteByExample(SupermarketVerificationLogsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SupermarketVerificationLogs record);

    int insertSelective(SupermarketVerificationLogs record);

    List<SupermarketVerificationLogs> selectByExample(SupermarketVerificationLogsExample example);

    SupermarketVerificationLogs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SupermarketVerificationLogs record, @Param("example") SupermarketVerificationLogsExample example);

    int updateByExample(@Param("record") SupermarketVerificationLogs record, @Param("example") SupermarketVerificationLogsExample example);

    int updateByPrimaryKeySelective(SupermarketVerificationLogs record);

    int updateByPrimaryKey(SupermarketVerificationLogs record);
}