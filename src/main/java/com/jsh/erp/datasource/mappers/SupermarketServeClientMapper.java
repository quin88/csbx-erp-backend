package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.SupermarketServeClient;
import com.jsh.erp.datasource.entities.SupermarketServeClientExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupermarketServeClientMapper {
    long countByExample(SupermarketServeClientExample example);

    int deleteByExample(SupermarketServeClientExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SupermarketServeClient record);

    int insertSelective(SupermarketServeClient record);

    List<SupermarketServeClient> selectByExample(SupermarketServeClientExample example);

    SupermarketServeClient selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SupermarketServeClient record, @Param("example") SupermarketServeClientExample example);

    int updateByExample(@Param("record") SupermarketServeClient record, @Param("example") SupermarketServeClientExample example);

    int updateByPrimaryKeySelective(SupermarketServeClient record);

    int updateByPrimaryKey(SupermarketServeClient record);
}