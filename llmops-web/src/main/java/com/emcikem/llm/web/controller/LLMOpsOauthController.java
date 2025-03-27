package com.emcikem.llm.web.controller;

import com.emcikem.llm.common.entity.ApiResponse;
import com.emcikem.llm.common.vo.oauth.AuthorizeParam;
import com.emcikem.llm.common.vo.oauth.AuthorizeVO;
import com.emcikem.llm.common.vo.oauth.ProviderVO;
import org.springframework.web.bind.annotation.*;

/**
 * Create with Emcikem on 2025/3/28
 *
 * @author Emcikem
 * @version 1.0.0
 */
@RestController
@RequestMapping("/oauth")
public class LLMOpsOauthController {

    @GetMapping("/{provider_name}")
    public ApiResponse<ProviderVO> provider(@PathVariable String provider_name) {
        ProviderVO providerVO = new ProviderVO();
        providerVO.setRedirect_url("https://" + provider_name);
        return ApiResponse.success(providerVO);
    }

    @PostMapping("/authorize/{provider_name}")
    public ApiResponse<AuthorizeVO> authorize(@PathVariable String provider_name, @RequestBody AuthorizeParam param) {
        AuthorizeVO authorizeVO = new AuthorizeVO();
        authorizeVO.setAccess_token("access_token");
        authorizeVO.setExpire_at(System.currentTimeMillis());
        return ApiResponse.success(authorizeVO);
    }
}
