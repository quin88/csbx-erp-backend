package com.jsh.erp.service.supermarketOrder;

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

@Service(value = "supermarketOrder_component")
@SupermarketOrderResource
public class SupermarketOrderComponent implements ICommonQuery {

    @Resource
    private SupermarketOrderService supermarketOrderService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return supermarketOrderService.selectOne(id);
    }

    @Override
    public List<?> select(Map<String, String> map) throws Exception {
        String search = map.get(Constants.SEARCH);
        Long id = StringUtil.parseStrLong(StringUtil.getInfo(search, "id"));
        String category = StringUtil.getInfo(search, "category");
        String beginTime = StringUtil.getInfo(search, "beginTime");
        String endTime = StringUtil.getInfo(search, "endTime");
        String number = StringUtil.getInfo(search, "number");
        String status = StringUtil.getInfo(search, "status");
        String uploadStatus = StringUtil.getInfo(search, "uploadStatus");
        Long serveClientId = StringUtil.parseStrLong(StringUtil.getInfo(search, "serveClientId"));//服务商
        String tradeBeginTime = StringUtil.getInfo(search, "tradeBeginTime");//交易开始时间
        String tradeEndTime = StringUtil.getInfo(search, "tradeEndTime");//交易结束时间
        Long marketAddressId = StringUtil.parseStrLong(StringUtil.getInfo(search, "marketAddressId"));//市场
        String linkFlag = StringUtil.getInfo(search, "linkFlag");//关联标记，1：过滤已被关联的订单
        return supermarketOrderService.search(id, category, beginTime, endTime, number, status, uploadStatus,
                serveClientId, tradeBeginTime, tradeEndTime, marketAddressId, linkFlag, QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map) throws Exception {
        String search = map.get(Constants.SEARCH);
        Long id = StringUtil.parseStrLong(StringUtil.getInfo(search, "id"));
        String category = StringUtil.getInfo(search, "category");
        String beginTime = StringUtil.getInfo(search, "beginTime");
        String endTime = StringUtil.getInfo(search, "endTime");
        String number = StringUtil.getInfo(search, "number");
        String status = StringUtil.getInfo(search, "status");
        String uploadStatus = StringUtil.getInfo(search, "uploadStatus");
        Long serveClientId = StringUtil.parseStrLong(StringUtil.getInfo(search, "serveClientId"));
        String tradeBeginTime = StringUtil.getInfo(search, "tradeBeginTime");
        String tradeEndTime = StringUtil.getInfo(search, "tradeEndTime");
        Long marketAddressId = StringUtil.parseStrLong(StringUtil.getInfo(search, "marketAddressId"));
        String linkFlag = StringUtil.getInfo(search, "linkFlag");//关联标记
        return supermarketOrderService.counts(id, category, beginTime, endTime, number, status, uploadStatus
                , serveClientId, tradeBeginTime, tradeEndTime, marketAddressId, linkFlag);
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
        return supermarketOrderService.deleteSupermarketOrder(id, request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request) throws Exception {
        return supermarketOrderService.batchDeleteSupermarketOrder(ids, request);
    }

    @Override
    public int checkIsNameExist(Long id, String name) throws Exception {
        return 0;
    }
}
