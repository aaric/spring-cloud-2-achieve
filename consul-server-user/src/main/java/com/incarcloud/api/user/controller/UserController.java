package com.incarcloud.api.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;

/**
 * com.incarcloud.api.user.controller
 *
 * @author Aaric, created on 2019-12-03T16:16.
 * @version 0.0.1-SNAPSHOT
 */
@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getUserOrder")
    public String getUserOrder() {
        String url = MessageFormat.format("http://{0}/api/order/getName", "server-order");
        log.debug("url-> " + url);
        return "user: " + restTemplate.getForObject(url, String.class);
    }
}
