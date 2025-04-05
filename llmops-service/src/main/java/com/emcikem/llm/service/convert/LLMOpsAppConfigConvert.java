package com.emcikem.llm.service.convert;

import com.emcikem.llm.common.util.GsonUtil;
import com.emcikem.llm.common.vo.apps.DraftAppConfigVO;
import com.emcikem.llm.common.vo.apps.config.*;
import com.emcikem.llm.dao.entity.LlmOpsAppConfigDO;

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
//        draftAppConfigVO.setDatasets(GsonUtil.parseList(appConfigDO.get));
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
    }
}
