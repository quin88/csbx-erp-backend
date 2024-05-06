package com.jsh.erp.service.supermarketReconciliationAquaticType;

import com.jsh.erp.datasource.entities.SupermarketReconciliationAquaticType;
import com.jsh.erp.datasource.entities.SupermarketReconciliationAquaticTypeExample;
import com.jsh.erp.datasource.mappers.SupermarketReconciliationAquaticTypeMapper;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SupermarketReconciliationAquaticTypeService {
    private Logger logger = LoggerFactory.getLogger(SupermarketReconciliationAquaticTypeService.class);
    @Resource
    private SupermarketReconciliationAquaticTypeMapper supermarketReconciliationAquaticTypeMapper;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void saveAquaticType(List<SupermarketReconciliationAquaticType> astList, Long srId, String satDeleteIds) {
        for (SupermarketReconciliationAquaticType sat : astList) {
            if (sat.getId() == null) {
                sat.setSupermarketReconciliationId(srId);
                supermarketReconciliationAquaticTypeMapper.insertSelective(sat);
            } else {
                supermarketReconciliationAquaticTypeMapper.updateByPrimaryKeySelective(sat);
            }

            if (satDeleteIds != null && !satDeleteIds.equals("")) {
                deleteReconciliationAquaticType(satDeleteIds);
            }
        }
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void deleteReconciliationAquaticType(String satDeleteIds) {
        List<Long> longs = StringUtil.strToLongList(satDeleteIds);
        SupermarketReconciliationAquaticTypeExample example = new SupermarketReconciliationAquaticTypeExample();
        example.createCriteria().andIdIn(longs);
        try {
            supermarketReconciliationAquaticTypeMapper.deleteByExample(example);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
    }
}