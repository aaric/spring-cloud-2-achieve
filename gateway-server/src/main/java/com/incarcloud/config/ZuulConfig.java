package com.incarcloud.config;

import com.incarcloud.filter.TokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ZuulConfig
 *
 * @author Aaric, created on 2019-12-13T10:32.
 * @version 0.0.5-SNAPSHOT
 */
@Configuration
public class ZuulConfig {

    @Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }
}
