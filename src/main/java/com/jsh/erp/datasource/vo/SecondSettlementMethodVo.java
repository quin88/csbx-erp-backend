package com.jsh.erp.datasource.vo;

import java.util.Date;

public class SecondSettlementMethodVo {
    private Long id;

    private Long settlementId;

    private String secondSettlementMethod;

    private Date createTime;

    private Long creator;

    private Date updateTime;

    private Long updater;

    private String remark;

    private String status;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSettlementId() {
        return this.settlementId;
    }

    public void setSettlementId(Long settlementId) {
        this.settlementId = settlementId;
    }

    public String getSecondSettlementMethod() {
        return this.secondSettlementMethod;
    }

    public void setSecondSettlementMethod(String secondSettlementMethod) {
        this.secondSettlementMethod = secondSettlementMethod;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreator() {
        return this.creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdater() {
        return this.updater;
    }

    public void setUpdater(Long updater) {
        this.updater = updater;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
