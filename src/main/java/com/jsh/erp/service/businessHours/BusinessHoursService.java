package com.jsh.erp.service.businessHours;

import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.entities.BusinessHours;
import com.jsh.erp.datasource.entities.BusinessHoursExample;
import com.jsh.erp.datasource.entities.SupermarketReconciliationRelevancy;
import com.jsh.erp.datasource.entities.SupermarketReconciliationRelevancyExample;
import com.jsh.erp.datasource.mappers.BusinessHoursMapper;
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
public class BusinessHoursService {
    private Logger logger = LoggerFactory.getLogger(BusinessHoursService.class);
    @Resource
    private BusinessHoursMapper businessHoursMapper;

    public void saveBusinessHours(Long depotId, List<BusinessHours> businessHours, String deleteIds) {
        if (businessHours != null) {
            for (BusinessHours bh : businessHours) {
                if (bh.getId() == null) {
                    bh.setDepotId(depotId);
                    businessHoursMapper.insertSelective(bh);
                } else {
                    businessHoursMapper.updateByPrimaryKeySelective(bh);
                }

            }
        }
        if (deleteIds != null && !deleteIds.equals("")) {
            deleteReconciliationRelevancy(deleteIds);
        }
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void deleteReconciliationRelevancy(String deleteIds) {
        BusinessHours bh = new BusinessHours();
        bh.setDeleteFlag(BusinessConstants.DELETE_FLAG_DELETED);
        List<Long> longs = StringUtil.strToLongList(deleteIds);
        BusinessHoursExample example = new BusinessHoursExample();
        example.createCriteria().andIdIn(longs);
        try {
            businessHoursMapper.updateByExampleSelective(bh, example);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
    }

}