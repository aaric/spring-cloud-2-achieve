package com.incarcloud.oauth2.rbac.service;

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
 * RbacUserServiceTest
 *
 * @author Aaric, created on 2020-04-11T20:17.
 * @version 0.7.0-SNAPSHOT
 */
@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class RbacUserServiceTests {

    @Autowired
    private RbacUserService rbacUserService;

    @Test
    @Disabled
    public void testGetByUsername() {
        RbacUser user = rbacUserService.getByUsername("admin");
        log.debug(user.toString());
        Assertions.assertNotNull(user);
    }
}
