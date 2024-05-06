package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.vo.SupermarketVerificationLogsVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SupermarketVerificationLogsMapperEx {

    List<SupermarketVerificationLogsVo> selectVerificationLogsById(@Param("orderId") Long orderId,
                                                                   @Param("sfId") Long sfId);

    void batchDeleteByOrderIds(@Param("deleteOrderIds") String deleteOrderIds);
}
