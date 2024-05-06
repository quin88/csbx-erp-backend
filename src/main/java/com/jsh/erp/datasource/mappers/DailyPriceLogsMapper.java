package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.DailyPriceLogs;
import com.jsh.erp.datasource.entities.DailyPriceLogsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DailyPriceLogsMapper {
    long countByExample(DailyPriceLogsExample example);

    int deleteByExample(DailyPriceLogsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DailyPriceLogs record);

    int insertSelective(DailyPriceLogs record);

    List<DailyPriceLogs> selectByExample(DailyPriceLogsExample example);

    DailyPriceLogs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DailyPriceLogs record, @Param("example") DailyPriceLogsExample example);

    int updateByExample(@Param("record") DailyPriceLogs record, @Param("example") DailyPriceLogsExample example);

    int updateByPrimaryKeySelective(DailyPriceLogs record);

    int updateByPrimaryKey(DailyPriceLogs record);
}