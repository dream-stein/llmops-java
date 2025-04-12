package com.emcikem.llm.service.constant;

import java.nio.file.Path;
import java.nio.file.Paths;

public class LLMOpsConstant {

    public static String USER_DIR = System.getProperty("user.dir");

    public static Path FILE_PATH = Paths.get(USER_DIR, "data");

    public static Path DB_PATH = Paths.get(FILE_PATH.toString(), "test.db");

    public static String SEARCH_FAILED = "搜索失败";

    public static String BUCKET_NAME = "test-1259211792";


}
