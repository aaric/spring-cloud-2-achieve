package com.incarcloud.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * OAuth2服务端启动类
 *
 * @author Aaric, created on 2020-04-07T19:22.
 * @version 0.6.0-SNAPSHOT
 */
@RefreshScope
@EnableDiscoveryClient
@SpringBootApplication
public class App {

    /**
     * Main
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        SpringApplication.run(com.incarcloud.oauth2.App.class, args);
    }
}
