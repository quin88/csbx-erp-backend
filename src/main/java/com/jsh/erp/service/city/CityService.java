package com.jsh.erp.service.city;

import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.entities.City;
import com.jsh.erp.datasource.entities.CityExample;
import com.jsh.erp.datasource.mappers.CityMapper;
import com.jsh.erp.datasource.mappers.CityMapperEx;
import com.jsh.erp.exception.JshException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CityService {
    private Logger logger = LoggerFactory.getLogger(CityService.class);

    @Resource
    private CityMapper cityMapper;

    @Resource
    private CityMapperEx cityMapperEx;

    public City getCity(Long id) {
        City result = null;
        try {
            result = cityMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    public List<City> getCityByProvinceId(Long provinceId) {
        CityExample example = new CityExample();
        example.createCriteria().andProvinceIdEqualTo(provinceId).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<City> list = null;
        try {
            list = cityMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<City> select(String name, Long province, int offset, int rows) {
        List<City> list = null;
        try {
            list = cityMapperEx.selectConditionByCity(name, province, offset, rows);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public Long countByCity(String name, Long province) {
        Long result = null;
        try {
            result = cityMapperEx.countByCity(name, province);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }
}
