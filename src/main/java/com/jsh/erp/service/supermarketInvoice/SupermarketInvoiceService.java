package com.jsh.erp.service.supermarketInvoice;

import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.entities.SupermarketInvoice;
import com.jsh.erp.datasource.entities.SupermarketInvoiceExample;
import com.jsh.erp.datasource.entities.User;
import com.jsh.erp.datasource.mappers.SupermarketInvoiceMapper;
import com.jsh.erp.datasource.mappers.SupermarketInvoiceMapperEx;
import com.jsh.erp.datasource.vo.SupermarketInvoiceVoList;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupermarketInvoiceService {
    private Logger logger = LoggerFactory.getLogger(SupermarketInvoiceService.class);

    @Resource
    private SupermarketInvoiceMapper supermarketInvoiceMapper;

    @Resource
    private SupermarketInvoiceMapperEx supermarketInvoiceMapperEx;

    @Resource
    private UserService userService;

    /**
     * 查询供应商所有的发票信息
     *
     * @param supplierId
     * @return
     */
    public List<SupermarketInvoice> getSupermarketInvoiceList(Long supplierId) {
        SupermarketInvoiceExample example = new SupermarketInvoiceExample();
        example.createCriteria().andSupplierIdEqualTo(supplierId).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<SupermarketInvoice> list = null;
        try {
            list = supermarketInvoiceMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    /**
     * 保存供应商发票信息
     *
     * @param invoiceList
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void saveInvoiceList(Long supplierId, List<SupermarketInvoice> invoiceList) throws Exception {
        User userInfo = userService.getCurrentUser();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        //获取供应商id
        List<Long> existingIds = supermarketInvoiceMapperEx.getExistingIds(supplierId);

        List<Long> idList = new ArrayList<>();
        try {
            if (invoiceList != null && invoiceList.size() > 0) {
                for (SupermarketInvoice invoice : invoiceList) {
                    invoice.setUpdater(userInfo == null ? null : userInfo.getId());
                    invoice.setUpdateTime(timestamp);
                    if (invoice.getId() == null) {
                        invoice.setCreator(userInfo == null ? null : userInfo.getId());
                        invoice.setCreateTime(timestamp);
                        supermarketInvoiceMapper.insertSelective(invoice);
                    } else {
                        supermarketInvoiceMapper.updateByPrimaryKeySelective(invoice);
                        idList.add(invoice.getId());
                    }
                }
            }
            if (!existingIds.isEmpty()) {
                List<Long> ids = existingIds.stream().filter(id -> !idList.contains(id)).collect(Collectors.toList());
                if (!ids.isEmpty()) {
                    supermarketInvoiceMapperEx.batchDeleteSupermarketInvoiceByIds(new Date(), userInfo == null ? null : userInfo.getId(), ids);
                }
            }
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
    }

    /**
     * 批量删除对应的发票信息
     *
     * @param supplierIds
     * @return
     * @throws Exception
     */
    public int batchDeleteSupermarketInvoiceBySupplierIds(String[] supplierIds) throws Exception {
        User userInfo = userService.getCurrentUser();
        int result = 0;
        try {
            result = supermarketInvoiceMapperEx.batchDeleteSupermarketInvoiceBySupplierIds(new Date(), userInfo == null ? null : userInfo.getId(), supplierIds);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    public List<SupermarketInvoiceVoList> findByAll(List<Long> supplierIds) {
        List<SupermarketInvoiceVoList> list = null;
        try {
            list = supermarketInvoiceMapperEx.findByAll(supplierIds);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }
}
