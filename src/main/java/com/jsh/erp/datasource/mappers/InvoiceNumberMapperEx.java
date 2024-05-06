package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.vo.InvoiceNumberVoList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InvoiceNumberMapperEx {
    List<Long> getExistingIds(@Param("materialId") Long materialId);

    int batchDeleteInvoiceByIds(@Param("ids") List<Long> ids);

    int batchDeleteInvoiceByMaterialIds(@Param("materialIds") List<Long> materialIds);

    List<InvoiceNumberVoList> findByAll(@Param("materialIds") List<Long> materialIds);
}
