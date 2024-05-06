package com.jsh.erp.service.valueAddedServeType;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.datasource.entities.ValueAddedServeType;
import com.jsh.erp.service.ICommonQuery;
import com.jsh.erp.utils.Constants;
import com.jsh.erp.utils.QueryUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service(value = "valueAddedServeType_component")
@ValueAddedServeTypeResource
public class ValueAddedServeTypeComponent implements ICommonQuery {
    @Resource
    private ValueAddedServeTypeService valueAddedServeTypeService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return valueAddedServeTypeService.selectOne(id);
    }

    @Override
    public List<?> select(Map<String, String> map) throws Exception {
        return getValueAddedServeTypeList(map);
    }

    private List<?> getValueAddedServeTypeList(Map<String, String> map) {
        List<ValueAddedServeType> result = null;
        try {
            result = valueAddedServeTypeService.select();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Long counts(Map<String, String> map) throws Exception {
        return valueAddedServeTypeService.counts();
    }

    @Override
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception {
        return valueAddedServeTypeService.insert(obj, request);
    }

    @Override
    public int update(JSONObject obj, HttpServletRequest request) throws Exception {
        return valueAddedServeTypeService.update(obj, request);
    }

    @Override
    public int delete(Long id, HttpServletRequest request) throws Exception {
        return valueAddedServeTypeService.delete(id, request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request) throws Exception {
        return valueAddedServeTypeService.deleteBatch(ids, request);
    }

    @Override
    public int checkIsNameExist(Long id, String name) throws Exception {
        return 0;
    }
}
