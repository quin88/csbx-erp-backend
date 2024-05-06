package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.SupermarketSystemConfig;
import com.jsh.erp.datasource.vo.SupermarketSystemConfigVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SupermarketSystemConfigMapperEx {

    List<SupermarketSystemConfigVo> selectSupermarketSystemConfig(@Param("offset") Integer offset,
                                                                  @Param("rows") Integer rows);

    Long countSupermarketSystemConfig();

    int batchDeleteSystemConfigByIds(@Param("ids") String[] ids);

    SupermarketSystemConfig getCurrentConfig(@Param("numberName")String numberName);
}
