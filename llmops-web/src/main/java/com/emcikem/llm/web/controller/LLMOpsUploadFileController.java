package com.emcikem.llm.web.controller;

import com.emcikem.llm.common.entity.ApiResponse;
import com.emcikem.llm.common.vo.file.UploadFileVO;
import com.emcikem.llm.common.vo.file.UploadImageVO;
import com.emcikem.llm.service.service.uploadfile.LLMOpsUploadFileService;
import com.emcikem.llm.service.util.FileUtil;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

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
        // 指定要上传的文件
        File localFile = FileUtil.convertMultipartFileToFile(file);
        // 指定文件将要存放的存储桶
        String bucketName = "test-1259211792";
        // 指定文件上传到 COS 上的路径，即对象键。例如对象键为 folder/picture.jpg，则表示将文件 picture.jpg 上传到 folder 路径下
        String key = file.getOriginalFilename();
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);

        return ApiResponse.success(null);
    }
}
