package com.emcikem.llm.web.request;

import lombok.Data;

/**
 * Create with Emcikem on 2025/1/19
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class DialogEditNameRequest {

    private Long dialogId;

    private String tenant;

    private String dialogName;
}
