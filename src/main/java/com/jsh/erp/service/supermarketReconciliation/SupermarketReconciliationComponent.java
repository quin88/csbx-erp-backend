package com.jsh.erp.service.supermarketReconciliation;

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

@Service(value = "supermarketReconciliation_component")
@SupermarketReconciliationResource
public class SupermarketReconciliationComponent implements ICommonQuery {

    @Resource
    private SupermarketReconciliationService supermarketReconciliationService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return supermarketReconciliationService.selectOne(id);
    }

    @Override
    public List<?> select(Map<String, String> map) throws Exception {
        String search = map.get(Constants.SEARCH);
        Long id = StringUtil.parseStrLong(StringUtil.getInfo(search, "id"));
        String atId = StringUtil.getInfo(search, "aquaticTypeId");//品类ID
        String beginTime = StringUtil.getInfo(search, "beginTime");
        String endTime = StringUtil.getInfo(search, "endTime");
        String number = StringUtil.getInfo(search, "number");
        String status = StringUtil.getInfo(search, "status");
        String reconciliationBeginTime = StringUtil.getInfo(search, "reconciliationBeginTime");
        String reconciliationEndTime = StringUtil.getInfo(search, "reconciliationEndTime");
        return supermarketReconciliationService.search(id, atId, beginTime, endTime, number, status,
                reconciliationBeginTime, reconciliationEndTime, QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map) throws Exception {
        String search = map.get(Constants.SEARCH);
        Long id = StringUtil.parseStrLong(StringUtil.getInfo(search, "id"));
        String atId = StringUtil.getInfo(search, "aquaticTypeId");//品类ID
        String beginTime = StringUtil.getInfo(search, "beginTime");
        String endTime = StringUtil.getInfo(search, "endTime");
        String number = StringUtil.getInfo(search, "number");
        String status = StringUtil.getInfo(search, "status");
        String reconciliationBeginTime = StringUtil.getInfo(search, "reconciliationBeginTime");
        String reconciliationEndTime = StringUtil.getInfo(search, "reconciliationEndTime");
        return supermarketReconciliationService.counts(id, atId, beginTime, endTime, number, status, reconciliationBeginTime, reconciliationEndTime);
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
        return supermarketReconciliationService.delete(id, request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request) throws Exception {
        return supermarketReconciliationService.batchDelete(ids, request);
    }

    @Override
    public int checkIsNameExist(Long id, String name) throws Exception {
        return 0;
    }
}
