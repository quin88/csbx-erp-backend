package com.jsh.erp.service.supermarketCooperation;

import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.entities.SupermarketCooperation;
import com.jsh.erp.datasource.entities.SupermarketCooperationExample;
import com.jsh.erp.datasource.entities.User;
import com.jsh.erp.datasource.mappers.SupermarketCooperationMapper;
import com.jsh.erp.datasource.mappers.SupermarketCooperationMapperEx;
import com.jsh.erp.datasource.vo.SupermarketCooperationVoList;
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
public class SupermarketCooperationService {
    private Logger logger = LoggerFactory.getLogger(SupermarketCooperationService.class);

    @Resource
    private SupermarketCooperationMapper supermarketCooperationMapper;

    @Resource
    private SupermarketCooperationMapperEx supermarketCooperationMapperEx;

    @Resource
    private UserService userService;

    /**
     * 查询供应商的所有合作信息
     *
     * @param supplierId
     * @return
     */
    public List<SupermarketCooperation> getSupermarketCooperationList(Long supplierId) {
        SupermarketCooperationExample example = new SupermarketCooperationExample();
        example.createCriteria().andSupplierIdEqualTo(supplierId).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<SupermarketCooperation> list = null;
        try {
            list = supermarketCooperationMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    /**
     * 保存供应商合作信息
     *
     * @param cooperationList
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void saveCooperationList(Long supplierId, List<SupermarketCooperation> cooperationList) throws Exception {
        User userInfo = userService.getCurrentUser();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        //获取供应商id
        List<Long> existingIds = supermarketCooperationMapperEx.getExistingIds(supplierId);

        List<Long> idList = new ArrayList<>();
        try {
            if (cooperationList != null && cooperationList.size() > 0) {
                for (SupermarketCooperation cooperation : cooperationList) {
                    cooperation.setUpdater(userInfo == null ? null : userInfo.getId());
                    cooperation.setUpdateTime(timestamp);
                    if (cooperation.getId() == null) {
                        cooperation.setCreator(userInfo == null ? null : userInfo.getId());
                        cooperation.setCreateTime(timestamp);
                        supermarketCooperationMapper.insertSelective(cooperation);
                    } else {
                        supermarketCooperationMapper.updateByPrimaryKeySelective(cooperation);
                        idList.add(cooperation.getId());
                    }
                }
            }
            if (!existingIds.isEmpty()) {
                List<Long> ids = existingIds.stream().filter(id -> !idList.contains(id)).collect(Collectors.toList());
                if (!ids.isEmpty()) {
                    supermarketCooperationMapperEx.batchDeleteSupermarketCooperationByIds(new Date(), userInfo == null ? null : userInfo.getId(), ids);
                }
            }
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
    }

    /**
     * 批量删除对应的合作信息
     *
     * @param supplierIds
     * @return
     */
    public int batchDeleteSupermarketCooperationBySupplierIds(String[] supplierIds) throws Exception {
        User userInfo = userService.getCurrentUser();
        int result = 0;
        try {
            result = supermarketCooperationMapperEx.batchDeleteSupermarketCooperationBySupplierIds(new Date(), userInfo == null ? null : userInfo.getId(), supplierIds);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    public List<SupermarketCooperationVoList> findByAll(List<Long> supplierIds) {
        List<SupermarketCooperationVoList> list = null;
        try {
            list = supermarketCooperationMapperEx.findByAll(supplierIds);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }
}
