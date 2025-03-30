package com.emcikem.llm.service.convert;

import com.emcikem.llm.common.vo.dataset.DatasetVO;
import com.emcikem.llm.common.vo.workflow.WorkflowVO;
import com.emcikem.llm.dao.entity.LlmOpsDatasetDO;
import com.emcikem.llm.dao.entity.LlmOpsWorkflowDO;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Create with Emcikem on 2025/3/30
 *
 * @author Emcikem
 * @version 1.0.0
 */
public class LLMOpsWorkflowConvert {

    public static List<WorkflowVO> convert(List<LlmOpsWorkflowDO> list) {
        if (CollectionUtils.isEmpty(list)) {
            return Lists.newArrayList();
        }
        return list.stream().map(LLMOpsWorkflowConvert::convert).filter(Objects::nonNull).collect(Collectors.toList());
    }

    public static WorkflowVO convert(LlmOpsWorkflowDO datasetDO) {
        if (datasetDO == null) {
            return null;
        }
        WorkflowVO workflowVO = new WorkflowVO();
        workflowVO.setId(datasetDO.getId());
        workflowVO.setName(datasetDO.getName());
//        workflowVO.setDescription(da);
        workflowVO.setIcon(datasetDO.getIcon());
        workflowVO.setStatus(datasetDO.getStatus());
        workflowVO.setUpdated_at(datasetDO.getUpdatedAt().getTime());
        workflowVO.setCreated_at(datasetDO.getCreatedAt().getTime());
        workflowVO.setIs_debug_passed(datasetDO.getIsDebugPassed());
//        workflowVO.setNode_count();
//        workflowVO.setTool_call_name();
        workflowVO.setPublished_at(datasetDO.getPublishedAt().getTime());
        return workflowVO;
    }
}
