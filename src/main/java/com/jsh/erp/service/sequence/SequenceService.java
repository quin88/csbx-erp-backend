package com.jsh.erp.service.sequence;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.*;
import com.jsh.erp.exception.BusinessRunTimeException;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.jsh.erp.utils.StringUtil.isPositiveLongWithLength5;

/**
 * Description
 *
 * @Author: CSBX
 * @Date: 2021/3/16 16:33
 */
@Service
public class SequenceService {
    private Logger logger = LoggerFactory.getLogger(SequenceService.class);

    @Resource
    private SequenceMapperEx sequenceMapperEx;
    @Resource
    private SupermarketMaterialMapperEx supermarketMaterialMapperEx;

    public SerialNumber getSequence(long id) throws Exception {
        return null;
    }

    public List<SerialNumberEx> select(String name, Integer offset, Integer rows) throws Exception {
        return null;
    }

    public Long countSequence(String name) throws Exception {
        return null;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertSequence(JSONObject obj, HttpServletRequest request) throws Exception {
        return 0;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateSequence(JSONObject obj, HttpServletRequest request) throws Exception {
        return 0;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteSequence(Long id, HttpServletRequest request) throws Exception {
        return 0;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteSequence(String ids, HttpServletRequest request) throws Exception {
        return 0;
    }

    public int checkIsNameExist(Long id, String serialNumber) throws Exception {
        return 0;
    }

    /**
     * 创建一个唯一的序列号
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public String buildOnlyNumber() throws Exception {
        Long buildOnlyNumber = null;
        synchronized (this) {
            try {
                sequenceMapperEx.updateBuildOnlyNumber(BusinessConstants.DEPOT_NUMBER_SEQ); //编号+1
                buildOnlyNumber = sequenceMapperEx.getBuildOnlyNumber(BusinessConstants.DEPOT_NUMBER_SEQ);
            } catch (Exception e) {
                JshException.writeFail(logger, e);
            }
        }
        if (buildOnlyNumber < BusinessConstants.SEQ_TO_STRING_MIN_LENGTH) {
            StringBuffer sb = new StringBuffer(buildOnlyNumber.toString());
            int len = BusinessConstants.SEQ_TO_STRING_MIN_LENGTH.toString().length() - sb.length();
            for (int i = 0; i < len; i++) {
                sb.insert(0, BusinessConstants.SEQ_TO_STRING_LESS_INSERT);
            }
            return sb.toString();
        } else {
            return buildOnlyNumber.toString();
        }
    }

    /**
     * 获取市场编码
     *
     * @return
     */
    public String getMarketNumber() {
        Long buildOnlyNumber = null;
        synchronized (this) {
            try {
                buildOnlyNumber = sequenceMapperEx.getBuildOnlyNumber(BusinessConstants.MARKET_NUMBER_SEQ);
            } catch (Exception e) {
                JshException.writeFail(logger, e);
            }
        }
        Long maxValue = sequenceMapperEx.getMaxValue(BusinessConstants.MARKET_NUMBER_SEQ);
        if (buildOnlyNumber < maxValue) {
            return String.format("%02d", buildOnlyNumber);
        } else {
            throw new BusinessRunTimeException(ExceptionConstants.SERIAL_NUMBERE_NOT_ENOUGH_CODE, ExceptionConstants.SERIAL_NUMBERE_NOT_ENOUGH_MSG);
        }
    }

    /**
     * 生成唯一的供应商编码
     *
     * @return
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public String buildSupplierNumber() {
        Long buildOnlyNumber = null;
        try {
            synchronized (this) {
//                sequenceMapperEx.updateBuildOnlyNumber(BusinessConstants.SUPPLIER_NUMBER_SEQ); //编号+1
                buildOnlyNumber = sequenceMapperEx.getBuildOnlyNumber(BusinessConstants.SUPPLIER_NUMBER_SEQ);
            }
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        Long maxValue = sequenceMapperEx.getMaxValue(BusinessConstants.SUPPLIER_NUMBER_SEQ);
        if (buildOnlyNumber < maxValue) {
            return String.format("%04d", buildOnlyNumber);
        } else {
            throw new BusinessRunTimeException(ExceptionConstants.SERIAL_NUMBERE_NOT_ENOUGH_CODE, ExceptionConstants.SERIAL_NUMBERE_NOT_ENOUGH_MSG);
        }
    }

    /**
     * 获取区县镇编码
     *
     * @return
     */
    public String getCountyNumber() {
        Long buildOnlyNumber = null;
        synchronized (this) {
            try {
                buildOnlyNumber = sequenceMapperEx.getBuildOnlyNumber(BusinessConstants.COUNTY_NUMBER_SEQ);
            } catch (Exception e) {
                JshException.writeFail(logger, e);
            }
        }
        Long maxValue = sequenceMapperEx.getMaxValue(BusinessConstants.COUNTY_NUMBER_SEQ);
        if (buildOnlyNumber < maxValue) {
            return String.format("%02d", buildOnlyNumber);
        } else {
            throw new BusinessRunTimeException(ExceptionConstants.SERIAL_NUMBERE_NOT_ENOUGH_CODE, ExceptionConstants.SERIAL_NUMBERE_NOT_ENOUGH_MSG);
        }
    }

    /**
     * 商超出入库编码接口
     *
     * @return
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public String getSupermarketDocumentNumber() {
        Long buildOnlyNumber = null;
        synchronized (this) {
            try {
                sequenceMapperEx.updateBuildOnlyNumber(BusinessConstants.SUPERMARKET_DOCUMENT_NUMBER_SEQ); //编号+1
                buildOnlyNumber = sequenceMapperEx.getBuildOnlyNumber(BusinessConstants.SUPERMARKET_DOCUMENT_NUMBER_SEQ);
            } catch (Exception e) {
                JshException.writeFail(logger, e);
            }
        }
        if (buildOnlyNumber < BusinessConstants.SEQ_TO_STRING_MIN_LENGTH) {
            StringBuffer sb = new StringBuffer(buildOnlyNumber.toString());
            int len = BusinessConstants.SEQ_TO_STRING_MIN_LENGTH.toString().length() - sb.length();
            for (int i = 0; i < len; i++) {
                sb.insert(0, BusinessConstants.SEQ_TO_STRING_LESS_INSERT);
            }
            return sb.toString();
        } else {
            return buildOnlyNumber.toString();
        }
    }

    /**
     * 生成商品编码(只包含五位数字)
     *  2023/12/27
     * @return
     */
/*    public String buildMaterialNumber() {
        Long buildOnlyNumber = null;
        synchronized (this) {
             buildOnlyNumber = sequenceMapperEx.getBuildOnlyNumber(BusinessConstants.SUPERMARKET_MATERIAL_NUMBER_SEQ);
//            sequenceMapperEx.updateMinValue(BusinessConstants.SUPERMARKET_MATERIAL_NUMBER_SEQ);
        }
        return String.format("%05d", buildOnlyNumber);
    }*/

    /**
     * 生成商品编码(大写字母和数字混合)
     * 2024/1/2
     *
     * @return
     */
    public String buildMaterialNumber() {
        String materialNumber = supermarketMaterialMapperEx.getOnlyNUmberByMaxId();
        if (StringUtil.isEmpty(materialNumber)) {
            return "00001";
        }
        String onlyNumber = materialNumber.substring(18);

        if (isPositiveLongWithLength5(onlyNumber) && Integer.parseInt(onlyNumber) < 99999) {
            return String.format("%05d", Integer.parseInt(onlyNumber) + 1);
        } else if (onlyNumber.equals("99999")) {
            return "0000A";
        } else if (onlyNumber.equals("9999Z")) {
            return "000A0";
        } else if (onlyNumber.equals("999Z9")) {
            return "00A00";
        } else if (onlyNumber.equals("99Z99")) {
            return "0A000";
        } else if (onlyNumber.equals("9Z999")) {
            return "A0000";
        } else if (onlyNumber.equals("Z9999")) {
            return "000AA";
        } else if (onlyNumber.equals("999ZZ")) {
            return "00AA0";
        } else if (onlyNumber.equals("99ZZ9")) {
            return "0AA00";
        } else if (onlyNumber.equals("9ZZ99")) {
            return "AA000";
        } else if (onlyNumber.equals("ZZ999")) {
            return "00AAA";
        } else if (onlyNumber.equals("99ZZZ")) {
            return "0AAA0";
        } else if (onlyNumber.equals("9ZZZ9")) {
            return "AAA00";
        } else if (onlyNumber.equals("ZZZ99")) {
            return "0AAAA";
        } else if (onlyNumber.equals("9ZZZZ")) {
            return "AAAA0";
        } else if (onlyNumber.equals("ZZZZ9")) {
            return "AAAAA";
        } else if (onlyNumber.equals("ZZZZZ")) {
            throw new BusinessRunTimeException(ExceptionConstants.NUMBER_IS_EXIST_CODE, ExceptionConstants.SERIAL_NUMBERE_NOT_ENOUGH_MSG);
        } else {
            return generateMixedCode(onlyNumber);
        }
    }

    /**
     * 生成数字和字母混合的5位数编码
     *
     * @return
     */
    private String generateMixedCode(String code) {
        char[] chars = code.toCharArray();
        if (chars[4] < 'Z' && chars[4] != '9') {
            chars[4]++;
        } else {
            if (chars[4] == '9') {
                chars[4] = '0';
            } else {
                chars[4] = 'A';
            }

            if (chars[3] < 'Z' && chars[3] != '9') {
                chars[3]++;
            } else {
                if (chars[3] == '9') {
                    chars[3] = '0';
                } else {
                    chars[3] = 'A';
                }
                if (chars[2] < 'Z' && chars[2] != '9') {
                    chars[2]++;
                } else {
                    if (chars[2] == '9') {
                        chars[2] = '0';
                    } else {
                        chars[2] = 'A';
                    }
                    if (chars[1] < 'Z' && chars[1] != '9') {
                        chars[1]++;
                    } else {
                        if (chars[1] == '9') {
                            chars[1] = '0';
                        } else {
                            chars[1] = 'A';
                        }
                        if (chars[0] < 'Z' && chars[0] != '9') {
                            chars[0]++;
                        } else {
                            return "ZZZZZ";
                        }
                    }
                }
            }
        }
        return new String(chars);
    }
}
