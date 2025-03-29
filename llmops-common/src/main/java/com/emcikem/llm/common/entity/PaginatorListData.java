package com.emcikem.llm.common.entity;

import lombok.Data;

import java.util.List;

/**
 * Create with Emcikem on 2025/3/30
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class PaginatorListData <T> {

    private List<T> list;

    private Paginator paginator;

    public PaginatorListData() {
    }

    public PaginatorListData(List<T> list, Paginator paginator) {
        this.list = list;
        this.paginator = paginator;
    }
}
