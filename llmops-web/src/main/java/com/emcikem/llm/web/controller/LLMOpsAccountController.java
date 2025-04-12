package com.emcikem.llm.web.controller;

import com.emcikem.llm.common.entity.ApiResponse;
import com.emcikem.llm.common.vo.account.CurrentUserVO;
import com.emcikem.llm.common.vo.account.UpdateAvatarParam;
import com.emcikem.llm.common.vo.account.UpdateNameParam;
import com.emcikem.llm.common.vo.account.UpdatePasswordParam;
import com.emcikem.llm.service.service.account.LLMOpsAccountService;
import com.google.protobuf.Api;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * Create with Emcikem on 2025/3/27
 *
 * @author Emcikem
 * @version 1.0.0
 */
@RestController
@RequestMapping("/account")
public class LLMOpsAccountController {

    @Resource
    private LLMOpsAccountService llmOpsAccountService;

    @GetMapping
    public ApiResponse<CurrentUserVO> getCurrent() {
        return ApiResponse.success(llmOpsAccountService.getCurrent());
    }

    @PostMapping("/password")
    public ApiResponse<Void> updatePassword(@RequestBody UpdatePasswordParam param) {
        llmOpsAccountService.updatePassword(param);
        return ApiResponse.success(null);
    }

    @PostMapping("/name")
    public ApiResponse<Void> updateName(@RequestBody UpdateNameParam param) {
        llmOpsAccountService.updateName(param);
        return ApiResponse.success(null);
    }

    @PostMapping("/avatar")
    public ApiResponse<Void> updateAvatar(@RequestBody UpdateAvatarParam param) {
        llmOpsAccountService.updateAvatar(param);
        return ApiResponse.success(null);
    }
}
