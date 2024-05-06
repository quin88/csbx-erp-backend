package com.jsh.erp.service.supermarketSupplier;

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

@Service(value = "supermarketSupplier_component")
@SupermarketSupplierResource
public class SupermarketSupplierComponent implements ICommonQuery {
    @Resource
    private SupermarketSupplierService supermarketSupplierService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return supermarketSupplierService.getSupermarketSupplier(id);
    }

    @Override
    public List<?> select(Map<String, String> map) throws Exception {
        return getSupermarketSupplierList(map);
    }

    private List<?> getSupermarketSupplierList(Map<String, String> map) {
        String search = map.get(Constants.SEARCH);
        String number = StringUtil.getInfo(search, "number");
        String name = StringUtil.getInfo(search, "name");
        String supplierLevel = StringUtil.getInfo(search, "supplierLevel");
        String status = StringUtil.getInfo(search, "status");
        return supermarketSupplierService.select(number, name, supplierLevel, status, QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map) throws Exception {
        String search = map.get(Constants.SEARCH);
        String number = StringUtil.getInfo(search, "number");
        String name = StringUtil.getInfo(search, "name");
        String supplierLevel = StringUtil.getInfo(search, "supplierLevel");
        String status = StringUtil.getInfo(search, "status");
        return supermarketSupplierService.countSupermarketSupplier(number, name, supplierLevel, status);
    }

    @Override
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception {
        return supermarketSupplierService.insertSuperMarketSupplierService(obj, request);
    }

    @Override
    public int update(JSONObject obj, HttpServletRequest request) throws Exception {
        return supermarketSupplierService.updateSuperMarketSupplierService(obj, request);
    }

    @Override
    public int delete(Long id, HttpServletRequest request) throws Exception {
        return supermarketSupplierService.deleteSuperMarketSupplier(id, request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request) throws Exception {
        return supermarketSupplierService.batchDeleteSuperMarketSupplier(ids, request);
    }

    @Override
    public int checkIsNameExist(Long id, String name) throws Exception {
        return 0;
    }
}
