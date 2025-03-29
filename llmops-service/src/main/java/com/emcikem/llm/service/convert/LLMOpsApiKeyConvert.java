package com.emcikem.llm.service.convert;

import cn.hutool.core.collection.CollectionUtil;
import com.emcikem.llm.common.entity.ApiBasePaginatorResponse;
import com.emcikem.llm.common.vo.apikey.ApiKeysPageVO;
import com.emcikem.llm.dao.entity.LlmOpsApiKeyDO;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Create with Emcikem on 2025/3/29
 *
 * @author Emcikem
 * @version 1.0.0
 */
public class LLMOpsApiKeyConvert {

    public static List<ApiKeysPageVO> convert(List<LlmOpsApiKeyDO> apiKeysDOList) {
        if (CollectionUtil.isEmpty(apiKeysDOList)) {
            return Lists.newArrayList();
        }
        return apiKeysDOList.stream().map(LLMOpsApiKeyConvert::convert).filter(Objects::nonNull).collect(Collectors.toList());
    }

    public static ApiKeysPageVO convert(LlmOpsApiKeyDO apiKeyDO) {
        if (apiKeyDO == null) {
            return null;
        }
        ApiKeysPageVO apiKeysPageVO = new ApiKeysPageVO();
        apiKeysPageVO.setId(apiKeyDO.getId());
        apiKeysPageVO.setApi_key(apiKeyDO.getApiKey());
        apiKeysPageVO.setCreated_at(apiKeyDO.getCreatedAt().getTime());
        apiKeysPageVO.setUpdated_at(apiKeyDO.getUpdatedAt().getTime());
        apiKeysPageVO.setRemark(apiKeyDO.getRemark());
        apiKeysPageVO.setIs_active(apiKeyDO.getIsActive() == 1);
        return apiKeysPageVO;
    }
}
