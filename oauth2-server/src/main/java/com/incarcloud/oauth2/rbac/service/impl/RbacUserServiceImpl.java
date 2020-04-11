package com.incarcloud.oauth2.rbac.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.incarcloud.oauth2.pojo.RbacUser;
import com.incarcloud.oauth2.rbac.mapper.RbacUserMapper;
import com.incarcloud.oauth2.rbac.service.RbacUserService;
import org.springframework.stereotype.Service;

/**
 * 用户信息服务接口实现
 *
 * @author Aaric, created on 2020-04-11T20:16.
 * @version 0.7.0-SNAPSHOT
 */
@Service
public class RbacUserServiceImpl extends ServiceImpl<RbacUserMapper, RbacUser> implements RbacUserService {

    @Override
    public RbacUser getByUsername(String username) {
        LambdaQueryWrapper<RbacUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(RbacUser::getUsername, username);
        return getBaseMapper().selectOne(queryWrapper);
    }
}
