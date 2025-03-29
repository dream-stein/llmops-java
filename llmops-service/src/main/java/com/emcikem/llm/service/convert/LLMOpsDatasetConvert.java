package com.emcikem.llm.service.convert;

import com.emcikem.llm.common.vo.dataset.DatasetVO;
import com.emcikem.llm.dao.entity.LlmOpsDatasetDO;
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
public class LLMOpsDatasetConvert {

    public static List<DatasetVO> convert(List<LlmOpsDatasetDO> list) {
        if (CollectionUtils.isEmpty(list)) {
            return Lists.newArrayList();
        }
        return list.stream().map(LLMOpsDatasetConvert::convert).filter(Objects::nonNull).collect(Collectors.toList());
    }

    public static DatasetVO convert(LlmOpsDatasetDO datasetDO) {
        if (datasetDO == null) {
            return null;
        }
        DatasetVO datasetVO = new DatasetVO();
        datasetVO.setId(datasetDO.getId());
        datasetVO.setIcon(datasetDO.getIcon());
        datasetVO.setName(datasetDO.getName());
        datasetVO.setDescription(datasetDO.getDescription());
        datasetVO.setCreated_at(datasetDO.getCreatedAt().getTime());
        datasetVO.setUpdated_at(datasetDO.getUpdatedAt().getTime());
        return datasetVO;
    }
}
