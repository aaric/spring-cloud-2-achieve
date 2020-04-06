package com.incarcloud.user.config;

import com.incarcloud.mvc.config.Swagger2ConfigurationSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2配置
 *
 * @author Aaric, created on 2020-04-06T22:10.
 * @version 0.5.0-SNAPSHOT
 */
@Configuration
@EnableSwagger2
public class Swagger2Config extends Swagger2ConfigurationSupport {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .globalOperationParameters(globalOperationParameters())
                /*.groupName("v1")*/
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.incarcloud.user"))
                .paths(PathSelectors.any())
                .build();
    }
}
