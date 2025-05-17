package com.emcikem.llm.service.service.uploadfile;

import com.emcikem.llm.common.vo.file.UploadFileVO;
import com.emcikem.llm.common.vo.file.UploadImageVO;
import com.emcikem.llm.dao.entity.LlmOpsUploadFileDO;
import com.emcikem.llm.service.constant.LLMOpsConstant;
import com.emcikem.llm.service.provider.LlmOpsUploadFileProvider;
import com.emcikem.llm.service.util.FileUtil;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @Resource
    private LlmOpsUploadFileProvider llmOpsUploadFileProvider;

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

    public UploadFileVO uploadFile(MultipartFile multipartFile) throws FileNotFoundException {
        // 1. 模型转换
        File localFile = FileUtil.convertMultipartFileToFile(multipartFile);
        if (localFile == null) {
            return null;
        }
        String fileName = localFile.getName();
        String extension = "";
        if (fileName.lastIndexOf(".") != -1) {
            extension = fileName.substring(fileName.lastIndexOf(".") + 1);
        }

        // 3. 生成一个随机的名字
        String randomFileName = UUID.randomUUID() + "." + fileName;
        Date now = new Date();
        String uploadFileName = String.format("%s/%s", new SimpleDateFormat("yyyy/MM/dd").format(now), randomFileName);

        // 4. 上传数据到cos存储桶中
        String bucketName = LLMOpsConstant.BUCKET_NAME;
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, uploadFileName, localFile);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);

        // 5. 创建上传记录
        LlmOpsUploadFileDO uploadFileDO = new LlmOpsUploadFileDO();
        uploadFileDO.setExtension(extension);
        uploadFileDO.setAccountId(getAccountId());
        uploadFileDO.setId(UUID.randomUUID().toString());
        uploadFileDO.setCreatedAt(new Date());
        uploadFileDO.setUpdatedAt(new Date());
        uploadFileDO.setSize((int) localFile.length());
        uploadFileDO.setMimeType(URLConnection.guessContentTypeFromName(fileName));
        uploadFileDO.setKey(uploadFileName);
        uploadFileDO.setName(fileName);
        uploadFileDO.setHash(FileUtil.md5HashCode(new FileInputStream(localFile)));

        boolean result = llmOpsUploadFileProvider.insertUploadFile(uploadFileDO);

        UploadFileVO uploadFileVO = new UploadFileVO();
        uploadFileVO.setAccount_id(getAccountId());
        uploadFileVO.setId(uploadFileDO.getId());
        uploadFileVO.setCreated_at(System.currentTimeMillis());
        uploadFileVO.setExtension(extension);
        uploadFileVO.setKey(uploadFileName);
        uploadFileVO.setName(fileName);
        uploadFileVO.setSize(uploadFileDO.getSize());
        uploadFileVO.setMine_type(uploadFileDO.getMimeType());
        return uploadFileVO;
    }

    private String getAccountId() {
        return "1";
    }
}
