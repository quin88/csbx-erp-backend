package com.jsh.erp.service.paymentConfig;

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

@Service(value = "paymentConfig_component")
@PaymentConfigResource
public class PaymentConfigComponent implements ICommonQuery {
    @Resource
    private PaymentConfigService paymentConfigService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return paymentConfigService.selectOne(id);
    }

    @Override
    public List<?> select(Map<String, String> map) throws Exception {
        return getSupermarketTaxList(map);
    }

    private List<?> getSupermarketTaxList(Map<String, String> map) {
        String search = map.get(Constants.SEARCH);
        Long maId = StringUtil.parseStrLong(StringUtil.getInfo(search, "marketAddressId"));
        Long atId = StringUtil.parseStrLong(StringUtil.getInfo(search, "aquaticTypeId"));
        return paymentConfigService.select(maId, atId, QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map) throws Exception {
        String search = map.get(Constants.SEARCH);
        Long maId = StringUtil.parseStrLong(StringUtil.getInfo(search, "marketAddressId"));
        Long atId = StringUtil.parseStrLong(StringUtil.getInfo(search, "aquaticTypeId"));
        return paymentConfigService.counts(maId,atId);
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
        return paymentConfigService.delete(id, request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request) throws Exception {
        return paymentConfigService.deleteBatch(ids, request);
    }

    @Override
    public int checkIsNameExist(Long id, String name) throws Exception {
        return 0;
    }
}
