package com.jsh.erp.service.depotHead;

import com.jsh.erp.service.ResourceInfo;

import java.lang.annotation.*;

/**
 * @author CSBX qq752718920  2018-10-7 15:26:27
 */
@ResourceInfo(value = "depotHead")
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DepotHeadResource {
}
