package com.emcikem.llm.common.vo.account;

import lombok.Data;

/**
 * Create with Emcikem on 2025/3/27
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class CurrentUserVO {

    private String id;

    private String name;

    private String email;

    private String avatar;

    private String last_login_ip;

    private Long last_login_at;

    private Long created_at;
}
