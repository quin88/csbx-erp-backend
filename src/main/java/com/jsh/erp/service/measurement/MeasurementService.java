package com.jsh.erp.service.measurement;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.MeasurementMapper;
import com.jsh.erp.datasource.mappers.MeasurementMapperEx;
import com.jsh.erp.datasource.vo.SecondMeasurementVo;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.user.UserService;
import com.jsh.erp.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;


@Service
public class MeasurementService {
    private Logger logger = LoggerFactory.getLogger(MeasurementService.class);

    @Resource
    private MeasurementMapper measurementMapper;

    @Resource
    private MeasurementMapperEx measurementMapperEx;

    @Resource
    private UserService userService;

    public Measurement getMeasurement(Long id) {
        Measurement result = null;
        try {
            result = measurementMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    public List<Measurement> getMeasurement() {
        MeasurementExample example = new MeasurementExample();
        example.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<Measurement> list = null;
        try {
            list = measurementMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<Measurement> select(int offset, int rows) {
        List<Measurement> result = null;
        try {
            result = measurementMapperEx.selectByConditionMeasurement(offset, rows);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    public Long countMeasurement() {
        Long result = null;
        try {
            result = measurementMapperEx.countMeasurement();
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertMeasurement(JSONObject obj, HttpServletRequest request) {
        Measurement measurement = JSONObject.parseObject(obj.toJSONString(), Measurement.class);
        int result = 0;
        try {
            result = measurementMapper.insertSelective(measurement);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateMeasurement(JSONObject obj, HttpServletRequest request) {
        Measurement measurement = JSONObject.parseObject(obj.toJSONString(), Measurement.class);
        int result = 0;
        try {
            result = measurementMapper.updateByPrimaryKey(measurement);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteMeasurement(Long id, HttpServletRequest request) {
        return batchDeleteMeasurementByIds(id.toString());
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteMeasurement(String ids, HttpServletRequest request) {
        return batchDeleteMeasurementByIds(ids);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteMeasurementByIds(String ids) {
        String[] idArray = ids.split(",");
        int result = 0;
        try {
            result = measurementMapperEx.batchDeleteMeasurementByIds(idArray);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    public int checkIsNameExist(Long id, String name) {
        MeasurementExample example = new MeasurementExample();
        example.createCriteria().andIdNotEqualTo(id).andMeasurementUnitEqualTo(name).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<Measurement> list = null;
        try {
            list = measurementMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list == null ? 0 : list.size();
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void addMeasurement(List<Measurement> measurementList, String deleteId, HttpServletRequest request) throws Exception {
        try {
            if (measurementList != null && measurementList.size() > 0) {
                for (Measurement measurement : measurementList) {
                    if (measurement.getId() == null) {
                        //执行新增
                        measurementMapper.insertSelective(measurement);
                    } else {
                        //执行编辑
                        measurementMapper.updateByPrimaryKeySelective(measurement);
                    }
                }
            }
            //执行删除
            if (StringUtil.isNotEmpty(deleteId)) {
                batchDeleteMeasurementByIds(deleteId);
            }
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
    }
}
