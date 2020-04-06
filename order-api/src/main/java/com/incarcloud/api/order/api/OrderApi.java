package com.incarcloud.api.order.api;

import com.incarcloud.api.order.pojo.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * OrderService
 *
 * @author Aaric, created on 2019-12-04T11:05.
 * @version 0.4.1-SNAPSHOT
 */
public interface OrderApi {

    @GetMapping("/getDetail")
    List<Order> getDetail(@RequestParam("userId") Integer userId);

    @GetMapping("/getCustomTitle")
    String getCustomTitle();
}
