package com.jsh.erp.service.secondMeasurement;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.entities.SecondMeasurement;
import com.jsh.erp.datasource.entities.SecondMeasurementExample;
import com.jsh.erp.datasource.mappers.SecondMeasurementMapper;
import com.jsh.erp.datasource.mappers.SecondMeasurementMapperEx;
import com.jsh.erp.datasource.vo.SecondMeasurementVo;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Service
public class SecondMeasurementService {
    private Logger logger = LoggerFactory.getLogger(SecondMeasurementService.class);

    @Resource
    private SecondMeasurementMapper secondMeasurementMapper;

    @Resource
    private SecondMeasurementMapperEx secondMeasurementMapperEx;

    public Object getSecondMeasurement(Long id) {
        SecondMeasurement result = null;
        try {
            result = secondMeasurementMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    public List<SecondMeasurement> findByMeasurementId(Long id) {
        SecondMeasurementExample example = new SecondMeasurementExample();
        example.createCriteria().andMeasurementIdEqualTo(id).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<SecondMeasurement> secondMeasurementList = null;
        try {
            secondMeasurementList = secondMeasurementMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return secondMeasurementList;
    }

    public List<SecondMeasurementVo> select(String measurementId, int offset, int rows) {
        List<SecondMeasurementVo> result = null;
        Long id = null;
        if (StringUtil.isNotEmpty(measurementId)) {
            id = Long.parseLong(measurementId);
        }
        try {
            result = secondMeasurementMapperEx.selectByConditionSecondMeasurement(id, offset, rows);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    public Long countSecondMeasurement(String measurementId) {
        Long result = null;
        Long id = null;
        if (StringUtil.isNotEmpty(measurementId)) {
            id = Long.parseLong(measurementId);
        }
        try {
            result = secondMeasurementMapperEx.countSecondMeasurement(id);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertSecondMeasurement(JSONObject obj, HttpServletRequest request) {
        SecondMeasurement secondMeasurement = JSONObject.parseObject(obj.toJSONString(), SecondMeasurement.class);
        int result = 0;
        try {
            result = secondMeasurementMapper.insertSelective(secondMeasurement);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateSecondMeasurement(JSONObject obj, HttpServletRequest request) {
        SecondMeasurement secondMeasurement = JSONObject.parseObject(obj.toJSONString(), SecondMeasurement.class);
        int result = 0;
        try {
            result = secondMeasurementMapper.updateByPrimaryKeySelective(secondMeasurement);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteSecondMeasurement(Long id, HttpServletRequest request) {
        return batchDeleteSecondMeasurementByIds(id.toString());
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteSecondMeasurement(String ids, HttpServletRequest request) {
        return batchDeleteSecondMeasurementByIds(ids);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteSecondMeasurementByIds(String ids) {
        int result = 0;
        String[] idArray = ids.split(",");
        try {
            result = secondMeasurementMapperEx.batchDeleteSecondMeasurementByIds(idArray);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void addSecondMeasurement(List<SecondMeasurement> secondMeasurementList, String deleteId, HttpServletRequest request) {
        try {
            if (secondMeasurementList != null && secondMeasurementList.size() > 0) {
                for (SecondMeasurement secondMeasurement : secondMeasurementList) {
                    if (secondMeasurement.getId() == null) {
                        //执行新增
                        secondMeasurementMapper.insertSelective(secondMeasurement);
                    } else {
                        //执行编辑
                        secondMeasurementMapper.updateByPrimaryKeySelective(secondMeasurement);
                    }
                }
            }
            //执行删除
            if (StringUtil.isNotEmpty(deleteId)) {
                batchDeleteSecondMeasurementByIds(deleteId);
            }
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
    }
}
