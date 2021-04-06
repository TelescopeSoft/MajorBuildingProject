package com.qlmsoft.mbp.common.datasource;

import com.qlmsoft.mbp.common.annotation.TargetDataSource;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class DataSourceExchange implements MethodBeforeAdvice, AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        DataSourceHolder.clearDataSource();
    }

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        // 这里TargetDataSource是自定义的注解
        if (method.isAnnotationPresent(TargetDataSource.class)) {
            TargetDataSource datasource = method.getAnnotation(TargetDataSource.class);
            DataSourceHolder.setDataSource(datasource.name());
        } else {
            if (target.getClass().isAnnotationPresent(TargetDataSource.class)) {
                TargetDataSource datasource = target.getClass().getAnnotation(TargetDataSource.class);
                DataSourceHolder.setDataSource(datasource.name());
            } else {
                DataSourceHolder.setDataSource(TargetDataSource.MASTER);
            }
        }

    }
}
