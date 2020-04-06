package com.incarcloud.api.fallback;

import com.incarcloud.api.entity.User;
import com.incarcloud.api.feign.UserServiceFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * UserServiceFallback
 *
 * @author Aaric, created on 2019-12-10T11:30.
 * @version 0.0.3-SNAPSHOT
 */
@Slf4j
@Component
public class UserServiceFallback implements UserServiceFeign {

    @Override
    public User getUser(Integer id) {
        log.info("currentThreadName: {}", Thread.currentThread().getName());
        return new User(0, "Waiting UserService$getUser ...");
    }
}
