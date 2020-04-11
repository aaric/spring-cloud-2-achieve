package com.incarcloud.oauth2.rbac.service;

import com.incarcloud.oauth2.pojo.RbacUser;

/**
 * 用户信息服务接口
 *
 * @author Aaric, created on 2020-04-11T20:15.
 * @version 0.7.0-SNAPSHOT
 */
public interface RbacUserService {

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return
     */
    RbacUser getByUsername(String username);
}
