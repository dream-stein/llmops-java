CREATE DATABASE llmops
CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;

use llmops;


CREATE TABLE `llmops_chat_history` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '聊天id',
  `role` tinyint(4) NOT NULL DEFAULT '1' COMMENT '角色类型，1:assist，2:user',
  `tenant` varchar(256) NOT NULL COMMENT '租户信息',
  `dialog_id` bigint(20) unsigned NOT NULL COMMENT '对话id',
  `content` json DEFAULT NULL COMMENT '对话内容',
  `token` bigint(20) unsigned NOT NULL COMMENT 'token数',
  `creator` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '创建人',
  `ctime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_tenant` (`tenant`),
  KEY `idx_role` (`role`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='对话记录表';


CREATE TABLE `llmops_chat_dialog` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '兑换id',
  `title` varchar(256) NOT NULL COMMENT '对话概要',
  `tenant` varchar(256) NOT NULL COMMENT '租户信息',
  `creator` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '创建人',
  `operator` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '最后修改人',
  `ctime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `utime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_tenant` (`tenant`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='对话概要表';


