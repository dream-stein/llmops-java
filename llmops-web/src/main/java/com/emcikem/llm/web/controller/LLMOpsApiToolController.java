package com.emcikem.llm.web.controller;

import com.emcikem.llm.common.entity.ApiBasePaginatorResponse;
import com.emcikem.llm.common.entity.ApiResponse;
import com.emcikem.llm.common.entity.Paginator;
import com.emcikem.llm.common.util.GsonUtil;
import com.emcikem.llm.common.vo.tools.*;
import com.emcikem.llm.dao.entity.LlmOpsApiToolProviderDO;
import com.emcikem.llm.dao.example.LlmOpsApiToolProviderDOExample;
import com.emcikem.llm.dao.mapper.LlmOpsApiToolProviderDOMapper;
import com.emcikem.llm.service.service.apitool.LLMOpsApiToolService;
import com.google.common.collect.Lists;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Create with Emcikem on 2025/3/2
 *
 * @author Emcikem
 * @version 1.0.0
 * @description 插件
 */
@RestController
@RequestMapping("/api-tools")
public class LLMOpsApiToolController {

    @Resource
    private LlmOpsApiToolProviderDOMapper llmOpsApiToolProviderDOMapper;

    @Resource
    private LLMOpsApiToolService llmOpsApiToolService;

    @GetMapping("/list")
    public ApiBasePaginatorResponse<ApiToolVO> getApiToolProvidersWithPage(@RequestParam("search_word") String searchWord,
                                                                               @RequestParam("current_page") Integer currentPage,
                                                                               @RequestParam("page_size") Integer pageSize) {
        return llmOpsApiToolService.getApiToolProvidersWithPage(searchWord, currentPage, pageSize);
    }

    @PostMapping("/validate-openapi-schema")
    public ApiResponse<Void> validateOpenAPISchema(@RequestBody ApiValidateOpenApiSchemaVO schemaVO) {
        return ApiResponse.success(null);
    }

    @PostMapping("/create")
    public ApiResponse<Void> createApiToolProvider(@RequestBody CreateProviderDetailVO createProviderDetailVO) {
        LlmOpsApiToolProviderDO providerDO = new LlmOpsApiToolProviderDO();
        providerDO.setCreatedAt(new Date());
        providerDO.setIcon(createProviderDetailVO.getIcon());
        providerDO.setUpdatedAt(new Date());
        providerDO.setProviderId(UUID.randomUUID().toString());
//        providerDO.setOpenapiSchema(createProviderDetailVO.getOpenapi_schema());
        providerDO.setAccountId(UUID.randomUUID().toString());
//        providerDO.setHeaders(GsonUtil.toJSONString(createProviderDetailVO.getHeaders()));
//        providerDO.setDescription("");
        providerDO.setName(createProviderDetailVO.getName());
//        int insert = llmOpsApiToolProviderDOMapper.insert(providerDO);
        return ApiResponse.success(null);
    }

    @PostMapping("/update/{provider_id}")
    public ApiResponse<Void> updateApiToolProvider(@PathVariable String provider_id, @RequestBody UpdateProviderDetailVO updateProviderDetailVO) {
        LlmOpsApiToolProviderDO providerDO = new LlmOpsApiToolProviderDO();
        providerDO.setUpdatedAt(new Date());
//        providerDO.setOpenapiSchema(updateProviderDetailVO.getOpenapi_schema());
        providerDO.setIcon(updateProviderDetailVO.getIcon());
        providerDO.setName(updateProviderDetailVO.getName());
        providerDO.setProviderId(provider_id);
//        providerDO.setHeaders(GsonUtil.toJSONString(updateProviderDetailVO.getHeaders()));
        LlmOpsApiToolProviderDOExample example = new LlmOpsApiToolProviderDOExample();
        example.createCriteria().andProviderIdEqualTo(provider_id);
//        int i = llmOpsApiToolProviderDOMapper.updateByExampleSelective(providerDO, example);
        return ApiResponse.success(null);
    }

    @PostMapping("/{provider_id}/delete")
    public ApiResponse<Void> deleteApiToolProvider(@PathVariable String provider_id) {
        LlmOpsApiToolProviderDOExample example = new LlmOpsApiToolProviderDOExample();
        example.createCriteria().andProviderIdEqualTo(provider_id);
        int i = llmOpsApiToolProviderDOMapper.deleteByExample(example);
        return ApiResponse.success(null);
    }

    @PostMapping("/detail/{provider_id}")
    public ApiResponse<GetApiToolProviderVO> getApiToolProvider(@PathVariable String provider_id) {
        return ApiResponse.success(null);
    }

    @GetMapping("/{provider_id}/{tool_name}")
    public ApiResponse<GetApiToolVO> getApiTool(@PathVariable String provider_id, @PathVariable String tool_name) {
        return ApiResponse.success(null);
    }
}
