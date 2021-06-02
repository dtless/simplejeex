package com.github.dttimes.simplejeex.lang.base;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


/**
 * <p><b>Slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-02 15:21<p>
 *
 * @author 王輝
 */
public class ValidatesTest {

    @Test
    public void test_positive001() {
        assertThat(Validates.positive(null)).as("null").isFalse();
        assertThat(Validates.positive(1)).as("整数").isTrue();
        assertThat(Validates.positive(999)).as("整数").isTrue();
        assertThat(Validates.positive(-2)).as("负数").isFalse();
        assertThat(Validates.positive(0)).as("零").isFalse();
    }
}