package com.emcikem.llm.service.convert;

import com.emcikem.llm.common.vo.workflow.WorkflowDetailVO;
import com.emcikem.llm.common.vo.workflow.WorkflowVO;
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
        workflowVO.setDescription(datasetDO.getDescription());
        workflowVO.setIcon(datasetDO.getIcon());
        workflowVO.setStatus(datasetDO.getStatus());
        workflowVO.setUpdated_at(datasetDO.getUpdatedAt().getTime());
        workflowVO.setCreated_at(datasetDO.getCreatedAt().getTime());
        workflowVO.setIs_debug_passed(datasetDO.getIsDebugPassed());
//        workflowVO.setNode_count();
        workflowVO.setTool_call_name(datasetDO.getToolCallName());
        workflowVO.setPublished_at(datasetDO.getPublishedAt().getTime());
        return workflowVO;
    }

    public static WorkflowDetailVO convert2DetailVO(LlmOpsWorkflowDO datasetDO) {
        if (datasetDO == null) {
            return null;
        }
        WorkflowDetailVO workflowDetailVO = new WorkflowDetailVO();
        workflowDetailVO.setId(datasetDO.getId());
        workflowDetailVO.setName(datasetDO.getName());
        workflowDetailVO.setDescription(datasetDO.getDescription());
        workflowDetailVO.setIcon(datasetDO.getIcon());
        workflowDetailVO.setStatus(datasetDO.getStatus());
        workflowDetailVO.setUpdated_at(datasetDO.getUpdatedAt().getTime());
        workflowDetailVO.setCreated_at(datasetDO.getCreatedAt().getTime());
        workflowDetailVO.setIs_debug_passed(datasetDO.getIsDebugPassed());
//        workflowDetailVO.setNode_count();
        workflowDetailVO.setTool_call_name(datasetDO.getToolCallName());
        workflowDetailVO.setPublished_at(datasetDO.getPublishedAt().getTime());
        return workflowDetailVO;
    }
}
