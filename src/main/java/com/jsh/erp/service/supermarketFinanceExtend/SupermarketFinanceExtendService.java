package com.jsh.erp.service.supermarketFinanceExtend;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.entities.SupermarketFinance;
import com.jsh.erp.datasource.entities.SupermarketFinanceExtend;
import com.jsh.erp.datasource.entities.SupermarketFinanceExtendExample;
import com.jsh.erp.datasource.mappers.SupermarketFinanceExtendMapper;
import com.jsh.erp.datasource.mappers.SupermarketFinanceExtendMapperEx;
import com.jsh.erp.datasource.mappers.SupermarketFinanceMapper;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class SupermarketFinanceExtendService {
    private Logger logger = LoggerFactory.getLogger(SupermarketFinanceExtendService.class);
    @Resource
    private SupermarketFinanceExtendMapper supermarketFinanceExtendMapper;
    @Resource
    private SupermarketFinanceExtendMapperEx supermarketFinanceExtendMapperEx;
    @Resource
    private SupermarketFinanceMapper supermarketFinanceMapper;
    @Resource
    private UserService userService;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void saveFinanceExtend(String rows, Long sfId, HttpServletRequest request) throws Exception {
        //删除单据的明细
        deleteFinanceExtend(sfId);
        JSONArray rowArr = JSONArray.parseArray(rows);
        if (null != rowArr && rowArr.size() > 0) {
            for (int i = 0; i < rowArr.size(); i++) {
                SupermarketFinanceExtend sfe = new SupermarketFinanceExtend();
                JSONObject tempInsertedJson = JSONObject.parseObject(rowArr.getString(i));
                sfe.setSupermarketFinanceId(sfId);
                if (tempInsertedJson.get("bankName") != null && !tempInsertedJson.get("bankName").equals("")) {
                    sfe.setBankName(tempInsertedJson.getString("bankName"));
                }
                if (tempInsertedJson.get("accountName") != null && !tempInsertedJson.get("accountName").equals("")) {
                    sfe.setAccountName(tempInsertedJson.getString("accountName"));
                }
                if (tempInsertedJson.get("accountNumber") != null && !tempInsertedJson.get("accountNumber").equals("")) {
                    sfe.setAccountNumber(tempInsertedJson.getString("accountNumber"));
                }
                if (tempInsertedJson.get("price") != null && !tempInsertedJson.get("price").equals("")) {
                    sfe.setPrice(tempInsertedJson.getBigDecimal("price"));
                }
                if (tempInsertedJson.get("proofOfPayment") != null && !tempInsertedJson.get("proofOfPayment").equals("")) {
                    sfe.setProofOfPayment(tempInsertedJson.getString("proofOfPayment"));
                }
                supermarketFinanceExtendMapper.insertSelective(sfe);
            }
        }
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void deleteFinanceExtend(Long sfId) throws Exception {
        SupermarketFinanceExtendExample example = new SupermarketFinanceExtendExample();
        example.createCriteria().andSupermarketFinanceIdEqualTo(sfId);
        try {
            supermarketFinanceExtendMapper.deleteByExample(example);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void uploadProofOfPayment(SupermarketFinanceExtend sfe, HttpServletRequest request) {
        supermarketFinanceExtendMapper.updateByPrimaryKey(sfe);
        SupermarketFinance supermarketFinance = new SupermarketFinance();
        Long sfId = sfe.getSupermarketFinanceId();
        try {
            supermarketFinance.setId(sfId);
            //更新付款状态
            int proofOfPayments = supermarketFinanceExtendMapperEx.countProofOfPayment(sfId);//获取付款凭证不为空的数量
            SupermarketFinanceExtendExample example = new SupermarketFinanceExtendExample();
            example.createCriteria().andSupermarketFinanceIdEqualTo(sfId).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
            List<SupermarketFinanceExtend> sfes = supermarketFinanceExtendMapper.selectByExample(example);
            if (sfes.size() == proofOfPayments) {//全部上传
                supermarketFinance.setPayStatus("2");
            } else if (proofOfPayments == 0) {//未上传
                supermarketFinance.setPayStatus("0");
            } else {//部分上传
                supermarketFinance.setPayStatus("1");
            }
            supermarketFinance.setUploader(userService.getCurrentUser().getId());
            supermarketFinance.setUploadTime(new Date());
            supermarketFinanceMapper.updateByPrimaryKeySelective(supermarketFinance);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
    }

    /**
     * 修改下载或结款状态
     *
     * @param ids
     * @param downloadStatus
     * @param paymentStatus
     * @param financeId
     * @param request
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void updateStatus(String ids, String downloadStatus, String paymentStatus, Long financeId, HttpServletRequest request) {
        try {
            String[] idArray = ids.split(",");
            int result = supermarketFinanceExtendMapperEx.updateStatus(idArray, downloadStatus, paymentStatus);

            //更新结款状态
            if (paymentStatus != null) {
                updatePaymentStatus(financeId, request);
            }
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
    }

    //更新结款状态
    public void updatePaymentStatus(Long sfId, HttpServletRequest request) {
        try {
            //更新结款状态
            SupermarketFinance supermarketFinance = new SupermarketFinance();

            int result = supermarketFinanceExtendMapperEx.countPaymentStatus(sfId);//获取结款状态为已结款的数量
            SupermarketFinanceExtendExample example = new SupermarketFinanceExtendExample();
            example.createCriteria().andSupermarketFinanceIdEqualTo(sfId).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
            List<SupermarketFinanceExtend> sfes = supermarketFinanceExtendMapper.selectByExample(example);
            if (sfes.size() == result) {//全部结款
                supermarketFinance.setPaymentStatus("2");
            } else if (result == 0) {//未结款
                supermarketFinance.setPaymentStatus("0");
            } else {//部分结款
                supermarketFinance.setPaymentStatus("1");
            }
            supermarketFinance.setId(sfId);
            supermarketFinance.setPaymenter(userService.getCurrentUser().getId());//结款人
            supermarketFinance.setPaymentDate(new Date());//结款时间
            supermarketFinanceMapper.updateByPrimaryKeySelective(supermarketFinance);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
    }

    public List<SupermarketFinanceExtend> getProofOfPaymentByFinanceId(Long linkId, HttpServletRequest request) {
        SupermarketFinanceExtendExample example = new SupermarketFinanceExtendExample();
        example.createCriteria().andSupermarketFinanceIdEqualTo(linkId).andDeleteFlagEqualTo(BusinessConstants.DELETE_FLAG_EXISTS);
        List<SupermarketFinanceExtend> supermarketFinanceExtends = supermarketFinanceExtendMapper.selectByExample(example);
        return supermarketFinanceExtends;
    }
}