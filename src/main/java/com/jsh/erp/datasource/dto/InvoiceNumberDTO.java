package com.jsh.erp.datasource.dto;

import java.io.Serializable;
import java.util.List;

public class InvoiceNumberDTO implements Serializable {

    private String batchNumber;

    private String filePath;

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
