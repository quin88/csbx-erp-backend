package com.jsh.erp.service.secondSettlementMethod;

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

@Service(value = "secondSettlementMethod_component")
@SecondSettlementMethodResource
public class SecondSettlementMethodComponent implements ICommonQuery {

    @Resource
    private SecondSettlementMethodService secondSettlementMethodService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return secondSettlementMethodService.getSecondSettlementMethod(id);
    }

    @Override
    public List<?> select(Map<String, String> map) throws Exception {
        return getSecondSettlementMethodList(map);
    }

    private List<?> getSecondSettlementMethodList(Map<String, String> map) {
        String search = map.get(Constants.SEARCH);
        String settlement = StringUtil.getInfo(search, "settlement");
        String settlementId = StringUtil.getInfo(search, "settlementId");
        String secondSettlement = StringUtil.getInfo(search, "secondSettlement");
        return secondSettlementMethodService.select(settlement, settlementId, secondSettlement, QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map) throws Exception {
        String search = map.get(Constants.SEARCH);
        String settlement = StringUtil.getInfo(search, "settlement");
        String settlementId = StringUtil.getInfo(search, "settlementId");
        String secondSettlement = StringUtil.getInfo(search, "secondSettlement");
        return secondSettlementMethodService.countSecondSettlement(settlement, settlementId, secondSettlement);
    }

    @Override
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception {
        return secondSettlementMethodService.insertSecondSettlementMethod(obj, request);
    }

    @Override
    public int update(JSONObject obj, HttpServletRequest request) throws Exception {
        return secondSettlementMethodService.updateSecondSettlementMethod(obj, request);
    }

    @Override
    public int delete(Long id, HttpServletRequest request) throws Exception {
        return secondSettlementMethodService.deleteSecondSettlementMethod(id, request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request) throws Exception {
        return secondSettlementMethodService.batchDeleteSecondSettlementMethod(ids, request);
    }

    @Override
    public int checkIsNameExist(Long id, String name) throws Exception {
        return 0;
    }
}
