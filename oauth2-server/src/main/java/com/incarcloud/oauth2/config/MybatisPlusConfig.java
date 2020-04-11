package com.incarcloud.oauth2.config;

import com.incarcloud.mybatis.config.MybatisPlusConfigurationSupport;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MybatisPlus配置
 *
 * @author Aaric, created on 2020-04-11T19:26.
 * @version 0.7.0-SNAPSHOT
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "com.incarcloud.oauth2.**.mapper")
public class MybatisPlusConfig extends MybatisPlusConfigurationSupport {
}
