package com.jsh.erp.service.goodsAllocation;

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

@Service(value = "goodsAllocation_component")
@GoodsAllocationResource
public class GoodsAllocationComponent implements ICommonQuery {

    @Resource
    private GoodsAllocationService goodsAllocationService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return goodsAllocationService.getGoodsAllocation(id);
    }

    @Override
    public List<?> select(Map<String, String> map) throws Exception {
        return getGoodsAllocationList(map);
    }

    private List<?> getGoodsAllocationList(Map<String, String> map) throws Exception {
        String search = map.get(Constants.SEARCH);
        Long depotId = StringUtil.parseStrLong(StringUtil.getInfo(search, "depotId"));
        Long smallDepotId = StringUtil.parseStrLong(StringUtil.getInfo(search, "smallDepotId"));
        String number = StringUtil.getInfo(search, "number");
        String capacityStatus = StringUtil.getInfo(search, "capacityStatus");
        String enabled = StringUtil.getInfo(search, "enabled");
        String order = QueryUtils.order(map);
        return goodsAllocationService.select(depotId, smallDepotId, number, capacityStatus, enabled, QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map) throws Exception {
        String search = map.get(Constants.SEARCH);
        Long depotId = StringUtil.parseStrLong(StringUtil.getInfo(search, "depotId"));
        Long smallDepotId = StringUtil.parseStrLong(StringUtil.getInfo(search, "smallDepotId"));
        String number = StringUtil.getInfo(search, "number");
        String capacityStatus = StringUtil.getInfo(search, "capacityStatus");
        String enabled = StringUtil.getInfo(search, "enabled");
        return goodsAllocationService.counts(depotId, smallDepotId, number, capacityStatus, enabled);
    }

    @Override
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception {
        return goodsAllocationService.insert(obj, request);
    }

    @Override
    public int update(JSONObject obj, HttpServletRequest request) throws Exception {
        return goodsAllocationService.update(obj, request);
    }

    @Override
    public int delete(Long id, HttpServletRequest request) throws Exception {
        return goodsAllocationService.delete(id, request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request) throws Exception {
        return goodsAllocationService.batchDelete(ids, request);
    }

    @Override
    public int checkIsNameExist(Long id, String name) throws Exception {
        return goodsAllocationService.checkIsNameExist(id, name);
    }
}
