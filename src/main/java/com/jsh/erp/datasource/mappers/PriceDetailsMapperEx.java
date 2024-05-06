package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.PriceDetails;
import com.jsh.erp.datasource.vo.ImportPriceReceiptsVo4List;
import com.jsh.erp.datasource.vo.PriceDetailsVo;
import com.jsh.erp.datasource.vo.PriceDetailsVoList;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface PriceDetailsMapperEx {

    int batchDeletePriceDetailByIds(@Param("updateTime") Date updateTime, @Param("updater") Long updater, @Param("ids") String[] ids);

    List<String> selectDetailsByReceiptsNumber(@Param("receiptsNumber") String receiptsNumber);

    BigDecimal selectPriceNumberByReceiptsNumber(@Param("receiptsNumber") String receiptsNumber);

    int batchDeletePriceDetailByReceiptsNumbers(@Param("updateTime") Date updateTime, @Param("updater") Long updater,@Param("receiptsNumberArray") String[] receiptsNumberArray);

    int batchSetStatusByReceiptsNumberArray(@Param("updateTime")Date updateTime, @Param("updater")Long updater, @Param("receiptsNumberArray")String[] receiptsNumberArray, @Param("status")String status);

    List<ImportPriceReceiptsVo4List> selectPriceDetailBySupplierIdAndTime(@Param("supplierId") Long supplierId, @Param("beginTime") String beginTime,
                                                                          @Param("endTime") String endTime);

    List<PriceDetails> selectListByReceiptsNumber(@Param("receiptsNumber") String receiptsNumber);
}