package com.jsh.erp.service.supermarketServeClient;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.*;
import com.jsh.erp.datasource.vo.SupermarketServeClientVo;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.log.LogService;
import com.jsh.erp.service.supermarketTax.SupermarketTaxService;
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
import java.util.stream.Collectors;

@Service
public class SupermarketServeClientService {
    private Logger logger = LoggerFactory.getLogger(SupermarketServeClientService.class);

    @Resource
    private SupermarketServeClientMapper supermarketServeClientMapper;
    @Resource
    private SupermarketServeClientMapperEx supermarketServeClientMapperEx;
    @Resource
    private UserService userService;
    @Resource
    private LogService logService;
    @Resource
    private SupermarketTaxService supermarketTaxService;
    @Resource
    private SupermarketTaxMapperEx supermarketTaxMapperEx;

    public SupermarketServeClient selectOne(Long id) {
        SupermarketServeClient result = null;
        try {
            result = supermarketServeClientMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }


    public List<SupermarketServeClientVo> select(int offset, int rows) {
        List<SupermarketServeClientVo> list = null;
        try {
            list = supermarketServeClientMapperEx.selectSupplierServeClient(offset, rows);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public Long counts() {
        Long result = null;
        try {
            result = supermarketServeClientMapperEx.countSupplierServeClient();
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception {
        SupermarketServeClient serveClient = JSONObject.parseObject(obj.toJSONString(), SupermarketServeClient.class);
        int result = 0;
        User userInfo = userService.getCurrentUser();
        try {
            result = supermarketServeClientMapper.insertSelective(serveClient);
            logService.insertLog("商超服务商",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ADD).append(serveClient.getName()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int update(JSONObject obj, HttpServletRequest request) throws Exception {
        SupermarketServeClient serveClient = JSONObject.parseObject(obj.toJSONString(), SupermarketServeClient.class);
        int result = 0;
        User userInfo = userService.getCurrentUser();
        try {
            result = supermarketServeClientMapper.updateByPrimaryKeySelective(serveClient);
            logService.insertLog("商超服务商",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(serveClient.getName()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    public int delete(Long id, HttpServletRequest request) throws Exception {
        return batchDeleteServeClientByIds(id.toString());
    }

    public int deleteBatch(String ids, HttpServletRequest request) throws Exception {
        return batchDeleteServeClientByIds(ids);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteServeClientByIds(String ids) throws Exception {
        String[] idArray = ids.split(",");
        User userInfo = userService.getCurrentUser();
        int result = 0;
        try {
            result = supermarketServeClientMapperEx.batchDeleteServeClientByIds(idArray);
            //删除挂钩的税率
            //查询对应的服务商id
            List<Long> taxIds = supermarketTaxMapperEx.selectTaxIdById(idArray);
            String idsString = String.join(",", taxIds.stream().map(String::valueOf).collect(Collectors.toList()));
            supermarketTaxService.batchDeleteSystemTaxByIds(idsString);
            //记录日志
            StringBuffer sb = new StringBuffer();
            sb.append(BusinessConstants.LOG_OPERATION_TYPE_DELETE);
            logService.insertLog("商超服务商", sb.toString(),
                    ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int addSupermarketServeClient(List<SupermarketServeClient> serveClients, String deleteId, HttpServletRequest request) throws Exception {
        int result = 0;
        User userInfo = userService.getCurrentUser();
        try {
            for (SupermarketServeClient serveClient : serveClients) {
                if (serveClient.getId() == null) {//新增
                    result = supermarketServeClientMapper.insertSelective(serveClient);
                } else {//编辑
                    result = supermarketServeClientMapper.updateByPrimaryKeySelective(serveClient);
                }
                logService.insertLog("商超服务商",
                        new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(serveClient.getName()).toString(), request);
            }
            //删除
            if (deleteId != null && !deleteId.isEmpty()) {
                batchDeleteServeClientByIds(deleteId);
            }
            logService.insertLog("商超服务商",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_DELETE).append(deleteId).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }
}


