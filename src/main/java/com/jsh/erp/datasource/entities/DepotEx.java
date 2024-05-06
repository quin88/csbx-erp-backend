package com.jsh.erp.datasource.entities;

import com.jsh.erp.datasource.vo.BusinessHoursVo;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * Description
 *
 * @Author: cjl
 * @Date: 2019/2/25 11:40
 */
@Data
public class DepotEx extends Depot {
    //负责人名字
    private String principalName;

    private BigDecimal initStock;

    private BigDecimal currentStock;

    private BigDecimal lowSafeStock;

    private BigDecimal highSafeStock;

    private List<BusinessHoursVo> businessHours;

    //负责人名字(手输)
    private String principalNameInput;

    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
    }

    public BigDecimal getInitStock() {
        return initStock;
    }

    public void setInitStock(BigDecimal initStock) {
        this.initStock = initStock;
    }

    public BigDecimal getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(BigDecimal currentStock) {
        this.currentStock = currentStock;
    }

    public BigDecimal getLowSafeStock() {
        return lowSafeStock;
    }

    public void setLowSafeStock(BigDecimal lowSafeStock) {
        this.lowSafeStock = lowSafeStock;
    }

    public BigDecimal getHighSafeStock() {
        return highSafeStock;
    }

    public void setHighSafeStock(BigDecimal highSafeStock) {
        this.highSafeStock = highSafeStock;
    }

    public List<BusinessHoursVo> getBusinessHours() {
        return businessHours;
    }

    public void setBusinessHours(List<BusinessHoursVo> businessHours) {
        this.businessHours = businessHours;
    }

    public String getPrincipalNameInput() {
        return principalNameInput;
    }

    public void setPrincipalNameInput(String principalNameInput) {
        this.principalNameInput = principalNameInput;
    }
}
