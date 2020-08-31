package com.boot.springmybatismultipledb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@MapperScan("com.boot.springmybatismultipledb.mapper")
public class SpringMybatisMultipledbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMybatisMultipledbApplication.class, args);
    }

}
