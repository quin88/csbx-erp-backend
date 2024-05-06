package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.DepotLinkNumber;
import com.jsh.erp.datasource.entities.DepotLinkNumberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DepotLinkNumberMapper {
    long countByExample(DepotLinkNumberExample example);

    int deleteByExample(DepotLinkNumberExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DepotLinkNumber record);

    int insertSelective(DepotLinkNumber record);

    List<DepotLinkNumber> selectByExample(DepotLinkNumberExample example);

    DepotLinkNumber selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DepotLinkNumber record, @Param("example") DepotLinkNumberExample example);

    int updateByExample(@Param("record") DepotLinkNumber record, @Param("example") DepotLinkNumberExample example);

    int updateByPrimaryKeySelective(DepotLinkNumber record);

    int updateByPrimaryKey(DepotLinkNumber record);
}