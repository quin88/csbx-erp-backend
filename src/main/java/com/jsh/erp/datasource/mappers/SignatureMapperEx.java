package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.Signature;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SignatureMapperEx {
    List<Signature> selectByConditionSignature(@Param("role") String role,
                                               @Param("name") String name,
                                               @Param("offset") int offset,
                                               @Param("rows") int rows);

    Long countSignature(@Param("role") String role,
                        @Param("name") String name);

    int batchDeleteSignatureByIds(@Param("ids") List<Long> ids);
}
