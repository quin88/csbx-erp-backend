package com.jsh.erp.service.feesSettlement;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.service.ICommonQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service(value = "feesSettlement_component")
@FeesSettlementResource
public class FeesSettlementComponent implements ICommonQuery {

    @Resource
    private FeesSettlementService feesSettlementService;
    /**
     * @param id 资源id
     * @return
     * @throws Exception
     */
    @Override
    public Object selectOne(Long id) throws Exception {
        return feesSettlementService.getFeesSettlement(id);
    }

    /**
     * @param parameterMap 查询参数
     * @return
     * @throws Exception
     */
    @Override
    public List<?> select(Map<String, String> parameterMap) throws Exception {
        return null;
    }

    /**
     * @param parameterMap 查询参数
     * @return
     * @throws Exception
     */
    @Override
    public Long counts(Map<String, String> parameterMap) throws Exception {
        return null;
    }

    /**
     * @param obj
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception {
        return feesSettlementService.insertFeesSettlement(obj,request);
    }

    /**
     * @param obj
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public int update(JSONObject obj, HttpServletRequest request) throws Exception {
        return feesSettlementService.updateFeesSettlement(obj,request);
    }

    /**
     * @param id
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public int delete(Long id, HttpServletRequest request) throws Exception {
        return feesSettlementService.deleteFeesSettlement(id,request);
    }

    /**
     * @param ids
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public int deleteBatch(String ids, HttpServletRequest request) throws Exception {
        return feesSettlementService.batchDeleteFeesSettlement(ids,request);
    }

    /**
     * @param id
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public int checkIsNameExist(Long id, String name) throws Exception {
        return 0;
    }
}
