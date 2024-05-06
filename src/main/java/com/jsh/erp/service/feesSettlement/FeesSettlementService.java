package com.jsh.erp.service.feesSettlement;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.*;
import com.jsh.erp.exception.BusinessRunTimeException;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.log.LogService;
import com.jsh.erp.service.supplier.SupplierService;
import com.jsh.erp.service.user.UserService;
import com.jsh.erp.utils.SendDingDingUtils;
import com.jsh.erp.utils.StringUtil;
import com.jsh.erp.utils.Tools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class FeesSettlementService {
    private Logger logger = LoggerFactory.getLogger(FeesSettlementService.class);

    @Resource
    private FeesSettlementMapper feesSettlementMapper;
    @Resource
    private FeesSettlementMapperEx feesSettlementMapperEx;
    @Resource
    private SupplierMapperEx supplierMapperEx;
    @Resource
    private LogService logService;
    @Resource
    private UserService userService;
    @Resource
    private AccountHeadMapperEx accountHeadMapperEx;
    @Resource
    private SupplierMapper supplierMapper;
    @Resource
    private SupplierService supplierService;
    @Resource
    private DepotHeadMapperEx depotHeadMapperEx;
    @Value("${SUPPLIER.CHECK.LINK}")
    private String supplier_check_link;
    @Value("${DINGDING.WEBHOOK.COLD.BACKEND}")
    private String webhookToColdBackend;
    @Value("${DINGDING.WEBHOOK.COLD.MINI.PROGRAMS}")
    private String webhookToMiniPrograms;
    @Resource
    private SendDingDingUtils sendDingDingUtils;

    public Object getFeesSettlement(Long id) {
        FeesSettlement result = null;
        try {
            result = feesSettlementMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertFeesSettlement(JSONObject obj, HttpServletRequest request) {
        FeesSettlement feesSettlement = JSONObject.parseObject(obj.toJSONString(), FeesSettlement.class);
        int result = 0;
        try {
            result = feesSettlementMapper.insertSelective(feesSettlement);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateFeesSettlement(JSONObject obj, HttpServletRequest request) {
        FeesSettlement feesSettlement = JSONObject.parseObject(obj.toJSONString(), FeesSettlement.class);
        int result = 0;
        try {
            result = feesSettlementMapper.updateByPrimaryKeySelective(feesSettlement);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    public int deleteFeesSettlement(Long id, HttpServletRequest request) {
        int result = 0;
        try {
            result = feesSettlementMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    public int batchDeleteFeesSettlement(String ids, HttpServletRequest request) {
        List<Long> idList = StringUtil.strToLongList(ids);
        FeesSettlementExample example = new FeesSettlementExample();
        example.createCriteria().andIdIn(idList);
        int result = 0;
        try {
            result = feesSettlementMapper.deleteByExample(example);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    public int batchDeleteSupplierAndFeesSettlement(String ids, HttpServletRequest request) {
        List<Long> idList = StringUtil.strToLongList(ids);
        FeesSettlementExample example = new FeesSettlementExample();
        example.createCriteria().andSupplierIdIn(idList);
        int result = 0;
        try {
            result = feesSettlementMapper.deleteByExample(example);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int addSupplierAndFeesSettlement(Supplier supplier, List<FeesSettlement> feesSettlements, HttpServletRequest request) {
        int result = 0;

        supplier.setEnabled(false);
        //如果来源为PC端，相同手机号则只能创建一个供应商（启用状态）
        if (!BusinessConstants.ORIGIN_TYPE.equals(supplier.getOriginType()) && "供应商".equals(supplier.getType())) {
            int number = supplierMapperEx.getSupplierNumberByPhone(supplier.getTelephone(),0L);
            if (number > 0) {
                throw new BusinessRunTimeException(ExceptionConstants.USER_LOGIN_PHONE_ALREADY_EXISTS_CODE,
                        ExceptionConstants.USER_LOGIN_PHONE_ALREADY_EXISTS_MSG);
            }
        }
        try {
            result = supplierMapper.insertSelective(supplier);
            logService.insertLog("商家",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ADD).append(supplier.getSupplier()).toString(), request);

            //根据供应商名称查询供应商id
            SupplierExample supplierExample = new SupplierExample();
            supplierExample.createCriteria().andSupplierEqualTo(supplier.getSupplier()).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
            List<Supplier> list = supplierMapper.selectByExample(supplierExample);
            if (list != null) {
                Long supplierId = list.get(0).getId();
                /**保存供应商结算方式信息*/
                saveFeesSettlement(feesSettlements, supplierId, request);
            }
            String supplierName = supplier.getSupplier();
            String originType = supplier.getOriginType();
            Date now = new Date();
            Long tenantId = userService.getCurrentUser().getTenantId();
            String status = supplier.getCheckStatus();
            //如果租户为城市佰兴，来源为小程序，则发送钉钉通知操作员审核(小程序群)
            if (tenantId == 146 && BusinessConstants.ORIGIN_TYPE.equals(originType)&&
                    status.equals(BusinessConstants.BILLS_STATUS_UN_AUDIT)) {
                String content = "审核页面：供应商审核" + "\n" +
                        "客户：" + supplierName + "\n" +
                        "来源：" + originType + "\n" +
                        "时间：" + Tools.parseDateToStr(now) + "\n" +
                        "链接：" + supplier_check_link;
                sendDingDingUtils.sendDingDingUtils(content, webhookToMiniPrograms);
            }
            if (tenantId == 146 && !BusinessConstants.ORIGIN_TYPE.equals(originType)&&
                    status.equals(BusinessConstants.BILLS_STATUS_UN_AUDIT)) {
                //发钉钉通知(后台群)
                String content = "审核页面：供应商审核" + "\n" +
                        "客户：" + supplierName + "\n" +
                        "来源：PC端" + "\n" +
                        "时间：" + Tools.parseDateToStr(now) + "\n" +
                        "链接：" + supplier_check_link;
                sendDingDingUtils.sendDingDingUtils(content, webhookToColdBackend);
            }
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void saveFeesSettlement(List<FeesSettlement> feesSettlements, Long supplierId, HttpServletRequest request) throws Exception {
        if (feesSettlements != null) {
            for (FeesSettlement feesSettlement : feesSettlements) {
                feesSettlement.setSupplierId(supplierId);
                Date date = new Date();
                feesSettlement.setCreateTime(date);
                feesSettlement.setUpdateTime(date);
                User userInfo = userService.getCurrentUser();
                feesSettlement.setCreator(userInfo == null ? null : userInfo.getId());
                feesSettlement.setUpdater(userInfo == null ? null : userInfo.getId());
                try {
                    feesSettlementMapper.insertSelective(feesSettlement);
                } catch (Exception e) {
                    JshException.readFail(logger, e);
                }
            }
        }
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateSupplierAndFeesSettlement(Supplier supplier, List<FeesSettlement> feesSettlements, HttpServletRequest request) throws Exception {
        int result = 0;
        if (supplier.getBeginNeedPay() == null) {
            supplier.setBeginNeedPay(BigDecimal.ZERO);
        }
        if (supplier.getBeginNeedGet() == null) {
            supplier.setBeginNeedGet(BigDecimal.ZERO);
        }
        //如果来源为PC端，相同手机号则只能创建一个供应商（启用状态）
        if (!BusinessConstants.ORIGIN_TYPE.equals(supplier.getOriginType()) && "供应商".equals(supplier.getType())) {
            int number = supplierMapperEx.getSupplierNumberByPhone(supplier.getTelephone(),supplier.getId());
            if (number > 0) {
                throw new BusinessRunTimeException(ExceptionConstants.USER_LOGIN_PHONE_ALREADY_EXISTS_CODE,
                        ExceptionConstants.USER_LOGIN_PHONE_ALREADY_EXISTS_MSG);
            }
        }
        try {
            supplierMapper.updateByPrimaryKeySelective(supplier);
            logService.insertLog("商家",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(supplier.getSupplier()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        /**更新供应商费用结算方式*/
        Long supplierId = supplier.getId();
        try {
            result = updateFeesSettlement(feesSettlements, supplierId, request);
            String supplierName = supplier.getSupplier();
            String originType = supplier.getOriginType();
            Date now = new Date();
            Long tenantId = userService.getCurrentUser().getTenantId();
            String status = supplier.getCheckStatus();
            //如果租户为城市佰兴，来源为小程序，则发送钉钉通知操作员审核(小程序群)
            if (tenantId == 146 && BusinessConstants.ORIGIN_TYPE.equals(originType)&&
                    status.equals(BusinessConstants.BILLS_STATUS_UN_AUDIT)) {
                String content = "审核页面：供应商审核" + "\n" +
                        "客户：" + supplierName + "\n" +
                        "来源：" + originType + "\n" +
                        "时间：" + Tools.parseDateToStr(now) + "\n" +
                        "链接：" + supplier_check_link;
                sendDingDingUtils.sendDingDingUtils(content, webhookToMiniPrograms);
            }
            if (tenantId == 146 && !BusinessConstants.ORIGIN_TYPE.equals(originType)&&
                    status.equals(BusinessConstants.BILLS_STATUS_UN_AUDIT)) {
                //发钉钉通知(后台群)
                String content = "审核页面：供应商审核" + "\n" +
                        "客户：" + supplierName + "\n" +
                        "来源：PC端" + "\n" +
                        "时间：" + Tools.parseDateToStr(now) + "\n" +
                        "链接：" + supplier_check_link;
                sendDingDingUtils.sendDingDingUtils(content, webhookToColdBackend);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateFeesSettlement(List<FeesSettlement> feesSettlements, Long supplierId, HttpServletRequest request) throws Exception {
        int result = 0;
        if (feesSettlements != null && !feesSettlements.isEmpty()) {
            FeesSettlementExample example = new FeesSettlementExample();
            example.createCriteria().andSupplierIdEqualTo(supplierId).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);

            // 获取数据库原有的数据，使用流式操作将其转换为 Map
            Map<Long, FeesSettlement> map = feesSettlementMapper.selectByExample(example)
                    .stream().collect(Collectors.toMap(FeesSettlement::getId, java.util.function.Function.identity()));
            Set<Long> ids = map.keySet();

            Date date = new Date();
            User userInfo = userService.getCurrentUser();

            for (FeesSettlement feesSettlement : feesSettlements) {
                Long id = feesSettlement.getId();
                if (id != null && map.containsKey(id)) {
                    feesSettlement.setUpdateTime(date);
                    feesSettlement.setUpdater(userInfo == null ? null : userInfo.getId());

                    // 更新现有记录
                    feesSettlementMapper.updateByPrimaryKeySelective(feesSettlement);
                    ids.removeIf(key -> key.equals(id));
                } else {
                    // 插入新记录
                    feesSettlement.setSupplierId(supplierId);
                    feesSettlement.setCreateTime(date);
                    feesSettlement.setCreator(userInfo == null ? null : userInfo.getId());
                    feesSettlement.setUpdateTime(date);
                    feesSettlement.setUpdater(userInfo == null ? null : userInfo.getId());

                    feesSettlementMapper.insertSelective(feesSettlement);
                }
            }
            //删除旧记录
            for (Long fsId : ids) {
                result = feesSettlementMapperEx.deleteByPrimaryKey(new Date(), userInfo == null ? null : userInfo.getId(), fsId);
            }
        }
        return result;
    }


    /**
     * 根据供应商id查询所属结算方式
     *
     * @param supplierId
     * @return
     */
    public List<FeesSettlementEx> findBySupplierId(Long supplierId) {
        List<FeesSettlementEx> list = null;
        try {
            list = feesSettlementMapperEx.selectBySupplierId(supplierId);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteSupplierByIds(String ids, HttpServletRequest request) throws Exception {
        int result = 0;
        String[] idArray = ids.split(",");
        //校验财务主表	jsh_accounthead
        List<AccountHead> accountHeadList = null;
        try {
            accountHeadList = accountHeadMapperEx.getAccountHeadListByOrganIds(idArray);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        if (accountHeadList != null && accountHeadList.size() > 0) {
            logger.error("异常码[{}],异常提示[{}],参数,OrganIds[{}]",
                    ExceptionConstants.DELETE_FORCE_CONFIRM_CODE, ExceptionConstants.DELETE_FORCE_CONFIRM_MSG, ids);
            throw new BusinessRunTimeException(ExceptionConstants.DELETE_FORCE_CONFIRM_CODE,
                    ExceptionConstants.DELETE_FORCE_CONFIRM_MSG);
        }
        //校验单据主表	jsh_depot_head
        List<DepotHead> depotHeadList = null;
        try {
            depotHeadList = depotHeadMapperEx.getDepotHeadListByOrganIds(idArray);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        if (depotHeadList != null && depotHeadList.size() > 0) {
            logger.error("异常码[{}],异常提示[{}],参数,OrganIds[{}]",
                    ExceptionConstants.DELETE_FORCE_CONFIRM_CODE, ExceptionConstants.DELETE_FORCE_CONFIRM_MSG, ids);
            throw new BusinessRunTimeException(ExceptionConstants.DELETE_FORCE_CONFIRM_CODE,
                    ExceptionConstants.DELETE_FORCE_CONFIRM_MSG);
        }
        //记录日志
        StringBuffer sb = new StringBuffer();
        sb.append(BusinessConstants.LOG_OPERATION_TYPE_DELETE);
        List<Supplier> list = supplierService.getSupplierListByIds(ids);
        for (Supplier supplier : list) {
            sb.append("[").append(supplier.getSupplier()).append("]");
        }
        logService.insertLog("商家", sb.toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        User userInfo = userService.getCurrentUser();
        //校验通过执行删除操作
        try {
            result = supplierMapperEx.batchDeleteSupplierByIds(new Date(), userInfo == null ? null : userInfo.getId(), idArray);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        /**供应商信息删除成功，费用信息一并删除*/
        if (1 == result) {
            try {
                result = feesSettlementMapperEx.batchDeleteBySupplierIds(new Date(), userInfo == null ? null : userInfo.getId(), idArray);
            } catch (Exception e) {
                JshException.writeFail(logger, e);
            }
        }
        return result;
    }
}
