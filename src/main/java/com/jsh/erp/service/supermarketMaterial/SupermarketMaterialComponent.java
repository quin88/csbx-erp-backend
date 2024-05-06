package com.jsh.erp.service.supermarketMaterial;

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

@Service(value = "supermarketMaterial_component")
@SupermarketMaterialResource
public class SupermarketMaterialComponent implements ICommonQuery {
    @Resource
    private SupermarketMaterialService supermarketMaterialService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return supermarketMaterialService.getSupermarketMaterial(id);
    }

    @Override
    public List<?> select(Map<String, String> map) throws Exception {
        return getSupermarketMaterialList(map);
    }

    private List<?> getSupermarketMaterialList(Map<String, String> map) {
        String search = map.get(Constants.SEARCH);
        Long supplierId = StringUtil.parseStrLong(StringUtil.getInfo(search, "supplierId"));
        Long categoryId = StringUtil.parseStrLong(StringUtil.getInfo(search, "categoryId"));
        Long secondCategoryId = StringUtil.parseStrLong(StringUtil.getInfo(search, "secondCategoryId"));
        Long thirdCategoryId = StringUtil.parseStrLong(StringUtil.getInfo(search, "thirdCategoryId"));
        String materialParam = StringUtil.getInfo(search, "materialParam");
        String temperatureCondition = StringUtil.getInfo(search, "temperatureCondition");
        String aquaticType = StringUtil.getInfo(search, "aquaticType");
        String status = StringUtil.getInfo(search, "status");
        return supermarketMaterialService.select(supplierId, categoryId, secondCategoryId, thirdCategoryId, materialParam,
                temperatureCondition, aquaticType, status, QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map) throws Exception {
        String search = map.get(Constants.SEARCH);
        Long supplierId = StringUtil.parseStrLong(StringUtil.getInfo(search, "supplierId"));
        Long categoryId = StringUtil.parseStrLong(StringUtil.getInfo(search, "categoryId"));
        Long secondCategoryId = StringUtil.parseStrLong(StringUtil.getInfo(search, "secondCategoryId"));
        Long thirdCategoryId = StringUtil.parseStrLong(StringUtil.getInfo(search, "thirdCategoryId"));
        String materialParam = StringUtil.getInfo(search, "materialParam");
        String temperatureCondition = StringUtil.getInfo(search, "temperatureCondition");
        String aquaticType = StringUtil.getInfo(search, "aquaticType");
        String status = StringUtil.getInfo(search, "status");
        return supermarketMaterialService.countSupermarketMaterial(supplierId, categoryId, secondCategoryId, thirdCategoryId, materialParam,
                temperatureCondition, aquaticType, status);
    }

    @Override
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception {
        return supermarketMaterialService.insertSupermarketMaterial(obj, request);
    }

    @Override
    public int update(JSONObject obj, HttpServletRequest request) throws Exception {
        return supermarketMaterialService.updateSupermarketMaterial(obj, request);

    }

    @Override
    public int delete(Long id, HttpServletRequest request) throws Exception {
        return supermarketMaterialService.deleteSupermarketMaterial(id, request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request) throws Exception {
        return supermarketMaterialService.batchDeleteSupermarketMaterial(ids, request);
    }

    @Override
    public int checkIsNameExist(Long id, String name) throws Exception {
        return 0;
    }
}
