package com.emcikem.llm.service.provider;

import com.emcikem.llm.dao.entity.LlmOpsKeywordTableDO;
import com.emcikem.llm.dao.example.LlmOpsKeywordTableDOExample;
import com.emcikem.llm.dao.mapper.LlmOpsKeywordTableDOMapper;
import jakarta.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create with Emcikem on 2025/6/2
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Service
public class LLMOpsKeyWordProvider {

    @Resource
    private LlmOpsKeywordTableDOMapper llmOpsKeywordTableDOMapper;

    public LlmOpsKeywordTableDO getKeyWordTableByDatasetId(String datasetId) {
        LlmOpsKeywordTableDOExample example = new LlmOpsKeywordTableDOExample();
        example.createCriteria().andDatasetIdEqualTo(datasetId);
        List<LlmOpsKeywordTableDO> llmOpsKeywordTableList = llmOpsKeywordTableDOMapper.selectByExampleWithBLOBs(example);
        if (CollectionUtils.isEmpty(llmOpsKeywordTableList)) {
            return null;
        }
        return llmOpsKeywordTableList.get(0);
    }

    public boolean updateKeyword(LlmOpsKeywordTableDO keyWordTableDO) {
        return llmOpsKeywordTableDOMapper.updateByPrimaryKeySelective(keyWordTableDO) == 1;
    }

    public boolean insertKeywordTable(LlmOpsKeywordTableDO llmOpsKeywordTableDO) {
        return llmOpsKeywordTableDOMapper.insert(llmOpsKeywordTableDO) == 1;
    }
}
