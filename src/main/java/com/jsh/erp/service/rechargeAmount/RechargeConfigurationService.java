package com.jsh.erp.service.rechargeAmount;

import com.jsh.erp.datasource.dto.RechargeConfigurationDTO;
import com.jsh.erp.datasource.entities.RechargeConfiguration;
import com.jsh.erp.datasource.entities.RechargeConfigurationExample;
import com.jsh.erp.datasource.mappers.RechargeConfigurationMapper;
import com.jsh.erp.datasource.mappers.RechargeConfigurationMapperEx;
import com.jsh.erp.exception.JshException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RechargeConfigurationService {

    private Logger logger = LoggerFactory.getLogger(RechargeConfigurationService.class);

    @Resource
    private RechargeConfigurationMapper rechargeConfigurationMapper;

    @Resource
    private RechargeConfigurationMapperEx rechargeConfigurationMapperEx;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void saveRechargeConfiguration(RechargeConfigurationDTO dto, HttpServletRequest request) throws Exception {
        List<RechargeConfiguration> rcs = dto.getRechargeConfigurations();
        for (RechargeConfiguration rc : rcs) {
            if (rc.getId() == null) {//新增
                rechargeConfigurationMapper.insertSelective(rc);
            } else {//编辑
                rechargeConfigurationMapper.updateByPrimaryKeySelective(rc);
            }
        }
        String deleteIds = dto.getDeleteIds();
        if (deleteIds != null && !deleteIds.isEmpty()) {//删除
            batchDeleteByIds(deleteIds);
        }
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteByIds(String ids) throws Exception {
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .collect(Collectors.toList());
        int result = 0;
        for (Long id : idList) {
            rechargeConfigurationMapper.deleteByPrimaryKey(id);
        }
        return result;
    }

    public List<RechargeConfiguration> getRechargeConfigurationList(HttpServletRequest request) {
        List<RechargeConfiguration> result = null;
        try {
            RechargeConfigurationExample example = new RechargeConfigurationExample();
            example.createCriteria();
            result = rechargeConfigurationMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    /**
     * 通过充值金额获取赠送金额（向下取值）
     *
     * @param rechargeAmount
     * @return
     */
    public BigDecimal getGiftAmountByRechargeAmount(BigDecimal rechargeAmount) {
        BigDecimal result = BigDecimal.ZERO;
        try {
            result = rechargeConfigurationMapperEx.getGiftAmountByRechargeAmount(rechargeAmount);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }
}


