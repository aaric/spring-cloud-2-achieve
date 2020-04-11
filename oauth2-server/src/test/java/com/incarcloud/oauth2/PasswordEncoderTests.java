package com.incarcloud.oauth2;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * PasswordEncoderTests
 *
 * @author Aaric, created on 2020-04-11T19:59.
 * @version 0.7.0-SNAPSHOT
 */
@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class PasswordEncoderTests {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void testPwd() {
        // secret: $2a$10$mXvf3XeEZxFM3KIOgthuDOVwAjmy5IiNUnPM4sxyzagJ4qUxx/hVO
        String pwdSecret = passwordEncoder.encode("secret");
        log.debug("secret: " + pwdSecret);
        Assertions.assertNotNull(pwdSecret);

        // 123456: $2a$10$bkrJ8sKKeDa4CGDsRLvCiO0CxG/AiEdSNVBP1FZT.ycXeHZI3o0oC
        String pwd123456 = passwordEncoder.encode("123456");
        log.debug("123456: " + pwd123456);
        Assertions.assertNotNull(pwd123456);
    }
}
