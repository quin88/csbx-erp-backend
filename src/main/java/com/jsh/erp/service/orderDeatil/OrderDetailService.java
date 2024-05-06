package com.jsh.erp.service.orderDeatil;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.dto.OrderDetailDTO;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.OrderDetailMapper;
import com.jsh.erp.datasource.mappers.SupermarketOrderMapper;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.user.UserService;
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
public class OrderDetailService {
    private final Logger logger = LoggerFactory.getLogger(OrderDetailService.class);

    @Resource
    private UserService userService;
    @Resource
    private OrderDetailMapper orderDetailMapper;
    @Resource
    private SupermarketOrderMapper supermarketOrderMapper;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void saveOrderDetails(String rows, Long soIds, HttpServletRequest request) throws Exception {
        //删除单据的明细
        deleteOrderDetails(soIds);

        BigDecimal nakedPriceTotal = BigDecimal.ZERO; // 裸价总计
        BigDecimal taxInclusiveTotal = BigDecimal.ZERO; // 税后总计
        JSONArray rowArr = JSONArray.parseArray(rows);
        if (null != rowArr && rowArr.size() > 0) {
            for (int i = 0; i < rowArr.size(); i++) {
                OrderDetail orderDetails = new OrderDetail();
                JSONObject tempInsertedJson = JSONObject.parseObject(rowArr.getString(i));
                orderDetails.setOrderId(soIds);
                if (tempInsertedJson.get("supplierId") != null && !tempInsertedJson.get("supplierId").equals("")) {
                    orderDetails.setSupplierId(tempInsertedJson.getLong("supplierId"));
                }
                if (tempInsertedJson.get("materialId") != null && !tempInsertedJson.get("materialId").equals("")) {
                    orderDetails.setMaterialId(tempInsertedJson.getLong("materialId"));
                }
                if (tempInsertedJson.get("aquaticType") != null && !tempInsertedJson.get("aquaticType").equals("")) {
                    orderDetails.setAquaticType(tempInsertedJson.getString("aquaticType"));
                }
                if (tempInsertedJson.get("originSource") != null && !tempInsertedJson.get("originSource").equals("")) {
                    orderDetails.setOriginSource(tempInsertedJson.getString("originSource"));
                }
                if (tempInsertedJson.get("quantity") != null && !tempInsertedJson.get("quantity").equals("")) {
                    orderDetails.setQuantity(tempInsertedJson.getBigDecimal("quantity"));
                }
                if (tempInsertedJson.get("unit") != null && !tempInsertedJson.get("unit").equals("")) {
                    orderDetails.setUnit(tempInsertedJson.getString("unit"));
                }
                if (tempInsertedJson.get("unitPrice") != null && !tempInsertedJson.get("unitPrice").equals("")) {
                    orderDetails.setUnitPrice(tempInsertedJson.getBigDecimal("unitPrice"));
                }
                if (tempInsertedJson.get("accountId") != null && !tempInsertedJson.get("accountId").equals("")) {
                    orderDetails.setAccountId(tempInsertedJson.getLong("accountId"));
                }
                if (tempInsertedJson.get("bankName") != null && !tempInsertedJson.get("bankName").equals("")) {
                    orderDetails.setBankName(tempInsertedJson.getString("bankName"));
                }
                if (tempInsertedJson.get("accountName") != null && !tempInsertedJson.get("accountName").equals("")) {
                    orderDetails.setAccountName(tempInsertedJson.getString("accountName"));
                }
                // 小计
                BigDecimal nakedPrice = tempInsertedJson.getBigDecimal("nakedPrice");
                if (tempInsertedJson.get("nakedPrice") != null && !tempInsertedJson.get("nakedPrice").equals("")) {
                    orderDetails.setNakedPrice(nakedPrice);
                }
                // 税后单价
                BigDecimal taxUnitPrice = tempInsertedJson.getBigDecimal("taxUnitPrice");
                if (tempInsertedJson.get("taxUnitPrice") != null && !tempInsertedJson.get("taxUnitPrice").equals("")) {
                    orderDetails.setTaxUnitPrice(taxUnitPrice);
                }
                // 税后小计
                BigDecimal taxNakedPrice = tempInsertedJson.getBigDecimal("taxNakedPrice");
                if (tempInsertedJson.get("taxNakedPrice") != null && !tempInsertedJson.get("taxNakedPrice").equals("")) {
                    orderDetails.setTaxNakedPrice(taxNakedPrice);
                }
                //差额
                if (tempInsertedJson.get("difference") != null && !tempInsertedJson.get("difference").equals("")) {
                    orderDetails.setDifference(tempInsertedJson.getBigDecimal("difference"));
                }
                //补额
                if (tempInsertedJson.get("supplementaryAmount") != null && !tempInsertedJson.get("supplementaryAmount").equals("")) {
                    orderDetails.setSupplementaryAmount(tempInsertedJson.getBigDecimal("supplementaryAmount"));
                }

                nakedPriceTotal = nakedPriceTotal.add(nakedPrice);//统计-总计
                taxInclusiveTotal = taxInclusiveTotal.add(taxNakedPrice);//统计-税后总计

                orderDetailMapper.insertSelective(orderDetails);
            }
            SupermarketOrder supermarketOrder = new SupermarketOrder();
            supermarketOrder.setId(soIds);
            supermarketOrder.setNakedPriceTotal(nakedPriceTotal);
            supermarketOrder.setTaxInclusiveTotal(taxInclusiveTotal);
            supermarketOrderMapper.updateByPrimaryKeySelective(supermarketOrder);//更新商超订单数据
        }
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void deleteOrderDetails(Long soIds) throws Exception {
        OrderDetailExample example = new OrderDetailExample();
        example.createCriteria().andOrderIdEqualTo(soIds);
        try {
            orderDetailMapper.deleteByExample(example);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
    }

    public int batchDeleteOrderDetails(String[] idArray) throws Exception {
        User userInfo = userService.getCurrentUser();
        List<Long> longList = Arrays.stream(idArray)
                .map(Long::valueOf)
                .collect(Collectors.toList());
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDeleteFlag(BusinessConstants.DELETE_FLAG_DELETED);
        OrderDetailExample example = new OrderDetailExample();
        example.createCriteria().andOrderIdIn(longList);
        int result = 0;
        try {
            result = orderDetailMapper.updateByExampleSelective(orderDetail, example);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    public void updateOrderDetailDifference(OrderDetailDTO orderDetailDTO) {
        BigDecimal difference = orderDetailDTO.getDifference();//当前差额
        OrderDetail orderDetail = orderDetailMapper.selectByPrimaryKey(orderDetailDTO.getId());
        orderDetail.setDifference(difference);
        orderDetailMapper.updateByPrimaryKey(orderDetail);
    }
}
