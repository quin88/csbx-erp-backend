package com.jsh.erp.service.supermarketServeClient;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.datasource.entities.SupermarketServeClient;
import com.jsh.erp.datasource.vo.SupermarketServeClientVo;
import com.jsh.erp.service.ICommonQuery;
import com.jsh.erp.utils.Constants;
import com.jsh.erp.utils.QueryUtils;
import com.jsh.erp.utils.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service(value = "supermarketServeClient_component")
@SupermarketServeClientResource
public class SupermarketServeClientComponent implements ICommonQuery {
    @Resource
    private SupermarketServeClientService supermarketServeClientService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return supermarketServeClientService.selectOne(id);
    }

    @Override
    public List<?> select(Map<String, String> map) throws Exception {
        return getSupermarketServeClientList(map);
    }

    private List<?> getSupermarketServeClientList(Map<String, String> map) {
        String search = map.get(Constants.SEARCH);
        JSONArray dataArray = new JSONArray();
        try {
            List<SupermarketServeClientVo> result = supermarketServeClientService.select( QueryUtils.offset(map), QueryUtils.rows(map));
            if (result != null) {
                for (SupermarketServeClientVo supermarketServeClient : result) {
                    JSONObject client = new JSONObject();
                    client.put("id", supermarketServeClient.getId());
                    client.put("name", supermarketServeClient.getName());
                    client.put("tenantName", supermarketServeClient.getTenantName());

                    dataArray.add(client);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataArray;
    }

    @Override
    public Long counts(Map<String, String> map) throws Exception {
        String search = map.get(Constants.SEARCH);
        return supermarketServeClientService.counts();
    }

    @Override
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception {
        return supermarketServeClientService.insert(obj,request);
    }

    @Override
    public int update(JSONObject obj, HttpServletRequest request) throws Exception {
        return supermarketServeClientService.update(obj,request);
    }

    @Override
    public int delete(Long id, HttpServletRequest request) throws Exception {
        return supermarketServeClientService.delete(id,request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request) throws Exception {
        return supermarketServeClientService.deleteBatch(ids,request);
    }

    @Override
    public int checkIsNameExist(Long id, String name) throws Exception {
        return 0;
    }
}
