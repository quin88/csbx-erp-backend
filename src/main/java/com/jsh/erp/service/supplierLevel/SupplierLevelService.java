package com.jsh.erp.service.supplierLevel;

import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.entities.SupplierLevel;
import com.jsh.erp.datasource.entities.SupplierLevelExample;
import com.jsh.erp.datasource.mappers.SupplierLevelMapper;
import com.jsh.erp.exception.JshException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SupplierLevelService {
    private Logger logger = LoggerFactory.getLogger(SupplierLevelService.class);

    @Resource
    private SupplierLevelMapper supplierLevelMapper;

    public List<SupplierLevel> findBySupplierLevel() {
        SupplierLevelExample example = new SupplierLevelExample();
        example.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<SupplierLevel> list = null;
        try {
            list = supplierLevelMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }
}
