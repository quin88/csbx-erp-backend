package com.jsh.erp.service.supermarketFinanceRelevancy;

import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.entities.SupermarketFinanceRelevancy;
import com.jsh.erp.datasource.entities.SupermarketFinanceRelevancyExample;
import com.jsh.erp.datasource.mappers.SupermarketFinanceRelevancyMapper;
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
public class SupermarketFinanceRelevancyService {
    private Logger logger = LoggerFactory.getLogger(SupermarketFinanceRelevancyService.class);
    @Resource
    private SupermarketFinanceRelevancyMapper supermarketFinanceRelevancyMapper;

    public void saveFinanceRelevancy(Long sfId, List<SupermarketFinanceRelevancy> srrList, String deleteIds) {
        for (SupermarketFinanceRelevancy supermarketFinanceRelevancy : srrList) {
            if (supermarketFinanceRelevancy.getId() == null) {
                supermarketFinanceRelevancy.setSupermarketFinanceId(sfId);
                supermarketFinanceRelevancyMapper.insertSelective(supermarketFinanceRelevancy);
            } else {
                supermarketFinanceRelevancyMapper.updateByPrimaryKeySelective(supermarketFinanceRelevancy);
            }

            if (deleteIds != null && !deleteIds.equals("")) {
                deleteFinanceRelevancy(deleteIds);
            }
        }
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void deleteFinanceRelevancy(String deleteIds) {
        SupermarketFinanceRelevancy sfr = new SupermarketFinanceRelevancy();
        sfr.setDeleteFlag(BusinessConstants.DELETE_FLAG_DELETED);
        List<Long> longs = StringUtil.strToLongList(deleteIds);
        SupermarketFinanceRelevancyExample example = new SupermarketFinanceRelevancyExample();
        example.createCriteria().andIdIn(longs);
        try {
            supermarketFinanceRelevancyMapper.updateByExampleSelective(sfr, example);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
    }

    public void batchDeleteBySfIds(String[] idArray) {
        SupermarketFinanceRelevancy sfr = new SupermarketFinanceRelevancy();
        sfr.setDeleteFlag(BusinessConstants.DELETE_FLAG_DELETED);
        List<Long> longList = Arrays.stream(idArray)
                .map(Long::valueOf) // 将字符串转换为Long
                .collect(Collectors.toList());
        SupermarketFinanceRelevancyExample example = new SupermarketFinanceRelevancyExample();
        example.createCriteria().andSupermarketFinanceIdIn(longList);
        try {
            supermarketFinanceRelevancyMapper.updateByExampleSelective(sfr, example);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
    }
}