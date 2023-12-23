package com.expt.Expt_SoftwareEngineer.exception;

import com.expt.Expt_SoftwareEngineer.pojo.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @SuppressWarnings("CallToPrintStackTrace")
    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception exception) {
        exception.printStackTrace();
        return Result.error(StringUtils.hasLength(exception.getMessage()) ? exception.getMessage() : "操作失败！");
    }
}
