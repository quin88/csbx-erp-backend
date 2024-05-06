package com.jsh.erp.service.smallDepot;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.DepotItemMapperEx;
import com.jsh.erp.datasource.mappers.SmallDepotMapper;
import com.jsh.erp.datasource.mappers.SmallDepotMapperEx;
import com.jsh.erp.datasource.vo.SupermarketFinanceVo;
import com.jsh.erp.exception.BusinessRunTimeException;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.log.LogService;
import com.jsh.erp.service.user.UserService;
import com.jsh.erp.utils.StringUtil;
import com.jsh.erp.utils.Tools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SmallDepotService {
    private Logger logger = LoggerFactory.getLogger(SmallDepotService.class);
    @Resource
    private LogService logService;
    @Resource
    private SmallDepotMapper smallDepotMapper;
    @Resource
    private SmallDepotMapperEx smallDepotMapperEx;
    @Resource
    private UserService userService;
    @Resource
    private DepotItemMapperEx depotItemMapperEx;

    public SmallDepot selectOne(Long id) {
        SmallDepot result = null;
        try {
            result = smallDepotMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    public List<?> search(Long depotId, String enabledFlag, int offset, int rows) {
        List<SmallDepot> list = null;
        try {
            list = smallDepotMapperEx.selectSmallDepot(depotId, enabledFlag, offset, rows);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;

    }

    public Long counts(Long depotId, String enabledFlag) {
        Long list = null;

        try {
            list = smallDepotMapperEx.countSmallDepot(depotId, enabledFlag);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception {
        SmallDepot smallDepot = JSONObject.parseObject(obj.toJSONString(), SmallDepot.class);
        int result = 0;
        User userInfo = userService.getCurrentUser();
        try {
            smallDepot.setEnabled(false);//默认禁用
            smallDepot.setCreator(userInfo.getId());
            smallDepot.setCreateTime(new Date());
            smallDepot.setUpdater(userInfo.getId());
            smallDepot.setUpdateTime(new Date());
            result = smallDepotMapper.insertSelective(smallDepot);
            logService.insertLog("小仓库",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ADD).append(smallDepot.getName()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int update(JSONObject obj, HttpServletRequest request) throws Exception {
        SmallDepot smallDepot = JSONObject.parseObject(obj.toJSONString(), SmallDepot.class);
        int result = 0;
        User userInfo = userService.getCurrentUser();
        try {

            smallDepot.setUpdater(userInfo.getId());
            smallDepot.setUpdateTime(new Date());
            result = smallDepotMapper.updateByPrimaryKeySelective(smallDepot);
            logService.insertLog("小仓库",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ADD).append(smallDepot.getName()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int delete(Long id, HttpServletRequest request) throws Exception {
        return batchDeleteByIds(id.toString());
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDelete(String ids, HttpServletRequest request) throws Exception {
        return batchDeleteByIds(ids);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteByIds(String ids) throws Exception {
        int result = 0;
        List<Long> sdIds = StringUtil.strToLongList(ids);
        //todo 需要校验是否有挂钩商品
        Long userId = userService.getCurrentUser().getId();
        //执行删除操作
        SmallDepot smallDepot = new SmallDepot();
        smallDepot.setDeleteFlag(BusinessConstants.DELETE_FLAG_DELETED);
        smallDepot.setUpdater(userId);
        smallDepot.setUpdateTime(new Date());
        SmallDepotExample example = new SmallDepotExample();
        example.createCriteria().andIdIn(sdIds);
        try {
            result = smallDepotMapper.updateByExampleSelective(smallDepot, example);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchSetActive(Boolean enabled, String ids) throws Exception {
        List<Long> sdIds = StringUtil.strToLongList(ids);
        SmallDepot smallDepot = new SmallDepot();
        smallDepot.setEnabled(enabled);
        SmallDepotExample example = new SmallDepotExample();
        example.createCriteria().andIdIn(sdIds);
        int result = 0;
        try {
            result = smallDepotMapper.updateByExampleSelective(smallDepot, example);
            logService.insertLog("增值服务",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ENABLED).append(ids).toString(),
                    ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }
}