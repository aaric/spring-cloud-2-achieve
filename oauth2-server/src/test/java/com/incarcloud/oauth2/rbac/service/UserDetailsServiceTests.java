package com.incarcloud.oauth2.rbac.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * UserDetailsServiceTests
 *
 * @author Aaric, created on 2020-04-11T20:51.
 * @version 0.7.0-SNAPSHOT
 */
@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class UserDetailsServiceTests {

    @Autowired
    private UserDetailsService userDetailsService;

    @Test
    @Disabled
    public void testLoadUserByUsername() {
        UserDetails userDetails = userDetailsService.loadUserByUsername("admin");
        log.info(userDetails.toString());
        Assertions.assertNotNull(userDetails);
    }
}
