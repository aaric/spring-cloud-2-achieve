package com.incarcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * API网关启动类
 *
 * @author Aaric, created on 2019-12-11T10:50.
 * @version 0.0.5-SNAPSHOT
 */
@EnableZuulProxy
@SpringBootApplication
public class AppGateway {

    /**
     * Main
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        SpringApplication.run(AppGateway.class, args);
    }
}
