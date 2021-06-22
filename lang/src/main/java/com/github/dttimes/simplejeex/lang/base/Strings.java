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
    private static final String DELIM = "{}";

    /**
     * 是否是字符串类型
     *
     * @return
     */
    public static final boolean isCharSequence(Object object) {
        return Objects.nonNull(object) && CharSequence.class.isAssignableFrom(object.getClass());
    }

    /**
     * 字符串格式化(模仿slf4j)
     *
     * @param format  待格式化的字符串
     * @param objects 替换的字符串
     * @return
     */
    public final static String format(String format, Object... objects) {
        Objects.requireNonNull(format);

        StringBuilder sbf = new StringBuilder(format.length() + 60);
        if (Objects.nonNull(objects)) {
            int index = 0, k = 0;
            for (Object object : objects) {
                k = format.indexOf(DELIM, index);
                if (k != -1) {
                    sbf.append(format, index, k).append(object);
                    index = k + 2;
                }
            }
            if (format.length() > index) {
                sbf.append(format.substring(index));
            }
        }
        return sbf.toString();
    }
}
