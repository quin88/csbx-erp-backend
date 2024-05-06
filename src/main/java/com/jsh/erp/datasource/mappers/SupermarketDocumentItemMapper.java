package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.SupermarketDocumentItem;
import com.jsh.erp.datasource.entities.SupermarketDocumentItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupermarketDocumentItemMapper {
    long countByExample(SupermarketDocumentItemExample example);

    int deleteByExample(SupermarketDocumentItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SupermarketDocumentItem record);

    int insertSelective(SupermarketDocumentItem record);

    List<SupermarketDocumentItem> selectByExample(SupermarketDocumentItemExample example);

    SupermarketDocumentItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SupermarketDocumentItem record, @Param("example") SupermarketDocumentItemExample example);

    int updateByExample(@Param("record") SupermarketDocumentItem record, @Param("example") SupermarketDocumentItemExample example);

    int updateByPrimaryKeySelective(SupermarketDocumentItem record);

    int updateByPrimaryKey(SupermarketDocumentItem record);
}