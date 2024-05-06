package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.SupermarketMaterial;
import com.jsh.erp.datasource.entities.SupermarketMaterialVo4;
import com.jsh.erp.datasource.vo.SupermarketMaterialVo;
import com.jsh.erp.datasource.vo.SupermarketMaterialVoList;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SupermarketMaterialMapperEx {
    List<SupermarketMaterialVoList> selectByConditionSupermarketMaterial(@Param("supplierId") Long supplierId,
                                                                         @Param("categoryId") Long categoryId,
                                                                         @Param("secondCategoryId") Long secondCategoryId,
                                                                         @Param("thirdCategoryId") Long thirdCategoryId,
                                                                         @Param("materialParam") String materialParam,
                                                                         @Param("temperatureCondition") String temperatureCondition,
                                                                         @Param("aquaticType") String aquaticType,
                                                                         @Param("statusArray") String[] statusArray,
                                                                         @Param("offset") Integer offset,
                                                                         @Param("rows") Integer rows);

    Long countBySupermarketMaterial(@Param("supplierId") Long supplierId,
                                    @Param("categoryId") Long categoryId,
                                    @Param("secondCategoryId") Long secondCategoryId,
                                    @Param("thirdCategoryId") Long thirdCategoryId,
                                    @Param("materialParam") String materialParam,
                                    @Param("temperatureCondition") String temperatureCondition,
                                    @Param("aquaticType") String aquaticType,
                                    @Param("statusArray") String[] statusArray);

    int batchDeleteSupermarketMaterialByIds(@Param("updateTime") Date updateTime, @Param("updater") Long updater, @Param("ids") List<Long> ids);

    List<SupermarketMaterialVoList> findBySelect(@Param("supplierId") Long supplierId,
                                                 @Param("materialParam") String materialParam,
                                                 @Param("temperatureCondition") String temperatureCondition,
                                                 @Param("province") String province,
                                                 @Param("city") String city,
                                                 @Param("county") String county,
                                                 @Param("aquaticType") String aquaticType,
                                                 @Param("offset") Integer offset,
                                                 @Param("rows") Integer rows);

    int findBySelectCount(@Param("supplierId") Long supplierId,
                          @Param("materialParam") String materialParam,
                          @Param("temperatureCondition") String temperatureCondition,
                          @Param("province") String province,
                          @Param("city") String city,
                          @Param("county") String county,
                          @Param("aquaticType") String aquaticType);

    int countHasCounty(@Param("countyIds") List<Long> countyIds);

    int countHasCategory(@Param("categoryIds") String[] categoryIds);

    SupermarketMaterialVo selectByPrimaryKey(@Param("id") Long id);

    List<SupermarketMaterialVo4> findByIds(@Param("ids") List<Long> ids);

    String getOnlyNUmberByMaxId();
}
