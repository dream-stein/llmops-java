package com.emcikem.llm.web.controller;

import com.emcikem.llm.common.entity.BaseResponse;
import com.emcikem.llm.web.request.DialogEditNameRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create with Emcikem on 2025/1/19
 *
 * @author Emcikem
 * @version 1.0.0
 * 对话数据接口
 */
@RestController("/dialog")
public class ChatDialogController {

    /**
     * 对话列表页
     * @param tenant
     */
    @GetMapping("/list")
    public void list(String tenant) {

    }

    /**
     * 删除对话
     * @param dialogId
     * @param tenant
     */
    @PostMapping("/delete")
    public void delete(Long dialogId, String tenant) {

    }

    /**
     * 修改对话名称
     * @param request
     */
    @PostMapping("/editName")
    public BaseResponse<Void> editName(DialogEditNameRequest request) {
        return new BaseResponse<>();
    }

    /**
     * 创建新的对话
     */
    @PostMapping("/create")
    public void create() {

    }
}
