package com.jsh.erp.service.shippingPrice;

import com.jsh.erp.service.ResourceInfo;

import java.lang.annotation.*;


@ResourceInfo(value = "shippingPrice")
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ShippingPriceResource {
}
