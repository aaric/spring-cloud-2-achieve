package com.incarcloud.api.service.impl;

import com.incarcloud.api.entity.User;
import com.incarcloud.api.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * UserServiceImpl
 *
 * @author Aaric, created on 2019-12-04T10:48.
 * @version 0.0.2-SNAPSHOT
 */
@Slf4j
@RestController
public class UserServiceImpl implements UserService {

    /**
     * 计数器
     */
    private static AtomicInteger counter = new AtomicInteger(0);

    @Override
    @GetMapping("/user/getUserOrder")
    public User getUser(@RequestParam("id") Integer id) {
        log.info("User-{}: id = {}", counter.incrementAndGet(), id);
        return new User(id, "user-" + id);
    }

    @Override
    @GetMapping("/user/getSleepT15")
    public String getSleepT15() {
        try {
            // 休眠1.5秒
            TimeUnit.MICROSECONDS.sleep(1500);
            return Thread.currentThread().getName();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
