package com.jsh.erp.service.market;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.*;
import com.jsh.erp.exception.BusinessRunTimeException;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.log.LogService;
import com.jsh.erp.service.marketArea.MarketAreaService;
import com.jsh.erp.service.user.UserService;
import com.jsh.erp.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
public class MarketService {
    private Logger logger = LoggerFactory.getLogger(MarketService.class);
    @Resource
    private SequenceMapperEx sequenceMapperEx;
    @Resource
    private LogService logService;
    @Resource
    private MarketMapper marketMapper;
    @Resource
    private MarketMapperEx marketMapperEx;
    @Resource
    private UserService userService;
    @Resource
    private MarketAreaService marketAreaService;
    @Resource
    private MarketAreaMapper marketAreaMapper;
    @Resource
    private MarketAreaMapperEx marketAreaMapperEx;
    @Resource
    private SupermarketSupplierMapperEx supermarketSupplierMapperEx;

    public Market selectOne(Long id) {
        Market result = null;
        try {
            result = marketMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    public List<?> select(String number, String name, String enabled, int offset, int rows) {
        List<Market> list = null;
        try {
            list = marketMapperEx.selectByConditionMarket(number, name, enabled, offset, rows);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public Long counts(String number, String name, String enabled) {
        Long result = null;
        try {
            result = marketMapperEx.countByConditionMarket(number, name, enabled);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertMarket(JSONObject obj, HttpServletRequest request) throws Exception {
        Market market = JSONObject.parseObject(obj.toJSONString(), Market.class);
        int result = 0;
        User userInfo = userService.getCurrentUser();
        try {
            market.setEnabled(false);
            result = marketMapper.insertSelective(market);
            //更新编号表数值
            sequenceMapperEx.updateBuildOnlyNumber(BusinessConstants.MARKET_NUMBER_SEQ); //编号+1
            logService.insertLog("市场管理",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ADD).append(market.getName()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    public int updateMarket(JSONObject obj, HttpServletRequest request) throws Exception {
        Market market = JSONObject.parseObject(obj.toJSONString(), Market.class);
        int result = 0;
        User userInfo = userService.getCurrentUser();
        try {
            result = marketMapper.updateByPrimaryKeySelective(market);
            logService.insertLog("市场管理",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(market.getName()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    public int deleteMarket(Long id, HttpServletRequest request) throws Exception {
        return batchDeleteMarketByIds(id.toString(), request);
    }

    public int batchDeleteMarket(String ids, HttpServletRequest request) throws Exception {
        return batchDeleteMarketByIds(ids, request);
    }

    /**
     * 批量删除接口
     *
     * @param ids
     * @return
     * @throws Exception
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteMarketByIds(String ids, HttpServletRequest request) throws Exception {
        int result = 0;
        User userInfo = userService.getCurrentUser();
        List<Long> marketIds = StringUtil.strToLongList(ids);
        //只有未挂钩供应商的市场可以删除
        Long res = supermarketSupplierMapperEx.countHasSupplier(marketIds);
        if (res > 0) {
            throw new BusinessRunTimeException(ExceptionConstants.MARKET_DELETE_FAILED_CODE,
                    String.format(ExceptionConstants.MARKET_DELETE_FAILED_MSG));
        }
        Market market = new Market();
        market.setDeleteFlag(BusinessConstants.DELETE_FLAG_DELETED);
        MarketExample example = new MarketExample();
        example.createCriteria().andIdIn(marketIds);
        try {
            result = marketMapper.updateByExampleSelective(market, example);
            //同步删除市场地区
            String[] idArray = ids.split(",");
            marketAreaMapperEx.batchDeleteByMarketIds(idArray);
            logService.insertLog("市场管理",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_DELETE).append(ids).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchSetActive(Boolean enabled, String ids) throws Exception {
        logService.insertLog("市场管理",
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ENABLED).append(ids).toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        List<Long> marketIds = StringUtil.strToLongList(ids);
        Market market = new Market();
        market.setEnabled(enabled);
        MarketExample example = new MarketExample();
        example.createCriteria().andIdIn(marketIds);
        int result = 0;
        try {
            result = marketMapper.updateByExampleSelective(market, example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public Object addMarketAndArea(MarketVo4Body body, HttpServletRequest request) throws Exception {
        Market market = new Market();
        BeanUtils.copyProperties(body, market);
        //校验编号是否重复
        if (checkIsNumberNoExist(0L, market.getNumber())) {
            throw new BusinessRunTimeException(ExceptionConstants.NUMBER_IS_EXIST_CODE,
                    String.format(ExceptionConstants.NUMBER_IS_EXIST_MSG)
            );
        }
        User userInfo = userService.getCurrentUser();
        market.setEnabled(false);
        marketMapper.insertSelective(market);
        //根据编号查询id
        Long maId = marketMapperEx.selectMarketByNumber(market.getNumber());
        marketAreaService.saveAreaDetail(body.getMarketAreaList(), maId, request);
        //更新编号表数值
        sequenceMapperEx.updateBuildOnlyNumber(BusinessConstants.MARKET_NUMBER_SEQ); //编号+1
        logService.insertLog("市场管理",
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ADD).append(market.getName()).toString(), request);

        return ExceptionConstants.standardSuccess();
    }

    private boolean checkIsNumberNoExist(Long id, String number) {
        MarketExample example = new MarketExample();
        example.createCriteria().andIdNotEqualTo(id).andNumberEqualTo(number).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<Market> list = null;
        try {
            list = marketMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list != null && !list.isEmpty();
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public Object updateMarketAndArea(MarketVo4Body body, HttpServletRequest request) throws Exception {
        Market market = new Market();
        BeanUtils.copyProperties(body, market);
        User userInfo = userService.getCurrentUser();
        marketMapper.updateByPrimaryKey(market);
        marketAreaService.updateAreaDetail(body.getMarketAreaList(), market.getId(), request);
        logService.insertLog("市场管理",
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(market.getName()).toString(), request);

        return ExceptionConstants.standardSuccess();
    }

    public Object findById(Long id, HttpServletRequest request) {
        Market result = marketMapper.selectByPrimaryKey(id);
        MarketVo4Body marketVo = new MarketVo4Body();
        BeanUtils.copyProperties(result, marketVo);
        //查询市场信息
        MarketAreaExample example = new MarketAreaExample();
        example.createCriteria().andMarketIdEqualTo(id).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<MarketArea> marketAreas = marketAreaMapper.selectByExample(example);
        marketVo.setMarketAreaList(marketAreas);
        return marketVo;
    }
}

