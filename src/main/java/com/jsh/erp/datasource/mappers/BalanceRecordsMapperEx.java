package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.BalanceRecords;
import org.apache.ibatis.annotations.Param;

public interface BalanceRecordsMapperEx {

    BalanceRecords selectBySupplierId(@Param("supplierId") Long supplierId);

}
