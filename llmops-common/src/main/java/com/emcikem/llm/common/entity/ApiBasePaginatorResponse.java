package com.emcikem.llm.common.entity;

import com.emcikem.llm.common.enums.ResponseStatusEnum;
import lombok.Data;

import java.util.List;

/**
 * Create with Emcikem on 2025/3/28
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class ApiBasePaginatorResponse<T> {

    private Integer code;

    private String message;

    private PaginatorListData<T> data;

    public ApiBasePaginatorResponse() {
    }

    public ApiBasePaginatorResponse(List<T> list, Paginator paginator) {
        this.data = new PaginatorListData<>(list, paginator);
    }

    public ApiBasePaginatorResponse(ResponseStatusEnum responseStatusEnum, List<T> list, Paginator paginator) {
        this.code = responseStatusEnum.getCode();
        this.message = responseStatusEnum.getMsg();
        this.data = new PaginatorListData<>(list, paginator);
    }

    public ApiBasePaginatorResponse(Integer code, String message, List<T> list, Paginator paginator) {
        this.code = code;
        this.message = message;
        this.data = new PaginatorListData<>(list, paginator);
    }

    public ApiBasePaginatorResponse(Integer code, List<T> list, Paginator paginator) {
        this.code = code;
        this.message = message;
        this.data = new PaginatorListData<>(list, paginator);
    }

    public static<T> ApiBasePaginatorResponse<T> success(List<T> data, Paginator paginator) {
        return new ApiBasePaginatorResponse<>(ResponseStatusEnum.SUCCESS, data, paginator);
    }

    public static <T> ApiBasePaginatorResponse<T> error(int code, String msg) {
        return new ApiBasePaginatorResponse<T>(code, msg, null, null);
    }

    public static <T> ApiBasePaginatorResponse<T> error(ResponseStatusEnum statusEnum) {
        return new ApiBasePaginatorResponse<T>(statusEnum.getCode(), statusEnum.getMsg(), null, null);
    }
}
