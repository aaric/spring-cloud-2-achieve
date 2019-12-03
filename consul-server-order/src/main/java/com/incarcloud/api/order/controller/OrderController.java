package com.incarcloud.api.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单管理控制器
 *
 * @author Aaric, created on 2019-12-03T15:51.
 * @version 0.0.1-SNAPSHOT
 */
@RestController
@RequestMapping("/api/order")
public class OrderController {

    @GetMapping("/getName")
    public String getName() {
        return "order01";
    }
}
