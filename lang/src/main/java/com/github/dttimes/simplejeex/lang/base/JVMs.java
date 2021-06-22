package com.github.dttimes.simplejeex.lang.base;

import java.lang.management.ManagementFactory;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Properties;

/**
 * <p><b>Slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-09 15:57<p>
 *
 * @author 王輝
 */
public class JVMs {
    private final static Properties PROPERTIES = System.getProperties();

    /**
     * 系统启动时间点
     *
     * @return
     */
    public static LocalDateTime startupTime() {
        long startup = ManagementFactory.getRuntimeMXBean().getStartTime();
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(startup), ZoneId.systemDefault());
    }

    /**
     * 操作系统名称
     *
     * @return
     */
    public static String osName() {
        return PROPERTIES.getProperty("os.name");
    }

    /**
     * 操作系统版本
     *
     * @return
     */
    public static String osVersion() {
        return PROPERTIES.getProperty("os.version");
    }

    /**
     * 获取Java版本
     *
     * @return
     */
    public static final String javaVersion() {
        return PROPERTIES.getProperty("java.version");
    }

    /**
     * 获取Java Home的路径
     *
     * @return
     */
    public static final String javaHome() {
        return PROPERTIES.getProperty("java.home");
    }

    /**
     * 获取当前用户的home路径
     *
     * @return
     */
    public static final String userHome() {
        return PROPERTIES.getProperty("user.home");
    }

    /**
     * 工程目录所在的路径
     *
     * @return
     */
    public static final String userDir() {
        return PROPERTIES.getProperty("user.dir");
    }
}
