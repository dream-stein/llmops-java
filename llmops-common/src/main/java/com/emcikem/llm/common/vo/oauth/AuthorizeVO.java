package com.emcikem.llm.common.vo.oauth;

import lombok.Data;

/**
 * Create with Emcikem on 2025/3/28
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class AuthorizeVO {

    private String access_token;

    private Long expire_at;
}
