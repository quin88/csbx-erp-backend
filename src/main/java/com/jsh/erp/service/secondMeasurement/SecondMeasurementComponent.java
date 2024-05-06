package com.jsh.erp.service.secondMeasurement;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.service.ICommonQuery;
import com.jsh.erp.utils.Constants;
import com.jsh.erp.utils.QueryUtils;
import com.jsh.erp.utils.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service(value = "secondMeasurement_component")
@SecondMeasurementResource
public class SecondMeasurementComponent implements ICommonQuery {
    @Resource
    private SecondMeasurementService secondMeasurementService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return secondMeasurementService.getSecondMeasurement(id);
    }

    @Override
    public List<?> select(Map<String, String> map) throws Exception {
        return getSecondMeasurementList(map);
    }

    private List<?> getSecondMeasurementList(Map<String, String> map) {
        String search = map.get(Constants.SEARCH);
        String measurementId = StringUtil.getInfo(search, "measurementId");
        return secondMeasurementService.select(measurementId, QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map) throws Exception {
        String search = map.get(Constants.SEARCH);
        String measurementId = StringUtil.getInfo(search, "measurementId");
        return secondMeasurementService.countSecondMeasurement(measurementId);
    }

    @Override
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception {
        return secondMeasurementService.insertSecondMeasurement(obj, request);
    }

    @Override
    public int update(JSONObject obj, HttpServletRequest request) throws Exception {
        return secondMeasurementService.updateSecondMeasurement(obj, request);
    }

    @Override
    public int delete(Long id, HttpServletRequest request) throws Exception {
        return secondMeasurementService.deleteSecondMeasurement(id, request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request) throws Exception {
        return secondMeasurementService.batchDeleteSecondMeasurement(ids, request);
    }

    @Override
    public int checkIsNameExist(Long id, String name) throws Exception {
        return 0;
    }
}
