package com.qlmsoft.mbp.common.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {

    String name() default TargetDataSource.MASTER;

    public static String MASTER = "dataSource1";

    public static String SLAVE = "dataSource2";

}
