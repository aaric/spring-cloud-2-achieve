package com.incarcloud.oauth2.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户信息
 *
 * @author Aaric, created on 2020-04-11T19:19.
 * @version 0.1.0-SNAPSHOT
 */
@Data
@Accessors(chain = true)
@TableName
public class RbacUser {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String username;
    private String phoneNumber;
    private String email;
    private String password;
    private String passwordSalt;
}
