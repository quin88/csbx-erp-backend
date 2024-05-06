package com.jsh.erp.service.supermarketDocumentItem;

import com.jsh.erp.datasource.entities.SupermarketDocumentItem;
import com.jsh.erp.datasource.mappers.SupermarketDocumentItemMapper;
import com.jsh.erp.datasource.mappers.SupermarketDocumentItemMapperEx;
import com.jsh.erp.exception.JshException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupermarketDocumentItemService {
    private Logger logger = LoggerFactory.getLogger(SupermarketDocumentItemService.class);
    @Resource
    private SupermarketDocumentItemMapper supermarketDocumentItemMapper;
    @Resource
    private SupermarketDocumentItemMapperEx supermarketDocumentItemMapperEx;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void saveSupermarketDocumentItem(List<SupermarketDocumentItem> items, Long documentId, HttpServletRequest request) throws Exception {

        //获取主表id
        List<Long> existingIds = supermarketDocumentItemMapperEx.getExistingIds(documentId);
        List<Long> idList = new ArrayList<>();
        try {
            if (items != null && items.size() > 0) {
                for (SupermarketDocumentItem item : items) {
                    item.setSdId(documentId);
                    if (item.getId() == null) {
                        supermarketDocumentItemMapper.insertSelective(item);
                    } else {
                        supermarketDocumentItemMapper.updateByPrimaryKeySelective(item);
                        idList.add(item.getId());
                    }
                }
            }
            if (!existingIds.isEmpty()) {
                List<Long> ids = existingIds.stream().filter(id -> !idList.contains(id)).collect(Collectors.toList());
                if (!ids.isEmpty()) {
                    supermarketDocumentItemMapperEx.batchDeleteDocumentItemByIds(ids);
                }
            }
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
    }
}