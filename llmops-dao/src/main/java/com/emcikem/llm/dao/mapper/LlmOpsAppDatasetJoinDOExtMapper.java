package com.emcikem.llm.dao.mapper;

import java.util.List;
import java.util.Map;

public interface LlmOpsAppDatasetJoinDOExtMapper {

    List<Map<String, Object>> countAppJoinByDatasetIdList(List<String> datasetIdList);

}