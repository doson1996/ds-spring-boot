package com.ds.spring.boot.config.exception;

/**
 * @Author ds
 * @Date 2020/9/14 20:06
 * @Version 1.0
 * @Description 业务异常
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1622308445131305928L;

    private Integer code;

    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Integer code,String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
