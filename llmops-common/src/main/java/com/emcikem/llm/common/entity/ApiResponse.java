package com.emcikem.llm.common.entity;

import com.emcikem.llm.common.enums.ResponseStatusEnum;
import lombok.Data;

/**
 * Create with Emcikem on 2025/1/19
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class ApiResponse<T> {

    private Integer code;

    private String message;

    private T data;

    public ApiResponse() {
    }

    public ApiResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ApiResponse(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static<T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(ResponseStatusEnum.SUCCESS.getCode(), ResponseStatusEnum.SUCCESS.getMsg(), data);
    }

    public static <T> ApiResponse<T> error(int code, String msg) {
        return new ApiResponse<>(code, msg);
    }

    public static <T> ApiResponse<T> error(ResponseStatusEnum statusEnum) {
        return new ApiResponse<>(statusEnum.getCode(), statusEnum.getMsg());
    }
}
