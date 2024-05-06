package com.jsh.erp.service.secondSettlementMethod;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.SecondSettlementMethodMapper;
import com.jsh.erp.datasource.mappers.SecondSettlementMethodMapperEx;
import com.jsh.erp.datasource.vo.SecondSettlementMethodVoList;
import com.jsh.erp.exception.BusinessRunTimeException;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.log.LogService;
import com.jsh.erp.service.user.UserService;
import com.jsh.erp.utils.BaseResponseInfo;
import com.jsh.erp.utils.ExcelUtils;
import com.jsh.erp.utils.StringUtil;
import jxl.Sheet;
import jxl.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;

@Service
public class SecondSettlementMethodService {
    private Logger logger = LoggerFactory.getLogger(SecondSettlementMethodService.class);

    @Resource
    private SecondSettlementMethodMapper secondSettlementMethodMapper;

    @Resource
    private SecondSettlementMethodMapperEx secondSettlementMethodMapperEx;

    @Resource
    private UserService userService;

    @Resource
    private LogService logService;

    public SecondSettlementMethod getSecondSettlementMethod(Long id) {
        SecondSettlementMethod result = null;
        try {
            result = secondSettlementMethodMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    public List<SecondSettlementMethod> getSecondSettlementMethodList(String settlementMethodIds) throws Exception {
        List<Long> idList = StringUtil.strToLongList(settlementMethodIds);
        List<SecondSettlementMethod> list = new ArrayList<>();
        try {
            SecondSettlementMethodExample example = new SecondSettlementMethodExample();
            example.createCriteria().andSettlementIdIn(idList).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
            list = secondSettlementMethodMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }
    public List<SecondSettlementMethod> findListBySettlementMethodId(Long id) {
        SecondSettlementMethodExample example = new SecondSettlementMethodExample();
        example.createCriteria().andSettlementIdEqualTo(id).andStatusEqualTo(BusinessConstants.ENABLE_STATUS_ENABLE)
                .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<SecondSettlementMethod> list = null;
        try {
            list = secondSettlementMethodMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<SecondSettlementMethodVoList> select(String settlement, String settlementId, String secondSettlement, int offset, int rows) {
        List<SecondSettlementMethodVoList> list = null;
        Long firstId = null;
        if (StringUtil.isNotEmpty(settlementId)) {
            firstId = Long.parseLong(settlementId);
        }
        try {
            list = secondSettlementMethodMapperEx.selectByConditionSecondSettlement(settlement, firstId, secondSettlement, offset, rows);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public Long countSecondSettlement(String settlement, String settlementId, String secondSettlement) {
        Long result = null;
        Long firstId = null;
        if (StringUtil.isNotEmpty(settlementId)) {
            firstId = Long.parseLong(settlementId);
        }
        try {
            result = secondSettlementMethodMapperEx.countSecondSettlement(settlement, firstId, secondSettlement);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertSecondSettlementMethod(JSONObject obj, HttpServletRequest request) throws Exception {
        User userInfo = userService.getCurrentUser();
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        SecondSettlementMethod secondSettlementMethod = JSONObject.parseObject(obj.toJSONString(), SecondSettlementMethod.class);
        //校验名称是否存在
        if (checkIsNameExist(secondSettlementMethod.getSettlementId(), secondSettlementMethod.getSecondSettlementMethod()) > 0) {
            throw new BusinessRunTimeException(ExceptionConstants.SECOND_SETTLEMENT_NAME_EXIST_CODE, String.format(ExceptionConstants.SECOND_SETTLEMENT_NAME_EXIST_EXIST_MSG, secondSettlementMethod.getSecondSettlementMethod()));
        }
        int result = 0;
        secondSettlementMethod.setCreator(userInfo == null ? null : userInfo.getId());
        secondSettlementMethod.setCreateTime(currentTime);
        secondSettlementMethod.setUpdater(userInfo == null ? null : userInfo.getId());
        secondSettlementMethod.setUpdateTime(currentTime);
        secondSettlementMethod.setStatus("0");
        try {
            result = secondSettlementMethodMapper.insertSelective(secondSettlementMethod);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateSecondSettlementMethod(JSONObject obj, HttpServletRequest request) throws Exception {
        User userInfo = userService.getCurrentUser();
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        SecondSettlementMethod secondSettlementMethod = JSONObject.parseObject(obj.toJSONString(), SecondSettlementMethod.class);
        secondSettlementMethod.setUpdater(userInfo == null ? null : userInfo.getId());
        secondSettlementMethod.setUpdateTime(currentTime);
        int result = 0;
        try {
            result = secondSettlementMethodMapper.updateByPrimaryKeySelective(secondSettlementMethod);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteSecondSettlementMethod(Long id, HttpServletRequest request) throws Exception {
        return batchDeleteSecondSettlementMethodByIds(id.toString());
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteSecondSettlementMethod(String ids, HttpServletRequest request) throws Exception {
        return batchDeleteSecondSettlementMethodByIds(ids);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteSecondSettlementMethodByIds(String ids) throws Exception {
        int result = 0;
        String[] idArray = ids.split(",");
        User userInfo = userService.getCurrentUser();
        try {
            result = secondSettlementMethodMapperEx.batchDeleteSecondSettlementMethodByIds(new Date(), userInfo == null ? null : userInfo.getId(), idArray);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    public int checkIsNameExist(Long settlementId, String name) throws Exception {
        SecondSettlementMethodExample example = new SecondSettlementMethodExample();
        example.createCriteria().andSettlementIdEqualTo(settlementId).andSecondSettlementMethodEqualTo(name).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<SecondSettlementMethod> list = null;
        try {
            list = secondSettlementMethodMapper.selectByExample(example);
        } catch (Exception e) {
            logger.error("异常码[{}],异常提示[{}],异常[{}]",
                    ExceptionConstants.DATA_READ_FAIL_CODE, ExceptionConstants.DATA_READ_FAIL_MSG, e);
            throw new BusinessRunTimeException(ExceptionConstants.DATA_READ_FAIL_CODE,
                    ExceptionConstants.DATA_READ_FAIL_MSG);
        }
        return list == null ? 0 : list.size();
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchSetStatus(String status, String ids) throws Exception {
        logService.insertLog("费用类型",
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ENABLED).toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        List<Long> idList = StringUtil.strToLongList(ids);
        SecondSettlementMethod secondSettlementMethod = new SecondSettlementMethod();
        secondSettlementMethod.setStatus(status);
        SecondSettlementMethodExample example = new SecondSettlementMethodExample();
        example.createCriteria().andIdIn(idList);
        int result = 0;
        try {
            result = secondSettlementMethodMapper.updateByExampleSelective(secondSettlementMethod, example);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    public void importCostTypes(MultipartFile file, HttpServletRequest request) throws Exception {
            String type = "费用类型";
            Workbook workbook = Workbook.getWorkbook(file.getInputStream());
            Sheet src = workbook.getSheet(0);
            //'结算模块id*', '费用名称*', '备注', '状态'
            List<SecondSettlementMethod> sList = new ArrayList<>();
            for (int i = 2; i < src.getRows(); i++) {
                String settlementId = ExcelUtils.getContent(src, i, 0);
                String enabled = ExcelUtils.getContent(src, i, 4);
                if (StringUtil.isNotEmpty(settlementId) && StringUtil.isNotEmpty(enabled)) {
                    SecondSettlementMethod s = new SecondSettlementMethod();
                    s.setSettlementId(Long.valueOf(settlementId));
                    s.setSecondSettlementMethod(ExcelUtils.getContent(src, i, 2));
                    s.setRemark(ExcelUtils.getContent(src, i, 3));
                    s.setStatus(enabled);
                    sList.add(s);
                }
            }
            importExcel(sList, type);
        }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public BaseResponseInfo importExcel(List<SecondSettlementMethod> mList, String type) throws Exception {
        logService.insertLog(type,
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_IMPORT).append(mList.size()).append(BusinessConstants.LOG_DATA_UNIT).toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        BaseResponseInfo info = new BaseResponseInfo();
        Map<String, Object> data = new HashMap<>();
        User userInfo = userService.getCurrentUser();
        try {
            for (SecondSettlementMethod s : mList) {
                SecondSettlementMethodExample example = new SecondSettlementMethodExample();
                example.createCriteria().andSecondSettlementMethodEqualTo(s.getSecondSettlementMethod()).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
                List<SecondSettlementMethod> list = secondSettlementMethodMapper.selectByExample(example);
                if (list.size() <= 0) {
                    s.setCreateTime(new Date());
                    s.setCreator(userInfo==null?null:userInfo.getId());
                    s.setUpdateTime(new Date());
                    s.setUpdater(userInfo==null?null:userInfo.getId());
                    secondSettlementMethodMapper.insertSelective(s);
                } else {
                    Long id = list.get(0).getId();
                    s.setId(id);
                    s.setUpdateTime(new Date());
                    s.setUpdater(userInfo==null?null:userInfo.getId());
                    secondSettlementMethodMapper.updateByPrimaryKeySelective(s);
                }
            }
            info.code = 200;
            data.put("message", "成功");
        } catch (Exception e) {
            e.printStackTrace();
            info.code = 500;
            data.put("message", e.getMessage());
        }
        info.data = data;
        return info;
    }

    public List<SecondSettlementMethodVoList> findByAll() {
        List<SecondSettlementMethodVoList> list = null;
        try {
            list = secondSettlementMethodMapperEx.findByAll();
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public File  exportExcel(List<SecondSettlementMethodVoList> dataList) throws Exception {
            String[] names = {"结算模块id*", "结算模块*", "费用名称*", "备注", "状态*"};
            String title = "费用类型";
            List<String[]> objects = new ArrayList<String[]>();
            if (null != dataList) {
                for (SecondSettlementMethodVoList s : dataList) {
                    String[] objs = new String[5];
                    objs[0] = String.valueOf(s.getSettlementId());
                    objs[1] = s.getSettlement();
                    objs[2] = s.getSecondSettlementMethod();
                    objs[3] = s.getRemark();
                    objs[4] = s.getStatus();
                    objects.add(objs);
                }
            }
            return ExcelUtils.exportObjectsWithoutTitle(title, "*导入时本行内容请勿删除，切记！", names, title, objects);
    }
}
