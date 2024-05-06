package com.jsh.erp.service.priceReceipts;

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

@Service(value = "priceReceipts_component")
@PriceReceiptsResource
public class PriceReceiptsComponent implements ICommonQuery {

    @Resource
    private PriceReceiptsService priceReceiptsService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return priceReceiptsService.getPriceReceipts(id);
    }

    @Override
    public List<?> select(Map<String, String> map) throws Exception {
        String search = map.get(Constants.SEARCH);
        String supplierId = StringUtil.getInfo(search, "supplier");
        String priceType = StringUtil.getInfo(search, "priceType");
        String beginTime = StringUtil.getInfo(search, "beginTime");
        String endTime = StringUtil.getInfo(search, "endTime");
        String status = StringUtil.getInfo(search, "status");
        return priceReceiptsService.select(supplierId, priceType, beginTime, endTime, status, QueryUtils.offset(map), QueryUtils.rows(map));
    }


    @Override
    public Long counts(Map<String, String> map) throws Exception {
        String search = map.get(Constants.SEARCH);
        String supplier = StringUtil.getInfo(search, "supplier");
        String priceType = StringUtil.getInfo(search, "priceType");
        String beginTime = StringUtil.getInfo(search, "beginTime");
        String endTime = StringUtil.getInfo(search, "endTime");
        String status = StringUtil.getInfo(search, "status");
        return priceReceiptsService.counts(supplier, priceType, beginTime, endTime, status);
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
        return priceReceiptsService.deleteByIds(id, request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request) throws Exception {
        return priceReceiptsService.deleteBatchByIds(ids, request);
    }

    @Override
    public int checkIsNameExist(Long id, String name) throws Exception {
        return 0;
    }

}
