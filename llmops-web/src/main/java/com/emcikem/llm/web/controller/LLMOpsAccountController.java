package com.emcikem.llm.web.controller;

import com.emcikem.llm.common.entity.ApiResponse;
import com.emcikem.llm.common.vo.account.CurrentUserVO;
import com.emcikem.llm.common.vo.account.UpdateAvatarParam;
import com.emcikem.llm.common.vo.account.UpdateNameParam;
import com.emcikem.llm.common.vo.account.UpdatePasswordParam;
import com.google.protobuf.Api;
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

    @GetMapping()
    public ApiResponse<CurrentUserVO> getCurrent() {
        CurrentUserVO currentUserVO = new CurrentUserVO();
        currentUserVO.setAvatar("https://img1.baidu.com/it/u=416942531,3513038533&fm=253&fmt=auto&app=138&f=JPEG?w=376&h=342");
        currentUserVO.setEmail("2287698754@qq.com");
        currentUserVO.setCreated_at(System.currentTimeMillis());
        currentUserVO.setId("11");
        currentUserVO.setLast_login_ip("广东");
        currentUserVO.setLast_login_at(System.currentTimeMillis());
        currentUserVO.setName("Emcikem");

        return ApiResponse.success(currentUserVO);
    }

    @PostMapping("/password")
    public ApiResponse<Void> updatePassword(@RequestBody UpdatePasswordParam param) {
        return ApiResponse.success(null);
    }

    @PostMapping("/name")
    public ApiResponse<Void> updateName(@RequestBody UpdateNameParam param) {
        return ApiResponse.success(null);
    }

    @PostMapping("/avatar")
    public ApiResponse<Void> updateAvatar(@RequestBody UpdateAvatarParam param) {
        return ApiResponse.success(null);
    }
}
