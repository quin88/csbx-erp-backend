package com.jsh.erp.service.goodsAllocation;

import com.jsh.erp.service.ResourceInfo;

import java.lang.annotation.*;

/**
 * @author CSBX qq752718920  2018-10-7 15:26:27
 */
@ResourceInfo(value = "goodsAllocation")
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface GoodsAllocationResource {
}
