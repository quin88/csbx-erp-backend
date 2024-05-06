package com.jsh.erp.service.valueAddedServeType;

import com.jsh.erp.service.ResourceInfo;

import java.lang.annotation.*;

@ResourceInfo(value = "valueAddedServeType")
@Inherited

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValueAddedServeTypeResource {
}
