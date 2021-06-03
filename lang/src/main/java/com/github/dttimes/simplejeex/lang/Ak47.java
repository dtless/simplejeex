package com.github.dttimes.simplejeex.lang;

import com.google.common.base.Strings;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * 快捷类,对工具包中常用工具做集合
 *
 * @author 王辉
 * @see <a href="https://www.dreamlu.net/mica2x/core-$.html">如梦科技</a>
 *
 * <p><b>slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-05-31 22:07<p>
 */
public class Ak47 {

    public static final boolean isNotNullOrEmpty(String text) {
        return !isNullOrEmpty(text);
    }

    public static final boolean isNullOrEmpty(String text) {
        return Strings.isNullOrEmpty(text);
    }

    public static final boolean isEmpty(Collection<?> collection) {
        return Objects.isNull(collection) || collection.isEmpty();
    }

    public static final boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    public static final <T> List<T> newLinkedList() {
        return new LinkedList<>();
    }

    public static final <T> List<T> defaultList(List<T> list) {
        return Objects.isNull(list) ? newLinkedList() : list;
    }

    public static final <T> Collection<T> defaults(List<T> list, List<T> defaultList) {
        return null;
    }

}
