package com.jsh.erp.service.priceReceipts;

import com.jsh.erp.service.ResourceInfo;

import java.lang.annotation.*;


@ResourceInfo(value = "priceReceipts")
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface PriceReceiptsResource {
}
