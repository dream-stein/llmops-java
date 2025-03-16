package com.emcikem.llm.common.vo.dataset;

import com.emcikem.llm.common.vo.apitools.Paginator;
import lombok.Data;

import java.util.List;

/**
 * Create with Emcikem on 2025/3/14
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class DatasetListVO {

    private List<DatasetVO> list;

    private Paginator paginator;
}
