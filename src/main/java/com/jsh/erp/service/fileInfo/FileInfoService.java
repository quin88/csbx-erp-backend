package com.jsh.erp.service.fileInfo;

import com.jsh.erp.datasource.entities.FileInfo;
import com.jsh.erp.datasource.entities.FileInfoExample;
import com.jsh.erp.datasource.mappers.FileInfoMapper;
import com.jsh.erp.datasource.mappers.FileInfoMapperEx;
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
public class FileInfoService {
    private Logger logger = LoggerFactory.getLogger(FileInfoService.class);

    @Resource
    private FileInfoMapper fileInfoMapper;

    @Resource
    private FileInfoMapperEx fileInfoMapperEx;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void saveFileInfoList(Long materialId, Long baseInfoId, List<FileInfo> fileInfoList) {
        List<Long> existingIds = fileInfoMapperEx.getExistingIds(materialId, baseInfoId);

        List<Long> idList = new ArrayList<>();
        try {
            if (fileInfoList != null && fileInfoList.size() > 0) {
                for (FileInfo fileInfo : fileInfoList) {
                    if (fileInfo.getId() == null) {
                        fileInfoMapper.insertSelective(fileInfo);
                    } else {
                        fileInfoMapper.updateByPrimaryKeySelective(fileInfo);
                        idList.add(fileInfo.getId());
                    }
                }
            }
            if (!existingIds.isEmpty()) {
                List<Long> ids = existingIds.stream().filter(id -> !idList.contains(id)).collect(Collectors.toList());
                if (!ids.isEmpty()) {
                    for (Long id : ids) {
                        fileInfoMapper.deleteByPrimaryKey(id);
                    }
                }
            }
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteFileInfoByMaterialIds(List<Long> materialIds) {
        int result = 0;
        FileInfoExample example = new FileInfoExample();
        example.createCriteria().andMaterialIdIn(materialIds);
        try {
            result = fileInfoMapper.deleteByExample(example);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    public List<FileInfo> findFileInfoListByMaterialId(Long materialId) {
        FileInfoExample example = new FileInfoExample();
        example.createCriteria().andMaterialIdEqualTo(materialId);
        List<FileInfo> list = new ArrayList<>();
        try {
            list = fileInfoMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<FileInfo> findFileInfoListByInvoiceNumberId(Long invoiceNumberId) {
        FileInfoExample example = new FileInfoExample();
        example.createCriteria().andInvoiceNumberIdEqualTo(invoiceNumberId);
        List<FileInfo> list = new ArrayList<>();
        try {
            list = fileInfoMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }
}
