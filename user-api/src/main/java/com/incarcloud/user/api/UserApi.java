package com.incarcloud.user.api;

import com.incarcloud.user.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * UserService
 *
 * @author Aaric, created on 2019-12-04T10:37.
 * @version 0.4.1-SNAPSHOT
 */
@Api(tags = "用户管理API")
public interface UserApi {

    @ApiOperation(value = "查询用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", dataType = "Integer", paramType = "query")
    })
    @GetMapping("/user/getUser")
    User getUser(@RequestParam("id") Integer id);
}
