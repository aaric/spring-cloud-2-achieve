package com.incarcloud.mybatis.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * MybatisPlus配置支持
 *
 * @author Aaric, created on 2020-04-11T18:37.
 * @version 0.7.0-SNAPSHOT
 */
public abstract class MybatisPlusConfigurationSupport {

    /**
     * 使用HikariCP数据库连接池
     *
     * @return
     */
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * MybatisPlus分页插件
     *
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
