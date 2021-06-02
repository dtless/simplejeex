package com.github.dttimes.simplejeex.lang.base;

import java.time.LocalDateTime;

/**
 * 时间辅助工具类
 *
 * <p><b>slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-02 10:57<p>
 *
 * @author 王辉
 */
public class Times {
    /**
     * 最常用的时间日期格式化
     */
    public static final String FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_DATE = "yyyy-MM-dd";
    public static final String FORMAT_TIME = "HH:mm:ss";

    public static final LocalDateTime now() {
        return LocalDateTime.now();
    }
}
