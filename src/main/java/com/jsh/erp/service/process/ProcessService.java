package com.jsh.erp.service.process;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.entities.Process;
import com.jsh.erp.datasource.mappers.ProcessMapper;
import com.jsh.erp.datasource.mappers.ProcessMapperEx;
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
public class ProcessService {
    private Logger logger = LoggerFactory.getLogger(ProcessService.class);

    @Resource
    private LogService logService;

    @Resource
    private ProcessMapper processMapper;

    @Resource
    private ProcessMapperEx processMapperEx;

    @Resource
    private UserService userService;


    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertProcess(JSONObject obj, HttpServletRequest request) {
        Process process = JSONObject.parseObject(obj.toJSONString(), Process.class);
        int result = 0;
        try {
            result = processMapper.insertSelective(process);
            logService.insertLog("组装管理",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ADD).append(process.getProcessName()).toString(), request);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateProcess(JSONObject obj, HttpServletRequest request) {
        Process process = JSONObject.parseObject(obj.toJSONString(), Process.class);
        int result = 0;
        try {
            result = processMapper.updateByPrimaryKeySelective(process);
            logService.insertLog("组装管理",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(process.getProcessName()).toString(), request);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteProcess(Long id, HttpServletRequest request) throws Exception {
        return batchDeleteProcessByIds(id.toString());

    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteProcess(String ids, HttpServletRequest request) throws Exception {
        return batchDeleteProcessByIds(ids);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteProcessByIds(String ids) throws Exception {
        int result = 0;
        String[] idArray = ids.split(",");
        //记录日志
        StringBuffer sb = new StringBuffer();
        sb.append(BusinessConstants.LOG_OPERATION_TYPE_DELETE);
        List<Process> list = getProcessListByIds(ids);
        for(Process process: list){
            sb.append("[").append(process.getProcessName()).append("]");
        }
        logService.insertLog("组装管理", sb.toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        User userInfo = userService.getCurrentUser();
        try {
            result =processMapperEx.batchDeleteProcessByIds(new Date(), userInfo == null ? null : userInfo.getId(), idArray);
        } catch (Exception e) {
            JshException.readFail(logger,e);
        }
        return result;
    }

    private List<Process> getProcessListByIds(String ids) {
        List<Long> idList = StringUtil.strToLongList(ids);
        List<Process> list = new ArrayList<>();
        try{
            ProcessExample example = new ProcessExample();
            example.createCriteria().andIdIn(idList);
            list = processMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }
}
