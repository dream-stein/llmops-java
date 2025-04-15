package com.emcikem.llm.common.vo.file;

import lombok.Data;

/**
 * Create with Emcikem on 2025/4/12
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class UploadFileVO {

    private String id;

    private String account_id;

    private String name;

    private String key;

    private Long size;

    private String extension;

    private String mine_type;

    private Long created_at;
}
