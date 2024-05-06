package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.OrderDetail;
import com.jsh.erp.datasource.vo.OrderDetailVo;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface OrderDetailMapperEx {
    List<OrderDetail> getOrderDetailListByMaterialIds(@Param("ids") List<Long> ids);

    List<OrderDetailVo> findBySelect(@Param("idArray") String[] idArray);

    List<OrderDetailVo> findByCondition(@Param("orderId") Long id, @Param("supplierId") Long supplierId, @Param("accountId") Long accountId);

    BigDecimal getSupplementaryAmountTotalById(@Param("orderId")Long id);
}
