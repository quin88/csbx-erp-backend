package com.jsh.erp.service.supermarketDocument;

import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.*;
import com.jsh.erp.exception.BusinessRunTimeException;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.log.LogService;
import com.jsh.erp.service.supermarketDocumentItem.SupermarketDocumentItemService;
import com.jsh.erp.service.supermarketInvoiceNumber.SupermarketInvoiceNumberService;
import com.jsh.erp.service.supermarketSystemConfig.SupermarketSystemConfigService;
import com.jsh.erp.service.user.UserService;
import com.jsh.erp.utils.Tools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SupermarketDocumentService {
    private Logger logger = LoggerFactory.getLogger(SupermarketDocumentService.class);
    @Resource
    private LogService logService;
    @Resource
    private SupermarketDocumentMapper supermarketDocumentMapper;
    @Resource
    private SupermarketDocumentMapperEx supermarketDocumentMapperEx;
    @Resource
    private UserService userService;
    @Resource
    private SupermarketDocumentItemService supermarketDocumentItemService;
    @Resource
    private SupermarketDocumentItemMapper supermarketDocumentItemMapper;
    @Resource
    private SupermarketInvoiceNumberService supermarketInvoiceNumberService;
    @Resource
    private SupermarketInvoiceNumberMapper supermarketInvoiceNumberMapper;
    @Resource
    private SupermarketSystemConfigService supermarketSystemConfigService;
    @Resource
    private SupermarketSystemConfigMapper supermarketSystemConfigMapper;

    public Object selectOne(Long id) {

        SupermarketDocumentVo4Body sdVo = new SupermarketDocumentVo4Body();
        try {
            sdVo = supermarketDocumentMapperEx.selectSupermarketDocumentById(id);
            //查询子数据
            SupermarketDocumentItemExample example = new SupermarketDocumentItemExample();
            example.createCriteria().andSdIdEqualTo(id);
            List<SupermarketDocumentItem> supermarketDocumentItems = supermarketDocumentItemMapper.selectByExample(example);
            sdVo.setSupermarketDocumentItem(supermarketDocumentItems);

            //查询发票号
            SupermarketInvoiceNumberExample numberExample = new SupermarketInvoiceNumberExample();
            numberExample.createCriteria().andSupermarketDocumentIdEqualTo(id);
            List<SupermarketInvoiceNumber> sin = supermarketInvoiceNumberMapper.selectByExample(numberExample);
            sdVo.setSupermarketInvoiceNumbers(sin);

        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return sdVo;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public Object addSupermarketDocumentAndItem(SupermarketDocumentVo4Body body, HttpServletRequest request) throws Exception {
        User userInfo = userService.getCurrentUser();
        //校验单号是否重复
        if (checkIsNumberNoExist(0L, body.getNumber())) {
            throw new BusinessRunTimeException(ExceptionConstants.NUMBER_IS_EXIST_CODE,
                    String.format(ExceptionConstants.NUMBER_IS_EXIST_MSG));
        }
        try {
            body.setCreator(userInfo == null ? null : userInfo.getId());
            body.setCreateTime(new Date());
            body.setUpdater(userInfo == null ? null : userInfo.getId());
            body.setUpdateTime(new Date());
            supermarketDocumentMapper.insertSelective(body);
            //更新编号数值
            SupermarketSystemConfig config = supermarketSystemConfigService.getCurrentConfig(BusinessConstants.SUPERMARKET_DOCUMENT_NUMBER_SEQ);
            Integer currentValue = config.getCurrentValue();
            config.setCurrentValue(currentValue + 1); //编号+1
            supermarketSystemConfigMapper.updateByPrimaryKeySelective(config);
            //根据编号查询id
            Long sdId = supermarketDocumentMapperEx.selectIdByNumber(body.getNumber());
            //新增子单据
            List<SupermarketDocumentItem> item = body.getSupermarketDocumentItem();
            if (item != null) {
                supermarketDocumentItemService.saveSupermarketDocumentItem(item, sdId, request);
            }
            //新增发票单号
            List<SupermarketInvoiceNumber> numbers = body.getSupermarketInvoiceNumbers();
            if (numbers != null) {
                supermarketInvoiceNumberService.saveSupermarketInvoiceNumber(numbers, sdId, body.getDeleteIds());
            }
            logService.insertLog("商超出入库",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ADD).append(body.getId()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return ExceptionConstants.standardSuccess();
    }

    private boolean checkIsNumberNoExist(Long id, String number) {
        SupermarketDocumentExample example = new SupermarketDocumentExample();
        example.createCriteria().andIdNotEqualTo(id).andNumberEqualTo(number).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<SupermarketDocument> list = null;
        try {
            list = supermarketDocumentMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list != null && !list.isEmpty();
    }

    public List<?> search(String supplier, String organ, String beginTime, String endTime, String number,
                          String invoiceNumber, String status, String type, int offset, int rows) {

        List<SupermarketDocumentVo4Body> result = new ArrayList<>();
        try {
            beginTime = Tools.parseDayToTime(beginTime, BusinessConstants.DAY_FIRST_TIME);
            endTime = Tools.parseDayToTime(endTime, BusinessConstants.DAY_LAST_TIME);
            List<SupermarketDocumentVo4Body> supermarketDocuments = supermarketDocumentMapperEx.selectSupermarketDocument(supplier, organ,
                    beginTime, endTime, number, invoiceNumber, status, type, offset, rows);

            for (SupermarketDocument supermarketDocument : supermarketDocuments) {
                SupermarketDocumentVo4Body sdVo = new SupermarketDocumentVo4Body();
                BeanUtils.copyProperties(supermarketDocument, sdVo);

                List<SupermarketDocumentItem> supermarketDocumentItems = getSupermarketDocumentItems(supermarketDocument.getId());
                SupermarketDocumentItem firstItem = supermarketDocumentItems.stream().findFirst().orElse(null);//获取第一条数据
                List<String> materialNames = getNames(supermarketDocumentItems);//获取所有商品名称
                BigDecimal totalQuantity = getTotalQuantity(supermarketDocumentItems);//数量小计

                sdVo.setItemName(String.join(",", materialNames));//拼接
                sdVo.setUnit(firstItem != null ? firstItem.getUnit() : null);
                sdVo.setAquaticType(firstItem != null ? firstItem.getAquaticType() : null);
                sdVo.setQuantity(totalQuantity);
                sdVo.setSupermarketDocumentItem(supermarketDocumentItems);
                //查询发票号
                SupermarketInvoiceNumberExample numberExample = new SupermarketInvoiceNumberExample();
                numberExample.createCriteria().andSupermarketDocumentIdEqualTo(supermarketDocument.getId());
                List<SupermarketInvoiceNumber> sin = supermarketInvoiceNumberMapper.selectByExample(numberExample);
                sdVo.setSupermarketInvoiceNumbers(sin);

                result.add(sdVo);
            }
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    private List<SupermarketDocumentItem> getSupermarketDocumentItems(Long sdId) {
        SupermarketDocumentItemExample example = new SupermarketDocumentItemExample();
        example.createCriteria().andSdIdEqualTo(sdId).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        return supermarketDocumentItemMapper.selectByExample(example);
    }

    private List<String> getNames(List<SupermarketDocumentItem> supermarketDocumentItems) {
        return supermarketDocumentItems.stream()
                .map(SupermarketDocumentItem::getName)
                .collect(Collectors.toList());
    }

    private BigDecimal getTotalQuantity(List<SupermarketDocumentItem> supermarketDocumentItems) {
        return supermarketDocumentItems.stream()
                .map(SupermarketDocumentItem::getQuantity)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Long counts(String supplier, String organ, String beginTime, String endTime, String number, String invoiceNumber,
                       String status, String type) {

        Long result = null;
        try {
            beginTime = Tools.parseDayToTime(beginTime, BusinessConstants.DAY_FIRST_TIME);
            endTime = Tools.parseDayToTime(endTime, BusinessConstants.DAY_LAST_TIME);
            result = supermarketDocumentMapperEx.countSupermarketDocument(supplier, organ,
                    beginTime, endTime, number, invoiceNumber, status, type);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }


    public Object updateSupermarketDocumentAndItem(SupermarketDocumentVo4Body body, List<Long> itemIds, HttpServletRequest request) {

        //校验单号是否重复
        if (checkIsNumberNoExist(body.getId(), body.getNumber())) {
            throw new BusinessRunTimeException(ExceptionConstants.NUMBER_IS_EXIST_CODE,
                    String.format(ExceptionConstants.NUMBER_IS_EXIST_MSG));
        }
        try {
            body.setUpdater(userService.getCurrentUser().getId());
            body.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            supermarketDocumentMapper.updateByPrimaryKeySelective(body);
            //编辑子单据,更换关联订单则根据前端传入的id删除
            if (itemIds != null) {
                SupermarketDocumentItemExample example = new SupermarketDocumentItemExample();
                example.createCriteria().andIdIn(itemIds);
                supermarketDocumentItemMapper.deleteByExample(example);
            }
            List<SupermarketDocumentItem> item = body.getSupermarketDocumentItem();
            supermarketDocumentItemService.saveSupermarketDocumentItem(item, body.getId(), request);
            //处理发票单号
            List<SupermarketInvoiceNumber> numbers = body.getSupermarketInvoiceNumbers();
            if (numbers != null) {
                supermarketInvoiceNumberService.saveSupermarketInvoiceNumber(numbers, body.getId(), body.getDeleteIds());
            }
            logService.insertLog("商超出入库",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(body.getId()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return ExceptionConstants.standardSuccess();
    }

    public int deleteSupermarketDocument(Long id, HttpServletRequest request) throws Exception {
        return batchDeleteSupermarketDocumentByIds(id.toString(), request);
    }

    public int batchDeleteSupermarketDocument(String ids, HttpServletRequest request) throws Exception {
        return batchDeleteSupermarketDocumentByIds(ids, request);
    }

    private int batchDeleteSupermarketDocumentByIds(String ids, HttpServletRequest request) throws Exception {
        String[] idArray = ids.split(",");
        User userInfo = userService.getCurrentUser();

        int result = 0;
        try {
            result = supermarketDocumentMapperEx.batchDeleteSuperDocumentByIds(new Date(), userInfo == null ? null : userInfo.getId(), idArray);
            //记录日志
            StringBuffer sb = new StringBuffer();
            sb.append(BusinessConstants.LOG_OPERATION_TYPE_DELETE);
            logService.insertLog("商超出入库", sb.toString(),
                    ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

}
