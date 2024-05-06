package com.jsh.erp.service.priceDetails;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.service.ICommonQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service(value = "priceDetails_component")
@PriceDetailsResource
public class PriceDetailsComponent implements ICommonQuery {

    @Resource
    private PriceDetailsService priceDetailsService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return priceDetailsService.getPriceDetails(id);
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
        return priceDetailsService.deleteById(id, request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request) throws Exception {
        return priceDetailsService.deleteBatchByIds(ids, request);
    }

    @Override
    public int checkIsNameExist(Long id, String name) throws Exception {
        return 0;
    }

}
