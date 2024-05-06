package com.jsh.erp.service.supplierServeProject;

import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.entities.SupplierServeProject;
import com.jsh.erp.datasource.mappers.SupplierServeProjectMapper;
import com.jsh.erp.datasource.mappers.SupplierServeProjectMapperEx;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.log.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class SupplierServeProjectService {
    private Logger logger = LoggerFactory.getLogger(SupplierServeProjectService.class);

    @Resource
    private LogService logService;

    @Resource
    private SupplierServeProjectMapper supplierServeProjectMapper;

    @Resource
    private SupplierServeProjectMapperEx supplierServeProjectMapperEx;

    public SupplierServeProject getSupplierServeProject(Long id) {
        SupplierServeProject result = null;
        try {
            result = supplierServeProjectMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    public List<SupplierServeProject> select(String type, Long supplierId, int offset, int rows) {
        return supplierServeProjectMapperEx.searchSupplierServeProject(type, supplierId, offset, rows);

    }

    public Long count(String type, String supplierId) {
        return supplierServeProjectMapperEx.countSupplierServeProject(type, supplierId);

    }

    public int insert(SupplierServeProject supplierServeProject, HttpServletRequest request) {
        int result = 0;
        try {
            result = supplierServeProjectMapper.insertSelective(supplierServeProject);
            logService.insertLog("供应商服务项目", BusinessConstants.LOG_OPERATION_TYPE_ADD, request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    public List<SupplierServeProject> selectByNumber(String number) {
        return supplierServeProjectMapperEx.selectSupplierServeProjectByNumber(number);
    }

    public int update(SupplierServeProject supplierServeProject, HttpServletRequest request) {
        int result = 0;
        try {
            result = supplierServeProjectMapper.updateByPrimaryKeySelective(supplierServeProject);
            logService.insertLog("供应商服务项目", BusinessConstants.LOG_OPERATION_TYPE_ADD, request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }
}
