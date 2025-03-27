package com.emcikem.llm.web.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.emcikem.llm.common.entity.ApiResponse;
import com.emcikem.llm.common.util.GsonUtil;
import com.emcikem.llm.common.vo.apitools.*;
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
    public ApiResponse<ApiProviderListVO> getAllApiTools(String search_word, Integer current_page, Integer page_size) {
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

        ApiProviderListVO apiProviderListVO = new ApiProviderListVO();
        apiProviderListVO.setPaginator(paginator);
        apiProviderListVO.setList(apiProviderList);
        return ApiResponse.success(apiProviderListVO);
    }

    @PostMapping("/create")
    public ApiResponse<Void> createApiTools(@RequestBody CreateProviderDetailVO createProviderDetailVO) {
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
    public ApiResponse<Void> updateApiTools(@PathVariable String provider_id, @RequestBody UpdateProviderDetailVO updateProviderDetailVO) {
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

    @GetMapping("/detail/{provider_id}")
    public ApiResponse<ApiToolsDetailVO> getApiToolsDetail(@PathVariable String provider_id) {
        LlmOpsApiToolProviderDOExample example = new LlmOpsApiToolProviderDOExample();
        example.createCriteria().andProviderIdEqualTo(provider_id);
        List<LlmOpsApiToolProviderDO> opsApiToolProviderList = llmOpsApiToolProviderDOMapper.selectByExample(example);
        if (CollectionUtil.isEmpty(opsApiToolProviderList)) {
            return ApiResponse.success(null);
        }
        LlmOpsApiToolProviderDO providerDO = opsApiToolProviderList.get(0);
        ApiToolsDetailVO apiToolsDetailVO = new ApiToolsDetailVO();
        apiToolsDetailVO.setHeaders(GsonUtil.parseList(providerDO.getHeaders(), ApiToolHeaderVO.class));
        apiToolsDetailVO.setName(providerDO.getName());
        apiToolsDetailVO.setIcon(providerDO.getIcon());
        apiToolsDetailVO.setCreated_at(providerDO.getCreatedAt().getTime());
        apiToolsDetailVO.setOpenapi_schema(providerDO.getOpenapiSchema());

//        String str = "{\"id\":\"46db3xd1-3199-4e79-a0cd-abf12fa6858f\",\"name\":\"高德工具包\",\"icon\":\"https://www.99it.com.cn/uploads/allimg/220622/114A52915-0.jpg\",\"openapi_schema\":null,\"headers\":[{\"key\":\"Authorization\",\"value\":\"Bearer QQYnRFerJTSEcrfB89fw8proaObmrch8\"}],\"created_at\":1721460914}";
//        String schema = "{\"description\":\"这是一个查询对应英文单词字典的工具\",\"server\":\"https://dict.youdao.com\",\"paths\":{\"/suggest\":{\"get\":{\"description\":\"根据传递的单词查询其字典信息\",\"operationId\":\"youdaoSuggest\",\"parameters\":[{\"name\":\"q\",\"in\":\"query\",\"description\":\"要检索查询的单词，例如love/computer\",\"required\":true,\"type\":\"str\"},{\"name\":\"doctype\",\"in\":\"query\",\"description\":\"返回的数据类型，支持json和xml两种格式，默认情况下json数据\",\"required\":false,\"type\":\"str\"}]}}}";
//        apiToolsDetailVO.setOpenapi_schema(schema);
        return ApiResponse.success(apiToolsDetailVO);
    }

    @PostMapping("/validate-openapi-schema")
    public ApiResponse<Void> validateOpenApiSchema(@RequestBody ApiValidateOpenApiSchemaVO schemaVO) {
        return ApiResponse.success(null);
    }

    @PostMapping("/{provider_id}/delete")
    public ApiResponse<Void> delete(@PathVariable String provider_id) {
        LlmOpsApiToolProviderDOExample example = new LlmOpsApiToolProviderDOExample();
        example.createCriteria().andProviderIdEqualTo(provider_id);
        int i = llmOpsApiToolProviderDOMapper.deleteByExample(example);
        return ApiResponse.success(null);
    }
}
