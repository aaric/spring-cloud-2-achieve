package com.incarcloud.oauth2.rbac.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.incarcloud.oauth2.pojo.RbacAuthority;
import com.incarcloud.oauth2.rbac.mapper.RbacAuthorityMapper;
import com.incarcloud.oauth2.rbac.service.RbacAuthorityService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 权限信息服务接口实现
 *
 * @author Aaric, created on 2020-04-11T20:46.
 * @version 0.7.0-SNAPSHOT
 */
@Service
public class RbacAuthorityServiceImpl extends ServiceImpl<RbacAuthorityMapper, RbacAuthority> implements RbacAuthorityService {

    @Override
    public List<RbacAuthority> queryListByUserId(Long userId) {
        return getBaseMapper().selectByUserId(userId);
    }
}
