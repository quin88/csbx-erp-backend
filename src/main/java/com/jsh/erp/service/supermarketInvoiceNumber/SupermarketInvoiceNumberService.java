package com.jsh.erp.service.supermarketInvoiceNumber;

import com.jsh.erp.datasource.entities.SupermarketInvoiceNumber;
import com.jsh.erp.datasource.entities.SupermarketInvoiceNumberExample;
import com.jsh.erp.datasource.mappers.SupermarketInvoiceNumberMapper;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SupermarketInvoiceNumberService {
    private Logger logger = LoggerFactory.getLogger(SupermarketInvoiceNumberService.class);
    @Resource
    private SupermarketInvoiceNumberMapper supermarketInvoiceNumberMapper;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void saveSupermarketInvoiceNumber(List<SupermarketInvoiceNumber> numbers, Long sdId, String deleteIds) {
        for (SupermarketInvoiceNumber number : numbers) {
            if (number.getId() == null) {
                number.setSupermarketDocumentId(sdId);
                supermarketInvoiceNumberMapper.insertSelective(number);
            } else {
                supermarketInvoiceNumberMapper.updateByPrimaryKeySelective(number);
            }

            if (deleteIds != null && !deleteIds.equals("")) {
                deleteSupermarketInvoiceNumber(deleteIds);
            }
        }
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void deleteSupermarketInvoiceNumber(String deleteIds) {
        List<Long> longs = StringUtil.strToLongList(deleteIds);
        SupermarketInvoiceNumberExample example = new SupermarketInvoiceNumberExample();
        example.createCriteria().andIdIn(longs);
        try {
            supermarketInvoiceNumberMapper.deleteByExample(example);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
    }
}