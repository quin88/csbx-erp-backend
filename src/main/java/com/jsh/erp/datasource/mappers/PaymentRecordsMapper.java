package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.PaymentRecords;
import com.jsh.erp.datasource.entities.PaymentRecordsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PaymentRecordsMapper {
    long countByExample(PaymentRecordsExample example);

    int deleteByExample(PaymentRecordsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PaymentRecords record);

    int insertSelective(PaymentRecords record);

    List<PaymentRecords> selectByExample(PaymentRecordsExample example);

    PaymentRecords selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PaymentRecords record, @Param("example") PaymentRecordsExample example);

    int updateByExample(@Param("record") PaymentRecords record, @Param("example") PaymentRecordsExample example);

    int updateByPrimaryKeySelective(PaymentRecords record);

    int updateByPrimaryKey(PaymentRecords record);
}