package com.jsh.erp.datasource.vo;

import com.jsh.erp.datasource.entities.DepotHead;

public class DepotHeadVo6List extends DepotHead {
    private String mImgName;

    private String mName;

    private String mMaterialUnit;

    private String operNumber;

    private String projectName;

    private String mBarCode;

    public String getmImgName() {
        return mImgName;
    }

    public void setmImgName(String mImgName) {
        this.mImgName = mImgName;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmMaterialUnit() {
        return mMaterialUnit;
    }

    public void setmMaterialUnit(String mMaterialUnit) {
        this.mMaterialUnit = mMaterialUnit;
    }

    public String getOperNumber() {
        return operNumber;
    }

    public void setOperNumber(String operNumber) {
        this.operNumber = operNumber;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getmBarCode() {
        return mBarCode;
    }

    public void setmBarCode(String mBarCode) {
        this.mBarCode = mBarCode;
    }
}
