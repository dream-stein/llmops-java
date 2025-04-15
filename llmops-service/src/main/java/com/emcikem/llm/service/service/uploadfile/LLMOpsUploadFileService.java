package com.emcikem.llm.service.service.uploadfile;

import com.emcikem.llm.common.vo.file.UploadFileVO;
import com.emcikem.llm.common.vo.file.UploadImageVO;
import com.emcikem.llm.service.constant.LLMOpsConstant;
import com.emcikem.llm.service.util.FileUtil;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.net.URL;
import java.util.UUID;

/**
 * Create with Emcikem on 2025/3/28
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Service
public class LLMOpsUploadFileService {

    @Resource
    private COSClient cosClient;

    public UploadImageVO uploadImage(MultipartFile multipartFile) {
        // 指定要上传的文件
        File localFile = FileUtil.convertMultipartFileToFile(multipartFile);
        // 指定文件将要存放的存储桶
        String bucketName = LLMOpsConstant.BUCKET_NAME;
        // 指定文件上传到 COS 上的路径，即对象键。例如对象键为 folder/picture.jpg，则表示将文件 picture.jpg 上传到 folder 路径下
        String key = "image/" + multipartFile.getOriginalFilename();
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);

        URL objectUrl = cosClient.getObjectUrl(bucketName, key);
        UploadImageVO uploadImageVO = new UploadImageVO();
        uploadImageVO.setImage_url(objectUrl.toString());
        return uploadImageVO;
    }

    public UploadFileVO uploadFile(MultipartFile multipartFile) {
        // 指定要上传的文件
        File localFile = FileUtil.convertMultipartFileToFile(multipartFile);
        // 指定文件将要存放的存储桶
        String bucketName = LLMOpsConstant.BUCKET_NAME;
        // 指定文件上传到 COS 上的路径，即对象键。例如对象键为 folder/picture.jpg，则表示将文件 picture.jpg 上传到 folder 路径下
        String key = "image/" + multipartFile.getOriginalFilename();
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);

        URL objectUrl = cosClient.getObjectUrl(bucketName, key);
        UploadImageVO uploadImageVO = new UploadImageVO();
        uploadImageVO.setImage_url(objectUrl.toString());

        UploadFileVO uploadFileVO = new UploadFileVO();
        uploadFileVO.setSize(multipartFile.getSize());
        uploadFileVO.setAccount_id(getAccountId());
        uploadFileVO.setId(UUID.randomUUID().toString());
        uploadFileVO.setCreated_at(System.currentTimeMillis());
        return uploadFileVO;
    }

    private String getAccountId() {
        return "1";
    }
}
