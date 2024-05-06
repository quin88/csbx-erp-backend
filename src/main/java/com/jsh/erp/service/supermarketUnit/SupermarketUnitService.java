package com.jsh.erp.service.supermarketUnit;

import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.entities.SupermarketUnit;
import com.jsh.erp.datasource.entities.SupermarketUnitExample;
import com.jsh.erp.datasource.mappers.SupermarketUnitMapper;
import com.jsh.erp.exception.JshException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SupermarketUnitService {
    private Logger logger = LoggerFactory.getLogger(SupermarketUnitService.class);

    @Resource
    private SupermarketUnitMapper supermarketUnitMapper;

    public List<SupermarketUnit> findBySupermarketUnit() {
        SupermarketUnitExample example = new SupermarketUnitExample();
        example.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<SupermarketUnit> list = null;
        try {
            list = supermarketUnitMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }
}
