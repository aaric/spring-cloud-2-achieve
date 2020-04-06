package com.incarcloud.user.api.impl;

import com.incarcloud.user.api.UserApi;
import com.incarcloud.user.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * UserServiceImpl
 *
 * @author Aaric, created on 2019-12-04T10:48.
 * @version 0.4.1-SNAPSHOT
 */
@Slf4j
@RestController
public class UserServiceImpl implements UserApi {

    /**
     * 计数器
     */
    private static AtomicInteger counter = new AtomicInteger(0);

    @Value("${custom.name}")
    private String customName;

    @Override
    @GetMapping("/getUser")
    public User getUser(@RequestParam("id") Integer id) {
        log.info("User-{}: id = {}", counter.incrementAndGet(), id);
        return new User(id, customName);
    }
}
