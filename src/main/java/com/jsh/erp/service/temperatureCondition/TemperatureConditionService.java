package com.jsh.erp.service.temperatureCondition;

import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.entities.TemperatureCondition;
import com.jsh.erp.datasource.entities.TemperatureConditionExample;
import com.jsh.erp.datasource.mappers.TemperatureConditionMapper;
import com.jsh.erp.exception.JshException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TemperatureConditionService {
    private Logger logger = LoggerFactory.getLogger(TemperatureConditionService.class);

    @Resource
    private TemperatureConditionMapper temperatureConditionMapper;

    public List<TemperatureCondition> findByTemperatureCondition() {
        TemperatureConditionExample example = new TemperatureConditionExample();
        example.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<TemperatureCondition> list = null;
        try {
            list = temperatureConditionMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }
}
