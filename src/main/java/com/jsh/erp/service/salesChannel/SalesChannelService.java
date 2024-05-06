package com.jsh.erp.service.salesChannel;

import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.entities.SalesChannel;
import com.jsh.erp.datasource.entities.SalesChannelExample;
import com.jsh.erp.datasource.mappers.SalesChannelMapper;
import com.jsh.erp.exception.JshException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SalesChannelService {
    private Logger logger = LoggerFactory.getLogger(SalesChannelService.class);

    @Resource
    private SalesChannelMapper salesChannelMapper;

    public List<SalesChannel> findBySalesChannel() {
        SalesChannelExample example = new SalesChannelExample();
        example.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<SalesChannel> list = null;
        try {
            list = salesChannelMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }
}
