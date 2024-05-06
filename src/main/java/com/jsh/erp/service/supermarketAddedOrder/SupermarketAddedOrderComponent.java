package com.jsh.erp.service.supermarketAddedOrder;

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

@Service(value = "supermarketAddedOrder_component")
@SupermarketAddedOrderResource
public class SupermarketAddedOrderComponent implements ICommonQuery {

    @Resource
    private SupermarketAddedOrderService supermarketAddedOrderService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return supermarketAddedOrderService.selectOne(id);
    }

    @Override
    public List<?> select(Map<String, String> map) throws Exception {
        String search = map.get(Constants.SEARCH);
        Long id = StringUtil.parseStrLong(StringUtil.getInfo(search, "id"));
        String beginTime = StringUtil.getInfo(search, "beginTime");
        String endTime = StringUtil.getInfo(search, "endTime");
        String number = StringUtil.getInfo(search, "number");
        String status = StringUtil.getInfo(search, "status");
        String linkNumber = StringUtil.getInfo(search, "linkNumber");
        return supermarketAddedOrderService.search(id, beginTime, endTime, number, status, linkNumber, QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map) throws Exception {
        String search = map.get(Constants.SEARCH);
        Long id = StringUtil.parseStrLong(StringUtil.getInfo(search, "id"));
        String beginTime = StringUtil.getInfo(search, "beginTime");
        String endTime = StringUtil.getInfo(search, "endTime");
        String number = StringUtil.getInfo(search, "number");
        String status = StringUtil.getInfo(search, "status");
        String linkNumber = StringUtil.getInfo(search, "linkNumber");
        return supermarketAddedOrderService.counts(id, beginTime, endTime, number, status, linkNumber);
    }

    @Override
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception {
        return supermarketAddedOrderService.insert(obj, request);
    }

    @Override
    public int update(JSONObject obj, HttpServletRequest request) throws Exception {
        return supermarketAddedOrderService.update(obj, request);
    }

    @Override
    public int delete(Long id, HttpServletRequest request) throws Exception {
        return supermarketAddedOrderService.delete(id, request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request) throws Exception {
        return supermarketAddedOrderService.batchDelete(ids, request);
    }

    @Override
    public int checkIsNameExist(Long id, String name) throws Exception {
        return 0;
    }
}
