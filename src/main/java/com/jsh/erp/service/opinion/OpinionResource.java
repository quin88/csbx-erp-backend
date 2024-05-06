package com.jsh.erp.service.opinion;

import com.jsh.erp.service.ResourceInfo;

import java.lang.annotation.*;

@ResourceInfo(value = "opinion")
@Inherited

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface OpinionResource {
}
