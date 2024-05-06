package com.jsh.erp.service.opinion;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.service.ICommonQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service(value = "opinion_component")
@OpinionResource
public class OpinionComponent implements ICommonQuery {
    @Resource
    private OpinionService opinionService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return null;
    }

    @Override
    public List<?> select(Map<String, String> map) throws Exception {
        return null;
    }

    @Override
    public Long counts(Map<String, String> map) throws Exception {
        return null;
    }

    @Override
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception {
        return opinionService.insert(obj, request);
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
