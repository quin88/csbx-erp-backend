package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.InvoiceNumber;
import com.jsh.erp.datasource.entities.InvoiceNumberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InvoiceNumberMapper {
    long countByExample(InvoiceNumberExample example);

    int deleteByExample(InvoiceNumberExample example);

    int deleteByPrimaryKey(Long id);

    int insert(InvoiceNumber record);

    int insertSelective(InvoiceNumber record);

    List<InvoiceNumber> selectByExample(InvoiceNumberExample example);

    InvoiceNumber selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") InvoiceNumber record, @Param("example") InvoiceNumberExample example);

    int updateByExample(@Param("record") InvoiceNumber record, @Param("example") InvoiceNumberExample example);

    int updateByPrimaryKeySelective(InvoiceNumber record);

    int updateByPrimaryKey(InvoiceNumber record);
}