package com.incarcloud.order.feign;

import com.incarcloud.order.fallback.UserServiceFallback;
import com.incarcloud.user.api.UserApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * UserServiceFeign
 *
 * @author Aaric, created on 2019-12-04T11:14.
 * @version 0.4.1-SNAPSHOT
 */
@FeignClient(value = "user-api-server", fallback = UserServiceFallback.class)
public interface UserServiceFeign extends UserApi {
}
