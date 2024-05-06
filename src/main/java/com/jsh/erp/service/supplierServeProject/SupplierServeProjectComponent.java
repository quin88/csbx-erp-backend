package com.jsh.erp.service.supplierServeProject;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.datasource.entities.SupplierServeProject;
import com.jsh.erp.service.ICommonQuery;
import com.jsh.erp.utils.Constants;
import com.jsh.erp.utils.QueryUtils;
import com.jsh.erp.utils.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service(value = "supplierServeProject")
@SupplierServeProjectResource
public class SupplierServeProjectComponent implements ICommonQuery {

    @Resource
    private SupplierServeProjectService supplierServeProjectService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return supplierServeProjectService.getSupplierServeProject(id);
    }

    @Override
    public List<?> select(Map<String, String> map) throws Exception {
        return getSupplierServeProjectList(map);
    }

    private List<?> getSupplierServeProjectList(Map<String, String> map) throws Exception {
        String search = map.get(Constants.SEARCH);
        String type = StringUtil.getInfo(search, "type");
        Long supplierId = StringUtil.parseStrLong(StringUtil.getInfo(search, "supplierId"));
        return supplierServeProjectService.select(type, supplierId, QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map) throws Exception {
        String search = map.get(Constants.SEARCH);
        String type = StringUtil.getInfo(search, "type");
        String active = StringUtil.getInfo(search, "active");
        return supplierServeProjectService.count(type, active);
    }

    @Override
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception {
        SupplierServeProject supplierServeProject = JSONObject.parseObject(obj.toJSONString(), SupplierServeProject.class);
        return supplierServeProjectService.insert(supplierServeProject, request);
    }

    @Override
    public int update(JSONObject obj, HttpServletRequest request) throws Exception {
        SupplierServeProject supplierServeProject = JSONObject.parseObject(obj.toJSONString(), SupplierServeProject.class);
        return supplierServeProjectService.update(supplierServeProject, request);
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
