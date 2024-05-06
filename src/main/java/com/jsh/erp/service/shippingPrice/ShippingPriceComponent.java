package com.jsh.erp.service.shippingPrice;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.service.ICommonQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service(value = "shippingPrice_component")
@ShippingPriceResource
public class ShippingPriceComponent implements ICommonQuery {

    @Resource
    private ShippingPriceService shippingPriceService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return shippingPriceService.getShippingPrice(id);
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
