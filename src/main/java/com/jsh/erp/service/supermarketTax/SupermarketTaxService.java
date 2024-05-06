package com.jsh.erp.service.supermarketTax;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.*;
import com.jsh.erp.datasource.vo.*;
import com.jsh.erp.exception.BusinessRunTimeException;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.log.LogService;
import com.jsh.erp.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
public class SupermarketTaxService {
    private Logger logger = LoggerFactory.getLogger(SupermarketTaxService.class);

    @Resource
    private SupermarketTaxMapper supermarketTaxMapper;

    @Resource
    private SupermarketTaxMapperEx supermarketTaxMapperEx;

    @Resource
    private UserService userService;

    @Resource
    private LogService logService;


    public SupermarketTax selectOne(Long id) {
        SupermarketTax result = null;
        try {
            result = supermarketTaxMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    public List<SupermarketTaxVo> select(int offset, int rows) {
        List<SupermarketTaxVo> list = null;
        try {
            list = supermarketTaxMapperEx.selectByConditionSupermarketTax(offset, rows);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public Long counts() {
        Long result = null;
        try {
            result = supermarketTaxMapperEx.countSupermarketSystemTax();
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception {
        SupermarketTax tax = JSONObject.parseObject(obj.toJSONString(), SupermarketTax.class);
        int result = 0;
        User userInfo = userService.getCurrentUser();
        try {
            result = supermarketTaxMapper.insertSelective(tax);
            logService.insertLog("商超税率",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ADD).append(tax.getTax()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int update(JSONObject obj, HttpServletRequest request) throws Exception {
        SupermarketTax tax = JSONObject.parseObject(obj.toJSONString(), SupermarketTax.class);
        int result = 0;
        User userInfo = userService.getCurrentUser();
        try {
            result = supermarketTaxMapper.updateByPrimaryKeySelective(tax);
            logService.insertLog("商超税率",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(tax.getTax()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    public int delete(Long id, HttpServletRequest request) throws Exception {
        return batchDeleteSystemTaxByIds(id.toString());
    }

    public int deleteBatch(String ids, HttpServletRequest request) throws Exception {
        return batchDeleteSystemTaxByIds(ids);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteSystemTaxByIds(String ids) throws Exception {
        String[] idArray = ids.split(",");
        User userInfo = userService.getCurrentUser();
        int result = 0;
        try {
            result = supermarketTaxMapperEx.batchDeleteSystemTaxByIds(idArray);
            //记录日志
            StringBuffer sb = new StringBuffer();
            sb.append(BusinessConstants.LOG_OPERATION_TYPE_DELETE);
            logService.insertLog("商超税率", sb.toString(),
                    ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    // 在service层
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int addSupermarketTax(List<SupermarketTax> supermarketTaxes, String deleteId, HttpServletRequest request) throws Exception {
        int result = 0;
        User userInfo = userService.getCurrentUser();
        for (SupermarketTax supermarketTax : supermarketTaxes) {
            if (supermarketTax.getId() == null) {//新增
                //每个服务商只能有一个税率
                SupermarketTaxExample example = new SupermarketTaxExample();
                example.createCriteria().andServeClientIdEqualTo(supermarketTax.getServeClientId())
                        .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
                List<SupermarketTax> supermarketTaxList = supermarketTaxMapper.selectByExample(example);
                if (!supermarketTaxList.isEmpty()) {
                    throw new BusinessRunTimeException(ExceptionConstants.SUPERMARKET_TAX_EXIST_CODE,
                            String.format(ExceptionConstants.SUPERMARKET_TAX_EXIST_MSG));
                }
                result = supermarketTaxMapper.insertSelective(supermarketTax);
            } else {//编辑
                result = supermarketTaxMapper.updateByPrimaryKeySelective(supermarketTax);
            }
            logService.insertLog("商超税率",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(supermarketTax.getTax()).toString(), request);
        }
        //删除
        if (deleteId != null && !deleteId.isEmpty()) {
            batchDeleteSystemTaxByIds(deleteId);
        }
        logService.insertLog("商超税率",
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_DELETE).append(deleteId).toString(), request);
        return result;
    }
}
