package com.jsh.erp.service.salesInfo;

import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.entities.SalesInfo;
import com.jsh.erp.datasource.entities.SalesInfoExample;
import com.jsh.erp.datasource.mappers.SalesInfoMapper;
import com.jsh.erp.datasource.mappers.SalesInfoMapperEx;
import com.jsh.erp.datasource.vo.SalesInfoVoList;
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
public class SalesInfoService {
    private Logger logger = LoggerFactory.getLogger(SalesInfoService.class);

    @Resource
    private SalesInfoMapper salesInfoMapper;

    @Resource
    private SalesInfoMapperEx salesInfoMapperEx;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void saveSalesInfoList(Long materialId, List<SalesInfo> salesInfoList) throws Exception {
        List<Long> existingIds = salesInfoMapperEx.getExistingIds(materialId);

        List<Long> idList = new ArrayList<>();
        try {
            if (salesInfoList != null && salesInfoList.size() > 0) {
                for (SalesInfo salesInfo : salesInfoList) {
                    if (salesInfo.getId() == null) {
                        salesInfoMapper.insertSelective(salesInfo);
                    } else {
                        salesInfoMapper.updateByPrimaryKey(salesInfo);
                        idList.add(salesInfo.getId());
                    }
                }
            }
            if (!existingIds.isEmpty()) {
                List<Long> ids = existingIds.stream().filter(id -> !idList.contains(id)).collect(Collectors.toList());
                if (!ids.isEmpty()) {
                    salesInfoMapperEx.batchDeleteSalesInfoByIds(ids);
                }
            }
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteSalesInfoByMaterialIds(List<Long> materialIds) throws Exception {
        int result = 0;
        try {
            result = salesInfoMapperEx.batchDeleteSalesInfoByMaterialIds(materialIds);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    public List<SalesInfo> findSalesInfoListByMaterialId(Long materialId) {
        SalesInfoExample example = new SalesInfoExample();
        example.createCriteria().andMaterialIdEqualTo(materialId).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<SalesInfo> list = new ArrayList<>();
        try {
            list = salesInfoMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<SalesInfoVoList> findByAll(List<Long> materialIds) {
        List<SalesInfoVoList> list = null;
        try {
            list = salesInfoMapperEx.findByAll(materialIds);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }
}
