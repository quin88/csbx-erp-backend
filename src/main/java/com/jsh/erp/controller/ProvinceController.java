package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.datasource.dto.ProvinceDTO;
import com.jsh.erp.datasource.entities.Province;
import com.jsh.erp.datasource.mappers.ProvinceMapperEx;
import com.jsh.erp.service.province.ProvinceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/province")
@Api(tags = {"省管理"})
public class ProvinceController {
    @Resource
    private ProvinceService provinceService;
    @Resource
    private ProvinceMapperEx provinceMapperEx;

    /**
     * 查找省信息-下拉框
     *
     * @param request
     * @return
     */
    @PostMapping(value = "/getProvinceByCountryId")
    @ApiOperation(value = "查找省信息")
    public JSONArray getProvinceByCountryId(@RequestParam("countryId") Long countryId, HttpServletRequest request) throws Exception {
        JSONArray arr = new JSONArray();
        try {
            List<Province> provinceList = provinceService.getProvinceByCountryId(countryId);
            JSONArray dataArray = new JSONArray();
            if (null != provinceList) {
                for (Province province : provinceList) {
                    JSONObject item = new JSONObject();
                    item.put("id", province.getId());
                    item.put("province", province.getProvinceName());
                    item.put("number", province.getProvinceNumber());
                    dataArray.add(item);
                }
            }
            arr = dataArray;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }

    @GetMapping(value = "/getProvinceTree")
    @ApiOperation(value = "获取产地树")
    public List<ProvinceDTO> getProvinceTree(HttpServletRequest request) throws Exception {
        List<ProvinceDTO> provinceDTOS = null;
        try {
            provinceDTOS = provinceMapperEx.selectAllCountiesInTree();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return provinceDTOS;
    }
}
