package com.jsh.erp.service.paymentRecords;

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

@Service(value = "paymentRecords_component")
@PaymentRecordsResource
public class PaymentRecordsComponent implements ICommonQuery {

    @Resource
    private PaymentRecordsService paymentRecordsService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return null;
    }

    @Override
    public List<?> select(Map<String, String> map) throws Exception {

        String search = map.get(Constants.SEARCH);
        String supplierId = StringUtil.getInfo(search, "supplierId");
        String beginTime = StringUtil.getInfo(search, "beginTime");
        String endTime = StringUtil.getInfo(search, "endTime");
        String searchType = StringUtil.getInfo(search, "searchType");
        String status = StringUtil.getInfo(search, "status");
        String paymentStatus = StringUtil.getInfo(search, "paymentStatus");//缴费状态,null：查询所有，0：异常，1：正常
        return paymentRecordsService.select(supplierId, beginTime, endTime, searchType, status, paymentStatus, QueryUtils.offset(map), QueryUtils.rows(map));

    }


    @Override
    public Long counts(Map<String, String> map) throws Exception {
        String search = map.get(Constants.SEARCH);
        String supplierId = StringUtil.getInfo(search, "supplierId");
        String beginTime = StringUtil.getInfo(search, "beginTime");
        String endTime = StringUtil.getInfo(search, "endTime");
        String searchType = StringUtil.getInfo(search, "searchType");
        String status = StringUtil.getInfo(search, "status");
        String paymentStatus = StringUtil.getInfo(search, "paymentStatus");//缴费状态,null：查询所有，0：异常，1：正常
        return paymentRecordsService.counts(supplierId, beginTime, endTime, searchType, status, paymentStatus);
    }

    @Override
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception {
        return paymentRecordsService.insertPaymentRecord(obj, request);
    }

    @Override
    public int update(JSONObject obj, HttpServletRequest request) throws Exception {
        return paymentRecordsService.updatePaymentRecords(obj, request);
    }

    @Override
    public int delete(Long id, HttpServletRequest request) throws Exception {
        return 0;
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request) throws Exception {
        return paymentRecordsService.batchDeletePaymentRecords(ids, request);
    }

    @Override
    public int checkIsNameExist(Long id, String name) throws Exception {
        return 0;
    }

}
