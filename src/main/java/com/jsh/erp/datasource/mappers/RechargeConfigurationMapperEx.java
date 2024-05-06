package com.jsh.erp.datasource.mappers;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public interface RechargeConfigurationMapperEx {

    BigDecimal getGiftAmountByRechargeAmount(@Param("rechargeAmount") BigDecimal rechargeAmount);
}