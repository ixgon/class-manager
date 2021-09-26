package com.xgon.classmanager.exception;

import com.xgon.classmanager.api.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * <p>FileName:&ensp;com.xgon.classmanager.exception.<strong>GlobalExceptionHandler.java</strong></p>
 * <p>Date:&ensp;2021-09-26 14:09</p>
 * <p>Description:&ensp;全局异常捕捉处理类</p>
 * <p>注意这里的异常从上到下是有序的，位于上面的会先尝试捕捉异常。</p>
 *
 * @author <a href="mail to: laoshi1998@outlook.com" rel="nofollow">xgon</a>
 * @version 1.0.0
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * <p>MethodName:&ensp;<strong>exceptionHandler</strong></p>
     * <p>Description:&ensp;处理自定义异常</p>
     *
     * @param e 自定义异常
     * @return com.xgon.classmanager.api.ApiResponse 异常处理响应消息
     */
    @ExceptionHandler(value = CustomException.class)
    public ApiResponse exceptionHandler(CustomException e) {
        log.error("发生业务异常！原因是：{}", e.getMessage());
        return ApiResponse.UNKNOWN;
    }

    /**
     * <p>MethodName:&ensp;<strong>exceptionHandler</strong></p>
     * <p>Description:&ensp;处理空指针异常</p>
     *
     * @param e 空指针异常
     * @return com.xgon.classmanager.api.ApiResponse 异常处理响应消息
     */
    @ExceptionHandler(value = NullPointerException.class)
    public ApiResponse exceptionHandler(NullPointerException e) {
        log.error("发生业务异常！原因是：{}", e.getMessage());
        return ApiResponse.NULL_POINTER_EXCEPTION;
    }

    /**
     * <p>MethodName:&ensp;<strong>exceptionHandler</strong></p>
     * <p>Description:&ensp;处理其它异常</p>
     *
     * @param req 本次请求对象
     * @param e   异常对象
     * @return com.xgon.classmanager.api.ApiResponse 异常处理响应消息
     */
    @ExceptionHandler(value = Exception.class)
    public ApiResponse exceptionHandler(HttpServletRequest req, Exception e) {
        System.out.println(req);
        System.out.println(Arrays.toString(e.getStackTrace()));
        log.error("未知异常！原因是：{}", e.getMessage());
        return ApiResponse.INTERNAL_SERVER_ERROR;
    }
}
