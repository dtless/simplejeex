package com.github.dttimes.simplejeex.lang.base;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * <p><b>Slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-09 15:37<p>
 *
 * @author 王輝
 */
public class PathsTest {

    @Test
    public void test_trim001() {
        assertThat(Paths.trim("/home/wanghui")).isEqualTo("home/wanghui");
        assertThat(Paths.trim("/home/wanghui///////////")).isEqualTo("home/wanghui");
    }

    @Test
    public void test_trim002() {
        assertThat(Paths.trim("/")).isEqualTo("");
        assertThat(Paths.trim("\\")).isEqualTo("");
        assertThat(Paths.trim("/\\\\///////////")).isEqualTo("");
    }

    @Test
    public void test_trim003() {
        assertThat(Paths.trim("/home/admin/", true, false)).as("left").isEqualTo("home/admin/");
        assertThat(Paths.trim("/home/admin/", false, true)).as("right").isEqualTo("/home/admin");
        assertThat(Paths.trim("/home/admin/", false, false)).as("none").isEqualTo("/home/admin/");
        assertThat(Paths.trim("/home/admin///////\\", false, true)).as("right multi").isEqualTo("/home/admin");
        assertThat(Paths.trim("\\///\\/home/admin///////\\", true, false)).as("right multi").isEqualTo("home/admin///////\\");
    }
}