package com.jsh.erp.service.orderDocument;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.dto.OrderDocumentDTO;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.OrderDocumentMapper;
import com.jsh.erp.datasource.mappers.SupermarketOrderMapper;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderDocumentService {
    private final Logger logger = LoggerFactory.getLogger(OrderDocumentService.class);

    @Resource
    private UserService userService;
    @Resource
    private OrderDocumentMapper orderDocumentMapper;
    @Value(value = "${file.path}")
    private String filePath;
    @Resource
    private SupermarketOrderMapper supermarketOrderMapper;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public Object saveOrderDocument(OrderDocumentDTO orderDocumentDTO, HttpServletRequest request) throws Exception {
        List<OrderDocument> list = orderDocumentDTO.getOrderDocuments();
        Long orderId = orderDocumentDTO.getOrderId();

        User user = userService.getCurrentUser();
        OrderDocumentExample example = new OrderDocumentExample();
        example.createCriteria().andOrderIdEqualTo(orderId);
        List<OrderDocument> orderDocumentList = orderDocumentMapper.selectByExample(example);
        for (OrderDocument orderDocument : orderDocumentList) {
            deleteFile(orderDocument.getFile());// 删除文件
        }
        //删除已有的数据
        deleteOrderDocuments(orderId);

        boolean hasType0 = false;//确认单据判断状态
        boolean hasType1 = false;//支付款单据判断状态
        for (OrderDocument orderDocument : list) {
            orderDocumentMapper.insertSelective(orderDocument);
            if ("0".equals(orderDocument.getType())) {
                hasType0 = true;
            } else if ("1".equals(orderDocument.getType())) {
                hasType1 = true;
            }
        }
        if (hasType0 || hasType1) {
            updateOrderStatus(orderId, BusinessConstants.USER_STATUS_ALL);//已上传
        } else {
            updateOrderStatus(orderId, BusinessConstants.UPLOAD_STATUS_NO);//未上传
        }

        return ExceptionConstants.standardSuccess();
    }

    private void updateOrderStatus(Long id, String status) {
        SupermarketOrder supermarketOrder = supermarketOrderMapper.selectByPrimaryKey(id);
        supermarketOrder.setUploadStatus(status);
        supermarketOrderMapper.updateByPrimaryKeySelective(supermarketOrder);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void deleteOrderDocuments(Long id) throws Exception {
        OrderDocumentExample example = new OrderDocumentExample();
        example.createCriteria().andOrderIdEqualTo(id);
        try {
            orderDocumentMapper.deleteByExample(example);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
    }

    private void deleteFile(String fileName) {
        String fileUrl = filePath + File.separator + fileName;
        File file = new File(fileUrl);
        if (file.exists() && file.isFile()) {
            file.delete();
        }
    }

    public Map<String, Object> getOrderDocument(Long orderId, HttpServletRequest request) {
        OrderDocumentExample example = new OrderDocumentExample();
        example.createCriteria().andOrderIdEqualTo(orderId).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<OrderDocument> list = orderDocumentMapper.selectByExample(example);
        // 分别存储类型为 0 和类型为 1 的数据
        JSONArray type0 = new JSONArray();
        JSONArray type1 = new JSONArray();

        for (OrderDocument orderDocument : list) {
            JSONObject orderDocumentJson = (JSONObject) JSONObject.toJSON(orderDocument);
            if ("0".equals(orderDocument.getType())) {
                // 类型为 0 的数据
                type0.add(orderDocumentJson);
            } else if ("1".equals(orderDocument.getType())) {
                // 类型为 1 的数据
                type1.add(orderDocumentJson);
            }
        }
        // 将两个数组放入 Map 中返回
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("q", type0);//确认单
        resultMap.put("c", type1);//采购款

        return resultMap;
    }
}
