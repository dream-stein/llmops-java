package com.emcikem.llm.common.entity;

import lombok.Data;

/**
 * Create with Emcikem on 2025/1/19
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class BaseResponse<T> {

    private Integer code;

    private String message;

    private T data;

    public BaseResponse<T> ofSuccess(T data) {
        BaseResponse<T> response = new BaseResponse<T>();
        response.setCode(0);
        response.setData(data);
        return response;
    }
}
