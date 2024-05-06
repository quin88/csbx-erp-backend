package com.jsh.erp.service.city;

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

@Service(value = "city_component")
@CityResource
public class CityComponent implements ICommonQuery {

    @Resource
    private CityService cityService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return cityService.getCity(id);
    }

    @Override
    public List<?> select(Map<String, String> map) throws Exception {
        return getCityList(map);
    }

    private List<?> getCityList(Map<String, String> map) {
        String search = map.get(Constants.SEARCH);
        String name = StringUtil.getInfo(search, "name");
        Long province = StringUtil.parseStrLong(StringUtil.getInfo(search, "province"));
        return cityService.select(name, province, QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map) throws Exception {
        String search = map.get(Constants.SEARCH);
        String name = StringUtil.getInfo(search, "name");
        Long province = StringUtil.parseStrLong(StringUtil.getInfo(search, "province"));
        return cityService.countByCity(name, province);
    }

    @Override
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception {
        return 0;
    }

    @Override
    public int update(JSONObject obj, HttpServletRequest request) throws Exception {
        return 0;
    }

    @Override
    public int delete(Long id, HttpServletRequest request) throws Exception {
        return 0;
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request) throws Exception {
        return 0;
    }

    @Override
    public int checkIsNameExist(Long id, String name) throws Exception {
        return 0;
    }
}
