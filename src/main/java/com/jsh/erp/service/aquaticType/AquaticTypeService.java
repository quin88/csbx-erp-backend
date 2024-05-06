package com.jsh.erp.service.aquaticType;

import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.entities.AquaticType;
import com.jsh.erp.datasource.entities.AquaticTypeExample;
import com.jsh.erp.datasource.mappers.AquaticTypeMapper;
import com.jsh.erp.exception.JshException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AquaticTypeService {
    private Logger logger = LoggerFactory.getLogger(AquaticTypeService.class);

    @Resource
    private AquaticTypeMapper aquaticTypeMapper;

    public List<AquaticType> findByAquaticType() {
        AquaticTypeExample example = new AquaticTypeExample();
        example.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<AquaticType> list = null;
        try {
            list = aquaticTypeMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }
}
