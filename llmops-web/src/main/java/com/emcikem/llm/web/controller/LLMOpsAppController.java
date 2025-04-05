package com.emcikem.llm.web.controller;

import com.emcikem.llm.common.entity.ApiBasePaginatorResponse;
import com.emcikem.llm.common.entity.ApiResponse;
import com.emcikem.llm.common.vo.apps.*;
import com.emcikem.llm.service.service.app.LLMOpsAppService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * Create with Emcikem on 2025/3/28
 *
 * @author Emcikem
 * @version 1.0.0
 */
@RestController
@RequestMapping("/apps")
public class LLMOpsAppController {

    @Resource
    private LLMOpsAppService llmOpsAppService;

    @GetMapping
    public ApiBasePaginatorResponse<AppVO> getDatasetsWithPage(@RequestParam(value = "search_word", required = false) String searchWord,
                                                               @RequestParam("current_page") Integer currentPage,
                                                               @RequestParam("page_size") Integer pageSize) {
        return llmOpsAppService.getDatasetsWithPage(searchWord, currentPage, pageSize);
    }

    @GetMapping("/{app_id}")
    public ApiResponse<AppDetailVO> getApp(@PathVariable("app_id") String appId) {
        return ApiResponse.success(llmOpsAppService.getApp(appId));
    }

    @PostMapping("/{app_id}/delete")
    public ApiResponse<Void> deleteApp(@PathVariable("app_id") String appId) {
        llmOpsAppService.deleteApp(appId);
        return ApiResponse.success(null);
    }

    @PostMapping("/{app_id}")
    public ApiResponse<Void> updateApp(@PathVariable("app_id") String appId,
                                       @RequestBody UpdateAppParam updateAppParam) {
        llmOpsAppService.updateApp(appId, updateAppParam);
        return ApiResponse.success(null);
    }

    @PostMapping
    public ApiResponse<CreateAppVO> createApp(@RequestBody CreateAppParam createAppParam) {
        return ApiResponse.success(llmOpsAppService.createApp(createAppParam));
    }

    @GetMapping("/{app_id}/conversations/messages/{}")
    public ApiBasePaginatorResponse<DebugConversationMessagesVO> getDebugConversationMessagesWithPage(@PathVariable("app_id") String appId,
                                                                           @RequestParam("current_page") Integer currentPage,
                                                                           @RequestParam("page_size") Integer pageSize,
                                                                           @RequestParam("created_at") Long createdAt) {
        return llmOpsAppService.getDebugConversationMessagesWithPage(appId, currentPage, pageSize, createdAt);
    }

    /**
     * 获取应用中的概要
     * @param appId
     * @return
     */
    @GetMapping("/{app_id}/summary")
    public ApiResponse<DebugConversationSummaryVO> getDebugConversationSummary(@PathVariable("app_id") String appId) {
        return ApiResponse.success(llmOpsAppService.getDebugConversationSummary(appId));
    }

    /**
     * 更新概要
     * @param appId
     * @param param
     * @return
     */
    @PostMapping("/{app_id}/summary")
    public ApiResponse<Void> updateDebugConversationSummary(@PathVariable("app_id") String appId,
                                                            @RequestBody UpdateDebugConversationSummaryParam param) {
        llmOpsAppService.updateDebugConversationSummary(appId, param);
        return ApiResponse.success(null);
    }


}
