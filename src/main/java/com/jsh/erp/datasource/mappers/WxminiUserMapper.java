package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.WxminiUser;
import com.jsh.erp.datasource.entities.WxminiUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WxminiUserMapper {
    long countByExample(WxminiUserExample example);

    int deleteByExample(WxminiUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WxminiUser record);

    int insertSelective(WxminiUser record);

    List<WxminiUser> selectByExample(WxminiUserExample example);

    WxminiUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WxminiUser record, @Param("example") WxminiUserExample example);

    int updateByExample(@Param("record") WxminiUser record, @Param("example") WxminiUserExample example);

    int updateByPrimaryKeySelective(WxminiUser record);

    int updateByPrimaryKey(WxminiUser record);
}