package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.datasource.entities.SecondSettlementMethod;
import com.jsh.erp.datasource.vo.SecondSettlementMethodVo;
import com.jsh.erp.datasource.vo.SecondSettlementMethodVoList;
import com.jsh.erp.service.secondSettlementMethod.SecondSettlementMethodService;
import com.jsh.erp.utils.BaseResponseInfo;
import com.jsh.erp.utils.ErpInfo;
import com.jsh.erp.utils.ExcelUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.jsh.erp.utils.ResponseJsonUtil.returnJson;

@RestController
@RequestMapping("/secondSettlementMethod")
@Api(tags = {"二级结算方式管理"})
public class SecondSettlementMethodController {
    private Logger logger= LoggerFactory.getLogger(SecondSettlementMethodController.class);

    @Resource
    private SecondSettlementMethodService secondSecondSettlementMethodService;

    @GetMapping(value = "/findListBySettlementMethodId")
    @ApiOperation(value = "根据一级结算方式id查询所属二级结算方式信息")
    public BaseResponseInfo findListBySettlementMethodId(@RequestParam ("SettlementMethodId") Long id, HttpServletRequest request) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        List<SecondSettlementMethodVo> secondSettlementMethodVos = new ArrayList<>();
        try {
            List<SecondSettlementMethod> list = secondSecondSettlementMethodService.findListBySettlementMethodId(id);
            if (list != null) {
                for (SecondSettlementMethod secondSettlementMethod : list) {
                    SecondSettlementMethodVo secondSettlementMethodVo = new SecondSettlementMethodVo();
                    BeanUtils.copyProperties(secondSettlementMethod,secondSettlementMethodVo);
                    secondSettlementMethodVos.add(secondSettlementMethodVo);
                }
            }
            res.code = 200;
            res.data = secondSettlementMethodVos;
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = "获取数据失败";
        }
        return res;
    }

    /**
     * 批量设置状态-启用或者禁用
     * @param jsonObject
     * @param request
     * @return
     */
    @PostMapping(value = "/batchSetStatus")
    @ApiOperation(value = "批量设置状态")
    public String batchSetStatus(@RequestBody JSONObject jsonObject,
                                 HttpServletRequest request)throws Exception {
        String status = jsonObject.getString("status");
        String ids = jsonObject.getString("ids");
        Map<String, Object> objectMap = new HashMap<>();
        int res = secondSecondSettlementMethodService.batchSetStatus(status, ids);
        if(res > 0) {
            return returnJson(objectMap, ErpInfo.OK.name, ErpInfo.OK.code);
        } else {
            return returnJson(objectMap, ErpInfo.ERROR.name, ErpInfo.ERROR.code);
        }
    }

    /**
     * 导入费用类型
     *
     * @param file
     * @param request
     * @param response
     * @return
     */
    @PostMapping(value = "/importCostTypes")
    @ApiOperation(value = "导入费用类型")
    public BaseResponseInfo importCostTypes(MultipartFile file,
                                         HttpServletRequest request, HttpServletResponse response) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        try {
            secondSecondSettlementMethodService.importCostTypes(file, request);
            res.code = 200;
            res.data = "导入成功";
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = "导入失败";
        }
        return res;
    }

    /**
     * 生成excel表格
     *
     * @param request
     * @param response
     * @return
     */
    @GetMapping(value = "/exportExcel")
    public void exportExcel(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<SecondSettlementMethodVoList> dataList = secondSecondSettlementMethodService.findByAll();
            File file = secondSecondSettlementMethodService.exportExcel(dataList);
            ExcelUtils.downloadExcel(file, file.getName(), response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
