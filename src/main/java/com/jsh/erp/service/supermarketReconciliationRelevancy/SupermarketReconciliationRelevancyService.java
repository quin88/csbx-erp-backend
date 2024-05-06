package com.jsh.erp.service.supermarketReconciliationRelevancy;

import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.entities.SupermarketReconciliationRelevancy;
import com.jsh.erp.datasource.entities.SupermarketReconciliationRelevancyExample;
import com.jsh.erp.datasource.mappers.SupermarketReconciliationRelevancyMapper;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupermarketReconciliationRelevancyService {
    private Logger logger = LoggerFactory.getLogger(SupermarketReconciliationRelevancyService.class);
    @Resource
    private SupermarketReconciliationRelevancyMapper supermarketReconciliationRelevancyMapper;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void saveReconciliationRelevancy(List<SupermarketReconciliationRelevancy> srrList, Long srId, String deleteIds) {
        for (SupermarketReconciliationRelevancy srr : srrList) {
            if (srr.getId() == null) {
                srr.setSupermarketReconciliationId(srId);
                supermarketReconciliationRelevancyMapper.insertSelective(srr);
            } else {
                supermarketReconciliationRelevancyMapper.updateByPrimaryKeySelective(srr);
            }
        }
        if (deleteIds != null && !deleteIds.equals("")) {
            deleteReconciliationRelevancy(deleteIds);
        }
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void deleteReconciliationRelevancy(String deleteIds) {
        SupermarketReconciliationRelevancy srr = new SupermarketReconciliationRelevancy();
        srr.setDeleteFlag(BusinessConstants.DELETE_FLAG_DELETED);
        List<Long> longs = StringUtil.strToLongList(deleteIds);
        SupermarketReconciliationRelevancyExample example = new SupermarketReconciliationRelevancyExample();
        example.createCriteria().andIdIn(longs);
        try {
            supermarketReconciliationRelevancyMapper.updateByExampleSelective(srr,example);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
    }

    public void batchDeleteBySrIds(String[] idArray) {
        SupermarketReconciliationRelevancy srr = new SupermarketReconciliationRelevancy();
        srr.setDeleteFlag(BusinessConstants.DELETE_FLAG_DELETED);
        List<Long> longList = Arrays.stream(idArray)
                .map(Long::valueOf) // 将字符串转换为Long
                .collect(Collectors.toList());
        SupermarketReconciliationRelevancyExample example = new SupermarketReconciliationRelevancyExample();
        example.createCriteria().andSupermarketReconciliationIdIn(longList);
        try {
            supermarketReconciliationRelevancyMapper.updateByExampleSelective(srr, example);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
    }
}