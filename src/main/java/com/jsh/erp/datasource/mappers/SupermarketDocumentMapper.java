package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.SupermarketDocument;
import com.jsh.erp.datasource.entities.SupermarketDocumentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupermarketDocumentMapper {
    long countByExample(SupermarketDocumentExample example);

    int deleteByExample(SupermarketDocumentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SupermarketDocument record);

    int insertSelective(SupermarketDocument record);

    List<SupermarketDocument> selectByExample(SupermarketDocumentExample example);

    SupermarketDocument selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SupermarketDocument record, @Param("example") SupermarketDocumentExample example);

    int updateByExample(@Param("record") SupermarketDocument record, @Param("example") SupermarketDocumentExample example);

    int updateByPrimaryKeySelective(SupermarketDocument record);

    int updateByPrimaryKey(SupermarketDocument record);
}