package com.jsh.erp.service.shippingMethod;

import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.entities.ShippingMethod;
import com.jsh.erp.datasource.entities.ShippingMethodExample;
import com.jsh.erp.datasource.mappers.ShippingMethodMapper;
import com.jsh.erp.exception.JshException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class ShippingMethodService {
    private Logger logger = LoggerFactory.getLogger(ShippingMethodService.class);

    @Resource
    private ShippingMethodMapper shippingMethodMapper;

    public List<ShippingMethod> findByShippingMethod() {
        ShippingMethodExample example = new ShippingMethodExample();
        example.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<ShippingMethod> list = null;
        try {
            list = shippingMethodMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }
}
