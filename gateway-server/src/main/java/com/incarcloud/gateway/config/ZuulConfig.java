package com.incarcloud.gateway.config;

import com.incarcloud.gateway.filter.TokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ZuulConfig
 *
 * @author Aaric, created on 2019-12-13T10:32.
 * @version 0.4.1-SNAPSHOT
 */
@Configuration
public class ZuulConfig {

    @Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }
}
