package com.github.dttimes.simplejeex.lang.base;

import java.util.Objects;

/**
 * <p><b>Slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-02 15:30<p>
 *
 * @author 王輝
 */
public class Casts {
    public final static char toChar(Integer val) {
        return Objects.isNull(val) ? null : Character.toChars(val)[0];
    }
}
