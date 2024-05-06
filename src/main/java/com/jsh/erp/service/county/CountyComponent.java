package com.jsh.erp.service.county;

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

@Service(value = "county_component")
@CountyResource
public class CountyComponent implements ICommonQuery {

    @Resource
    private CountyService countyService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return null;
    }

    @Override
    public List<?> select(Map<String, String> map) throws Exception {

        String search = map.get(Constants.SEARCH);
        Long id = StringUtil.parseStrLong(StringUtil.getInfo(search, "id"));
        Long provinceId = StringUtil.parseStrLong(StringUtil.getInfo(search, "provinceId"));
        Long cityId = StringUtil.parseStrLong(StringUtil.getInfo(search, "cityId"));
        String countyName = StringUtil.getInfo(search, "countyName");
        String enabled = StringUtil.getInfo(search, "enabled");
        return countyService.select(id, provinceId, cityId, countyName, enabled,
                QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map) throws Exception {
        String search = map.get(Constants.SEARCH);
        Long id = StringUtil.parseStrLong(StringUtil.getInfo(search, "id"));
        Long provinceId = StringUtil.parseStrLong(StringUtil.getInfo(search, "provinceId"));
        Long cityId = StringUtil.parseStrLong(StringUtil.getInfo(search, "cityId"));
        String countyName = StringUtil.getInfo(search, "countyName");
        String enabled = StringUtil.getInfo(search, "enabled");
        return countyService.counts(id, provinceId, cityId, countyName, enabled);
    }

    @Override
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception {
        return countyService.insert(obj, request);
    }

    @Override
    public int update(JSONObject obj, HttpServletRequest request) throws Exception {
        return countyService.update(obj, request);
    }

    @Override
    public int delete(Long id, HttpServletRequest request) throws Exception {
        return countyService.delete(id, request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request) throws Exception {
        return countyService.deleteBatch(ids, request);
    }

    @Override
    public int checkIsNameExist(Long id, String name) throws Exception {
        return 0;
    }
}
