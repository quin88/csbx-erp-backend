package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.ProduceBom;
import com.jsh.erp.datasource.entities.ProduceBomExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProduceBomMapper {
    long countByExample(ProduceBomExample example);

    int deleteByExample(ProduceBomExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProduceBom record);

    int insertSelective(ProduceBom record);

    List<ProduceBom> selectByExample(ProduceBomExample example);

    ProduceBom selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProduceBom record, @Param("example") ProduceBomExample example);

    int updateByExample(@Param("record") ProduceBom record, @Param("example") ProduceBomExample example);

    int updateByPrimaryKeySelective(ProduceBom record);

    int updateByPrimaryKey(ProduceBom record);
}