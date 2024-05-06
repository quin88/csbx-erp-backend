package com.jsh.erp.datasource.mappers;


import com.jsh.erp.datasource.entities.PaymentRecords;
import com.jsh.erp.datasource.vo.ImportPriceReceiptsVo4List;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface PaymentRecordsMapperEx {

    List<PaymentRecords> getHistoricalRecordsBySupplierId(@Param("supplierId") String supplierId, @Param("beginTime") String beginTime,
                                                          @Param("endTime") String endTime, @Param("statusArray") String[] statusArray,
                                                          @Param("offset") Integer offset, @Param("rows") Integer rows);


    List<PaymentRecords> getHistoricalRecordsList(@Param("supplierId") String supplierId, @Param("beginTime") String beginTime,
                                                  @Param("endTime") String endTime, @Param("statusArray") String[] statusArray,
                                                  @Param("paymentStatus") Integer paymentStatus, @Param("offset") Integer offset, @Param("rows") Integer rows);

    int batchDeletePaymentRecordsByIds(@Param("updateTime") Date updateTime, @Param("updater") Long updater, @Param("ids") String[] ids);

    List<PaymentRecords> getHistoricalDocumentsBySupplierId(@Param("supplierId") String supplierId, @Param("beginTime") String beginTime,
                                                            @Param("endTime") String endTime, @Param("offset") Integer offset,
                                                            @Param("rows") Integer rows);

    Long countsHistoricalRecordsList(@Param("supplierId") String supplierId, @Param("beginTime") String beginTime,
                                     @Param("endTime") String endTime, @Param("statusArray") String[] statusArray,
                                     @Param("paymentStatus") Integer paymentStatus);

    Long countsHistoricalRecordsBySupplierId(@Param("supplierId") String supplierId, @Param("beginTime") String beginTime,
                                             @Param("endTime") String endTime, @Param("statusArray") String[] statusArray);

    Long countsHistoricalDocumentsBySupplierId(@Param("supplierId") String supplierId, @Param("beginTime") String beginTime,
                                               @Param("endTime") String endTime, @Param("statusArray") String[] statusArray);

    List<PaymentRecords> selectByConditionPaymentRecords(@Param("supplierId") String supplierId, @Param("beginTime") String beginTime,
                                                         @Param("endTime") String endTime, @Param("statusArray") String[] statusArray,
                                                         @Param("offset") Integer offset, @Param("rows") Integer rows);

    List<ImportPriceReceiptsVo4List> selectPaymentRecordsBySupplierIdAndTime(@Param("supplierId") Long supplierId, @Param("beginTime") String beginTime,
                                                                             @Param("endTime") String endTime);

    BigDecimal getRemainingSumStatistics(@Param("supplierId") Long supplierId,
                                         @Param("endTime") String endTime);
}
