package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.BusinessHours;
import com.jsh.erp.datasource.entities.BusinessHoursExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BusinessHoursMapper {
    long countByExample(BusinessHoursExample example);

    int deleteByExample(BusinessHoursExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BusinessHours record);

    int insertSelective(BusinessHours record);

    List<BusinessHours> selectByExample(BusinessHoursExample example);

    BusinessHours selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BusinessHours record, @Param("example") BusinessHoursExample example);

    int updateByExample(@Param("record") BusinessHours record, @Param("example") BusinessHoursExample example);

    int updateByPrimaryKeySelective(BusinessHours record);

    int updateByPrimaryKey(BusinessHours record);
}