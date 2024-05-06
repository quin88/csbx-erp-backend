package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.vo.SecondSettlementMethodVoList;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SecondSettlementMethodMapperEx {
    int batchDeleteSecondSettlementMethodByIds(@Param("updateTime") Date updateTime, @Param("updater") Long updater, @Param("ids") String[] ids);

    List<SecondSettlementMethodVoList> selectByConditionSecondSettlement(@Param("settlement") String settlement,
                                                                         @Param("settlementId") Long settlementId,
                                                                         @Param("secondSettlement") String secondSettlement,
                                                                         @Param("offset") int offset,
                                                                         @Param("rows") int rows);

    Long countSecondSettlement(@Param("settlement") String settlement,
                               @Param("settlementId") Long settlementId,
                               @Param("secondSettlement") String secondSettlement);

    List<SecondSettlementMethodVoList> findByAll();
}
