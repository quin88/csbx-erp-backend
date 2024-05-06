package com.jsh.erp.service.process;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.service.ICommonQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service(value = "process")
@ProcessResource
public class ProcessComponent implements ICommonQuery {
    @Resource
    private ProcessService processService;


    @Override
    public Object selectOne(Long id) throws Exception {
        return null;
    }

    @Override
    public List<?> select(Map<String, String> parameterMap) throws Exception {
        return null;
    }

    @Override
    public Long counts(Map<String, String> parameterMap) throws Exception {
        return null;
    }

    @Override
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception {
        return processService.insertProcess(obj, request);
    }

    @Override
    public int update(JSONObject obj, HttpServletRequest request) throws Exception {
        return processService.updateProcess(obj, request);
    }

    @Override
    public int delete(Long id, HttpServletRequest request) throws Exception {
        return processService.deleteProcess(id, request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request) throws Exception {
        return processService.batchDeleteProcess(ids, request);
    }

    @Override
    public int checkIsNameExist(Long id, String name) throws Exception {
        return 0;
    }
}
