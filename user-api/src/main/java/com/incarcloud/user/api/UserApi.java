package com.incarcloud.user.api;

import com.incarcloud.user.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * UserService
 *
 * @author Aaric, created on 2019-12-04T10:37.
 * @version 0.4.1-SNAPSHOT
 */
public interface UserApi {

    @GetMapping("/user/getUser")
    User getUser(@RequestParam("id") Integer id);
}
