package com.jsh.erp.service.produceBom;

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

@Service(value = "produceBom")
@ProduceBomResource
public class ProduceBomComponent implements ICommonQuery {

    @Resource
    private ProduceBomService produceBomService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return null;
    }

    @Override
    public List<?> select(Map<String, String> map) throws Exception {
        String search = map.get(Constants.SEARCH);
        String produceBomParam = StringUtil.getInfo(search, "produceBomParam");
        return produceBomService.getProduceBomList(produceBomParam, QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map) throws Exception {
        String search = map.get(Constants.SEARCH);
        String produceBomParam = StringUtil.getInfo(search, "produceBomParam");
        return produceBomService.countProduceBomList(produceBomParam);
    }

    @Override
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception {
        return produceBomService.insertProduceBom(obj, request);
    }

    @Override
    public int update(JSONObject obj, HttpServletRequest request) throws Exception {
        return produceBomService.updateProduceBom(obj, request);
    }

    @Override
    public int delete(Long id, HttpServletRequest request) throws Exception {
        return produceBomService.deleteProduceBom(id, request);

    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request) throws Exception {
        return produceBomService.batchDeleteProduceBom(ids, request);
    }

    @Override
    public int checkIsNameExist(Long id, String name) throws Exception {
        return 0;
    }
}
