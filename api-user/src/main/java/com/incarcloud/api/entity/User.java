package com.incarcloud.api.entity;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * User
 *
 * @author Aaric, created on 2019-12-04T10:34.
 * @version 0.0.2-SNAPSHOT
 */
@Getter
@Setter
@ToString(callSuper = true)
@Accessors(chain = true) //支持setXxx链式编程习惯
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;

    private String name;
}
