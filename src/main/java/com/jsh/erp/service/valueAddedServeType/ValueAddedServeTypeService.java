package com.jsh.erp.service.valueAddedServeType;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.dto.ValueAddedServeDTO;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.ValueAddedServeTypeMapper;
import com.jsh.erp.datasource.mappers.ValueAddedServeTypeMapperEx;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.log.LogService;
import com.jsh.erp.service.supermarketServeClient.SupermarketServeClientService;
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
public class ValueAddedServeTypeService {
    private Logger logger = LoggerFactory.getLogger(SupermarketServeClientService.class);

    @Resource
    private ValueAddedServeTypeMapper valueAddedServeTypeMapper;
    @Resource
    private ValueAddedServeTypeMapperEx valueAddedServeTypeMapperEx;
    @Resource
    private UserService userService;
    @Resource
    private LogService logService;

    public ValueAddedServeType selectOne(Long id) {
        ValueAddedServeType result = null;
        try {
            result = valueAddedServeTypeMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    public List<ValueAddedServeType> select() {
        List<ValueAddedServeType> list = null;
        try {
            ValueAddedServeTypeExample example = new ValueAddedServeTypeExample();
            example.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
            list = valueAddedServeTypeMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public Long counts() {
        Long result = null;
        try {
            ValueAddedServeTypeExample example = new ValueAddedServeTypeExample();
            example.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
            result = valueAddedServeTypeMapper.countByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception {
        ValueAddedServeType valueAddedServeType = JSONObject.parseObject(obj.toJSONString(), ValueAddedServeType.class);
        int result = 0;
        User userInfo = userService.getCurrentUser();
        try {
            valueAddedServeType.setCreator(userInfo.getId());
            valueAddedServeType.setCreateTime(new Date());
            valueAddedServeType.setUpdater(userInfo.getId());
            valueAddedServeType.setUpdateTime(new Date());
            result = valueAddedServeTypeMapper.insertSelective(valueAddedServeType);
            logService.insertLog("增值服务类型",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ADD).append(valueAddedServeType.getType()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int update(JSONObject obj, HttpServletRequest request) throws Exception {
        ValueAddedServeType valueAddedServeType = JSONObject.parseObject(obj.toJSONString(), ValueAddedServeType.class);
        int result = 0;
        User userInfo = userService.getCurrentUser();
        try {
            valueAddedServeType.setUpdater(userInfo.getId());
            valueAddedServeType.setUpdateTime(new Date());
            result = valueAddedServeTypeMapper.updateByPrimaryKeySelective(valueAddedServeType);
            logService.insertLog("增值服务类型",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(valueAddedServeType.getType()).toString(), request);
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
        try {
            result = valueAddedServeTypeMapperEx.batchDeleteByIds(new Date(), userInfo == null ? null : userInfo.getId(), idArray);
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
    public void addValueAddedServe(ValueAddedServeDTO valueAddedServeDTO, HttpServletRequest request) throws Exception {

        User userInfo = userService.getCurrentUser();
        List<ValueAddedServeType> body = valueAddedServeDTO.getValueAddedServeTypes();
        // 找出需要新增和更新的数据
        for (ValueAddedServeType va : body) {
            if (va.getId() != null) {//编辑
                va.setUpdater(userInfo == null ? null : userInfo.getId());
                va.setUpdateTime(new Date());
                valueAddedServeTypeMapper.updateByPrimaryKeySelective(va);
            } else {//新增
                va.setCreateTime(new Date());
                va.setCreator(userInfo == null ? null : userInfo.getId());
                va.setUpdateTime(new Date());
                va.setUpdater(userInfo == null ? null : userInfo.getId());
                valueAddedServeTypeMapper.insertSelective(va);
            }
        }
        //处理被删除数据
        batchDeleteByIds(valueAddedServeDTO.getDeleteIds());
    }

}

