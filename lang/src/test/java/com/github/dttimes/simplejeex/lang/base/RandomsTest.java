package com.github.dttimes.simplejeex.lang.base;

import org.junit.Test;

/**
 * <p><b>Slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-02 15:40<p>
 *
 * @author 王輝
 */
public class RandomsTest {

    @Test
    public void test_randomString001() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Randoms.randomString(5));
        }
    }
}