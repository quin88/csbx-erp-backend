package com.jsh.erp.service.supermarketVerificationLogs;

import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.entities.SupermarketVerificationLogs;
import com.jsh.erp.datasource.entities.SupermarketVerificationLogsExample;
import com.jsh.erp.datasource.mappers.SupermarketVerificationLogsMapper;
import com.jsh.erp.datasource.mappers.SupermarketVerificationLogsMapperEx;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupermarketVerificationLogsService {
    private Logger logger = LoggerFactory.getLogger(SupermarketVerificationLogsService.class);
    @Resource
    private SupermarketVerificationLogsMapper supermarketVerificationLogsMapper;

    @Resource
    private SupermarketVerificationLogsMapperEx supermarketVerificationLogsMapperEx;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void saveVerificationLogs(SupermarketVerificationLogs logs, HttpServletRequest request) throws Exception {

        supermarketVerificationLogsMapper.insertSelective(logs);
    }

    public void batchDeleteBySfIds(String ids) {
        SupermarketVerificationLogs svl = new SupermarketVerificationLogs();
        svl.setDeleteFlag(BusinessConstants.DELETE_FLAG_DELETED);
        List<Long> longList = StringUtil.strToLongList(ids);

        SupermarketVerificationLogsExample example = new SupermarketVerificationLogsExample();
        example.createCriteria().andSupermarketFinanceIdIn(longList);
        try {
            supermarketVerificationLogsMapper.updateByExampleSelective(svl, example);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
    }
}
