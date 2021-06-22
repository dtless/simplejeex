package com.github.dttimes.simplejeex.coc.web;

import com.github.dttimes.simplejeex.coc.core.constants.Ex;

/**
 * 前端响应报文结构体
 *
 * <p><b>slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-05-31 22:28<p>
 *
 * @author 王辉
 */
public class R<T> {
    protected static final String SUCCESS_MESSAGE = "执行成功.";
    protected static final String FAIL_MESSAGE = "执行失败!!!";
    private T data;
    private String code;
    private String message;
    private String space;

    public R() {
        this(Ex.SUCCESS, SUCCESS_MESSAGE);
    }

    public R(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public R<T> code(String code) {
        this.code = code;
        return this;
    }

    public R<T> message(String message) {
        this.message = message;
        return this;
    }

    public R<T> data(T data) {
        this.data = data;
        return this;
    }

    public R<T> space(String space) {
        this.space = space;
        return this;
    }

    public static <T> R<T> ok() {
        return new R();
    }

    public static <T> R<T> ok(T data) {
        return new R().data(data);
    }

    public static <T> R<T> fail() {
        return new R(Ex.BUSINESS_EXCEPTION, FAIL_MESSAGE);
    }

    public static <T> R<T> fail(String message) {
        return new R(Ex.BUSINESS_EXCEPTION, message);
    }

    public static <T> R<T> fail(String code, String message) {
        return new R(code, message);
    }

    public T getData() {
        return data;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Boolean isSuccess() {
        return Ex.SUCCESS.equals(this.code);
    }
}