package com.jsh.erp.datasource.vo;

import java.util.Date;
import java.util.List;

public class SettlementMethodVo {
    private Long id;

    private String settlement;

    private Date createTime;

    private Long creator;

    private String remark;

    private String status;

    private List<SecondSettlementMethodVo> secondSettlementMethod;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSettlement() {
        return this.settlement;
    }

    public void setSettlement(String settlement) {
        this.settlement = settlement;
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

    public List<SecondSettlementMethodVo> getSecondSettlementMethod() {
        return this.secondSettlementMethod;
    }

    public void setSecondSettlementMethod(List<SecondSettlementMethodVo> secondSettlementMethod) {
        this.secondSettlementMethod = secondSettlementMethod;
    }
}
