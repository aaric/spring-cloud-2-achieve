package com.incarcloud.gateway.config;

import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Swagger2资源配置
 *
 * @author Aaric, created on 2020-04-12T21:21.
 * @version 0.8.0-SNAPSHOT
 */
@Primary
@Component
public class Swagger2ResourcesConfig implements SwaggerResourcesProvider {

    private final RouteLocator routeLocator;

    public Swagger2ResourcesConfig(RouteLocator routeLocator) {
        this.routeLocator = routeLocator;
    }

    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        List<Route> routes = routeLocator.getRoutes();
        routes.forEach(route -> {
            // 限定以"/api"开头的路由
            if (route.getFullPath().startsWith("/api")) {
                //System.err.println(route.getFullPath());
                resources.add(swaggerResource(route.getId(), route.getFullPath().replace("**", "v2/api-docs"), "1.0"));
            }
        });
        return resources;
    }

    /**
     * 构建API资源对象
     *
     * @param name API名称，即应用名称
     * @param location API地址
     * @param version Swagger版本号
     * @return
     */
    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource resource = new SwaggerResource();
        resource.setName(name);
        resource.setLocation(location);
        resource.setSwaggerVersion(version);
        return resource;
    }
}
