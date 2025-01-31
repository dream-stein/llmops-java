package com.emcikem.llm.web.controller;

import com.emcikem.llm.common.entity.ApiResponse;
import com.emcikem.llm.common.enums.ResponseStatusEnum;
import com.emcikem.llm.common.vo.ChatDialogVO;
import com.emcikem.llm.service.service.ChatDialogService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Create with Emcikem on 2025/1/19
 *
 * @author Emcikem
 * @version 1.0.0
 * 对话数据接口
 */
@RestController
@RequestMapping("/dialog")
@Slf4j
public class ChatDialogController {

    @Resource
    private ChatDialogService chatDialogService;

    /**
     * 对话列表页
     * @param tenantId
     */
    @GetMapping("/list")
    public ApiResponse<List<ChatDialogVO>> list(Long tenantId) {
        try {
            List<ChatDialogVO> chatDialogList = chatDialogService.queryDialogList(tenantId);
            return ApiResponse.success(chatDialogList);
        } catch (Exception ex) {
            log.error("ChatDialogController list Failed, req:{}", tenantId, ex);
            return ApiResponse.error(ResponseStatusEnum.SYSTEM_ERROR);
        }
    }

    /**
     * 删除对话
     * @param dialogId
     * @param tenantId
     */
    @PostMapping("/delete")
    public void delete(Long dialogId, Long tenantId) {

    }

    /**
     * 修改对话名称
     * @param request
     */
    @PostMapping("/editName")
    public ApiResponse<Void> editName(ChatDialogVO request) {
        return new ApiResponse<>();
    }

    /**
     * 创建新的对话
     */
    @PostMapping("/create")
    public void create() {

    }
}
