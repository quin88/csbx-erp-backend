package com.jsh.erp.controller;

import com.jsh.erp.exception.BusinessRunTimeException;
import com.jsh.erp.service.sequence.SequenceService;
import com.jsh.erp.utils.BaseResponseInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/sequence")
@Api(tags = {"单据编号"})
public class SequenceController {
    private Logger logger = LoggerFactory.getLogger(SequenceController.class);

    @Resource
    private SequenceService sequenceService;

    /**
     * 单据编号生成接口
     *
     * @param request
     * @return
     */
    @GetMapping(value = "/buildNumber")
    @ApiOperation(value = "单据编号生成接口")
    public BaseResponseInfo buildNumber(HttpServletRequest request) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            String number = sequenceService.buildOnlyNumber();
            map.put("defaultNumber", number);
            res.code = 200;
            res.data = map;
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = "获取数据失败";
        }
        return res;
    }

    /**
     * 市场编号查询接口
     *
     * @param request
     * @return
     */
    @GetMapping(value = "/getMarketNumber")
    @ApiOperation(value = "市场编号查询接口")
    public BaseResponseInfo getMarketNumber(HttpServletRequest request) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            String number = sequenceService.getMarketNumber();
            map.put("number", number);
            res.code = 200;
            res.data = map;
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = e.getMessage();
        }
        return res;
    }

    /**
     * 商超供应商编码生成接口
     *
     * @param request
     * @return
     */
    @GetMapping(value = "/buildSupplierNumber")
    @ApiOperation(value = "商超供应商编码生成接口")
    public BaseResponseInfo buildSupplierNumber(HttpServletRequest request) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            String number = sequenceService.buildSupplierNumber();
            map.put("defaultNumber", number);
            res.code = 200;
            res.data = map;
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = e.getMessage();
        }
        return res;
    }

    /**
     * 区县镇编号查询接口
     *
     * @param request
     * @return
     */
    @GetMapping(value = "/getCountyNumber")
    @ApiOperation(value = "区县镇编号查询接口")
    public BaseResponseInfo getCountyNumber(HttpServletRequest request) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            String number = sequenceService.getCountyNumber();
            map.put("number", number);
            res.code = 200;
            res.data = map;
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = e.getMessage();
        }
        return res;
    }

    /**
     * 商超出入库编码接口
     * @param request
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/getSupermarketDocumentNumber")
    @ApiOperation(value = "商超出入库编码接口")
    public BaseResponseInfo getSupermarketDocumentNumber(HttpServletRequest request) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            String number = sequenceService.getSupermarketDocumentNumber();
            map.put("number", number);
            res.code = 200;
            res.data = map;
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = e.getMessage();
        }
        return res;
    }

    @GetMapping(value = "/buildMaterialNumber")
    @ApiOperation(value = "商品编号生成接口")
    public BaseResponseInfo buildMaterialNumber(HttpServletRequest request) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            String number = sequenceService.buildMaterialNumber();
            map.put("defaultNumber", number);
            res.code = 200;
            res.data = map;
        }catch (BusinessRunTimeException e){
            res.code=e.getCode();
            res.data=e.getData().get("message");
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = "获取数据失败";
        }
        return res;
    }
}
