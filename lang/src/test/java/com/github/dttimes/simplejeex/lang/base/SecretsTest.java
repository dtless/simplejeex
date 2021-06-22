package com.github.dttimes.simplejeex.lang.base;

import org.junit.Test;

/**
 * <p><b>Slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-22 17:39<p>
 *
 * @author 王輝
 */
public class SecretsTest {

    @Test
    public void test_md5Hex_001() {
        System.out.println(Secrets.md5Hex("abc123"));
    }
}