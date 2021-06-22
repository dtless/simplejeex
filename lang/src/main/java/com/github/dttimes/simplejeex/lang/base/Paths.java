package com.github.dttimes.simplejeex.lang.base;

import java.io.File;
import java.util.*;

/**
 * <p><b>Slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-09 15:24<p>
 *
 * @author 王輝
 */
public class Paths {
    /**
     * 文件路径分隔符
     */
    public static final String SEPARATOR_PATH = File.separator;
    public static final Set PATHS = new HashSet();

    static {
        PATHS.add('\\');
        PATHS.add('/');
    }

    public static final String path(String rootPath, String... fragments) {
        String path = rootPath;
        if (Objects.nonNull(fragments)) {
            for (String fragment : fragments) {
                path = String.join(SEPARATOR_PATH, trim(path, false, true), trim(fragment, true, false));
            }
        }
        return path;
    }

    /**
     * 对目录去左右目录分隔符
     *
     * @param path 路径
     * @return 去掉左右目录分隔符的路径
     */
    public static final String trim(String path) {
        return trim(path, true, true);
    }

    /**
     * 对路径去目录分隔符
     *
     * @param path  路径
     * @param left  去左侧目录分隔符
     * @param right 去右侧目录分隔符
     * @return 去分隔符后的目录
     */
    public static final String trim(String path, boolean left, boolean right) {
        Objects.requireNonNull(path);
        if (left) {
            int index = 0;
            for (; index < path.length() && PATHS.contains(path.charAt(index)); index++) {
            }
            if (index > 0) {
                path = path.substring(index);
            }
        }

        if (right) {
            int index = path.length() - 1;
            for (; index >= 0 && PATHS.contains(path.charAt(index)); index--) {
            }

            if (index >= 0) {
                path = path.substring(0, index + 1);
            }
        }
        return path;
    }
}
