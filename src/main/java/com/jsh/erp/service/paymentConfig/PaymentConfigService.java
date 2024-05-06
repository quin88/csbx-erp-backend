package com.jsh.erp.service.paymentConfig;

import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.PaymentConfigMapper;
import com.jsh.erp.datasource.mappers.PaymentConfigMapperEx;
import com.jsh.erp.datasource.vo.PaymentConfigVo;
import com.jsh.erp.exception.BusinessRunTimeException;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.log.LogService;
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
public class PaymentConfigService {
    private Logger logger = LoggerFactory.getLogger(PaymentConfigService.class);

    @Resource
    private PaymentConfigMapper paymentConfigMapper;
    @Resource
    private PaymentConfigMapperEx paymentConfigMapperEx;

    @Resource
    private UserService userService;

    @Resource
    private LogService logService;

    public PaymentConfig selectOne(Long id) {
        PaymentConfig result = null;
        try {
            result = paymentConfigMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    public List<PaymentConfigVo> select(Long maId, Long atId, int offset, int rows) {
        List<PaymentConfigVo> list = null;
        try {
            list = paymentConfigMapperEx.selectPaymentConfig(maId, atId, offset, rows);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public Long counts(Long maId, Long atId) {
        Long result = null;
        try {
            result = paymentConfigMapperEx.countPaymentConfig(maId, atId);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }


    public int delete(Long id, HttpServletRequest request) throws Exception {
        return batchDeletePaymentConfigByIds(id.toString());
    }

    public int deleteBatch(String ids, HttpServletRequest request) throws Exception {
        return batchDeletePaymentConfigByIds(ids);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeletePaymentConfigByIds(String ids) throws Exception {
        String[] idArray = ids.split(",");
        User userInfo = userService.getCurrentUser();
        int result = 0;
        try {
            result = paymentConfigMapperEx.batchDeletePaymentConfigByIds(idArray);
            //记录日志
            StringBuffer sb = new StringBuffer();
            sb.append(BusinessConstants.LOG_OPERATION_TYPE_DELETE);
            logService.insertLog("商超付款配置", sb.toString(),
                    ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int addPaymentConfig(List<PaymentConfig> paymentConfigs, String deleteId, HttpServletRequest request) throws Exception {
        int result = 0;
        User userInfo = userService.getCurrentUser();
        for (PaymentConfig paymentConfig : paymentConfigs) {
            if (paymentConfig.getId() == null) {//新增
                //同样的地区加同样的品类是只能1条
                PaymentConfigExample example = new PaymentConfigExample();
                example.createCriteria().andMarketAddressIdEqualTo(paymentConfig.getMarketAddressId())
                        .andAquaticTypeIdEqualTo(paymentConfig.getAquaticTypeId())
                        .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
                List<PaymentConfig> pcList = paymentConfigMapper.selectByExample(example);
                if (!pcList.isEmpty()) {
                    throw new BusinessRunTimeException(ExceptionConstants.SUPERMARKET_PAYMENT_CONFIG_EXIST_CODE,
                            String.format(ExceptionConstants.SUPERMARKET_PAYMENT_CONFIG_EXIST_MSG));
                }
                result = paymentConfigMapper.insertSelective(paymentConfig);
            } else {//编辑
                result = paymentConfigMapper.updateByPrimaryKeySelective(paymentConfig);
            }
            logService.insertLog("商超付款配置",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(paymentConfig.getId()).toString(), request);
        }
        //删除
        if (deleteId != null && !deleteId.isEmpty()) {
            batchDeletePaymentConfigByIds(deleteId);
        }
        logService.insertLog("商超付款配置",
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_DELETE).append(deleteId).toString(), request);
        return result;
    }
}
