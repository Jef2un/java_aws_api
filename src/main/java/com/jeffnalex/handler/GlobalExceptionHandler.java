package com.jeffnalex.handler;


import com.jeffnalex.exception.BaseException;
import com.jeffnalex.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // 全局異常處理器
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 全局異常處理器
     * @param exception
     * @return
     */
    public Result exceoptionHandler(BaseException exception){
        log.error("異常訊息: {}", exception.getMessage());
        return Result.error(exception.getMessage());
    }

}
