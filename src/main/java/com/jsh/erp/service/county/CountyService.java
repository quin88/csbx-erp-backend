package com.jsh.erp.service.county;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.*;
import com.jsh.erp.datasource.vo.CountyVo4List;
import com.jsh.erp.exception.BusinessRunTimeException;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.log.LogService;
import com.jsh.erp.service.user.UserService;
import com.jsh.erp.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class CountyService {
    private Logger logger = LoggerFactory.getLogger(CountyService.class);

    @Resource
    private LogService logService;
    @Resource
    private UserService userService;
    @Resource
    private CountyMapper countyMapper;
    @Resource
    private SequenceMapperEx sequenceMapperEx;
    @Resource
    private CountyMapperEx countyMapperEx;
    @Resource
    private ProvinceMapper provinceMapper;
    @Resource
    private SupermarketMaterialMapperEx supermarketMaterialMapperEx;

    public List<County> getCountyById(Long provinceId, Long cityId) {
        List<County> list = null;
        try {
            list = countyMapperEx.getCountyById(provinceId, cityId);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception {
        County county = JSONObject.parseObject(obj.toJSONString(), County.class);
        //校验编号是否重复
        if (checkIsNumberNoExist(0L, county.getCountyNumber())) {
            throw new BusinessRunTimeException(ExceptionConstants.NUMBER_IS_EXIST_CODE,
                    String.format(ExceptionConstants.NUMBER_IS_EXIST_MSG));
        }
        int result = 0;
        User userInfo = userService.getCurrentUser();
        try {
            county.setEnabled(false);
            result = countyMapper.insertSelective(county);
            //更新编号表数值
            sequenceMapperEx.updateBuildOnlyNumber(BusinessConstants.COUNTY_NUMBER_SEQ); //编号+1
            logService.insertLog("产地信息",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ADD).append(county.getCountyName()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    private boolean checkIsNumberNoExist(Long id, String number) {
        CountyExample example = new CountyExample();
        example.createCriteria().andIdNotEqualTo(id).andCountyNumberEqualTo(number).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<County> list = null;
        try {
            list = countyMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list != null && !list.isEmpty();
    }

    public List<CountyVo4List> select(Long id, Long provinceId, Long cityId, String countyName, String enabled,
                                      int offset, int rows) {
        List<CountyVo4List> list = null;
        try {
            list = countyMapperEx.selectByConditionCounty(id, provinceId, cityId, countyName, enabled, offset, rows);
            for (CountyVo4List countyVo4List : list) {
                if (countyVo4List.getCityId() == null) {
                    Province province = provinceMapper.selectByPrimaryKey(countyVo4List.getProvinceId());
                    countyVo4List.setProvince(province.getProvinceName());
                    countyVo4List.setProvinceNumber(province.getProvinceNumber());
                }
            }
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public Long counts(Long id, Long provinceId, Long cityId, String countyName, String enabled) {
        Long result = null;
        try {
            result = countyMapperEx.countByConditionCounty(id, provinceId, cityId, countyName, enabled);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int update(JSONObject obj, HttpServletRequest request) throws Exception {
        County county = JSONObject.parseObject(obj.toJSONString(), County.class);
        //校验编号是否重复
        if (checkIsNumberNoExist(county.getId(), county.getCountyNumber())) {
            throw new BusinessRunTimeException(ExceptionConstants.NUMBER_IS_EXIST_CODE,
                    String.format(ExceptionConstants.NUMBER_IS_EXIST_MSG));
        }
        int result = 0;
        User userInfo = userService.getCurrentUser();
        try {
            county.setEnabled(false);
            result = countyMapper.updateByPrimaryKey(county);
            logService.insertLog("产地信息",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(county.getCountyName()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchSetActive(Boolean enabled, String ids) throws Exception {
        logService.insertLog("产地信息",
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ENABLED).append(ids).toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        List<Long> countyIds = StringUtil.strToLongList(ids);
        County county = new County();
        county.setEnabled(enabled);
        CountyExample example = new CountyExample();
        example.createCriteria().andIdIn(countyIds);
        int result = 0;
        try {
            result = countyMapper.updateByExampleSelective(county, example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }


    public int delete(Long id, HttpServletRequest request) throws Exception {
        return batchDeleteCountyByIds(id.toString(), request);
    }

    public int deleteBatch(String ids, HttpServletRequest request) throws Exception {
        return batchDeleteCountyByIds(ids, request);
    }

    /**
     * 批量删除接口
     *
     * @param ids
     * @return
     * @throws Exception
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteCountyByIds(String ids, HttpServletRequest request) throws Exception {
        logService.insertLog("产地信息",
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_DELETE).append(ids).toString(), request);
        User userInfo = userService.getCurrentUser();
        List<Long> countyIds = StringUtil.strToLongList(ids);
        //检测是否有挂钩商品
        int count = supermarketMaterialMapperEx.countHasCounty(countyIds);
        if (count > 0) {
            throw new BusinessRunTimeException(ExceptionConstants.COUNTY_DELETE_FAILED_CODE,
                    String.format(ExceptionConstants.COUNTY_DELETE_FAILED_MSG));
        }
        County county = new County();
        county.setDeleteFlag(BusinessConstants.DELETE_FLAG_DELETED);
        CountyExample example = new CountyExample();
        example.createCriteria().andIdIn(countyIds);
        int result = 0;
        try {
            result = countyMapper.updateByExampleSelective(county, example);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }
}
