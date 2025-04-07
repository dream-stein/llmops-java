package com.emcikem.llm.service.service.app;

import com.emcikem.llm.common.entity.ApiBasePaginatorResponse;
import com.emcikem.llm.common.entity.Paginator;
import com.emcikem.llm.common.util.GsonUtil;
import com.emcikem.llm.common.vo.apps.*;
import com.emcikem.llm.dao.entity.LlmOpsAppConfigDO;
import com.emcikem.llm.dao.entity.LlmOpsAppDO;
import com.emcikem.llm.dao.entity.LlmOpsConversationDO;
import com.emcikem.llm.service.convert.LLMOpsAppConfigConvert;
import com.emcikem.llm.service.convert.LLMOpsAppConvert;
import com.emcikem.llm.service.provider.LLMOpsAppConfigProvider;
import com.emcikem.llm.service.provider.LLMOpsAppProvider;
import com.emcikem.llm.service.provider.LLMOpsConversationProvider;
import jakarta.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Create with Emcikem on 2025/3/28
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Service
public class LLMOpsAppService {

    @Resource
    private LLMOpsAppProvider llmOpsAppProvider;

    @Resource
    private LLMOpsConversationProvider llmOpsConversationProvider;

    @Resource
    private LLMOpsAppConfigProvider llmOpsAppConfigProvider;

    public ApiBasePaginatorResponse<AppVO> getDatasetsWithPage(String searchWord, Integer currentPage, Integer pageSize) {
        // 1. 查询当前账号
        String accountId = getAccountId();

        // 2. 数据查询
        Long count = llmOpsAppProvider.countAppList(accountId, searchWord);
        Integer offset = (currentPage - 1) * pageSize;
        List<LlmOpsAppDO> appList = llmOpsAppProvider.getAppList(pageSize, offset, accountId, searchWord);

        Paginator paginator = new Paginator();
        paginator.setCurrent_page(currentPage);
        paginator.setPage_size(pageSize);
        paginator.setTotal_record(count);
        paginator.setTotal_page((int) ((count + pageSize - 1) / pageSize));

        return ApiBasePaginatorResponse.success(LLMOpsAppConvert.convert(appList), paginator);

    }

    public AppDetailVO getApp(String appId) {
        // 1. 查询当前账号
        String accountId = getAccountId();

        // 2. 查询数据
        LlmOpsAppDO llmOpsAppDO = llmOpsAppProvider.getApp(appId, accountId);

        return LLMOpsAppConvert.convert2DetailVO(llmOpsAppDO);
    }

    public void deleteApp(String appId) {
        // 1. 查询当前账号
        String accountId = getAccountId();

        // 2. 删除数据
        llmOpsAppProvider.deleteApp(accountId, appId);
    }

    public void updateApp(String appId, UpdateAppParam updateAppParam) {
        // 1. 查询当前账号
        String accountId = getAccountId();
        LlmOpsAppDO llmOpsAppDO = new LlmOpsAppDO();
        llmOpsAppDO.setUpdatedAt(new Date());
        llmOpsAppDO.setName(updateAppParam.getName());
        llmOpsAppDO.setDescription(updateAppParam.getDescription());
        llmOpsAppDO.setIcon(updateAppParam.getIcon());

        llmOpsAppProvider.updateApp(accountId, appId, llmOpsAppDO);
    }

    public CreateAppVO createApp(CreateAppParam createAppParam) {
        // 1. 查询当前账号
        String accountId = getAccountId();

        LlmOpsAppDO llmOpsAppDO = new LlmOpsAppDO();
        llmOpsAppDO.setCreatedAt(new Date());
        llmOpsAppDO.setUpdatedAt(new Date());
        llmOpsAppDO.setId(UUID.randomUUID().toString());
        llmOpsAppDO.setDraftedAppConfigId(null);
        llmOpsAppDO.setPublishedAppConfigId(null);
        llmOpsAppDO.setIcon(createAppParam.getIcon());
        llmOpsAppDO.setName(createAppParam.getName());
        llmOpsAppDO.setDescription(createAppParam.getDescription());
        llmOpsAppDO.setAccountId(accountId);
        llmOpsAppDO.setStatus("draft");
        llmOpsAppProvider.createApp(llmOpsAppDO);

        CreateAppVO createAppVO = new CreateAppVO();
        createAppVO.setId(llmOpsAppDO.getId());
        return createAppVO;
    }

    public ApiBasePaginatorResponse<DebugConversationMessagesVO> getDebugConversationMessagesWithPage(String appId, Integer currentPage, Integer pageSize, Long createdAt) {


        return null;
    }

    public DebugConversationSummaryVO getDebugConversationSummary(String appId) {
        LlmOpsConversationDO llmOpsConversationDO = llmOpsConversationProvider.getConversation(appId);

        DebugConversationSummaryVO summaryVO = new DebugConversationSummaryVO();
        if (llmOpsConversationDO == null) {
            summaryVO.setSummary("");
            return summaryVO;
        }
        summaryVO.setSummary(llmOpsConversationDO.getSummary());
        return summaryVO;
    }

    public void updateDebugConversationSummary(String appId, UpdateDebugConversationSummaryParam param) {
        LlmOpsConversationDO llmOpsConversationDO = new LlmOpsConversationDO();
        llmOpsConversationDO.setSummary(param.getSummary());
        llmOpsConversationDO.setUpdatedAt(new Date());

        boolean result = llmOpsConversationProvider.updateConversation(appId, llmOpsConversationDO);
    }

    public DraftAppConfigVO getDraftAppConfig(String appId) {
        LlmOpsAppConfigDO appConfigDO = llmOpsAppConfigProvider.getDraftAppConfig(appId);
        return LLMOpsAppConfigConvert.convertAppConfig(appConfigDO);
    }

    public void updateDraftAppConfig(String appId, UpdateDraftAppConfigParam param) {
        LlmOpsAppConfigDO appConfigDO = new LlmOpsAppConfigDO();
        appConfigDO.setUpdatedAt(new Date());
        appConfigDO.setDialogRound(param.getDialog_round());
        appConfigDO.setOpeningStatement(param.getOpening_statement());
        appConfigDO.setPresetPrompt(param.getPreset_prompt());
        if (CollectionUtils.isNotEmpty(param.getOpening_questions())) {
            appConfigDO.setOpeningQuestions(GsonUtil.toJSONString(param.getOpening_questions()));
        }
        if (param.getRetrieval_config() != null) {
            appConfigDO.setRetrievalConfig(GsonUtil.toJSONString(param.getRetrieval_config()));
        }
        if (param.getLong_term_memory() != null) {
            appConfigDO.setLongTermMemory(GsonUtil.toJSONString(param.getLong_term_memory()));
        }
        if (param.getReview_config() != null) {
            appConfigDO.setReviewConfig(GsonUtil.toJSONString(param.getReview_config()));
        }
        if (param.getSuggested_after_answer() != null) {
            appConfigDO.setSuggestedAfterAnswer(GsonUtil.toJSONString(param.getSuggested_after_answer()));
        }
        boolean result = llmOpsAppConfigProvider.updateDraftAppConfig(appId, appConfigDO);
    }

    private String getAccountId() {
        return "1";
    }
}
