package com.jsh.erp.service.marketArea;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.service.ICommonQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service(value = "marketArea_component")
@MarketAreaResource
public class MarketAreaComponent implements ICommonQuery {
    @Resource
    private MarketAreaService areaService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return areaService.getMarketArea(id);
    }

    @Override
    public List<?> select(Map<String, String> parameterMap) throws Exception {
        return null;
    }

    @Override
    public Long counts(Map<String, String> parameterMap) throws Exception {
        return null;
    }

    @Override
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception {
        return areaService.insertMarketArea(obj, request);
    }

    @Override
    public int update(JSONObject obj, HttpServletRequest request) throws Exception {
        return areaService.updateMarketArea(obj, request);
    }

    @Override
    public int delete(Long id, HttpServletRequest request) throws Exception {
        return areaService.deleteMarketArea(id, request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request) throws Exception {
        return areaService.batchDeleteMarketArea(ids, request);
    }

    @Override
    public int checkIsNameExist(Long id, String name) throws Exception {
        return 0;
    }
}
