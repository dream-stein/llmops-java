package com.emcikem.llm.common.vo.apikey;

import lombok.Data;

/**
 * Create with Emcikem on 2025/3/28
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class ApiKeysPageVO {

    private String id;

    private String api_key;

    private boolean is_active;

    private String remark;

    private Long updated_at;

    private Long created_at;
}
