package com.emcikem.llm.common.vo.apps;

import com.emcikem.llm.common.vo.apps.config.EnableConfigVO;
import com.emcikem.llm.common.vo.apps.config.RetrievalConfigVO;
import com.emcikem.llm.common.vo.apps.config.ReviewConfigVO;
import lombok.Data;

import java.util.List;

/**
 * Create with Emcikem on 2025/4/8
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class UpdateDraftAppConfigParam {

//    private String model;

    private Integer dialog_round;

    private String preset_prompt;

//    private String tools;

    private List<String> workflows;

    private List<String> datasets;

    private RetrievalConfigVO retrieval_config;

    private EnableConfigVO long_term_memory;

    private String opening_statement;

    private List<String> opening_questions;

    private EnableConfigVO speech_to_text;

//    private EnableConfigVO text_to_speech;

    private EnableConfigVO suggested_after_answer;

    private ReviewConfigVO review_config;
}
