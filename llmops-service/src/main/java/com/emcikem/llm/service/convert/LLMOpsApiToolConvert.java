package com.emcikem.llm.service.convert;

import com.emcikem.llm.common.vo.tools.ApiProviderToolVO;
import com.emcikem.llm.common.vo.tools.ApiToolHeaderVO;
import com.emcikem.llm.common.vo.tools.ApiToolInputVO;
import com.emcikem.llm.common.vo.tools.ApiToolProviderVO;
import com.emcikem.llm.dao.entity.LlmOpsApiToolDO;
import com.emcikem.llm.dao.entity.LlmOpsApiToolProviderDO;
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

    public static List<ApiToolProviderVO> convert2ApiProviderList(List<LlmOpsApiToolProviderDO> apiToolList) {
        if (CollectionUtils.isEmpty(apiToolList)) {
            return Lists.newArrayList();
        }
        return apiToolList.stream().map(LLMOpsApiToolConvert::convert2ApiProvider).filter(Objects::nonNull).collect(Collectors.toList());
    }

    public static ApiToolProviderVO convert2ApiProvider(LlmOpsApiToolProviderDO apiToolProviderDO) {
        if (apiToolProviderDO == null) {
            return null;
        }
        ApiToolProviderVO apiToolProviderVO = new ApiToolProviderVO();
        apiToolProviderVO.setId(apiToolProviderDO.getId());
        apiToolProviderVO.setName(apiToolProviderDO.getName());
        apiToolProviderVO.setIcon(apiToolProviderDO.getIcon());
        apiToolProviderVO.setCreated_at(apiToolProviderDO.getCreatedAt().getTime());
        apiToolProviderVO.setDescription("测试描述");
        ApiToolHeaderVO apiToolHeaderVO = new ApiToolHeaderVO();
        apiToolHeaderVO.setKey("a");
        apiToolHeaderVO.setValue("b");;

        ApiProviderToolVO apiProviderToolVO1 = new ApiProviderToolVO();
        apiProviderToolVO1.setId("2121");
        apiProviderToolVO1.setName("谷歌Serper搜索");
        apiProviderToolVO1.setDescription("一个用于执行Google SERP搜索并提取片段和网页的工具。输入应该是一个搜索查询。\n");
        ApiToolInputVO apiToolInputVO = new ApiToolInputVO();
        apiToolInputVO.setType("string");
        apiToolInputVO.setRequired(true);
        apiToolInputVO.setName("提示词");
        apiToolInputVO.setDescription("图像提示词，您可以查看 DallE 3 的官方文档");
        apiProviderToolVO1.setInputs(Lists.newArrayList(apiToolInputVO));

        ApiProviderToolVO apiProviderToolVO2 = new ApiProviderToolVO();
        apiProviderToolVO2.setId("2121");
        apiProviderToolVO2.setName("谷歌新闻");
        apiProviderToolVO2.setDescription("谷新闻搜索引擎可以帮助你按关键字搜索新闻。");
        apiProviderToolVO2.setInputs(Lists.newArrayList());

        apiToolProviderVO.setTools(Lists.newArrayList(apiProviderToolVO1, apiProviderToolVO2));
        apiToolProviderVO.setHeaders(Lists.newArrayList(apiToolHeaderVO));
        return apiToolProviderVO;
    }
}
