package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.vo.PaymentConfigVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaymentConfigMapperEx {

    List<PaymentConfigVo> selectPaymentConfig(@Param("maId")Long maId,
                                              @Param("atId")Long atId,
                                              @Param("offset") Integer offset,
                                              @Param("rows") Integer rows);

    Long countPaymentConfig(@Param("maId")Long maId,
                            @Param("atId")Long atId);

    int batchDeletePaymentConfigByIds(@Param("ids") String[] ids);
}
