package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.Signature;
import com.jsh.erp.datasource.entities.SignatureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SignatureMapper {
    long countByExample(SignatureExample example);

    int deleteByExample(SignatureExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Signature record);

    int insertSelective(Signature record);

    List<Signature> selectByExample(SignatureExample example);

    Signature selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Signature record, @Param("example") SignatureExample example);

    int updateByExample(@Param("record") Signature record, @Param("example") SignatureExample example);

    int updateByPrimaryKeySelective(Signature record);

    int updateByPrimaryKey(Signature record);
}