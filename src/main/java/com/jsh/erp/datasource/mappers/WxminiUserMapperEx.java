package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.WxminiUser;
import org.apache.ibatis.annotations.Param;

public interface WxminiUserMapperEx {
    WxminiUser selectByPhoneNumber(
            @Param("phoneNumber") String phoneNumber);

    WxminiUser selectByOpenId(@Param("openId")String openId);
}
