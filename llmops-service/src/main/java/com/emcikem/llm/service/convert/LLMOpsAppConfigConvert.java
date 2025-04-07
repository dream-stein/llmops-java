package com.emcikem.llm.service.convert;

import com.emcikem.llm.common.util.GsonUtil;
import com.emcikem.llm.common.vo.apps.DraftAppConfigVO;
import com.emcikem.llm.common.vo.apps.config.*;
import com.emcikem.llm.dao.entity.LlmOpsAppConfigDO;
import org.apache.commons.compress.utils.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * Create with Emcikem on 2025/4/5
 *
 * @author Emcikem
 * @version 1.0.0
 */
public class LLMOpsAppConfigConvert {

    public static DraftAppConfigVO convertAppConfig(LlmOpsAppConfigDO appConfigDO) {
        if (appConfigDO == null) {
            return null;
        }
        DraftAppConfigVO draftAppConfigVO = new DraftAppConfigVO();
        draftAppConfigVO.setId(appConfigDO.getId());
        draftAppConfigVO.setDialog_round(appConfigDO.getDialogRound());
        draftAppConfigVO.setPreset_prompt(appConfigDO.getPresetPrompt());
        draftAppConfigVO.setUpdated_at(appConfigDO.getUpdatedAt().getTime());
        draftAppConfigVO.setCreated_at(appConfigDO.getCreatedAt().getTime());
        draftAppConfigVO.setOpening_statement(appConfigDO.getOpeningStatement());
        draftAppConfigVO.setOpening_questions(GsonUtil.parseList(appConfigDO.getOpeningQuestions(), String.class));
        draftAppConfigVO.setRetrieval_config(GsonUtil.parseObject(appConfigDO.getRetrievalConfig(), RetrievalConfigVO.class));
        draftAppConfigVO.setReview_config(GsonUtil.parseObject(appConfigDO.getReviewConfig(), ReviewConfigVO.class));
        draftAppConfigVO.setLong_term_memory(GsonUtil.parseObject(appConfigDO.getLongTermMemory(), EnableConfigVO.class));
        draftAppConfigVO.setSuggested_after_answer(GsonUtil.parseObject(appConfigDO.getSuggestedAfterAnswer(), EnableConfigVO.class));
        draftAppConfigVO.setDatasets(Lists.newArrayList());
        draftAppConfigVO.setWorkflows(GsonUtil.parseList(appConfigDO.getWorkflows(), WorkflowConfigVO.class));
        draftAppConfigVO.setTools(GsonUtil.parseList(appConfigDO.getTools(), ToolsConfigVO.class));
        return draftAppConfigVO;
    }

    public static void main(String[] args) {
        RetrievalConfigVO retrievalConfigVO = new RetrievalConfigVO();
        retrievalConfigVO.setK(5);
        retrievalConfigVO.setScore(0.05f);
        retrievalConfigVO.setRetrieval_strategy("full_text");
        System.out.println(GsonUtil.toJSONString(retrievalConfigVO));

        ReviewConfigVO reviewConfigVO = new ReviewConfigVO();
        reviewConfigVO.setEnable(true);
        reviewConfigVO.setKeywords(List.of("关键词1", "关键词2"));
        OutputsConfigVO outputsConfigVO = new OutputsConfigVO();
        outputsConfigVO.setEnable(true);
        reviewConfigVO.setOutputs_config(outputsConfigVO);
        InputsConfigVO inputsConfigVO = new InputsConfigVO();
        inputsConfigVO.setEnable(true);
        inputsConfigVO.setPreset_response("我是预设回复");
        reviewConfigVO.setInputs_config(inputsConfigVO);
        System.out.println(GsonUtil.toJSONString(reviewConfigVO));

        EnableConfigVO enableConfigVO = new EnableConfigVO();
        enableConfigVO.setEnable(true);
        System.out.println(GsonUtil.toJSONString(enableConfigVO));

        WorkflowConfigVO workflowConfigVO = new WorkflowConfigVO();
        workflowConfigVO.setId("2122112");
        workflowConfigVO.setName("小红书文案生成");
        workflowConfigVO.setIcon("https://www.yimiaotui.com/d/image/20230427/98ed757ec1b322e69fb9e5afcfb275c2.jpg");
        workflowConfigVO.setDescription("这是一个可以根据特定主体生成小红书文案的工作流，传递对应的query即可。");
        List<WorkflowConfigVO> workflowConfigVOList = new ArrayList<>();
        workflowConfigVOList.add(workflowConfigVO);
        System.out.println(GsonUtil.toJSONString(workflowConfigVOList));

        ToolsConfigVO toolsConfigVO = new ToolsConfigVO();
        toolsConfigVO.setType("api_tool");
        ToolsProviderConfigVO providerConfigVO = new ToolsProviderConfigVO();
        providerConfigVO.setId("12121");
        providerConfigVO.setName("谷歌");
        providerConfigVO.setLabel("谷歌");
        providerConfigVO.setIcon("https://q2.itc.cn/q_70/images03/20240329/84cca9641e9444e5b3fe9256f095da6b.png");
        providerConfigVO.setDescription("我是谷歌的介绍");
        toolsConfigVO.setProvider(providerConfigVO);
        ToolsToolConfigVO toolsToolConfigVO = new ToolsToolConfigVO();
        toolsToolConfigVO.setId("211122");
        toolsToolConfigVO.setName("2121212");
        toolsToolConfigVO.setLabel("2121212");
        toolsToolConfigVO.setDescription("我是工具介绍");
        toolsConfigVO.setTool(toolsToolConfigVO);
        List<ToolsConfigVO> toolsConfigVOList = new ArrayList<>();
        toolsConfigVOList.add(toolsConfigVO);
        System.out.println(GsonUtil.toJSONString(toolsConfigVOList));
    }
}
