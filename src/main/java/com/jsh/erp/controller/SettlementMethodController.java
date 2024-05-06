package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.dto.MeasurementDTO;
import com.jsh.erp.datasource.dto.SettlementMethodDTO;
import com.jsh.erp.datasource.entities.Measurement;
import com.jsh.erp.datasource.entities.SecondSettlementMethod;
import com.jsh.erp.datasource.entities.SettlementMethod;
import com.jsh.erp.datasource.entities.Supplier;
import com.jsh.erp.datasource.vo.SecondSettlementMethodVo;
import com.jsh.erp.datasource.vo.SettlementMethodVo;
import com.jsh.erp.service.secondSettlementMethod.SecondSettlementMethodService;
import com.jsh.erp.service.settlementMethod.SettlementMethodService;
import com.jsh.erp.utils.BaseResponseInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/settlementMethod")
@Api(tags = {"一级结算方式管理"})
public class SettlementMethodController {
    private Logger logger = LoggerFactory.getLogger(SettlementMethodController.class);

    @Resource
    private SettlementMethodService settlementMethodService;

    @Resource
    private SecondSettlementMethodService secondSettlementMethodService;

    @GetMapping(value = "/getAllList")
    @ApiOperation(value = "查询全部一二级结算方式信息")
    public BaseResponseInfo getAllList(HttpServletRequest request) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        List<SettlementMethodVo> settlementMethodVoList = new ArrayList<>();
        try {
            List<SettlementMethod> list = settlementMethodService.getSettlementMethod();//获取一级结算方式
            if (list != null) {
                for (SettlementMethod settlementMethod : list) {
                    SettlementMethodVo settlementMethodVo = new SettlementMethodVo();
                    BeanUtils.copyProperties(settlementMethod, settlementMethodVo);

                    List<SecondSettlementMethod> secondList = secondSettlementMethodService.findListBySettlementMethodId(settlementMethod.getId());
                    List<SecondSettlementMethodVo> secondArray = new ArrayList<>();
                    if (secondList != null) {
                        for (SecondSettlementMethod secondSettlementMethod : secondList) {
                            SecondSettlementMethodVo secondSettlementMethodVo = new SecondSettlementMethodVo();
                            BeanUtils.copyProperties(secondSettlementMethod, secondSettlementMethodVo);
                            secondArray.add(secondSettlementMethodVo);
                        }
                    }
                    settlementMethodVo.setSecondSettlementMethod(secondArray);
                    settlementMethodVoList.add(settlementMethodVo);
                }
            }
            res.code = 200;
            res.data = settlementMethodVoList;
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = "获取数据失败";
        }
        return res;
    }

    /**
     * 查找结算类型-下拉框
     *
     * @param request
     * @return
     */
    @GetMapping(value = "/findBySelect")
    @ApiOperation(value = "查找结算类型")
    public JSONArray findBySelect(HttpServletRequest request) throws Exception {
        JSONArray arr = new JSONArray();
        try {
            List<SettlementMethod> settlementMethodList = settlementMethodService.findBySelectSup();
            JSONArray dataArray = new JSONArray();
            if (null != settlementMethodList) {
                for (SettlementMethod settlementMethod : settlementMethodList) {
                    JSONObject item = new JSONObject();
                    item.put("id", settlementMethod.getId());
                    //结算方式名称
                    item.put("name", settlementMethod.getSettlement());
                    dataArray.add(item);
                }
            }
            arr = dataArray;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }

    /**
     * 添加一级结算方式
     *
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/addSettlementMethod")
    @ApiOperation(value = "添加一级结算方式")
    public Object addSettlementMethod(@RequestBody SettlementMethodDTO dto, HttpServletRequest request) throws Exception {
        JSONObject result = ExceptionConstants.standardSuccess();
        List<SettlementMethod> settlementMethodList = dto.getSettlementMethod();
        String deleteId = dto.getDeleteId();
        settlementMethodService.addSettlementMethod(settlementMethodList, deleteId, request);
        return result;
    }
}
