package com.ds.spring.boot.config.exception;

import com.ds.spring.boot.result.Result;
import com.ds.spring.boot.result.ResultCode;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author ds
 * @Date 2020/8/31 20:31
 * @Version 1.0
 * @Description 全局异常处理
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    /**
     * 权限不足报错拦截
     */
    @ExceptionHandler(UnauthorizedException.class)
    public Result unauthorizedExceptionHandler() {
        return Result.fail(ResultCode.PERMISSION_NO_ACCESS.getCode(),ResultCode.PERMISSION_NO_ACCESS.getMsg());
    }

    /**
     * 未登录报错拦截
     * 在请求需要权限的接口,而连登录都还没登录的时候,会报此错
     */
    @ExceptionHandler(UnauthenticatedException.class)
    public Result unauthenticatedExceptionHandler() {
        return Result.fail(ResultCode.UNAUTHORIZED.getCode(),ResultCode.UNAUTHORIZED.getMsg());
    }

    /**
     * RedisService参数报错拦截
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public Result IllegalArgumentExceptionHandler(IllegalArgumentException e) {
        return Result.fail(ResultCode.PARAM_IS_INVALID.getCode(),e.getMessage());
    }
}
