package com.incarcloud.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 订单子系统启动类
 *
 * @author Aaric, created on 2019-12-03T15:49.
 * @version 0.0.1-SNAPSHOT
 */
@EnableDiscoveryClient
@SpringBootApplication
public class AppOrder {

    /**
     * Main
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        SpringApplication.run(AppOrder.class, args);
    }
}
