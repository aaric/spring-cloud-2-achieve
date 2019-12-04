package com.incarcloud.api.service;

import com.incarcloud.api.entity.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * OrderService
 *
 * @author Aaric, created on 2019-12-04T11:05.
 * @version 0.0.2-SNAPSHOT
 */
public interface OrderService {

    @GetMapping("/api/order/getDetail")
    List<Order> getDetail(@RequestParam("userId") Integer userId);
}
