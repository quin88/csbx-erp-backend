package com.jsh.erp.service.rechargeAmount;

import com.jsh.erp.service.ResourceInfo;

import java.lang.annotation.*;

@ResourceInfo(value = "rechargeConfiguration")
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RechargeConfigurationResource {
}
