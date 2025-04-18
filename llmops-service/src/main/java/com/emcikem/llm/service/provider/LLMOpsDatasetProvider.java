package com.emcikem.llm.service.provider;

import com.emcikem.llm.dao.entity.LlmOpsDatasetDO;
import com.emcikem.llm.dao.entity.LlmOpsDocumentDO;
import com.emcikem.llm.dao.entity.LlmOpsSegmentDO;
import com.emcikem.llm.dao.example.LlmOpsDatasetDOExample;
import com.emcikem.llm.dao.example.LlmOpsDocumentDOExample;
import com.emcikem.llm.dao.example.LlmOpsSegmentDOExample;
import com.emcikem.llm.dao.mapper.LlmOpsDatasetDOMapper;
import com.emcikem.llm.dao.mapper.LlmOpsDocumentDOMapper;
import com.emcikem.llm.dao.mapper.LlmOpsSegmentDOMapper;
import jakarta.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create with Emcikem on 2025/3/30
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Service
public class LLMOpsDatasetProvider {

    @Resource
    private LlmOpsDatasetDOMapper llmOpsDatasetDOMapper;

    @Resource
    private LlmOpsDocumentDOMapper llmOpsDocumentDOMapper;

    @Resource
    private LlmOpsSegmentDOMapper llmOpsSegmentDOMapper;

    public LlmOpsDatasetDO getDataset(String datasetId, String accountId) {
        LlmOpsDatasetDOExample example = new LlmOpsDatasetDOExample();
        LlmOpsDatasetDOExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(datasetId);
        criteria.andAccountIdEqualTo(accountId);
        List<LlmOpsDatasetDO> llmOpsDatasetList = llmOpsDatasetDOMapper.selectByExampleWithBLOBs(example);
        if (CollectionUtils.isEmpty(llmOpsDatasetList)) {
            return null;
        }
        return llmOpsDatasetList.get(0);
    }

    public Long countDatasetList(String accountId, String searchWord) {
        LlmOpsDatasetDOExample example = new LlmOpsDatasetDOExample();
        LlmOpsDatasetDOExample.Criteria criteria = example.createCriteria();
        criteria.andAccountIdEqualTo(accountId);
        if (StringUtils.isNoneBlank(searchWord)) {
            criteria.andNameLike("%" + searchWord + "%");
        }
        return llmOpsDatasetDOMapper.countByExample(example);
    }

    public List<LlmOpsDatasetDO> getDatasetList(Integer limit, Integer offset, String accountId, String searchWord) {
        LlmOpsDatasetDOExample example = new LlmOpsDatasetDOExample();
        example.setOffset(offset);
        example.setRows(limit);
        LlmOpsDatasetDOExample.Criteria criteria = example.createCriteria();
        criteria.andAccountIdEqualTo(accountId);
        if (StringUtils.isNoneBlank(searchWord)) {
            criteria.andNameLike("%" + searchWord + "%");
        }
        return llmOpsDatasetDOMapper.selectByExampleWithBLOBs(example);
    }

    public boolean deleteDataset(String accountId, String datasetId) {
        LlmOpsDatasetDOExample example = new LlmOpsDatasetDOExample();
        LlmOpsDatasetDOExample.Criteria criteria = example.createCriteria();
        criteria.andAccountIdEqualTo(accountId);
        criteria.andIdEqualTo(datasetId);
        return llmOpsDatasetDOMapper.deleteByExample(example) == 1;
    }

    public boolean createDataset(LlmOpsDatasetDO llmOpsDatasetDO) {
        return llmOpsDatasetDOMapper.insert(llmOpsDatasetDO) == 1;
    }

    public boolean updateDataset(String datasetId, String accountId, LlmOpsDatasetDO llmOpsDatasetDO) {
        LlmOpsDatasetDOExample example = new LlmOpsDatasetDOExample();
        LlmOpsDatasetDOExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(datasetId);
        criteria.andAccountIdEqualTo(accountId);
        return llmOpsDatasetDOMapper.updateByExampleSelective(llmOpsDatasetDO, example) == 1;
    }

    public boolean updateDocument(String datasetId, String documentId, String accountId, LlmOpsDocumentDO llmOpsDocumentDO) {
        LlmOpsDocumentDOExample example = new LlmOpsDocumentDOExample();
        LlmOpsDocumentDOExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(documentId);
        criteria.andAccountIdEqualTo(accountId);
        criteria.andDatasetIdEqualTo(datasetId);
        return llmOpsDocumentDOMapper.updateByExampleSelective(llmOpsDocumentDO, example) == 1;
    }

    public boolean deleteDocument(String datasetId, String documentId, String accountId) {
        LlmOpsDocumentDOExample example = new LlmOpsDocumentDOExample();
        LlmOpsDocumentDOExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(datasetId);
        criteria.andAccountIdEqualTo(accountId);
        criteria.andDatasetIdEqualTo(documentId);
        return llmOpsDocumentDOMapper.deleteByExample(example) == 1;
    }

    public Long countDocumentList(String accountId, String searchWord, String datasetId) {
        LlmOpsDocumentDOExample example = new LlmOpsDocumentDOExample();
        LlmOpsDocumentDOExample.Criteria criteria = example.createCriteria();
        criteria.andAccountIdEqualTo(accountId);
        criteria.andDatasetIdEqualTo(datasetId);
        if (StringUtils.isNoneBlank(searchWord)) {
            criteria.andNameLike("%" + searchWord + "%");
        }
        return llmOpsDocumentDOMapper.countByExample(example);
    }

    public List<LlmOpsDocumentDO> getDocumentList(Integer pageSize, Integer offset, String accountId, String datasetId, String searchWord) {
        LlmOpsDocumentDOExample example = new LlmOpsDocumentDOExample();
        example.setOffset(offset);
        example.setRows(pageSize);
        LlmOpsDocumentDOExample.Criteria criteria = example.createCriteria();
        criteria.andAccountIdEqualTo(accountId);
        criteria.andDatasetIdEqualTo(datasetId);
        if (StringUtils.isNoneBlank(searchWord)) {
            criteria.andNameLike("%" + searchWord + "%");
        }
        return llmOpsDocumentDOMapper.selectByExampleWithBLOBs(example);
    }

    public LlmOpsDocumentDO getDocument(String accountId, String datasetId, String documentId) {
        LlmOpsDocumentDOExample example = new LlmOpsDocumentDOExample();
        LlmOpsDocumentDOExample.Criteria criteria = example.createCriteria();
        criteria.andAccountIdEqualTo(accountId);
        criteria.andDatasetIdEqualTo(datasetId);
        criteria.andIdEqualTo(documentId);
        List<LlmOpsDocumentDO> llmOpsDocumentList = llmOpsDocumentDOMapper.selectByExampleWithBLOBs(example);
        if (CollectionUtils.isEmpty(llmOpsDocumentList)) {
            return null;
        }
        return llmOpsDocumentList.get(0);
    }

    public Long countSegmentList(String datasetId, String documentId, String accountId, String searchWord) {
        LlmOpsSegmentDOExample example = new LlmOpsSegmentDOExample();
        LlmOpsSegmentDOExample.Criteria criteria = example.createCriteria();
        criteria.andDatasetIdEqualTo(datasetId);
        criteria.andAccountIdEqualTo(accountId);
        criteria.andDocumentIdEqualTo(documentId);
//        if (StringUtils.isNoneBlank(searchWord)) {
//            criteria.andCon
//        }
        return llmOpsSegmentDOMapper.countByExample(example);
    }


    public List<LlmOpsSegmentDO> getSegmentList(Integer pageSize, Integer offset, String accountId, String searchWord, String datasetId, String documentId) {
        LlmOpsSegmentDOExample example = new LlmOpsSegmentDOExample();
        example.setOffset(offset);
        example.setRows(pageSize);
        LlmOpsSegmentDOExample.Criteria criteria = example.createCriteria();
        criteria.andDatasetIdEqualTo(datasetId);
        criteria.andAccountIdEqualTo(accountId);
        criteria.andDocumentIdEqualTo(documentId);
        // TODO：修改
        if (StringUtils.isNoneBlank(searchWord)) {
//            criteria.and
        }
        return llmOpsSegmentDOMapper.selectByExampleWithBLOBs(example);
    }

    public LlmOpsSegmentDO getSegment(String datasetId, String documentId, String segmentId, String accountId) {
        LlmOpsSegmentDOExample example = new LlmOpsSegmentDOExample();
        LlmOpsSegmentDOExample.Criteria criteria = example.createCriteria();
        criteria.andDatasetIdEqualTo(datasetId);
        criteria.andDocumentIdEqualTo(documentId);
        criteria.andIdEqualTo(segmentId);
        criteria.andAccountIdEqualTo(accountId);
        List<LlmOpsSegmentDO> llmOpsSegmentList = llmOpsSegmentDOMapper.selectByExampleWithBLOBs(example);
        if (CollectionUtils.isEmpty(llmOpsSegmentList)) {
            return null;
        }
        return llmOpsSegmentList.get(0);
    }

    public boolean updateSegment(String datasetId, String documentId, String segmentId, String accountId, LlmOpsSegmentDO llmOpsSegmentDO) {
        LlmOpsSegmentDOExample example = new LlmOpsSegmentDOExample();
        LlmOpsSegmentDOExample.Criteria criteria = example.createCriteria();
        criteria.andDatasetIdEqualTo(datasetId);
        criteria.andDocumentIdEqualTo(documentId);
        criteria.andIdEqualTo(segmentId);
        criteria.andAccountIdEqualTo(accountId);

        return llmOpsSegmentDOMapper.updateByExampleSelective(llmOpsSegmentDO, example) == 1;
    }

    public boolean deleteSegment(String datasetId, String documentId, String segmentId, String accountId) {
        LlmOpsSegmentDOExample example = new LlmOpsSegmentDOExample();
        LlmOpsSegmentDOExample.Criteria criteria = example.createCriteria();
        criteria.andDatasetIdEqualTo(datasetId);
        criteria.andDocumentIdEqualTo(documentId);
        criteria.andIdEqualTo(segmentId);
        criteria.andAccountIdEqualTo(accountId);
        return llmOpsSegmentDOMapper.deleteByExample(example) == 1;
    }

    public boolean createSegment(LlmOpsSegmentDO llmOpsSegmentDO) {
        return llmOpsSegmentDOMapper.insert(llmOpsSegmentDO) == 1;
    }
}
