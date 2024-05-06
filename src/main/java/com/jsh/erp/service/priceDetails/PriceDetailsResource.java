package com.jsh.erp.service.priceDetails;

import com.jsh.erp.service.ResourceInfo;

import java.lang.annotation.*;


@ResourceInfo(value = "priceDetails")
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface PriceDetailsResource {
}
