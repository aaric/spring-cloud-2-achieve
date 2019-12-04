package com.incarcloud.api.feign;

import com.incarcloud.api.service.UserService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * UserServiceFeign
 *
 * @author Aaric, created on 2019-12-04T11:14.
 * @version 0.0.2-SNAPSHOT
 */
@FeignClient("api-user-server")
public interface UserServiceFeign extends UserService {
}
