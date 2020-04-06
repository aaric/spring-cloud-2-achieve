package com.incarcloud.api.order.pojo;

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
public class Order {

    private Integer id;

    private String orderName;

    private String belongs;
}