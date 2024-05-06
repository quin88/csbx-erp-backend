package com.jsh.erp.service.paymentRecords;

import com.jsh.erp.service.ResourceInfo;

import java.lang.annotation.*;


@ResourceInfo(value = "paymentRecords")
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface PaymentRecordsResource {
}
