package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.MarketAddress;
import com.jsh.erp.datasource.entities.MarketAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MarketAddressMapper {
    long countByExample(MarketAddressExample example);

    int deleteByExample(MarketAddressExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MarketAddress record);

    int insertSelective(MarketAddress record);

    List<MarketAddress> selectByExample(MarketAddressExample example);

    MarketAddress selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MarketAddress record, @Param("example") MarketAddressExample example);

    int updateByExample(@Param("record") MarketAddress record, @Param("example") MarketAddressExample example);

    int updateByPrimaryKeySelective(MarketAddress record);

    int updateByPrimaryKey(MarketAddress record);
}