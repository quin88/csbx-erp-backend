package com.jsh.erp.service.valueAddedServe;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.ValueAddedServeMapper;
import com.jsh.erp.datasource.mappers.ValueAddedServeMapperEx;
import com.jsh.erp.datasource.vo.ValueAddedServeVo;
import com.jsh.erp.exception.BusinessRunTimeException;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.log.LogService;
import com.jsh.erp.service.supermarketServeClient.SupermarketServeClientService;
import com.jsh.erp.service.user.UserService;
import com.jsh.erp.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class ValueAddedServeService {
    private Logger logger = LoggerFactory.getLogger(SupermarketServeClientService.class);

    @Resource
    private ValueAddedServeMapper valueAddedServeMapper;
    @Resource
    private ValueAddedServeMapperEx valueAddedServeMapperEx;
    @Resource
    private UserService userService;
    @Resource
    private LogService logService;

    public ValueAddedServe selectOne(Long id) {
        ValueAddedServe result = null;
        try {
            result = valueAddedServeMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    public List<ValueAddedServeVo> select(Long serveTypeId, String title, String enabledFlag, int offset, int rows) {
        List<ValueAddedServeVo> list = null;
        try {
            list = valueAddedServeMapperEx.selectByCondition(serveTypeId, title, enabledFlag, offset, rows);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public Long counts(Long serveTypeId, String title, String enabledFlag) {
        Long result = null;
        try {
            result = valueAddedServeMapperEx.countByCondition(serveTypeId, title, enabledFlag);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception {
        ValueAddedServe valueAddedServe = JSONObject.parseObject(obj.toJSONString(), ValueAddedServe.class);
        int result = 0;
        User userInfo = userService.getCurrentUser();
        try {
            valueAddedServe.setEnabled(false);//默认禁用
            valueAddedServe.setCreator(userInfo.getId());
            valueAddedServe.setCreateTime(new Date());
            valueAddedServe.setUpdater(userInfo.getId());
            valueAddedServe.setUpdateTime(new Date());
            result = valueAddedServeMapper.insertSelective(valueAddedServe);
            logService.insertLog("增值服务",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ADD).append(valueAddedServe.getId()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int update(JSONObject obj, HttpServletRequest request) throws Exception {
        ValueAddedServe valueAddedServe = JSONObject.parseObject(obj.toJSONString(), ValueAddedServe.class);
        int result = 0;
        User userInfo = userService.getCurrentUser();
        try {
            valueAddedServe.setUpdater(userInfo.getId());
            valueAddedServe.setUpdateTime(new Date());
            result = valueAddedServeMapper.updateByPrimaryKeySelective(valueAddedServe);
            logService.insertLog("增值服务",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(valueAddedServe.getId()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    public int delete(Long id, HttpServletRequest request) throws Exception {
        return batchDeleteByIds(id.toString());
    }

    public int deleteBatch(String ids, HttpServletRequest request) throws Exception {
        return batchDeleteByIds(ids);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteByIds(String ids) throws Exception {
        String[] idArray = ids.split(",");
        User userInfo = userService.getCurrentUser();
        int result = 0;
        //只有禁用的增值服务可以删除
        Long res = valueAddedServeMapperEx.countIsActive(idArray);//查询这些数据中是否有启用的数据
        if (res > 0) {
            throw new BusinessRunTimeException(ExceptionConstants.DELETE_ACTIVE_VALUE_ADDED_FAILED_CODE, String.format(ExceptionConstants.DELETE_ACTIVE_VALUE_ADDED_FAILED_MSG));
        }

        try {
            result = valueAddedServeMapperEx.batchDeleteByIds(new Date(), userInfo == null ? null : userInfo.getId(), idArray);
            //记录日志
            StringBuffer sb = new StringBuffer();
            sb.append(BusinessConstants.LOG_OPERATION_TYPE_DELETE);
            logService.insertLog("增值服务", sb.toString(),
                    ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchSetActive(Boolean enabled, String ids) throws Exception {
        List<Long> valueAddServeIds = StringUtil.strToLongList(ids);
        ValueAddedServe valueAddedServe = new ValueAddedServe();
        valueAddedServe.setEnabled(enabled);
        ValueAddedServeExample example = new ValueAddedServeExample();
        example.createCriteria().andIdIn(valueAddServeIds);
        int result = 0;
        try {
            result = valueAddedServeMapper.updateByExampleSelective(valueAddedServe, example);
            logService.insertLog("增值服务",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ENABLED).append(ids).toString(),
                    ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }
}