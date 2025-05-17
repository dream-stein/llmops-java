package com.emcikem.llm.common.exception;

import com.emcikem.llm.common.enums.LlmOpsResultEnum;

/**
 * Create with Emcikem on 2025/5/17
 *
 * @author Emcikem
 * @version 1.0.0
 */
public class LlmOpsException extends RuntimeException {

    protected Integer resultCode;

    protected String message;

    public Integer getResultCode() {
        if (resultCode == null) {
            return LlmOpsResultEnum.SYSTEM_ERROR.getCode();
        }
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LlmOpsException(Integer resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }

    public LlmOpsException(LlmOpsResultEnum resultEnum) {
        this.resultCode = resultEnum.getCode();
        this.message = resultEnum.getMessage();
    }
}
