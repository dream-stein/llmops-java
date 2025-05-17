--------------------------
账号
--------------------------
CREATE TABLE IF NOT EXISTS `llmops_account` (
    `id` VARCHAR(36) PRIMARY KEY COMMENT '主键UUID',
    `name` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '账号名称',
    `email` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '绑定邮箱（唯一）',
    `varchar` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '头像',
    `password` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '密码哈希值（非明文）',
    `password_salt` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '密码盐值',
    `assistant_conversation_id` VARCHAR(36) DEFAULT NULL COMMENT '关联的辅助会话ID',
    `last_login_at` TIMESTAMP NULL DEFAULT NULL COMMENT '最后登录时间',
    `last_login_ip` VARCHAR(45) NOT NULL DEFAULT '' COMMENT '最后登录IP（支持IPv6）',
    `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    UNIQUE INDEX `uniq_email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户账号表';


CREATE TABLE IF NOT EXISTS `llmops_account_oauth` (
    `id` VARCHAR(36) PRIMARY KEY COMMENT '主键UUID',
    `account_id` VARCHAR(36) NOT NULL DEFAULT '' COMMENT '关联账号id',
    `provider` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '提供商名字',
    `openid` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '开放id',
    `encrypted_token` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '加密凭证',
    `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    INDEX `idx_account_id` (`account_id`),
    UNIQUE INDEX `idx_provider_openid` (`provider`, `openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='账号第三方授权表';

--------------------------
文件
--------------------------
CREATE TABLE IF NOT EXISTS `llmops_upload_file` (
    `id` VARCHAR(36) PRIMARY KEY COMMENT '主键UUID',
    `account_id` VARCHAR(36) NOT NULL DEFAULT '' COMMENT '上传文件的用户id',
    `name` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '上传的文件名',
    `key` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '对象存储文件路径',
    `size` INT NOT NULL DEFAULT 0 COMMENT '上传文件的大小',
    `extension` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '文件扩展名',
    `mime_type` VARCHAR(255) NOT NULL DEFAULT '' COMMENT 'mimetype',
    `hash` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '文件内容的哈希值',
    `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='上传文件';

--------------------------
应用
--------------------------
CREATE TABLE IF NOT EXISTS `llmops_app_config` (
    `id` VARCHAR(36) PRIMARY KEY COMMENT '主键UUID',
    `app_id` VARCHAR(36) NOT NULL DEFAULT '' COMMENT '关联的应用id',
    `model_config` JSON NOT NULL COMMENT '模型配置',
    `dialog_round` INT NOT NULL DEFAULT 0 COMMENT '上下文对话轮数',
    `preset_prompt` TEXT NOT NULL COMMENT '人设与回复逻辑',
    `tools` JSON NOT NULL COMMENT '关联工具列表',
    `workflows` JSON NOT NULL COMMENT '关联工作流列表',
    `retrieval_config` JSON NOT NULL COMMENT '知识库检索配置',
    `long_term_memory` JSON NOT NULL COMMENT '长期记忆配置',
    `opening_statement` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '对话开场白',
    `opening_questions` JSON NOT NULL COMMENT '开场建议问题',
    `suggested_after_answer` JSON NOT NULL COMMENT '回答后建议问题',
    `speech_to_text` JSON NOT NULL COMMENT '语音转文本配置',
    `text_to_speech` JSON NOT NULL COMMENT '文本转语音配置',
    `review_config` JSON NOT NULL COMMENT '内容审核配置',
    `config_type` tinyint(1) NOT NULL DEFAULT '0' COMMENT '配置类型',
    `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    INDEX `idx_app_config_type` (`app_id`, `config_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='应用配置表';


CREATE TABLE IF NOT EXISTS `llmops_app_config_version` (
    `id` VARCHAR(36) PRIMARY KEY COMMENT '主键UUID',
    `app_id` VARCHAR(36) NOT NULL DEFAULT '' COMMENT '关联的应用id',
    `model_config` JSON NOT NULL DEFAULT (JSON_OBJECT()) COMMENT '模型配置（默认空对象）',
    `dialog_round` INT NOT NULL DEFAULT 0 COMMENT '上下文对话轮数', 
    `preset_prompt` TEXT NOT NULL COMMENT '人设与回复逻辑',
    `tools` JSON NOT NULL DEFAULT (JSON_ARRAY()) COMMENT '关联工具列表（默认空数组）',
    `workflows` JSON NOT NULL DEFAULT (JSON_ARRAY()) COMMENT '关联工作流列表（默认空数组）',
    `datasets` JSON NOT NULL DEFAULT (JSON_ARRAY()) COMMENT '关联知识库列表（默认空数组）',
    `retrieval_config` JSON NOT NULL DEFAULT (JSON_OBJECT()) COMMENT '知识库检索配置（默认空对象）',
    `long_term_memory` JSON NOT NULL DEFAULT (JSON_OBJECT()) COMMENT '长期记忆配置（默认空对象）',
    `opening_statement` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '对话开场白',
    `opening_questions` JSON NOT NULL DEFAULT (JSON_ARRAY()) COMMENT '开场建议问题（默认空数组）',
    `suggested_after_answer` JSON NOT NULL DEFAULT (JSON_ARRAY()) COMMENT '回答后建议问题（默认空数组）',
    `speech_to_text` JSON NOT NULL DEFAULT (JSON_OBJECT()) COMMENT '语音转文本配置（默认空对象）',
    `text_to_speech` JSON NOT NULL DEFAULT (JSON_OBJECT()) COMMENT '文本转语音配置（默认空对象）',
    `review_config` JSON NOT NULL DEFAULT (JSON_OBJECT()) COMMENT '内容审核配置（默认空对象）',
    `version` INT NOT NULL DEFAULT 0 COMMENT '版本号（递增）',
    `config_type` VARCHAR(64) NOT NULL DEFAULT 'release' COMMENT '配置类型（release/draft）',
    `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间', 
    INDEX `idx_app_version` (`app_id`, `version`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='应用配置版本管理表';

CREATE TABLE IF NOT EXISTS `llmops_app` (
    `id` VARCHAR(36) PRIMARY KEY COMMENT '主键UUID',
    `account_id` VARCHAR(36) NOT NULL DEFAULT '' COMMENT '账号id',
    `published_app_config_id` VARCHAR(36) NOT NULL DEFAULT '' COMMENT '已发布配置id',
    `drafted_app_config_id` VARCHAR(36) NOT NULL DEFAULT '' COMMENT '调试会话id',
    `name` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '应用名称',
    `icon` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '应用图标',
    `description` TEXT COMMENT '应用描述',
    `status` VARCHAR(100) NOT NULL DEFAULT '' COMMENT '应用状态',
    `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    INDEX `idx_account_id` (`account_id`),
    INDEX `idx_status` (`status`),
    INDEX `idx_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='AI应用表';

CREATE TABLE IF NOT EXISTS `llmops_end_user` (
`id` VARCHAR(36) PRIMARY KEY COMMENT '主键UUID',
`tenant_id` VARCHAR(36) NOT NULL DEFAULT '' COMMENT '终端用户归属账号id',
`app_id` VARCHAR(36) NOT NULL DEFAULT '' COMMENT '终端用户归属应用id',
`created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='终端用户端';

--------------------------
知识库
--------------------------
CREATE TABLE IF NOT EXISTS `llmops_dataset` (
    `id` VARCHAR(36) PRIMARY KEY COMMENT '主键UUID',
    `account_id` VARCHAR(36) NOT NULL DEFAULT '' COMMENT '关联的用户id',
    `name` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '知识库名称',
    `icon` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '知识库图标',
    `description` TEXT COMMENT '知识库描述',
    `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    INDEX `idx_account_id` (`account_id`),
    INDEX `idx_name` (`name`),
    UNIQUE INDEX `idx_account_name` (`account_id`, `name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='知识库';

CREATE TABLE IF NOT EXISTS `llmops_dataset_query` (
    `id` VARCHAR(36) PRIMARY KEY COMMENT '主键UUID',
    `dataset_id` VARCHAR(36) NOT NULL DEFAULT '' COMMENT '关联的知识库id',
    `query` TEXT COMMENT '查询query语句',
    `source` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '查询的来源',
    `source_app_id` VARCHAR(36) NOT NULL DEFAULT '' COMMENT '查询关联的应用id',
    `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    INDEX `idx_dataset_id` (`dataset_id`),
    INDEX `idx_source_app_id` (`source_app_id`),
    INDEX `idx_created_at` (`created_at`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='知识库查询';

CREATE TABLE IF NOT EXISTS `llmops_keyword_table` (
    `id` VARCHAR(36) PRIMARY KEY COMMENT '主键UUID',
    `dataset_id` VARCHAR(36) NOT NULL DEFAULT '' COMMENT '关联的知识库id',
    `keyword_table` JSON NOT NULL DEFAULT (JSON_OBJECT()) COMMENT '关键词表',
    `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    INDEX `idx_dataset_id` (`dataset_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='关键词配置表';

CREATE TABLE IF NOT EXISTS `llmops_process_rule` (
    `id` VARCHAR(36) PRIMARY KEY COMMENT '主键UUID',
    `account_id` VARCHAR(36) NOT NULL DEFAULT '' COMMENT '关联的用户id',
    `dataset_id` VARCHAR(36) NOT NULL DEFAULT '' COMMENT '归属的知识库id',
    `mode` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '处理模式',
    `rule` JSON COMMENT '处理规则',
    `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    INDEX `idx_account_id` (`account_id`),
    INDEX `idx_dataset_id` (`dataset_id`),
    INDEX `idx_mode` (`mode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='处理规则表';

CREATE TABLE IF NOT EXISTS `llmops_app_dataset_join` (
    `id` VARCHAR(36) PRIMARY KEY COMMENT '主键UUID',
    `app_id` VARCHAR(36) NOT NULL DEFAULT '' COMMENT '关联的应用id',
    `dataset_id` VARCHAR(36) NOT NULL DEFAULT '' COMMENT '关联的知识库id',
    `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    INDEX `idx_app_id` (`app_id`),
    INDEX `idx_dataset_id` (`dataset_id`),
    UNIQUE INDEX `idx_app_dataset` (`app_id`, `dataset_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='应用关联知识库表';

CREATE TABLE IF NOT EXISTS `llmops_document` (
    `id` VARCHAR(36) PRIMARY KEY COMMENT '主键UUID',
    `account_id` VARCHAR(36) NOT NULL DEFAULT '' COMMENT '关联的用户id',
    `dataset_id` VARCHAR(36) NOT NULL DEFAULT '' COMMENT '关联的知识库id',
    `upload_file_id` VARCHAR(36) NOT NULL DEFAULT '' COMMENT '关联的文件id',
    `process_rule_id` VARCHAR(36) NOT NULL DEFAULT '' COMMENT '处理规则id',
    `batch` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '文档处理批次',
    `name` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '文档名字',
    `position` INT NOT NULL DEFAULT 1 COMMENT '文档位置',
    `character_count` INT NOT NULL DEFAULT 0 COMMENT '文档总字符',
    `token_count` INT NOT NULL DEFAULT 0 COMMENT '文档token数',
    `processing_started_at` TIMESTAMP NULL COMMENT '开始处理时间',
    `parsing_completed_at` TIMESTAMP NULL COMMENT '解析结束时间',
    `splitting_completed_at` TIMESTAMP NULL COMMENT '分割结束时间',
    `index_completed_at` TIMESTAMP NULL COMMENT '索引结束时间',
    `completed_at` TIMESTAMP NULL COMMENT '构建完成时间',
    `stopped_at` TIMESTAMP NULL COMMENT '停止时间',
    `error` TEXT COMMENT '错误日志',
    `enabled` TINYINT(1) NOT NULL DEFAULT 1 COMMENT '是否启用',
    `disabled_at` TIMESTAMP NULL COMMENT '人为禁用时间',
    `status` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '状态',
    `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    INDEX `idx_account_id` (`account_id`),
    INDEX `idx_dataset_id` (`dataset_id`),
    INDEX `idx_upload_file_id` (`upload_file_id`),
    INDEX `idx_batch` (`batch`),
    INDEX `idx_status` (`status`),
    INDEX `idx_enabled` (`enabled`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='文档';

CREATE TABLE IF NOT EXISTS `llmops_segment` (
    `id` VARCHAR(36) PRIMARY KEY COMMENT '主键UUID',
    `account_id` VARCHAR(36) NOT NULL DEFAULT '' COMMENT '关联的用户id',
    `dataset_id` VARCHAR(36) NOT NULL DEFAULT '' COMMENT '关联的知识库id',
    `document_id` VARCHAR(36) NOT NULL DEFAULT '' COMMENT '关联的文档id',
    `node_id` VARCHAR(36) NOT NULL DEFAULT '' COMMENT '向量数据库节点id用于快速查找',
    `position` INT NOT NULL DEFAULT 1 COMMENT '片段在文档的位置',
    `content` TEXT NOT NULL COMMENT '片段内容',
    `character_count` INT NOT NULL DEFAULT 0 COMMENT '片段长度',
    `token_count` INT NOT NULL DEFAULT 0 COMMENT 'token词数',
    `keywords` JSON COMMENT '关键词列表',
    `hash` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '内容哈希值',
    `hit_count` INT NOT NULL DEFAULT 0 COMMENT '命中次数',
    `enabled` BOOLEAN NOT NULL DEFAULT FALSE COMMENT '是否启用',
    `disabled_at` TIMESTAMP NULL DEFAULT NULL COMMENT '禁用时间',
    `processing_started_at` TIMESTAMP NULL DEFAULT NULL COMMENT '开始处理时间',
    `index_completed_at` TIMESTAMP NULL DEFAULT NULL COMMENT '索引结束时间',
    `completed_at` TIMESTAMP NULL DEFAULT NULL COMMENT '构建完成时间',
    `stopped_at` TIMESTAMP NULL DEFAULT NULL COMMENT '停止时间',
    `error` TEXT COMMENT '错误日志',
    `status` VARCHAR(255) NOT NULL DEFAULT 'waiting' COMMENT '状态（如 waiting/processing/completed）',
    `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    INDEX `idx_account_id` (`account_id`),
    INDEX `idx_dataset_id` (`dataset_id`),
    INDEX `idx_document_id` (`document_id`),
    INDEX `idx_status` (`status`),
    INDEX `idx_node_id` (`node_id`),
    UNIQUE INDEX `idx_hash` (`hash`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='文档片段';


--------------------------
工具
--------------------------
CREATE TABLE IF NOT EXISTS `llmops_api_tool` (
    `id` VARCHAR(36) PRIMARY KEY COMMENT '主键UUID',
    `account_id` VARCHAR(36) NOT NULL DEFAULT '' COMMENT '关联的用户id',
    `provider_id` VARCHAR(36) NOT NULL DEFAULT '' COMMENT '关联的提供者id',
    `name` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '工具名称',
    `description` TEXT COMMENT '工具描述',
    `url` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '工具API地址',
    `method` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '路由方法',
    `parameters` JSON COMMENT '工具参数',
    `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    INDEX `idx_account_id` (`account_id`),
    INDEX `idx_name` (`name`),
    UNIQUE INDEX `idx_account_name` (`account_id`, `name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='API工具';

CREATE TABLE IF NOT EXISTS `llmops_api_tool_provider` (
    `id` VARCHAR(36) PRIMARY KEY COMMENT '主键UUID',
    `account_id` VARCHAR(36) NOT NULL DEFAULT '' COMMENT '关联的用户id',
    `name` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '提供商名称',
    `icon` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '提供商图标',
    `description` TEXT COMMENT '应用描述',
    `openapi_schema` JSON COMMENT '描述规范',
    `headers` JSON COMMENT '提供商对应的请求头',
    `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    INDEX `idx_account_id` (`account_id`),
    INDEX `idx_name` (`name`),
    UNIQUE INDEX `idx_account_name` (`account_id`, `name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='API工具提供者';

--------------------------
AI对话
--------------------------
CREATE TABLE IF NOT EXISTS `llmops_message` (
    `id` VARCHAR(36) PRIMARY KEY COMMENT '主键UUID',
    `app_id` VARCHAR(36) NOT NULL DEFAULT '' COMMENT '应用id',
    `conversation` VARCHAR(36) NOT NULL DEFAULT '' COMMENT '会话id',
    `invoke_from` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '调用来源',
    `created_by` VARCHAR(36) NOT NULL DEFAULT '' COMMENT '创建账号id',
    `query` TEXT NOT NULL COMMENT '消息的原始问题',
    `message` JSON NOT NULL COMMENT '最终消息列表',
    `message_token_count` INT NOT NULL DEFAULT 0 COMMENT 'token数',
    `message_unit_price` FLOAT NOT NULL DEFAULT 0 COMMENT '单价',
    `message_price_unit` FLOAT NOT NULL DEFAULT 0 COMMENT '价格单位',
    `answer` TEXT NOT NULL COMMENT 'AI内容消息',
    `answer_token_count` INT NOT NULL DEFAULT 0 COMMENT 'token数',
    `answer_unit_price` FLOAT NOT NULL DEFAULT 0 COMMENT '单价',
    `answer_price_unit` FLOAT NOT NULL DEFAULT 0 COMMENT '价格单位',
    `latency` FLOAT NOT NULL DEFAULT 0 COMMENT '响应耗时',
    `total_token_count` INT NOT NULL DEFAULT 0 COMMENT '总token数',
    `total_price` FLOAT NOT NULL DEFAULT 0 COMMENT '消息总价格',
    `status` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '状态',
    `error` TEXT NOT NULL COMMENT '错误日志',
    `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    INDEX `idx_created_by` (`created_by`),
    INDEX `idx_app_id` (`app_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='消息表';

CREATE TABLE IF NOT EXISTS `llmops_message_agent_thought` (
    `id` VARCHAR(36) PRIMARY KEY COMMENT '主键UUID',
    `app_id` VARCHAR(36) NOT NULL DEFAULT '' COMMENT '关联的应用id',
    `conversation_id` VARCHAR(36) NOT NULL DEFAULT '' COMMENT '对话id',
    `message_id` VARCHAR(36) NOT NULL DEFAULT '' COMMENT '关联消息id',
    `invoke_from` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '来源',
    `created_by` VARCHAR(36) NOT NULL DEFAULT '' COMMENT '创建者id',
    `position` INT NOT NULL DEFAULT 0 COMMENT '推理步骤位置',
    `event` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '事件类型',
    `thought` TEXT NOT NULL COMMENT '推理内容',
    `observation` TEXT NOT NULL COMMENT '观察内容',
    `tool` TEXT NOT NULL COMMENT '工具名称',
    `tool_label` TEXT NOT NULL COMMENT '工具标签',
    `tool_params` JSON NOT NULL COMMENT '工具配置参数',
    `tool_input` JSON NOT NULL COMMENT '工具LLM输入',
    `message` JSON NOT NULL COMMENT '推理的消息列表',
    `message_token_count` INT NOT NULL DEFAULT 0 COMMENT 'token数',
    `message_unit_price` FLOAT NOT NULL DEFAULT 0 COMMENT '单价',
    `message_price_unit` FLOAT NOT NULL DEFAULT 0 COMMENT '价格单位',
    `answer` TEXT NOT NULL COMMENT '答案',
    `answer_token_count` INT NOT NULL DEFAULT 0 COMMENT 'token数',
    `answer_unit_price` FLOAT NOT NULL DEFAULT 0 COMMENT '单价',
    `answer_price_unit` FLOAT NOT NULL DEFAULT 0 COMMENT '价格单位',
    `total_token_count` INT NOT NULL DEFAULT 0 COMMENT '总token数',
    `total_price` FLOAT NOT NULL DEFAULT 0 COMMENT '消息总价格',
    `latency` FLOAT NOT NULL DEFAULT 0 COMMENT '响应耗时',
    `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    INDEX `idx_app_id` (`app_id`),
    INDEX `idx_message_id` (`message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='智能体消息推理表';

CREATE TABLE IF NOT EXISTS `llmops_conversation` (
    `id` VARCHAR(36) PRIMARY KEY COMMENT '主键UUID',
    `app_id` VARCHAR(36) NOT NULL DEFAULT '' COMMENT '应用id',
    `name` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '会话名称',
    `summary` TEXT COMMENT '会话概要',
    `is_pinned` BOOLEAN NOT NULL DEFAULT FALSE COMMENT '是否置顶',
    `is_delete` BOOLEAN NOT NULL DEFAULT FALSE COMMENT '是否删除',
    `invoke_from` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '来源',
    `created_by` VARCHAR(36) NOT NULL COMMENT '创建会话的id',
    `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    INDEX `idx_app_id` (`app_id`),
    INDEX `idx_is_delete` (`is_delete`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='会话表';

--------------------------
apikey
--------------------------
CREATE TABLE IF NOT EXISTS `llmops_api_key` (
    `id` VARCHAR(36) PRIMARY KEY COMMENT '主键UUID',
    `account_id` VARCHAR(36) NOT NULL DEFAULT '' COMMENT '关联的用户id',
    `api_key` VARCHAR(255) NOT NULL DEFAULT '' COMMENT 'API密钥',
    `is_active` BOOLEAN NOT NULL DEFAULT FALSE COMMENT '是否激活',
    `remark` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '备注信息',
    `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    INDEX `idx_account_id` (`account_id`),
    UNIQUE INDEX `uniq_api_key` (`api_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='API密钥表';

--------------------------
工作流
--------------------------
CREATE TABLE IF NOT EXISTS `llmops_workflow` (
    `id` VARCHAR(36) PRIMARY KEY COMMENT '主键UUID',
    `account_id` VARCHAR(36) NOT NULL DEFAULT '' COMMENT '关联的用户id',
    `name` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '工作流名称',
    `tool_call_name` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '工作流调用名称',
    `icon` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '工作流图标',
    `description` TEXT COMMENT '工作流描述',
    `graph` JSON NOT NULL COMMENT '工作流图结构信息',
    `draft_graph` JSON NOT NULL COMMENT '工作流草稿图',
    `is_debug_passed` BOOLEAN NOT NULL DEFAULT FALSE COMMENT '调试是否通过',
    `status` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '工作流状态',
    `published_at` TIMESTAMP NULL DEFAULT NULL COMMENT '发布时间',
    `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    INDEX `idx_account_id` (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='工作流模型';

CREATE TABLE IF NOT EXISTS `llmops_workflow_result` (
    `id` VARCHAR(36) PRIMARY KEY COMMENT '主键UUID',
    `account_id` VARCHAR(36) NOT NULL DEFAULT '' COMMENT '关联的用户id',
    `app_id` VARCHAR(36) NOT NULL DEFAULT '' COMMENT '关联的应用id',
    `workflow_id` VARCHAR(36) NOT NULL DEFAULT '' COMMENT '结果关联的工作流id',
    `graph` JSON NOT NULL COMMENT '运行该结果的图结构',
    `state` JSON NOT NULL COMMENT '工作流的最终结果状态',
    `latency` FLOAT NOT NULL DEFAULT 0 COMMENT '工作流的整体耗时（单位：秒）',
    `status` VARCHAR(64) NOT NULL DEFAULT 'pending' COMMENT '状态（pending/running/success/failed）',
    `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    INDEX `idx_workflow_id` (`workflow_id`),
    INDEX `idx_app_id` (`app_id`),
    INDEX `idx_account_id` (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='工作流村粗结果模型';