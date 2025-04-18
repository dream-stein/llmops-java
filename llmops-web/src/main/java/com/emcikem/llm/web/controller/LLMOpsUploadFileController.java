package com.emcikem.llm.web.controller;

import com.emcikem.llm.common.entity.ApiResponse;
import com.emcikem.llm.common.enums.ResponseStatusEnum;
import com.emcikem.llm.common.vo.file.UploadFileVO;
import com.emcikem.llm.common.vo.file.UploadImageVO;
import com.emcikem.llm.service.service.uploadfile.LLMOpsUploadFileService;
import com.qcloud.cos.COSClient;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
 * Create with Emcikem on 2025/3/14
 *
 * @author Emcikem
 * @version 1.0.0
 * @Description 文件接口
 */
@RestController
@RequestMapping("/upload-files")
public class LLMOpsUploadFileController {

    @Resource
    private COSClient cosClient;

    @Resource
    private LLMOpsUploadFileService llmOpsUploadFileService;

    @PostMapping("/image")
    public ApiResponse<UploadImageVO> uploadImage(MultipartFile file){
        return ApiResponse.success(llmOpsUploadFileService.uploadImage(file));
    }

    @PostMapping("/file")
    public ApiResponse<UploadFileVO> uploadFile(MultipartFile file) {
        // 文档大小校验
        // 文档格式校验
        try {
            return ApiResponse.success(llmOpsUploadFileService.uploadFile(file));
        } catch (Exception ex) {
            return ApiResponse.error(ResponseStatusEnum.SYSTEM_ERROR);
        }
    }
}
