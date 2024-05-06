package com.jsh.erp.service.salesMarket;

import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.SalesMarketMapper;
import com.jsh.erp.datasource.mappers.SalesMarketMapperEx;
import com.jsh.erp.datasource.vo.SalesMarketVoList;
import com.jsh.erp.exception.JshException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalesMarketService {
    private Logger logger = LoggerFactory.getLogger(SalesMarketService.class);

    @Resource
    private SalesMarketMapper salesMarketMapper;

    @Resource
    private SalesMarketMapperEx salesMarketMapperEx;


    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void savesSalesMarketList(Long materialId, List<SalesMarket> salesMarketList) throws Exception {
        List<Long> existingIds = salesMarketMapperEx.getExistingIds(materialId);

        List<Long> idList = new ArrayList<>();
        try {
            if (salesMarketList != null && salesMarketList.size() > 0) {
                for (SalesMarket market : salesMarketList) {
                    if (market.getId() == null) {
                        salesMarketMapper.insertSelective(market);
                    } else {
                        salesMarketMapper.updateByPrimaryKeySelective(market);
                        idList.add(market.getId());
                    }
                }
            }
            if (!existingIds.isEmpty()) {
                List<Long> ids = existingIds.stream().filter(id -> !idList.contains(id)).collect(Collectors.toList());
                if (!ids.isEmpty()) {
                    salesMarketMapperEx.batchDeleteSalesMarketByIds(ids);
                }
            }
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteSalesMarketByMaterialIds(List<Long> materialIds) throws Exception {
        int result = 0;
        try {
            result = salesMarketMapperEx.batchDeleteSalesMarketByMaterialIds(materialIds);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    public List<SalesMarket> findSalesMarketListByMaterialId(Long materialId) {
        SalesMarketExample example = new SalesMarketExample();
        example.createCriteria().andMaterialIdEqualTo(materialId).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<SalesMarket> list = new ArrayList<>();
        try {
            list = salesMarketMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<SalesMarketVoList> findByAll(List<Long> materialIds) {
        List<SalesMarketVoList> list = null;
        try {
            list = salesMarketMapperEx.findByAll(materialIds);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }
}
