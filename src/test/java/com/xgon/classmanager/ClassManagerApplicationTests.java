package com.xgon.classmanager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ClassManagerApplicationTests {

    @Test
    void contextLoads() {
        // System.getProperty("user.dir") 表示当前项目所在的目录（src目录的父目录的绝对路径）
        System.out.println(System.getProperty("user.dir"));
    }

}
