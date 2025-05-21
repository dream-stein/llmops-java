package com.emcikem.llm.service.constant;

import com.google.common.collect.Sets;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;

public class LLMOpsConstant {

    public static String USER_DIR = System.getProperty("user.dir");

    public static Path FILE_PATH = Paths.get(USER_DIR, "data");

    public static Path DB_PATH = Paths.get(FILE_PATH.toString(), "test.db");

    public static String SEARCH_FAILED = "搜索失败";

    public static String BUCKET_NAME = "test-1259211792";




    public static HashSet<String> ALLOWED_IMAGE_EXTENSION = Sets.newHashSet("jpg", "jpeg", "png", "webp", "gif", "svg");

    public static HashSet<String> ALLOWED_DOCUMENT_EXTENSION = Sets.newHashSet("txt", "markdown", "md", "pdf", "html", "htm", "xlsx", "xls", "doc", "docx", "csv");

    public static String DEFAULT_DATASET_DESCRIPTION_FORMATTER = "当你需要回答关于《%s》的时候可以引用该知识库。";
}
