package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.dto.SecondMeasurementDTO;
import com.jsh.erp.datasource.entities.SecondMeasurement;
import com.jsh.erp.service.secondMeasurement.SecondMeasurementService;
import com.jsh.erp.utils.BaseResponseInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping(value = "/secondMeasurement")
@Api(tags = {"二级财务计量管理"})
public class SecondMeasurementController {

    @Resource
    private SecondMeasurementService secondMeasurementService;

    @GetMapping(value = "/findByMeasurementId")
    @ApiOperation(value = "根据一级财务计量id查询所属二级")
    public BaseResponseInfo findByMeasurementId(@RequestParam(value = "measurementId", required = false) Long id, HttpServletRequest request) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        JSONArray array = new JSONArray();
        try {
            List<SecondMeasurement> list = secondMeasurementService.findByMeasurementId(id);
            if (list != null) {
                for (SecondMeasurement secondMeasurement : list) {
                    JSONObject item = new JSONObject();
                    item.put("id", secondMeasurement.getId());
                    item.put("measurementId", secondMeasurement.getMeasurementId());
                    item.put("secondSettlementUnit", secondMeasurement.getSecondMeasurementUnit());
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
     * 添加二级财务计量方式
     *
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/addSecondMeasurement")
    @ApiOperation(value = "添加二级财务计量方式")
    public Object addSecondMeasurement(@RequestBody SecondMeasurementDTO dto, HttpServletRequest request) throws Exception {
        JSONObject result = ExceptionConstants.standardSuccess();
        List<SecondMeasurement> secondMeasurementList = dto.getSecondMeasurementList();
        String deleteId = dto.getDeleteId();
        secondMeasurementService.addSecondMeasurement(secondMeasurementList, deleteId, request);
        return result;
    }
}
