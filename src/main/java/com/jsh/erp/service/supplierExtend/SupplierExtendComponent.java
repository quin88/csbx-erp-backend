package com.jsh.erp.service.supplierExtend;

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

@Service(value = "supplierExtend")
@SupplierExtendResource
public class SupplierExtendComponent implements ICommonQuery {
    @Resource
    private SupplierExtendService supplierExtendService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return supplierExtendService.getSupplierExtend(id);
    }

    @Override
    public List<?> select(Map<String, String> map) throws Exception {
        return getSupplierExtendList(map);
    }

    private List<?> getSupplierExtendList(Map<String, String> map) {
        String search = map.get(Constants.SEARCH);
        String supplierId = StringUtil.getInfo(search, "supplierId");
        String active = StringUtil.getInfo(search, "active");
        String name = StringUtil.getInfo(search, "name");
        String phone = StringUtil.getInfo(search, "phone");
        String role = StringUtil.getInfo(search, "role");
        String checkStatus = StringUtil.getInfo(search, "checkStatus");
        return supplierExtendService.select(supplierId, active, name, phone, role, checkStatus, QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map) throws Exception {
        String search = map.get(Constants.SEARCH);
        String supplierId = StringUtil.getInfo(search, "supplierId");
        String active = StringUtil.getInfo(search, "active");
        String name = StringUtil.getInfo(search, "name");
        String phone = StringUtil.getInfo(search, "phone");
        String role = StringUtil.getInfo(search, "role");
        String checkStatus = StringUtil.getInfo(search, "checkStatus");
        return supplierExtendService.countSupplierExtend(supplierId, active, name, phone, role,checkStatus);
    }

    @Override
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception {
        return supplierExtendService.insertSupplierExtend(obj, request);
    }

    @Override
    public int update(JSONObject obj, HttpServletRequest request) throws Exception {
        return supplierExtendService.updateSupplierExtend(obj, request);
    }

    @Override
    public int delete(Long id, HttpServletRequest request) throws Exception {
        return supplierExtendService.deleteSupplierExtend(id, request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request) throws Exception {
        return supplierExtendService.batchDeleteSupplierExtend(ids, request);
    }

    @Override
    public int checkIsNameExist(Long id, String name) throws Exception {
        return supplierExtendService.checkIsNameExistExtend(id, name);
    }
}
