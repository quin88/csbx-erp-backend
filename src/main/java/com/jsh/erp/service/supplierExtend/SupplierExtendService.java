package com.jsh.erp.service.supplierExtend;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.api.AliyunSignature;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.SupplierExtendMapper;
import com.jsh.erp.datasource.mappers.SupplierExtendMapperEx;
import com.jsh.erp.datasource.mappers.SupplierMapper;
import com.jsh.erp.datasource.mappers.SupplierMapperEx;
import com.jsh.erp.datasource.vo.SupplierExtendVoList;
import com.jsh.erp.datasource.vo.UserVo;
import com.jsh.erp.exception.BusinessRunTimeException;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.log.LogService;
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
import java.util.*;

import static com.jsh.erp.utils.Tools.getCenternTime;

@Service
public class SupplierExtendService {
    private Logger logger = LoggerFactory.getLogger(SupplierExtendService.class);

    @Resource
    private LogService logService;
    @Resource
    private SupplierExtendMapper supplierExtendMapper;
    @Resource
    private SupplierExtendMapperEx supplierExtendMapperEx;
    @Resource
    private UserService userService;
    @Value("${SUPPLIER.EXTEND.CHECK.LINK}")
    private String supplier_extend_check_link;
    @Value("${DINGDING.WEBHOOK.COLD.BACKEND}")
    private String webhookToColdBackend;
    @Value("${DINGDING.WEBHOOK.COLD.MINI.PROGRAMS}")
    private String webhookToMiniPrograms;
    @Resource
    private SendDingDingUtils sendDingDingUtils;
    @Resource
    private SupplierMapperEx supplierMapperEx;
    @Resource
    private SupplierMapper supplierMapper;

    public SupplierExtend getSupplierExtend(Long id) {
        SupplierExtend result = null;
        try {
            result = supplierExtendMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertSupplierExtend(JSONObject obj, HttpServletRequest request) throws Exception {
        SupplierExtend supplierExtend = JSONObject.parseObject(obj.toJSONString(), SupplierExtend.class);
        Long userId = userService.getCurrentUser().getId();
        Date date = new Date();
        int result = 0;
        //一个供应商最多可创建10个子账户
        Long supplierId = supplierExtend.getSupplierId();
        int activeFlag = 0;
        int number = supplierExtendMapperEx.countIsActiveSupplierExtend(supplierId, activeFlag);
        if (number >= 10) {
            throw new BusinessRunTimeException(ExceptionConstants.SUPPLIER_EXTEND_CREATED_MORE_THAN_FAILED_CODE,
                    String.format(ExceptionConstants.SUPPLIER_EXTEND_CREATED_MORE_THAN_FAILED_MSG, number));
        }
        try {
            supplierExtend.setActive(false);
            supplierExtend.setCreator(userId);
            supplierExtend.setCreateTime(date);
            supplierExtend.setUpdater(userId);
            supplierExtend.setUpdateTime(date);
            result = supplierExtendMapper.insertSelective(supplierExtend);
            String supplierName = supplierMapper.selectByPrimaryKey(supplierExtend.getSupplierId()).getSupplier();
            String originType = supplierExtend.getOriginType();
            Date now = new Date();
            Long tenantId = userService.getCurrentUser().getTenantId();
            String status = supplierExtend.getCheckStatus();
            //如果租户为城市佰兴，来源为小程序，则发送钉钉通知操作员审核(小程序群)
            if (tenantId == 146 && BusinessConstants.ORIGIN_TYPE.equals(originType)&&
                    status.equals(BusinessConstants.BILLS_STATUS_UN_AUDIT)) {
                String content = "审核页面：子账户审核" + "\n" +
                        "客户：" + supplierName + "\n" +
                        "来源：" + originType + "\n" +
                        "时间：" + Tools.parseDateToStr(now) + "\n" +
                        "链接：" + supplier_extend_check_link;
                sendDingDingUtils.sendDingDingUtils(content, webhookToMiniPrograms);
            }
            if (tenantId == 146 && !BusinessConstants.ORIGIN_TYPE.equals(originType)&&
                    status.equals(BusinessConstants.BILLS_STATUS_UN_AUDIT)) {
                //发钉钉通知(后台群)
                String content = "审核页面：子账户审核" + "\n" +
                        "客户：" + supplierName + "\n" +
                        "来源：PC端" + "\n" +
                        "时间：" + Tools.parseDateToStr(now) + "\n" +
                        "链接：" + supplier_extend_check_link;
                sendDingDingUtils.sendDingDingUtils(content, webhookToColdBackend);
            }
            logService.insertLog("小程序角色管理",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ADD).append(supplierExtend.getName()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateSupplierExtend(JSONObject obj, HttpServletRequest request) throws Exception {
        SupplierExtend supplierExtend = JSONObject.parseObject(obj.toJSONString(), SupplierExtend.class);
        User userInfo = userService.getCurrentUser();
        int result = 0;

        try {
            supplierExtend.setUpdater(userInfo.getId());
            supplierExtend.setUpdateTime(new Date());
            result = supplierExtendMapper.updateByPrimaryKeySelective(supplierExtend);
            Long supplierId = supplierExtendMapper.selectByPrimaryKey(supplierExtend.getId()).getSupplierId();
            String supplierName = supplierMapper.selectByPrimaryKey(supplierId).getSupplier();
            String originType = supplierExtend.getOriginType();
            Date now = new Date();
            Long tenantId = userService.getCurrentUser().getTenantId();
            String status = supplierExtend.getCheckStatus();
            //如果租户为城市佰兴，来源为小程序，则发送钉钉通知操作员审核(小程序群)
            if (tenantId == 146 && BusinessConstants.ORIGIN_TYPE.equals(originType)&&
                    status.equals(BusinessConstants.BILLS_STATUS_UN_AUDIT)) {
                String content = "审核页面：子账户审核" + "\n" +
                        "客户：" + supplierName + "\n" +
                        "来源：" + originType + "\n" +
                        "时间：" + Tools.parseDateToStr(now) + "\n" +
                        "链接：" + supplier_extend_check_link;
                sendDingDingUtils.sendDingDingUtils(content, webhookToMiniPrograms);
            }
            if (tenantId == 146 && !BusinessConstants.ORIGIN_TYPE.equals(originType)&&
                    status.equals(BusinessConstants.BILLS_STATUS_UN_AUDIT)) {
                //发钉钉通知(后台群)
                String content = "审核页面：子账户审核" + "\n" +
                        "客户：" + supplierName + "\n" +
                        "来源：PC端" + "\n" +
                        "时间：" + Tools.parseDateToStr(now) + "\n" +
                        "链接：" + supplier_extend_check_link;
                sendDingDingUtils.sendDingDingUtils(content, webhookToColdBackend);
            }
            logService.insertLog("小程序角色管理",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(supplierExtend.getName()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    public int deleteSupplierExtend(Long id, HttpServletRequest request) throws Exception {
        return batchDeleteSupplierByIds(id.toString());
    }

    public int batchDeleteSupplierExtend(String ids, HttpServletRequest request) throws Exception {
        return batchDeleteSupplierByIds(ids);
    }

    /**
     * 批量删除接口
     *
     * @param ids
     * @return
     * @throws Exception
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteSupplierByIds(String ids) throws Exception {
        String[] idArray = ids.split(",");
        User userInfo = userService.getCurrentUser();
        //只有禁用的子账户可以删除
        Long res = supplierExtendMapperEx.countIsActive(idArray);//查询这些数据中是否有启用的账户
        if (res > 0) {
            throw new BusinessRunTimeException(ExceptionConstants.DELETE_ACTIVE_SUPPLIER_EXTEND_FAILED_CODE, String.format(ExceptionConstants.DELETE_ACTIVE_SUPPLIER_EXTEND_FAILED_MSG));
        }
        int result = 0;
        try {
            result = supplierExtendMapperEx.batchDeleteSupplierExtendByIds(new Date(), userInfo == null ? null : userInfo.getId(), idArray);
            //记录日志
            StringBuffer sb = new StringBuffer();
            sb.append(BusinessConstants.LOG_OPERATION_TYPE_DELETE);
            logService.insertLog("小程序角色管理", sb.toString(),
                    ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    public int checkIsNameExistExtend(Long id, String name) {
        return 0;
    }

    public List<?> select(String supplierId, String active, String name, String phone, String role, String checkStatus, int offset, int rows) {
        List<SupplierExtendVoList> list = null;
        String[] statusArray = StringUtil.isNotEmpty(checkStatus) ? checkStatus.split(",") : null;
        try {
            list = supplierExtendMapperEx.selectByConditionSupplierExtend(supplierId, active, name, phone, role, statusArray, offset, rows);
            for (SupplierExtendVoList se : list) {
                if (se.getVerifierTime() != null) {
                    se.setVerifierTimeStr(getCenternTime(se.getVerifierTime()));
                }
            }
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public Long countSupplierExtend(String supplierId, String active, String name, String phone, String role, String checkStatus) {
        Long list = null;
        String[] statusArray = StringUtil.isNotEmpty(checkStatus) ? checkStatus.split(",") : null;
        try {
            list = supplierExtendMapperEx.countByConditionSupplierExtend(supplierId, active, name, phone, role, statusArray);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    /**
     * 批量设置状态
     *
     * @param status
     * @param ids
     * @return
     * @throws Exception
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchSetStatus(String status, String ids, String comment, HttpServletRequest request) throws Exception {
        User userInfo = userService.getCurrentUser();

        int result = 0;
        List<Long> seIds = new ArrayList<>();
        List<Long> supplierExtendIds = StringUtil.strToLongList(ids);
        //检查修改的审核状态是否符合逻辑
        Map<String, List<String>> statusRules = new HashMap<>();
        statusRules.put("0", Arrays.asList("0", "1", "5", "6", "9"));
        statusRules.put("1", Arrays.asList("0", "9"));
        statusRules.put("5", Arrays.asList("0", "9"));
        statusRules.put("6", Arrays.asList("0", "6"));
        statusRules.put("9", Arrays.asList("0"));

        for (Long id : supplierExtendIds) {
            SupplierExtend supplierExtend = supplierExtendMapper.selectByPrimaryKey(id);
            String seStatus = supplierExtend.getCheckStatus();
            if (statusRules.containsKey(status) && statusRules.get(status).contains(seStatus)) {
                seIds.add(id);
            } else {
                throw new BusinessRunTimeException(ExceptionConstants.UPDATE_STATUS_FAILED_CODE, ExceptionConstants.UPDATE_STATUS_FAILED_MSG);
            }
        }
        if (seIds.size() > 0) {
            SupplierExtend supplierExtend = new SupplierExtend();
            supplierExtend.setCheckStatus(status);
            supplierExtend.setComment(comment);
            supplierExtend.setVerifier(userInfo.getId());
            supplierExtend.setVerifierTime(new Date());
            SupplierExtendExample example = new SupplierExtendExample();
            example.createCriteria().andIdIn(seIds);
            result = supplierExtendMapper.updateByExampleSelective(supplierExtend, example);
        }
        logService.insertLog("子账户管理",
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ENABLED).toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchSetActive(Boolean active, String ids) throws Exception {
        User userInfo = userService.getCurrentUser();

        int result = 0;
        List<Long> seIds = new ArrayList<>();
        List<Long> supplierExtendIds = StringUtil.strToLongList(ids);
        int activeNumber = 0;//启用数量
        for (Long id : supplierExtendIds) {
            SupplierExtend supplierExtend = supplierExtendMapper.selectByPrimaryKey(id);
            if (active) {//启用
                //查询启用的子账号数量，限制5个
                Long supplierId = supplierExtend.getSupplierId();
                int activeFlag = 1;
                int number = supplierExtendMapperEx.countIsActiveSupplierExtend(supplierId, activeFlag);//数据库已有启用数量
                //本次启用数量
                if (number + activeNumber >= 5) {
                    throw new BusinessRunTimeException(ExceptionConstants.SUPPLIER_EXTEND_UPDATE_ACTIVE_MORE_THAN_FAILED_CODE,
                            String.format(ExceptionConstants.SUPPLIER_EXTEND_UPDATE_ACTIVE_MORE_THAN_FAILED_MSG, 5));
                }
                if (!supplierExtend.getActive() && "1".equals(supplierExtend.getCheckStatus())) {
                    seIds.add(id);
                    activeNumber++;
                } else {
                    throw new BusinessRunTimeException(ExceptionConstants.SUPPLIER_EXTEND_UPDATE_ACTIVE_TURE_FAILED_CODE,
                            String.format(ExceptionConstants.SUPPLIER_EXTEND_UPDATE_ACTIVE_TURE_FAILED_MSG));
                }
            } else {//改为禁用
                if (supplierExtend.getActive() && "1".equals(supplierExtend.getCheckStatus())) {
                    seIds.add(id);
                } else {
                    throw new BusinessRunTimeException(ExceptionConstants.SUPPLIER_EXTEND_UPDATE_ACTIVE_FALSE_FAILED_CODE, String.format(ExceptionConstants.SUPPLIER_EXTEND_UPDATE_ACTIVE_FALSE_FAILED_MSG));
                }
            }
        }
        if (seIds.size() > 0) {
            SupplierExtend supplierExtend = new SupplierExtend();
            supplierExtend.setActive(active);
            SupplierExtendExample example = new SupplierExtendExample();
            example.createCriteria().andIdIn(seIds);
            result = supplierExtendMapper.updateByExampleSelective(supplierExtend, example);
        }
        logService.insertLog("子账户管理",
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ENABLED).toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        return result;
    }
}

