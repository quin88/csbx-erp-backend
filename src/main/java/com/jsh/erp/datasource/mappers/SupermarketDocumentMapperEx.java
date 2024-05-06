package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.SupermarketDocument;
import com.jsh.erp.datasource.entities.SupermarketDocumentVo4Body;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SupermarketDocumentMapperEx {

    Long selectIdByNumber(@Param("number") String number);

    List<SupermarketDocument> getSupermarketDocumentListBySignatureIds(@Param("ids") List<Long> ids);

    List<SupermarketDocumentVo4Body> selectSupermarketDocument(
            @Param("supplier") String supplier,
            @Param("organ") String organ,
            @Param("beginTime") String beginTime,
            @Param("endTime") String endTime,
            @Param("number") String number,
            @Param("invoiceNumber") String invoiceNumber,
            @Param("status") String status,
            @Param("type") String type,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countSupermarketDocument(
            @Param("supplier") String supplier,
            @Param("organ") String organ,
            @Param("beginTime") String beginTime,
            @Param("endTime") String endTime,
            @Param("number") String number,
            @Param("invoiceNumber") String invoiceNumber,
            @Param("status") String status,
            @Param("type") String type);

    SupermarketDocumentVo4Body selectSupermarketDocumentById(@Param("id") Long id);

    Long countIsSubmit(@Param("idArray")String[] idArray);

    int batchDeleteSuperDocumentByIds(@Param("updateTime") Date updateTime, @Param("updater") Long updater, @Param("ids") String[] ids);
}
