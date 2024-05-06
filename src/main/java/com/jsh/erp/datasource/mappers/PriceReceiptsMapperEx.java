package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.PriceReceipts;
import com.jsh.erp.datasource.vo.ImportPriceReceiptsVo4List;
import com.jsh.erp.datasource.vo.PriceReceiptsVo;
import com.jsh.erp.datasource.vo.PriceReceiptsVoSExpense;
import com.jsh.erp.datasource.vo.PriceReceiptsVoSMonthExpense;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface PriceReceiptsMapperEx {

    PriceReceipts selectPriceReceiptsByNumber(@Param("number") String number);

    PriceReceipts selectPriceReceiptsByReceiptsNumber(@Param("receiptsNumber") String receiptsNumber);

    List<PriceReceiptsVo> selectPriceReceiptsList(@Param("supplierId") String supplierId, @Param("priceType") String priceType,
                                                  @Param("beginTime") String beginTime, @Param("endTime") String endTime,
                                                  @Param("statusArray") String[] statusArray, @Param("offset") Integer offset, @Param("rows") Integer rows);

    int batchDeletePriceReceiptsByIds(@Param("updateTime") Date updateTime, @Param("updater") Long updater, @Param("ids") String[] ids);

    Long countsPriceReceipts(@Param("supplierId") String supplierId, @Param("priceType") String priceType, @Param("beginTime") String beginTime,
                             @Param("endTime") String endTime, @Param("statusArray") String[] statusArray);

    List<String> findPriceDetailReceiptsNumberByIdArray(@Param("idArray") String[] idArray);

    List<PriceReceipts> selectPriceReceiptsByDepotHeadIds(@Param("ids") List<Long> ids);

    BigDecimal getStatisticsBySupplier(@Param("priceType") String priceType,
                                       @Param("supplierId") Long supplierId,
                                       @Param("beginTime") String beginTime,
                                       @Param("endTime") String endTime);

    List<ImportPriceReceiptsVo4List> selectShippingPriceBySupplierIdAndTime(@Param("supplierId") Long supplierId, @Param("beginTime") String beginTime,
                                                                            @Param("endTime") String endTime);

    BigDecimal getCurrentMonthStatistics(@Param("supplierId") Long supplierId,
                                         @Param("beginTime") String beginTime,
                                         @Param("endTime") String endTime);

    List<PriceReceiptsVoSExpense> findDayTotalExpense(@Param("supplierId") Long supplierId,
                                                      @Param("beginTime") String beginTime,
                                                      @Param("endTime") String endTime);

    List<PriceReceiptsVoSMonthExpense> findMonthTotalExpense(@Param("supplierId") Long supplierId,
                                                             @Param("beginTime") String beginTime,
                                                             @Param("endTime") String endTime);
}