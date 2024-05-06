package com.jsh.erp.service.startLevel;

import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.entities.StarLevel;
import com.jsh.erp.datasource.entities.StarLevelExample;
import com.jsh.erp.datasource.mappers.StarLevelMapper;
import com.jsh.erp.exception.JshException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StartLevelService {
    private Logger logger = LoggerFactory.getLogger(StartLevelService.class);

    @Resource
    private StarLevelMapper starLevelMapper;

    public List<StarLevel> findByStartLevel() {
        StarLevelExample example = new StarLevelExample();
        example.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<StarLevel> list = null;
        try {
            list = starLevelMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }
}
