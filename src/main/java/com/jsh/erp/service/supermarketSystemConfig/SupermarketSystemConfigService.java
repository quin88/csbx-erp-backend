package com.jsh.erp.service.supermarketSystemConfig;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.entities.SupermarketSystemConfig;
import com.jsh.erp.datasource.entities.SupermarketSystemConfigExample;
import com.jsh.erp.datasource.entities.User;
import com.jsh.erp.datasource.mappers.*;
import com.jsh.erp.datasource.vo.SupermarketSystemConfigVo;
import com.jsh.erp.exception.BusinessRunTimeException;
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
import java.util.List;

@Service
public class SupermarketSystemConfigService {
    private Logger logger = LoggerFactory.getLogger(SupermarketServeClientService.class);

    @Resource
    private SupermarketSystemConfigMapperEx supermarketSystemConfigMapperEx;
    @Resource
    private SupermarketSystemConfigMapper supermarketSystemConfigMapper;
    @Resource
    private UserService userService;
    @Resource
    private LogService logService;
    /**
     * 生成商超编码统一方法
     *
     * @param numberName
     * @param length
     * @param request
     * @return
     */
    public String buildNumber(String numberName, int length, HttpServletRequest request) {
        try {
            User currentUser = userService.getCurrentUser();
            SupermarketSystemConfig systemConfig = supermarketSystemConfigMapperEx.getCurrentConfig(numberName);
            int currentValue = systemConfig.getCurrentValue() + 1; // 当前编号尾号
            String numberPrefix = systemConfig.getNumberPrefix(); // 编号前缀
            if (currentValue < systemConfig.getMaxValue()) {
                // 使用动态长度
                String format = "%0" + length + "d";
                String numberString = String.format(format, currentValue);
                return numberPrefix + numberString;
            } else {
                throw new BusinessRunTimeException(ExceptionConstants.SERIAL_NUMBERE_NOT_ENOUGH_CODE, ExceptionConstants.SERIAL_NUMBERE_NOT_ENOUGH_MSG);
            }
        } catch (Exception e) {
            JshException.readFail(logger, e);
            return ""; // 返回空字符串表示生成编号失败
        }
    }

    public SupermarketSystemConfig getCurrentConfig(String numberName) {
        return supermarketSystemConfigMapperEx.getCurrentConfig(numberName);
    }

    public SupermarketSystemConfig selectOne(Long id) {
        SupermarketSystemConfig result = null;
        try {
            result = supermarketSystemConfigMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    public List<SupermarketSystemConfigVo> select(int offset, int rows) {
        List<SupermarketSystemConfigVo> list = null;
        try {
            list = supermarketSystemConfigMapperEx.selectSupermarketSystemConfig(offset, rows);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public Long counts() {
        Long result = null;
        try {
            result = supermarketSystemConfigMapperEx.countSupermarketSystemConfig();
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception {
        SupermarketSystemConfig systemConfig = JSONObject.parseObject(obj.toJSONString(), SupermarketSystemConfig.class);
        int result = 0;
        User userInfo = userService.getCurrentUser();
        //每个租户只能有一个商超订单编码前缀
        if (getNumberPrefix() != null && !getNumberPrefix().isEmpty()) {
            throw new BusinessRunTimeException(ExceptionConstants.SUPERMARKET_ORDER_NUMBER_PREFIX_EXIST_CODE,
                    String.format(ExceptionConstants.SUPERMARKET_ORDER_NUMBER_PREFIX_EXIST_MSG));
        }
        try {
            result = supermarketSystemConfigMapper.insertSelective(systemConfig);
            logService.insertLog("商超编码",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ADD).append(systemConfig.getNumberPrefix()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int update(JSONObject obj, HttpServletRequest request) throws Exception {
        SupermarketSystemConfig systemConfig = JSONObject.parseObject(obj.toJSONString(), SupermarketSystemConfig.class);
        int result = 0;
        User userInfo = userService.getCurrentUser();
        try {
            result = supermarketSystemConfigMapper.updateByPrimaryKeySelective(systemConfig);
            logService.insertLog("商超编码",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(systemConfig.getNumberPrefix()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    public int delete(Long id, HttpServletRequest request) throws Exception {
        return batchDeleteSystemConfigByIds(id.toString());
    }

    public int deleteBatch(String ids, HttpServletRequest request) throws Exception {
        return batchDeleteSystemConfigByIds(ids);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteSystemConfigByIds(String ids) throws Exception {
        String[] idArray = ids.split(",");
        User userInfo = userService.getCurrentUser();
        int result = 0;
        try {
            result = supermarketSystemConfigMapperEx.batchDeleteSystemConfigByIds(idArray);
            //记录日志
            StringBuffer sb = new StringBuffer();
            sb.append(BusinessConstants.LOG_OPERATION_TYPE_DELETE);
            logService.insertLog("商超编码", sb.toString(),
                    ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    /**
     * 获取当前租户的编码前缀
     *
     * @return
     */
    public String getNumberPrefix() {
        String numberPrefix = "";
        try {
            SupermarketSystemConfig currentTenantConfig = getCurrentTenantConfig();
            if (currentTenantConfig != null) {
                numberPrefix = currentTenantConfig.getNumberPrefix();
            }
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return numberPrefix;
    }

    /**
     * 获取当前租户配置
     */
    public SupermarketSystemConfig getCurrentTenantConfig() {
        SupermarketSystemConfigExample example = new SupermarketSystemConfigExample();
        example.createCriteria().andNumberNameEqualTo(BusinessConstants.SUPERMARKET_ORDER_NUMBER_SEQ).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<SupermarketSystemConfig> systemConfigs = supermarketSystemConfigMapper.selectByExample(example);
        if (!systemConfigs.isEmpty()) {
            return systemConfigs.get(0);
        } else {
            return null;
        }
    }
}
