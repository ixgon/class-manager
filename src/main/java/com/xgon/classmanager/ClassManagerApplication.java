package com.xgon.classmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.xgon.classmanager.mapper")
public class ClassManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClassManagerApplication.class, args);
    }

}
