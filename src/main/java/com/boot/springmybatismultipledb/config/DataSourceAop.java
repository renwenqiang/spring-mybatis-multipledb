package com.boot.springmybatismultipledb.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DataSourceAop {
    @Before("execution(* com.boot.springmybatismultipledb.mapper.OrderMapper.*(..))")
    public void setDataSource1() {
        DataSourceType.setDataBaseType(DataSourceType.DataBaseType.ds1);
    }
    @Before("execution(* com.boot.springmybatismultipledb.mapper.StorageMapper.*(..))")
    public void setDataSource2() {
        DataSourceType.setDataBaseType(DataSourceType.DataBaseType.ds2);
    }
}