package com.jsh.erp.service.taxLevel;

import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.entities.TaxLevel;
import com.jsh.erp.datasource.entities.TaxLevelExample;
import com.jsh.erp.datasource.mappers.TaxLevelMapper;
import com.jsh.erp.exception.JshException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TaxLevelService {
    private Logger logger = LoggerFactory.getLogger(TaxLevelService.class);

    @Resource
    private TaxLevelMapper taxLevelMapper;

    public List<TaxLevel> findByTaxLevel() {
        TaxLevelExample example = new TaxLevelExample();
        example.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<TaxLevel> list = null;
        try {
            list=taxLevelMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger,e);
        }
        return list;
    }
}
