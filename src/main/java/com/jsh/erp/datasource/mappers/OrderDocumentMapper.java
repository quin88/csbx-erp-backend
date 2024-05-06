package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.OrderDocument;
import com.jsh.erp.datasource.entities.OrderDocumentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderDocumentMapper {
    long countByExample(OrderDocumentExample example);

    int deleteByExample(OrderDocumentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderDocument record);

    int insertSelective(OrderDocument record);

    List<OrderDocument> selectByExample(OrderDocumentExample example);

    OrderDocument selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderDocument record, @Param("example") OrderDocumentExample example);

    int updateByExample(@Param("record") OrderDocument record, @Param("example") OrderDocumentExample example);

    int updateByPrimaryKeySelective(OrderDocument record);

    int updateByPrimaryKey(OrderDocument record);
}