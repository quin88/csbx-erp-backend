package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.vo.SupermarketReconciliationVo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SupermarketReconciliationMapperEx {
    List<SupermarketReconciliationVo> selectSupermarketReconciliation(@Param("id") Long id,
                                                                      @Param("atIdArray") String[] atIdArray,
                                                                      @Param("beginTime") String beginTime,
                                                                      @Param("endTime") String endTime,
                                                                      @Param("number") String number,
                                                                      @Param("statusArray") String[] statusArray,
                                                                      @Param("reconciliationBeginTime") String reconciliationBeginTime,
                                                                      @Param("reconciliationEndTime") String reconciliationEndTime,
                                                                      @Param("offset") Integer offset,
                                                                      @Param("rows") Integer rows);

    Long countSupermarketReconciliation(@Param("id") Long id,
                                        @Param("atIdArray") String[] atIdArray,
                                        @Param("beginTime") String beginTime,
                                        @Param("endTime") String endTime,
                                        @Param("number") String number,
                                        @Param("statusArray") String[] statusArray,
                                        @Param("reconciliationBeginTime") String reconciliationBeginTime,
                                        @Param("reconciliationEndTime") String reconciliationEndTime);

    int batchDeleteByIds(@Param("updateTime") Date updateTime,
                         @Param("updater") Long updater,
                         @Param("ids") String[] ids);

    Long selectIdByNumber(@Param("number") String number);

    SupermarketReconciliationVo selectSupermarketReconciliationById(@Param("id") Long id);
}
