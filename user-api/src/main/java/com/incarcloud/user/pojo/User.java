package com.incarcloud.user.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * User
 *
 * @author Aaric, created on 2019-12-04T10:34.
 * @version 0.4.1-SNAPSHOT
 */
@Data
@Accessors(chain = true) //支持setXxx链式编程习惯
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;

    private String name;
}