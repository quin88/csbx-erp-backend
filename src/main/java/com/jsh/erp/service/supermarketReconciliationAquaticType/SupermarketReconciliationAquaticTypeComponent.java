package com.jsh.erp.service.supermarketReconciliationAquaticType;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.service.ICommonQuery;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service(value = "supermarketReconciliationAquaticType_component")
@SupermarketReconciliationAquaticTypeResource
public class SupermarketReconciliationAquaticTypeComponent implements ICommonQuery {

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
