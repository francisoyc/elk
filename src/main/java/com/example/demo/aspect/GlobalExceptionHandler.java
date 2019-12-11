package com.example.demo.aspect;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 全局异常拦截类
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 拦截的异常类型和返回内容自己可根据实际情况定义
     * @param request
     * @param exception
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    public Map<String, Object> allExceptionHandler(HttpServletRequest request, Exception exception) throws Exception{
        Map<String, Object> map = new HashMap<>();
        map.put("success", false);
        map.put("errorMsg", exception.getMessage());
        return map;
    }
}
