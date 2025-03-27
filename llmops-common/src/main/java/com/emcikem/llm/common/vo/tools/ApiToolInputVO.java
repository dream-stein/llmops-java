package com.emcikem.llm.common.vo.tools;

import lombok.Data;

/**
 * Create with Emcikem on 2025/3/2
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class ApiToolInputVO {

    private String type;

    private boolean required;

    private String name;

    private String description;
}
