package com.jsh.erp.service.supermarketSystemConfig;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.datasource.entities.SupermarketServeClient;
import com.jsh.erp.datasource.entities.SupermarketSystemConfig;
import com.jsh.erp.datasource.vo.SupermarketSystemConfigVo;
import com.jsh.erp.service.ICommonQuery;
import com.jsh.erp.utils.Constants;
import com.jsh.erp.utils.QueryUtils;
import com.jsh.erp.utils.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service(value = "supermarketSystemConfig_component")
@SupermarketSystemConfigResource
public class SupermarketSystemConfigComponent implements ICommonQuery {
    @Resource
    private SupermarketSystemConfigService supermarketSystemConfigService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return supermarketSystemConfigService.selectOne(id);
    }

    @Override
    public List<?> select(Map<String, String> map) throws Exception {
        return getSupermarketSystemConfigList(map);
    }

    private List<?> getSupermarketSystemConfigList(Map<String, String> map) {
        List<SupermarketSystemConfigVo> result = null;
        try {
            result = supermarketSystemConfigService.select(QueryUtils.offset(map), QueryUtils.rows(map));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Long counts(Map<String, String> map) throws Exception {
        String search = map.get(Constants.SEARCH);
        return supermarketSystemConfigService.counts();
    }

    @Override
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception {
        return supermarketSystemConfigService.insert(obj, request);
    }

    @Override
    public int update(JSONObject obj, HttpServletRequest request) throws Exception {
        return supermarketSystemConfigService.update(obj, request);
    }

    @Override
    public int delete(Long id, HttpServletRequest request) throws Exception {
        return supermarketSystemConfigService.delete(id, request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request) throws Exception {
        return supermarketSystemConfigService.deleteBatch(ids, request);
    }

    @Override
    public int checkIsNameExist(Long id, String name) throws Exception {
        return 0;
    }
}
