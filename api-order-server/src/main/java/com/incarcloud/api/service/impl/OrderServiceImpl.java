package com.incarcloud.api.service.impl;

import com.incarcloud.api.entity.Order;
import com.incarcloud.api.entity.User;
import com.incarcloud.api.feign.UserServiceFeign;
import com.incarcloud.api.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * OrderServiceImpl
 *
 * @author Aaric, created on 2019-12-04T11:06.
 * @version 0.0.2-SNAPSHOT
 */
@Slf4j
@RestController
public class OrderServiceImpl implements OrderService {

    @Autowired
    private UserServiceFeign userServiceFeign;

    @Override
    @GetMapping("/api/order/getDetail")
    public List<Order> getDetail(@RequestParam("userId") Integer userId) {
        User user = userServiceFeign.getUser(userId);
        return Arrays.asList(new Order(1, "macpro", user.getName()));
    }
}
