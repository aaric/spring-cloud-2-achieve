package com.incarcloud.api.service.impl;

import com.incarcloud.api.entity.User;
import com.incarcloud.api.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserServiceImpl
 *
 * @author Aaric, created on 2019-12-04T10:48.
 * @version 0.0.2-SNAPSHOT
 */
@Slf4j
@RestController
public class UserServiceImpl implements UserService {

    @Override
    @GetMapping("/api/user/getUserOrder")
    public User getUser(@RequestParam("id") Integer id) {
        return new User(id, "user-" + id);
    }
}
