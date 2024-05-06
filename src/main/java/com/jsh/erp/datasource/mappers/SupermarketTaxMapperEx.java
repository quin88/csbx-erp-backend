package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.SupermarketTax;
import com.jsh.erp.datasource.vo.SupermarketTaxVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SupermarketTaxMapperEx {

    List<SupermarketTaxVo> selectByConditionSupermarketTax(@Param("offset") Integer offset,
                                                           @Param("rows") Integer rows);

    Long countSupermarketSystemTax();

    int batchDeleteSystemTaxByIds(@Param("ids") String[] ids);

    SupermarketTax selectByClientId(@Param("serveClientId") Long serveClientId);

    List<Long> selectTaxIdById(@Param("ids") String[] ids);
}
