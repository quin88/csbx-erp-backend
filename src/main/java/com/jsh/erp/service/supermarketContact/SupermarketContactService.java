package com.jsh.erp.service.supermarketContact;

import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.entities.SupermarketContact;
import com.jsh.erp.datasource.entities.SupermarketContactExample;
import com.jsh.erp.datasource.entities.User;
import com.jsh.erp.datasource.mappers.SupermarketContactMapper;
import com.jsh.erp.datasource.mappers.SupermarketContactMapperEx;
import com.jsh.erp.datasource.vo.SupermarketContactVoList;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SupermarketContactService {
    private Logger logger = LoggerFactory.getLogger(SupermarketContactService.class);

    @Resource
    private SupermarketContactMapper supermarketContactMapper;

    @Resource
    private SupermarketContactMapperEx supermarketContactMapperEx;

    @Resource
    private UserService userService;

    /**
     * 查询供应商的所有联系人信息
     *
     * @param supplierId
     * @return
     */
    public List<SupermarketContact> getSupermarketContactList(Long supplierId) {
        SupermarketContactExample example = new SupermarketContactExample();
        example.createCriteria().andSupplierIdEqualTo(supplierId).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<SupermarketContact> list = null;
        try {
            list = supermarketContactMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void saveContactList(Long supplierId, List<SupermarketContact> contactList) throws Exception {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        User userInfo = userService.getCurrentUser();

        List<Long> existingIds = supermarketContactMapperEx.getExistingIds(supplierId);
        List<Long> idList = new ArrayList<>();
        try {
            if (contactList != null && contactList.size() > 0) {
                for (SupermarketContact contact : contactList) {
                    contact.setUpdater(userInfo == null ? null : userInfo.getId());
                    contact.setUpdateTime(timestamp);
                    if (contact.getId() == null) {
                        contact.setCreator(userInfo == null ? null : userInfo.getId());
                        contact.setCreateTime(timestamp);
                        supermarketContactMapper.insertSelective(contact);
                    } else {
                        supermarketContactMapper.updateByPrimaryKeySelective(contact);
                        idList.add(contact.getId());
                    }
                }
            }
            if (!existingIds.isEmpty()) {
                List<Long> ids = existingIds.stream().filter(id -> !idList.contains(id)).collect(Collectors.toList());
                if (!ids.isEmpty()) {
                    supermarketContactMapperEx.batchDeleteSupermarketContactByIds(new Date(), userInfo == null ? null : userInfo.getId(), ids);
                }
            }
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
    }

    /**
     * 批量删除供应商对应的联系人信息
     *
     * @param supplierIds
     * @return
     */
    public int batchDeleteSupermarketContactBySupplierIds(String[] supplierIds) throws Exception {
        User userInfo = userService.getCurrentUser();
        int result = 0;
        try {
            result = supermarketContactMapperEx.batchDeleteSupermarketContactBySupplierIds(new Date(), userInfo == null ? null : userInfo.getId(), supplierIds);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    public List<SupermarketContactVoList> findByAll(List<Long> supplierIds) {
        List<SupermarketContactVoList> list = null;
        try {
            list = supermarketContactMapperEx.findByAll(supplierIds);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }
}
