package com.emcikem.llm.service.convert;

import com.emcikem.llm.common.util.GsonUtil;
import com.emcikem.llm.common.vo.dataset.*;
import com.emcikem.llm.dao.entity.LlmOpsDatasetDO;
import com.emcikem.llm.dao.entity.LlmOpsDatasetQueryDO;
import com.emcikem.llm.dao.entity.LlmOpsDocumentDO;
import com.emcikem.llm.dao.entity.LlmOpsSegmentDO;
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
        datasetVO.setCharacter_count(2);
        datasetVO.setDocument_count(3);
        datasetVO.setRelated_app_count(4);
        return datasetVO;
    }

    public static DatasetDetailVO convert2DetailVO(LlmOpsDatasetDO datasetDO) {
        if (datasetDO == null) {
            return null;
        }
        DatasetDetailVO datasetDetailVO = new DatasetDetailVO();
        datasetDetailVO.setId(datasetDO.getId());
        datasetDetailVO.setIcon(datasetDO.getIcon());
        datasetDetailVO.setName(datasetDO.getName());
        datasetDetailVO.setDescription(datasetDO.getDescription());
        datasetDetailVO.setCreated_at(datasetDO.getCreatedAt().getTime());
        datasetDetailVO.setUpdated_at(datasetDO.getUpdatedAt().getTime());
        datasetDetailVO.setCharacter_count(2);
        datasetDetailVO.setDocument_count(3);
        datasetDetailVO.setRelated_app_count(4);
        datasetDetailVO.setHit_count(1);
        return datasetDetailVO;
    }

    public static List<DatasetQueryVO> convert2QueryList(List<LlmOpsDatasetQueryDO> datasetQueryList) {
        if (CollectionUtils.isEmpty(datasetQueryList)) {
            return Lists.newArrayList();
        }
        return datasetQueryList.stream().map(LLMOpsDatasetConvert::convert2QueryVO).filter(Objects::nonNull).collect(Collectors.toList());
    }

    public static DatasetQueryVO convert2QueryVO(LlmOpsDatasetQueryDO datasetQueryDO) {
        if (datasetQueryDO == null) {
            return null;
        }
        DatasetQueryVO datasetQueryVO = new DatasetQueryVO();
        datasetQueryVO.setDataset_id(datasetQueryDO.getDatasetId());
        datasetQueryVO.setQuery(datasetQueryDO.getQuery());
        datasetQueryVO.setCreated_at(datasetQueryDO.getCreatedAt().getTime());
        datasetQueryVO.setSource(datasetQueryDO.getSource());
        datasetQueryVO.setId(datasetQueryDO.getId());
        return datasetQueryVO;
    }

    public static List<DocumentVO> convertDocumentList(List<LlmOpsDocumentDO> list) {
        if (CollectionUtils.isEmpty(list)) {
            return Lists.newArrayList();
        }
        return list.stream().map(LLMOpsDatasetConvert::convertDocument).filter(Objects::nonNull).collect(Collectors.toList());
    }

    public static DocumentVO convertDocument(LlmOpsDocumentDO documentDO) {
        if (documentDO == null) {
            return null;
        }
        DocumentVO documentVO = new DocumentVO();
        documentVO.setId(documentDO.getId());
        documentVO.setEnabled(documentDO.getEnabled());
        documentVO.setName(documentDO.getName());
        documentVO.setCreated_at(documentDO.getCreatedAt().getTime());
        documentVO.setUpdated_at(documentDO.getUpdatedAt().getTime());
        documentVO.setEnabled(documentDO.getEnabled());
        documentVO.setStatus(documentDO.getStatus());
        documentVO.setCharacter_count(documentDO.getCharacterCount());
//        documentVO.setHit_count(documentDO.get());
        documentVO.setPosition(documentDO.getPosition());
        return documentVO;
    }

    public static DocumentDetailVO convertDocumentDetail(LlmOpsDocumentDO documentDO) {
        if (documentDO == null) {
            return null;
        }
        DocumentDetailVO documentDetailVO = new DocumentDetailVO();
        documentDetailVO.setId(documentDO.getId());
        documentDetailVO.setEnabled(documentDO.getEnabled());
        documentDetailVO.setName(documentDO.getName());
        documentDetailVO.setCreated_at(documentDO.getCreatedAt().getTime());
        documentDetailVO.setUpdated_at(documentDO.getUpdatedAt().getTime());
        documentDetailVO.setEnabled(documentDO.getEnabled());
        documentDetailVO.setStatus(documentDO.getStatus());
        documentDetailVO.setCharacter_count(documentDO.getCharacterCount());
        documentDetailVO.setHit_count(2);
        documentDetailVO.setSegment_count(10);
        documentDetailVO.setPosition(documentDO.getPosition());
        return documentDetailVO;
    }

    public static List<SegmentVO> convertSegmentList(List<LlmOpsSegmentDO> segmentList) {
        if (CollectionUtils.isEmpty(segmentList)) {
            return Lists.newArrayList();
        }
        return segmentList.stream().map(LLMOpsDatasetConvert::convertSegment).filter(Objects::nonNull).collect(Collectors.toList());
    }

    public static SegmentVO convertSegment(LlmOpsSegmentDO segmentDO) {
        if (segmentDO == null) {
            return null;
        }

        SegmentVO segmentVO = new SegmentVO();
        segmentVO.setId(segmentDO.getId());
        segmentVO.setEnabled(segmentDO.getEnabled());
        segmentVO.setContent(segmentDO.getContent());
        segmentVO.setError(segmentDO.getError());
        segmentVO.setStatus(segmentDO.getStatus());
        segmentVO.setDisabled_at(segmentDO.getDisabledAt().getTime());
        segmentVO.setCreated_at(segmentDO.getCreatedAt().getTime());
        segmentVO.setUpdated_at(segmentDO.getUpdatedAt().getTime());
        segmentVO.setKeywords(GsonUtil.parseList(segmentDO.getKeywords(), String.class));
        segmentVO.setCharacter_count(segmentDO.getCharacterCount());
        segmentVO.setPosition(segmentDO.getPosition());
        segmentVO.setHit_count(1);
        segmentVO.setToken_count(segmentDO.getTokenCount());
        segmentVO.setDocument_id(segmentDO.getDocumentId());
        segmentVO.setDataset_id(segmentDO.getDatasetId());
        return segmentVO;
    }

    public static SegmentDetailVO convert2SegmentDetail(LlmOpsSegmentDO segmentDO) {
        if (segmentDO == null) {
            return null;
        }
        SegmentDetailVO segmentDetailVO = new SegmentDetailVO();
        segmentDetailVO.setId(segmentDO.getId());
        segmentDetailVO.setEnabled(segmentDO.getEnabled());
        segmentDetailVO.setContent(segmentDO.getContent());
        segmentDetailVO.setError(segmentDO.getError());
        segmentDetailVO.setStatus(segmentDO.getStatus());
        segmentDetailVO.setCharacter_count(segmentDO.getCharacterCount());
        segmentDetailVO.setHit_count(segmentDO.getHitCount());
        segmentDetailVO.setToken_count(segmentDO.getTokenCount());
        segmentDetailVO.setDataset_id(segmentDO.getDatasetId());
        segmentDetailVO.setDocument_id(segmentDO.getDocumentId());
        segmentDetailVO.setHash(segmentDO.getHash());
        segmentDetailVO.setCreated_at(segmentDO.getCreatedAt().getTime());
        segmentDetailVO.setUpdated_at(segmentDO.getUpdatedAt().getTime());
        segmentDetailVO.setKeywords(GsonUtil.parseList(segmentDO.getKeywords(), String.class));
        segmentDetailVO.setPosition(segmentDO.getPosition());
        return segmentDetailVO;
    }
}
