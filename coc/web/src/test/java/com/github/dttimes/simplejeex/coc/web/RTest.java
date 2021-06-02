package com.github.dttimes.simplejeex.coc.web;

import com.github.dttimes.simplejeex.lang.base.JSONs;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * <p><b>slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-02 11:27<p>
 *
 * @author 王辉
 */
public class RTest {

    @Test
    public void test_ok001() {
        assertThat(R.ok().isSuccess()).as("success判断").isTrue();
        assertThat(R.ok().getData()).isNull();
        assertThat(R.ok().getMessage()).isEqualTo(R.SUCCESS_MESSAGE);
    }

    @Test
    public void test_ok002() {
        assertThat(R.ok("def").getData()).isEqualTo("def");
        assertThat(R.ok().message("hello").getMessage()).isEqualTo("hello");
    }

    @Test
    public void test_ok003() {
        System.out.println(JSONs.stringBeautify(R.ok()));
    }
}