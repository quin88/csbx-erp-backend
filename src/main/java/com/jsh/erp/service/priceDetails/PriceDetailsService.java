package com.jsh.erp.service.priceDetails;

import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.*;
import com.jsh.erp.datasource.vo.PriceDetailsVo;
import com.jsh.erp.exception.BusinessRunTimeException;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.balanceRecords.BalanceRecordsService;
import com.jsh.erp.service.log.LogService;
import com.jsh.erp.service.user.UserService;
import com.jsh.erp.utils.ResponseCode;
import com.jsh.erp.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;

@Service
public class PriceDetailsService {

    private Logger logger = LoggerFactory.getLogger(PriceDetailsService.class);

    @Resource
    private PriceDetailsMapper priceDetailsMapper;
    @Resource
    private PriceReceiptsMapper priceReceiptsMapper;
    @Resource
    private BalanceRecordsService balanceRecordsService;
    @Resource
    private PriceReceiptsMapperEx priceReceiptsMapperEx;
    @Resource
    private UserService userService;
    @Resource
    private SupplierMapper supplierMapper;
    @Resource
    private LogService logService;
    @Resource
    private PriceDetailsMapperEx priceDetailsMapperEx;
    @Resource
    private BalanceRecordsMapperEx balanceRecordsMapperEx;

    public PriceDetails getPriceDetails(Long id) {
        PriceDetails result = null;
        try {
            result = priceDetailsMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    public PriceDetailsVo selectPriceDetails(String receiptsNumbers, HttpServletRequest request) {
        PriceDetailsVo priceDetailsVo = new PriceDetailsVo();
        //查询费用明细
        PriceDetailsExample priceDetailsExample = new PriceDetailsExample();
        priceDetailsExample.createCriteria().andDeleteFlagEqualTo(BusinessConstants.DELETE_FLAG_EXISTS).andReceiptsNumberEqualTo(receiptsNumbers);
        List<PriceDetails> priceDetails = null;
        try {
            priceDetails = priceDetailsMapper.selectByExample(priceDetailsExample);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        priceDetailsVo.setPriceDetails(priceDetails);
        //查询费用单据
        PriceReceipts priceReceipts = priceReceiptsMapperEx.selectPriceReceiptsByReceiptsNumber(receiptsNumbers);
        priceDetailsVo.setPriceReceipts(priceReceipts);
        return priceDetailsVo;
    }

    /**
     * 通过单据主表编号查询缴费数据
     *
     * @param number
     * @return
     */
    public PriceDetailsVo selectPriceDetailsByDepotHeadNumber(String number) {
        PriceDetailsVo priceDetailsVo = new PriceDetailsVo();
        //查询费用明细
        PriceDetailsExample priceDetailsExample = new PriceDetailsExample();
        priceDetailsExample.createCriteria().andDeleteFlagEqualTo(BusinessConstants.DELETE_FLAG_EXISTS).andNumberEqualTo(number);
        List<PriceDetails> priceDetails = null;
        try {
            priceDetails = priceDetailsMapper.selectByExample(priceDetailsExample);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        priceDetailsVo.setPriceDetails(priceDetails);
        //查询费用单据
        PriceReceipts priceReceipts = priceReceiptsMapperEx.selectPriceReceiptsByNumber(number);
        priceDetailsVo.setPriceReceipts(priceReceipts);
        return priceDetailsVo;
    }

    /**
     * 添加费用单据和费用详情
     *
     * @param priceDetailsVo
     * @param request
     * @return
     * @throws Exception
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public Object addPriceDetails(PriceDetailsVo priceDetailsVo, String subType, HttpServletRequest request) throws Exception {

        User userInfo = userService.getCurrentUser();
        String supplier = supplierMapper.selectByPrimaryKey(priceDetailsVo.getPriceReceipts().getSupplierId()).getSupplier();
        for (PriceDetails detail : priceDetailsVo.getPriceDetails()) {
            detail.setSupplier(supplier);
            detail.setCreator(userInfo == null ? null : userInfo.getId());
            priceDetailsMapper.insertSelective(detail);
        }
        //添加费用单据信息
        PriceReceipts priceReceipts = priceDetailsVo.getPriceReceipts();
        priceReceipts.setSupplier(supplier);
        priceReceipts.setCreator(userInfo == null ? null : userInfo.getId());
        priceReceiptsMapper.insertSelective(priceReceipts);
        if ("1".equals(priceReceipts.getStatus())) {
            balanceRecordsService.subtractBalance(priceReceipts.getSupplierId(), priceReceipts.getTotalPrice(), priceReceipts.getPriceType());
        }
        return new ResponseCode(ExceptionConstants.SERVICE_SUCCESS_CODE, String.format(ExceptionConstants.SERVICE_SUCCESS_MSG));
    }

    /**
     * 编辑单据详情
     *
     * @param priceDetailsVo
     * @param request
     * @return
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public Object updatePriceDetails(PriceDetailsVo priceDetailsVo, HttpServletRequest request) throws Exception {
        List<PriceDetails> priceDetails = priceDetailsVo.getPriceDetails();
        User userInfo = userService.getCurrentUser();
        String supplier = supplierMapper.selectByPrimaryKey(priceDetailsVo.getPriceReceipts().getSupplierId()).getSupplier();
        // 获取数据库中已有的 PriceDetails 数据
        PriceDetailsExample priceDetailsExample = new PriceDetailsExample();
        priceDetailsExample.createCriteria().andReceiptsNumberEqualTo(priceDetailsVo.getPriceReceipts().getReceiptsNumber());
        List<PriceDetails> existingPriceDetails = priceDetailsMapper.selectByExample(priceDetailsExample);

        // 找出需要新增和更新的数据
        for (PriceDetails detail : priceDetails) {
            if (detail.getId() != null) {
                detail.setStatus(priceDetailsVo.getPriceReceipts().getStatus());
                detail.setUpdater(userInfo == null ? null : userInfo.getId());
                detail.setUpdateTime(new Date());
                priceDetailsMapper.updateByPrimaryKeySelective(detail);
            } else {
                detail.setSupplier(supplier);
                detail.setStatus(priceDetailsVo.getPriceReceipts().getStatus());
                detail.setCreator(userInfo == null ? null : userInfo.getId());
                detail.setCreateTime(new Date());
                priceDetailsMapper.insertSelective(detail);
            }
        }
        // 删除用户删除行，找出需要删除的数据
        Set<Long> frontendIds = new HashSet<>();
        for (PriceDetails detail : priceDetails) {
            if (detail.getId() != null) {
                frontendIds.add(detail.getId());
            }
        }
        // 创建一个List来存储需要删除的PriceDetails的id
        List<Long> ids = new ArrayList<>();
        // 遍历查询
        for (PriceDetails existingDetail : existingPriceDetails) {
            if (!frontendIds.contains(existingDetail.getId())) {
                ids.add(existingDetail.getId());
            }
        }
        // 执行批量删除操作,尚未审核通过，执行物理删除
        if (!ids.isEmpty()) {
            for (Long id : ids) {
                priceDetailsMapper.deleteByPrimaryKey(id);
            }
        }
        //更新费用单据表
        PriceReceipts priceReceipts = priceDetailsVo.getPriceReceipts();
        //查询已有的状态费用单据状态
        PriceReceipts pr = priceReceiptsMapperEx.selectPriceReceiptsByReceiptsNumber(priceReceipts.getReceiptsNumber());
        priceReceipts.setUpdater(userInfo == null ? null : userInfo.getId());
        priceReceipts.setUpdateTime(new Date());
        PriceReceiptsExample example = new PriceReceiptsExample();
        example.createCriteria().andReceiptsNumberEqualTo(priceDetailsVo.getPriceReceipts().getReceiptsNumber());
        priceReceiptsMapper.updateByExampleSelective(priceDetailsVo.getPriceReceipts(), example);

        //状态为已审核扣除供应商余额
        if ("1".equals(priceReceipts.getStatus())) {
            balanceRecordsService.subtractBalance(priceReceipts.getSupplierId(), priceReceipts.getTotalPrice(), priceReceipts.getPriceType());
        } else if ("0".equals(priceReceipts.getStatus()) && "1".equals(pr.getStatus())) {//反审核，金额回退
            balanceRecordsService.addBalanceRecords(priceReceipts.getSupplierId(), priceReceipts.getTotalPrice(), BigDecimal.ZERO);
        }
        return new ResponseCode(ExceptionConstants.SERVICE_SUCCESS_CODE, String.format(ExceptionConstants.SERVICE_SUCCESS_MSG));
    }

    /**
     * 批量设置状态-审核或者反审核
     *
     * @param status
     * @param list
     * @return
     * @throws Exception
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchSetStatus(String status, List<String> list) throws Exception {
        String[] receiptsNumberArray = StringUtil.listToStringArray(list);
        User userInfo = userService.getCurrentUser();
        int result = 0;
        try {
            result = priceDetailsMapperEx.batchSetStatusByReceiptsNumberArray(new Date(), userInfo == null ? null : userInfo.getId(), receiptsNumberArray, status);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }


    /**
     * 逻辑删除费用明细
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteById(Long id, HttpServletRequest request) throws Exception {
        return batchDeletePriceDetailByIds(id.toString());
    }

    /**
     * 批量逻辑删除费用明细
     *
     * @param ids
     * @return
     * @throws Exception
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteBatchByIds(String ids, HttpServletRequest request) throws Exception {
        return batchDeletePriceDetailByIds(ids);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeletePriceDetailByIds(String ids) throws Exception {
        String[] idArray = ids.split(",");
        User userInfo = userService.getCurrentUser();
        int result = 0;
        try {

            //逻辑删除费用明细
            result = priceDetailsMapperEx.batchDeletePriceDetailByIds(new Date(), userInfo == null ? null : userInfo.getId(), idArray);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    /**
     * 根据receipts_number批量逻辑删除
     *
     * @param receiptsNumbers
     * @return
     * @throws Exception
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeletePriceDetailByReceiptsNumber(List<String> receiptsNumbers) throws Exception {
        User userInfo = userService.getCurrentUser();
        int result = 0;

        try {
            for (String number : receiptsNumbers) {
                List<PriceDetails> list = priceDetailsMapperEx.selectListByReceiptsNumber(number);
                // 使用 Stream 进行过滤
                long unAuditCount = list.stream()
                        .filter(priceDetails -> BusinessConstants.BILLS_STATUS_AUDIT.equals(priceDetails.getStatus()) ||
                                BusinessConstants.BILLS_STATUS_UNDER_REVIEW.equals(priceDetails.getStatus()))
                        .count();
                // 判断是否有为已审核
                if (unAuditCount > 0) {
                    throw new BusinessRunTimeException(ExceptionConstants.DEPOT_HEAD_UN_AUDIT_DELETE_FAILED_CODE,
                            String.format(ExceptionConstants.DEPOT_HEAD_UN_AUDIT_DELETE_FAILED_MSG));
                }
            }
            String[] numberArray = receiptsNumbers.toArray(new String[0]);
            // 批量删除
            result = priceDetailsMapperEx.batchDeletePriceDetailByReceiptsNumbers(new Date(),
                    userInfo == null ? null : userInfo.getId(), numberArray);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }
}


