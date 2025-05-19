package com.emcikem.llm.service.provider;

import com.emcikem.llm.dao.example.LlmOpsAppDatasetJoinDOExample;
import com.emcikem.llm.dao.mapper.LlmOpsAppDatasetJoinDOExtMapper;
import com.emcikem.llm.dao.mapper.LlmOpsAppDatasetJoinDOMapper;
import jakarta.annotation.Resource;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Create with Emcikem on 2025/5/17
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Service
public class LLMOpsAppDatasetJoinProvider {

    @Resource
    private LlmOpsAppDatasetJoinDOMapper llmOpsAppDatasetJoinDOMapper;

    @Resource
    private LlmOpsAppDatasetJoinDOExtMapper llmOpsAppDatasetJoinDOExtMapper;

    public Long countAppDatasetJoin(String datasetId) {
        LlmOpsAppDatasetJoinDOExample example = new LlmOpsAppDatasetJoinDOExample();
        example.createCriteria().andDatasetIdEqualTo(datasetId);
        return llmOpsAppDatasetJoinDOMapper.countByExample(example);
    }

    public Map<String, Integer> countAppDatasetJoinByDataBaseIdList(List<String> databaseIdList) {
        List<Map<String, Object>> list = llmOpsAppDatasetJoinDOExtMapper.countAppJoinByDatasetIdList(databaseIdList);
        return list.stream().map(map -> {
            Integer total = MapUtils.getInteger(map, "total");
            String datasetId = MapUtils.getString(map, "datasetId");
            return Pair.of(datasetId, total);
        }).collect(Collectors.toMap(Pair::getKey, Pair::getValue, (a, b) -> a));
    }
}
