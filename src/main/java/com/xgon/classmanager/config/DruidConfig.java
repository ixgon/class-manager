package com.xgon.classmanager.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * <p>FileName:&ensp;com.xgon.classmanager.config.<strong>DruidConfig.java</strong></p>
 * <p>Date:&ensp;2021-09-24 15:06</p>
 * <p>Description:&ensp;数据源与数据库连接池配置</p>
 *
 * @author <a href="mail to: laoshi1998@outlook.com" rel="nofollow">xgon</a>
 * @version 1.0.0
 */
@Configuration
public class DruidConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druid() {
        return new DruidDataSource();
    }
}
