package com.jsh.erp.service.serveProject;

import cn.hutool.core.util.BooleanUtil;
import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.ServeProjectMapper;
import com.jsh.erp.datasource.mappers.ServeProjectMapperEx;
import com.jsh.erp.datasource.mappers.SupplierExtendMapperEx;
import com.jsh.erp.datasource.mappers.SupplierServeProjectMapperEx;
import com.jsh.erp.exception.BusinessRunTimeException;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.log.LogService;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ServeProjectService {
    private Logger logger = LoggerFactory.getLogger(ServeProjectService.class);

    @Resource
    private LogService logService;

    @Resource
    private ServeProjectMapper serveProjectMapper;

    @Resource
    private ServeProjectMapperEx serveProjectMapperEx;

    @Resource
    private SupplierServeProjectMapperEx supplierServeProjectMapperEx;

    public ServeProject getServeProject(Long id) {
        ServeProject result = null;
        try {
            result = serveProjectMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    private List<ServeProject> getServeProjectListByIds(String ids) {
        List<Long> idList = StringUtil.strToLongList(ids);
        List<ServeProject> list = new ArrayList<>();
        try {
            ServeProjectExample example = new ServeProjectExample();
            example.createCriteria().andIdIn(idList);
            list = serveProjectMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<ServeProject> select(String type, String active, String projectName, int offset, int rows) {
        return serveProjectMapperEx.searchServeProject(type, active, projectName, offset, rows);
    }

    public Long count(String type, String active, String projectName) {
        return serveProjectMapperEx.countServeProject(type, active, projectName);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertServeProject(JSONObject obj, HttpServletRequest request) {
        ServeProject serveProject = JSONObject.parseObject(obj.toJSONString(), ServeProject.class);
        int result = 0;
        try {
            serveProject.setActive(false);
            result = serveProjectMapper.insertSelective(serveProject);
            logService.insertLog("服务项目",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ADD).append(serveProject.getProjectName()).toString(), request);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateServeProject(JSONObject obj, HttpServletRequest request) {
        ServeProject serveProject = JSONObject.parseObject(obj.toJSONString(), ServeProject.class);
        int result = 0;
        try {
            result = serveProjectMapper.updateByPrimaryKeySelective(serveProject);
            logService.insertLog("服务项目",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(serveProject.getProjectName()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchSetStatus(Boolean active, String ids) throws Exception {
        logService.insertLog("服务项目",
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ENABLED).toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        List<Long> serveProjectIds = StringUtil.strToLongList(ids);
        ServeProject serveProject = new ServeProject();
        serveProject.setActive(active);
        ServeProjectExample example = new ServeProjectExample();
        example.createCriteria().andIdIn(serveProjectIds);
        int result = 0;
        try {
            result = serveProjectMapper.updateByExampleSelective(serveProject, example);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteServeProject(Long id, HttpServletRequest request) throws Exception {
        return batchDeleteSupplierByIds(id.toString());
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteServeProject(String ids, HttpServletRequest request) throws Exception {
        return batchDeleteSupplierByIds(ids);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteSupplierByIds(String ids) throws Exception {
        String[] idArray = ids.split(",");
        //校验supplier_serve_project 是否存在依赖数据
        List<SupplierServeProject> supplierServeProjectList = null;
        try {
            supplierServeProjectList = supplierServeProjectMapperEx.getSupplierServeProjectListByServeProjectIds(idArray);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        if (supplierServeProjectList != null && supplierServeProjectList.size() > 0) {
            logger.error("异常码[{}],异常提示[{}],参数,ServeProjectIds[{}]",
                    ExceptionConstants.DELETE_FORCE_CONFIRM_CODE, ExceptionConstants.DELETE_FORCE_CONFIRM_MSG, ids);
            throw new BusinessRunTimeException(ExceptionConstants.DELETE_FORCE_CONFIRM_CODE,
                    ExceptionConstants.DELETE_FORCE_CONFIRM_MSG);
        }
        StringBuffer sb = new StringBuffer();
        sb.append(BusinessConstants.LOG_OPERATION_TYPE_DELETE);
        List<ServeProject> list = getServeProjectListByIds(ids);
        for (ServeProject serveProject : list) {
            sb.append("[").append(serveProject.getProjectName()).append("]");
        }
        logService.insertLog("服务项目", sb.toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        int result = 0;
        ServeProjectExample example = new ServeProjectExample();
        List<Long> serveProjectIds = StringUtil.strToLongList(ids);
        example.createCriteria().andIdIn(serveProjectIds);
        try {
            result = serveProjectMapper.deleteByExample(example);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }
}
