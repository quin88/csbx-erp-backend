package com.jsh.erp.datasource.mappers;

import org.apache.ibatis.annotations.Param;

public interface SequenceMapperEx {

    void updateBuildOnlyNumber(@Param("seqName") String seqName);

    /**
     * 获得一个全局唯一的数作为订单号的追加
     * */
    Long getBuildOnlyNumber(@Param("seqName") String seqName);

    Long getMaxValue(@Param("seqName")String seqName);

    void updateMinValue(@Param("seqName") String seqName);

}
