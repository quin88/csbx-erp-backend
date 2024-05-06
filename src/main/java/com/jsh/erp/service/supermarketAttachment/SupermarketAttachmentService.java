package com.jsh.erp.service.supermarketAttachment;

import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.entities.SupermarketAttachment;
import com.jsh.erp.datasource.entities.SupermarketAttachmentExample;
import com.jsh.erp.datasource.entities.User;
import com.jsh.erp.datasource.mappers.SupermarketAttachmentMapper;
import com.jsh.erp.datasource.mappers.SupermarketAttachmentMapperEx;
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
public class SupermarketAttachmentService {
    private Logger logger = LoggerFactory.getLogger(SupermarketAttachmentService.class);

    @Resource
    private SupermarketAttachmentMapper supermarketAttachmentMapper;

    @Resource
    private SupermarketAttachmentMapperEx supermarketAttachmentMapperEx;

    @Resource
    private UserService userService;

    /**
     * 查询供应商的所有附件信息
     *
     * @param supplierId
     * @return
     */
    public List<SupermarketAttachment> getSupermarketAttachmentList(Long supplierId) {
        SupermarketAttachmentExample example = new SupermarketAttachmentExample();
        example.createCriteria().andSupplierIdEqualTo(supplierId).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<SupermarketAttachment> list = null;
        try {
            list = supermarketAttachmentMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    /**
     * 新增供应商附件
     *
     * @param attachmentList
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void saveAttachmentList(Long supplierId, List<SupermarketAttachment> attachmentList) throws Exception {
        User userInfo = userService.getCurrentUser();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        //获取供应商id
        List<Long> existingIds = supermarketAttachmentMapperEx.getExistingIds(supplierId);

        List<Long> idList = new ArrayList<>();
        try {
            if (attachmentList != null && attachmentList.size() > 0) {
                for (SupermarketAttachment attachment : attachmentList) {
                    attachment.setUpdater(userInfo == null ? null : userInfo.getId());
                    attachment.setUpdateTime(timestamp);
                    if (attachment.getId() == null) {
                        attachment.setCreator(userInfo == null ? null : userInfo.getId());
                        attachment.setCreateTime(timestamp);
                        supermarketAttachmentMapper.insertSelective(attachment);
                    } else {
                        supermarketAttachmentMapper.updateByPrimaryKeySelective(attachment);
                        idList.add(attachment.getId());
                    }
                }
            }
            if (!existingIds.isEmpty()) {
                List<Long> ids = existingIds.stream().filter(id -> !idList.contains(id)).collect(Collectors.toList());
                if (!ids.isEmpty()) {
                    supermarketAttachmentMapperEx.batchDeleteSupermarketAttachmentByIds(new Date(), userInfo == null ? null : userInfo.getId(), ids);
                }
            }
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
    }

    /**
     * 批量删除对应的附件信息
     *
     * @param supplierIds
     * @return
     */
    public int batchDeleteSupermarketAttachmentBySupplierIds(String[] supplierIds) throws Exception {
        User userInfo = userService.getCurrentUser();
        int result = 0;
        try {
            result = supermarketAttachmentMapperEx.batchDeleteSupermarketAttachmentBySupplierIds(new Date(), userInfo == null ? null : userInfo.getId(), supplierIds);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

}
