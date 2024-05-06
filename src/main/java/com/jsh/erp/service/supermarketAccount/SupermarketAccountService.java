package com.jsh.erp.service.supermarketAccount;

import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.entities.SupermarketAccount;
import com.jsh.erp.datasource.entities.SupermarketAccountExample;
import com.jsh.erp.datasource.entities.SupermarketSupplier;
import com.jsh.erp.datasource.entities.User;
import com.jsh.erp.datasource.mappers.SupermarketAccountMapper;
import com.jsh.erp.datasource.mappers.SupermarketAccountMapperEx;
import com.jsh.erp.datasource.vo.SupermarketAccountVoList;
import com.jsh.erp.exception.BusinessRunTimeException;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.user.UserService;
import com.jsh.erp.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupermarketAccountService {
    private Logger logger = LoggerFactory.getLogger(SupermarketAccountService.class);

    @Resource
    private SupermarketAccountMapper supermarketAccountMapper;

    @Resource
    private SupermarketAccountMapperEx supermarketAccountMapperEx;

    @Resource
    private UserService userService;

    /**
     * 查询所有账户信息(供应商：已审核且启用)
     *
     * @return
     */
    public List<SupermarketAccountVoList> getSupermarketAccountList() {
        List<SupermarketAccountVoList> list = null;

        try {
            list = supermarketAccountMapperEx.getSupermarketAccountList();
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    /**
     * 查询供应商的所有账户信息
     *
     * @param supplierId
     * @return
     */
    public List<SupermarketAccount> getAccountListBySupplierId(Long supplierId) {
        SupermarketAccountExample example = new SupermarketAccountExample();
        example.createCriteria().andSupplierIdEqualTo(supplierId).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<SupermarketAccount> list = null;
        try {
            list = supermarketAccountMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    /**
     * 保存供应商账户信息
     *
     * @param accountList
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void saveAccountList(Long supplierId, List<SupermarketAccount> accountList) throws Exception {
        User userInfo = userService.getCurrentUser();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        //获取供应商id
        List<Long> existingIds = supermarketAccountMapperEx.getExistingIds(supplierId);
        List<Long> idList = new ArrayList<>();
        if (accountList != null && accountList.size() > 0) {
            for (SupermarketAccount account : accountList) {
                account.setUpdater(userInfo == null ? null : userInfo.getId());
                account.setUpdateTime(timestamp);
                if (account.getId() == null) {
                    //校验银行账户是否存在
                    checkIsAccountNumberExist(account.getAccountNumber());

                    account.setCreator(userInfo == null ? null : userInfo.getId());
                    account.setCreateTime(timestamp);
                    supermarketAccountMapper.insertSelective(account);
                } else {
                    supermarketAccountMapper.updateByPrimaryKeySelective(account);
                    idList.add(account.getId());
                }
            }
        }
        if (!existingIds.isEmpty()) {
            List<Long> ids = existingIds.stream().filter(id -> !idList.contains(id)).collect(Collectors.toList());
            if (!ids.isEmpty()) {
                supermarketAccountMapperEx.batchDeleteSupermarketAccountByIds(new Date(), userInfo == null ? null : userInfo.getId(), ids);
            }
        }
    }

    private void checkIsAccountNumberExist(String accountNumber) {
        if (StringUtil.isNotEmpty(accountNumber)) {
            SupermarketAccountExample example = new SupermarketAccountExample();
            example.createCriteria().andAccountNumberEqualTo(accountNumber).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
            List<SupermarketAccount> list = supermarketAccountMapper.selectByExample(example);
            if (list != null && list.size() > 0) {
                throw new BusinessRunTimeException(ExceptionConstants.SUPERMARKET_ACCOUNT_NUMBER_IS_EXIST_CODE, String.format(ExceptionConstants.SUPERMARKET_ACCOUNT_NUMBER_IS_EXIST_MSG, accountNumber));
            }
        }
    }

    /**
     * 批量删除供应商对应的账户信息
     *
     * @param supplierIds
     * @return
     */
    public int batchDeleteSupermarketAccountBySupplierIds(String[] supplierIds) throws Exception {
        User userInfo = userService.getCurrentUser();
        int result = 0;
        try {
            result = supermarketAccountMapperEx.batchDeleteSupermarketAccountBySupplierIds(new Date(), userInfo == null ? null : userInfo.getId(), supplierIds);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    public List<SupermarketAccount> findAccountListBySupplierId(Long supplierId, HttpServletRequest request) {
        SupermarketAccountExample example = new SupermarketAccountExample();
        example.createCriteria().andSupplierIdEqualTo(supplierId).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        return supermarketAccountMapper.selectByExample(example);
    }

    public List<SupermarketAccountVoList> findByAll(List<Long> supplierIds) {
        List<SupermarketAccountVoList> list = null;
        try {
            list = supermarketAccountMapperEx.findByAll(supplierIds);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }
}
