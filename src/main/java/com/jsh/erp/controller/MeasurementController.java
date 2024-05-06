package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.dto.MeasurementDTO;
import com.jsh.erp.datasource.entities.Measurement;
import com.jsh.erp.service.measurement.MeasurementService;
import com.jsh.erp.utils.BaseResponseInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/measurement")
@Api(tags = {"一级财务计量管理"})
public class MeasurementController {
    @Resource
    private MeasurementService measurementService;

    /**
     * 获取所有的一级财务计量方式-下拉框
     *
     * @param request
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/getAllList")
    @ApiOperation(value = "获取所有的一级财务计量方式")
    public BaseResponseInfo getAllList(HttpServletRequest request) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        JSONArray array = new JSONArray();
        try {
            List<Measurement> list = measurementService.getMeasurement();
            if (list != null) {
                for (Measurement measurement : list) {
                    JSONObject item = new JSONObject();
                    item.put("id", measurement.getId());
                    item.put("measurementUnit", measurement.getMeasurementUnit());
                    array.add(item);
                }
            }
            res.code = 200;
            res.data = array;
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = "获取数据失败";
        }
        return res;
    }

    /**
     * 添加一级财务计量方式
     *
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping (value = "/addMeasurement")
    @ApiOperation(value = "添加一级财务计量方式")
    public Object addMeasurement(@RequestBody MeasurementDTO dto, HttpServletRequest request) throws Exception {
        JSONObject result = ExceptionConstants.standardSuccess();
        List<Measurement> measurementList = dto.getMeasurements();
        String deleteId = dto.getDeleteId();
        measurementService.addMeasurement(measurementList, deleteId, request);
        return result;
    }
}
