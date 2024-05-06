package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.SupermarketServeClient;
import com.jsh.erp.datasource.vo.SupermarketServeClientVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SupermarketServeClientMapperEx {

    List<SupermarketServeClientVo> selectSupplierServeClient(@Param("offset") Integer offset,
                                                             @Param("rows") Integer rows);

    Long countSupplierServeClient();

    int batchDeleteServeClientByIds(@Param("ids") String[] ids);
}
