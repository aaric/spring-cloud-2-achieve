package com.incarcloud.oauth2.rbac.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.incarcloud.oauth2.pojo.RbacAuthority;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 权限信息DAO
 *
 * @author Aaric, created on 2020-04-11T19:21.
 * @version 0.7.0-SNAPSHOT
 */
public interface RbacAuthorityMapper extends BaseMapper<RbacAuthority> {

    /**
     * 根据用户ID获得权限列表
     *
     * @param userId 用户ID
     * @return
     */
    List<RbacAuthority> selectByUserId(@Param("userId") Long userId);
}
