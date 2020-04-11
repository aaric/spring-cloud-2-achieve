-- 创建组织机构表
CREATE TABLE `rbac_org` (
`id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '组织ID',
`parent_id` bigint UNSIGNED NULL COMMENT '父级ID',
`region_id` bigint UNSIGNED NULL COMMENT '行政区ID',
`name` varchar(100) NOT NULL COMMENT '组织名称',
`code` varchar(50) NULL COMMENT '组织编码',
`type` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '组织类型：0-机构，1-部门，2-岗位',
`icon` varchar(50) NULL COMMENT '组织图标',
`phone_number` varchar(20) NULL COMMENT '电话',
`fax_number` varchar(20) NULL COMMENT '传真',
`email` varchar(100) NULL COMMENT '电子邮箱',
`address` varchar(200) NULL COMMENT '详细地址',
`remark` varchar(500) NULL COMMENT '备注',
`order_index` bigint NOT NULL COMMENT '排序字段，时间戳',
`is_del` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
`create_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建人ID',
`create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`update_id` bigint UNSIGNED NULL COMMENT '更新人ID',
`update_time` datetime NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY (`id`),
UNIQUE KEY `code` (`code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='组织机构表';

INSERT INTO `rbac_org`(`id`, `parent_id`, `name`, `type`, `order_index`) VALUES (1, NULL, '测试机构', 0, 10);

-- 创建用户表
CREATE TABLE `rbac_user` (
`id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户ID',
`org_id` bigint UNSIGNED NULL COMMENT '组织ID',
`region_id` bigint UNSIGNED NULL COMMENT '行政区ID',
`username` varchar(50) NOT NULL COMMENT '用户名',
`phone_number` varchar(20) NULL COMMENT '手机号',
`email` varchar(100) NULL COMMENT '电子邮箱',
`password` varchar(100) NOT NULL COMMENT '密码',
`password_salt` varchar(10) NOT NULL COMMENT '密码盐',
`locale` varchar(10) NOT NULL DEFAULT 'zh_CN' COMMENT '语言环境',
`avatar_path` varchar(100) NULL COMMENT '头像路径',
`full_name` varchar(50) NULL COMMENT '姓名',
`gender` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '性别：0-未知，1-男，2-女',
`id_type` int UNSIGNED NULL COMMENT '证件类型：0-身份证，1-护照，3-其他',
`id_number` varchar(20) NULL COMMENT '证件号',
`address` varchar(200) NULL COMMENT '详细地址',
`remark` varchar(500) NULL COMMENT '备注',
`is_del` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否删除',
`create_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建人ID',
`create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`update_id` bigint UNSIGNED NULL COMMENT '更新人ID',
`update_time` datetime NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY (`id`),
UNIQUE KEY `username` (`username`) USING BTREE,
UNIQUE KEY `phone_number` (`phone_number`) USING BTREE,
UNIQUE KEY `email` (`email`) USING BTREE,
FOREIGN KEY (`org_id`) REFERENCES `rbac_org` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户表';

INSERT INTO `rbac_user`(`id`, `org_id`, `username`, `password`, `password_salt`) VALUES (1, 1, 'admin', '$2a$10$bkrJ8sKKeDa4CGDsRLvCiO0CxG/AiEdSNVBP1FZT.ycXeHZI3o0oC', '');
INSERT INTO `rbac_user`(`id`, `org_id`, `username`, `password`, `password_salt`) VALUES (2, 1, 'test', '$2a$10$bkrJ8sKKeDa4CGDsRLvCiO0CxG/AiEdSNVBP1FZT.ycXeHZI3o0oC', '');

-- 创建角色表
CREATE TABLE `rbac_role` (
`id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '角色ID',
`name` varchar(100) NOT NULL COMMENT '角色名称',
`code` varchar(50) NULL COMMENT '角色编码',
`remark` varchar(500) NULL COMMENT '备注',
`is_del` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否删除',
`create_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建人ID',
`create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`update_id` bigint UNSIGNED NULL COMMENT '更新人ID',
`update_time` datetime NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY (`id`),
UNIQUE KEY `code` (`code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='角色表';

INSERT INTO `rbac_role`(`id`, `name`) VALUES (1, '超级管理员');
INSERT INTO `rbac_role`(`id`, `name`) VALUES (2, '测试人员');

-- 创建组织角色关联表
CREATE TABLE `rbac_org_role` (
`id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '关联ID',
`org_id` bigint UNSIGNED NOT NULL COMMENT '组织ID',
`role_id` bigint UNSIGNED NOT NULL COMMENT '角色ID',
`create_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建人ID',
`create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
PRIMARY KEY (`id`),
FOREIGN KEY (`org_id`) REFERENCES `rbac_org` (`id`),
FOREIGN KEY (`role_id`) REFERENCES `rbac_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='组织角色关联表';

-- 创建用户角色关联表
CREATE TABLE `rbac_user_role` (
`id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '关联ID',
`user_id` bigint UNSIGNED NOT NULL COMMENT '用户ID',
`role_id` bigint UNSIGNED NOT NULL COMMENT '角色ID',
`create_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建人ID',
`create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
PRIMARY KEY (`id`),
FOREIGN KEY (`user_id`) REFERENCES `rbac_user` (`id`),
FOREIGN KEY (`role_id`) REFERENCES `rbac_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户角色关联表';

INSERT INTO `rbac_user_role`(`id`, `user_id`, `role_id`) VALUES (1, 1, 1);
INSERT INTO `rbac_user_role`(`id`, `user_id`, `role_id`) VALUES (2, 2, 2);

-- 创建权限表
CREATE TABLE `rbac_authority` (
`id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户ID',
`parent_id` bigint UNSIGNED NULL COMMENT '父级ID',
`icon` varchar(50) NULL COMMENT '权限图标',
`name` varchar(100) NULL COMMENT '权限名称',
`code` varchar(50) NULL COMMENT '权限编码',
`url` varchar(200) NULL COMMENT '授权路径',
`type` int NOT NULL DEFAULT 0 COMMENT '授权类型：0-权限，1-功能，2-菜单',
`remark` varchar(500) NULL COMMENT '备注',
`is_del` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否删除',
`create_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建人ID',
`create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`update_id` bigint UNSIGNED NULL COMMENT '更新人ID',
`update_time` datetime NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY (`id`),
UNIQUE KEY `code` (`code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='权限表';

INSERT INTO `rbac_authority`(`id`, `parent_id`, `name`, `code`, `url`, `type`) VALUES (1, NULL, '用户管理', NULL, '', 2);
INSERT INTO `rbac_authority`(`id`, `parent_id`, `name`, `code`, `url`, `type`) VALUES (2, 1, '查询用户信息', 'user:UserApi:getUser', '/user/getUser', 0);
INSERT INTO `rbac_authority`(`id`, `parent_id`, `name`, `code`, `url`, `type`) VALUES (3, NULL, '订单管理', NULL, '', 2);
INSERT INTO `rbac_authority`(`id`, `parent_id`, `name`, `code`, `url`, `type`) VALUES (4, 3, '查询订单详情', 'order:OrderApi:getDetail', '/order/getDetail', 0);
INSERT INTO `rbac_authority`(`id`, `parent_id`, `name`, `code`, `url`, `type`) VALUES (5, 3, '查询自定义标题', 'order:OrderApi:getCustomTitle', '/order/getCustomTitle', 0);

-- 创建角色权限关联表
CREATE TABLE `rbac_role_authority` (
`id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '关联ID',
`role_id` bigint UNSIGNED NOT NULL COMMENT '角色ID',
`authority_id` bigint UNSIGNED NOT NULL COMMENT '权限ID',
`create_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建人ID',
`create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
PRIMARY KEY (`id`),
FOREIGN KEY (`role_id`) REFERENCES `rbac_role` (`id`),
FOREIGN KEY (`authority_id`) REFERENCES `rbac_authority` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='角色权限关联表';

INSERT INTO `rbac_role_authority`(`id`, `role_id`, `authority_id`) VALUES (1, 1, 2);
INSERT INTO `rbac_role_authority`(`id`, `role_id`, `authority_id`) VALUES (2, 1, 4);
INSERT INTO `rbac_role_authority`(`id`, `role_id`, `authority_id`) VALUES (3, 1, 5);
INSERT INTO `rbac_role_authority`(`id`, `role_id`, `authority_id`) VALUES (4, 2, 2);
