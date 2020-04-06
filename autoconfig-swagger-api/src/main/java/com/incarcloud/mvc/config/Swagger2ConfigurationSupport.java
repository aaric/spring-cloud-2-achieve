package com.incarcloud.mvc.config;

import com.incarcloud.mvc.config.settings.Swagger2ApiProperties;
import com.incarcloud.mvc.config.settings.Swagger2AuthorProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;

import java.util.ArrayList;
import java.util.List;

/**
 * Swagger2配置支持
 *
 * @author Aaric, created on 2020-04-06T21:20.
 * @version 0.5.0-SNAPSHOT
 */
public abstract class Swagger2ConfigurationSupport {

    @Autowired
    protected Swagger2ApiProperties swagger2ApiProperties;

    @Autowired
    protected Swagger2AuthorProperties swagger2AuthorProperties;

    protected ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(swagger2ApiProperties.getTitle())
                .description(swagger2ApiProperties.getDescription())
                .termsOfServiceUrl(swagger2ApiProperties.getServiceUrl())
                .version(swagger2ApiProperties.getVersion())
                .contact(new Contact(swagger2AuthorProperties.getName(),
                        swagger2AuthorProperties.getWebsiteUrl(),
                        swagger2AuthorProperties.getEmail()))
                .build();
    }

    /**
     * 注册国际化参数信息
     *
     * @return
     */
    protected List<Parameter> globalOperationParameters() {
        // 构建参数: 地区语言代码
        ParameterBuilder builderQueryLocale = new ParameterBuilder();
        builderQueryLocale.name(LocaleChangeInterceptor.DEFAULT_PARAM_NAME)
                .description("地区语言代码，默认zh_CN(简体中文), en_US(英文)")
                .modelRef(new ModelRef("string"))
                .parameterType("query")
                .defaultValue("zh_CN")
                .required(false);

        // 构建参数: 客户端请求时间戳
        /*ParameterBuilder builderQueryTs = new ParameterBuilder();
        builderQueryTs.name(DbLog.DEFAULT_CLIENT_TIME_KEY)
                .description("客户端请求时间戳")
                .modelRef(new ModelRef("integer"))
                .parameterType("query")
                .defaultValue("" + System.currentTimeMillis())
                .required(false);*/

        // 设置全局参数列表
        List<Parameter> parameters = new ArrayList<Parameter>();
        parameters.add(builderQueryLocale.build());
        /*parameters.add(builderQueryTs.build());*/
        return parameters;
    }
}
