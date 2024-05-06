package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.SupermarketContact;
import com.jsh.erp.datasource.entities.SupermarketContactExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupermarketContactMapper {
    long countByExample(SupermarketContactExample example);

    int deleteByExample(SupermarketContactExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SupermarketContact record);

    int insertSelective(SupermarketContact record);

    List<SupermarketContact> selectByExample(SupermarketContactExample example);

    SupermarketContact selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SupermarketContact record, @Param("example") SupermarketContactExample example);

    int updateByExample(@Param("record") SupermarketContact record, @Param("example") SupermarketContactExample example);

    int updateByPrimaryKeySelective(SupermarketContact record);

    int updateByPrimaryKey(SupermarketContact record);
}