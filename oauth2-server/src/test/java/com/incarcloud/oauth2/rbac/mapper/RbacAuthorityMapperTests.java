package com.incarcloud.oauth2.rbac.mapper;

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
 * RbacAuthorityMapperTest
 *
 * @author Aaric, created on 2020-04-11T19:25.
 * @version 0.7.0-SNAPSHOT
 */
@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class RbacAuthorityMapperTests {

    @Autowired
    private RbacAuthorityMapper rbacAuthorityMapper;

    @Test
    @Disabled
    public void testSelectByUserId() {
        List<RbacAuthority> list = rbacAuthorityMapper.selectByUserId(1L);
        list.forEach(object -> log.info(object.toString()));
        Assertions.assertNotEquals(0, list.size());
    }
}
