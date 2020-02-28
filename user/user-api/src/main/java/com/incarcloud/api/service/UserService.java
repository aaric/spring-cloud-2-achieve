package com.incarcloud.api.service;

import com.incarcloud.api.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * UserService
 *
 * @author Aaric, created on 2019-12-04T10:37.
 * @version 0.0.2-SNAPSHOT
 */
public interface UserService {

    @GetMapping("/user/getUser")
    User getUser(@RequestParam("id") Integer id);
}
