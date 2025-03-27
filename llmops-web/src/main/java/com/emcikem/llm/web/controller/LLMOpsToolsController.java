package com.emcikem.llm.web.controller;

import com.emcikem.llm.common.entity.ApiBasePaginatorResponse;
import com.emcikem.llm.common.entity.ApiResponse;
import com.emcikem.llm.common.entity.Paginator;
import com.emcikem.llm.common.util.GsonUtil;
import com.emcikem.llm.common.vo.tools.*;
import com.emcikem.llm.dao.entity.LlmOpsApiToolProviderDO;
import com.emcikem.llm.dao.example.LlmOpsApiToolProviderDOExample;
import com.emcikem.llm.dao.mapper.LlmOpsApiToolProviderDOMapper;
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
public class LLMOpsToolsController {

    @Resource
    private LlmOpsApiToolProviderDOMapper llmOpsApiToolProviderDOMapper;

    @GetMapping("/list")
    public ApiBasePaginatorResponse<ApiProviderVO> getApiToolProvidersWithPage(String search_word, Integer current_page, Integer page_size) {
        LlmOpsApiToolProviderDOExample example = new LlmOpsApiToolProviderDOExample();
        example.setOffset(current_page - 1);
        example.setRows(page_size);
        if (StringUtils.isNoneEmpty(search_word)) {
            example.createCriteria().andNameLike("%" + search_word + "%");
        }
        List<LlmOpsApiToolProviderDO> opsApiToolProviderList = llmOpsApiToolProviderDOMapper.selectByExample(example);
        long count = llmOpsApiToolProviderDOMapper.countByExample(example);

        Paginator paginator = new Paginator();
        paginator.setCurrent_page(current_page);
        paginator.setPage_size(page_size);
        paginator.setTotal_page((int) ((count + page_size - 1) / page_size));
        paginator.setTotal_record((int) (count));

        List<ApiProviderVO> apiProviderList = opsApiToolProviderList.stream().map(llmOpsApiToolProviderDO -> {
            ApiProviderVO apiProviderVO = new ApiProviderVO();
            apiProviderVO.setDescription(llmOpsApiToolProviderDO.getDescription());
            apiProviderVO.setIcon(llmOpsApiToolProviderDO.getIcon());
            apiProviderVO.setId(llmOpsApiToolProviderDO.getProviderId());
            apiProviderVO.setHeaders(GsonUtil.parseList(llmOpsApiToolProviderDO.getHeaders(), ApiToolHeaderVO.class));
            apiProviderVO.setTools(Lists.newArrayList());
            apiProviderVO.setName(llmOpsApiToolProviderDO.getName());
            apiProviderVO.setCreated_at(llmOpsApiToolProviderDO.getCreatedAt().getTime());
            return apiProviderVO;
        }).collect(Collectors.toList());
        return ApiBasePaginatorResponse.success(apiProviderList, paginator);
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
        providerDO.setOpenapiSchema(createProviderDetailVO.getOpenapi_schema());
        providerDO.setAccountId(UUID.randomUUID().toString());
        providerDO.setHeaders(GsonUtil.toJSONString(createProviderDetailVO.getHeaders()));
        providerDO.setDescription("");
        providerDO.setName(createProviderDetailVO.getName());
        int insert = llmOpsApiToolProviderDOMapper.insert(providerDO);
        return ApiResponse.success(null);
    }

    @PostMapping("/update/{provider_id}")
    public ApiResponse<Void> updateApiToolProvider(@PathVariable String provider_id, @RequestBody UpdateProviderDetailVO updateProviderDetailVO) {
        LlmOpsApiToolProviderDO providerDO = new LlmOpsApiToolProviderDO();
        providerDO.setUpdatedAt(new Date());
        providerDO.setOpenapiSchema(updateProviderDetailVO.getOpenapi_schema());
        providerDO.setIcon(updateProviderDetailVO.getIcon());
        providerDO.setName(updateProviderDetailVO.getName());
        providerDO.setProviderId(provider_id);
        providerDO.setHeaders(GsonUtil.toJSONString(updateProviderDetailVO.getHeaders()));
        LlmOpsApiToolProviderDOExample example = new LlmOpsApiToolProviderDOExample();
        example.createCriteria().andProviderIdEqualTo(provider_id);
        int i = llmOpsApiToolProviderDOMapper.updateByExampleSelective(providerDO, example);
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
