package com.incarcloud.mvc.config.settings;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Swagger2在线文档API配置类<br>
 *
 * <pre>
 * # Incarcloud settings
 * incarcloud:
 *   swagger2:
 *     api:
 *       title: 英卡示例项目在线API文档
 *       description: 本文档包含该项目全部业务接口，注意保密。
 *       service-url: http://localhost:8080/doc.html
 *       version: 1.0.0
 * </pre>
 *
 * @author Aaric, created on 2020-04-06T21:21.
 * @version 0.5.0-SNAPSHOT
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "incarcloud.swagger2.api")
public class Swagger2ApiProperties {

    /**
     * 文档标题
     */
    private static final String DEFAULT_TITLE = "英卡科技在线API文档";

    /**
     * 文档描述
     */
    private static final String DEFAULT_DESCRIPTION = "本文档包含该项目全部业务接口，注意保密。";

    /**
     * 文档地址
     */
    private static final String DEFAULT_SERVICE_URL = "http://localhost:8080/doc.html";

    /**
     * 文档版本
     */
    private static final String DEFAULT_VERSION = "1.0.0";

    private String title = DEFAULT_TITLE;

    private String description = DEFAULT_DESCRIPTION;

    private String serviceUrl = DEFAULT_SERVICE_URL;

    private String version = DEFAULT_VERSION;
}
