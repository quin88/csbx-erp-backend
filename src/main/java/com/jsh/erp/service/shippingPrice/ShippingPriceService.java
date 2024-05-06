package com.jsh.erp.service.shippingPrice;

import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.*;
import com.jsh.erp.datasource.vo.ShippingPriceVo;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.balanceRecords.BalanceRecordsService;
import com.jsh.erp.service.user.UserService;
import com.jsh.erp.utils.ResponseCode;
import com.jsh.erp.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
public class ShippingPriceService {

    private Logger logger = LoggerFactory.getLogger(ShippingPriceService.class);

    @Resource
    private ShippingPriceMapper shippingPriceMapper;
    @Resource
    private PriceReceiptsMapper priceReceiptsMapper;
    @Resource
    private UserService userService;
    @Resource
    private BalanceRecordsService balanceRecordsService;
    @Resource
    private PriceReceiptsMapperEx priceReceiptsMapperEx;
    @Resource
    private SupplierMapper supplierMapper;
    @Resource
    private ShippingPriceMapperEx shippingPriceMapperEx;

    public ShippingPrice getShippingPrice(Long id) {
        ShippingPrice result = null;
        try {
            result = shippingPriceMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    /**
     * 根据编号查询物流费用
     *
     * @param receiptsNumber
     * @param request
     * @return
     */
    public ShippingPriceVo selectPriceDetails(String receiptsNumber, HttpServletRequest request) {
        ShippingPriceVo shippingPriceVo = new ShippingPriceVo();
        //查询物流费用
        ShippingPriceExample shippingPriceExample = new ShippingPriceExample();
        shippingPriceExample.createCriteria().andDeleteFlagEqualTo(BusinessConstants.DELETE_FLAG_EXISTS).andReceiptsNumberEqualTo(receiptsNumber);
        List<ShippingPrice> shippingPrice = shippingPriceMapper.selectByExample(shippingPriceExample);

        shippingPriceVo.setShippingPrices(shippingPrice);
        //查询费用单据
        PriceReceipts priceReceipts = priceReceiptsMapperEx.selectPriceReceiptsByReceiptsNumber(receiptsNumber);
        shippingPriceVo.setPriceReceipts(priceReceipts);
        return shippingPriceVo;
    }

    /**
     * 新增物流费用
     *
     * @param shippingPriceVo
     * @param request
     * @return
     * @throws Exception
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public Object addShippingPrice(ShippingPriceVo shippingPriceVo, HttpServletRequest request) throws Exception {
        User userInfo = userService.getCurrentUser();
        PriceReceipts priceReceipts = shippingPriceVo.getPriceReceipts();
        for (ShippingPrice shippingPrice : shippingPriceVo.getShippingPrices()) {
            shippingPrice.setCreator(userInfo == null ? null : userInfo.getId());
            shippingPrice.setCreateTime(priceReceipts.getCreateTime());
            shippingPriceMapper.insertSelective(shippingPrice);
        }
        //添加费用单据信息
        String supplier = supplierMapper.selectByPrimaryKey(shippingPriceVo.getPriceReceipts().getSupplierId()).getSupplier();
        priceReceipts.setSupplier(supplier);
        priceReceipts.setCreator(userInfo == null ? null : userInfo.getId());
        priceReceiptsMapper.insertSelective(priceReceipts);
        //状态为已审核扣除供应商余额
        if ("1".equals(priceReceipts.getStatus())) {
            balanceRecordsService.subtractBalance(priceReceipts.getSupplierId(), priceReceipts.getTotalPrice(), priceReceipts.getPriceType());
        }
        return new ResponseCode(ExceptionConstants.SERVICE_SUCCESS_CODE, String.format(ExceptionConstants.SERVICE_SUCCESS_MSG));

    }

    /**
     * 编辑物流费用
     *
     * @param shippingPriceVo
     * @param request
     * @return
     * @throws Exception
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public Object updatePriceDetails(ShippingPriceVo shippingPriceVo, HttpServletRequest request) throws Exception {
        List<ShippingPrice> shippingPrices = shippingPriceVo.getShippingPrices();
        User userInfo = userService.getCurrentUser();
        // 获取数据库中已有的 ShippingPrice 数据
        ShippingPriceExample shippingPriceExample = new ShippingPriceExample();
        shippingPriceExample.createCriteria().andReceiptsNumberEqualTo(shippingPriceVo.getPriceReceipts().getReceiptsNumber());
        List<ShippingPrice> existingShippingPrice = shippingPriceMapper.selectByExample(shippingPriceExample);

        // 找出需要新增和更新的数据
        for (ShippingPrice shippingPrice : shippingPrices) {
            if (shippingPrice.getId() != null) {
                shippingPrice.setUpdater(userInfo == null ? null : userInfo.getId());
                shippingPrice.setUpdateTime(new Date());
                shippingPriceMapper.updateByPrimaryKeySelective(shippingPrice);
            } else {
                shippingPrice.setUpdater(userInfo == null ? null : userInfo.getId());
                shippingPriceMapper.insertSelective(shippingPrice);
            }
        }

        // 删除用户删除行，找出需要删除的数据
        Set<Long> frontendIds = new HashSet<>();
        for (ShippingPrice shippingPrice : shippingPrices) {
            if (shippingPrice.getId() != null) {
                frontendIds.add(shippingPrice.getId());
            }
        }
        // 创建一个List来存储需要删除的PriceDetails的id
        List<Long> ids = new ArrayList<>();
        // 遍历查询
        for (ShippingPrice shippingPrice : existingShippingPrice) {
            if (!frontendIds.contains(shippingPrice.getId())) {
                ids.add(shippingPrice.getId());
            }
        }
        // 执行批量删除操作,尚未审核通过，执行物流删除
        if (!ids.isEmpty()) {
            for (Long id : ids) {
                shippingPriceMapper.deleteByPrimaryKey(id);
            }
        }
        //更新费用单据表
        PriceReceipts priceReceipts = shippingPriceVo.getPriceReceipts();
        priceReceipts.setUpdater(userInfo == null ? null : userInfo.getId());
        priceReceipts.setUpdateTime(new Date());
        PriceReceiptsExample example = new PriceReceiptsExample();
        example.createCriteria().andReceiptsNumberEqualTo(shippingPriceVo.getPriceReceipts().getReceiptsNumber());
        priceReceiptsMapper.updateByExampleSelective(shippingPriceVo.getPriceReceipts(), example);
        //状态为已审核扣除供应商余额
        if ("1".equals(priceReceipts.getStatus())) {
            balanceRecordsService.subtractBalance(priceReceipts.getSupplierId(), priceReceipts.getTotalPrice(), priceReceipts.getPriceType());
        }
        return new ResponseCode(ExceptionConstants.SERVICE_SUCCESS_CODE, String.format(ExceptionConstants.SERVICE_SUCCESS_MSG));
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeletePriceDetailByReceiptsNumber(List<String> numbers) throws Exception {
        String[] numberArray = StringUtil.listToStringArray(numbers);
        User userInfo = userService.getCurrentUser();
        int result = 0;
        try {
            // 批量删除物流费用记录
            result = shippingPriceMapperEx.batchDeleteShippingPriceByReceiptsNumbers(new Date(),
                    userInfo == null ? null : userInfo.getId(), numberArray);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }
}


