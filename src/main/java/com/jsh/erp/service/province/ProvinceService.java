package com.jsh.erp.service.province;

import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.entities.Province;
import com.jsh.erp.datasource.entities.ProvinceExample;
import com.jsh.erp.datasource.mappers.ProvinceMapper;
import com.jsh.erp.exception.JshException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class ProvinceService {
    private Logger logger = LoggerFactory.getLogger(ProvinceService.class);

    @Resource
    private ProvinceMapper provinceMapper;

    public List<Province> getProvinceByCountryId(Long countryId) {
        ProvinceExample example = new ProvinceExample();
        example.createCriteria().andCountryIdEqualTo(countryId).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);

        List<Province> list = null;
        try {
            list = provinceMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }
}
