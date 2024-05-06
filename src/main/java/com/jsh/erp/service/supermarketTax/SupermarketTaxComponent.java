package com.jsh.erp.service.supermarketTax;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.service.ICommonQuery;
import com.jsh.erp.utils.Constants;
import com.jsh.erp.utils.QueryUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service(value = "supermarketTax_component")
@SupermarketTaxResource
public class SupermarketTaxComponent implements ICommonQuery {
    @Resource
    private SupermarketTaxService supermarketTaxService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return supermarketTaxService.selectOne(id);
    }

    @Override
    public List<?> select(Map<String, String> map) throws Exception {
        return getSupermarketTaxList(map);
    }

    private List<?> getSupermarketTaxList(Map<String, String> map) {
        String search = map.get(Constants.SEARCH);
        return supermarketTaxService.select(QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map) throws Exception {
        String search = map.get(Constants.SEARCH);
        return supermarketTaxService.counts();
    }

    @Override
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception {
        return supermarketTaxService.insert(obj, request);
    }

    @Override
    public int update(JSONObject obj, HttpServletRequest request) throws Exception {
        return supermarketTaxService.update(obj, request);
    }

    @Override
    public int delete(Long id, HttpServletRequest request) throws Exception {
        return supermarketTaxService.delete(id, request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request) throws Exception {
        return supermarketTaxService.deleteBatch(ids, request);
    }

    @Override
    public int checkIsNameExist(Long id, String name) throws Exception {
        return 0;
    }
}
