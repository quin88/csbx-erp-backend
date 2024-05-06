package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.SupermarketInvoiceNumber;
import com.jsh.erp.datasource.entities.SupermarketInvoiceNumberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupermarketInvoiceNumberMapper {
    long countByExample(SupermarketInvoiceNumberExample example);

    int deleteByExample(SupermarketInvoiceNumberExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SupermarketInvoiceNumber record);

    int insertSelective(SupermarketInvoiceNumber record);

    List<SupermarketInvoiceNumber> selectByExample(SupermarketInvoiceNumberExample example);

    SupermarketInvoiceNumber selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SupermarketInvoiceNumber record, @Param("example") SupermarketInvoiceNumberExample example);

    int updateByExample(@Param("record") SupermarketInvoiceNumber record, @Param("example") SupermarketInvoiceNumberExample example);

    int updateByPrimaryKeySelective(SupermarketInvoiceNumber record);

    int updateByPrimaryKey(SupermarketInvoiceNumber record);
}