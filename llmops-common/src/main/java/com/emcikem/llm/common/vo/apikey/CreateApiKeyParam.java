package com.emcikem.llm.common.vo.apikey;

import lombok.Data;

/**
 * Create with Emcikem on 2025/3/28
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class CreateApiKeyParam {

    private boolean is_active;

    private String remark;
}
