package com.incarcloud.user.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(description = "用户信息")
public class User {

    @ApiModelProperty(position = 1, value = "ID", required = true, example = "1")
    private Integer id;

    @ApiModelProperty(position = 2, value = "用户名", required = true, example = "admin")
    private String username;
}
