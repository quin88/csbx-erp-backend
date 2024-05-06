package com.jsh.erp.service.businessType;

import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.entities.BusinessType;
import com.jsh.erp.datasource.entities.BusinessTypeExample;
import com.jsh.erp.datasource.mappers.BusinessTypeMapper;
import com.jsh.erp.exception.JshException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BusinessTypeService {
    private Logger logger = LoggerFactory.getLogger(BusinessTypeService.class);
    @Resource
    private BusinessTypeMapper businessTypeMapper;

    public List<BusinessType> findByBusinessType() {
        BusinessTypeExample example = new BusinessTypeExample();
        example.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<BusinessType> list = null;
        try {
            list = businessTypeMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }
}
