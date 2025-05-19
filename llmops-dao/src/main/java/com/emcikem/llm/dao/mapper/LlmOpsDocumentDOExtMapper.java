package com.emcikem.llm.dao.mapper;

import java.util.List;
import java.util.Map;

public interface LlmOpsDocumentDOExtMapper {

    Long sumDocumentCharacterCount(String accountId, String datasetId);

    List<Map<String, Object>> sumDocumentCharacterCountByDataBaseIdList(String accountId, List<String> datasetIdList);

    List<Map<String, Object>> countDocumentByDataBaseIdList(String accountId, List<String> datasetIdList);
}