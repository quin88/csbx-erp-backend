package com.jsh.erp.service.signature;

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

@Service(value = "signature_component")
@SignatureResource
public class SignatureComponent implements ICommonQuery {
    @Resource
    private SignatureService signatureService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return signatureService.getSignature(id);
    }

    @Override
    public List<?> select(Map<String, String> map) throws Exception {
        return getSignatureList(map);
    }

    private List<?> getSignatureList(Map<String, String> map) {
        String search = map.get(Constants.SEARCH);
        String role = StringUtil.getInfo(search, "role");
        String name = StringUtil.getInfo(search, "name");
        return signatureService.select(role, name, QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map) throws Exception {
        String search = map.get(Constants.SEARCH);
        String role = StringUtil.getInfo(search, "role");
        String name = StringUtil.getInfo(search, "name");
        return signatureService.countSignature(role, name);
    }

    @Override
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception {
        return signatureService.insertSignature(obj, request);
    }

    @Override
    public int update(JSONObject obj, HttpServletRequest request) throws Exception {
        return signatureService.updateSignature(obj, request);
    }

    @Override
    public int delete(Long id, HttpServletRequest request) throws Exception {
        return signatureService.deleteSignature(id, request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request) throws Exception {
        return signatureService.batchDeleteSignature(ids, request);
    }

    @Override
    public int checkIsNameExist(Long id, String name) throws Exception {
        return 0;
    }
}
