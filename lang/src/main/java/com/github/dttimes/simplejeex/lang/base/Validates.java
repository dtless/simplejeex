package com.github.dttimes.simplejeex.lang.base;

import java.util.Objects;

/**
 * <p><b>Slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-02 15:20<p>
 *
 * @author 王輝
 */
public class Validates {
    /**
     * 判断是否为正正整数
     *
     * @param val 待判断的数字
     * @return 为null或非整正整数返回false，其他返回true
     */
    public static final boolean positive(Integer val) {
        return Objects.nonNull(val) && val.compareTo(Integer.valueOf(0)) > 0;
    }
}
