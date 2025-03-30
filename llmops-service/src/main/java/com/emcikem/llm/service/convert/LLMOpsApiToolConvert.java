package com.emcikem.llm.service.convert;

import com.emcikem.llm.common.vo.tools.ApiToolVO;
import com.emcikem.llm.dao.entity.LlmOpsApiToolDO;
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
public class LLMOpsApiToolConvert {

    public static List<ApiToolVO> convert(List<LlmOpsApiToolDO> apiToolList) {
        if (CollectionUtils.isEmpty(apiToolList)) {
            return Lists.newArrayList();
        }
        return apiToolList.stream().map(LLMOpsApiToolConvert::convert).filter(Objects::nonNull).collect(Collectors.toList());
    }

    public static ApiToolVO convert(LlmOpsApiToolDO apiToolDO) {
        if (apiToolDO == null) {
            return null;
        }
        ApiToolVO apiToolVO = new ApiToolVO();
        apiToolVO.setId(apiToolDO.getId());
        apiToolVO.setName(apiToolDO.getName());
        apiToolVO.setIcon(apiToolDO.getUrl());
        apiToolVO.setCreated_at(apiToolDO.getCreatedAt().getTime());
        apiToolVO.setDescription("测试描述");
        apiToolVO.setTools(Lists.newArrayList());
        apiToolVO.setHeaders(Lists.newArrayList());
        return apiToolVO;
    }
}
