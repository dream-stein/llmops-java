package com.emcikem.llm.service.service.dataset;

import com.emcikem.llm.dao.entity.LlmOpsDocumentDO;
import com.emcikem.llm.service.provider.LLMOpsDatasetProvider;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create with Emcikem on 2025/5/22
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Service
public class LLMOpsDocumentTask {

    @Resource
    private LLMOpsDatasetProvider llmOpsDatasetProvider;

    /**
     * 根据传递的文档id列表构建文档，涵盖了加载、分割、索引构建、数据村粗等内容
     * @param documentIdList
     */
    public void buildDocumentsAsync(List<String> documentIdList) {
        // 1. 根据传递的文档id获取所有的文档
        List<LlmOpsDocumentDO> llmOpsDocumentList = llmOpsDatasetProvider.getDocumentListByIdList(documentIdList);

        // 2. 执行循环遍历所有文档完成对每个文档的构建
        for (LlmOpsDocumentDO documentDO : llmOpsDocumentList) {
            try {

            } catch (Exception ex) {
                llmOpsDatasetProvider.updateDocument();
            }
        }
    }
}
