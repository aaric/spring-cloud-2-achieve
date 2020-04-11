package com.incarcloud.oauth2.rbac.service;

import com.incarcloud.oauth2.pojo.RbacAuthority;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

/**
 * RbacAuthorityServiceTests
 *
 * @author Aaric, created on 2020-04-11T20:48.
 * @version 0.7.0-SNAPSHOT
 */
@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class RbacAuthorityServiceTests {

    @Autowired
    private RbacAuthorityService rbacAuthorityService;

    @Test
    @Disabled
    public void testQueryListByUserId() {
        List<RbacAuthority> list = rbacAuthorityService.queryListByUserId(1L);
        list.forEach(object -> log.info(object.toString()));
        Assertions.assertNotEquals(0, list.size());
    }
}
