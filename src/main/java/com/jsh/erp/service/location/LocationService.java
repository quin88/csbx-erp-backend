package com.jsh.erp.service.location;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.entities.Location;
import com.jsh.erp.datasource.entities.LocationExample;
import com.jsh.erp.datasource.entities.User;
import com.jsh.erp.datasource.mappers.LocationMapper;
import com.jsh.erp.datasource.mappers.LocationMapperEx;
import com.jsh.erp.datasource.vo.LocationVo;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.log.LogService;
import com.jsh.erp.service.user.UserService;
import com.jsh.erp.utils.StringUtil;
import liquibase.pro.packaged.L;
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
public class LocationService {
    private Logger logger = LoggerFactory.getLogger(LocationService.class);
    @Resource
    private LogService logService;
    @Resource
    private LocationMapper locationMapper;
    @Resource
    private LocationMapperEx locationMapperEx;
    @Resource
    private UserService userService;

    public Location selectOne(Long id) {
        Location result = null;
        try {
            result = locationMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    public List<?> search(Long depotId, Long smallDepotId, String enabledFlag, int offset, int rows) {
        List<LocationVo> list = null;
        try {
            list = locationMapperEx.selectLocation(depotId, smallDepotId, enabledFlag, offset, rows);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public Long counts(Long depotId, Long smallDepotId, String enabledFlag) {
        Long list = null;
        try {
            list = locationMapperEx.countLocation(depotId, smallDepotId, enabledFlag);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception {
        Location location = JSONObject.parseObject(obj.toJSONString(), Location.class);
        int result = 0;
        User userInfo = userService.getCurrentUser();
        try {
            location.setEnabled(false);//默认禁用
            location.setCreator(userInfo.getId());
            location.setCreateTime(new Date());
            location.setUpdater(userInfo.getId());
            location.setUpdateTime(new Date());
            result = locationMapper.insertSelective(location);
            logService.insertLog("区位",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ADD).append(location.getName()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int update(JSONObject obj, HttpServletRequest request) throws Exception {
        Location location = JSONObject.parseObject(obj.toJSONString(), Location.class);
        int result = 0;
        User userInfo = userService.getCurrentUser();
        try {
            location.setUpdater(userInfo.getId());
            location.setUpdateTime(new Date());
            result = locationMapper.updateByPrimaryKeySelective(location);
            logService.insertLog("区位",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ADD).append(location.getName()).toString(), request);
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
        List<Long> loIds = StringUtil.strToLongList(ids);
        Long userId = userService.getCurrentUser().getId();
        //todo 需要校验是否有挂钩商品
        //执行删除操作
        Location location = new Location();
        location.setDeleteFlag(BusinessConstants.DELETE_FLAG_DELETED);
        location.setUpdater(userId);
        location.setUpdateTime(new Date());
        LocationExample example = new LocationExample();
        example.createCriteria().andIdIn(loIds);
        try {
            result = locationMapper.updateByExampleSelective(location, example);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchSetActive(Boolean enabled, String ids) throws Exception {
        List<Long> loIds = StringUtil.strToLongList(ids);
        Location location = new Location();
        location.setEnabled(enabled);
        LocationExample example = new LocationExample();
        example.createCriteria().andIdIn(loIds);
        int result = 0;
        try {
            result = locationMapper.updateByExampleSelective(location, example);
            logService.insertLog("增值服务",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ENABLED).append(ids).toString(),
                    ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }
}