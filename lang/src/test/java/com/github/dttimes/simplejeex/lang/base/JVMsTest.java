package com.github.dttimes.simplejeex.lang.base;

import org.junit.Test;

/**
 * <p><b>Slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-09 16:03<p>
 *
 * @author 王輝
 */
public class JVMsTest {

    @Test
    public void test_osName001() {
        System.out.println(JVMs.osName());
    }

    @Test
    public void test_osVersion001() {
        System.out.println(JVMs.osVersion());
    }

    @Test
    public void test_javaVersion() {
        System.out.println(JVMs.javaVersion());
    }

    @Test
    public void test_javaHome() {
        System.out.println(JVMs.javaHome());
    }

    @Test
    public void test_userHome() {
        System.out.println(JVMs.userHome());
    }

    @Test
    public void test_userDir() {
        System.out.println(JVMs.userDir());
    }
}