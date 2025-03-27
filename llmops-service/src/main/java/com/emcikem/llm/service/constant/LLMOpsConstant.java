package com.emcikem.llm.service.constant;

import java.nio.file.Path;
import java.nio.file.Paths;

public interface LLMOpsConstant {
    String USER_DIR = System.getProperty("user.dir");

    Path FILE_PATH = Paths.get(USER_DIR, "data");

    Path DB_PATH = Paths.get(FILE_PATH.toString(), "test.db");

    String SEARCH_FAILED = "搜索失败";
}
