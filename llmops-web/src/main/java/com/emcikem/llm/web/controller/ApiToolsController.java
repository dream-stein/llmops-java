package com.emcikem.llm.web.controller;

import com.emcikem.llm.common.entity.ApiResponse;
import com.emcikem.llm.common.util.GsonUtil;
import com.emcikem.llm.common.vo.apitools.ApiProviderListVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create with Emcikem on 2025/3/2
 *
 * @author Emcikem
 * @version 1.0.0
 */
@RestController
@RequestMapping("/api-tools")
public class ApiToolsController {

    @GetMapping()
    public ApiResponse<ApiProviderListVO> getAllApiTools(String search_word, Integer current_page, Integer page_size) {
        String str = "{\"list\":[{\"id\":\"46db30d1-3199-4e79-a0cd-abf12fa6858f\",\"name\":\"高德地图\",\"icon\":\"https://cdn.imooc.com/gaode.png\",\"description\":\"查询ip所在地、天气预报、路线规划等搞得工具包\",\"tools\":[{\"id\":\"d400cec0-892f-49ab-8f72-821b88c1aaa9\",\"description\":\"根据传递的城市名获取制定城市的天气预报、例如：广州\",\"name\":\"GetCurrentWeather\",\"inputs\":[{\"type\":\"str\",\"required\":true,\"name\":\"query\",\"description\":\"需要搜素的查询语句\"}]}],\"headers\":[{\"key\":\"Authorization\",\"value\":\"Bearer QQYnRerJTSEcrf889fw8prOaOberch8\"}],\"created_at\":1721460914}],\"paginator\":{\"current_page\":1,\"page_size\":21,\"total_page\":1,\"total_record\":2}}";
        ApiProviderListVO apiProviderListVO = GsonUtil.parseObject(str, ApiProviderListVO.class);
        return ApiResponse.success(apiProviderListVO);
    }

    @PostMapping()
    public void createApiTools() {

    }

    @PostMapping()
    public void updateApiTools() {

    }

    @GetMapping()
    public void getApiToolsDetail(String provider_id) {

    }

    @PostMapping("/validate-openapi-schema")
    public void validateOpenApiSchema() {

    }
}
