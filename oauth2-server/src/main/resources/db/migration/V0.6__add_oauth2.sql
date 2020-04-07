-- 官方参考链接
-- https://github.com/spring-projects/spring-security-oauth/blob/master/spring-security-oauth2/src/test/resources/schema.sql

CREATE TABLE `oauth_client_details` (
  `client_id` varchar(128) NOT NULL COMMENT '主键，客户端ID',
  `resource_ids` varchar(256) DEFAULT NULL COMMENT '客户端所能访问的资源ID集合，多个资源时用英文逗号分隔',
  `client_secret` varchar(256) DEFAULT NULL COMMENT '客户端访问密钥',
  `scope` varchar(256) DEFAULT NULL COMMENT '客户端申请的权限范围，多个权限范围用英文逗号分隔',
  `authorized_grant_types` varchar(256) DEFAULT NULL COMMENT '客户端支持的授权类型，支持多个类型用英文逗号分隔',
  `web_server_redirect_uri` varchar(256) DEFAULT NULL COMMENT '客户端的重定向URI，仅限authorization_code或implicit类型',
  `authorities` varchar(256) DEFAULT NULL COMMENT '客户端所拥有的Spring Security的权限值',
  `access_token_validity` int(11) DEFAULT NULL COMMENT '客户端的access_token的有效时间值，单位：秒',
  `refresh_token_validity` int(11) DEFAULT NULL COMMENT '客户端的refresh_token的有效时间值，单位：秒',
  `additional_information` varchar(4096) DEFAULT NULL COMMENT '预留字段，必须为JSON数据格式',
  `autoapprove` varchar(256) DEFAULT NULL COMMENT '设置用户是否自动Approval操作，默认值为false',
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='OAuth2客户端详情表';

INSERT INTO `oauth_client_details` (`client_id`, `client_secret`, `scope`, `authorized_grant_types`, `web_server_redirect_uri`, `access_token_validity`, `refresh_token_validity`)
VALUES ('client', '$2a$10$/FdlWQWV0JNGNF4WU4tJIeMT8QQMrg9jq8jPu7QGkTMypZ6Eb6wVa', 'app', 'authorization_code,password,refresh_token', 'https://www.incarcloud.com', 43200, 2592000);
