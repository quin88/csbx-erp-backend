package com.jsh.erp.service.supermarketSystemConfig;

import com.jsh.erp.service.ResourceInfo;

import java.lang.annotation.*;

@ResourceInfo(value = "supermarketSystemConfig")
@Inherited

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SupermarketSystemConfigResource {
}
