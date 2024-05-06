package com.jsh.erp.service.supermarketFinance;

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

@Service(value = "supermarketFinance_component")
@SupermarketFinanceResource
public class SupermarketFinanceComponent implements ICommonQuery {

    @Resource
    private SupermarketFinanceService supermarketFinanceService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return supermarketFinanceService.selectOne(id);
    }

    @Override
    public List<?> select(Map<String, String> map) throws Exception {
        String search = map.get(Constants.SEARCH);
        Long id = StringUtil.parseStrLong(StringUtil.getInfo(search, "id"));
        Long aquaticTypeId = StringUtil.parseStrLong(StringUtil.getInfo(search, "aquaticTypeId"));//品类ID
        Long marketId = StringUtil.parseStrLong(StringUtil.getInfo(search, "marketId"));
        String beginTime = StringUtil.getInfo(search, "beginTime");
        String endTime = StringUtil.getInfo(search, "endTime");
        String number = StringUtil.getInfo(search, "number");
        String status = StringUtil.getInfo(search, "status");
        String linkNumber = StringUtil.getInfo(search, "linkNumber");
        return supermarketFinanceService.search(id, aquaticTypeId, marketId, beginTime, endTime, number, status, linkNumber,
                QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map) throws Exception {
        String search = map.get(Constants.SEARCH);
        Long id = StringUtil.parseStrLong(StringUtil.getInfo(search, "id"));
        Long aquaticTypeId = StringUtil.parseStrLong(StringUtil.getInfo(search, "aquaticTypeId"));//品类ID
        Long marketId = StringUtil.parseStrLong(StringUtil.getInfo(search, "marketId"));
        String beginTime = StringUtil.getInfo(search, "beginTime");
        String endTime = StringUtil.getInfo(search, "endTime");
        String number = StringUtil.getInfo(search, "number");
        String status = StringUtil.getInfo(search, "status");
        String linkNumber = StringUtil.getInfo(search, "linkNumber");
        return supermarketFinanceService.counts(id, aquaticTypeId, marketId, beginTime, endTime, number, status, linkNumber);
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
        return supermarketFinanceService.delete(id, request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request) throws Exception {
        return supermarketFinanceService.batchDelete(ids, request);
    }

    @Override
    public int checkIsNameExist(Long id, String name) throws Exception {
        return 0;
    }
}
