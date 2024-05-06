package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.PriceDetails;
import com.jsh.erp.datasource.entities.PriceDetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PriceDetailsMapper {
    long countByExample(PriceDetailsExample example);

    int deleteByExample(PriceDetailsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PriceDetails record);

    int insertSelective(PriceDetails record);

    List<PriceDetails> selectByExample(PriceDetailsExample example);

    PriceDetails selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PriceDetails record, @Param("example") PriceDetailsExample example);

    int updateByExample(@Param("record") PriceDetails record, @Param("example") PriceDetailsExample example);

    int updateByPrimaryKeySelective(PriceDetails record);

    int updateByPrimaryKey(PriceDetails record);
}