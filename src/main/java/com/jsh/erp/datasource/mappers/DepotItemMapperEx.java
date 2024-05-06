package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.vo.DepotItemStockWarningCount;
import com.jsh.erp.datasource.vo.DepotItemVo4Stock;
import com.jsh.erp.datasource.vo.DepotItemVoBatchNumberList;
import com.jsh.erp.datasource.vo.ImportPriceReceiptsVo4List;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Description
 *
 * @Author: cjl
 * @Date: 2019/1/24 16:59
 */
public interface DepotItemMapperEx {
    List<DepotItem> selectByConditionDepotItem(
            @Param("name") String name,
            @Param("type") Integer type,
            @Param("remark") String remark,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countsByDepotItem(
            @Param("name") String name,
            @Param("type") Integer type,
            @Param("remark") String remark);

    List<DepotItemVo4DetailByTypeAndMId> findDetailByDepotIdsAndMaterialIdList(
            @Param("depotIdArray") Long[] depotIdArray,
            @Param("forceFlag") Boolean forceFlag,
            @Param("sku") String sku,
            @Param("batchNumber") String batchNumber,
            @Param("number") String number,
            @Param("beginTime") String beginTime,
            @Param("endTime") String endTime,
            @Param("mId") Long mId,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long findDetailByDepotIdsAndMaterialIdCount(
            @Param("depotIdArray") Long[] depotIdArray,
            @Param("forceFlag") Boolean forceFlag,
            @Param("sku") String sku,
            @Param("batchNumber") String batchNumber,
            @Param("number") String number,
            @Param("beginTime") String beginTime,
            @Param("endTime") String endTime,
            @Param("mId") Long mId);

    List<DepotItemVo4WithInfoEx> getDetailList(
            @Param("headIdArr") String[] headIdArr);

    List<DepotItemVo4WithInfoEx> findByAll(
            @Param("materialParam") String materialParam,
            @Param("endTime") String endTime,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    int findByAllCount(
            @Param("materialParam") String materialParam,
            @Param("endTime") String endTime);

    List<DepotItemVo4WithInfoEx> getListWithBugOrSale(
            @Param("materialParam") String materialParam,
            @Param("billType") String billType,
            @Param("beginTime") String beginTime,
            @Param("endTime") String endTime,
            @Param("creatorArray") String[] creatorArray,
            @Param("organId") Long organId,
            @Param("organArray") String [] organArray,
            @Param("depotList") List<Long> depotList,
            @Param("forceFlag") Boolean forceFlag,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    int getListWithBugOrSaleCount(
            @Param("materialParam") String materialParam,
            @Param("billType") String billType,
            @Param("beginTime") String beginTime,
            @Param("endTime") String endTime,
            @Param("creatorArray") String[] creatorArray,
            @Param("organId") Long organId,
            @Param("organArray") String [] organArray,
            @Param("depotList") List<Long> depotList,
            @Param("forceFlag") Boolean forceFlag);

    BigDecimal buyOrSaleNumber(
            @Param("type") String type,
            @Param("subType") String subType,
            @Param("MId") Long MId,
            @Param("beginTime") String beginTime,
            @Param("endTime") String endTime,
            @Param("creatorArray") String[] creatorArray,
            @Param("organId") Long organId,
            @Param("organArray") String [] organArray,
            @Param("depotList") List<Long> depotList,
            @Param("forceFlag") Boolean forceFlag,
            @Param("sumType") String sumType);

    BigDecimal buyOrSalePrice(
            @Param("type") String type,
            @Param("subType") String subType,
            @Param("MId") Long MId,
            @Param("beginTime") String beginTime,
            @Param("endTime") String endTime,
            @Param("creatorArray") String[] creatorArray,
            @Param("organId") Long organId,
            @Param("organArray") String [] organArray,
            @Param("depotList") List<Long> depotList,
            @Param("forceFlag") Boolean forceFlag,
            @Param("sumType") String sumType);

    BigDecimal inOrOutPrice(
            @Param("type") String type,
            @Param("subType") String subType,
            @Param("beginTime") String beginTime,
            @Param("endTime") String endTime,
            @Param("creatorArray") String[] creatorArray,
            @Param("forceFlag") Boolean forceFlag);

    BigDecimal inOrOutRetailPrice(
            @Param("type") String type,
            @Param("subType") String subType,
            @Param("beginTime") String beginTime,
            @Param("endTime") String endTime,
            @Param("creatorArray") String[] creatorArray,
            @Param("forceFlag") Boolean forceFlag);

    BigDecimal getStockCheckSumByDepotList(
            @Param("depotList") List<Long> depotList,
            @Param("mId") Long mId,
            @Param("forceFlag") Boolean forceFlag,
            @Param("beginTime") String beginTime,
            @Param("endTime") String endTime);

    DepotItemVo4Stock getSkuStockByParamWithDepotList(
            @Param("depotList") List<Long> depotList,
            @Param("meId") Long meId,
            @Param("forceFlag") Boolean forceFlag,
            @Param("beginTime") String beginTime,
            @Param("endTime") String endTime);

    DepotItemVo4Stock getStockByParamWithDepotList(
            @Param("depotList") List<Long> depotList,
            @Param("mId") Long mId,
            @Param("forceFlag") Boolean forceFlag,
            @Param("beginTime") String beginTime,
            @Param("endTime") String endTime);

    /**
     * 通过单据主表id查询所有单据子表数据
     * @param depotheadId
     * @param enableSerialNumber
     * @return
     */
     List<DepotItem> findDepotItemListBydepotheadId(@Param("depotheadId")Long depotheadId,
                                                    @Param("enableSerialNumber")String enableSerialNumber);
     /**
      * 根据单据主表id删除单据子表数据
      * */
     int batchDeleteDepotItemByDepotHeadIds(@Param("depotheadIds")Long []depotHeadIds);

    int batchDeleteDepotItemByIds(@Param("updateTime") Date updateTime, @Param("updater") Long updater, @Param("ids") String ids[]);

    List<DepotItem> getDepotItemListListByDepotIds(@Param("depotIds") String[] depotIds);

    List<DepotItem> getDepotItemListListByMaterialIds(@Param("materialIds") String[] materialIds);

    List<DepotItemStockWarningCount> findStockWarningCount(
            @Param("offset") Integer offset,
            @Param("rows") Integer rows,
            @Param("materialParam") String materialParam,
            @Param("depotList") List<Long> depotList);

    int findStockWarningCountTotal(
            @Param("materialParam") String materialParam,
            @Param("depotList") List<Long> depotList);

    BigDecimal getFinishNumber(
            @Param("meId") Long meId,
            @Param("linkId") Long linkId,
            @Param("linkNumber") String linkNumber,
            @Param("goToType") String goToType);

    BigDecimal getRealFinishNumber(
            @Param("meId") Long meId,
            @Param("linkId") Long linkId,
            @Param("linkNumber") String linkNumber,
            @Param("currentHeaderId") Long currentHeaderId,
            @Param("goToType") String goToType);

    List<DepotItemVoBatchNumberList> getBatchNumberList(
            @Param("number") String number,
            @Param("name") String name,
            @Param("depotId") Long depotId,
            @Param("barCode") String barCode,
            @Param("batchNumber") String batchNumber);

    Long getCountByMaterialAndDepot(
            @Param("mId") Long mId,
            @Param("depotId") Long depotId);

    List<DepotItemVo4MaterialAndSum> getLinkBillDetailMaterialSum(
            @Param("linkNumber") String linkNumber);

    List<DepotItemVo4MaterialAndSum> getBatchBillDetailMaterialSum(
            @Param("linkNumber") String linkNumber,
            @Param("type") String type);

    Long getCountByMaterialAndBatchNumber(
            @Param("meId") Long meId,
            @Param("batchNumber") String batchNumber);

    List<DepotItem> getDepotItemByBatchNumber(
            @Param("batchNumber") String batchNumber);

    List<ImportPriceReceiptsVo4List> selectDepotItemInfoBySupplierIdAndTime(@Param("supplierId") Long supplierId, @Param("beginTime") String beginTime,
                                                                            @Param("endTime") String endTime);
}
