package com.jsh.erp.service.settlementMethod;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.SettlementMethodMapper;
import com.jsh.erp.datasource.mappers.SettlementMethodMapperEx;
import com.jsh.erp.exception.BusinessRunTimeException;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.secondSettlementMethod.SecondSettlementMethodService;
import com.jsh.erp.service.user.UserService;
import com.jsh.erp.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class SettlementMethodService {
    private Logger logger = LoggerFactory.getLogger(SettlementMethodService.class);

    @Resource
    private SettlementMethodMapper settlementMethodMapper;

    @Resource
    private SettlementMethodMapperEx settlementMethodMapperEx;

    @Resource
    private SecondSettlementMethodService secondSettlementMethodService;

    @Resource
    private UserService userService;

    public SettlementMethod getSettlementMethod(Long id) {
        SettlementMethod result = null;
        try {
            result = settlementMethodMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    public List<SettlementMethod> getSettlementMethod() {
        SettlementMethodExample example = new SettlementMethodExample();
        example.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<SettlementMethod> list = null;
        try {
            list = settlementMethodMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertSettlementMethod(JSONObject obj, HttpServletRequest request) throws Exception {
        SettlementMethod settlementMethod = JSONObject.parseObject(obj.toJSONString(), SettlementMethod.class);
        User userInfo = userService.getCurrentUser();
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        int result = 0;
        try {
            settlementMethod.setCreateTime(currentTime);
            settlementMethod.setCreator(userInfo == null ? null : userInfo.getId());
            settlementMethod.setUpdateTime(currentTime);
            settlementMethod.setUpdater(userInfo == null ? null : userInfo.getId());
            settlementMethod.setStatus("1");
            result = settlementMethodMapper.insertSelective(settlementMethod);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateSettlementMethod(JSONObject obj, HttpServletRequest request) throws Exception {
        SettlementMethod settlementMethod = JSONObject.parseObject(obj.toJSONString(), SettlementMethod.class);
        User userInfo = userService.getCurrentUser();
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        int result = 0;
        try {
            settlementMethod.setUpdateTime(currentTime);
            settlementMethod.setUpdater(userInfo == null ? null : userInfo.getId());
            result = settlementMethodMapper.updateByPrimaryKeySelective(settlementMethod);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteSettlementMethod(Long id, HttpServletRequest request) {
        return batchDeleteSettlementMethodByIds(id.toString());
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteSettlementMethod(String ids, HttpServletRequest request) {
        return batchDeleteSettlementMethodByIds(ids);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteSettlementMethodByIds(String ids) {
        int result = 0;
        String[] idArray = ids.split(",");
        //校验二级结算方式表	second_settlement_method
        List<SecondSettlementMethod> list = null;
        try {
            list = secondSettlementMethodService.getSecondSettlementMethodList(ids);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        if (list != null && list.size() > 0) {
            logger.error("异常码[{}],异常提示[{}],参数,[{}]",
                    ExceptionConstants.DELETE_FORCE_CONFIRM_CODE, ExceptionConstants.DELETE_FORCE_CONFIRM_MSG, ids);
            throw new BusinessRunTimeException(ExceptionConstants.DELETE_FORCE_CONFIRM_CODE,
                    ExceptionConstants.DELETE_FORCE_CONFIRM_MSG);
        }
        try {
            User userInfo = userService.getCurrentUser();
            result = settlementMethodMapperEx.batchDeleteSettlementMethodByIds(new Date(), userInfo == null ? null : userInfo.getId(), idArray);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void addSettlementMethod(List<SettlementMethod> settlementMethodList, String deleteId, HttpServletRequest request) throws Exception {
        if (settlementMethodList != null && settlementMethodList.size() > 0) {
            User userInfo = userService.getCurrentUser();
            Timestamp currentTime = new Timestamp(System.currentTimeMillis());

            for (SettlementMethod settlementMethod : settlementMethodList) {
                settlementMethod.setUpdater(userInfo == null ? null : userInfo.getId());
                settlementMethod.setUpdateTime(currentTime);
                if (settlementMethod.getId() == null) {
                    //校验名称是否重复
                    if (checkIsNameExist(settlementMethod.getSettlement()) > 0) {
                        throw new BusinessRunTimeException(ExceptionConstants.SETTLEMENT_NAME_EXIST_CODE, String.format(ExceptionConstants.SETTLEMENT_NAME_EXIST_EXIST_MSG, settlementMethod.getSettlement()));
                    }
                    settlementMethod.setCreator(userInfo == null ? null : userInfo.getId());
                    settlementMethod.setCreateTime(currentTime);
                    //执行新增
                    settlementMethodMapper.insertSelective(settlementMethod);
                } else {
                    //执行编辑
                    settlementMethodMapper.updateByPrimaryKeySelective(settlementMethod);
                }
            }
        }
        //执行删除
        if (StringUtil.isNotEmpty(deleteId)) {
            batchDeleteSettlementMethodByIds(deleteId);
        }
    }

    public int checkIsNameExist(String name) throws Exception {
        SettlementMethodExample example = new SettlementMethodExample();
        example.createCriteria().andSettlementEqualTo(name).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<SettlementMethod> list = null;
        try {
            list = settlementMethodMapper.selectByExample(example);
        } catch (Exception e) {
            logger.error("异常码[{}],异常提示[{}],异常[{}]",
                    ExceptionConstants.DATA_READ_FAIL_CODE, ExceptionConstants.DATA_READ_FAIL_MSG, e);
            throw new BusinessRunTimeException(ExceptionConstants.DATA_READ_FAIL_CODE,
                    ExceptionConstants.DATA_READ_FAIL_MSG);
        }
        return list == null ? 0 : list.size();
    }

    public List<SettlementMethod> findBySelectSup() {
        SettlementMethodExample example = new SettlementMethodExample();
        example.createCriteria().andStatusEqualTo("1")
                .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<SettlementMethod> list = null;
        try {
            list = settlementMethodMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }
}
