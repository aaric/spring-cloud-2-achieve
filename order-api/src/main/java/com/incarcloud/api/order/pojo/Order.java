package com.incarcloud.api.order.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Order
 *
 * @author Aaric, created on 2019-12-04T11:09.
 * @version 0.4.1-SNAPSHOT
 */
@Data
@Accessors(chain = true) //支持setXxx链式编程习惯
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "订单信息")
public class Order {

    @ApiModelProperty(position = 1, value = "ID", required = true, example = "1")
    private Integer id;

    @ApiModelProperty(position = 2, value = "订单名称", required = true, example = "订单名称")
    private String orderName;

    @ApiModelProperty(position = 3, value = "订单归属人", required = true, example = "buyer")
    private String belongs;
}
