package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.SupermarketFinanceExtend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SupermarketFinanceExtendMapperEx {

    int countProofOfPayment(@Param("sfId") Long sfId);

    int countPaymentStatus(@Param("sfId") Long sfId);

    List<SupermarketFinanceExtend> getProofOfPaymentByOrderId(@Param("linkId") Long linkId);

    int updateStatus(@Param("idArray") String[] idArray,
                     @Param("downloadStatus") String downloadStatus,
                     @Param("paymentStatus") String paymentStatus);
}