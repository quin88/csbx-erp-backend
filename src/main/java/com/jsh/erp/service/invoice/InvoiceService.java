package com.jsh.erp.service.invoice;

import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.dto.InvoiceNumberDTO;
import com.jsh.erp.datasource.entities.FileInfo;
import com.jsh.erp.datasource.entities.FileInfoExample;
import com.jsh.erp.datasource.entities.InvoiceNumber;
import com.jsh.erp.datasource.entities.InvoiceNumberExample;
import com.jsh.erp.datasource.mappers.FileInfoMapper;
import com.jsh.erp.datasource.mappers.InvoiceNumberMapper;
import com.jsh.erp.datasource.mappers.InvoiceNumberMapperEx;
import com.jsh.erp.datasource.vo.InvoiceNumberVoList;
import com.jsh.erp.exception.JshException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceService {
    private Logger logger = LoggerFactory.getLogger(InvoiceService.class);

    @Resource
    private InvoiceNumberMapper invoiceNumberMapper;
    @Resource
    private InvoiceNumberMapperEx invoiceNumberMapperEx;
    @Resource
    private FileInfoMapper fileInfoMapper;
    @Value(value = "${file.path}")
    private String filePath;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void saveInvoiceList(Long materialId, List<InvoiceNumber> invoiceList) {
        List<Long> existingIds = invoiceNumberMapperEx.getExistingIds(materialId);

        List<Long> idList = new ArrayList<>();
        try {
            if (invoiceList != null && invoiceList.size() > 0) {
                for (InvoiceNumber invoice : invoiceList) {
                    if (invoice.getId() == null) {
                        invoiceNumberMapper.insertSelective(invoice);
                    } else {
                        invoiceNumberMapper.updateByPrimaryKeySelective(invoice);
                        idList.add(invoice.getId());
                    }
                }
            }
            if (!existingIds.isEmpty()) {
                List<Long> ids = existingIds.stream().filter(id -> !idList.contains(id)).collect(Collectors.toList());
                if (!ids.isEmpty()) {
                    invoiceNumberMapperEx.batchDeleteInvoiceByIds(ids);
                }
            }
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteInvoiceByMaterialIds(List<Long> materialIds) {
        int result = 0;
        try {
            result = invoiceNumberMapperEx.batchDeleteInvoiceByMaterialIds(materialIds);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    public List<InvoiceNumber> findInvoiceListByMaterialId(Long materialId) {
        InvoiceNumberExample example = new InvoiceNumberExample();
        example.createCriteria().andMaterialIdEqualTo(materialId).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<InvoiceNumber> list = new ArrayList<>();
        try {
            list = invoiceNumberMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<InvoiceNumberVoList> findByAll(List<Long> materialIds) {
        List<InvoiceNumberVoList> list = null;
        try {
            list = invoiceNumberMapperEx.findByAll(materialIds);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public void saveFileInfoDetails(List<Long> fileIds, List<InvoiceNumberDTO> invoiceList) {
        for (InvoiceNumberDTO invoiceNumberDTO : invoiceList) {
            InvoiceNumberExample example = new InvoiceNumberExample();
            example.createCriteria().andBatchNumberEqualTo(invoiceNumberDTO.getBatchNumber())
                    .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
            List<InvoiceNumber> invoiceNumbers = invoiceNumberMapper.selectByExample(example);
            Long id = invoiceNumbers.stream().findFirst().get().getId();

            FileInfo info = new FileInfo();
            info.setFilePath(invoiceNumberDTO.getFilePath());
            info.setInvoiceNumberId(id);
            fileInfoMapper.insertSelective(info);
        }
        if (fileIds != null && fileIds.size() > 0) {
            FileInfoExample example = new FileInfoExample();
            example.createCriteria().andIdIn(fileIds);
            List<FileInfo> fileInfos = fileInfoMapper.selectByExample(example);
            for (FileInfo fileInfo : fileInfos) {
                deleteFile(fileInfo.getFilePath());
            }
            fileInfoMapper.deleteByExample(example);
        }
    }

    private void deleteFile(String fileName) {
        String fileUrl = filePath + File.separator + fileName;
        File file = new File(fileUrl);
        if (file.exists() && file.isFile()) {
            file.delete();
        }
    }
}
