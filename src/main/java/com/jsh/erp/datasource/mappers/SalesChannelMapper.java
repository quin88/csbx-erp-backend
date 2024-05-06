package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.SalesChannel;
import com.jsh.erp.datasource.entities.SalesChannelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalesChannelMapper {
    long countByExample(SalesChannelExample example);

    int deleteByExample(SalesChannelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SalesChannel record);

    int insertSelective(SalesChannel record);

    List<SalesChannel> selectByExample(SalesChannelExample example);

    SalesChannel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SalesChannel record, @Param("example") SalesChannelExample example);

    int updateByExample(@Param("record") SalesChannel record, @Param("example") SalesChannelExample example);

    int updateByPrimaryKeySelective(SalesChannel record);

    int updateByPrimaryKey(SalesChannel record);
}