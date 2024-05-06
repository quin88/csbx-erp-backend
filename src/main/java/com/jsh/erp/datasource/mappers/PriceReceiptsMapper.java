package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.PriceReceipts;
import com.jsh.erp.datasource.entities.PriceReceiptsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PriceReceiptsMapper {
    long countByExample(PriceReceiptsExample example);

    int deleteByExample(PriceReceiptsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PriceReceipts record);

    int insertSelective(PriceReceipts record);

    List<PriceReceipts> selectByExample(PriceReceiptsExample example);

    PriceReceipts selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PriceReceipts record, @Param("example") PriceReceiptsExample example);

    int updateByExample(@Param("record") PriceReceipts record, @Param("example") PriceReceiptsExample example);

    int updateByPrimaryKeySelective(PriceReceipts record);

    int updateByPrimaryKey(PriceReceipts record);
}