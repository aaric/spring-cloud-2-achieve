package com.incarcloud.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * 用户子系统启动类
 *
 * @author Aaric, created on 2019-12-03T15:49.
 * @version 0.4.1-SNAPSHOT
 */
@RefreshScope
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {
        "com.incarcloud.mvc",
        "com.incarcloud.user"
})
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
