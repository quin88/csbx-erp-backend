package com.jsh.erp.service.smallDepot;

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

@Service(value = "smallDepot_component")
@SmallDepotResource
public class SmallDepotComponent implements ICommonQuery {

    @Resource
    private SmallDepotService smallDepotService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return smallDepotService.selectOne(id);
    }

    @Override
    public List<?> select(Map<String, String> map) throws Exception {
        String search = map.get(Constants.SEARCH);
        Long depotId = StringUtil.parseStrLong(StringUtil.getInfo(search, "depotId"));//仓库ID
        String enabledFlag = StringUtil.getInfo(search, "enabledFlag");
        return smallDepotService.search(depotId, enabledFlag, QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map) throws Exception {
        String search = map.get(Constants.SEARCH);
        Long depotId = StringUtil.parseStrLong(StringUtil.getInfo(search, "depotId"));//仓库ID
        String enabledFlag = StringUtil.getInfo(search, "enabledFlag");
        return smallDepotService.counts(depotId, enabledFlag);
    }

    @Override
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception {
        return smallDepotService.insert(obj, request);
    }

    @Override
    public int update(JSONObject obj, HttpServletRequest request) throws Exception {
        return smallDepotService.update(obj,request);
    }

    @Override
    public int delete(Long id, HttpServletRequest request) throws Exception {
        return smallDepotService.delete(id, request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request) throws Exception {
        return smallDepotService.batchDelete(ids, request);
    }

    @Override
    public int checkIsNameExist(Long id, String name) throws Exception {
        return 0;
    }
}
