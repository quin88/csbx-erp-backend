package com.jsh.erp.service.signature;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.SignatureMapper;
import com.jsh.erp.datasource.mappers.SignatureMapperEx;
import com.jsh.erp.datasource.mappers.SupermarketDocumentMapperEx;
import com.jsh.erp.exception.BusinessRunTimeException;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class SignatureService {
    private Logger logger = LoggerFactory.getLogger(SignatureService.class);

    @Resource
    private SignatureMapper signatureMapper;

    @Resource
    private SignatureMapperEx signatureMapperEx;

    @Resource
    private SupermarketDocumentMapperEx supermarketDocumentMapperEx;

    public Signature getSignature(Long id) {
        Signature result = null;
        try {
            result = signatureMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    public List<Signature> select(String role, String name, int offset, int rows) {
        List<Signature> list = null;
        try {
            list = signatureMapperEx.selectByConditionSignature(role, name, offset, rows);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public Long countSignature(String role, String name) {
        Long result = null;
        try {
            result = signatureMapperEx.countSignature(role, name);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertSignature(JSONObject obj, HttpServletRequest request) {
        Signature signature = JSONObject.parseObject(obj.toJSONString(), Signature.class);
        int result = 0;

        signature.setEnabled(false);
        try {
            result = signatureMapper.insertSelective(signature);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateSignature(JSONObject obj, HttpServletRequest request) {
        Signature signature = JSONObject.parseObject(obj.toJSONString(), Signature.class);
        int result = 0;

        try {
            result = signatureMapper.updateByPrimaryKeySelective(signature);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteSignature(Long id, HttpServletRequest request) {
        return batchDeleteSignatureByIds(id.toString());
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteSignature(String ids, HttpServletRequest request) {
        return batchDeleteSignatureByIds(ids);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteSignatureByIds(String ids) {
        List<Long> idList = StringUtil.strToLongList(ids);

        //校验出入库单
        List<SupermarketDocument> supermarketDocumentList = null;
        try {
            supermarketDocumentList = supermarketDocumentMapperEx.getSupermarketDocumentListBySignatureIds(idList);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        if (supermarketDocumentList != null && supermarketDocumentList.size() > 0) {
            logger.error("异常码[{}],异常提示[{}],参数,signatureIds[{}]",
                    ExceptionConstants.DELETE_FORCE_CONFIRM_CODE, ExceptionConstants.DELETE_FORCE_CONFIRM_MSG, ids);
            throw new BusinessRunTimeException(ExceptionConstants.DELETE_FORCE_CONFIRM_CODE,
                    ExceptionConstants.DELETE_FORCE_CONFIRM_MSG);
        }
        int result = 0;
        try {
            result = signatureMapperEx.batchDeleteSignatureByIds(idList);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchSetActive(Boolean enabled, String ids) {
        List<Long> idList = StringUtil.strToLongList(ids);

        SignatureExample example = new SignatureExample();
        example.createCriteria().andIdIn(idList);
        Signature signature = new Signature();
        signature.setEnabled(enabled);
        int result = 0;
        try {
            result = signatureMapper.updateByExampleSelective(signature, example);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    public List<Signature> findBySelect( String role, boolean enable) {
        SignatureExample example = new SignatureExample();
        example.createCriteria().andRoleEqualTo(role).andEnabledEqualTo(enable)
                .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        example.setOrderByClause("id desc");
        List<Signature> list = null;
        try {
            list = signatureMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }
}
