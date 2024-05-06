package com.jsh.erp.service.serveProject;

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

@Service(value = "serveProject")
@ServeProjectResource
public class ServeProjectComponent implements ICommonQuery {

    @Resource
    private ServeProjectService serveProjectService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return serveProjectService.getServeProject(id);
    }

    @Override
    public List<?> select(Map<String, String> map) throws Exception {
        return getServeProjectList(map);
    }

    private List<?> getServeProjectList(Map<String, String> map) throws Exception {
        String search = map.get(Constants.SEARCH);
        String type = StringUtil.getInfo(search, "type");
        String active = StringUtil.getInfo(search, "active");
        String projectName = StringUtil.getInfo(search, "projectName");
        return serveProjectService.select(type, active, projectName, QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map) throws Exception {
        String search = map.get(Constants.SEARCH);
        String type = StringUtil.getInfo(search, "type");
        String active = StringUtil.getInfo(search, "active");
        String projectName = StringUtil.getInfo(search, "projectName");
        return serveProjectService.count(type, active, projectName);
    }

    @Override
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception {
        return serveProjectService.insertServeProject(obj, request);
    }

    @Override
    public int update(JSONObject obj, HttpServletRequest request) throws Exception {
        return serveProjectService.updateServeProject(obj, request);
    }

    @Override
    public int delete(Long id, HttpServletRequest request) throws Exception {
        return serveProjectService.deleteServeProject(id, request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request) throws Exception {
        return serveProjectService.batchDeleteServeProject(ids, request);
    }

    @Override
    public int checkIsNameExist(Long id, String name) throws Exception {
        return 0;
    }

}
