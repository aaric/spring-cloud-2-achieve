package com.incarcloud.oauth2.rbac.mapper;

import com.incarcloud.oauth2.pojo.RbacUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * RbacUserMapperTests
 *
 * @author Aaric, created on 2020-04-11T19:36.
 * @version 0.7.0-SNAPSHOT
 */
@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class RbacUserMapperTests {

    @Autowired
    private RbacUserMapper rbacUserMapper;

    @Test
    @Disabled
    public void testGet() {
        RbacUser user = rbacUserMapper.selectById(1L);
        log.debug(user.toString());
        Assertions.assertNotNull(user);
    }
}
