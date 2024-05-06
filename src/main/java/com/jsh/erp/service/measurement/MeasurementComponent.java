package com.jsh.erp.service.measurement;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.service.ICommonQuery;
import com.jsh.erp.utils.Constants;
import com.jsh.erp.utils.QueryUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service(value = "measurement_component")
@MeasurementResource
public class MeasurementComponent implements ICommonQuery {
    @Resource
    private MeasurementService measurementService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return measurementService.getMeasurement(id);
    }

    @Override
    public List<?> select(Map<String, String> map) throws Exception {
        return getMeasurementList(map);
    }

    private List<?> getMeasurementList(Map<String, String> map) {
        String search = map.get(Constants.SEARCH);
        return measurementService.select(QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> parameterMap) throws Exception {
        return measurementService.countMeasurement();
    }

    @Override
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception {
        return measurementService.insertMeasurement(obj,request);
    }

    @Override
    public int update(JSONObject obj, HttpServletRequest request) throws Exception {
        return measurementService.updateMeasurement(obj,request);
    }

    @Override
    public int delete(Long id, HttpServletRequest request) throws Exception {
        return measurementService.deleteMeasurement(id,request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request) throws Exception {
        return measurementService.batchDeleteMeasurement(ids,request);
    }

    @Override
    public int checkIsNameExist(Long id, String name) throws Exception {
        return measurementService.checkIsNameExist(id,name);
    }
}
