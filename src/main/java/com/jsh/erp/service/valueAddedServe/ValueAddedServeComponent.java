package com.jsh.erp.service.valueAddedServe;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.datasource.entities.ValueAddedServe;
import com.jsh.erp.datasource.entities.ValueAddedServeType;
import com.jsh.erp.datasource.vo.ValueAddedServeVo;
import com.jsh.erp.service.ICommonQuery;
import com.jsh.erp.utils.Constants;
import com.jsh.erp.utils.QueryUtils;
import com.jsh.erp.utils.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service(value = "valueAddedServe_component")
@ValueAddedServeResource
public class ValueAddedServeComponent implements ICommonQuery {
    @Resource
    private ValueAddedServeService valueAddedServeService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return valueAddedServeService.selectOne(id);
    }

    @Override
    public List<?> select(Map<String, String> map) throws Exception {
        return getValueAddedServeTypeList(map);
    }

    private List<?> getValueAddedServeTypeList(Map<String, String> map) {
        String search = map.get(Constants.SEARCH);
        Long serveTypeId = StringUtil.parseStrLong(StringUtil.getInfo(search, "serveTypeId"));
        String title = StringUtil.getInfo(search, "title");
        String enabledFlag = StringUtil.getInfo(search, "enabledFlag");
        List<ValueAddedServeVo> result = null;
        try {
            result = valueAddedServeService.select(serveTypeId, title, enabledFlag,
                    QueryUtils.offset(map), QueryUtils.rows(map));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Long counts(Map<String, String> map) throws Exception {
        String search = map.get(Constants.SEARCH);
        Long serveTypeId = StringUtil.parseStrLong(StringUtil.getInfo(search, "serveTypeId"));
        String title = StringUtil.getInfo(search, "title");
        String enabledFlag = StringUtil.getInfo(search, "enabledFlag");
        Long result = null;
        try {
            result = valueAddedServeService.counts(serveTypeId, title, enabledFlag);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception {
        return valueAddedServeService.insert(obj, request);
    }

    @Override
    public int update(JSONObject obj, HttpServletRequest request) throws Exception {
        return valueAddedServeService.update(obj, request);
    }

    @Override
    public int delete(Long id, HttpServletRequest request) throws Exception {
        return valueAddedServeService.delete(id, request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request) throws Exception {
        return valueAddedServeService.deleteBatch(ids, request);
    }

    @Override
    public int checkIsNameExist(Long id, String name) throws Exception {
        return 0;
    }
}
