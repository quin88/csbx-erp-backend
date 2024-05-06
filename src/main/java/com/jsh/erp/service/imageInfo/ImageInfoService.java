package com.jsh.erp.service.imageInfo;

import com.jsh.erp.datasource.entities.ImageInfo;
import com.jsh.erp.datasource.entities.ImageInfoExample;
import com.jsh.erp.datasource.entities.SalesMarket;
import com.jsh.erp.datasource.mappers.ImageInfoMapper;
import com.jsh.erp.datasource.mappers.ImageInfoMapperEx;
import com.jsh.erp.exception.JshException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageInfoService {
    private Logger logger = LoggerFactory.getLogger(ImageInfoService.class);

    @Resource
    private ImageInfoMapper imageInfoMapper;

    @Resource
    private ImageInfoMapperEx imageInfoMapperEx;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void saveImageInfoList(Long materialId, List<ImageInfo> imageInfoList) {
        List<Long> existingIds = imageInfoMapperEx.getExistingIds(materialId);

        List<Long> idList = new ArrayList<>();
        try {
            if (imageInfoList != null && imageInfoList.size() > 0) {
                for (ImageInfo imageInfo : imageInfoList) {
                    if (imageInfo.getId() == null) {
                        imageInfoMapper.insertSelective(imageInfo);
                    } else {
                        imageInfoMapper.updateByPrimaryKeySelective(imageInfo);
                        idList.add(imageInfo.getId());
                    }
                }
            }
            if (!existingIds.isEmpty()) {
                List<Long> ids = existingIds.stream().filter(id -> !idList.contains(id)).collect(Collectors.toList());
                if (!ids.isEmpty()) {
                    for (Long id : ids) {
                        imageInfoMapper.deleteByPrimaryKey(id);
                    }
                }
            }
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteImageInfoByMaterialIds(List<Long> materialIds) {
        int result = 0;
        ImageInfoExample example = new ImageInfoExample();
        example.createCriteria().andMaterialIdIn(materialIds);
        try {
            result = imageInfoMapper.deleteByExample(example);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    public List<ImageInfo> findImageInfoListByMaterialId(Long materialId) {
        ImageInfoExample example = new ImageInfoExample();
        example.createCriteria().andMaterialIdEqualTo(materialId);
        List<ImageInfo> list = new ArrayList<>();
        try {
            list = imageInfoMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }
}
