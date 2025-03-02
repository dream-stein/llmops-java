package com.emcikem.llm.web.controller;

import com.emcikem.llm.common.entity.ApiResponse;
import com.emcikem.llm.common.util.GsonUtil;
import com.emcikem.llm.common.vo.apitools.ApiProviderListVO;
import com.emcikem.llm.common.vo.apitools.ApiToolsDetailVO;
import com.emcikem.llm.common.vo.apitools.ApiValidateOpenApiSchemaVO;
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

    @GetMapping("/list")
    public ApiResponse<ApiProviderListVO> getAllApiTools(String search_word, Integer current_page, Integer page_size) {
        String str = "{\"list\":[{\"id\":\"46db30d1-3199-4e79-a0cd-abf12fa6858f\",\"name\":\"高德地图\",\"icon\":\"https://www.99it.com.cn/uploads/allimg/220622/114A52915-0.jpg\",\"description\":\"查询ip所在地、天气预报、路线规划等搞得工具包\",\"tools\":[{\"id\":\"d400cec0-892f-49ab-8f72-821b88c1aaa9\",\"description\":\"根据传递的城市名获取制定城市的天气预报、例如：广州\",\"name\":\"GetCurrentWeather\",\"inputs\":[{\"type\":\"str\",\"required\":true,\"name\":\"query\",\"description\":\"需要搜素的查询语句\"}]}],\"headers\":[{\"key\":\"Authorization\",\"value\":\"Bearer QQYnRerJTSEcrf889fw8prOaOberch8\"}],\"created_at\":1721460914}],\"paginator\":{\"current_page\":1,\"page_size\":21,\"total_page\":1,\"total_record\":2}}";
        ApiProviderListVO apiProviderListVO = GsonUtil.parseObject(str, ApiProviderListVO.class);
        return ApiResponse.success(apiProviderListVO);
    }

    @PostMapping("/create")
    public void createApiTools() {

    }

    @PostMapping("/update")
    public void updateApiTools() {

    }

    @GetMapping("/detail/{provider_id}")
    public ApiResponse<ApiToolsDetailVO> getApiToolsDetail() {
        String str = "{\"id\":\"46db3xd1-3199-4e79-a0cd-abf12fa6858f\",\"name\":\"高德工具包\",\"icon\":\"https://cdn.imoooc.com/google.png\",\"openapi_schema\":null,\"headers\":[{\"key\":\"Authorization\",\"value\":\"Bearer QQYnRFerJTSEcrfB89fw8proaObmrch8\"}],\"created_at\":1721460914}";
        ApiToolsDetailVO apiToolsDetailVO = GsonUtil.parseObject(str, ApiToolsDetailVO.class);
        String schema = "{\"description\":\"这是一个查询对应英文单词字典的工具\",\"server\":\"https://dict.youdao.com\",\"paths\":{\"/suggest\":{\"get\":{\"description\":\"根据传递的单词查询其字典信息\",\"operationId\":\"youdaoSuggest\",\"parameters\":[{\"name\":\"q\",\"in\":\"query\",\"description\":\"要检索查询的单词，例如love/computer\",\"required\":true,\"type\":\"str\"},{\"name\":\"doctype\",\"in\":\"query\",\"description\":\"返回的数据类型，支持json和xml两种格式，默认情况下json数据\",\"required\":false,\"type\":\"str\"}]}}}";
        apiToolsDetailVO.setOpenapi_schema(schema);
        return ApiResponse.success(apiToolsDetailVO);
    }

    @PostMapping("/validate-openapi-schema")
    public ApiResponse<Void> validateOpenApiSchema(ApiValidateOpenApiSchemaVO schemaVO) {
        return ApiResponse.success(null);
    }
}
