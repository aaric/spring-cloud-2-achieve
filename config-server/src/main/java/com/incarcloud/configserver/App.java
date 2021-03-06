package com.incarcloud.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 配置中心系统启动类
 *
 * @author Aaric, created on 2019-12-10T12:41.
 * @version 0.4.1-SNAPSHOT
 */
@EnableConfigServer
@SpringBootApplication
public class App {

    /**
     * Main
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
