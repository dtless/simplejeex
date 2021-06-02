package com.github.dttimes.simplejeex.lang.base;

import java.util.Objects;

/**
 * 字符串辅助类
 *
 * <p><b>slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-02 11:05<p>
 *
 * @author 王辉
 */
public class Strings {

    /**
     * 是否是字符串类型
     *
     * @return
     */
    public static final boolean isCharSequence(Object object) {
        return Objects.nonNull(object) && CharSequence.class.isAssignableFrom(object.getClass());
    }
}
