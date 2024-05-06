package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.SupermarketInvoice;
import com.jsh.erp.datasource.entities.SupermarketInvoiceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupermarketInvoiceMapper {
    long countByExample(SupermarketInvoiceExample example);

    int deleteByExample(SupermarketInvoiceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SupermarketInvoice record);

    int insertSelective(SupermarketInvoice record);

    List<SupermarketInvoice> selectByExample(SupermarketInvoiceExample example);

    SupermarketInvoice selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SupermarketInvoice record, @Param("example") SupermarketInvoiceExample example);

    int updateByExample(@Param("record") SupermarketInvoice record, @Param("example") SupermarketInvoiceExample example);

    int updateByPrimaryKeySelective(SupermarketInvoice record);

    int updateByPrimaryKey(SupermarketInvoice record);
}