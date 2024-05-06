package com.jsh.erp.service.market;

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

@Service(value = "market_component")
@MarketResource
public class MarketComponent implements ICommonQuery {
    @Resource
    private MarketService marketService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return marketService.selectOne(id);
    }

    @Override
    public List<?> select(Map<String, String> map) throws Exception {
        return getMarketList(map);
    }

    private List<?> getMarketList(Map<String, String> map) {
        String search = map.get(Constants.SEARCH);
        String number = StringUtil.getInfo(search, "number");
        String name = StringUtil.getInfo(search, "name");
        String enabled = StringUtil.getInfo(search, "enabled");
        return marketService.select(number, name, enabled, QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map) throws Exception {
        String search = map.get(Constants.SEARCH);
        String number = StringUtil.getInfo(search, "number");
        String name = StringUtil.getInfo(search, "name");
        String enabled = StringUtil.getInfo(search, "enabled");
        return marketService.counts(number, name, enabled);
    }

    @Override
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception {
        return marketService.insertMarket(obj, request);
    }

    @Override
    public int update(JSONObject obj, HttpServletRequest request) throws Exception {
        return marketService.updateMarket(obj, request);
    }

    @Override
    public int delete(Long id, HttpServletRequest request) throws Exception {
        return marketService.deleteMarket(id, request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request) throws Exception {
        return marketService.batchDeleteMarket(ids, request);
    }

    @Override
    public int checkIsNameExist(Long id, String name) throws Exception {
        return 0;
    }
}
