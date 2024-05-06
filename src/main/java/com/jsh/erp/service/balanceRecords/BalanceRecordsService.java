package com.jsh.erp.service.balanceRecords;

import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.entities.BalanceRecords;
import com.jsh.erp.datasource.entities.User;
import com.jsh.erp.datasource.mappers.BalanceRecordsMapper;
import com.jsh.erp.datasource.mappers.BalanceRecordsMapperEx;
import com.jsh.erp.datasource.mappers.SupplierMapper;
import com.jsh.erp.exception.BusinessRunTimeException;
import com.jsh.erp.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

@Service
public class BalanceRecordsService {

    private Logger logger = LoggerFactory.getLogger(BalanceRecordsService.class);

    @Resource
    private UserService userService;
    @Resource
    private SupplierMapper supplierMapper;
    @Resource
    private BalanceRecordsMapper balanceRecordsMapper;
    @Resource
    private BalanceRecordsMapperEx balanceRecordsMapperEx;

    /**
     * 更新供应商余额（增加在余额表的的余额）
     *
     * @param supplierId
     * @param price
     * @param amountOfGift
     * @throws Exception
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int addBalanceRecords(Long supplierId, BigDecimal price, BigDecimal amountOfGift) throws Exception {

        User userInfo = userService.getCurrentUser();
        String supplier = supplierMapper.selectByPrimaryKey(supplierId).getSupplier();
        BalanceRecords balanceRecords = balanceRecordsMapperEx.selectBySupplierId(supplierId);
        int result = 0;
        if (balanceRecords == null) {
            // 如果供应商余额表中不存在记录，则创建一条新的记录
            balanceRecords = new BalanceRecords();
            balanceRecords.setSupplierId(supplierId);
            balanceRecords.setSupplier(supplier);
            balanceRecords.setBalance(price);//充值金额
            balanceRecords.setAmountOfGift(amountOfGift);//赠送金额
            balanceRecords.setSubtotal(price.add(amountOfGift));//余额总计
            balanceRecords.setCreator(userInfo.getId());
            balanceRecords.setCreateTime(new Date());
            result = balanceRecordsMapper.insertSelective(balanceRecords);
        } else {
            // 如果供应商余额表中已存在记录，则更新余额
            BigDecimal currentBalance = balanceRecords.getBalance();//已有的充值金额
            BigDecimal newBalance = currentBalance.add(price);
            BigDecimal currentAmountOfGift = balanceRecords.getAmountOfGift();//已有的赠送金额
            BigDecimal newAmountOfGift = currentAmountOfGift.add(amountOfGift);

            balanceRecords.setBalance(newBalance);//充值金额
            balanceRecords.setAmountOfGift(newAmountOfGift);//赠送金额
            balanceRecords.setSubtotal(newBalance.add(newAmountOfGift));//余额总计
            balanceRecords.setUpdater(userInfo.getId());
            balanceRecords.setUpdateTime(new Date());
            result = balanceRecordsMapper.updateByPrimaryKeySelective(balanceRecords);
        }
        return result;
    }

    /**
     * 更新供应商余额（出入库等反审核操作，回退金额到用户账户）
     *
     * @param supplierId
     * @param paymentAmount
     * @param amountOfGift
     * @throws Exception
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int rollbackBalanceRecords(Long supplierId, BigDecimal paymentAmount, BigDecimal amountOfGift) throws Exception {
        User userInfo = userService.getCurrentUser();
        BalanceRecords balanceRecords = balanceRecordsMapperEx.selectBySupplierId(supplierId);

        BigDecimal currentBalance = balanceRecords.getBalance();//已有的充值金额
        BigDecimal newBalance = currentBalance.add(paymentAmount);//扣除充值金额
        BigDecimal currentAmountOfGift = balanceRecords.getAmountOfGift();//已有的赠送金额
        BigDecimal newAmountOfGift = currentAmountOfGift.add(amountOfGift);//扣除赠送金额

        balanceRecords.setBalance(newBalance);//充值金额
        balanceRecords.setAmountOfGift(newAmountOfGift);//赠送金额
        balanceRecords.setSubtotal(newBalance.add(newAmountOfGift));//余额总计
        balanceRecords.setUpdater(userInfo.getId());
        balanceRecords.setUpdateTime(new Date());
        return balanceRecordsMapper.updateByPrimaryKeySelective(balanceRecords);
    }

    /**
     * 更新供应商余额（充值反审核操作，回退供应商余额）
     *
     * @param supplierId
     * @param paymentAmount
     * @param amountOfGift
     * @throws Exception
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int subtractBalanceRecords(Long supplierId, BigDecimal paymentAmount, BigDecimal amountOfGift) throws Exception {
        User userInfo = userService.getCurrentUser();
        BalanceRecords balanceRecords = balanceRecordsMapperEx.selectBySupplierId(supplierId);

        BigDecimal currentBalance = balanceRecords.getBalance();//已有的充值金额
        BigDecimal newBalance = currentBalance.subtract(paymentAmount);//扣除充值金额
        BigDecimal currentAmountOfGift = balanceRecords.getAmountOfGift();//已有的赠送金额
        BigDecimal newAmountOfGift = currentAmountOfGift.subtract(amountOfGift);//扣除赠送金额

        balanceRecords.setBalance(newBalance);//充值金额
        balanceRecords.setAmountOfGift(newAmountOfGift);//赠送金额
        balanceRecords.setSubtotal(newBalance.add(newAmountOfGift));//余额总计
        balanceRecords.setUpdater(userInfo.getId());
        balanceRecords.setUpdateTime(new Date());
        return balanceRecordsMapper.updateByPrimaryKeySelective(balanceRecords);
    }

    /**
     * 更新供应商余额（扣除金额）
     *
     * @param supplierId
     * @param totalPrice
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int subtractBalance(Long supplierId, BigDecimal totalPrice, String subType) throws Exception {
        User userInfo = userService.getCurrentUser();

       /* 校验余额是否支持出入库操作：
         1.余额大于0，可以出入库
         2.余额小于等于0，可以入库，正常计费
         3.余额小于等于0，出库有费用，提示“供应商余额不足”*/

        BalanceRecords balanceRecords = balanceRecordsMapperEx.selectBySupplierId(supplierId);//查询余额
        if (balanceRecords == null) {
            throw new BusinessRunTimeException(
                    ExceptionConstants.BALANCE_RECORDS_SUBTRACT_FAILED_CODE,
                    String.format(ExceptionConstants.BALANCE_RECORDS_SUBTRACT_FAILED_MSG)
            );
        }

        BigDecimal subtotal = balanceRecords.getSubtotal();
        if (("销售寄存出库".equals(subType) || ("其它费用".equals(subType))) && subtotal.compareTo(totalPrice) < 0) {
            throw new BusinessRunTimeException(
                    ExceptionConstants.BALANCE_RECORDS_SUBTRACT_FAILED_CODE,
                    String.format(ExceptionConstants.BALANCE_RECORDS_SUBTRACT_FAILED_MSG)
            );
        }

        BigDecimal balance = balanceRecords.getBalance();
        BigDecimal amountOfGift = balanceRecords.getAmountOfGift();
        BigDecimal remainingAmount;
        //先扣除基础金额，然后再扣除赠送金额
        if (subtotal.compareTo(totalPrice) >= 0) {
            // 如果总余额大于等于扣款金额，则先扣除基础余额，再扣除赠送金额
            if (balance.compareTo(BigDecimal.ZERO) > 0) {
                // 如果还有基础余额
                remainingAmount = balance.subtract(totalPrice);
                if (remainingAmount.compareTo(BigDecimal.ZERO) < 0) {
                    // 基础余额不足以支付
                    amountOfGift = amountOfGift.add(remainingAmount);
                    balance = BigDecimal.ZERO;
                } else {
                    balance = remainingAmount;
                }
            } else {
                // 没有基础余额，直接扣除赠送金额
                amountOfGift = amountOfGift.subtract(totalPrice);
            }
        } else {
            // 余额小于扣款金额
            remainingAmount = totalPrice.subtract(amountOfGift);
            amountOfGift = BigDecimal.ZERO;
            balance = balance.subtract(remainingAmount);
        }
        // 更新余额信息
        BigDecimal newSubtotal = balance.add(amountOfGift);
        balanceRecords.setAmountOfGift(amountOfGift);
        balanceRecords.setBalance(balance);
        balanceRecords.setSubtotal(newSubtotal);
        balanceRecords.setUpdater(userInfo.getId());
        balanceRecords.setUpdateTime(new Date());
        return balanceRecordsMapper.updateByPrimaryKey(balanceRecords);
    }
}

