package com.jsh.erp.service.supermarketDocument;

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

@Service(value = "supermarketDocument_component")
@SupermarketDocumentResource
public class SupermarketDocumentComponent implements ICommonQuery {

    @Resource
    private SupermarketDocumentService supermarketDocumentService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return supermarketDocumentService.selectOne(id);
    }

    @Override
    public List<?> select(Map<String, String> map) throws Exception {
        String search = map.get(Constants.SEARCH);
        String supplier = StringUtil.getInfo(search, "supplier");
        String organ = StringUtil.getInfo(search, "organ");
        String beginTime = StringUtil.getInfo(search, "beginTime");
        String endTime = StringUtil.getInfo(search, "endTime");
        String number = StringUtil.getInfo(search, "number");
        String invoiceNumber = StringUtil.getInfo(search, "invoiceNumber");
        String status = StringUtil.getInfo(search, "status");
        String type = StringUtil.getInfo(search, "type");
        return supermarketDocumentService.search(supplier, organ, beginTime, endTime, number, invoiceNumber,
                status, type, QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map) throws Exception {
        String search = map.get(Constants.SEARCH);
        String supplier = StringUtil.getInfo(search, "supplier");
        String organ = StringUtil.getInfo(search, "organ");
        String beginTime = StringUtil.getInfo(search, "beginTime");
        String endTime = StringUtil.getInfo(search, "endTime");
        String number = StringUtil.getInfo(search, "number");
        String invoiceNumber = StringUtil.getInfo(search, "invoiceNumber");
        String status = StringUtil.getInfo(search, "status");
        String type = StringUtil.getInfo(search, "type");
        return supermarketDocumentService.counts(supplier, organ, beginTime, endTime, number, invoiceNumber, status, type);
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
        return supermarketDocumentService.deleteSupermarketDocument(id, request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request) throws Exception {
        return supermarketDocumentService.batchDeleteSupermarketDocument(ids, request);
    }

    @Override
    public int checkIsNameExist(Long id, String name) throws Exception {
        return 0;
    }
}
