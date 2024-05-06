package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.vo.ValueAddedServeVo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ValueAddedServeMapperEx {

    int batchDeleteByIds(@Param("updateTime") Date updateTime,
                         @Param("updater") Long updater,
                         @Param("ids") String[] ids);

    List<ValueAddedServeVo> selectByCondition(@Param("serveTypeId") Long serveTypeId,
                                              @Param("title") String title,
                                              @Param("enabledFlag") String enabledFlag,
                                              @Param("offset") Integer offset,
                                              @Param("rows") Integer rows);

    Long countByCondition(@Param("serveTypeId") Long serveTypeId,
                          @Param("title") String title,
                          @Param("enabledFlag") String enabledFlag);

    Long countIsActive(@Param("idArray") String[] idArray);
}
