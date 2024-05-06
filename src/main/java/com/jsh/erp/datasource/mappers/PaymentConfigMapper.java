package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.PaymentConfig;
import com.jsh.erp.datasource.entities.PaymentConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PaymentConfigMapper {
    long countByExample(PaymentConfigExample example);

    int deleteByExample(PaymentConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PaymentConfig record);

    int insertSelective(PaymentConfig record);

    List<PaymentConfig> selectByExample(PaymentConfigExample example);

    PaymentConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PaymentConfig record, @Param("example") PaymentConfigExample example);

    int updateByExample(@Param("record") PaymentConfig record, @Param("example") PaymentConfigExample example);

    int updateByPrimaryKeySelective(PaymentConfig record);

    int updateByPrimaryKey(PaymentConfig record);
}