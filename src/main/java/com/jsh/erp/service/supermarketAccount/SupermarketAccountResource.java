package com.jsh.erp.service.supermarketAccount;

import com.jsh.erp.service.ResourceInfo;
import java.lang.annotation.*;

@ResourceInfo(value = "supermarketAccount")
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SupermarketAccountResource {
}
