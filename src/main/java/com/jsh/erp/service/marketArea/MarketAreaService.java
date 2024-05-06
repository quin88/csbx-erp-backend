package com.jsh.erp.service.marketArea;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.MarketAreaMapper;
import com.jsh.erp.datasource.mappers.MarketAreaMapperEx;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.log.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class MarketAreaService {
    private Logger logger = LoggerFactory.getLogger(MarketAreaService.class);
    @Resource
    private MarketAreaMapper marketAreaMapper;

    @Resource
    private MarketAreaMapperEx marketAreaMapperEx;

    @Resource
    private LogService logService;

    public Object getMarketArea(Long id) {
        MarketArea result = null;
        try {
            result = marketAreaMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertMarketArea(JSONObject obj, HttpServletRequest request) {
        MarketArea marketArea = JSONObject.parseObject(obj.toJSONString(), MarketArea.class);
        int result = 0;
        try {
            result = marketAreaMapper.insertSelective(marketArea);
            logService.insertLog("市场区域",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ADD).append(marketArea.getName()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateMarketArea(JSONObject obj, HttpServletRequest request) {
        MarketArea marketArea = JSONObject.parseObject(obj.toJSONString(), MarketArea.class);
        int result = 0;
        try {
            result = marketAreaMapper.updateByPrimaryKeySelective(marketArea);
            logService.insertLog("市场区域",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(marketArea.getName()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteMarketArea(Long id, HttpServletRequest request) throws Exception {
        return batchDeleteMarketAreaByIds(id.toString());
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteMarketArea(String ids, HttpServletRequest request) throws Exception {
        return batchDeleteMarketAreaByIds(ids);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteMarketAreaByIds(String ids) throws Exception {
        logService.insertLog("市场区域",
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_DELETE).append(ids).toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        String[] idArray = ids.split(",");
        try {
            return marketAreaMapperEx.batchDeleteMarketAreaByIds(idArray);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
            return 0;
        }
    }

    public void saveAreaDetail(List<MarketArea> marketAreaList, Long maId, HttpServletRequest request) {
        try {
            for (MarketArea marketArea : marketAreaList) {
                marketArea.setMarketId(maId);
                marketAreaMapper.insertSelective(marketArea);
                logService.insertLog("市场区域",
                        new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ADD).append(marketArea.getName()).toString(), request);
            }
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
    }

    public void updateAreaDetail(List<MarketArea> marketAreaList, Long maId, HttpServletRequest request) throws Exception {
        //删除原有数据
        deleteAreaDetail(maId);
        try {
            for (MarketArea marketArea : marketAreaList) {
                marketArea.setMarketId(maId);
                marketAreaMapper.insertSelective(marketArea);
                logService.insertLog("市场区域",
                        new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ADD).append(marketArea.getName()).toString(), request);
            }
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void deleteAreaDetail(Long maId) throws Exception {
        MarketAreaExample example = new MarketAreaExample();
        example.createCriteria().andMarketIdEqualTo(maId);
        try {
            marketAreaMapper.deleteByExample(example);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
    }
}
