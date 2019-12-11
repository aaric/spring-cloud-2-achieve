package com.incarcloud.api.service.impl;

import com.incarcloud.api.entity.Order;
import com.incarcloud.api.entity.User;
import com.incarcloud.api.feign.UserServiceFeign;
import com.incarcloud.api.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * OrderServiceImpl
 *
 * @author Aaric, created on 2019-12-04T11:06.
 * @version 0.0.2-SNAPSHOT
 */
@Slf4j
@RestController
public class OrderServiceImpl implements OrderService {

    /**
     * 数据来源配置中心
     */
    @Value("${custom.title}")
    private String customTitle;

    /**
     * 计数器
     */
    private static AtomicInteger counter = new AtomicInteger(0);

    @Autowired
    private UserServiceFeign userServiceFeign;

    @Override
    @GetMapping("/order/getDetail")
    public List<Order> getDetail(@RequestParam("userId") Integer userId) {
        log.info("currentThreadName: {}", Thread.currentThread().getName());
        log.info("Order-{}: userId = {}", counter.incrementAndGet(), userId);
        User user = userServiceFeign.getUser(userId);
        return Arrays.asList(new Order(1, "macpro", user.getName()));
    }

    @Override
    @GetMapping("/order/getCustomTitle")
    public String getCustomTitle() {
        return customTitle;
    }
}
