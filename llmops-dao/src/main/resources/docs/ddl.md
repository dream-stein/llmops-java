CREATE DATABASE llmops
CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;

use llmops;


CREATE TABLE `llmops_chat_history` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '聊天id',
  `role` tinyint(4) NOT NULL DEFAULT '1' COMMENT '角色类型，1:assist，2:user',
  `tenant_id` bigint(20) unsigned NOT NULL COMMENT '租户id',
  `dialog_id` bigint(20) unsigned NOT NULL COMMENT '对话id',
  `content` json DEFAULT NULL COMMENT '对话内容',
  `token` bigint(20) unsigned NOT NULL COMMENT 'token数',
  `creator` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '创建人',
  `ctime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_tenant_id` (`tenant_id`),
  KEY `idx_role` (`role`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='对话记录表';


CREATE TABLE `llmops_chat_dialog` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '兑换id',
  `title` varchar(256) NOT NULL COMMENT '对话概要',
  `tenant_id` bigint(20) unsigned NOT NULL COMMENT '租户id',
  `content` json DEFAULT NULL COMMENT '对话内容',
  `creator` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '创建人',
  `operator` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '最后修改人',
  `ctime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `utime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_tenant_id` (`tenant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='对话概要表';


--------------------------
重新设计llmops的DDL
--------------------------

CREATE TABLE `llmops_app_config` (
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '表的自增主键，用于唯一标识每条记录',
    `app_id` varchar(36) NOT NULL COMMENT '关联的应用ID，用于区分不同的应用',
    `model_config` json DEFAULT NULL COMMENT '存储模型相关的配置信息，以JSON格式存储',
    `memory_mode` varchar(255) NOT NULL COMMENT '记录该应用配置的记忆类型',
    `status` char(100) NOT NULL DEFAULT '' COMMENT '表示当前应用配置的状态，初始为空字符串',
    `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录该条记录的最后更新时间',
    `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录该条记录的创建时间',
    PRIMARY KEY (`id`),
    KEY `idx_app_id` (`app_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='应用配置表';

CREATE TABLE `llmops_conversation` (
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '会话自增主键',
    `conversation_id` varchar(255) NOT NULL COMMENT '会话自增主键',
    `account_id` varchar(255) NOT NULL COMMENT '用户id',
    `app_id` varchar(255) NOT NULL COMMENT '应用id',
    `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`),
    KEY `idx_account_id` (`account_id`),
    KEY `idx_app_id` (`app_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='会话表';

CREATE TABLE `llmops_message` (
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '消息自增主键',
    `conversation_id` varchar(255) NOT NULL COMMENT '会话id，关联会话表',
    `account_id` varchar(255) NOT NULL COMMENT '用户id',
    `query` text NOT NULL COMMENT '人类输入内容',
    `answer` text NOT NULL COMMENT 'AI生成内容',
    `answer_tokens` int NOT NULL DEFAULT 0 COMMENT '消耗token数',
    `response_latency` float NOT NULL DEFAULT 0 COMMENT '响应延时',
    `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`),
    KEY `idx_conversation_id` (`conversation_id`),
    KEY `idx_account_id` (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='消息表';

CREATE TABLE `llmops_account` (
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '账号自增主键',
    `account_id` varchar(255) NOT NULL COMMENT '账号id',
    `name` varchar(255) NOT NULL COMMENT '账号名称',
    `email` varchar(255) NOT NULL COMMENT '绑定邮箱',
    `password` varchar(255) NOT NULL COMMENT '密码',
    `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`),
    KEY `idx_email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='账号表';

CREATE TABLE `llmops_api_tool` (
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'API工具自增主键',
    `account_id` varchar(255) NOT NULL COMMENT '关联的用户id',
    `provider_id` varchar(255) NOT NULL COMMENT '关联的提供者id',
    `name` varchar(255) NOT NULL COMMENT '工具名称',
    `description` text NOT NULL COMMENT '工具描述',
    `url` varchar(255) NOT NULL COMMENT '工具API地址',
    `method` varchar(255) NOT NULL COMMENT '调用方法',
    `parameters` json NOT NULL COMMENT '工具参数',
    `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`),
    KEY `idx_account_id` (`account_id`),
    KEY `idx_provider_id` (`provider_id`),
    KEY `idx_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='API工具表';

CREATE TABLE `llmops_api_tool_provider` (
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'API工具提供者自增主键',
    `provider_id` varchar(255) NOT NULL COMMENT '工具提供商唯一标识', 
    `account_id` varchar(255) NOT NULL COMMENT '关联的用户id',
    `name` varchar(255) NOT NULL COMMENT '提供商名称',
    `icon` varchar(255) NOT NULL COMMENT '提供商图标',
    `description` text NOT NULL COMMENT '提供商描述',
    `openapi_schema` json NOT NULL COMMENT '规范描述',
    `headers` json NOT NULL COMMENT '提供商对应的请求头',
    `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`),
    KEY `idx_account_id` (`account_id`),
    KEY `idx_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='API工具提供者表';

CREATE TABLE `llmops_app` (
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
    `app_id` varchar(255) NOT NULL COMMENT 'AI应用唯一标识',
    `account_id` varchar(255) NOT NULL COMMENT '账号id',
    `published_app_config_id` varchar(255) NULL COMMENT '已发布配置id',
    `drafted_app_config_id` varchar(255) NULL COMMENT '草稿配置id',
    `debug_conversion_id` varchar(255) NOT NULL COMMENT '调试会话id',
    `name` varchar(255) NOT NULL COMMENT '应用名称',
    `icon` varchar(255) NOT NULL COMMENT '应用图标',
    `description` text NOT NULL COMMENT '应用描述',
    `status` char(100) NOT NULL COMMENT '应用状态',
    `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`),
    KEY `idx_account_id` (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='AI应用表';