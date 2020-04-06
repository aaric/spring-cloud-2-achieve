package com.incarcloud.api.order.api;

import com.incarcloud.api.order.pojo.Order;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * OrderService
 *
 * @author Aaric, created on 2019-12-04T11:05.
 * @version 0.4.1-SNAPSHOT
 */
@Api(tags = "订单管理API")
public interface OrderApi {

    @ApiOperation(value = "查询订单详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", dataType = "Integer", paramType = "query")
    })
    @GetMapping("/order/getDetail")
    List<Order> getDetail(@RequestParam("userId") Integer userId);

    @ApiOperation(value = "查询自定义标题")
    @GetMapping("/order/getCustomTitle")
    String getCustomTitle();
}
