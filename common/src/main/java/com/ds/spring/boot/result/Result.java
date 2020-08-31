package com.ds.spring.boot.result;

import lombok.Data;

/**
 * @Author ds
 * @Date 2020/7/21 17:51
 * @Version 1.0
 * @Description
 */
@Data

public class Result<T> {
    /**
     * 响应业务状态
     */
    private Integer code;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应中的数据
     */
    private T data;

    public Result(T data) {
        this.code = ResultCode.SUCCESS.getCode();
        this.message = ResultCode.SUCCESS.getMsg();
        this.data = data;
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Result<T> ok(T data) {
        return new Result(data);
    }

    public static <T> Result<T> ok(String message,T data) {
        return new Result(ResultCode.SUCCESS.getCode(),message,data);
    }

    public static Result ok() {
        return new Result("");
    }

    public static Result fail() {
        return new Result(ResultCode.ERROR.getCode(), ResultCode.ERROR.getMsg());
    }

    public static Result fail(String msg) {
        return new Result(ResultCode.ERROR.getCode(), msg);
    }

    public static Result fail(Integer code, String msg) {
        return new Result(code, msg);
    }

    public static <T> Result<T> fail(T data) {
        return new Result(ResultCode.ERROR.getCode(), ResultCode.ERROR.getMsg(), data);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
