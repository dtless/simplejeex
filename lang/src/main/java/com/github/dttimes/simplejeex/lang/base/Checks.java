package com.github.dttimes.simplejeex.lang.base;

import java.util.Objects;

/**
 * <p><b>Slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-02 15:07<p>
 *
 * @author 王輝
 */
public class Checks {
    public static final void nonNull(Object object) {
        nonNull(object, "参数不能为null对象");
    }

    public static final void nonNull(Object object, String message) {
        isTrue(Objects.nonNull(object), message);
    }

    public static final void isTrue(Boolean val) {
        isTrue(val, "表达式计算结果必须为真");
    }

    public static final void isTrue(Boolean val, String message) {
        if (Objects.isNull(val)) {
            throw new IllegalArgumentException("表达式计算结果不能为空");
        } else if (!val) {
            throw new IllegalArgumentException(message(message));
        }
    }

    public static final void positive(Integer val) {
        positive(val, "不能为空并且必须为正整数");
    }

    public static final void positive(Integer val, String message) {
        isTrue(Validates.positive(val), message);
    }


    public void hasLen(String text) {

    }

    public void hasLen(String text, String message) {

    }

    public void lenLess(String text, int length) {

    }

    public void lenLess(String text, int length, String message) {

    }

    public void lenLessEquals(String text, int length) {

    }

    public void lenLessEquals(String text, int length, String message) {

    }

    /**
     * 预判消息
     *
     * @param message 预判消息封装
     * @return
     */
    protected static final String message(String message) {
        return String.format("【Assert Fail】- %s", message);
    }
}
