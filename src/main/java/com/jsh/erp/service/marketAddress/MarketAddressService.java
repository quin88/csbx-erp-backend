package com.jsh.erp.service.marketAddress;

import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.*;
import com.jsh.erp.exception.JshException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MarketAddressService {

    private Logger logger = LoggerFactory.getLogger(MarketAddressService.class);

    @Resource
    private MarketAddressMapper marketAddressMapper;

    public MarketAddress selectOne(Long id) {
        MarketAddress result = null;
        try {
            result = marketAddressMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    public List<?> select() {
        List<MarketAddress> list = null;
        try {
            MarketAddressExample example = new MarketAddressExample();
            example.createCriteria();
            list = marketAddressMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public Long counts() {
        Long result = null;
        try {
            MarketAddressExample example = new MarketAddressExample();
            example.createCriteria();
            result = marketAddressMapper.countByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

}

