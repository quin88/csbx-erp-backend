package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.SupermarketAttachment;
import com.jsh.erp.datasource.entities.SupermarketAttachmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupermarketAttachmentMapper {
    long countByExample(SupermarketAttachmentExample example);

    int deleteByExample(SupermarketAttachmentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SupermarketAttachment record);

    int insertSelective(SupermarketAttachment record);

    List<SupermarketAttachment> selectByExample(SupermarketAttachmentExample example);

    SupermarketAttachment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SupermarketAttachment record, @Param("example") SupermarketAttachmentExample example);

    int updateByExample(@Param("record") SupermarketAttachment record, @Param("example") SupermarketAttachmentExample example);

    int updateByPrimaryKeySelective(SupermarketAttachment record);

    int updateByPrimaryKey(SupermarketAttachment record);
}