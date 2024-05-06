package com.jsh.erp.service.valueAddedServe;

import com.jsh.erp.service.ResourceInfo;

import java.lang.annotation.*;

@ResourceInfo(value = "valueAddedServe")
@Inherited

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValueAddedServeResource {
}
