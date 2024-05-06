package com.jsh.erp.service.produceBom;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.entities.ProduceBom;
import com.jsh.erp.datasource.entities.ProduceBomExample;
import com.jsh.erp.datasource.entities.User;
import com.jsh.erp.datasource.mappers.ProduceBomMapper;
import com.jsh.erp.datasource.mappers.ProduceBomMapperEx;
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
import java.util.Map;

@Service
public class ProduceBomService {
    private Logger logger = LoggerFactory.getLogger(ProduceBomService.class);

    @Resource
    private LogService logService;

    @Resource
    private ProduceBomMapper produceBomMapper;

    @Resource
    private ProduceBomMapperEx produceBomMapperEx;

    @Resource
    private UserService userService;

    public List<ProduceBom> getProduceBomList(String produceBomParam, int offset, int rows) {
        List<ProduceBom> list = null;
        try {
            list = produceBomMapperEx.getProduceBomList(produceBomParam, offset, rows);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public Long countProduceBomList(String produceBomParam) {
        Long result = null;
        try {
            result=produceBomMapperEx.countProduceBomList(produceBomParam);
        } catch (Exception e) {
            JshException.readFail(logger,e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertProduceBom(JSONObject obj, HttpServletRequest request) {
        ProduceBom produceBom = JSONObject.parseObject(obj.toJSONString(), ProduceBom.class);
        int result = 0;
        try {
            result = produceBomMapper.insertSelective(produceBom);
            logService.insertLog("物料清单",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ADD).append(produceBom.getName()).toString(), request);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateProduceBom(JSONObject obj, HttpServletRequest request) {
        ProduceBom produceBom = JSONObject.parseObject(obj.toJSONString(), ProduceBom.class);
        int result = 0;
        try {
            result = produceBomMapper.updateByPrimaryKeySelective(produceBom);
            logService.insertLog("物料清单",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(produceBom.getName()).toString(), request);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteProduceBom(Long id, HttpServletRequest request) throws Exception {
        return batchDeleteProduceBomByIds(id.toString());
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteProduceBom(String ids, HttpServletRequest request) throws Exception {
        return batchDeleteProduceBomByIds(ids);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteProduceBomByIds(String ids) throws Exception {
        int result = 0;
        String[] idArray = ids.split(",");
        //记录日志
        StringBuffer sb = new StringBuffer();
        sb.append(BusinessConstants.LOG_OPERATION_TYPE_DELETE);
        List<ProduceBom> list = getProduceBomListByIds(ids);
        for (ProduceBom produceBom : list) {
            sb.append("[").append(produceBom.getName()).append("]");
        }
        logService.insertLog("物料清单", sb.toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        User userInfo = userService.getCurrentUser();
        try {
            result = produceBomMapperEx.batchDeleteProduceBomByIds(new Date(), userInfo == null ? null : userInfo.getId(), idArray);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    private List<ProduceBom> getProduceBomListByIds(String ids) {
        List<Long> idList = StringUtil.strToLongList(ids);
        List<ProduceBom> list = new ArrayList<>();
        try {
            ProduceBomExample example = new ProduceBomExample();
            example.createCriteria().andIdIn(idList);
            list = produceBomMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }
}
