package com.jsh.erp.service.settlementMethod;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.service.ICommonQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service(value = "settlementMethod_component")
@SettlementMethodResource
public class SettlementMethodComponent implements ICommonQuery {
    @Resource
    private SettlementMethodService settlementMethodService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return settlementMethodService.getSettlementMethod(id);
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
        return settlementMethodService.insertSettlementMethod(obj, request);
    }

    @Override
    public int update(JSONObject obj, HttpServletRequest request) throws Exception {
        return settlementMethodService.updateSettlementMethod(obj, request);
    }

    @Override
    public int delete(Long id, HttpServletRequest request) throws Exception {
        return settlementMethodService.deleteSettlementMethod(id, request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request) throws Exception {
        return settlementMethodService.batchDeleteSettlementMethod(ids, request);
    }

    @Override
    public int checkIsNameExist(Long id, String name) throws Exception {
        return 0;
    }
}
