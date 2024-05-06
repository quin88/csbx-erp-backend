package com.jsh.erp.service.marketAddress;

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

@Service(value = "marketAddress_component")
@MarketAddressResource
public class MarketAddressComponent implements ICommonQuery {
    @Resource
    private MarketAddressService marketAddressService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return marketAddressService.selectOne(id);
    }

    @Override
    public List<?> select(Map<String, String> map) throws Exception {
        return getMarketList(map);
    }

    private List<?> getMarketList(Map<String, String> map) {
        String search = map.get(Constants.SEARCH);
        return marketAddressService.select();
    }

    @Override
    public Long counts(Map<String, String> map) throws Exception {
        String search = map.get(Constants.SEARCH);
        return marketAddressService.counts();
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
