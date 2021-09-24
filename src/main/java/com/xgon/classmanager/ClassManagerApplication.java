package com.xgon.classmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>FileName:&ensp;com.xgon.classmanager.<strong>ClassManagerApplication.java</strong></p>
 * <p>Date:&ensp;2021-09-24 13:29</p>
 * <p>Description:&ensp;项目启动类</p>
 *
 * @author <a href="mail to: laoshi1998@outlook.com" rel="nofollow">xgon</a>
 * @version 1.0.0
 */
@SpringBootApplication
@MapperScan("com.xgon.classmanager.mapper")
public class ClassManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClassManagerApplication.class, args);
    }
}
