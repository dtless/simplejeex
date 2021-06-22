package com.github.dttimes.simplejeex.lang.base;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <p><b>slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-02 11:13<p>
 *
 * @author 王辉
 */
public class StringsTest {

    @Test
    public void test_isCharSequence001() {
        assertThat(Strings.isCharSequence("abc")).isTrue();
        assertThat(Strings.isCharSequence(new StringBuffer("def"))).isTrue();
        assertThat(Strings.isCharSequence(new StringBuilder("def"))).isTrue();
        assertThat(Strings.isCharSequence(null)).as("空对象").isFalse();
        assertThat(Strings.isCharSequence(LocalDateTime.now())).as("非字符串").isFalse();
    }

    @Test
    public void test_format001() {
        assertThat(Strings.format("a{}b{}", "xxx", "yyy")).isEqualTo("axxxbyyy");
        assertThat(Strings.format("a{}b", "xxx")).isEqualTo("axxxb");
    }
}