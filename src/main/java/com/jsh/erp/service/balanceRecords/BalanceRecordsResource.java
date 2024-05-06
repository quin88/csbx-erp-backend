package com.jsh.erp.service.balanceRecords;

import com.jsh.erp.service.ResourceInfo;

import java.lang.annotation.*;


@ResourceInfo(value = "balanceRecords")
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface BalanceRecordsResource {
}
