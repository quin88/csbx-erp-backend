package com.jsh.erp.service.sourceType;

import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.entities.SourceType;
import com.jsh.erp.datasource.entities.SourceTypeExample;
import com.jsh.erp.datasource.mappers.SourceTypeMapper;
import com.jsh.erp.exception.JshException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SourceTypeService {
    private Logger logger = LoggerFactory.getLogger(SourceTypeService.class);

    @Resource
    private SourceTypeMapper sourceTypeMapper;

    public List<SourceType> findBySourceType() {
        SourceTypeExample example = new SourceTypeExample();
        example.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<SourceType> list = null;
        try {
            list = sourceTypeMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }
}
